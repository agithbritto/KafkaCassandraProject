package com.project.kafka.cil.service;

import com.project.kafka.cil.entity.Entity;
import com.project.kafka.cil.repository.CILRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@AllArgsConstructor
@Service
public class CilServices {

    private final CILRepository cilRepository;

    public List<Entity> findAll() {

        return cilRepository.findAll();
    }

    public Entity findById(UUID uuid) {
        return cilRepository.findById(uuid).orElseThrow(() -> new NoSuchElementException());
    }

    public Entity saveEntity(Entity entity) {
        return cilRepository.save(entity);
    }

    public void deleteEntity(UUID uuid) {

    	cilRepository.deleteById(uuid);
    }

    public Entity updateEntity(Entity entity) {
        return cilRepository.save(entity);
    }

    public boolean existById(UUID uuid) {
        return cilRepository.existsById(uuid);
    }
}