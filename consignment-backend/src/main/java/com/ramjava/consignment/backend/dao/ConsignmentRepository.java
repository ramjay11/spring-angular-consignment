package com.ramjava.consignment.backend.dao;

import com.ramjava.consignment.backend.entity.Consignment;
import org.springframework.data.repository.CrudRepository;

public interface ConsignmentRepository extends CrudRepository<Consignment, Integer> {
}
