package com.example.Lab2_NenashevDA_StaryginVA.controller;

import com.example.Lab2_NenashevDA_StaryginVA.model.User;
import com.example.Lab2_NenashevDA_StaryginVA.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getAllUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "user/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("user", new User());
        return "user/create";
    }

    @PostMapping("/create")
    public String createUser(@Valid @ModelAttribute User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "user/create";
        }
        try {
            userService.createUser(user);
            return "redirect:/users";
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            return "user/create";
        }
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Optional<User> user = userService.getUserById(id);
        if (user.isPresent()) {
            model.addAttribute("user", user.get());
            return "user/edit";
        } else {
            return "redirect:/users";
        }
    }

    @PostMapping("/edit/{id}")
    public String updateUser(@PathVariable Integer id, @Valid @ModelAttribute User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "user/edit";
        }
        try {
            user.setId(id);
            userService.updateUser(user);
            return "redirect:/users";
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            return "user/edit";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}