package entities;

import utils.DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmpleadoDAOImpleJDBC implements EmpleadoDAO {
    @Override
    public Empleado find (int idEmpleado) {
        PreparedStatement pstm = null;
        ResultSet rs = null;

        String sql = "";
        sql += "SELECT * FROM empleado";
        sql += " WHERE id_empleado = ?";

        try {
            Connection con = DataAccess.getConnection();

            pstm = con.prepareStatement(sql);
            pstm.setInt(1, idEmpleado);

            rs = pstm.executeQuery();

            Empleado empleado = null;
            if (rs.next()) {
                empleado = new Empleado();
                empleado.setIdEmpleado(rs.getInt("id_empleado"));
                empleado.setNombre(rs.getString("nombre"));

                EmpleadoDAOImpleJDBC dao = new EmpleadoDAOImpleJDBC();
                Empleado jefe = dao.find(rs.getInt("id_jefe"));

                empleado.setIdJefe(jefe);
            }
            return empleado;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException();
        }
        finally {
            try {
                if (rs != null) rs.close();
                if (pstm != null ) pstm.close();
            }
            catch (Exception ex2) {
                ex2.printStackTrace();
                throw new RuntimeException();
            }
        }
    }
}
