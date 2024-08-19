package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.beans.User;

public class UserDaoImpl implements UserDao {
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
    public User login(String name, String password) {
        String sql = "SELECT * FROM `user` WHERE NAME LIKE ? AND `PASSWORD` LIKE ?";
        try (Connection conn = DriverManager.getConnection(URL,USER,PASS)) {
            PreparedStatement pStmt = conn.prepareStatement(sql);

            pStmt.setString(1, name);
            pStmt.setString(2, password);

            ResultSet rs = pStmt.executeQuery();
            User user = null;
            while (rs.next()) {
                int id = rs.getInt("id");
                String gName = rs.getString("name");
                String imagePath = rs.getString("imagePath");
//                boolean isAdmin = rs.getBoolean("isAdmin");

                user = new User.Builder()
                        .id(id)
                        .name(gName)
                        .userImagePath(imagePath)
//                        .isAdmin(isAdmin)
                        .build();
            }

            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean registration(String name, String password, boolean isAdmin) {
        String sql = "INSERT INTO user (`NAME`, `PASSWORD`) VALUES (?,?)";

        try (Connection conn = DriverManager.getConnection(URL,USER, PASS)) {
            PreparedStatement pStmt = conn.prepareStatement(sql);

            pStmt.setString(1, name);
            pStmt.setString(2, password);

            pStmt.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
