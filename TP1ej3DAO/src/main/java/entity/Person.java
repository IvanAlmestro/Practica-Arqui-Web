package entity;
import lombok.*;
@Data
public class Person {
    String name;
    Integer id;
    Integer age;
    public Person(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
