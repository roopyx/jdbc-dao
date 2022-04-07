package entities;

import java.util.Objects;

public class ProveedorCategoria
{
    private int idProveedorCategoria;
    private Proveedor proveedor;
    private Categoria categoria;

    public ProveedorCategoria () {}

    public ProveedorCategoria (int idProveedorCategoria)
    {
        this.idProveedorCategoria = idProveedorCategoria;
    }

    public int getIdProveedorCategoria()
    {
        return idProveedorCategoria;
    }

    public void setIdProveedorCategoria(int idProveedorCategoria)
    {
        this.idProveedorCategoria = idProveedorCategoria;
    }

    public Proveedor getProveedor()
    {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor)
    {
        this.proveedor = proveedor;
    }

    public Categoria getCategoria()
    {
        return categoria;
    }

    public void setCategoria(Categoria categoria)
    {
        this.categoria = categoria;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProveedorCategoria that = (ProveedorCategoria) o;
        return idProveedorCategoria == that.idProveedorCategoria &&
                Objects.equals(proveedor, that.proveedor) &&
                Objects.equals(categoria, that.categoria);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(idProveedorCategoria, proveedor, categoria);
    }

    @Override
    public String toString()
    {
        return "ProveedorCategoria{" +
                "idProveedorCategoria=" + idProveedorCategoria +
                ", proveedor=" + proveedor +
                ", categoria=" + categoria +
                '}';
    }
}
