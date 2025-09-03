package app;
import dao.PersonDAO;
import factory.DAOFactory;
import factory.DBType;


import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            // 1. Creamos la factory de MySQL
            DAOFactory factory = DAOFactory.getInstance(DBType.MYSQL);

            // 2. Obtenemos el DAO de Persona
            PersonDAO personDAO = factory.createPersonDAO();


            // 3. Insertamos una persona (esto depende de cómo tengas el método en tu DAO)
            personDAO.createPerson(1, "Ivan", 22);
            personDAO.createPerson(2, "Martin", 25);

            // 4. Listamos todas las personas
            personDAO.findAll().forEach(System.out::println);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

