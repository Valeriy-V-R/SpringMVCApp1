package by.valery.springcourseMVC.controllers;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FistController {

    @GetMapping("/hello")

    // Получение параметров запроса с помощью HttpServletRequest
//    public String helloPage(HttpServletRequest request) {
//        String name = request.getParameter("name");
//        String surname = request.getParameter("surname");
//
//        System.out.println("Hello, " + name + " " + surname);
//
//        return ("first/hello");
//    }


    // Получение параметров запроса с помощью @RequestParam
    //
      public String helloPage(@RequestParam(value = "name", required = false) String name,
                                    @RequestParam (value = "surname", required = false) String surname) {

        System.out.println("Hello, " + name + " " + surname);

        return ("first/hello");
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return ("first/goodbye");
    }


}
