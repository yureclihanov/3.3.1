package com.springboot.controller;

import com.springboot.model.User;
import com.springboot.servise.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService servise;

    @Autowired
    public UserController(UserService servise) {
        this.servise = servise;
    }


    @GetMapping
    public String all(Model model) {
        model.addAttribute("people", servise.allUsers());
        return "index";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", servise.findUserById(id));
        return "show";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("person") User user) {
        return "/new";
    }

    @PostMapping
    public String createNewUser(@ModelAttribute("person") User user) {
        servise.add(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/update")
    public String updateUser(Model model, @PathVariable("id") int id) {
        model.addAttribute("person", servise.findUserById(id));
        return "update";
    }

    @PatchMapping("/{id}")
    public String updateuser(@ModelAttribute("person") User user, @PathVariable("id") int id) {
        servise.update(user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}/delete")
    public String deleteUser(@PathVariable("id") int id) {
        servise.deleteById(id);
        return "redirect:/users";
    }

}
