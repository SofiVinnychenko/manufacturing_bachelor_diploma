package com.example.Manufac.controllers;

import com.example.Manufac.models.*;
import com.example.Manufac.repo.*;
import com.example.Manufac.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
public class DispProcessesController {

    @Autowired
    private com.example.Manufac.repo.WorkProgramRepository workProgramRepository;
    @Autowired
    private MachinesRepository machinesRepository;

    @GetMapping("/disp-processes")
    public String showProcesses(Model model) {
        LocalDate currentDate = LocalDate.now();
        Timestamp startOfDay = Timestamp.valueOf(currentDate.atStartOfDay());
        Timestamp endOfDay = Timestamp.valueOf(currentDate.atTime(23, 59, 59));

        Iterable<WorkProgram> wprog = workProgramRepository.findByDatetimeBetween(startOfDay, endOfDay);
        model.addAttribute("wprog", wprog);

        return "disp-processes"; // Имя шаблона без расширения
    }

    @GetMapping("/disp-processes/{id}/pt")
    public String getPersonalTask(@PathVariable("id") Long id, Model model) {
        Optional<WorkProgram> optionalWorkProgram = workProgramRepository.findById(id);
        if (optionalWorkProgram.isPresent()) {
            WorkProgram workProgram = optionalWorkProgram.get();
            BigInteger machineId = workProgram.getMachines(); // Предполагается, что поле machines содержит идентификатор машины типа BigInteger
            Optional<Machines> optionalMachine = machinesRepository.findById(machineId);
            double oneHourBatch = workProgram.getOnebatt_hour() * workProgram.getBatch();
            double result;
            if ("MixerP".equals(workProgram.getTitle()) || "MixerE".equals(workProgram.getTitle())) {
                result = oneHourBatch * 0.5;
            } else {
                result = oneHourBatch;
            }
            String formattedTime = TimeUtils.formatTime(result);
            model.addAttribute("formattedTime", formattedTime);
            if (optionalMachine.isPresent()) {
                Machines machine = optionalMachine.get();
                model.addAttribute("workProgram", workProgram);
                model.addAttribute("machine", machine);
                return "personal-tasks";
            }
        }
        // Обработка случая, когда программа или машина не найдены
        return "redirect:/disp-processes";
    }
}
