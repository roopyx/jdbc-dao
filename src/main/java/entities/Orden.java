package entities;

import java.sql.Date;
import java.util.Objects;

public class Orden {
    private int idOrden;
    private Cliente cliente;
    private Empleado empleado;
    private Date fechaGenerada;
    private Date fechaEntregada;

    public Orden () {}

    public Orden (int idOrden,
                  Cliente cliente,
                  Empleado empleado,
                  Date fechaGenerada,
                  Date fechaEntregada) {
        this.idOrden = idOrden;
        this.cliente = cliente;
        this.empleado = empleado;
        this.fechaGenerada = fechaGenerada;
        this.fechaEntregada = fechaEntregada;
    }

    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Date getFechaGenerada() {
        return fechaGenerada;
    }

    public void setFechaGenerada(Date fechaGenerada) {
        this.fechaGenerada = fechaGenerada;
    }

    public Date getFechaEntregada() {
        return fechaEntregada;
    }

    public void setFechaEntregada(Date fechaEntregada) {
        this.fechaEntregada = fechaEntregada;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orden orden = (Orden) o;
        return idOrden == orden.idOrden &&
                Objects.equals(cliente, orden.cliente) &&
                Objects.equals(empleado, orden.empleado) &&
                Objects.equals(fechaGenerada, orden.fechaGenerada) &&
                Objects.equals(fechaEntregada, orden.fechaEntregada);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOrden, cliente, empleado, fechaGenerada, fechaEntregada);
    }

    @Override
    public String toString() {
        return "Orden{" +
                "idOrden=" + idOrden +
                ", cliente=" + cliente +
                ", empleado=" + empleado +
                ", fechaGenerada=" + fechaGenerada +
                ", fechaEntregada=" + fechaEntregada +
                '}';
    }
}
