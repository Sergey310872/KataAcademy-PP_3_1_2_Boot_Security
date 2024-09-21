package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.ServiceUser;

import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    private ServiceUser serviceUser;

    @GetMapping(value = "/users")
    public String listAllUser(ModelMap model) {
        model.addAttribute("messages", serviceUser.getAllUsers());
        return "users";
    }

    @GetMapping(value = "/delete")
    public String deleteUser(@RequestParam("id") Optional<Long> id) {
        serviceUser.deleteUser(id.get());
        return "redirect:/users";
    }

    @GetMapping(value = "/update")
    public String updateUser(@RequestParam("id") Optional<Long> id, Model model) {
        User user = serviceUser.getUserById(id.get());
        model.addAttribute("user", user);
        return "user-details";
    }

    @PostMapping(value = "/update")
    public String saveUser(@ModelAttribute("user") User user) {
        serviceUser.updateUser(user);
        return "redirect:/users";
    }

    @GetMapping("/add")
    public String addUser(ModelMap model) {
        model.addAttribute("user", new User());
        return "user-details";
    }

}
