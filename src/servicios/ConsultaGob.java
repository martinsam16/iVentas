package servicios;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class ConsultaGob {

    protected static JSONParser parser = new JSONParser();

    public static JSONObject getDatosRuc(String RUC) throws ParseException {        
        /*
        ruc, razon_social, ciiu, fecha_actividad, contribuyente_condicion, contribuyente_tipo, contribuyente_estado,
        nombre_comercial, fecha_inscripcion, domicilio_fiscal, sistema_emision, sistema_contabilidad, actividad_exterior,
        emision_electronica, fecha_inscripcion_ple, Oficio, fecha_baja, representante_legal, empleados, locales
         */
        try {
            Document doc = Jsoup.connect("https://api.sunat.cloud/ruc/" + RUC).ignoreContentType(true).get();
            Element el = doc.body();
            String datos = el.text();
            return (JSONObject) parser.parse(datos);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static JSONObject getDatosDni(String DNI) throws ParseException {
        /*dni, cui, apellido_paterno, apellido_materno, nombres*/
        try {
            Document doc = Jsoup.connect("https://api.reniec.cloud/dni/" + DNI).ignoreContentType(true).get();
            Element el = doc.body();
            String datos = el.text();
            return (JSONObject) parser.parse(datos);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
