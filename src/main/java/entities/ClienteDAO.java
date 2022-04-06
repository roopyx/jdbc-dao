package entities;

import java.util.List;

public interface ClienteDAO
{
    public Cliente find ( int idCliente );

    public List<Cliente> findByTipoCliente ( int idTipoCliente );

    public void insert ( Cliente cliente );

    public void update ( Cliente cliente );

    public void delete ( int idCliente );

}

