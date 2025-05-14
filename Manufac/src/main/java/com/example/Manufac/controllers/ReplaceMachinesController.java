package com.example.Manufac.controllers;

import com.example.Manufac.models.*;
import com.example.Manufac.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ReplaceMachinesController {

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


    @GetMapping("/replace-mach")
    public String showReplaceMach(Model model) {
        List<Object[]> mixerpastaList = mixerpastaRepository.findMachines();
        model.addAttribute("mixerpastaList", mixerpastaList);
        List<Object[]> mixerelectrolyteList = mixerelectrolyteRepository.findMachinesE();
        model.addAttribute("mixerelectrolyteList", mixerelectrolyteList);
        List<Object[]> syringemachinesList = syringemachinesRepository.findMachinesS();
        model.addAttribute("syringemachinesList", syringemachinesList);
        List<Object[]> dryovenList = dryovenRepository.findMachinesD();
        model.addAttribute("dryovenList", dryovenList);
        List<Object[]> hydrpressList = hydrpressRepository.findMachinesH();
        model.addAttribute("hydrpressList", hydrpressList);
        List<Object[]> lasercutterList = lasercutterRepository.findMachinesL();
        model.addAttribute("lasercutterList", lasercutterList);
        List<Object[]> stackmashList = stackmashRepository.findMachinesST();
        model.addAttribute("stackmashList", stackmashList);
        List<Object[]> cellelectrolytemList = cellelectrolytemRepository.findMachinesC();
        model.addAttribute("cellelectrolytemList", cellelectrolytemList);
        List<Object[]> sealingchamberList = sealingchamberRepository.findMachinesSC();
        model.addAttribute("sealingchamberList", sealingchamberList);

        return "replace-mach";
    }

    @PostMapping("/update-status")
    @ResponseBody
    public String updateStatus(@RequestParam("id") BigInteger id, @RequestParam("status") String status) {
                Mixerpasta mixerpasta = mixerpastaRepository.findById(id).orElseThrow(() -> new RuntimeException("Mixerpasta not found"));
                mixerpasta.setStatus(Mixerpasta.Status.valueOf(status)); // Изменение здесь
                mixerpastaRepository.save(mixerpasta);
                return "Status updated successfully";
    }

    @PostMapping("/update-statusE")
    @ResponseBody
    public String updateStatusE(@RequestParam("id") BigInteger id, @RequestParam("statusE") String statusE) {
        Mixerelectrolyte mixerelectrolyte = mixerelectrolyteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mixerelectrolyte not found"));
        mixerelectrolyte.setStatus(Mixerelectrolyte.StatusE.valueOf(statusE));
        mixerelectrolyteRepository.save(mixerelectrolyte);
        return "Status updated successfully";
    }

    @PostMapping("/update-statusS")
    @ResponseBody
    public String updateStatusS(@RequestParam("id") BigInteger id, @RequestParam("statusS") String statusS) {
        Syringemachines syringemachines = syringemachinesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Syringemachines not found"));
        syringemachines.setStatusS(Syringemachines.StatusS.valueOf(statusS));
        syringemachinesRepository.save(syringemachines);
        return "Status updated successfully";
    }

    @PostMapping("/update-statusD")
    @ResponseBody
    public String updateStatusD(@RequestParam("id") BigInteger id, @RequestParam("statusD") String statusD) {
        Dryoven dryoven = dryovenRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dryoven not found"));
        dryoven.setStatusD(Dryoven.StatusD.valueOf(statusD));
        dryovenRepository.save(dryoven);
        return "Status updated successfully";
    }

    @PostMapping("/update-statusH")
    @ResponseBody
    public String updateStatusH(@RequestParam("id") BigInteger id, @RequestParam("statusH") String statusH) {
        Hydrpress hydrpress = hydrpressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hydrpress not found"));
        hydrpress.setStatusH(Hydrpress.StatusH.valueOf(statusH));
        hydrpressRepository.save(hydrpress);
        return "Status updated successfully";
    }

    @PostMapping("/update-statusL")
    @ResponseBody
    public String updateStatusL(@RequestParam("id") BigInteger id, @RequestParam("statusL") String statusL) {
        Lasercutter lasercutter = lasercutterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lasercutter not found"));
        lasercutter.setStatusL(Lasercutter.StatusL.valueOf(statusL));
        lasercutterRepository.save(lasercutter);
        return "Status updated successfully";
    }

    @PostMapping("/update-statusST")
    @ResponseBody
    public String updateStatusST(@RequestParam("id") BigInteger id, @RequestParam("statusST") String statusST) {
        Stackmash stackmash = stackmashRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Stackmash not found"));
        stackmash.setStatusST(Stackmash.StatusST.valueOf(statusST));
        stackmashRepository.save(stackmash);
        return "Status updated successfully";
    }

    @PostMapping("/update-statusC")
    @ResponseBody
    public String updateStatusC(@RequestParam("id") BigInteger id, @RequestParam("statusC") String statusC) {
        Cellelectrolytem cellelectrolytem = cellelectrolytemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cellelectrolytem not found"));
        cellelectrolytem.setStatusC(Cellelectrolytem.StatusC.valueOf(statusC));
        cellelectrolytemRepository.save(cellelectrolytem);
        return "Status updated successfully";
    }

    @PostMapping("/update-statusSC")
    @ResponseBody
    public String updateStatusSC(@RequestParam("id") BigInteger id, @RequestParam("statusSC") String statusSC) {
        Sealingchamber sealingchamber = sealingchamberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sealingchamber not found"));
        sealingchamber.setStatusSC(Sealingchamber.StatusSC.valueOf(statusSC));
        sealingchamberRepository.save(sealingchamber);
        return "Status updated successfully";
    }
}
