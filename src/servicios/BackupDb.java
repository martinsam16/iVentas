package servicios;

import com.intenum.jdbc.backup.Backup;
import dao.Conexion;
import java.io.PrintStream;
import java.sql.SQLException;

/**
 * Backup y Restauración de una Base de Datos: MySql tiene que estar en el path
 *
 * @version 0.0.1
 * @author Martín Alexis Samán Arata
 */
public class BackupDb extends Conexion {

    public void backup() throws SQLException, Exception {
        try {
            Backup bu = new Backup(conectar());
            bu.execute(new PrintStream("backup.sql"));
        } catch (Exception e) {
            System.out.println(e.getMessage() + e.getCause());
        }
    }
}
