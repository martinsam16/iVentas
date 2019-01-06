package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion{
    protected static Connection conexion = null;
    
    public static Connection conectar() throws Exception{
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/sistcomp";
        String usr = "root";
        String passw ="root";
        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(url,usr,passw);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("error conectar()" + e.getMessage());
        }
        return conexion;
    }
    
    public static boolean estado() throws Exception{
        boolean est = false;
        try {
            if (!conexion.isClosed()) {
                est = true;
            }
        } catch (SQLException e) {
            System.out.println("error estado()"+e.getMessage());
        }
        return est;
    }
    
    public static void desconectar() throws Exception{
        try {
            if (conexion!=null) {
                conexion.close();                
            }
        } catch (SQLException e) {
            System.out.println("Error desconectar"+e.getMessage());
        }
    }
}
