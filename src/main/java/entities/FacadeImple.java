package entities;

import utils.DataAccess;

import java.util.List;

public class FacadeImple implements Facade
{
    public List<Categoria> obtenerCategorias ()
    {
        CategoriaDAO dao = DataAccess.getObject("categoriaDAO");
        List<Categoria> categorias = dao.findAllCategorias();
        return categorias;
    }

    public List<Producto> obtenerProductos (int idCategoria)
    {
        ProductoDAO dao = DataAccess.getObject("productoDAO");
        List<Producto> productos = dao.findProductos(idCategoria);
        return productos;
    }
}
