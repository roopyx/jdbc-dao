package entities;

import utils.DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductoDAOImpleJDBC implements ProductoDAO
{
    @Override
    public Producto find (int idProducto)
    {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql = "";

        sql += "SELECT id_producto";
        sql += ", descripcion";
        sql += ", id_proveedor";
        sql += ", id_categoria";
        sql += ", precio_unitario";
        sql += ", unidades_stock";
        sql += ", unidades_reposicion";
        sql += ", flg_discontinuo";
        sql += " FROM producto";
        sql += " WHERE id_producto = ?";

        try
        {
            Connection connection = DataAccess.getConnection();

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idProducto);

            resultSet = preparedStatement.executeQuery();

            Producto producto = null;
            Proveedor proveedor;
            Categoria categoria;

            if (resultSet.next())
            {
                producto = new Producto();
                producto.setIdProducto(resultSet.getInt("id_producto"));
                producto.setDescripcion(resultSet.getString("descripcion"));

                int idProveedor = resultSet.getInt("id_proveedor");
                ProveedorDAO proveedorDAO = DataAccess.getObject("proveedorDAO");
                proveedor = proveedorDAO.find(idProveedor);

                producto.setProveedor(proveedor);

                int idCategoria = resultSet.getInt("id_categoria");
                CategoriaDAO categoriaDAO = DataAccess.getObject("categoriaDao");
                categoria = categoriaDAO.find(idCategoria);

                producto.setCategoria(categoria);
                producto.setPrecioUnitario(resultSet.getDouble("precio_unitario"));
                producto.setUnidadesStock(resultSet.getInt("unidades_stock"));
                producto.setUnidadesReposicion(resultSet.getInt("unidades_reposicion"));
                producto.setFlgDiscontinuo(resultSet.getInt("flg_discontinuo"));
            }
            return producto;
        }
        catch (Exception ex )
        {
            ex.printStackTrace();
            throw new RuntimeException();
        }
        finally
        {
            try
            {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
            }
            catch (Exception ex2)
            {
                ex2.printStackTrace();
                throw new RuntimeException();
            }
        }
    }
}
