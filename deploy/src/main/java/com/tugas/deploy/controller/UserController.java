package com.tugas.deploy.controller;


import com.tugas.deploy.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    List<User> data = new ArrayList<>();

    String myNim = "20240140253"; // CHANGE THIS

    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password) {

        if(username.equals("admin") && password.equals(myNim)) {
            return "redirect:/home";
        }

        return "login";
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("listUser", data);
        return "home";
    }

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("user", new User());
        return "form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute User user) {
        data.add(user);
        return "redirect:/home";
    }
}
