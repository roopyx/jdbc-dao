package entities;

import utils.DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public interface TipoClienteDAO {
    TipoCliente find(int idTipoCliente);

}