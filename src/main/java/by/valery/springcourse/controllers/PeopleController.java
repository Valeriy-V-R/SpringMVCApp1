package by.valery.springcourse.controllers;


import by.valery.springcourse.dao.PersonDAO;
import by.valery.springcourse.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


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
    public  String show (@PathVariable("id") int id, Model model) { // Аннотация @PathVariable используется для присвоения
                                                                   // вводимого в строке URL
        //Получим одного человека по id из DAO и передадим на отображение в представления
        model.addAttribute("person", PERSON_DAO.show(id));
        return "people/show";
    }
    // Метод возвращает форму для создания нового человека
    @GetMapping("/new")
    public String newPerson(Model model) {
        model.addAttribute("person", new Person());
        return "people/new";
    }

    // Верхний метод можно реализовать иначе. Строка public String newPerson(@ModelAttribute("person") Person person)
    // сама занесет человека в экземпляр Person.
//    @GetMapping("/new")
//    public String newPerson(@ModelAttribute("person") Person person) {
//        return "people/new";

    // Метод добавляет нового человека в базу данных из формы с помощью @ModelAttribute("person")
    @PostMapping()
    public String create(@ModelAttribute("person") Person person){
        PERSON_DAO.save(person);
        return "redirect:/people"; //redirect осуществляет переход на страницу
                                   //указанную после двоеточия
    }
    // Создание страницы для редактирования человека
    @GetMapping("/{id}/edit")
    public  String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("person", PERSON_DAO.show(id));
        return "people/edit";
    }
    //
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") Person person, @PathVariable("id") int id){
        PERSON_DAO.update(id, person);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        PERSON_DAO.delete(id);
        return "redirect:/people";
    }
}

