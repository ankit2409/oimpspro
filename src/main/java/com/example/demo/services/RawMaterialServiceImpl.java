package com.example.demo.services;

import com.example.demo.model.RawMaterial;
import com.example.demo.repository.RawMaterialRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Collection;

@Service
public class RawMaterialServiceImpl implements RawMaterialService{
    Logger LOGGER = LoggerFactory.getLogger(RawMaterialServiceImpl.class);

    @Autowired
    RawMaterialRepository rawMaterialRepository;


    @Override
    public Collection<RawMaterial> getRawMaterial() {
        LOGGER.info("Fetching raw materials from database {}",rawMaterialRepository.findAll());
        return rawMaterialRepository.findAll();
    }

    @Override
    public RawMaterial addRawMaterial(RawMaterial rawMaterial) {
        rawMaterialRepository.save(rawMaterial);
        return rawMaterial;
    }
}
