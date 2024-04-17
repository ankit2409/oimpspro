package com.example.demo.services;

import com.example.demo.model.Part;
import com.example.demo.model.RawMaterial;
import com.example.demo.repository.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class PartServiceImpl implements PartService{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    PartRepository partRepository;

    @Autowired
    RawMaterialService rawMaterialService;


    @Override
    public Part addpart(Part part) {
        partRepository.save(part);
        return part;
    }

    @Override
    public Collection<Part> getParts() {
        return partRepository.findAll();
    }

    @Override
    public List<RawMaterial> getAllRawMaterials() {
        List<RawMaterial> rawMaterials = (List<RawMaterial>) rawMaterialService.getRawMaterial();
        return rawMaterials;
    }
}
