import entities.*;
import utils.DataAccess;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main
{
    private Scanner scanner = new Scanner(System.in);

    public int pantalla1 ()
    {
        System.out.println("Seleccione una categoria");

        Facade f = DataAccess.getObject("facade");
        List<Categoria> categorias = f.obtenerCategorias();

        for(Categoria cat: categorias)
        {
            System.out.print(cat.getIdCategoria());
            System.out.println(cat.getDescripcion());
        }
        return scanner.nextInt();
    }

    public int pantalla2 (int idCat)
    {
        System.out.println("-Productos de la categoria-");

        Facade f = DataAccess.getObject("facade");
        List<Producto> productos = f.obtenerProductos(idCat);

        for(Producto prod: productos)
        {
            System.out.print(prod.getIdProducto());
            System.out.println(prod.getDescripcion());
        }
        return scanner.nextInt();
    }

    public static void main(String[] args) throws SQLException
    {
        Main app = DataAccess.getObject("miApp");

        int idCat = app.pantalla1();

        app.pantalla2(idCat);

    }
}
