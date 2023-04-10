package com.alexander.maksimov.controllers;

import com.alexander.maksimov.models.User;
import com.alexander.maksimov.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping()
    public String showAllUser(Model model) {
        model.addAttribute("users", userService.findAll());
        return "index";
    }

    @GetMapping("/{id}")
    public String showOneUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.findOne(id));
        return "show";
    }

    @GetMapping("/new")
    public String showPageCreatingUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {

        userService.save(user);
        return "redirect:/user";
    }

    @GetMapping("/{id}/update")
    public String showPageEditUser(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.findOne(id));
        return "update";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/user";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/user";
    }
}
