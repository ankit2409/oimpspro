package com.example.demo.services;

import com.example.demo.model.Part;
import com.example.demo.model.RawMaterial;

import java.util.Collection;
import java.util.List;

public interface PartService {
    Part addpart(Part part);

    Collection<Part> getParts();

    List<RawMaterial> getAllRawMaterials();
}
