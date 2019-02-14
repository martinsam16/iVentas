package servicios;

import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class TablasS {
    
    /**
     * Sirve para filtar datos en un JTable
     * @param consulta String Lo que se quiere buscar
     * @param tbl JTable Tabla en donde se quiere buscar
     * @param mayus char '0': .toUpperCase '1': crudo
     */
    public static void buscar(String consulta, JTable tbl,char mayus) {
        try {
            DefaultTableModel dm = (DefaultTableModel) tbl.getModel();            
            TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(dm);
            tbl.setRowSorter(tr);
            switch(mayus){
                case '0':
                    tr.setRowFilter(RowFilter.regexFilter(consulta.toUpperCase()));
                    break;
                case '1':
                    tr.setRowFilter(RowFilter.regexFilter(consulta));
                    break;
            }
            
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
            System.out.println(e.getMessage());
        }
        System.out.println("Datos: "+datos);
        return datos;

    }
}
