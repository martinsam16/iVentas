package modelo;

import java.sql.Date;

public class EntradaSalidaM {
    private int codigoEntrasaSalida, codigoProducto, cantidadEntrada, cantidadSalida, stock;
    private Date fechaEntrada, fechaSalida;

    public int getCodigoEntrasaSalida() {
        return codigoEntrasaSalida;
    }

    public void setCodigoEntrasaSalida(int codigoEntrasaSalida) {
        this.codigoEntrasaSalida = codigoEntrasaSalida;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public int getCantidadEntrada() {
        return cantidadEntrada;
    }

    public void setCantidadEntrada(int cantidadEntrada) {
        this.cantidadEntrada = cantidadEntrada;
    }

    public int getCantidadSalida() {
        return cantidadSalida;
    }

    public void setCantidadSalida(int cantidadSalida) {
        this.cantidadSalida = cantidadSalida;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
}
