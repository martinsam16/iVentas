package modelo;

import java.sql.Date;
import java.sql.Time;

public class VentaM {
    private int codigoVenta;
    private String documentoVendedor, documentoComprador;
    private Date fechaVenta;
    private Time horaVenta;
    private String tipoVenta;     

    public int getCodigoVenta() {
        return codigoVenta;
    }

    public void setCodigoVenta(int codigoVenta) {
        this.codigoVenta = codigoVenta;
    }

    public String getDocumentoVendedor() {
        return documentoVendedor;
    }

    public void setDocumentoVendedor(String documentoVendedor) {
        this.documentoVendedor = documentoVendedor;
    }

    public String getDocumentoComprador() {
        return documentoComprador;
    }

    public void setDocumentoComprador(String documentoComprador) {
        this.documentoComprador = documentoComprador;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Time getHoraVenta() {
        return horaVenta;
    }

    public void setHoraVenta(Time horaVenta) {
        this.horaVenta = horaVenta;
    }

    public String getTipoVenta() {
        return tipoVenta;
    }

    public void setTipoVenta(String tipoVenta) {
        this.tipoVenta = tipoVenta;
    }
    
}