package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.dao.DAO;
import web.model.User;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CRUDController {
    private final DAO dao;

    @Autowired
    public CRUDController(DAO dao) {
        this.dao = dao;
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
    public String userList(Model model) {
        model.addAttribute("usersList", dao.getAllUsers());
        return "table";
    }

    @ModelAttribute("getUser")
    public User getUser() {
        return new User();
    }

    @PostMapping(value = "/table")
    public String saveUser(
            @ModelAttribute("getUser") User user,
            BindingResult bindingResult, ModelMap model) {
        if (bindingResult.hasErrors()){
            model.addAttribute("usersList", dao.getAllUsers());
            return "table";
        }
        dao.saveUser(user);

        return "redirect:/table";
    }

    @PostMapping(value = "/table/{id}")
    public String updateUser(
            @ModelAttribute("getUser") User user,
            BindingResult bindingResult, ModelMap model) {
        if (bindingResult.hasErrors()){
            model.addAttribute("usersList", dao.getAllUsers());
            return "table";
        }
        dao.updateUser(user);

        return "redirect:/table";
    }

    @DeleteMapping("/table/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        dao.removeUserById(id);
        return "redirect:/table";
    }
}