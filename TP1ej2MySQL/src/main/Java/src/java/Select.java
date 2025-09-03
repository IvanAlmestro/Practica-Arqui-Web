package src.java;

import java.sql.*;

public class Select {
    public static void main(String[] args) {
        String driver = "com.mysql.cj.jdbc.Driver";
        try {
            //Cargo el driver
            Class.forName(driver).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            //si falla salgo del programa
            System.exit(1);
        }
        // creo la uri donde esta la base de datos
        String uri = "jdbc:mysql://localhost:3307/mi_base";
        try {
            //creo la conexion
            Connection conn = DriverManager.getConnection(uri, "root", "1234");
            conn.setAutoCommit(false);
            String select = "SELECT * FROM persona";
            PreparedStatement ps= conn.prepareStatement(select);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                System.out.println(rs.getInt("id")+" "+rs.getString("nombre")+" "+rs.getInt("edad"));
            }
            conn.close();
            System.out.println("Conexion a base de datos realizada");

        } catch (SQLException e) {
            e.printStackTrace();
            //si falla salgo del programa
            System.exit(1);
        }

    }

}