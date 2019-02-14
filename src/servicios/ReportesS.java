package servicios;

import dao.Conexion;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 * Servicio para los Reportes
 *
 * @author Martín Alexis Samán Arata
 * @version 0.0.1
 */


public class ReportesS extends Conexion {

    /**
     * Genera los reportes a partir del package reportes
     *
     * @param tipo char: '0': Productos '1': Boleta
     * @param codigo int Código
     */
    public static void generarReportes(char tipo, int codigo) {
        try {
            JasperReport reporte = null;
            String path = "reportes/";
            Map parametros = new HashMap();
            switch (tipo) {
                case '0'://Productos
                    path += "ProductosR";
                    break;
                case '1':
                    path += "BoletaR";
                    parametros.put("codigoVenta", codigo);
                    break;
            }
            path += ".jasper";
            /*
             //Para hacer filtro xd, el null de fill report cambiamos :v
             Map parametro = new HashMap();
             parametro.put("nommarca", "dell");
             */
            reporte = (JasperReport) JRLoader.loadObject(new InputStream() {

                @Override
                public int read() throws IOException {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            }.getClass().getClassLoader().getResource(path));
            JasperPrint jprint = JasperFillManager.fillReport(reporte, parametros, conectar());
            desconectar();
            
            JasperViewer view = new JasperViewer(jprint, false);
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            view.setVisible(true);
        } catch (Exception e) {
            System.out.println("error reporteProductos R " + e.getMessage());
        }

    }
}
