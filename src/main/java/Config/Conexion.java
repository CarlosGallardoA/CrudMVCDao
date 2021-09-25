package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    Connection conn;
    public Conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ventas2021","root","1234");
        }catch (ClassNotFoundException e1){
            System.out.println("Error en el driver de conexion");
        }catch (SQLException e2){
            System.out.println("Error en la consulta");
        }
    }
    public Connection getConnection(){
        return conn;
    }
}
