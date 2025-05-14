package com.example.Manufac.controllers;

import com.example.Manufac.models.*;
import com.example.Manufac.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class MonitoringController {

    @Autowired
    private MixerpastaRepository mixerpastaRepository;
    @Autowired
    private MixerelectrolyteRepository mixerelectrolyteRepository;
    @Autowired
    private SyringemachinesRepository syringemachinesRepository;
    @Autowired
    private DryovenRepository dryovenRepository;
    @Autowired
    private HydrpressRepository hydrpressRepository;
    @Autowired
    private LasercutterRepository lasercutterRepository;
    @Autowired
    private StackmashRepository stackmashRepository;
    @Autowired
    private CellelectrolytemRepository cellelectrolytemRepository;
    @Autowired
    private SealingchamberRepository sealingchamberRepository;
    @Autowired
    private com.example.Manufac.repo.WorkProgramRepository workProgramRepository;
    @Autowired
    private MachinesRepository MachinesRepository;

    public MonitoringController(MachinesRepository machinesRepository) {
        this.MachinesRepository = machinesRepository;}


    @GetMapping("/monitoring")
    public String showMonitoring (Model model) {

        List<Object[]> findMachinesP = mixerpastaRepository.findUsedMachines();
        model.addAttribute("mixers", findMachinesP);

        List<Object[]> findMachinesE = mixerelectrolyteRepository.findUsedMachinesE();
        model.addAttribute("mixere", findMachinesE);

        List<Object[]> findMachinesS = syringemachinesRepository.findUsedMachinesS();
        model.addAttribute("syrm", findMachinesS);

        List<Object[]> findMachinesD = dryovenRepository.findUsedMachinesD();
        model.addAttribute("dryo", findMachinesD);

        List<Object[]> findMachinesH = hydrpressRepository.findUsedMachinesH();
        model.addAttribute("hydr", findMachinesH);

        List<Object[]> findMachinesL = lasercutterRepository.findUsedMachinesL();
        model.addAttribute("laser", findMachinesL);

        List<Object[]> findMachinesST = stackmashRepository.findUsedMachinesST();
        model.addAttribute("stack", findMachinesST);

        List<Object[]> findMachinesC = cellelectrolytemRepository.findUsedMachinesC();
        model.addAttribute("elec", findMachinesC);

        List<Object[]> findMachinesSC = sealingchamberRepository.findUsedMachinesSC();
        model.addAttribute("seal", findMachinesSC);

        LocalDate currentDate = LocalDate.now();
        Timestamp startOfDay = Timestamp.valueOf(currentDate.atStartOfDay());
        Timestamp endOfDay = Timestamp.valueOf(currentDate.atTime(23, 59, 59));

        List<WorkProgram> wprogram = workProgramRepository.findByDatetimeBetween(startOfDay, endOfDay);
        List<String> processNames = wprogram.stream()
                .map(WorkProgram::getProcess)
                .collect(Collectors.toList());

        model.addAttribute("wprogram", wprogram);
        model.addAttribute("processNames", processNames);

        return "monitoring"; // Имя шаблона без расширения
    }

    @GetMapping("/monitoring/repair")
    public String showRepairPage(Model model) {
        List<Machines> activeModels = MachinesRepository.findActiveModels();
        model.addAttribute("machines", activeModels);
        return "repair";
    }

}
