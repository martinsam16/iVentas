package dao;

import java.sql.PreparedStatement;
import modelo.EntradaSalidaM;

public class EntradaSalidaD extends Conexion {

    public void accionEntradaSalida(EntradaSalidaM inventario, char tipo) {
        try {
            String sql = null;
            switch (tipo) {
                case '1':
                    sql = "INSERT INTO ENTRADASALIDA (PRODUCTO_CODPRO, CNTEN, FECEN, CNTSA, FECSA, STOCK) VALUES (?,?,?,?,?,?)";
                    break;
            }
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, inventario.getCodigoProducto());
            ps.setInt(2, inventario.getCantidadEntrada());
            ps.setDate(3, inventario.getFechaEntrada());
            ps.setInt(4, inventario.getCantidadSalida());
            ps.setDate(5, inventario.getFechaSalida());

            ps.executeUpdate();
            ps.close();
            this.desconectar();

        } catch (Exception e) {
            System.out.println("Error accionEntradaSalida " + e.getMessage());
        }
    }
}
