package com.project.kafka.cil.entity;

import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.Getter;
import lombok.Setter;

@Table
@Getter
@Setter
public class Entity {

    @PrimaryKey
    private UUID id;

    private String name;

    private String mobile;
    
    @Override
    public String toString() {
		return "\n id -> "+id+"\n name -> "+name+"\n mobile -> "+mobile;
    	
    }

}