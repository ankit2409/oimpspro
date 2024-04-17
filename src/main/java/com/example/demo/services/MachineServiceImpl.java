package com.example.demo.services;

import com.example.demo.model.Machine;
import com.example.demo.repository.MachineRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;


import java.util.Collection;
import java.util.List;

@Service
public class MachineServiceImpl implements MachineService{

    private final MachineRepository machineRepository;

    public MachineServiceImpl(MachineRepository machineRepository) {
        this.machineRepository = machineRepository;
    }

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public List<String> getAllRawMaterials() {
        List<String> rawMaterials = jdbcTemplate.query("select name from raw_materials", (rs, rowNum) -> rs.getString("name"));
        return rawMaterials;
    }

    @Override
    public Machine addMachine(Machine machine) {
        machineRepository.save(machine);
        return machine;
    }

    @Override
    public Collection<Machine> getMachines() {
        return machineRepository.findAll();
    }


}
