package servicios;

import dao.Conexion;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;

/**
 * Devuelve DefaultComboBoxModel de acuerdo a una consulta
 *
 * @version 0.0.1
 * @author Martín Alexis Samán Arata
 */
public class CombosAnidados extends Conexion {

    /**
     *
     * @param tip char 0 Empresa, 1 Marca, 2 Modelo, 3 Modelo dependiente de
     * marca, 4 Departamentos, 5, Provincias dependientes de Departamentos, 6
     * Distritos dependientes de Provincia, 7 Documentos Personas, 8 Documento
     * Vendedores, 9 Documento Clientes y Empresas
     * @param nombre String
     * @return DefaultComboBoxModel
     * @throws Exception
     */
    public DefaultComboBoxModel listarCombo(char tip, String nombre) throws Exception {
        DefaultComboBoxModel cmbTemp = null;
        try {
            String sql = null;
            switch (tip) {
                case '0':
                    sql = "SELECT PERSONA.NOMPER FROM PERSONA WHERE length(PERSONA.DOCPER)=11";
                    break;
                case '1':
                    sql = "SELECT MARCA.NOMMAR FROM MARCA ORDER BY MARCA.NOMMAR ASC";
                    break;
                case '2':
                    sql = "SELECT MODELO.NOMMOD FROM MODELO";
                    break;
                case '3':
                    sql = "SELECT MODELO.NOMMOD FROM MODELO INNER JOIN MARCA ON  MODELO.MARCA_CODMAR_MARMOD = MARCA.CODMAR WHERE MARCA.NOMMAR= '" + nombre + "' ORDER BY MODELO.NOMMOD ASC";
                    break;
                case '4':
                    sql = "SELECT DEPARTAMENTO.NOMDEP FROM DEPARTAMENTO ORDER BY DEPARTAMENTO.NOMDEP ASC";
                    break;
                case '5':
                    sql = "SELECT PROVINCIA.NOMPROV FROM PROVINCIA INNER JOIN DEPARTAMENTO ON PROVINCIA.DEPARTAMENTO_CODDEP = DEPARTAMENTO.CODDEP WHERE DEPARTAMENTO.NOMDEP = '" + nombre + "'";
                    break;
                case '6':
                    sql = "SELECT DISTRITO.NOMDIS FROM DISTRITO INNER JOIN PROVINCIA ON DISTRITO.PROVINCIA_CODPROV = PROVINCIA.CODPROV  WHERE PROVINCIA.NOMPROV = '" + nombre + "'";
                    break;
                case '7':
                    sql = "SELECT PERSONA.DOCPER FROM PERSONA";
                    break;
                case '8':
                    sql = "SELECT CONCAT(PERSONA.DOCPER,' | ' ,PERSONA.NOMPER )FROM PERSONA WHERE PERSONA.TIPPER='V' ORDER BY PERSONA.DOCPER ASC";
                    break;
                case '9':
                    sql = "SELECT CONCAT(PERSONA.DOCPER,' | ' ,PERSONA.NOMPER,' ',PERSONA.APEPER ) FROM PERSONA WHERE PERSONA.TIPPER='C' OR PERSONA.TIPPER='E' ORDER BY PERSONA.TIPPER ASC";
                    break;
                default:
                    break;
            }

            Statement s = this.conectar().prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);
            Vector dts = new Vector();
            while (rs.next()) {
                dts.add(rs.getString(1));
            }
            cmbTemp = new DefaultComboBoxModel(dts);
            s.close();
            rs.close();
            this.desconectar();

        } catch (Exception e) {
            System.out.println("Error ListarCmb() D " + e.getMessage());
        }

        return cmbTemp;
    }

    /**
     *
     * @param tip char 0: Productos
     * @return DefaultComboBoxModel
     */
    public DefaultComboBoxModel listarCombo(char tip) {
        DefaultComboBoxModel cmbTemp = null;
        try {
            String sql = null;
            switch (tip) {
                case '0':
                    sql = "SELECT PRODUCTO.NOMPRO FROM PRODUCTO";
                    break;
                case '1':
                    sql="SELECT CATEGORIA.NOMCAT FROM CATEGORIA";
                default:
                    break;
            }

            Statement s = this.conectar().prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);
            Vector dts = new Vector();
            while (rs.next()) {
                dts.add(rs.getString(1));
            }
            cmbTemp = new DefaultComboBoxModel(dts);
            s.close();
            rs.close();
            this.desconectar();

        } catch (Exception e) {
            System.out.println("Error ListarCmb() D " + e.getMessage());
        }

        return cmbTemp;

    }
}
