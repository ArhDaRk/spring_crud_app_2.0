package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/user-table")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String findAll(Model model, User user) {
        model.addAttribute("usersList", userService.getAllUsers());
        model.addAttribute("user", user);
        return "user-table";
    }

    @PostMapping
    public String createUser(User user) {
        userService.saveUser(user);
        return "redirect:/user-table";
    }

    @GetMapping("/{id}")
    public String getUpdateUser(@PathVariable("id") Integer id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "redirect:/user-table";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Integer id) {
        userService.removeUserById(id);
        return "redirect:/user-table";
    }

    @PostMapping("/{id}")
    public String saveUpdateUser(User user) {
        userService.updateUser(user);
        return "redirect:/user-table";
    }
}
