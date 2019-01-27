package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.PersonaM;

public class PersonaD extends Conexion {
    
    public boolean autenticar(PersonaM persona) {
        boolean autentica = false;
        try {
            String sql = "SELECT AUTENTICAR('" + persona.getUsrper() + "' ,'" + persona.getPswper() + "')";
            Statement s = this.conectar().prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);
            String rspta = null;
            while (rs.next()) {
                rspta = String.valueOf(rs.getObject(1));
            }
            s.close();
            rs.close();
            this.desconectar();
            if (!"0".equals(rspta) && (!rspta.isEmpty() || rspta != null)) {
                persona.setTipper(rspta);
                autentica = true;
            }
        } catch (Exception e) {
            System.out.println("error autenticacion()" + e.getMessage());
        }
        return autentica;
    }
    
    public void accionPersona(PersonaM persona, char tipo) throws Exception {
        try {
            String sql = null;
            persona.setCoddis(devolverCodigoDistrito(persona.getNomdis()));
            boolean temp = false;
            System.out.println("Coddis=" + persona.getCoddis());
            switch (tipo) {
                case '1':
                    if (existeDni(persona.getDniper())) {
                        JOptionPane.showMessageDialog(null, "El DNI ingresado ya existe.");
                        return;
                    }
                    sql = "INSERT INTO PERSONA (NOMPER, APEPER, DNIPER, TLFPER, TIPPER, DISTRITO_CODDIS_DISPER, DIRPER, USRLOGPER, PSWLOGPER, ESTLOGPER) VALUES (?,?,?,?,?,?,?,?,?,?)";
                    if (!"C".equals(persona.getTipper())) {
                        persona.setUsrper(persona.getDniper());
                        persona.setPswper("@" + persona.getDniper());
                    }
                    break;
                case '2':
                    sql = "UPDATE PERSONA SET NOMPER=?, APEPER=?, DNIPER=?, TLFPER=?, TIPPER=?, DISTRITO_CODDIS_DISPER=?, DIRPER=?, USRLOGPER=?, PSWLOGPER=?, ESTLOGPER=? WHERE DNIPER='" + persona.getDniper() + "'";
                    if ("C".equals(persona.getTipper())) {
                        persona.setEstlog("I");
                    }
                    break;
                case '3':
                    sql = "DELETE FROM PERSONA WHERE DNIPER= ? ";
                    temp = true;
                default:
                    break;
            }
            System.out.println(persona.toString());
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            if (!temp) {
                ps.setString(1, persona.getNomper());
                ps.setString(2, persona.getApeper());
                ps.setString(3, persona.getDniper());
                ps.setString(4, persona.getTelfper());
                ps.setString(5, persona.getTipper());
                ps.setInt(6, persona.getCoddis());
                ps.setString(7, persona.getDir());
                ps.setString(8, persona.getUsrper());
                ps.setString(9, persona.getPswper());
                ps.setString(10, persona.getEstlog());
            } else {
                ps.setString(1, persona.getDniper());
            }
            
            ps.executeUpdate();
            ps.close();
            this.desconectar();
            
        } catch (Exception e) {
            System.out.println("error AccionPer()");
            System.out.println(e.getMessage());
        }
    }
    
    public int devolverCodigoDistrito(String nombreDelDistrito) {
        try {
            int cod = 0;
            String sql = "SELECT CODDIS FROM DISTRITO WHERE NOMDIS='" + nombreDelDistrito + "'";
            Statement s = this.conectar().prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                cod = Integer.valueOf(rs.getString(1));
            }
            return cod;
        } catch (Exception e) {
            return 0;
        }
    }
    
    public boolean existeDni(String dni) {
        boolean existe = false;
        try {
            String sql = ("SELECT DNIPER FROM PERSONA WHERE DNIPER='" + dni + "'");
            try (Statement s = this.conectar().prepareStatement(sql)) {
                ResultSet rs = s.executeQuery(sql);
                int contador = 0;
                while (rs.next()) {
                    System.out.println(rs.getArray(contador));
                    contador++;
                }
                if (contador >= 1) {
                    existe = true;
                }
                s.close();
                rs.close();
                this.desconectar();
            }
        } catch (Exception e) {
            existe = true;
            System.out.println("error ExistDni");
        }
        return existe;
    }
    
    public DefaultTableModel listarPersonas(char tipper, boolean estado) throws Exception {
        
        DefaultTableModel tblTemp = null;
        try {
            String clmsTemp = "CÓDIGO,NOMBRES,APELLIDOS,DNI,TELÉFONO,TIPO";
            String sql;
            
            sql = "SELECT CODPER, NOMPER, APEPER, DNIPER, TLFPER, TIPPER FROM PERSONA ";
            if (estado) {
                if (tipper == 'V') {
                    clmsTemp += ",USUARIO,CONTRA";
                    sql = "SELECT PERSONA.CODPER, PERSONA.NOMPER, PERSONA.APEPER, PERSONA.DNIPER, PERSONA.TLFPER, PERSONA.TIPPER, PERSONA.USRLOGPER, PERSONA.PSWLOGPER FROM PERSONA ";
                }
                sql += "WHERE TIPPER = '" + tipper + "'";
            }
            String clms[] = clmsTemp.split(",");
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
