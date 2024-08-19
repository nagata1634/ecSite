package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.beans.Product;

public class CartDaoImpl implements CartDao{

    private static String RDB_DRIVE = "org.mariadb.jdbc.Driver";
    private static String URL = "jdbc:mariadb://localhost/ecSite";
    private static String USER = "root";
    private static String PASS = "";

    static {
        try {
            Class.forName(RDB_DRIVE);
        } catch(ClassNotFoundException e) {
            throw new IllegalStateException("JDBCドライバが読み込めませんでした");
        }
    }

    @Override
    public boolean addCart(int userId, int productId) {
        String sql = "INSERT INTO `cart`(`USERID`, `PRODUCTID`) VALUES (?,?)";

        try(Connection conn = DriverManager.getConnection(URL,USER,PASS)) {
            PreparedStatement pStmt = conn.prepareStatement(sql);

            pStmt.setInt(1, userId);
            pStmt.setInt(2, productId);

            pStmt.executeUpdate();

            return true;
        } catch(SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Product> getCartList(int userId) {
        String sql ="SELECT product.* FROM product LEFT JOIN cart ON product.ID = cart.PRODUCTID WHERE cart.USERID =  ?";
        List<Product> list = new ArrayList<>();
        try(Connection conn = DriverManager.getConnection(URL,USER,PASS)) {
            PreparedStatement pStmt = conn.prepareStatement(sql);

            pStmt.setInt(1, userId);

            ResultSet rs = pStmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("NAME");
                String extension = rs.getString("EXTENSION");
                int aPieces = rs.getInt("PIECES");
                int price = rs.getInt("PRICE");
                String imagePath = rs.getString("IMAGEPATH");

                Product pro = new Product
                        .Builder(id, name)
                        .extension(extension)
                        .pieces(aPieces)
                        .price(price)
                        .imagePath(imagePath)
                        .build();

                list.add(pro);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
