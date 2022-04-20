package entities;

import utils.DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PromocionDAOImpleJDBC implements PromocionDAO {
    @Override
    public Promocion find (int idPromocion) {
        PreparedStatement pstm = null;
        ResultSet rs = null;

        String sql = "";

        sql += "SELECT * FROM promocion";
        sql += " WHERE id_promocion = ?";

        try {
            Connection conn = DataAccess.getConnection();

            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, idPromocion);

            rs = pstm.executeQuery();

            Promocion promocion = null;
            if (rs.next()) {
                promocion = new Promocion();
                promocion.setIdPromocion(rs.getInt("id_promocion"));
                promocion.setDescripcion(rs.getString("descripcion"));
            }
            return promocion;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException();
        }
        finally {
            try {
                if (rs != null) rs.close();
                if (pstm != null) pstm.close();
            }
            catch (Exception ex2) {
                ex2.printStackTrace();
                throw new RuntimeException();
            }
        }
    }
}
