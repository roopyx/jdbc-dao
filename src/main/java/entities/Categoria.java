package entities;

import java.util.Objects;

public class Categoria
{
    private int idCategoria;
    private String descripcion;

    public Categoria () {}

    public Categoria (int idCategoria)
    {
        this.idCategoria = idCategoria;
    }

    public Categoria (int idCategoria, String descripcion)
    {
        this.idCategoria = idCategoria;
        this.descripcion = descripcion;
    }

    public int getIdCategoria()
    {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria)
    {
        this.idCategoria = idCategoria;
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
        Categoria categoria = (Categoria) o;
        return idCategoria == categoria.idCategoria &&
                Objects.equals(descripcion, categoria.descripcion);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(idCategoria, descripcion);
    }

    @Override
    public String toString()
    {
        return "Categoria{" +
                "idCategoria=" + idCategoria +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
