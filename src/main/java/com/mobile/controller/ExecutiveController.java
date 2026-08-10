package com.mobile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.mobile.entity.Executive;
import com.mobile.repository.ExecutiveRepository;

@Controller
@RequestMapping("/executives")
public class ExecutiveController {

    @Autowired
    private ExecutiveRepository executiveRepository;

    @GetMapping
    public String listExecutives(Model model) {
        model.addAttribute("executives", executiveRepository.findAll());
        model.addAttribute("executive", new Executive());
        return "executives";
    }

    @PostMapping("/save")
    public String saveExecutive(@ModelAttribute Executive executive) {
    	
        executiveRepository.save(executive);
        return "redirect:/executives";
    }

}