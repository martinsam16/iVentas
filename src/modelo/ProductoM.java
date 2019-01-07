package modelo;

public class ProductoM {
    private String nompro, serpro, urlimgpro, nommar, nommod;
    private double prepo;

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

    public double getPrepo() {
        return prepo;
    }

    public void setPrepo(double prepo) {
        this.prepo = prepo;
    }
    
    @Override
    public String toString(){
        return "["+this.nompro+","+this.nommar+","+this.nommod+","+this.serpro+","+this.urlimgpro+"]";
    }
    
    public void clear(){
        this.nommar = "";
        this.nommod = "";
        this.nompro = "";
        this.prepo = 0;
        this.serpro = "";
//        this.urlimgpro=null;
        
    }
}
