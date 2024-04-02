package com.project.kafka.cil.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.project.kafka.cil.entity.Entity;

import java.util.List;
import java.util.UUID;

public interface CILRepository extends CassandraRepository<Entity, UUID> {
	List<Entity> findByMobile(String mobileNumber);
}
