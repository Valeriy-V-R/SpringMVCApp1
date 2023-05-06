package by.valery.springcourse.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor     //Аннотации Lombok https://projectlombok.org/features/
@NoArgsConstructor
public class Person {
    private int id;
    private String name;
}
