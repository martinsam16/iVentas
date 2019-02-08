package controlador;

import dao.VentaD;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import modelo.VentaDetalleM;
import modelo.VentaM;
import servicios.CombosAnidados;
import servicios.TablasS;
import static vista.VentaV.comboDocumentoComprador;
import static vista.VentaV.comboDocumentoVendedor;
import static vista.VentaV.tblProdVen;
import static vista.VentaV.tblVentas;

public class VentaC extends JTable {

    VentaD dao = new VentaD();
    VentaM venta = new VentaM();
    VentaDetalleM detalleVenta = new VentaDetalleM();

    public void accionVenta(char tipoDeAccion) {
        try {
            dao.accionVenta(venta, tipoDeAccion);
        } catch (Exception e) {
        }
    }

    public DefaultComboBoxModel llenarComboPersonas(char tipo) {
        try {
            /*
             8   Documento Vendedores
             9   Documento Clientes y Empresas
             */
            servicios.CombosAnidados combo = new CombosAnidados();
            return combo.listarCombo(tipo, null);
        } catch (Exception e) {
            System.out.println("llenarComboPersonas " + e.getMessage());
        }
        return null;
    }

    public void accionDetalleVenta(char tipoDeAccion) {
        try {
            dao.accionVentaDetalle(venta.getCodigoVenta(), detalleVenta, tipoDeAccion);
        } catch (Exception e) {
        }
    }

    public void cargarVariablesVentaM() {
        venta.setHoraVenta(Time.valueOf(LocalTime.now()));
        venta.setFechaVenta(Date.valueOf(LocalDate.now().toString()));

        venta.setDocumentoComprador(comboDocumentoComprador.getSelectedItem().toString());
        venta.setDocumentoVendedor(comboDocumentoVendedor.getSelectedItem().toString());

        if (comboDocumentoComprador.getSelectedItem().toString().length() == 8) {
            venta.setTipoVenta("B");
        } else {
            venta.setTipoVenta("F");
        }
    }

    public void buscador(String consulta) {
        if (consulta != null || !"".equals(consulta) || !consulta.isEmpty()) {
            TablasS.buscar(consulta, tblProdVen, '0');
        }
    }

    public void cargarVariablesRegistrarDetalleM() {
        TablasS.buscar("true", tblProdVen, '1');
        tblProdVen.repaint();

        if (tblProdVen.getRowCount() > 0) {
            cargarVariablesVentaM();
            accionVenta('1');
            venta.setCodigoVenta(dao.devolverCodigos(null, '2'));

            for (int i = 0; i < tblProdVen.getRowCount(); i++) {
                //CÓDIGO,NOMBRE,MARCA,MODELO,SERIE,GAR,PRECIO,DSC,TOTAl_UNITARIO,CANTIDAD,IGV,TOTAL,SELEC
                detalleVenta.setCodigoProducto(Integer.valueOf(tblProdVen.getValueAt(i, 0).toString()));
                detalleVenta.setCantidadProducto(Integer.valueOf(tblProdVen.getValueAt(i, 9).toString()));
                detalleVenta.setDescuentoProducto(Double.valueOf(tblProdVen.getValueAt(i, 7).toString()));
                detalleVenta.setEstadoVenta("A");
                accionDetalleVenta('1');
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione almenos un producto! ._.");
        }

        TablasS.buscar("", tblProdVen, '1');
        tblProdVen.repaint();
    }

    public void llenarTblPoductos() {
        try {
            tblProdVen.setModel(dao.llenarTbl());

            TableColumn columnaTabla = tblProdVen.getColumnModel().getColumn(12);

            JCheckBox checkBox = new JCheckBox();
            columnaTabla.setCellEditor(new DefaultCellEditor(checkBox));

        } catch (Exception e) {
        }
    }

    public void actualizarTblVenta() {
        try {
            tblVentas.setModel(dao.llenarTbl('1', 0));
        } catch (Exception e) {
        }
    }

    public DefaultTableModel llenarTblVentas(char tipo, int codigoVenta) {
        try {
            return dao.llenarTbl(tipo, codigoVenta);
        } catch (Exception e) {
        }
        return null;
    }
}
