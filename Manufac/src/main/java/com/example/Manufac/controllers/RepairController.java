package com.example.Manufac.controllers;

import com.example.Manufac.models.Machines;
import com.example.Manufac.models.Repair;
import com.example.Manufac.repo.MachinesRepository;
import com.example.Manufac.repo.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigInteger;
import java.time.LocalTime;
import java.util.Optional;

@Controller
public class RepairController {

    @Autowired
    private RepairRepository repairRepository;

    @PostMapping("/repair")
    public String createRepair (@RequestParam String process, @RequestParam BigInteger machines_model, @RequestParam String problem, @RequestParam String possible_reasons,
                                @RequestParam float abnormal_value, @RequestParam float normal_value_min, @RequestParam float normal_value_max, Model model) {
        Repair repair = new Repair();
        repair.setProcess(process);
        repair.setMachines_model(machines_model);
        repair.setProblem(problem);
        repair.setPossible_reasons(possible_reasons);
        repair.setAbnormal_value(abnormal_value);
        repair.setNormal_value_min(normal_value_min);
        repair.setNormal_value_max(normal_value_max);
        repair.setStatus(Repair.Status.SENT); // Установить статус SENT

        // Оставить поле details как null

        // Сохранить repair в базу данных
        repairRepository.save(repair);

        return "redirect:/repair-info-disp"; // Или любой другой URL для перенаправления
    }

    @GetMapping("/repair/{id}/update")
    public String editRepair(@PathVariable("id") Long id, Model model) {
        Optional<Repair> optionalRepair = repairRepository.findById(id);
        if (optionalRepair.isPresent()) {
            Repair repair = optionalRepair.get();
            model.addAttribute("repair", repair);
            return "edit-details"; // Имя шаблона Thymeleaf для редактирования программы
        } else {
            // Обработка случая, когда программа с указанным номером не найдена
            return "redirect:/subm-reports"; // Или другая страница по вашему выбору
        }
    }

    @PostMapping("/repair/{id}/update")
    public String updateRepair (@PathVariable("id") Long id, @RequestParam String details, @RequestParam LocalTime spent_time, Model model) {
        Repair repair = repairRepository.findById(id).orElseThrow();
        repair.setDetails(details);
        repair.setSpent_time(spent_time);
        repair.setStatus(Repair.Status.COMPLETED); // Установить статус COMPLETED

        // Сохранить repair в базу данных
        repairRepository.save(repair);

        return "redirect:/subm-reports"; // Или любой другой URL для перенаправления
    }


}
