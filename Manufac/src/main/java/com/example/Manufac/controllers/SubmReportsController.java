package com.example.Manufac.controllers;

import com.example.Manufac.models.Machines;
import com.example.Manufac.models.Repair;
import com.example.Manufac.models.WorkProgram;
import com.example.Manufac.repo.MachinesRepository;
import com.example.Manufac.repo.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Controller
public class SubmReportsController {

    @Autowired
    private RepairRepository repairRepository;


    @GetMapping("/subm-reports")
    public String SubmReport(Model model) {
        List<Object[]> repairsWithModels = repairRepository.findAllWithMachineModels();
        model.addAttribute("submrep", repairsWithModels);
        return "subm-reports";
    }

}
