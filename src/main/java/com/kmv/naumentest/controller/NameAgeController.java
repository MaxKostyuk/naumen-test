package com.kmv.naumentest.controller;

import com.kmv.naumentest.service.NameAgeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class NameAgeController {

    private final NameAgeService service;

    @GetMapping("/main")
    public String startPage() {
        return "nameage/main";
    }

    @GetMapping("/result")
    public String resultPage(Model model) {
        model.addAttribute("name", "Антон");
        model.addAttribute("age", 27);
        return "nameage/result";
    }
}
