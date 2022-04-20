package entities;

import utils.DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OrdenDAOImpleJDBC implements OrdenDAO{

    @Override
    public Orden find(int idOrden) {
        PreparedStatement pstm = null;
        ResultSet rs = null;

        String sql = "";

        sql += "SELECT * FROM orden";
        sql += " WHERE id_orden = ?";

        try {
            Connection conn = DataAccess.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, idOrden);

            Orden orden = null;
            if(rs.next()) {
                orden = new Orden();
                orden.setIdOrden(rs.getInt("id_orden"));

                ClienteDAOImpleJDBC daoCl = new ClienteDAOImpleJDBC();
                orden.setCliente(daoCl.find(rs.getInt("id_cliente")));

                EmpleadoDAOImpleJDBC daoEmp = new EmpleadoDAOImpleJDBC();
                orden.setEmpleado(daoEmp.find(rs.getInt("id_empleado")));

                orden.setFechaGenerada(rs.getDate("fecha_generada"));
                orden.setFechaEntregada(rs.getDate("fecha_entregada"));
            }
            return orden;
        }
        catch(Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException();
        }
        finally {
            try {
                if (rs != null) rs.close();
                if (pstm != null) pstm.close();
            }
            catch(Exception ex2) {
                ex2.printStackTrace();
                throw new RuntimeException();
            }
        }
    }
}
