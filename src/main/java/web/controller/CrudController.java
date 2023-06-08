package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.repository.UserService;
import web.model.User;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CrudController {
    private final UserService userService;

    @Autowired
    public CrudController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String printWelcome(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Hello!");
        messages.add("I'm Spring MVC application");
        messages.add("Version by ArhDaRk june'23 ");
        model.addAttribute("messages", messages);
        return "index";
    }

    @GetMapping("/table")
    public String findAll(Model model, User user) {
        model.addAttribute("usersList", userService.getAllUsers());
        model.addAttribute("user", user);
        return "table";
    }

    @PostMapping("/table")
    public String createUser(User user) {
        userService.saveUser(user);
        return "redirect:/table";
    }

    @GetMapping("/table/{id}")
    public String getUpdateUser(@PathVariable("id") Integer id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "redirect:/table";
    }

    @DeleteMapping("/table/{id}")
    public String deleteUser(@PathVariable("id") Integer id) {
        userService.removeUserById(id);
        return "redirect:/table";
    }

    @PostMapping("/table/{id}")
    public String saveUpdateUser(User user) {
        userService.updateUser(user);
        return "redirect:/table";
    }
}
