package servicios;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class ConsultaGob {

    public static String getNombresApellidos(String DNI) {
        String datos = "";
        try {
            Document doc = Jsoup.connect("http://aplicaciones007.jne.gob.pe/srop_publico/Consulta/Afiliado/GetNombresCiudadano?DNI=" + DNI).get();
            Element el = doc.body();
            datos = el.text();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return datos.replace("|", " ");
    }
    
    public static String getDatosRuc(String RUC){
        String datos = "";
        try {
            Document doc = Jsoup.connect("https://api.sunat.cloud/ruc/" + RUC).ignoreContentType(true).get();
            Element el = doc.body();
            datos = el.text();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return datos;
    }
    
    public static String getDatosDni(String DNI){
        String datos = "";
        try {
            Document doc = Jsoup.connect("https://api.reniec.cloud/dni/" + DNI).ignoreContentType(true).get();
            Element el = doc.body();
            datos = el.text();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return datos;
    }
    
    public static void main(String[] args) {
        System.out.println(getDatosDni("15451073"));
    }
}
