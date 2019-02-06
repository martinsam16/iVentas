package modelo;

public class VentaM {
    private int codigoVenta;
    private int documentoVendedor, documentoComprador;
    private String fechaVenta, horaVenta;
    private String tipoVenta; 

    public int getCodigoVenta() {
        return codigoVenta;
    }

    public void setCodigoVenta(int codigoVenta) {
        this.codigoVenta = codigoVenta;
    }

    public int getDocumentoVendedor() {
        return documentoVendedor;
    }

    public void setDocumentoVendedor(int documentoVendedor) {
        this.documentoVendedor = documentoVendedor;
    }

    public int getDocumentoComprador() {
        return documentoComprador;
    }

    public void setDocumentoComprador(int documentoComprador) {
        this.documentoComprador = documentoComprador;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public String getHoraVenta() {
        return horaVenta;
    }

    public void setHoraVenta(String horaVenta) {
        this.horaVenta = horaVenta;
    }

    public String getTipoVenta() {
        return tipoVenta;
    }

    public void setTipoVenta(String tipoVenta) {
        this.tipoVenta = tipoVenta;
    }
    
    
}