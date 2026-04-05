package com.hirai.serviceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hirai.enity.Farmer;
import com.hirai.repo.FarmerRepository;

import java.util.List;

@Service
public class FarmerService {

    @Autowired
    private FarmerRepository farmerRepository;

    public Farmer registerFarmer(Farmer farmer) {
        return farmerRepository.save(farmer);
    }

    public List<Farmer> getAllFarmers() {
        return farmerRepository.findAll();
    }

    public Farmer getFarmerById(Long id) {
        return farmerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Farmer not found with id: " + id));
    }
}
