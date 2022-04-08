package entities;

import java.util.List;

public interface ProductoDAO
{
    Producto find (int idProducto);

    List<Producto> findProductos(int idCategoria);
}
