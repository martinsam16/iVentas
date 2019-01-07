package servicios;
import dao.Conexion;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class ReporteS extends Conexion{
    public void generarReporteProductos(){
        try {
            JasperReport reporte= null;
            String path = "src\\reportes\\ProductoR.jasper";
            /*
            //Para hacer filtro xd, el null de fill report cambiamos :v
            Map parametro = new HashMap();
            parametro.put("nommarca", "dell");
            */
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jprint = JasperFillManager.fillReport(reporte, null, conectar());
            desconectar();
            
            JasperViewer view = new JasperViewer(jprint,false);
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            view.setVisible(true);
        } catch (Exception e) {
            System.out.println("error reporteProductos R " + e.getMessage());
        }
    }
    
     public static void generarCotizacionProductos(){
        
    }
    
    /*Jasper is rial, ademàs se puede desde table.print() :v*/
//      public void toPdfFromTable(JTable tabla, String titulo) throws Exception {
//        Document document = new Document();
//        try {
//
//            PdfWriter writer;
//            writer = PdfWriter.getInstance(document, new FileOutputStream(titulo + ".pdf"));
//            document.open();
//            
//            document.addTitle(titulo);
//            document.addAuthor("Martín Alexis Samán Arata");
//           
//            document.setPageSize(PageSize.A4.rotate());
//            document.newPage();
//
//            PdfPTable tblTemp = new PdfPTable(tabla.getColumnCount());
//            PdfPCell columnHeader;
//
//            for (int column = 0; column < tabla.getColumnCount(); column++) {
//                columnHeader = new PdfPCell(new Phrase(tabla.getColumnName(column)));
//                columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
//                tblTemp.addCell(columnHeader);
//            }
//            tblTemp.setHeaderRows(1);
//            for (int row = 0; row < tabla.getRowCount(); row++) {
//                for (int column = 0; column < tabla.getColumnCount(); column++) {
//                    tblTemp.addCell(tabla.getValueAt(row, column).toString());
//                }
//            }
//
//            document.add(tblTemp);
//            tabla.print();
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage() + e.getCause());
//        }
//        document.close();
//
//    }
      
   
    
}
