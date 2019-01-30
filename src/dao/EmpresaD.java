package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import modelo.EmpresaM;

public class EmpresaD extends Conexion {

    public void AccionEmpresa(EmpresaM empresa, char tipoDeAccion) {
        try {
            String sql = null;
            switch (tipoDeAccion) {
                case '1':
                    sql = "INSERT INTO EMPRESA (NOMEMP, RUCEMP, TLFEMP, EMAILEMP, PERSONA_CODPER_REPLEG, TIPEMP, DISTRITO_CODDIS_DISEMP, DIREMP) VALUES (?,?,?,?,?,?,?,?)";
                    break;
                case '2':
                    sql = "UPDATE EMPRESA SET NOMEMP=?, RUCEMP=?, TLFEMP=?, EMAILEMP=?, PERSONA_CODPER_REPLEG=?, TIPEMP=?, DISTRITO_CODDIS_DISEMP=?, DIREMP=? WHERE RUCEMP='" + empresa.getRucemp() + "'";
                    break;
            }

            PreparedStatement ps = this.conectar().prepareStatement(sql);

            ps.setString(1, empresa.getNomemp());
            ps.setString(2, empresa.getRucemp());
            ps.setString(3, empresa.getTlfemp());
            ps.setString(4, empresa.getEmailemp());
            ps.setInt(5, devolverCodigos(empresa, '2'));
            ps.setString(6, empresa.getTipemp());
            ps.setInt(7, devolverCodigos(empresa, '1'));
            ps.setString(8, empresa.getDiremp());

            ps.executeUpdate();
            ps.close();
            this.desconectar();

        } catch (Exception e) {
            System.out.println("Error AccionEmpresa Dao" + e.getMessage());
        }
    }

    public int devolverCodigos(EmpresaM empresa, char tipoDeDevolucion) {
        int cod = 0;
        try {
            String sql = null;
            switch (tipoDeDevolucion) {
                case '1':
                    sql = "SELECT CODDIS FROM DISTRITO WHERE NOMDIS='" + empresa.getNomdistemp() + "'";
                    break;
                case '2':
                    sql = "SELECT CODPER FROM PERSONA WHERE DNIPER='" + empresa.getDnirepleg() + "'";
                    break;
            }

            Statement s = this.conectar().prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                cod = Integer.valueOf(rs.getString(1));
            }
        } catch (Exception e) {
            System.out.println("error devolver codigos EmpresaD" + e.getMessage());
        }
        return cod;
    }
    
    public DefaultTableModel listarPro() throws Exception {
        DefaultTableModel tblTemp = null;
        try {
            String sql = "SELECT EMPRESA.CODEMP, EMPRESA.NOMEMP, EMPRESA.RUCEMP, EMPRESA.TLFEMP, EMPRESA.EMAILEMP, PERSONA.DNIPER, PERSONA.APEPER, PERSONA.NOMPER, EMPRESA.TIPEMP, DEPARTAMENTO.NOMDEP,PROVINCIA.NOMPROV,DISTRITO.NOMDIS, EMPRESA.DIREMP FROM EMPRESA INNER JOIN PERSONA ON EMPRESA.PERSONA_CODPER_REPLEG=PERSONA.CODPER INNER JOIN DISTRITO ON EMPRESA.DISTRITO_CODDIS_DISEMP = DISTRITO.CODDIS INNER JOIN PROVINCIA ON DISTRITO.PROVINCIA_CODPROV = PROVINCIA.CODPROV INNER JOIN DEPARTAMENTO ON PROVINCIA.DEPARTAMENTO_CODDEP = DEPARTAMENTO.CODDEP";
            
            String clms = "CÓDIGO,NOMBRE,RUC,TELEFONO,EMAIL,DNI REPLEG,APELLIDOS,NOMBRES,TIPO DE EMPRESA,DEPARTAMENTO,PROVINCIA,DISTRITO,DIRECCION";

            tblTemp = new DefaultTableModel(null, clms.split(","));
            Statement s = this.conectar().prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);
            String dts[] = new String[clms.split(",").length];

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
            System.out.println("Error listar Productos Dao"+e.getMessage());
        }
        return tblTemp;
    }
}
