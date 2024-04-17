package com.example.demo.services;

import com.example.demo.model.NodeMcu;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface NodeMcuService {
    NodeMcu getNodeMcuByCode(String code);

    List<String> getNodeMcu();
    NodeMcu addNodeMcu(NodeMcu nodeMcu);
}
