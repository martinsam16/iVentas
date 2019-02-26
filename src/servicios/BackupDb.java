package servicios;

import com.intenum.jdbc.backup.Backup;
import dao.Conexion;
import java.io.PrintStream;
import java.sql.SQLException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Backup y Restauración de una Base de Datos, independientes del tipo: basado
 * en el JDBC Driver
 *
 * @version 0.0.1
 * @author Martín Alexis Samán Arata
 */
public class BackupDb extends Conexion {

    public void backup() throws SQLException, Exception {
        try {           
            JFileChooser ruta = new JFileChooser(".");
            ruta.setDialogTitle("Guardar Backup de su Base de Datos");
            ruta.setFileFilter(new FileNameExtensionFilter("Archivos SQL (.sql)", "SQL"));
            ruta.showOpenDialog(ruta);
            
            Backup bu = new Backup(conectar());            
            bu.execute(new PrintStream(ruta.getSelectedFile().getAbsolutePath()+".sql"));
            JOptionPane.showMessageDialog(null, "Backup Exitoso!");
        } catch (Exception e) {
            System.err.println("[ERROR] backup, "+e.getMessage());
        }
    }
}
