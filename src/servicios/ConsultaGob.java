package servicios;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class ConsultaGob extends dao.Conexion {

    protected static JSONParser parser = new JSONParser();

    public static JSONObject getDatosRuc(String RUC) throws ParseException {
        /*
         ruc, razon_social, ciiu, fecha_actividad, contribuyente_condicion, contribuyente_tipo, contribuyente_estado,
         nombre_comercial, fecha_inscripcion, domicilio_fiscal, sistema_emision, sistema_contabilidad, actividad_exterior,
         emision_electronica, fecha_inscripcion_ple, Oficio, fecha_baja, representante_legal, empleados, locales
         */
        try {
            Document doc = Jsoup.connect("https://api.sunat.cloud/ruc/" + RUC).ignoreContentType(true).get();
            String datos = doc.body().text();
            return (JSONObject) parser.parse(datos);
        } catch (IOException | ParseException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static JSONObject getDatosDni(String DNI) throws ParseException {
        //No para encendido en la madrugada
        /*dni, cui, apellido_paterno, apellido_materno, nombres*/
        try {
            Document doc = Jsoup.connect("https://api.reniec.cloud/dni/" + DNI).ignoreContentType(true).get();
            String datos = doc.body().text();
            return (JSONObject) parser.parse(datos);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static boolean existeDocumento(String numeroDeDocumento, char tipoDeDocumento) throws Exception {
        boolean existe = false;
        try {
            String sql = null;
            switch (tipoDeDocumento) {
                case '1':
                    sql = ("SELECT DNIPER FROM PERSONA WHERE DNIPER='" + numeroDeDocumento + "'");
                    break;
                case '2':
                    sql = ("SELECT RUCEMP FROM EMPRESA WHERE RUCEMP='" + numeroDeDocumento + "'");
                    break;
                default:
                    break;
            }
            ResultSet rs;
            try (Statement s = ConsultaGob.conectar().prepareStatement(sql)) {
                rs = s.executeQuery(sql);
                int contador = 0;
                while (rs.next()) {
                    contador++;
                }
                if (contador >= 1) {
                    existe = true;
                }
            }
            rs.close();
            ConsultaGob.desconectar();

        } catch (Exception e) {
            System.out.println("error ExistDni" + e.getMessage());
        }
        return existe;
    }

    public static String[] separarDomicilio(String direccionObtenida) {
        String datosFinal = "";
        String datos[] = direccionObtenida.split("-");
        String datosTemporal[] = datos[0].split(" ");
        datosFinal += datosTemporal[datosTemporal.length - 1] + "^";
        datosFinal += datos[1].trim() + "^";
        datos[0] = datos[0].trim();
        datosFinal += datos[2].trim() + "^";
        for (int i = 0; i < datosTemporal.length - 1; i++) {
            datosFinal += datosTemporal[i] + " ";
        }
        return datosFinal.trim().split("\\^");
    }
    
}
