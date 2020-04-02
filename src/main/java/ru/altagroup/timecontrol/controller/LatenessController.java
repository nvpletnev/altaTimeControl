package ru.altagroup.timecontrol.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.altagroup.timecontrol.service.UserService;

@Controller
public class LatenessController {

    private UserService userService;

    @Autowired
    public LatenessController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getUsersWithFailure(Model model) {
        model.addAttribute("users", userService.getUsersWithSheduleFailure());
        return "index";
    }
}
