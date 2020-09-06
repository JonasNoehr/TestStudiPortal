package de.hsba.bi.studentOrganisationPortal.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

    @PostMapping(path = "/hello")
    public String hello(Model model, @RequestParam String name) {
        if (name != null) {
            model.addAttribute("greeting", "Hello, " + name + "!");
        }
        return "index";
    }
}
