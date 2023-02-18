package com.forum.forum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.forum.forum.SecurityContext.Context;
import com.forum.forum.services.MessageService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class DashController {
    
    private final MessageService messageService;

    @GetMapping("/home")
    public String getHomePage(Model model) {
        String name = Context.getUser();
        model.addAttribute("name", name);
        model.addAttribute("data", messageService.retrieve());
        return "home";
    }

    

    
}
