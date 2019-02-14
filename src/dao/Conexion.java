package dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Clase que permite conectar con una Base De Datos
 *
 * @version 0.0.1
 * @author Martín Alexis Samán Arata
 */
public class Conexion {

    protected static Connection conexion = null;
    protected final static Properties PROPIEDADES = new Properties();

    /**
     * Conecta con una Base De Datos a partir de un archivo properties
     *
     * @return
     * @throws ClassNotFoundException | SQLException | IOException
     */
    public static Connection conectar() throws Exception {
        try {
            PROPIEDADES.load(new InputStream() {
                @Override
                public int read() throws IOException {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            }.getClass().getClassLoader().getResourceAsStream("propiedades/db.properties"));
            Class.forName(PROPIEDADES.getProperty("db.driver"));
            conexion = DriverManager.getConnection(PROPIEDADES.getProperty("db.url"), PROPIEDADES.getProperty("db.user"), PROPIEDADES.getProperty("db.pssw"));
        } catch (ClassNotFoundException | SQLException | IOException e) {
            System.out.println("error conectar()" + e.getMessage());
        }
        return conexion;
    }

    /**
     * Verifica el estado de la Conexion
     *
     * @return boolean true: conectado, false desconectado
     * @throws Exception
     */
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

    /**
     * Desconecta la Base De Datos
     *
     * @throws java.sql.SQLException
     */
    public static void desconectar() throws SQLException {
        try {
            if (conexion != null) {
                conexion.close();
            }
        } catch (SQLException e) {
            System.out.println("Error desconectar" + e.getMessage());
        }
    }
}
