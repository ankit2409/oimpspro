package com.example.demo.controller;

import com.example.demo.services.NodeMcuService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/nodemcu")
public class NodeMcuController {
    private final NodeMcuService nodeMcuService;

    public NodeMcuController(NodeMcuService nodeMcuService) {
        this.nodeMcuService = nodeMcuService;
    }

    @GetMapping("/viewNodemcu")
    public String viewNodemcu(Model model) {
        model.addAttribute("nodemcu", nodeMcuService.getNodeMcu());
        return "view-nodemcu";
    }

}
