package repository.mysql;

import dao.PersonDAO;
import entity.Person;
import factory.ConnectionMySQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLPersonDAO implements PersonDAO {

    private final Connection conn;

    public MySQLPersonDAO(Connection connection) throws SQLException {
        this.conn = connection;
        createTableIfNotExists();

    }

    private void createTableIfNotExists() {
        final String sql = "CREATE TABLE IF NOT EXISTS persons (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "name VARCHAR(100) NOT NULL," +
                "age INT NOT NULL" +
                ");";

        try (Statement st = conn.createStatement()) {
            st.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createPerson(int id, String name, int age) {
        String sql = "INSERT INTO person (id, name, age) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setInt(3, age);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Person getPersonById(int id) {
        final String sql = "SELECT * FROM persons WHERE id = " + id + ";";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Person(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getInt("age")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Person> findAll() throws SQLException {
        List<Person> people = new ArrayList<>();
        String sql = "SELECT id, name, age FROM person";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                people.add(new Person(id, name, age));
            }
        }
        return people;
    }

    @Override
    public void updatePerson(Person person) {
        final String sql = "UPDATE PERSONS SET NAME = ?, AGE = ? WHERE ID = ?;";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, person.getName());
            ps.setInt(2, person.getAge());
            ps.setInt(3, person.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePerson(int id) {
        final String sql = "DELETE FROM PERSONS WHERE ID = ?;";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
}
