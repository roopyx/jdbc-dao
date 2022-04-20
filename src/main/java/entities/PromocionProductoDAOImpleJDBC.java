package entities;

import utils.DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PromocionProductoDAOImpleJDBC implements PromocionProductoDAO {
    @Override
    public PromocionProducto find(int idPromocionProducto) {
        PreparedStatement pstm = null;
        ResultSet rs = null;

        String sql = "";
        sql += "SELECT * FROM promocion_producto";
        sql += " WHERE id_promocion_producto = ?";

        try {
            Connection conn = DataAccess.getConnection();
             pstm = conn.prepareStatement(sql);
             pstm.setInt(1, idPromocionProducto);

             rs = pstm.executeQuery();

             PromocionProducto promProd = null;
             if (rs.next()) {
                promProd = new PromocionProducto();

                PromocionVigenciaDAOImpleJDBC promdao = new PromocionVigenciaDAOImpleJDBC();
                PromocionVigencia promvig = promdao.find(rs.getInt("id_promocion_vigencia"));

                ProductoDAOImpleJDBC pdao = new ProductoDAOImpleJDBC();
                Producto prod = pdao.find(rs.getInt("id_producto"));

                promProd.setPromocionVigencia(promvig);
                promProd.setProducto(prod);
                promProd.setDescuento(rs.getDouble("descuento"));
             }
             return promProd;
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