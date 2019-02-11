package servicios;

import dao.Conexion;
import java.util.HashMap;
import java.util.Map;
;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;



public class ReportesS extends Conexion {

    public static void generarReportes(char tipo,int codigo) {
        try {
            JasperReport reporte = null;
            String path = "src/reportes/";
            Map parametros = new HashMap();
            switch (tipo) {
                case '0'://Productos
                    path += "ProductosR";
                    break;
                case '1':
                    path+="BoletaR";
                    parametros.put("codigoVenta", codigo);
                    break;
            }
            path+=".jasper";
            /*
             //Para hacer filtro xd, el null de fill report cambiamos :v
             Map parametro = new HashMap();
             parametro.put("nommarca", "dell");
             */
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jprint = JasperFillManager.fillReport(reporte,parametros, conectar());
            desconectar();

            JasperViewer view = new JasperViewer(jprint, false);
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            view.setVisible(true);
        } catch (Exception e) {
            System.out.println("error reporteProductos R " + e.getMessage());
        }

    }
}
