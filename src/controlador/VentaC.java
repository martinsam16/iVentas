package controlador;

import dao.VentaD;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import modelo.VentaM;
import vista.VentaV;

public class VentaC extends JTable {

    VentaD dao = new VentaD();
    VentaM venta = new VentaM();
    List<String> listaProductos = new ArrayList<>();

    public void accionVenta(char tipoDeAccion) {
        try {
            dao.accionVenta(venta, tipoDeAccion);
        } catch (Exception e) {
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 9;
    }

    public void llenarTblPoductos() {
        try {
            VentaV.tblProdVen.setModel(dao.llenarTblProductos());

            TableColumn columnaTabla = VentaV.tblProdVen.getColumnModel().getColumn(9);

            JCheckBox checkBox = new JCheckBox();

            checkBox.addActionListener((ActionEvent e) -> {
                if (checkBox.isSelected()) {
                    if (!listaProductos.contains(VentaV.tblProdVen.getValueAt(VentaV.tblProdVen.getSelectedRow(), 0).toString())) {
                        listaProductos.add(VentaV.tblProdVen.getValueAt(VentaV.tblProdVen.getSelectedRow(), 0).toString());                        
                    }

                } else {
                    listaProductos.remove(VentaV.tblProdVen.getValueAt(VentaV.tblProdVen.getSelectedRow(), 0).toString());
                }
                System.out.println(listaProductos);

            });

            columnaTabla.setCellEditor(new DefaultCellEditor(checkBox));

        } catch (Exception e) {
        }

    }
}
