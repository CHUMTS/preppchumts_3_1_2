package com.chumts.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.chumts.task.model.User;
import com.chumts.task.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }



    @GetMapping(value = "/users")
    public String usersPage(Model model){
        model.addAttribute("usersList", userService.getAllUsers());
        return "allUsers";
    }

    @GetMapping(value = "/users/new")
    public String inputForm(Model model){
        model.addAttribute("user", new User());
        return "new";
    }

    @GetMapping(value = "users/{id}/edit")
    public String editForm(@PathVariable("id") Long id, Model model){
        model.addAttribute("user", userService.showUserById(id).get());
        return "edit";
    }

    @PatchMapping(value = "users/{id}/edit")
    public String editUser(@PathVariable("id") Long id, @ModelAttribute("userEdit") User user){
        userService.saveUser(user);
        return "redirect:/users";
    }

    @DeleteMapping(value = "/users/{id}/delete")
    public String deleteUser(@PathVariable("id") Long id){
        userService.removeUserById(id);
        return "redirect:/users";
    }

    @GetMapping(value = "/users/{id}")
    public String showUser(@PathVariable("id") long id, Model model){
        model.addAttribute("user", userService.showUserById(id));
        return "showUser";
    }

    @PostMapping(value = "/users")
    public String createUser(@ModelAttribute("userCreate") User user){
        userService.saveUser(user);
        return "redirect:/users";
    }
}
