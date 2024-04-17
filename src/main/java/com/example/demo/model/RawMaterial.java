package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "raw_material")
public class RawMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String grade;
    private String material;
    @OneToMany(mappedBy = "rawMaterial", cascade = CascadeType.ALL)
    private Set<Part> parts;
    @OneToMany(mappedBy = "rawMaterial", cascade = CascadeType.ALL)
    private Set<Machine> machine;
    private double size;
    private double quantity;
}
