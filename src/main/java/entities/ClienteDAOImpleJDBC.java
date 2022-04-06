package entities;

import utils.DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAOImpleJDBC implements ClienteDAO
{
    @Override
    public Cliente find ( int idCliente )
    {
        PreparedStatement pstm = null;
        ResultSet rs = null;

        String sql = "";

        sql += "SELECT c.id_cliente AS cIdCliente";
        sql += ", c.nombre AS cNombre";
        sql += ", c.direccion AS cDireccion";
        sql += ", c.id_tipo_cliente AS cIdTipoCliente";
        sql += ", tc.descripcion AS tcDescripcion";
        sql += " FROM cliente c, tipo_cliente tc";
        sql += " WHERE c.id_tipo_cliente = tc.id_tipo_cliente";
        sql += " AND c.id_cliente = ?";

        try
        {
            // Conexion, sentencia preparada y resultset
            Connection conn = DataAccess.getConnection();

            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, idCliente);

            rs = pstm.executeQuery();

            Cliente cliente = null;
            if ( rs.next() )
            {
                cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("cIdCliente"));
                cliente.setNombre(rs.getString("cNombre"));
                cliente.setDireccion(rs.getString("cDireccion"));

                // tipo de cliente
                TipoCliente tipoCliente = new TipoCliente();
                tipoCliente.setIdTipoCliente(rs.getInt("cIdTipoCliente"));
                tipoCliente.setDescripcion(rs.getString("tcDescripcion"));

                // asignacion del objeto tipoCliente
                cliente.setTipoCliente(tipoCliente);
            }
            return cliente;
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
                if ( rs != null ) rs.close();
                if ( pstm != null ) pstm.close();
            }
            catch ( Exception e2 )
            {
                e2.printStackTrace();
                throw new RuntimeException();
            }
        }
    }

    @Override
    public List<Cliente> findByTipoCliente (int idTipoCliente )
    {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql = "";
        sql += "SELECT id_cliente";
        sql += " FROM cliente";
        sql += " WHERE id_tipo_cliente = ?";

        try
        {
            Connection connection = DataAccess.getConnection();

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idTipoCliente);

            resultSet = preparedStatement.executeQuery();

            List<Cliente> listadoClientes = new ArrayList<>();
            while ( resultSet.next() )
            {
                int idCliente = resultSet.getInt("id_cliente");
                Cliente cliente = find(idCliente);
                listadoClientes.add(cliente);
            }
            return listadoClientes;
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
                throw new RuntimeException(e2);
            }
        }
    }

    @Override
    public void insert (Cliente cliente)
    {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql = "";

        sql += "INSERT INTO cliente (nombre, direccion, id_tipo_cliente)";
        sql += "VALUES (?, ?, ?)";

        try
        {
            Connection connection = DataAccess.getConnection();

            preparedStatement = connection.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);

            // asignacion de parametros
            preparedStatement.setString(1, cliente.getNombre());
            preparedStatement.setString(2, cliente.getDireccion());
            preparedStatement.setInt(3, cliente.getTipoCliente().getIdTipoCliente());

            // ejecucion update
            int rtdo = preparedStatement.executeUpdate();

            if ( rtdo == 1 )
            {
                // recuperacion del id
                resultSet = preparedStatement.getGeneratedKeys();
                if ( resultSet.next() )
                {
                    // asignacion del id generado
                    int id = resultSet.getInt(1);
                    cliente.setIdCliente(id);
                }
            }
            else
            {
                throw new RuntimeException("Error en insert");
            }
        }
        catch ( Exception ex )
        {
            ex.printStackTrace();
            throw new RuntimeException(ex);
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
                throw new RuntimeException(e2);
            }
        }
    }

    @Override
    public void update ( Cliente cliente )
    {
        PreparedStatement preparedStatement = null;

        String sql = "";
        sql += "UPDATE cliente";
        sql += " SET nombre = ?";
        sql += ", direccion = ?";
        sql += ", id_tipo_cliente = ?";
        sql += " WHERE id_cliente = ?";

        try
        {
            Connection connection = DataAccess.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            // asignacion de parametros
            preparedStatement.setString(1, cliente.getNombre());
            preparedStatement.setString(2, cliente.getDireccion());
            preparedStatement.setInt(3, cliente.getTipoCliente().getIdTipoCliente());
            preparedStatement.setInt(4, cliente.getIdCliente());

            // ejecucion del update
            int rtdo = preparedStatement.executeUpdate();

            if ( rtdo != 1 )
            {
                throw new RuntimeException("Error en update");
            }
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
                if ( preparedStatement != null ) preparedStatement.close();
            }
            catch (Exception ex2)
            {
                ex2.printStackTrace();
                throw new RuntimeException(ex2);
            }
        }
    }

    @Override
    public void delete ( int idCliente )
    {
        PreparedStatement preparedStatement = null;

        String sql = "";

        sql += "DELETE FROM cliente WHERE id_cliente = ?";

        try
        {
            Connection connection = DataAccess.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            // asignamiento de parametros
            preparedStatement.setInt(1, idCliente);

            // ejecucion del uptdate
            int rtdo = preparedStatement.executeUpdate();

            if ( rtdo != 1 )
            {
                throw new RuntimeException("Error en update");
            }
        }
        catch ( Exception ex )
        {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        finally
        {
            try
            {
                if ( preparedStatement != null ) preparedStatement.close();
            }
            catch (Exception ex2)
            {
                ex2.printStackTrace();
                throw new RuntimeException(ex2);
            }
        }
     }

}
