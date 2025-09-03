package dao;

import entity.Person;

import java.sql.SQLException;
import java.util.List;

public interface PersonDAO {
    Person getPersonById(int id);
    List<Person> findAll() throws SQLException;
    void createPerson(int id,String name, int age);
    void updatePerson(Person person);
    void deletePerson(int id);
}
