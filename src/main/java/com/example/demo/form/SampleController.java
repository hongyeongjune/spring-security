package com.example.demo.form;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class SampleController {

    private final SampleService sampleService;

    @GetMapping("/")
    public String index(Model model, Principal principal) {
        if(principal == null) {
            model.addAttribute("message", "Hello Spring Security");
        }
        else {
            model.addAttribute("meessage", "hello" + principal.getName());
        }
        return "index";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model, Principal principal) {
        model.addAttribute("message", "Dashboard" + principal.getName());
        sampleService.dashboard();
        return "index";
    }

    @GetMapping("/info")
    public String info(Model model) {
        model.addAttribute("message", "Info");

        return "index";
    }

    @GetMapping("/admin")
    public String admin(Model model, Principal principal) {
        model.addAttribute("message", "admin" + principal.getName());

        return "index";
    }
}
