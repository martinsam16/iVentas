package controlador;

import dao.ProductoD;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.ProductoM;
import servicios.TablasS;
import static vista.ProductoV.cmbMarPro;
import static vista.ProductoV.cmbMarPro1;
import static vista.ProductoV.cmbModPro;
import static vista.ProductoV.inptMarPro;
import static vista.ProductoV.inptModPro;
import static vista.ProductoV.inptNomPro;
import static vista.ProductoV.inptPrePro;
import static vista.ProductoV.inptSerPro;
import static vista.ProductoV.lblImg;
import static vista.ProductoV.tblProductos;

public class ProductoC {

    ProductoM producto = new ProductoM();
    ProductoD dao = new ProductoD();
    
    public void accionMarca(String accion){
        try {
            dao.accionMarca(producto, accion);
        } catch (Exception e) {
        }
    }
    
    public void accionModelo(String accion){
        try {
            dao.accionModelo(producto, accion);
        } catch (Exception e) {
        }
    }
    
    public void accionProducto(String accion){
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
    
    public void actCmb(){
        try {
            cmbMarPro1.setModel(dao.listarCmb('1',""));
            cmbMarPro.setModel(dao.listarCmb('1',""));
        } catch (Exception e) {
        }
    }
    public DefaultComboBoxModel listarCmb(char tip, String nommar) {
        try {
            return dao.listarCmb(tip, nommar);
        } catch (Exception e) {
            return null;
        }
    }

    public void variablesM(char tip) {
        /*
        1   Producto
        2   Marca
        3   Modelo
         */
        producto.clear();
        switch (tip) {
            case '1':
                producto.setNompro(inptNomPro.getText());
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
        System.out.println(producto.toString());

    }
    
    public void llenarCampos(){
        String datosTemp = TablasS.devolverCamposDeFila(tblProductos);
        if (datosTemp!=null) {
            String datos[]=datosTemp.split("\\^");
            // CÓDIGO,NOMBRE,MARCA,MODELO,SERIE,PRECIO,URLIMG
            inptNomPro.setText(datos[1]);
            cmbMarPro.setSelectedItem(datos[2]);
            cmbModPro.setSelectedItem(datos[3]);
            inptSerPro.setText(datos[4]);
            inptPrePro.setText(datos[5]);
            lblImg.setIcon(cargarImg(datos[6]));
        }
    }    
    
    public void buscar(String consulta, JTable tbl){
        TablasS.buscar(consulta, tbl);
    }

    public void limpiar() {
        System.out.println(producto.toString());
        lblImg.setIcon(null);
        producto.setUrlimgpro(null);
        inptPrePro.setText("0000.00");
        inptNomPro.setText("");        
        inptMarPro.setText("");
        inptModPro.setText("");
        inptSerPro.setText("");
        tblProductos.clearSelection();
        producto.clear();
        
    }

}
