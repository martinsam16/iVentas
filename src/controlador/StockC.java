package controlador;

import dao.ProductoD;
import dao.StockD;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;
import modelo.StockM;
import modelo.VentaDetalleM;
import static vista.ProductoV.inptCantidad;
import static vista.ProductoV.inptCodPro;
import static vista.ProductoV.inptFechaIn;

/**
 *
 * @author Martín Alexis Samán Arata
 */
public class StockC {

    StockD daoS = new StockD();
    StockM stock = new StockM();
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    ProductoD gg = new ProductoD();
   

    public DefaultTableModel listarStock() {
        try {
            return daoS.listarStock();
        } catch (Exception e) {
            return null;
        }
    }

    public void limpiarStock() {
        inptCantidad.setValue(1);
        stock.clear();
    }

    public void variablesMStock() {        
        stock.setCodigoProducto(Integer.valueOf(inptCodPro.getText()));
        stock.setCantidadEntrada(Integer.valueOf(inptCantidad.getValue().toString()));
        stock.setFechaEntrada(df.format(inptFechaIn.getDate()));

    }
    
     public void variablesMStock(VentaDetalleM detalleVenta, String fecha) {    
         stock.setCodigoProducto(detalleVenta.getCodigoProducto());
         stock.setCantidadSalida(detalleVenta.getCantidadProducto());
         stock.setFechaSalida(fecha);
     }
    
    

    public void registrarStockIn() throws Exception {
        variablesMStock();
        daoS.accionInOut(stock);
        //cambiar estado producto a Activo
        gg.cambiarEstadoProducto(stock.getCodigoProducto(), "A");
        limpiarStock();
    }
    
    public void registrarStockOut(VentaDetalleM detalleVenta, Date fecha) throws Exception{
        variablesMStock(detalleVenta, df.format(fecha));
        daoS.accionInOut(stock);
       stock.clear();
    }


}
