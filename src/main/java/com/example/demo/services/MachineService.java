package com.example.demo.services;

import com.example.demo.model.Book;
import com.example.demo.model.Machine;

import java.util.Collection;
import java.util.List;

public interface MachineService {
    public List<String> getAllRawMaterials();

    Machine addMachine(Machine machine);

    Collection<Machine> getMachines();
}
