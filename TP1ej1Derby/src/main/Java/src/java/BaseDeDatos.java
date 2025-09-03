package src.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BaseDeDatos {
    public static void main(String[] args) {
        String driver = "org.apache.derby.jdbc.EmbeddedDriver";
        try {
            //Cargo el driver
            Class.forName(driver).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            //si falla salgo del programa
            System.exit(1);
        }
        // creo la uri donde esta la base de datos
        String uri = "jdbc:derby:myDerbyDB;create=true";
        try {
            //creo la conexion
            Connection conn = DriverManager.getConnection(uri);
            createTables(conn);
            addPerson(conn,1, "Ivan", 22);
            addPerson(conn,2, "Paula", 21);
            conn.close();
            System.out.println("Conexion a base de datos realizada");

        } catch (SQLException e) {
            e.printStackTrace();
            //si falla salgo del programa
            System.exit(1);
        }

    }

    private static void addPerson(Connection conn, int id, String name, int years) throws SQLException {
        String insert = "INSERT INTO persona (id,nombre,edad) VALUES (?,?,?)";
        PreparedStatement ps= conn.prepareStatement(insert);
        //seteamos los valores que va a utilizar
        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setInt(3, years);
        ps.executeUpdate();
        ps.close();
        conn.commit();
    }

    private static void createTables(Connection conn) throws SQLException {
        String table = "CREATE TABLE persona(" +
                "id INT, " +
                "nombre VARCHAR(500),"+
                "edad INT," +
                "PRIMARY KEY(id))";
        conn.prepareStatement(table).execute();
        conn.commit();
    }
}