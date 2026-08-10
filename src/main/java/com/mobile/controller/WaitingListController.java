package com.mobile.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mobile.entity.WaitingList;
import com.mobile.repository.WaitingListRepository;


@Controller
public class WaitingListController {

    @Autowired
    private WaitingListRepository waitingListRepository;


    @GetMapping("/waiting")
    public String showWaitingList(Model model) {

        List<WaitingList> waitingList = waitingListRepository.findAll();
        model.addAttribute("waitingList", waitingList);

        return "waiting";
    }
}