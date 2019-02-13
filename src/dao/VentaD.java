package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import modelo.VentaDetalleM;
import modelo.VentaM;
/**
 * Permite realizar una Venta
 * Tablas: Venta, Venta_Detalle
 * 
 * @author Martín Alexis Samán Arata
 * @version 0.0.1
 */
public class VentaD extends Conexion {
    
    public void accionVenta(VentaM venta, char tipoDeAccion) {
        try {
            String sql = null;
            switch (tipoDeAccion) {
                case '1':
                    sql = "INSERT INTO VENTA (CODPER_VENVEN, FECVEN, HOVEN, TIPVEN, CODPER_COMVEN) VALUES (?,?,?,?,?)";
                    break;
            }
            
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            
            ps.setInt(1, devolverCodigos(venta.getDocumentoVendedor(), '1'));
            ps.setDate(2, venta.getFechaVenta());
            ps.setTime(3, venta.getHoraVenta());
            ps.setString(4, venta.getTipoVenta());
            ps.setInt(5, devolverCodigos(venta.getDocumentoComprador(), '1'));
            
            ps.executeUpdate();
            ps.close();
            this.desconectar();
            
        } catch (Exception e) {
            System.out.println("Error accionVenta D " + e.getMessage());
        }
    }
    
    public void accionVentaDetalle(int codigoVentaPerteneciente, VentaDetalleM detalle, char tipoDeAccion) {
        try {
            String sql = null;
            
            switch (tipoDeAccion) {
                case '1':
                    sql = "INSERT INTO VENTA_DETALLE (VENTA_CODVEN_VENVEN, PRODUCTO_CODPRO_PROVEN, CANTPROVEN, DSCPROVEN, ESTVEN) VALUES (?,?,?,?,?)";
                    break;
            }
            
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, codigoVentaPerteneciente);
            ps.setInt(2, detalle.getCodigoProducto());
            ps.setInt(3, detalle.getCantidadProducto());
            ps.setDouble(4, detalle.getDescuentoProducto());
            ps.setString(5, detalle.getEstadoVenta());
            
            ps.executeUpdate();
            ps.close();
            this.desconectar();
            
        } catch (Exception e) {
            System.out.println("Error accionVentaDetalle " + e.getMessage());
        }
    }
    
    public DefaultTableModel llenarTbl() throws Exception {
        /*
         Productos xd
         */
        DefaultTableModel tblTemp = null;
        try {
            String sql = "SELECT PRODUCTO.CODPRO, PRODUCTO.NOMPRO, MARCA.NOMMAR, MODELO.NOMMOD, PRODUCTO.SERPRO, PRODUCTO.FECGARPRO, PRODUCTO.PREPRO FROM MODELO INNER JOIN PRODUCTO ON PRODUCTO.MODELO_CODMOD_MODPRO = MODELO.CODMOD INNER JOIN MARCA ON MODELO.MARCA_CODMAR_MARMOD = MARCA.CODMAR";
            
            String clms = "CÓDIGO,NOMBRE,MARCA,MODELO,SERIE,GAR,PRECIO,DSC,TOTAl_UNITARIO,CANTIDAD,IGV,TOTAL,SELEC";
            
            tblTemp = new DefaultTableModel(null, clms.split(","));
            Statement s = this.conectar().prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);
            Object dts[] = new Object[clms.split(",").length];
            
            while (rs.next()) {
                for (int i = 0; i < dts.length; i++) {
                    if (i <= 6) {
                        dts[i] = rs.getString(i + 1);
                    } else if (i == 7) {//DEscuento
                        dts[i] = 0.0;
                    } else if (i == 8) {//Total_uni
                        dts[i] = dts[6];
                    } else if (i == 9) {//cantidad                        
                        dts[i] = 0;
                    } else if (i == 10) {//igv
                        dts[i] = 0.18;
                    } else if (i == 11) {//total
                        dts[i] = 0.0;
                    } else if (i == 12) {//check
                        dts[i] = false;
                    }
                }
                tblTemp.addRow(dts);
            }
            s.close();
            rs.close();
            this.desconectar();
            
        } catch (Exception e) {
            System.out.println("Error listar Productos Dao" + e.getMessage());
        }
        return tblTemp;
    }
    
    public DefaultTableModel llenarTbl(char tipo, int codigoVenta) throws Exception {
        /*
         1   Venta
         2   DetalleVenta
         */
        DefaultTableModel tblTemp = null;
        try {
            String sql = null;
            String clms = null;
            switch (tipo) {
                case '1':
                    sql = "SELECT VENTA.CODVEN, PERSONA.NOMPER as vendedor, PERSONA1.NOMPER as comprador, VENTA.FECVEN, VENTA.HOVEN, VENTA.TIPVEN FROM VENTA INNER JOIN PERSONA ON VENTA.CODPER_VENVEN = PERSONA.CODPER INNER JOIN PERSONA AS PERSONA1 ON VENTA.CODPER_COMVEN = PERSONA1.CODPER ORDER BY VENTA.CODVEN ASC";
                    clms = "CODVEN,VENDEDOR,COMPRADOR,FECHA,HORA,TIPO";
                    break;
                case '2':
                    sql = "SELECT VENTA_DETALLE.CODDETVEN, PRODUCTO.NOMPRO, VENTA_DETALLE.CANTPROVEN, PRODUCTO.PREPRO, VENTA_DETALLE.DSCPROVEN, VENTA_DETALLE.ESTVEN FROM VENTA_DETALLE INNER JOIN PRODUCTO ON VENTA_DETALLE.PRODUCTO_CODPRO_PROVEN= PRODUCTO.CODPRO WHERE VENTA_DETALLE.VENTA_CODVEN_VENVEN = " + codigoVenta + " ORDER BY VENTA_DETALLE.CODDETVEN ASC";
                    clms = "CodDetVen,Producto,Cantidad,Precio,Descuento,Estado";
                    break;
            }
            
            tblTemp = new DefaultTableModel(null, clms.split(","));
            Statement s = this.conectar().prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);
            Object dts[] = new Object[clms.split(",").length];
            
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
            System.out.println("Error listar Productos Dao" + e.getMessage());
        }
        return tblTemp;
    }
    
    public int devolverCodigos(String documento, char tipo) {
        try {
            /*
             1 Persona
             2 Venta
             */
            int cod = 0;
            String sql = null;
            
            switch (tipo) {
                case '1':
                    sql = "SELECT CODPER FROM PERSONA WHERE DOCPER= '" + documento + "'";
                    break;
                case '2':
                    sql = "SELECT CODVEN FROM VENTA ORDER BY CODVEN ASC";//Para futuras referencias poner que se ordenen ascendentemente :,v
                    break;
            }
            
            Statement s = this.conectar().prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                cod = Integer.valueOf(rs.getString(1));
            }
            this.desconectar();
            return cod;
        } catch (Exception e) {
            System.out.println("Error devolverCodigos VentaD " + e.getMessage());
            return 0;
        }
    }
}
