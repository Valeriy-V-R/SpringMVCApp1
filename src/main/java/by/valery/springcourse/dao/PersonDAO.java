package by.valery.springcourse.dao;

// Класс для работы со списком людей (поик, добавление, удаление)


import by.valery.springcourse.models.Person;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Component // Это @bean с отличиями. Обычно @Component - аннотация уровня класса
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    // Подключение к БД
    private static final String URL ="jdbc:postgresql://localhost:5432/first_db";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";

    //Соединение к бд с помощью JDBC
    static private Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Отображает всех людей из списка
    public List<Person> index() {
        List<Person> people = new ArrayList<>();

        // Объект Statement содержит в себе запрос к БД
        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM Person"; // SQL запрос
            statement.executeQuery(SQL);

            //Принимаем результат запроса statement.executeQuery(SQL)
            //и помещаем результат в спец класс ResultSet
            ResultSet resultSet = statement.executeQuery(SQL);

            //проходим по строкам и переводим их в java объект
            while (resultSet.next()) {
                Person person = new Person();

                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setEmail(resultSet.getString("email"));
                person.setAge(resultSet.getInt("age"));

                people.add(person);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return people;
    }

    public Person show(int id) {  // Отображает человека по ID
//        return people.stream().filter(person -> person.getId() == id).findAny().orElse((null));
    return null;
    }

    public void save(Person person) {
//        person.setId(++PEOPLE_COUNT);
//        people.add(person);

        //Создаем SQL запрос к БД
        try {
            Statement statement = connection.createStatement();
            String SQL = "INSERT INTO Person VALUES(" + 1 + ",'" + person.getName() + "',"
                    + person.getAge() + ",'" + person.getEmail() + "')";
            // INSET INTO Person VALUES(1, 'Tom', 18, 'tom@mail.ru')
            // Такой запрос может иметь ошибки. Есть способ сделать лучше

            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public void update(int id, Person updatedPerson){
//        Person personToBEUpdated = show(id);
//        personToBEUpdated.setName(updatedPerson.getName());
//        personToBEUpdated.setAge(updatedPerson.getAge());
//        personToBEUpdated.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id){
        //use method removeIf() - удаление по предикату
        people.removeIf(p -> p.getId() == id);
    }
}



