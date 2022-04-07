package entities;

import utils.DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CategoriaDAOImpleJDBC implements CategoriaDAO
{
    @Override
    public Categoria find (int idCategoria)
    {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql = "";

        sql += "SELECT idCategoria";
        sql += ", descripcion";
        sql += " FROM categoria";
        sql += " WHERE id_categoria = ?";

        try
        {
            Connection connection = DataAccess.getConnection();

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idCategoria);

            resultSet = preparedStatement.executeQuery();

            Categoria categoria = null;
            if (resultSet.next())
            {
                categoria = new Categoria();
                categoria.setIdCategoria(resultSet.getInt("id_categoria"));
                categoria.setDescripcion(resultSet.getString("descripcion"));
            }
            return categoria;
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            throw new RuntimeException(ex);
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
