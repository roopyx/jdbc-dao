import entities.Cliente;
import entities.ClienteDAO;
import entities.TipoCliente;
import utils.JdbcUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class Main
{
    public static void main(String[] args) throws SQLException {
        ClienteDAO dao = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setNombre("Lazlo");
        cliente.setDireccion("Av. Del Libertador 123");
        cliente.setTipoCliente(new TipoCliente(1));

        dao.insert(cliente);

        // transaccion
        Connection connection = JdbcUtil.getConnection();
        connection.setAutoCommit(false);
        connection.commit();
    }
}
