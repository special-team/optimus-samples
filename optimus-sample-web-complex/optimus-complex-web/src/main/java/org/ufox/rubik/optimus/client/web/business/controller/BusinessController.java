package org.ufox.rubik.optimus.client.web.business.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BusinessController {

    @GetMapping("/portal/customer/index")
    public String index() {
        return "portal/customer/index";
    }
}
