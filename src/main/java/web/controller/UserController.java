package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String listUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "user-list";
    }

    @GetMapping("/new")
    public String showFormForAdd(Model model) {
        model.addAttribute("user", new User());
        return "user-form";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/edit")
    public String showFormForUpdate(@RequestParam("userId") Long id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "user-form";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam("userId") Long id) {
        userService.delete(id);
        return "redirect:/users";
    }
}

