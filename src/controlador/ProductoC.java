package controlador;

import dao.ProductoD;
import servicios.ReportesS;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.ProductoM;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import servicios.CombosAnidados;
import servicios.ConsultaGob;
import servicios.TablasS;
import static vista.ProductoV.cmbMarPro;
import static vista.ProductoV.cmbMarPro1;
import static vista.ProductoV.cmbModPro;
import static vista.ProductoV.inptMarPro;
import static vista.ProductoV.inptModPro;
import static vista.ProductoV.inptNomPro;
import static vista.ProductoV.inptPrePro;
import static vista.ProductoV.inptRucPro;
import static vista.ProductoV.inptSerPro;
import static vista.ProductoV.inputAtributosDelProducto;
import static vista.ProductoV.inputFecGarPro;
import static vista.ProductoV.lblImg;
import static vista.ProductoV.tblProductos;

public class ProductoC {

    ProductoM producto = new ProductoM();
    ProductoD dao = new ProductoD();
    ReportesS servicioR = new ReportesS();
    servicios.CombosAnidados combo = new CombosAnidados();

    public String nuevo = "";

    public void accionMarca(char accion) {
        try {
            dao.accionMarca(producto, nuevo, accion);
        } catch (Exception e) {
        }
    }

    public void accionModelo(char accion) {
        try {
            dao.accionModelo(producto, nuevo, accion);
        } catch (Exception e) {
        }
    }

    public void accionProducto(char accion) {
        try {
            dao.accionProducto(producto, accion);
        } catch (Exception e) {
        }
    }

    public DefaultTableModel listarProductos() {
        try {
            return dao.listarPro();
        } catch (Exception e) {
            return null;
        }
    }

    public void actualizar() {
        actCmb();
        limpiar();
        tblProductos.setModel(listarProductos());
    }

    public Icon cargarImg(String link) {
        try {
            Image img = null;
            producto.setUrlimgpro(link);
            URL url = new URL(link);
            ImageIcon imgIcon = new ImageIcon(ImageIO.read(url));
            Icon icono = new ImageIcon(imgIcon.getImage().getScaledInstance(lblImg.getWidth(), lblImg.getHeight(), Image.SCALE_DEFAULT));
            return icono;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }

    public void actCmb() {
        try {
            cmbMarPro1.setModel(combo.listarCombo('1', ""));
            cmbMarPro.setModel(combo.listarCombo('1', ""));
            cmbModPro.removeAllItems();
        } catch (Exception e) {
        }
    }

    public DefaultComboBoxModel listarCmb(char tip, String nommar) {
        try {
            return combo.listarCombo(tip, nommar);
        } catch (Exception e) {
            return null;
        }
    }

    public void variablesM(char tip) {
        // Para registrar
        /*
         1   Producto
         2   Marca
         3   Modelo
         */
        producto.clear();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        switch (tip) {
            case '1':
                producto.setRucprov(inptRucPro.getText());
                producto.setDespro(inputAtributosDelProducto.getText());
                producto.setFecgarpro(df.format(inputFecGarPro.getDate()));
                producto.setNompro(inptNomPro.getText());
                producto.setNommar(cmbMarPro.getSelectedItem().toString());
                producto.setNommod(cmbModPro.getSelectedItem().toString());
                producto.setSerpro(inptSerPro.getText().toUpperCase());
                producto.setPrepo(Double.parseDouble(inptPrePro.getText()));
                break;
            case '2':
                producto.setNommar(inptMarPro.getText().toUpperCase());
                break;
            case '3':
                producto.setNommar(cmbMarPro1.getSelectedItem().toString());
                producto.setNommod(inptModPro.getText().toUpperCase());
                break;
            default:
                break;
        }
        System.out.println("VariablesM" + producto.toString());

    }

    public DefaultComboBoxModel llenarComboUbigeo(char tipo, String nombre) {
        try {
            servicios.CombosAnidados combo = new CombosAnidados();
            return combo.listarCombo(tipo, nombre);
        } catch (Exception e) {
            return null;
        }
    }

    public void autorrellenarCamposPorRuc() throws ParseException {
        if (inptRucPro.getText().length() == 11) {
            if (!dao.existeRuc(inptRucPro.getText())) {
                JSONObject datos = ConsultaGob.getDatosRuc(inptRucPro.getText());
                System.out.println(datos.toString());
            } else {
                JOptionPane.showMessageDialog(null, "El DNI ingresado ya existe en la Base de Datos");
            }
        }
    }

    public void llenarCampos() {
        String datosTemp = TablasS.devolverCamposDeFila(tblProductos);
        if (datosTemp != null) {
            String datos[] = datosTemp.split("\\^");
            // CÓDIGO,NOMBRE,MARCA,MODELO,SERIE,PRECIO,URLIMG
            inptNomPro.setText(datos[1]);
            cmbMarPro.setSelectedItem(datos[2]);
            cmbModPro.setSelectedItem(datos[3]);
            inptSerPro.setText(datos[4]);
            inptPrePro.setText(datos[5]);

            variablesM('1');
//            producto.setNommod(datos[3]);
            try {
                producto.setUrlimgpro(datos[6]);
                lblImg.setIcon(cargarImg(datos[6]));
            } catch (Exception e) {
                System.out.println("error link vacio xd");
            }

            System.out.println("variablesm editar" + producto.toString());
        }
    }

    public void buscar(String consulta, JTable tbl) {
        TablasS.buscar(consulta, tbl);
    }

    public void generarReporteDeTodosLosProductos() {
        servicioR.generarReporteProductos();
    }

    public void limpiar() {

        lblImg.setIcon(null);
        producto.setUrlimgpro("");
        inptPrePro.setText("0000.00");
        inptNomPro.setText("");
        inptMarPro.setText("");
        inptModPro.setText("");
        inptSerPro.setText("");

        tblProductos.clearSelection();
        producto.clear();
        nuevo = "";

    }

}
