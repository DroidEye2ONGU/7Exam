package DAO;

import Moudle.User;

import java.sql.*;

public class UserDAO {
    private static final String DBDRIVER = "com.mysql.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://localhost:3306/7exam?useSSL=false";
    private static final String DBUSER = "root";
    private static final String DBPASS = "admin";

    private static UserDAO userDAO = null;
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    private UserDAO() throws ClassNotFoundException {
        Class.forName(DBDRIVER);
    }

    public static UserDAO getUserDAOInstance() {
        if (userDAO == null) {
            try {
                userDAO = new UserDAO();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return userDAO;
    }

    private boolean prepareMySql(String sql) {
        try {
            conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
            pstmt = conn.prepareStatement(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void closeMySql() {
        if (conn != null) {
            try {
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean addNewUser(User user) {
        if (prepareMySql("INSERT INTO user VALUES(?,?,?,?,?,?)")) {
            try {
                pstmt.setString(1, user.getID());
                pstmt.setString(2, user.getName());
                pstmt.setString(3, user.getPass());
                pstmt.setString(4, user.getSex());
                pstmt.setString(5, user.getAge());
                pstmt.setString(6,user.getMail());
                pstmt.executeUpdate();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                closeMySql();
            }
        }
        return false;
    }

    public User queryUser(String ID) {
        User user = null;
        if (prepareMySql("SELECT * FROM user WHERE ID=\'" + ID + "\'")) {
            try {
                rs = pstmt.executeQuery();
                while (rs.next()) {
                    user = new User();
                    user.setID(rs.getString(1));
                    user.setName(rs.getString(2));
                    user.setPass(rs.getString(3));
                    user.setSex(rs.getString(4));
                    user.setAge(rs.getString(5));
                    user.setMail(rs.getString(6));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                closeMySql();
            }
        }
        return user;
    }


}
