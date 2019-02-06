package controlador;

import dao.VentaD;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import modelo.VentaDetalleM;
import modelo.VentaM;
import servicios.TablasS;
import static vista.VentaV.tblProdVen;

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

    public void cargarVariablesRegistrarDetalleM() {
        TablasS.buscar("true", tblProdVen, '1');
        tblProdVen.repaint();
      
        venta.setHoraVenta(String.valueOf(Time.valueOf(LocalTime.now())));
        venta.setFechaVenta(String.valueOf(Date.valueOf(LocalDate.now().toString())));
        
        for (int i = 0; i < tblProdVen.getRowCount(); i++) {
            //CÓDIGO,NOMBRE,MARCA,MODELO,SERIE,GAR,PRECIO,DSC,TOTAl_UNITARIO,CANTIDAD,IGV,TOTAL,SELEC
            detalleVenta.setCodigoProducto(Integer.valueOf(tblProdVen.getValueAt(i, 0).toString()));
            detalleVenta.setCantidadProducto(Integer.valueOf(tblProdVen.getValueAt(i, 9).toString()));
            detalleVenta.setDescuentoProducto(Double.valueOf(tblProdVen.getValueAt(i, 7).toString()));
        }
        TablasS.buscar("", tblProdVen, '1');
        tblProdVen.repaint();
    }

    public void llenarTblPoductos() {
        try {
            tblProdVen.setModel(dao.llenarTblProductos());

            TableColumn columnaTabla = tblProdVen.getColumnModel().getColumn(12);

            JCheckBox checkBox = new JCheckBox();
            columnaTabla.setCellEditor(new DefaultCellEditor(checkBox));

        } catch (Exception e) {
        }

    }
}
