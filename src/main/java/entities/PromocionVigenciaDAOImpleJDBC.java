package entities;

import utils.DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PromocionVigenciaDAOImpleJDBC implements PromocionVigenciaDAO {
    @Override
    public PromocionVigencia find(int idPromocionVigencia) {
        PreparedStatement pstm = null;
        ResultSet rs = null;

        String sql = "";
        sql += "SELECT * FROM promocion_vigencia";
        sql += " WHERE id_promocion_vigencia = ?";

        try {
            Connection conn = DataAccess.getConnection();

            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, idPromocionVigencia);

            rs = pstm.executeQuery();

            PromocionVigencia promocionVigencia = null;
            if (rs.next()) {
                promocionVigencia = new PromocionVigencia();
                promocionVigencia.setIdPromocionVigencia(rs.getInt("id_promocion_vigencia"));

                Promocion promocion = new Promocion();
                promocion.setIdPromocion(rs.getInt("id_promocion"));
                promocion.setDescripcion(rs.getString("descripcion"));

                promocionVigencia.setPromocion(promocion);
                promocionVigencia.setFechaInicio(rs.getDate("fecha_inicio"));
                promocionVigencia.setFechaFin(rs.getDate("fecha_fin"));
            }
            return promocionVigencia;
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
