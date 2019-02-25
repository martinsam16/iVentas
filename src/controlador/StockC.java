package controlador;

import dao.StockD;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;
import modelo.StockM;
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
    
    public DefaultTableModel listarStock(){
        try {
            return daoS.listarStock();
        } catch (Exception e) {
            return null;
        }
    }
    
    public void limpiarStock(){
        inptCantidad.setValue(1);
        stock.clear();
    }
    
    public void variablesMStock(){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        stock.setCodigoProducto(Integer.valueOf(inptCodPro.getText().toString()));
        stock.setCantidadEntrada(Integer.valueOf(inptCantidad.getValue().toString()));
        stock.setFechaEntrada(df.format(inptFechaIn.getDate()));
    }
    
    public void registrarStockIn() throws Exception{
        variablesMStock();
        daoS.accionInOut(stock);
        limpiarStock();
    }
    
}
