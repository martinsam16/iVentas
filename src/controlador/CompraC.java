package controlador;

import dao.ProductoD;
import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import servicios.PonerImgLabel;
import static vista.CompraV.lblImagenProducto;
import static vista.CompraV.lblNombreProducto;
import static vista.CompraV.lblPrecioProducto;
import static vista.CompraV.tblDetTecnico;

/**
 *
 *
 * @author Martín Alexis Samán Arata
 * @version 0.0.1
 */
public class CompraC {

    ProductoD dao = new ProductoD();
    JTable tblTemporal = new JTable(dao.listarPro());
    int numeroFila = -1;
    int maximo = tblTemporal.getRowCount() - 1;


    public void accionBtns(char btn) {
        switch (btn) {
            case 'I':
                numeroFila--;
                if (numeroFila < 0) {
                    numeroFila = maximo;
                }
                break;
            case 'D':
                numeroFila++;
                if (numeroFila > maximo) {
                    numeroFila = 0;
                }
                break;
        }
        PonerImgLabel setImg = new PonerImgLabel("demo");
        setImg.link= tblTemporal.getValueAt(numeroFila, 6).toString();
        setImg.lbl=lblImagenProducto;
        setImg.start();
        listarProducto();
    }

    public void listarProducto() {
        try {
            //CÓDIGO,NOMBRE,MARCA,MODELO,SERIE,PRECIO,URLIMG,ATRIB,PROVEEDOR,GAR
            String clms = "MARCA,MODELO,ATRIBUTOS,GARANTIA";
            String dts[] = new String[clms.split(",").length];
            DefaultTableModel temporal = null;
            temporal = new DefaultTableModel(null, clms.split(","));

            //dts[0] = tblTemporal.getValueAt(numeroFila, 0).toString();
            dts[0] = tblTemporal.getValueAt(numeroFila, 2).toString();
            dts[1] = tblTemporal.getValueAt(numeroFila, 3).toString();
            dts[2] = tblTemporal.getValueAt(numeroFila, 7).toString();
            dts[3] = tblTemporal.getValueAt(numeroFila, 9).toString();

            temporal.addRow(dts);
            tblDetTecnico.setModel(temporal);
            temporal = null;
            lblNombreProducto.setText(tblTemporal.getValueAt(numeroFila, 1).toString());
            lblPrecioProducto.setText("S/. " + tblTemporal.getValueAt(numeroFila, 5).toString());

            tblDetTecnico.getColumn("ATRIBUTOS").setCellRenderer(new TextAreaRenderer());
            tblDetTecnico.getColumn("ATRIBUTOS").setCellEditor(new TextAreaEditor());
        } catch (Exception e) {
            System.out.println("error listarProducto CompraC " + e.getMessage());
        }
    }

}


class TextAreaRenderer extends JScrollPane implements TableCellRenderer {

    JTextArea textarea;

    public TextAreaRenderer() {
        textarea = new JTextArea();
        textarea.setLineWrap(true);
        textarea.setWrapStyleWord(true);
        //textarea.setBorder(new TitledBorder("This is a JTextArea"));
        getViewport().add(textarea);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus,
            int row, int column) {
        if (isSelected) {
            setForeground(table.getSelectionForeground());
            setBackground(table.getSelectionBackground());
            textarea.setForeground(table.getSelectionForeground());
            textarea.setBackground(table.getSelectionBackground());
        } else {
            setForeground(table.getForeground());
            setBackground(table.getBackground());
            textarea.setForeground(table.getForeground());
            textarea.setBackground(table.getBackground());
        }

        textarea.setText((String) value);
        textarea.setCaretPosition(0);
        return this;
    }
}

class TextAreaEditor extends DefaultCellEditor {

    protected JScrollPane scrollpane;
    protected JTextArea textarea;

    public TextAreaEditor() {
        super(new JCheckBox());
        scrollpane = new JScrollPane();
        textarea = new JTextArea();
        textarea.setLineWrap(true);
        textarea.setWrapStyleWord(true);
        //textarea.setBorder(new TitledBorder("This is a JTextArea"));
        scrollpane.getViewport().add(textarea);
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
        textarea.setText((String) value);

        return scrollpane;
    }

    @Override
    public Object getCellEditorValue() {
        return textarea.getText();
    }
}
