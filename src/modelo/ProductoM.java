package modelo;

import java.sql.Date;

public class ProductoM {

    public String getNompro() {
        return nompro;
    }

    public void setNompro(String nompro) {
        this.nompro = nompro;
    }

    public String getSerpro() {
        return serpro;
    }

    public void setSerpro(String serpro) {
        this.serpro = serpro;
    }

    public String getUrlimgpro() {
        return urlimgpro;
    }

    public void setUrlimgpro(String urlimgpro) {
        this.urlimgpro = urlimgpro;
    }

    public String getNommar() {
        return nommar;
    }

    public void setNommar(String nommar) {
        this.nommar = nommar;
    }

    public String getNommod() {
        return nommod;
    }

    public void setNommod(String nommod) {
        this.nommod = nommod;
    }

    public String getProveedor_codprov() {
        return proveedor_codprov;
    }

    public void setProveedor_codprov(String proveedor_codprov) {
        this.proveedor_codprov = proveedor_codprov;
    }

    public String getDespro() {
        return despro;
    }

    public void setDespro(String despro) {
        this.despro = despro;
    }

    public String getEstpro() {
        return estpro;
    }

    public void setEstpro(String estpro) {
        this.estpro = estpro;
    }

    public double getPrepo() {
        return prepo;
    }

    public void setPrepo(double prepo) {
        this.prepo = prepo;
    }

    public Date getFecgarpro() {
        return fecgarpro;
    }

    public void setFecgarpro(Date fecgarpro) {
        this.fecgarpro = fecgarpro;
    }

    private String nompro, serpro, urlimgpro, nommar, nommod, proveedor_codprov, despro, estpro;
    private double prepo;
    Date fecgarpro;

    @Override
    public String toString() {
        return "[" + this.proveedor_codprov + this.nompro + "," + this.nommar + "," + this.nommod + "," + this.serpro + "," + this.urlimgpro + "," + this.despro + "," + this.estpro + "," + this.prepo + "," + this.fecgarpro + "]";
    }

    public void clear() {
        this.nommar = "";
        this.nommod = "";
        this.nompro = "";
        this.prepo = 0;
        this.serpro = "";
        this.despro = "";
        this.estpro = "";
        this.prepo = 0;
        this.fecgarpro = null;
//        this.urlimgpro=null;

    }
}
