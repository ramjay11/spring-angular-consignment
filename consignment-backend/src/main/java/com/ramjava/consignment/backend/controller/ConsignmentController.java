package com.ramjava.consignment.backend.controller;

import com.ramjava.consignment.backend.dao.ConsignmentRepository;
import com.ramjava.consignment.backend.entity.Consignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ConsignmentController {

    @Autowired
    private ConsignmentRepository repository;
    @GetMapping("/consignment")
    public List<Consignment> getAllConsignment() {
        return (List<Consignment>) repository.findAll();
    }

    @GetMapping("/consignment/{id}")
    public Consignment getConsignmentById(@PathVariable int id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consignment not found " + id));
    }

    @PostMapping("/save_consignment")
    public Consignment saveConsignment(@RequestBody Consignment consignment) {
        return repository.save(consignment);
    }

    @PutMapping("/consignment/{id}")
    public Consignment updateConsignment(@PathVariable int id, @RequestBody Consignment consignment) {
        Consignment existing = repository.findById(id).orElseThrow(() -> new RuntimeException("Consignment not found " + id));
        consignment.setConsignmentStatus(consignment.getConsignmentStatus() != null ?
                consignment.getConsignmentStatus() : existing.getConsignmentStatus());
        consignment.setConsignmentCategory(consignment.getConsignmentCategory() != null ?
                consignment.getConsignmentCategory() : existing.getConsignmentCategory());
        consignment.setDeliveryPartner(consignment.getDeliveryPartner() != null ?
                consignment.getDeliveryPartner() : existing.getDeliveryPartner());
        repository.save(existing);
        return existing;
    }

    @DeleteMapping("/consignment/{id}")
    public String deleteConsignment(@PathVariable int id) {
        repository.deleteById(id);
        return "Consignment deleted" + id;
    }
}
