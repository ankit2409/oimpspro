package com.example.demo.repository;

import com.example.demo.model.ProductionPartCount;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductionPartCountRepository extends JpaRepository<ProductionPartCount, String> {
}
