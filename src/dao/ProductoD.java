package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import modelo.ProductoM;

public class ProductoD extends Conexion {

    public void accionProducto(ProductoM producto, char tipoDeAccion) throws Exception {
        try {
            String sql = null;
            switch (tipoDeAccion) {
                case '1':
                    sql = "INSERT INTO PRODUCTO (NOMPRO, MODELO_CODMOD_MODPRO, SERPRO, PREPRO, URLIMGPRO, ATRIBPRO, ESTPRO, FECGARPRO, PERSONA_CODPER_PROVPRO) VALUES (?,?,?,?,?,?,?,?,?)";
                    break;
                case '2':
                    sql = "UPDATE PRODUCTO SET NOMPRO=?, MODELO_CODMOD_MODPRO=?, SERPRO=?, PREPRO=?, URLIMGPRO=?, ATRIBPRO=?, ESTPRO=?, FECGARPRO=?, PERSONA_CODPER_PROVPRO=? WHERE SERPRO ='" + producto.getSerpro() + "'";
                    break;
                case '3':
                    sql = "DELETE FROM PRODUCTO WHERE PRODUCTO.SERPRO = '"+producto.getSerpro()+"'";
                    break;
            }
            PreparedStatement ps = this.conectar().prepareStatement(sql);

            if (tipoDeAccion != '3') {
                ps.setString(1, producto.getNompro());
                ps.setInt(2, devolverCodigos('2', producto));
                ps.setString(3, producto.getSerpro());
                ps.setDouble(4, producto.getPrepo());
                ps.setString(5, producto.getUrlimgpro());
                ps.setString(6, producto.getDespro());
                ps.setString(7, producto.getEstpro());
                ps.setString(8, producto.getFecgarpro());
                ps.setInt(9, devolverCodigos('3', producto));
            }

            ps.executeUpdate();
            ps.close();
            this.desconectar();
        } catch (Exception e) {
            System.out.println("Error AccPro() productoD" + e.getMessage());
        }
    }

    public void accionMarca(ProductoM producto, String nombreDeMarcaModificado, char tipoDeAccion) throws Exception {
        try {
            String sql = null;
            switch (tipoDeAccion) {
                case '1':
                    sql = "INSERT INTO MARCA (NOMMAR) VALUES (?)";
                    break;
                case '2':
                    sql = "UPDATE MARCA SET NOMMAR = '" + nombreDeMarcaModificado + "' WHERE NOMMAR = ?";
                    break;
//                case '3':
//                    sql = "DELETE FROM MARCA WHERE NOMMAR = ?";
//                    break;
            }

            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, producto.getNommar());

            ps.executeUpdate();
            ps.close();
            this.desconectar();
        } catch (Exception e) {
        }
    }

    public void accionModelo(ProductoM producto, String nombreDeModeloMofificado, char tipoDeAccion) throws Exception {
        try {
            String sql = null;
            switch (tipoDeAccion) {
                case '1':
                    sql = "INSERT INTO MODELO (NOMMOD, MARCA_CODMAR_MARMOD) VALUES ('" + producto.getNommod() + "', '" + devolverCodigos('1', producto) + "')";
                    break;
                case '2':
                    sql = "UPDATE MODELO SET NOMMOD = '" + nombreDeModeloMofificado + "' WHERE NOMMOD = '" + producto.getNommod() + "'";
                    break;
            }
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.executeUpdate();
            ps.close();
            this.desconectar();
        } catch (Exception e) {
            System.out.println("Error accionModelo" + e.getMessage());
        }
    }

    public int devolverCodigos(char tipo, ProductoM producto) {
        try {
            /*
             1 Marca
             2 Modelo
             3 Proveedor
             */
            int cod = 0;
            String sql = null;
            switch (tipo) {
                case '1':
                    sql = "SELECT CODMAR FROM MARCA WHERE NOMMAR= '" + producto.getNommar() + "'";
                    break;
                case '2':
                    sql = "SELECT CODMOD FROM MODELO WHERE NOMMOD='" + producto.getNommod() + "'";
                    break;
                case '3':
                    sql = "SELECT CODPER FROM PERSONA WHERE NOMPER='" + producto.getNomprov()+ "'";
                    break;
            }
            Statement s = this.conectar().prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                cod = Integer.valueOf(rs.getString(1));
            }
            return cod;
        } catch (Exception e) {
            return 0;
        }
    }

    public DefaultTableModel listarPro() throws Exception {
        DefaultTableModel tblTemp = null;
        try {
            String sql = "SELECT PRODUCTO.CODPRO, PRODUCTO.NOMPRO, MARCA.NOMMAR, MODELO.NOMMOD, PRODUCTO.SERPRO, PRODUCTO.PREPRO, PRODUCTO.URLIMGPRO, PRODUCTO.ATRIBPRO, PERSONA.NOMPER, PRODUCTO.FECGARPRO FROM MODELO INNER JOIN PRODUCTO ON PRODUCTO.MODELO_CODMOD_MODPRO = MODELO.CODMOD INNER JOIN MARCA ON MODELO.MARCA_CODMAR_MARMOD = MARCA.CODMAR INNER JOIN PERSONA ON PRODUCTO.PERSONA_CODPER_PROVPRO = PERSONA.CODPER";
            
            String clms = "CÓDIGO,NOMBRE,MARCA,MODELO,SERIE,PRECIO,URLIMG,ATRIB,PROVEEDOR,GAR";

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
            System.out.println("Error listar Productos Dao"+e.getMessage());
        }
        return tblTemp;
    }

}
