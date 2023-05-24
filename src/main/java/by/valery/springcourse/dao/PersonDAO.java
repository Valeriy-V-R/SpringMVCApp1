package by.valery.springcourse.dao;

// Класс для работы со списком людей (поик, добавление, удаление)


import by.valery.springcourse.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component // Это @bean с отличиями. Обычно @Component - аннотация уровня класса
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Tom", 24, "tom@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Bob", 52, "bob@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Mike", 18, "mike@yahoo.com"));
        people.add(new Person(++PEOPLE_COUNT, "Katy", 34, "katy@gmail.com"));
    }

    public List<Person> index() { // Отображает всех людей из списка
        return people;
    }

    public Person show(int id) {  // Отображает человека по ID
        return people.stream().filter(person -> person.getId() == id).findAny().orElse((null));
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }


    public void update(int id, Person updatedPerson){
        Person personToBEUpdated = show(id);
        personToBEUpdated.setName(updatedPerson.getName());
        personToBEUpdated.setAge(updatedPerson.getAge());
        personToBEUpdated.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id){
        //use method removeIf() - удаление по предикату
        people.removeIf(p -> p.getId() == id);
    }
}



