package ru.gb.my_first_crud.controller;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.gb.my_first_crud.model.User;
import ru.gb.my_first_crud.service.UserService;

import java.util.List;

@Controller
@AllArgsConstructor
@Log
public class UserController {

    private UserService userService;
    @GetMapping("/users")
    public String findAll(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        log.info("users quantity " + users.size());
        return "user-list";
    }

    @GetMapping("/user-create")
    public String createUserForm(User user) {
        log.warning("We going to create a User");
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user) {
        userService.saveUser(user);
        log.info("User created");
        return "redirect:/users";
    }

    @PostMapping("/user-update")
    public String updateUser(User user) {
        userService.updateUser(user);
        log.info("User with id: " + user.getId() + " has been updated");
        return "redirect:/users";
    }

    @GetMapping("user-delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteById(id);
        log.warning("User with id: " + id + " has been deleted");
        return "redirect:/users";
    }

    @GetMapping("/user-update/{id}")
    public String updateUser(@PathVariable("id") int id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        log.warning("User with id: " + id + " going to be updated");
        return "user-update";
    }


}
