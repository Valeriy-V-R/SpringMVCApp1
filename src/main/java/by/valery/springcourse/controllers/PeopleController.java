package by.valery.springcourse.controllers;


import by.valery.springcourse.dao.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/people") //Связывает метод контроллера с URL адресом
public class PeopleController {

    // Внедряем DAO в контроллер
    final private PersonDAO PERSON_DAO;

    @Autowired //Сканирует на наличие @bean и @Component и внедряет их.
    public PeopleController(PersonDAO PERSON_DAO) {
        this.PERSON_DAO = PERSON_DAO;
    }
    // Метод возвращает список из людей

    @GetMapping() //Связывает метод контроллера с URL адресом
    public String index(Model model){
        //Получим всех людей из DAO и передадим на отображение и представление
        model.addAttribute("people", PERSON_DAO.index());
        return "people/index";
    }

    // Метод возвращает одного человека по его ID
    @GetMapping("/{id}")
    public  String show (@PathVariable("id") int id, Model model) {
        //Получим одного человека по id из DAO и передадим на отображение в представления
        model.addAttribute("person", PERSON_DAO.show(id));
        return "people/show";
    }
}

