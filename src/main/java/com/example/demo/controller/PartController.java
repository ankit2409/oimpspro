package com.example.demo.controller;

import com.example.demo.model.Part;
import com.example.demo.model.RawMaterial;
import com.example.demo.services.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/part")
public class PartController {
    @Autowired
    PartService partService;

    @GetMapping("/viewParts")
    public String viewParts(Model model) {
        model.addAttribute("parts", partService.getParts());
        return "view-parts";
    }

    @GetMapping("/addPart")
    public String addPartView(Model model) {
        model.addAttribute("part", new Part());
        model.addAttribute("rawMaterials", partService.getAllRawMaterials());
        return "add-part";
    }

    @PostMapping("/addPart")
    public RedirectView addPart(@ModelAttribute("part") Part part, RedirectAttributes redirectAttributes) {
        final RedirectView redirectView = new RedirectView("/part/addPart", true);
        Part savedPart = partService.addpart(part);
        List<RawMaterial> rawMaterials = partService.getAllRawMaterials();
        redirectAttributes.addFlashAttribute("savedPart", savedPart);
        redirectAttributes.addFlashAttribute("rawMaterials", rawMaterials);
        redirectAttributes.addFlashAttribute("addPartSuccess", true);
        return redirectView;
    }


    // Add other CRUD operations as needed
}
