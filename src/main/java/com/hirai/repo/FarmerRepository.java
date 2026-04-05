package com.hirai.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hirai.enity.Farmer;

public interface FarmerRepository extends JpaRepository<Farmer,Long> {

}
