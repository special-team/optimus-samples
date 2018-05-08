package org.ufox.rubik.optimus.client.web.business.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BusinessController {

    @GetMapping("/login")
    public String login(Model model, String error) {
        if (error != null) {
            model.addAttribute("message", error);
        }
        return "login";
    }

    @GetMapping("/")
    public String root() {
        return "redirect:/portal/demo";
    }

    @GetMapping("/portal/demo")
    public String demo() {
        return "portal/demo";
    }
}
