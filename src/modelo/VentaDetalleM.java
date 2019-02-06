package modelo;


public class VentaDetalleM {
    private int codigoProducto, cantidadProducto;
    private double descuentoProducto;

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public double getDescuentoProducto() {
        return descuentoProducto;
    }

    public void setDescuentoProducto(double descuentoProducto) {
        this.descuentoProducto = descuentoProducto;
    }
    
    @Override
    public String toString(){
        return "["+this.codigoProducto+","+this.cantidadProducto+","+this.descuentoProducto+"]";
    }
}
