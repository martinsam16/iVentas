package servicios;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * Sirve para hacer querys
 *
 * @version 0.0.1
 * @author Martín Alexis Samán Arata
 */
public class ConsultaGob extends dao.Conexion {

    protected static JSONParser parser = new JSONParser();

    /**
     * Obtiene un JSON con los datos de un determinado RUC
     *
     * @param RUC String Número de RUC
     * @return JSONObject: ruc, razon_social, ciiu, fecha_actividad,
     * contribuyente_condicion, contribuyente_tipo, contribuyente_estado,
     * nombre_comercial, fecha_inscripcion, domicilio_fiscal, sistema_emision,
     * sistema_contabilidad, actividad_exterior, emision_electronica,
     * fecha_inscripcion_ple, Oficio, fecha_baja, representante_legal,
     * empleados, locales
     * @throws ParseException | IOException
     */
    public static JSONObject getDatosRuc(String RUC) throws ParseException {
        try {
            Document doc = Jsoup.connect("https://api.sunat.cloud/ruc/" + RUC).ignoreContentType(true).get();
            String datos = doc.body().text();
            return (JSONObject) parser.parse(datos);
        } catch (IOException | ParseException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * Devuelve los datos de una persona partir de un número de DNI
     *
     * @param DNI String Número de DNI
     * @return JSONObject: dni, cui, apellido_paterno, apellido_materno, nombres
     * @throws ParseException
     */
    public static JSONObject getDatosDni(String DNI) throws ParseException {
        try {
            Document doc = Jsoup.connect("https://api.reniec.cloud/dni/" + DNI).ignoreContentType(true).get();
            String datos = doc.body().text();
            return (JSONObject) parser.parse(datos);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * Verifica en la Base de Datos si un documento existe
     *
     * @param numeroDeDocumento String DNI o RUC
     * @return boolean true: existe, false: No existe
     * @throws Exception
     */
    public static boolean existeDocumento(String numeroDeDocumento) throws Exception {
        boolean existe = false;
        try {
            String sql = null;
            sql = ("SELECT DOCPER FROM PERSONA WHERE DOCPER='" + numeroDeDocumento + "'");
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

    /**
     * Separa en Departamento, Provincia, Distrito y Direccion lo que devuelve
     * el api de la SUNAT
     *
     * @param direccionObtenida String
     * @return String[] Departamento, Provincia, Distrito, Direccion
     */
    public static String[] separarDomicilio(String direccionObtenida) {
        //Rcordar Mejoralo xd
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
