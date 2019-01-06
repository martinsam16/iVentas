package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import modelo.LoginM;
import modelo.PersonaM;


public class LoginD extends Conexion {

    public boolean autenticacion(LoginM login, PersonaM persona) throws Exception {
        boolean autentica= false;
        try {            
            String sql = "select autenticar('"+login.getUsrper()+"' ,'"+login.getPswper()+"')";
            Statement s = this.conectar().prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql); 
            String rspta = null;
            while (rs.next()) {
                 rspta = String.valueOf(rs.getObject(1));
            }
            s.close();
            rs.close();
            this.desconectar();
            if (!"0".equals(rspta) && (!rspta.isEmpty() || rspta!=null)) {
                persona.setTipper(rspta);
                autentica = true;                
            }
        } catch (Exception e) {
            System.out.println("error autenticacion()" + e.getMessage());            
        }
        return autentica;
    }
    
        public void editarLogin(LoginM login, String dni){
        try {
            String sql = "CALL PROLOG(?,?,?)";
            PreparedStatement ps = this.conectar().prepareCall(sql);
            ps.setString(1, dni);
            ps.setString(2, login.getUsrper());
            ps.setString(3, login.getPswper());
            ps.executeUpdate();
            ps.close();
            this.desconectar();
        } catch (Exception e) {
            System.out.println("Error EditLog()" + e.getMessage());
        }
    }

}
