package modelo;


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

    public String getNomprov() {
        return nomprov;
    }

    public void setNomprov(String nomprov) {
        this.nomprov = nomprov;
    }

    public String getFecgarpro() {
        return fecgarpro;
    }

    public void setFecgarpro(String fecgarpro) {
        this.fecgarpro = fecgarpro;
    }

    public double getPrepo() {
        return prepo;
    }

    public void setPrepo(double prepo) {
        this.prepo = prepo;
    }

    public int getCodmar() {
        return codmar;
    }

    public void setCodmar(int codmar) {
        this.codmar = codmar;
    }

    public int getCodmod() {
        return codmod;
    }

    public void setCodmod(int codmod) {
        this.codmod = codmod;
    }
    
    private String nompro, serpro, urlimgpro, nommar, nommod, despro, estpro, nomprov,fecgarpro, nomcat;

    public String getNomcat() {
        return nomcat;
    }

    public void setNomcat(String nomcat) {
        this.nomcat = nomcat;
    }

    public int getCodcat() {
        return codcat;
    }

    public void setCodcat(int codcat) {
        this.codcat = codcat;
    }
    private double prepo;
    private int codmar, codmod, codcat;
    

    @Override
    public String toString() {
        return "[" + this.nomprov+ "," + this.codmar+ "," + this.codmod + this.nompro + "," + this.nommar + "," + this.nommod + "," +this.codcat+ this.serpro + "," + this.urlimgpro + "," + this.despro + "," + this.estpro + "," + this.prepo + "," + this.fecgarpro + "]";
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
