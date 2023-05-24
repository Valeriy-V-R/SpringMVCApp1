package by.valery.springcourse.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
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

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 30, message = ("Name should be 2 or 30 characters"))
    private String name;

    @Min(value = 0, message = ("Age should be greater than 0"))
    private int age;

    @NotEmpty(message = "Email should not be empty")
    @Email(message = ("Email should be valid"))
    private String email;
}
