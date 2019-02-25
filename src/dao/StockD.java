package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import modelo.StockM;

/**
 *
 * @author Martín Alexis Samán Arata
 */
public class StockD extends Conexion {
    
    public void accionInOut(StockM stock) throws Exception {
        String sql = "INSERT INTO STOCK  (PRODUCTO_CODPRO_PROSTK, INPSTK, OUTSTK, FECINP, FECOUT) VALUES (?,?,?,?,?)";
        
        PreparedStatement ps = this.conectar().prepareStatement(sql);
        ps.setInt(1, stock.getCodigoProducto());
        ps.setInt(2, stock.getCantidadEntrada());
        ps.setInt(3, stock.getCantidadSalida());
        ps.setString(4, stock.getFechaEntrada());
        ps.setString(5, stock.getFechaSalida());
        ps.executeUpdate();
        ps.close();
        this.desconectar();
        
    }
    
    public DefaultTableModel listarStock() throws Exception {
        DefaultTableModel tblTemp = null;
        try {
            
            String sql = "SELECT STOCK.INPSTK, STOCK.FECINP, STOCK.OUTSTK, STOCK.FECOUT FROM STOCK";
            
            String clms = "ENTRADA,FECHA ENTRADA,SALIDA,FECHA SALIDA";
            
            tblTemp = new DefaultTableModel(null, clms.split(","));
            Statement s = this.conectar().prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);
            String dts[] = new String[clms.split(",").length];
            
            while (rs.next()) {
                for (int i = 0; i < dts.length; i++) {
                    dts[i] = String.valueOf(rs.getObject(i + 1));
                }
                tblTemp.addRow(dts);
            }
            s.close();
            rs.close();
            this.desconectar();
        } catch (Exception e) {
        }
        
        return tblTemp;
    }
    
}
