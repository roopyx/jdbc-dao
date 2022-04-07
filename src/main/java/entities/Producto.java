package entities;

import java.util.Objects;

public class Producto
{
    private int idProducto;
    private String descripcion;
    private Proveedor proveedor;
    private Categoria categoria;
    private double precioUnitario;
    private int unidadesStock;
    private int unidadesReposicion;
    private int flgDiscontinuo;

    public Producto () {}

    public Producto (int idProducto)
    {
        this.idProducto = idProducto;
    }

    public Producto(int idProducto,
                    String descripcion,
                    Proveedor proveedor,
                    Categoria categoria,
                    double precioUnitario,
                    int unidadesStock,
                    int unidadesReposicion,
                    int flgDiscontinuo)
    {
        this.idProducto = idProducto;
        this.descripcion = descripcion;
        this.proveedor = proveedor;
        this.categoria = categoria;
        this.precioUnitario = precioUnitario;
        this.unidadesStock = unidadesStock;
        this.unidadesReposicion = unidadesReposicion;
        this.flgDiscontinuo = flgDiscontinuo;
    }

    public int getIdProducto()
    {
        return idProducto;
    }

    public void setIdProducto(int idProducto)
    {
        this.idProducto = idProducto;
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
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

    public double getPrecioUnitario()
    {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario)
    {
        this.precioUnitario = precioUnitario;
    }

    public int getUnidadesStock()
    {
        return unidadesStock;
    }

    public void setUnidadesStock(int unidadesStock)
    {
        this.unidadesStock = unidadesStock;
    }

    public int getUnidadesReposicion()
    {
        return unidadesReposicion;
    }

    public void setUnidadesReposicion(int unidadesReposicion)
    {
        this.unidadesReposicion = unidadesReposicion;
    }

    public int getFlgDiscontinuo()
    {
        return flgDiscontinuo;
    }

    public void setFlgDiscontinuo(int flgDiscontinuo)
    {
        this.flgDiscontinuo = flgDiscontinuo;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return idProducto == producto.idProducto &&
                Double.compare(producto.precioUnitario, precioUnitario) == 0 &&
                unidadesStock == producto.unidadesStock &&
                unidadesReposicion == producto.unidadesReposicion &&
                flgDiscontinuo == producto.flgDiscontinuo &&
                Objects.equals(descripcion, producto.descripcion) &&
                Objects.equals(proveedor, producto.proveedor) &&
                Objects.equals(categoria, producto.categoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                idProducto,
                descripcion,
                proveedor,
                categoria,
                precioUnitario,
                unidadesStock,
                unidadesReposicion,
                flgDiscontinuo);
    }

    @Override
    public String toString() {
        return "Producto{" +
                "idProducto=" + idProducto +
                ", descripcion='" + descripcion + '\'' +
                ", proveedor=" + proveedor +
                ", categoria=" + categoria +
                ", precioUnitario=" + precioUnitario +
                ", unidadesStock=" + unidadesStock +
                ", unidadesReposicion=" + unidadesReposicion +
                ", flgDiscontinuo=" + flgDiscontinuo +
                '}';
    }
}
