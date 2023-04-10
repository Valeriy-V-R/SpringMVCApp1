package by.valery.springcourseMVC.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/first")
public class FistController {

    @GetMapping("/hello")
    public String helloPage() {
        return ("first/hello");
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return ("first/goodbye");
    }


}
