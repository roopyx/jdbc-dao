package entities;

import java.util.Objects;

public class Promocion {
    private int idPromocion;
    private String descripcion;

    public Promocion () {}

    public Promocion (int idPromocion, String descripcion) {
        this.idPromocion = idPromocion;
        this.descripcion = descripcion;
    }

    public int getIdPromocion() {
        return idPromocion;
    }

    public void setIdPromocion(int idPromocion) {
        this.idPromocion = idPromocion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Promocion promocion = (Promocion) o;
        return idPromocion == promocion.idPromocion &&
                Objects.equals(descripcion, promocion.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPromocion, descripcion);
    }

    @Override
    public String toString() {
        return "Promocion{" +
                "idPromocion=" + idPromocion +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
