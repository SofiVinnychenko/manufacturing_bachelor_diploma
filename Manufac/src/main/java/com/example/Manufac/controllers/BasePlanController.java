package com.example.Manufac.controllers;

import com.example.Manufac.models.WorkProgram;
import com.example.Manufac.repo.WorkProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class BasePlanController {

    @Autowired
    private WorkProgramRepository WorkProgramRepository;


    @PreAuthorize("hasRole('PLANNER')")
    @GetMapping("/base-plan")
    public String BasePlan(Model model) {
        Iterable<WorkProgram> progs = WorkProgramRepository.findAll();
        model.addAttribute("progs", progs);
        return "base-plan";
    }

}
