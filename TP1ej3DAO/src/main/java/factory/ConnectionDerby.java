package factory;


import lombok.Getter;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public final class ConnectionDerby {
    //metodo estatico para obtener la instancia unica (singleton) osea una sola coneccion y no haya problemas al hacer consultas SQL.
    //VOLATILE ES PARA QUE LA INSTANCIA SEA VISIBLE PARA TODOS LOS HILOS , Y NO SE CREE MAS DE UNA VEZ
    @Getter
    private static volatile ConnectionDerby instance;
    private Connection conn;

    private static final String URL = "jdbc:derby:mi_base;create=true";
    //constructor privado
    private ConnectionDerby(){
        String driver = "org.apache.derby.jdbc.EmbeddedDriver";
        try {
            // Cargo el driver
            Class.forName(driver).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        try {
            // Guardo en el atributo de la clase
            this.conn = DriverManager.getConnection(URL);
            this.conn.setAutoCommit(false);
            System.out.println("Conexión a base de datos realizada");
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
    public static ConnectionDerby getInstance() {
        if (instance == null) {
            synchronized (ConnectionDerby.class) {
                if (instance == null) {
                    instance = new ConnectionDerby();
                }
            }
        }
        return instance;
    }
    //metodo para obtener la conexion
    public Connection getConnection(){
        return this.conn;
    }


    public Statement createStatement() {
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return stmt;
    }

    public PreparedStatement prepareStatement(String sql) {
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return pstmt;
    }
}