package org.launchcode.spaday.controllers;

import org.launchcode.spaday.data.UserData;
import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {


    @GetMapping("add")
    public String displayAddUserForm() {
        return "user/add";
    }

    @PostMapping("add")
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
        if (verify.equals(user.getPassword())) {
            UserData.add(user);
            model.addAttribute("username", user.getUsername());
            model.addAttribute("users", UserData.getAll());
            return "user/index";
        } else {
            model.addAttribute("error", "Passwords must match");
            model.addAttribute("username", user.getUsername());
            model.addAttribute("email", user.getEmail());
            return "user/add";
        }
    }

    @GetMapping("detail/{id}")
    public String displayUserDetail(@PathVariable int id, Model model) {
        model.addAttribute("username", UserData.getById(id).getUsername());
        model.addAttribute("email", UserData.getById(id).getEmail());
        return "user/detail";
    }
}
