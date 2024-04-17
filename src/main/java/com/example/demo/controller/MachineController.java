package com.example.demo.controller;

import com.example.demo.model.Machine;
import com.example.demo.services.MachineService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/machine")
public class MachineController {
    private MachineService machineService;

    public  MachineController(MachineService machineService){
        this.machineService = machineService;
    }
    @GetMapping("/viewMachines")
    public String viewMachines(Model model) {
        model.addAttribute("machines", machineService.getMachines());
        return "view-machines";
    }

    @GetMapping("/addMachine")
    public String addMachineView(Model model) {
        model.addAttribute("machine", new Machine());
        return "add-machine";
    }

    @PostMapping("/addMachine")
    public RedirectView addMachine(@ModelAttribute("machine") Machine machine, RedirectAttributes redirectAttributes) {
        final RedirectView redirectView = new RedirectView("/machine/addMachine", true);
        Machine savedMachine = machineService.addMachine(machine);
        redirectAttributes.addFlashAttribute("savedMachine", savedMachine);
        redirectAttributes.addFlashAttribute("addMachineSuccess", true);
        return redirectView;
    }

}
