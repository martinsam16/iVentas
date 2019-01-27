package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import modelo.ProductoM;

public class ProductoD extends Conexion {

    public void accionProducto(ProductoM producto, String tipoDeAccion) throws Exception {
        try {
            String sql = "CALL ACCIONPRODUCTO(?,?,?,?,?,?)";
            PreparedStatement ps = this.conectar().prepareCall(sql);
            ps.setString(1, producto.getNompro());
            ps.setString(2, producto.getNommod());
            ps.setString(3, producto.getSerpro());
            ps.setDouble(4, producto.getPrepo());
            ps.setString(5, producto.getUrlimgpro());
            ps.setString(6, tipoDeAccion);
            ps.executeQuery();
            ps.close();
            this.desconectar();
        } catch (Exception e) {
            System.out.println("Error AccPro() productoD" + e.getMessage());
        }
    }

    public void accionMarca(ProductoM producto,String nommarmod, String tipAc) throws Exception {
        try {
            String sql = "CALL ACCIONMARCA(?,?,?)";
            PreparedStatement ps = this.conectar().prepareCall(sql);
            ps.setString(1, producto.getNommar());
            ps.setString(2, nommarmod);
            ps.setString(3, tipAc);
            ps.executeQuery();
            ps.close();
            this.desconectar();
        } catch (Exception e) {
        }
    }

    public void accionModelo(ProductoM producto, String nommod ,String tipAc) throws Exception {
        try {
            String sql = "CALL ACCIONMODELO(?,?,?,?)";
            PreparedStatement ps = this.conectar().prepareCall(sql);
            ps.setString(1, producto.getNommar());
            ps.setString(2, producto.getNommod());
            ps.setString(3, nommod);
            ps.setString(4, tipAc);
            ps.executeQuery();
            ps.close();
            this.desconectar();
        } catch (Exception e) {
            System.out.println("Error accionModelo" + e.getMessage());
        }
    }


    public DefaultTableModel listarPro() throws Exception {
        DefaultTableModel tblTemp = null;
        try {
            String sql = "SELECT PRODUCTO.CODPRO, PRODUCTO.NOMPRO, MARCA.NOMMAR, MODELO.NOMMOD, PRODUCTO.SERPRO, PRODUCTO.PREPRO, PRODUCTO.URLIMGPRO FROM PRODUCTO INNER JOIN MODELO ON PRODUCTO.MODELO_CODMOD = MODELO.CODMOD INNER JOIN MARCA ON MODELO.MARCA_CODMAR = MARCA.CODMAR";
            String clms = "CÓDIGO,NOMBRE,MARCA,MODELO,SERIE,PRECIO,URLIMG";

            tblTemp = new DefaultTableModel(null, clms.split(","));
            Statement s = this.conectar().prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);
            String dts[] = new String[clms.split(",").length];

            while (rs.next()) {
                for (int i = 0; i < dts.length; i++) {
                    dts[i] = rs.getString(i + 1);
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
