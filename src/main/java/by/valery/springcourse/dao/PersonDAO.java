package by.valery.springcourse.dao;

// Класс для работы со списком людей (поик, добавление, удаление)


import by.valery.springcourse.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Tom"));
        people.add(new Person(++PEOPLE_COUNT, "Bob"));
        people.add(new Person(++PEOPLE_COUNT, "Mike"));
        people.add(new Person(++PEOPLE_COUNT, "Katy"));
    }

    public  List<Person> index(){ // Отображает всех людей из списка
        return people;
    }

    public Person show(int id) {  // Отображает человека по ID
        return people.stream().filter(person -> person.getId() == id).findAny().orElse((null));
    }
}

