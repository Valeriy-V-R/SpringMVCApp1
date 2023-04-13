package by.valery.springcourseMVC.controllers;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FistController {

    @GetMapping("/calculator")

    // Получение параметров запроса с помощью @RequestParam

      public String helloPage(@RequestParam(value = "a", required = false) Integer a,
                              @RequestParam (value = "b", required = false) Integer b,
                              @RequestParam (value = "action", required = false) String action,
                              Model model) {

       if (action.equals("multiplication")){
           model.addAttribute("result",   a * b);
       }
       else if(action.equals("addition")){
           model.addAttribute("result",   a + b);
       }
       else if(action.equals("subtraction")) {
           model.addAttribute("result", a - b);
       }
       else if(action.equals("division")) {
           model.addAttribute("result", a / b);
       }

        return ("first/calculator");
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return ("first/goodbye");
    }


}
