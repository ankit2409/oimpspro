package com.example.demo.services;

import com.example.demo.model.RawMaterial;

import java.util.Collection;

public interface RawMaterialService {
    Collection<RawMaterial> getRawMaterial();

    RawMaterial addRawMaterial(RawMaterial rawMaterial);
}
