package entities;

import utils.DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProveedorCategoriaImpleJDBC implements ProveedorCategoriaDAO
{
    @Override
    public ProveedorCategoria find (int idProveedorCategoria)
    {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql = "";

        sql += "SELECT pc.id_proveedor_categoria AS pcIdProveedorCategoria";
        sql += ", pc.id_proveedor AS pcIdProveedor";
        sql += ", pc.id_categoria AS pcIdCategoria";
        sql += ", p.id_proveedor AS pIdProveedor";
        sql += ", p.empresa AS pEmpresa";
        sql += ", p.contacto AS pContacto";
        sql += ", p.direccion AS pDireccion";
        sql += ", c.id_categoria AS cIdCategoria";
        sql += ", c.descripcion AS cDescripcion";
        sql += " FROM proveedor_categoria pc, proveedor p, categoria c";
        sql += " WHERE pc.id_proveedor = p.id_proveedor";
        sql += " AND pc.id_categoria = c.id_categoria";
        sql += " AND pc.id_proveedor_categoria = ?";

        try
        {
            Connection connection = DataAccess.getConnection();

            preparedStatement =connection.prepareStatement(sql);
            preparedStatement.setInt(1, idProveedorCategoria);

            resultSet = preparedStatement.executeQuery();

            ProveedorCategoria proveedorCategoria = null;
            if (resultSet.next())
            {
                proveedorCategoria = new ProveedorCategoria();
                proveedorCategoria.setIdProveedorCategoria(resultSet.getInt("pcIdProveedorCategoria"));

                Proveedor proveedor = new Proveedor();
                proveedor.setIdProveedor(resultSet.getInt("pIdProveedor"));
                proveedor.setEmpresa(resultSet.getString("pEmpresa"));
                proveedor.setContacto(resultSet.getString("pContacto"));
                proveedor.setDireccion(resultSet.getString("pDireccion"));

                Categoria categoria = new Categoria();
                categoria.setIdCategoria(resultSet.getInt("cIdCategoria"));
                categoria.setDescripcion(resultSet.getString("cDescripcion"));

                proveedorCategoria.setProveedor(proveedor);
                proveedorCategoria.setCategoria(categoria);
            }
            return proveedorCategoria;
        }
        catch (Exception ex)
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
