package entities;

import utils.DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProveedorDAOImpleJDBC implements ProveedorDAO
{
    @Override
    public Proveedor find (int idProveedor)
    {
        PreparedStatement  preparedStatement = null;
        ResultSet resultSet = null;

        String sql = "";

        sql += "SELECT idProveedor, empresa, contacto, descripcion";
        sql += " FROM proveedor";
        sql += " WHERE id_proveedor = ?";

        try
        {
            Connection connection = DataAccess.getConnection();

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idProveedor);

            resultSet = preparedStatement.executeQuery();

            Proveedor proveedor = null;
            if (resultSet.next())
            {
                proveedor = new Proveedor();
                proveedor.setIdProveedor(resultSet.getInt("id_proveedor"));
                proveedor.setEmpresa(resultSet.getString("empresa"));
                proveedor.setContacto(resultSet.getString("contacto"));
                proveedor.setDireccion(resultSet.getString("direccion"));
            }
            return proveedor;
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
