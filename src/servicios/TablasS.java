package servicios;

import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class TablasS {

    public static void buscar(String consulta, JTable tbl) {
        try {
            DefaultTableModel dm = (DefaultTableModel) tbl.getModel();
            TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(dm);
            tbl.setRowSorter(tr);
            tr.setRowFilter(RowFilter.regexFilter(consulta));
        } catch (Exception e) {
            System.out.println("Error buscar() s");
            return;
        }
    }

    public static String devolverCamposDeFila(JTable tbl) {
        String datos = "";
        try {
            int fila = tbl.getSelectedRow();
            if (fila == -1) {
                return null;

            } else {

                for (int i = 0; i < tbl.getColumnCount(); i++) {
                    datos += String.valueOf(tbl.getValueAt(fila, i)) + "^";
                }
                datos = datos.substring(0, datos.length() - 1);
            }

        } catch (Exception e) {
            System.out.println(e.getCause() + e.getMessage());
        }
        return datos;

    }
}
