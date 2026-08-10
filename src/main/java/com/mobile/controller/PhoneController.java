package com.mobile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.mobile.entity.Phone;
import com.mobile.repository.PhoneRepository;

@Controller
@RequestMapping("/phones")
public class PhoneController {

    @Autowired
    private PhoneRepository phoneRepository;

    @GetMapping
    public String listPhones(Model model) {
        model.addAttribute("phones", phoneRepository.findAll());
        model.addAttribute("phone", new Phone());
        return "phones";
    }

    @PostMapping("/save")
    public String savePhone(@ModelAttribute Phone phone) {
        if (phone.getStatus() == null || phone.getStatus().isEmpty()) {
            phone.setStatus("Available");
        }
        phoneRepository.save(phone);
        return "redirect:/phones";
    }

}