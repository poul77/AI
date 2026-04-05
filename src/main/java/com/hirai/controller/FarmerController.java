package com.hirai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hirai.enity.Farmer;
import com.hirai.serviceimpl.FarmerService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FarmerController {

    @Autowired
    private FarmerService farmerService;

    // POST http://localhost:8080/api/farmers
    @PostMapping("/farmer")
    public Farmer createFarmer(@RequestBody Farmer  farmer) {
        return farmerService.registerFarmer(farmer);
    }

    // GET http://localhost:8080/api/farmers
    @GetMapping("/getfarmer")
    public List<Farmer> listAllFarmers() {
        return farmerService.getAllFarmers();
    }

    // GET http://localhost:8080/api/farmers/1
    @GetMapping("/{id}")
    public Farmer getFarmer(@PathVariable Long id) {
        return farmerService.getFarmerById(id);
    }
}
