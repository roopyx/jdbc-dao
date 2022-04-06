import entities.*;
import utils.DataAccess;
import utils.Transaction;

import java.sql.SQLException;

public class Main
{
    public static void main(String[] args) throws SQLException
    {

        // Comienzo de la transaccion
        Transaction transaction = DataAccess.beginTransaction();

        Cliente cliente = new Cliente();
        cliente.setNombre("Alejandra");
        cliente.setDireccion("Santa Julia 442");
        cliente.setTipoCliente(new TipoCliente(1));

        ClienteDAO dao = DataAccess.getObject("clienteDAO");
        dao.insert(cliente);

        // finalizacion de la transaccion
        transaction.commit();

    }
}
