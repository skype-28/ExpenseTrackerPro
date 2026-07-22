package com.skp.expensetrackerpro.controller;

import com.skp.expensetrackerpro.dto.RegisterDto;
import com.skp.expensetrackerpro.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("registerDto", new RegisterDto());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(
            @Valid @ModelAttribute("registerDto") RegisterDto dto,
            BindingResult result,
            Model model)  {
        
        if (result.hasErrors()) {
            return "register";
        }

        try {
            userService.register(dto);
            model.addAttribute("success", "Registration successful! You can now login.");
        } catch (RuntimeException ex) {
            model.addAttribute("error", ex.getMessage());
        }

        return "register";
    }
    
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
    
    
    
}
