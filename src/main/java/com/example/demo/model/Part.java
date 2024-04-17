package com.example.demo.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Entity
@Data
@Table(name = "part")
public class Part{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "raw_material_id")
    private RawMaterial rawMaterial;
    private double quantity;
    private double weight;
    private String drawingUrl;
    @OneToMany(mappedBy = "part", cascade = CascadeType.ALL)
    private Set<Machine> machines;
}
