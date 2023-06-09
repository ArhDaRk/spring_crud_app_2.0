package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.repository.UserRepository;
import web.model.User;

@Controller
public class UserController {
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/user-table")
    public String findAll(Model model, User user) {
        model.addAttribute("usersList", userRepository.getAllUsers());
        model.addAttribute("user", user);
        return "user-table";
    }

    @PostMapping("/user-table")
    public String createUser(User user) {
        userRepository.saveUser(user);
        return "redirect:/user-table";
    }

    @GetMapping("/user-table/{id}")
    public String getUpdateUser(@PathVariable("id") Integer id, Model model) {
        User user = userRepository.getUserById(id);
        model.addAttribute("user", user);
        return "redirect:/user-table";
    }

    @DeleteMapping("/user-table/{id}")
    public String deleteUser(@PathVariable("id") Integer id) {
        userRepository.removeUserById(id);
        return "redirect:/user-table";
    }

    @PostMapping("/user-table/{id}")
    public String saveUpdateUser(User user) {
        userRepository.updateUser(user);
        return "redirect:/user-table";
    }
}