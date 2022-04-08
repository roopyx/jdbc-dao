package entities;

import java.util.List;

public interface Facade
{
    public List<Categoria> obtenerCategorias ();
    public List<Producto> obtenerProductos (int idCategoria);
}
