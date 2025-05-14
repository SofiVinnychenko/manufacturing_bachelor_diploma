package com.example.Manufac.controllers;

import com.example.Manufac.models.Machines;
import com.example.Manufac.models.WorkProgram;
import com.example.Manufac.repo.MachinesRepository;
import com.example.Manufac.repo.WorkProgramRepository;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Controller
public class ProgramController {
    @Autowired
    private WorkProgramRepository WorkProgramRepository;

    @Autowired
    private MachinesRepository MachinesRepository;

    public ProgramController(MachinesRepository machinesRepository) {
        this.MachinesRepository = machinesRepository;}


    @GetMapping("/program")
    public String WorkProg(Model model) {
        List<Machines> activeModels = MachinesRepository.findActiveModels();
        model.addAttribute("machines", activeModels);
        return "work-prog";
    }

    @PostMapping("/program")
    public String workProgramPost(@RequestParam int number, @RequestParam int morenumber, @RequestParam String title, @RequestParam int batch, @RequestParam String process,
                                  @RequestParam BigInteger machines, @RequestParam String capacity, @RequestParam float onebatt_hour, @RequestParam String datetime, Model model) {
        Timestamp timestamp = Timestamp.valueOf(datetime);
        WorkProgram WorkProgram = new WorkProgram(number,morenumber,title,batch,process,machines,capacity,onebatt_hour,timestamp);
        WorkProgramRepository.save(WorkProgram);
        return "redirect:/base-plan";
    }

    @GetMapping("/program/{id}/edit")
    public String editProgram(@PathVariable("id") Long id, Model model) {
        Optional<WorkProgram> optionalWorkProgram = WorkProgramRepository.findById(id);
        if (optionalWorkProgram.isPresent()) {
            WorkProgram workProgram = optionalWorkProgram.get();
            List<Machines> activeModels = MachinesRepository.findActiveModels();
            model.addAttribute("workProgram", workProgram);
            model.addAttribute("machines", activeModels);
            return "program-edit"; // Имя шаблона Thymeleaf для редактирования программы
        } else {
            // Обработка случая, когда программа с указанным номером не найдена
            return "redirect:/base-plan"; // Или другая страница по вашему выбору
        }
    }

    @PostMapping("/program/{id}/edit")
    public String workProgramPostEdit(@PathVariable("id") Long id, @RequestParam int number, @RequestParam int morenumber, @RequestParam String title, @RequestParam int batch, @RequestParam String process,
                                  @RequestParam BigInteger machines, @RequestParam String capacity, @RequestParam float onebatt_hour, @RequestParam String datetime, Model model) {
        WorkProgram WorkProgram = WorkProgramRepository.findById(id).orElseThrow();
        Timestamp timestamp = Timestamp.valueOf(datetime);
        WorkProgram.setNumber(number);
        WorkProgram.setMorenumber(morenumber);
        WorkProgram.setTitle(title);
        WorkProgram.setBatch(batch);
        WorkProgram.setProcess(process);
        WorkProgram.setMachines(machines);
        WorkProgram.setCapacity(capacity);
        WorkProgram.setOnebatt_hour(onebatt_hour);
        WorkProgram.setDatetime(timestamp);
        WorkProgramRepository.save(WorkProgram);
        return "redirect:/base-plan";
    }

    @PostMapping("/program/{id}/remove")
    public String workProgramPostDelete(@PathVariable("id") Long id, Model model) {
        WorkProgram WorkProgram = WorkProgramRepository.findById(id).orElseThrow();
        WorkProgramRepository.delete(WorkProgram);
        return "redirect:/base-plan";
    }
}
