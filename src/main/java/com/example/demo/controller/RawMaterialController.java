package com.example.demo.controller;

import com.example.demo.model.RawMaterial;
import com.example.demo.services.RawMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/rawMaterial")
public class RawMaterialController {
    @Autowired
    RawMaterialService rawMaterialService;


    @GetMapping("/viewRawMaterials")
    public String viewRawMaterials(Model model) {
        model.addAttribute("rawMaterials", rawMaterialService.getRawMaterial());
        return "view-rawMaterials";
    }

    @GetMapping("/addRawMaterial")
    public String addRawMaterialView(Model model) {
        model.addAttribute("rawMaterial", new RawMaterial());
        return "add-rawMaterial";
    }

    @PostMapping("/addRawMaterial")
    public RedirectView addRawMaterial(@ModelAttribute("rawMaterial") RawMaterial rawMaterial, RedirectAttributes redirectAttributes) {
        final RedirectView redirectView = new RedirectView("/rawMaterial/addRawMaterial", true);
        RawMaterial savedRawMaterial = rawMaterialService.addRawMaterial(rawMaterial);
        redirectAttributes.addFlashAttribute("rawMaterial", savedRawMaterial);
        redirectAttributes.addFlashAttribute("addRawMaterialSuccess", true);
        return redirectView;
    }

    // Add other CRUD operations as needed
}
