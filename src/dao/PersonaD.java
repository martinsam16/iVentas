package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import modelo.PersonaM;

public class PersonaD extends Conexion {

    public void accionPersona(PersonaM PerM, String tipAc) throws Exception {
        try {
            String sql = "CALL ACCIONPERSONA(?,?,?,?,?,?)";
            PreparedStatement ps = this.conectar().prepareCall(sql);
            ps.setString(1, PerM.getNomper());
            ps.setString(2, PerM.getApeper());
            ps.setString(3, PerM.getDniper());
            ps.setString(4, PerM.getTelfper());
            ps.setString(5, PerM.getTipper());
            ps.setString(6, tipAc);
            ps.executeQuery();
            ps.close();
            this.desconectar();

        } catch (Exception e) {
            System.out.println("error AccionPer()");
            System.out.println(e.getMessage());
        }
    }

    public DefaultTableModel listarPersonas(char tipper, boolean estado) throws Exception {
        
        DefaultTableModel tblTemp = null;        
        try {
            String clmsTemp = "CÓDIGO,NOMBRES,APELLIDOS,DNI,TELÉFONO,TIPO";
            String sql;           
            
            sql = "SELECT CODPER, NOMPER, APEPER, DNIPER, TLFPER, TIPPER FROM PERSONA ";
            if (estado) {        
                if (tipper=='V') {
                    clmsTemp+=",USUARIO,CONTRA";
                    sql ="SELECT PERSONA.CODPER, PERSONA.NOMPER, PERSONA.APEPER, PERSONA.DNIPER, PERSONA.TLFPER, PERSONA.TIPPER, LOGIN.USRLOG, LOGIN.PSWLOG FROM PERSONA INNER JOIN LOGIN ON PERSONA.CODPER = LOGIN.PERSONA_CODPER ";
                }
                sql+="WHERE TIPPER = '"+tipper+"'";
            }
            String clms[]=clmsTemp.split(",");
            tblTemp = new DefaultTableModel(null, clms);
            Statement s = this.conectar().prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);
            String dts[] = new String[clms.length];

            while (rs.next()) {
                for (int i = 0; i < dts.length; i++) {
                    dts[i] = rs.getString(i + 1);
                }
                tblTemp.addRow(dts);
            }
            s.close();
            rs.close();
            this.desconectar();

        } catch (Exception e) {
            System.out.println(e.getMessage() + e.getMessage());
            System.out.println("Error ListarPer()");
        }
        return tblTemp;
    }

}
