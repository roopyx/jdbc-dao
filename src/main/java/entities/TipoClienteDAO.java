package entities;

import utils.DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TipoClienteDAO
{
    public TipoCliente find ( int idTipoCliente )
    {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql = "";

        sql += "SELECT idTipoCiente,";
        sql += ", descripcion";
        sql += " FROM tipo_cliente";
        sql += " WHERE id_tipo_cliente = ?";

        try
        {
            Connection connection = DataAccess.getConnection();

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idTipoCliente);

            resultSet = preparedStatement.executeQuery();

            TipoCliente tipoCliente = null;
            if ( resultSet.next() )
            {
                tipoCliente = new TipoCliente();
                tipoCliente.setIdTipoCliente(resultSet.getInt("id_tipo_cliente"));
                tipoCliente.setDescripcion("descripcion");
            }
            return tipoCliente;
        }
        catch ( Exception e )
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        finally
        {
            try
            {
                if ( resultSet != null ) resultSet.close();
                if ( preparedStatement != null ) preparedStatement.close();
            }
            catch ( Exception e2 )
            {
                e2.printStackTrace();
                throw new RuntimeException();
            }
        }
    }
}