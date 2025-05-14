package com.example.Manufac.controllers;

import com.example.Manufac.models.Machines;
import com.example.Manufac.models.WorkProgram;
import com.example.Manufac.repo.MachinesRepository;
import com.example.Manufac.repo.WorkProgramRepository;
import com.example.Manufac.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
public class ReportsController {

    @Autowired
    private com.example.Manufac.repo.WorkProgramRepository WorkProgramRepository;
    @Autowired
    private MachinesRepository machinesRepository;


    @GetMapping("/reports")
    public String Report(Model model) {
        // Получаем все рабочие программы
        Iterable<WorkProgram> progs = WorkProgramRepository.findAll();

        // Группируем программы по number
        Map<Integer, List<WorkProgram>> groupedPrograms = StreamSupport.stream(progs.spliterator(), false)
                .collect(Collectors.groupingBy(WorkProgram::getNumber));

        model.addAttribute("groupedPrograms", groupedPrograms);
        return "reports";
    }

    @GetMapping("/reports/{id}/pt")
    public String getPersonalTask(@PathVariable("id") Long id, Model model) {
        Optional<WorkProgram> optionalWorkProgram = WorkProgramRepository.findById(id);
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
        return "redirect:/reports";
    }
}
