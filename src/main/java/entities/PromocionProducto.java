package entities;

import java.util.Objects;

public class PromocionProducto {
    private PromocionVigencia promocionVigencia;
    private Producto producto;
    private double descuento;

    public PromocionProducto () {}

    public PromocionProducto (PromocionVigencia promocionVigencia,
                              Producto producto, double descuento) {
        this.promocionVigencia = promocionVigencia;
        this.producto = producto;
        this.descuento = descuento;
    }

    public PromocionVigencia getPromocionVigencia() {
        return promocionVigencia;
    }

    public void setPromocionVigencia(PromocionVigencia promocionVigencia) {
        this.promocionVigencia = promocionVigencia;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PromocionProducto that = (PromocionProducto) o;
        return Double.compare(that.descuento, descuento) == 0 &&
                Objects.equals(promocionVigencia, that.promocionVigencia) &&
                Objects.equals(producto, that.producto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(promocionVigencia, producto, descuento);
    }

    @Override
    public String toString() {
        return "PromocionProducto{" +
                "promocionVigencia=" + promocionVigencia +
                ", producto=" + producto +
                ", descuento=" + descuento +
                '}';
    }
}
