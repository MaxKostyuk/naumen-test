package com.kmv.naumentest.controller;

import com.kmv.naumentest.model.NameAge;
import com.kmv.naumentest.service.NameAgeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class NameAgeController {

    private final NameAgeService service;

    @GetMapping("/main")
    public String startPage(Model model) {
        model.addAttribute("nameAge", new NameAge());
        return "nameage/main";
    }

//    @GetMapping("/result")
//    public String resultPage(@RequestParam String name,
//                             Model model) {
//        model.addAttribute("name", name);
//        model.addAttribute("age", service.getNameAge(name));
//        return "nameage/result";
//    }

    @GetMapping("/result")
    public String resultPage(@ModelAttribute @Valid NameAge nameAge,
                             BindingResult result) {
        if (result.hasErrors())
            return "nameage/main";
        nameAge.setAge(service.getNameAge(nameAge.getName()));
        return "nameage/result";
    }
}
