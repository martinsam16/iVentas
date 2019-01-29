package servicios;

import dao.Conexion;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;

public class CombosAnidados extends Conexion {

    public DefaultComboBoxModel listarCombo(char tip, String nombre) throws Exception {
        /*
         0   Empresa
         1   Marca
         2   Modelo
         3   Modelo dependiente de marca
         4   Departamentos
         5   Provincias dependientes de Departamentos
         6   Distritos dependientes de Provincia
         */
        DefaultComboBoxModel cmbTemp = null;
        try {
            String sql = null;
            switch (tip) {
                case '0':
                    sql = "SELECT EMPRESA.NOMEMP FROM EMPRESA";
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
