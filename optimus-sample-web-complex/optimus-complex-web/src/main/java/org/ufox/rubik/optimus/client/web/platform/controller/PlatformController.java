package org.ufox.rubik.optimus.client.web.platform.controller;

import com.github.ooknight.rubik.core.client.web.security.annotation.U;
import com.github.ooknight.rubik.core.session.SessionUser;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PlatformController {

    @GetMapping("/")
    public String root() {
        return "redirect:/portal/dashboard";
    }

    @RequestMapping("/login")
    public String login(Model model, String error) {
        if (error != null) {
            model.addAttribute("message", "无效的用户名或密码");
        }
        return "login";
    }

    @GetMapping("/portal/dashboard")
    public String dashboard() {
        return "portal/dashboard";
    }

    @GetMapping("/portal/profile")
    public String profile() {
        return "portal/profile";
    }

    @GetMapping("/admin")
    public String debug() {
        return "portal/debug";
    }
}
