package com.example.Manufac.controllers;

import com.example.Manufac.models.Repair;
import com.example.Manufac.models.WorkProgram;
import com.example.Manufac.repo.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class RepairInfoDispController {

    @Autowired
    private RepairRepository repairRepository;

    @GetMapping("/repair-info-disp")
    public String RepairInfoD(Model model) {
        List<Object[]> repairsWithModels = repairRepository.findAllWithMachineModels();
        model.addAttribute("repdisp", repairsWithModels);
        return "repair-info-disp";
    }
}
