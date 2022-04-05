package entities;

import java.util.Objects;

public class TipoCliente
{
    private int idTipoCliente;
    private String descripcion;

    public TipoCliente () {}

    public TipoCliente(int idTipoCiente, String descripcion)
    {
        this.idTipoCliente = idTipoCiente;
        this.descripcion = descripcion;
    }

    public TipoCliente(int id) {
        this.idTipoCliente = id;
    }

    public int getIdTipoCliente()
    {
        return idTipoCliente;
    }

    public void setIdTipoCliente(int idTipoCliente)
    {
        this.idTipoCliente = idTipoCliente;
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoCliente that = (TipoCliente) o;
        return idTipoCliente == that.idTipoCliente && Objects.equals(descripcion, that.descripcion);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(idTipoCliente, descripcion);
    }

    @Override
    public String toString()
    {
        return "TipoCliente{" +
                "idTipoCiente=" + idTipoCliente +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
