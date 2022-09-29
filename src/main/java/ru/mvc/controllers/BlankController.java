package ru.mvc.controllers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.mvc.config.SpringConfig;


@Controller
public class BlankController {
    @GetMapping("/")
    public String helloPage(){
        return "index";
    }
}
