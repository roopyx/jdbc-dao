package entities;

import java.sql.Date;
import java.util.Objects;

public class PromocionVigencia {
    private int idPromocionVigencia;
    private Promocion promocion;
    private Date fechaInicio;
    private Date fechaFin;

    public PromocionVigencia() {}

    public PromocionVigencia(int idPromocionVigencia,
                             Promocion promocion,
                             Date fechaInicio,
                             Date fechaFin) {
        this.idPromocionVigencia = idPromocionVigencia;
        this.promocion = promocion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public int getIdPromocionVigencia() {
        return idPromocionVigencia;
    }

    public void setIdPromocionVigencia(int idPromocionVigencia) {
        this.idPromocionVigencia = idPromocionVigencia;
    }

    public Promocion getPromocion() {
        return promocion;
    }

    public void setPromocion(Promocion promocion) {
        this.promocion = promocion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PromocionVigencia that = (PromocionVigencia) o;
        return idPromocionVigencia == that.idPromocionVigencia &&
                Objects.equals(promocion, that.promocion) &&
                Objects.equals(fechaInicio, that.fechaInicio) &&
                Objects.equals(fechaFin, that.fechaFin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPromocionVigencia,
                promocion, fechaInicio, fechaFin);
    }

    @Override
    public String toString() {
        return "PromocionVigencia{" +
                "idPromocionVigencia=" + idPromocionVigencia +
                ", promocion=" + promocion +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                '}';
    }
}
