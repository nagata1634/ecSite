package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.beans.Product;

public class ProductDaoImpl implements ProductDao {
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
    public List<Product> list(int start, int pieces) {
        String sql = "SELECT * FROM ecSite.Product LIMIT ? OFFSET ?";

        List<Product> list = new ArrayList<>();
        try(Connection conn = DriverManager.getConnection(URL,USER,PASS)) {
            PreparedStatement pStmt = conn.prepareStatement(sql);

            pStmt.setInt(1, start);
            pStmt.setInt(2, pieces);

            ResultSet rs = pStmt.executeQuery();

            while(rs.next()) {
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Product search(int productId) {
        String sql = "SELECT * FROM `product` WHERE `ID` = ?";

        try (Connection conn = DriverManager.getConnection(URL,USER,PASS)) {
            PreparedStatement pStmt = conn.prepareStatement(sql);

            pStmt.setInt(1, productId);

            ResultSet rs = pStmt.executeQuery();

            rs.next();

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

            return pro;
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
