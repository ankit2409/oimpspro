package com.example.demo.controller;
import com.example.demo.model.ProductionSheet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductionSheetController {

    @GetMapping("/production")
    public String machineStatus(Model model) {
        // Simulate data retrieval (replace with your actual data source)
        List<ProductionSheet> machineList = new ArrayList<>();
        machineList.add(new ProductionSheet("001", "Part A", "Metal", "5 kg", "1000", "Operational"));
        machineList.add(new ProductionSheet("002", "Part B", "Plastic", "2 kg", "500", "Maintenance"));
        model.addAttribute("machineList", machineList);
        return "production-sheet";
    }

}

