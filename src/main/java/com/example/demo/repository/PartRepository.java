package com.example.demo.repository;

import com.example.demo.model.Part;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface PartRepository extends JpaRepository<Part, String> {
}
