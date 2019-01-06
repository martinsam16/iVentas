package servicios;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class BackupDb {
//     Recordar Optimizar!!

    public static void respaldar() {
        try {
            /*
        MySQL tiene que estar agregado al path, sino alv :,v
        mysql -u "usuario" -p"contraseña" nombre-de-la-base-de-datos < ubicacion-y-nombre-del-respaldo.sql
             */
            Process comando = Runtime.getRuntime().exec("mysqldump -u root -proot sistcomp");
            new HiloLectorCatchSql(comando.getErrorStream()).start();
            InputStream is = comando.getInputStream();
            FileOutputStream salida = new FileOutputStream("iVentas.sql");
            byte[] buffer = new byte[1000];

            int bytesLeidos = is.read(buffer);
            while (bytesLeidos > 0) {
                salida.write(buffer, 0, bytesLeidos);
                bytesLeidos = is.read(buffer);
            }

            salida.close();
        } catch (Exception e) {
        }

    }

    public static void restaurar() {
        try {
            Process comando = Runtime.getRuntime().exec("mysql -u root -proot sistcomp");
            new HiloLectorCatchSql(comando.getErrorStream()).start();
            OutputStream os = comando.getOutputStream();
            FileInputStream entrada = new FileInputStream("iVentas.sql");
            byte[] buffer = new byte[1000];

            int bytesLeidos = entrada.read(buffer);
            while (bytesLeidos > 0) {
                os.write(buffer, 0, bytesLeidos);
                bytesLeidos = entrada.read(buffer);
            }

            os.flush();
            os.close();
            entrada.close();
        } catch (Exception e) {
        }

    }
}
