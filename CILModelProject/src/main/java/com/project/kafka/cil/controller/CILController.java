package com.project.kafka.cil.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.kafka.cil.entity.Entity;
import com.project.kafka.cil.kafka.KafkaProducer;
import com.project.kafka.cil.service.CilServices;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/entities")
@RequiredArgsConstructor
public class CILController {

    private final CilServices cilservice;
    private final KafkaProducer kafkaProducer;

    @GetMapping()
    public ResponseEntity<List<Entity>> getAllEntities() {

        return new ResponseEntity<>(cilservice.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entity> getEntityById(@PathVariable("id") String id) {

        return new ResponseEntity<>(cilservice.findById(UUID.fromString(id)), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Entity> createEntity(@RequestBody Entity entity) {

        kafkaProducer.sendMessage(entity);
        return new ResponseEntity<>(cilservice.saveEntity(entity), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Entity> updateEntityr(@PathVariable("id") String id, @RequestBody Entity entity) {

        if (cilservice.existById(UUID.fromString(id))) {
            return new ResponseEntity<>(cilservice.saveEntity(entity), HttpStatus.ACCEPTED);
        }

        throw new IllegalArgumentException("Entity with id " + id + "not found");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteEntity(@PathVariable("id") String id) {

    	cilservice.deleteEntity(UUID.fromString(id));

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}