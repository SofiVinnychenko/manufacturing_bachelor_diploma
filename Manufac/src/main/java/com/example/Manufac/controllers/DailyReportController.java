package com.example.Manufac.controllers;

import com.example.Manufac.models.WorkProgram;
import com.example.Manufac.repo.MachinesRepository;
import com.example.Manufac.repo.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Controller
public class DailyReportController {

    @Autowired
    private com.example.Manufac.repo.WorkProgramRepository workProgramRepository;
    @Autowired
    private RepairRepository repairRepository;

    @GetMapping("/daily-report")
    public String showDailyReport(Model model) {
        LocalDate currentDate = LocalDate.now();
        Timestamp startOfDay = Timestamp.valueOf(currentDate.atStartOfDay());
        Timestamp endOfDay = Timestamp.valueOf(currentDate.atTime(23, 59, 59));

        List<Object[]> completedRepairsWithModels = repairRepository.findCompletedWithMachineModels();
        model.addAttribute("repdaily", completedRepairsWithModels);

        Iterable<WorkProgram> workdaily = workProgramRepository.findByDatetimeBetween(startOfDay, endOfDay);
        model.addAttribute("workdaily", workdaily);

        return "daily-report"; // Имя шаблона без расширения
    }
}
