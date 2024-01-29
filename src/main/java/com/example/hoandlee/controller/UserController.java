package com.example.hoandlee.controller;

import com.example.hoandlee.domain.User;
import com.example.hoandlee.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String registerForm() {
        return "register";
    }

    @PostMapping("/doRegister")
    public String registerUser(@ModelAttribute User user, RedirectAttributes redirectAttributes) {
        boolean success = userService.registerUser(user);
        if (!success) {
            redirectAttributes.addFlashAttribute("message", "Username already exists.");
            return "redirect:/register";
        }
        return "redirect:/login";
    }
}
