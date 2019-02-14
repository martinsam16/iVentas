package controlador;

import dao.ProductoD;
import servicios.ReportesS;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.ProductoM;
import servicios.CombosAnidados;
import servicios.PonerImgLabel;
import servicios.TablasS;
import vista.ProductoV;
import static vista.ProductoV.cmbCatPro;
import static vista.ProductoV.cmbMarPro;
import static vista.ProductoV.cmbMarPro1;
import static vista.ProductoV.cmbModPro;
import static vista.ProductoV.comboProveedor;
import static vista.ProductoV.inptCategoriaProducto;
import static vista.ProductoV.inptMarPro;
import static vista.ProductoV.inptModPro;
import static vista.ProductoV.inptNomPro;
import static vista.ProductoV.inptPrePro;
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

    
    public void accionCategoria(char  accion){
        try {
            dao.accionCategoria(producto, nuevo, accion);
        } catch (Exception e) {
        }
    }
    
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

    public void cargarImg(String link) {
        PonerImgLabel setImg = new PonerImgLabel("Hilo");
        setImg.link=link;
        producto.setUrlimgpro(link);
        setImg.lbl=lblImg;
        setImg.start();
    }

    public void actCmb() {
        try {
            cmbMarPro1.setModel(combo.listarCombo('1', ""));
            cmbMarPro.setModel(combo.listarCombo('1', ""));
            cmbCatPro.setModel(combo.listarCombo('1'));
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
 public DefaultComboBoxModel listarCmb(char tip) {
        try {
            return combo.listarCombo(tip);
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
                producto.setNomprov(comboProveedor.getSelectedItem().toString());
                producto.setDespro(inputAtributosDelProducto.getText());
                producto.setFecgarpro(df.format(inputFecGarPro.getDate()));
                producto.setNompro(inptNomPro.getText().toUpperCase());
                producto.setNommar(cmbMarPro.getSelectedItem().toString());
                producto.setNommod(cmbModPro.getSelectedItem().toString());
                producto.setNomcat(cmbCatPro.getSelectedItem().toString());
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
            case '4':
                producto.setNomcat(inptCategoriaProducto.getText().toUpperCase());
            default:
                break;
        }
        System.out.println("VariablesM" + producto.toString());

    }

    public DefaultComboBoxModel llenarComboRucEmpresas() {
        try {
            return combo.listarCombo('0', null);
        } catch (Exception e) {
            return null;
        }
    }

    public void llenarCampos() throws ParseException {
        
        String datosTemp = TablasS.devolverCamposDeFila(tblProductos);
        if (datosTemp != null) {
            String datos[] = datosTemp.split("\\^");
            // CÓDIGO,NOMBRE,MARCA,MODELO,SERIE,PRECIO,URLIMG,ATRIB,PROVEEDOR,GAR,CAT
            inptNomPro.setText(datos[1]);
            cmbMarPro.setSelectedItem(datos[2]);
            cmbModPro.setSelectedItem(datos[3]);
            inptSerPro.setText(datos[4]);
            inptPrePro.setText(datos[5]);
            inputAtributosDelProducto.setText(datos[7]);
            comboProveedor.setSelectedItem(datos[8]);            
            inputFecGarPro.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(datos[9]));
            cmbCatPro.setSelectedItem(datos[10]);

            variablesM('1');
//            producto.setNommod(datos[3]);
            try {
                cargarImg(datos[6]);
            } catch (Exception e) {
                System.out.println("error link vacio xd");
            }

            //System.out.println("variablesm editar" + producto.toString());
        }
    }

    public void buscar(String consulta, JTable tbl) {
        TablasS.buscar(consulta, tbl,'0');
    }

    public void generarReporteDeTodosLosProductos(){
        ReportesS.generarReportes('0',0);
    }

    public void limpiar() {

        lblImg.setIcon(null);
        producto.setUrlimgpro("");
        inptPrePro.setText("0000.00");
        inptNomPro.setText("");
        inptMarPro.setText("");
        inptModPro.setText("");
        inptSerPro.setText("");
        inptCategoriaProducto.setText("");

        tblProductos.clearSelection();
        producto.clear();
        nuevo = "";

    }    

}
