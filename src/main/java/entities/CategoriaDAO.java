package entities;

import java.util.List;

public interface CategoriaDAO
{
    Categoria find(int idCategoria);

    List<Categoria> findAllCategorias();
}
