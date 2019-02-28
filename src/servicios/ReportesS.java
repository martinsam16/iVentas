package servicios;

import dao.Conexion;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.TableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
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
     * @param tipo char: '0': Productos '1': Boleta '2':Factura
     * @param codigo int Código
     * @param tbl
     */
    public static void generarReportes(char tipo, int codigo, TableModel tbl) {
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
                case '2':
                    path += "FacturaR";
                    parametros.put("codigoVenta", codigo);
                    break;
                case '3':
                    path+="CotizacionR";                    
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
            JasperPrint jprint = null;
            
            if (tbl==null) {
                jprint = JasperFillManager.fillReport(reporte, parametros, conectar());
                 desconectar();
            }else{
                System.out.println("Cotizar");
                jprint = JasperFillManager.fillReport(reporte, new HashMap(), new JRTableModelDataSource(tbl));
            }            
           

            JasperViewer view = new JasperViewer(jprint, false);
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            view.setVisible(true);
        } catch (Exception e) {
            System.out.println("error reporteProductos R " + e.getMessage());
        }

    }
    
    
}
