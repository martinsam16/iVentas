package controlador;

import dao.ProductoD;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import servicios.ConsultaGob;
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
public class CompraC extends ConsultaGob {

    ProductoD dao = new ProductoD();
    JTable tblTemporal = new JTable(dao.listarPro());
    int numeroFila = -1;

    public void accionBtns(char btn) {
        switch (btn) {
            case 'I':
                if (numeroFila >= 1) {
                    numeroFila--;
                } else {
                    numeroFila = tblTemporal.getRowCount();
                }
                listarProducto();
                break;
            case 'D':
                if (numeroFila < tblTemporal.getRowCount()) {
                    numeroFila++;
                } else {
                    numeroFila = 0;
                }
                listarProducto();
                break;
        }
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
            lblPrecioProducto.setText("S/. "+tblTemporal.getValueAt(numeroFila, 5).toString());
            lblImagenProducto.setIcon(
                    cargarImg(tblTemporal.getValueAt(numeroFila, 6).toString(), lblImagenProducto)
            );
        } catch (Exception e) {
            System.out.println("error listarProducto CompraC " + e.getMessage());
        }
    }

    public void listarFichaTecnica(String atributos) throws ParseException {
        JSONObject jsonAtributos = (JSONObject) parser.parse(atributos);

        for (int i = 0; i < jsonAtributos.size(); i++) {
            System.out.println(jsonAtributos.get(i));
        }
    }

    public Icon cargarImg(String link, JLabel lblImg) {
        try {
            Image img = null;
            URL url = new URL(link);
            ImageIcon imgIcon = new ImageIcon(ImageIO.read(url));
            Icon icono = new ImageIcon(imgIcon.getImage().getScaledInstance(lblImg.getWidth(), lblImg.getHeight(), Image.SCALE_DEFAULT));
            return icono;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }

}
