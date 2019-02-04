package dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexion {

    protected static Connection conexion = null;
    protected final static Properties PROPIEDADES = new Properties();

    public static Connection conectar() throws Exception {
        try {
            PROPIEDADES.load(new FileInputStream("db.properties"));
            Class.forName(PROPIEDADES.getProperty("db.driver"));
            conexion = DriverManager.getConnection(PROPIEDADES.getProperty("db.url"), PROPIEDADES.getProperty("db.user"), PROPIEDADES.getProperty("db.pssw"));
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("error conectar()" + e.getMessage());
        }
        return conexion;
    }

    public static boolean estado() throws Exception {
        boolean est = false;
        try {
            if (!conexion.isClosed()) {
                est = true;
            }
        } catch (SQLException e) {
            System.out.println("error estado()" + e.getMessage());
        }
        return est;
    }

    public static void desconectar() throws Exception {
        try {
            if (conexion != null) {
                conexion.close();
            }
        } catch (SQLException e) {
            System.out.println("Error desconectar" + e.getMessage());
        }
    }
}
