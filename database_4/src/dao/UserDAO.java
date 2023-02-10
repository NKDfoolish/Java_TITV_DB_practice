package dao;

import databases.JDBCUtil;
import model.User;

import java.sql.*;
import java.util.ArrayList;

public class UserDAO implements DAOInterface<User>{

    public static UserDAO getInstance() {
        return new UserDAO();
    }

    @Override
    public int insert(User user) {
        int ketQua = 0;
        try {
            // b1: tao ket noi csdl
            Connection connect = JDBCUtil.getConnection();

            //b3: thuc thi cau lenh sql
            String sql = "INSERT INTO user (username, password, hovaten)" +
                    " VALUES(?,?,?)";

            // b2: tao ra doi tuong statement
            PreparedStatement pst = connect.prepareStatement(sql);
            pst.setString(1,user.getUsername());
            pst.setString(2,user.getPassword());
            pst.setString(3,user.getHovaten());

            ketQua = pst.executeUpdate();

            //b4: xu ly them (thong bao)
            System.out.println("Ban da thuc thi "+sql);
            System.out.println("Co "+ketQua+" dong bi thay doi");

            //b5: ngat ket noi voi csdl
            JDBCUtil.closeConnection(connect);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketQua;
    }

    @Override
    public int update(User user) {
        int ketQua = 0;
        try {
            Connection connect = JDBCUtil.getConnection();
            String sql = "UPDATE user " +
                        " SET " +
                        " password = ?" +
                        ", hovaten = ?" +
                        " WHERE username = ?";
            PreparedStatement st = connect.prepareStatement(sql);
            st.setString(1,user.getPassword());
            st.setString(2,user.getHovaten());
            st.setString(3,user.getUsername());

            ketQua = st.executeUpdate();

            System.out.println("Ban da thuc thi "+sql);
            System.out.println("Co "+ketQua+" dong bi thay doi");

            JDBCUtil.closeConnection(connect);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketQua;
    }

    @Override
    public int delete(User user) {
        int ketQua = 0;
        try {
            Connection connect = JDBCUtil.getConnection();
            String sql = "DELETE FROM user " +
                    "WHERE username = ?";
            PreparedStatement st = connect.prepareStatement(sql);
            st.setString(1, user.getUsername());

            ketQua = st.executeUpdate();

            System.out.println("Ban da thuc thi "+sql);
            System.out.println("Co "+ketQua+" dong bi thay doi");

            JDBCUtil.closeConnection(connect);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketQua;
    }

    @Override
    public ArrayList<User> selectAll() {
        ArrayList<User> ketQua = new ArrayList<User>();
        try {
            Connection connect = JDBCUtil.getConnection();
            String sql = "SELECT * FROM user";
            PreparedStatement st = connect.prepareStatement(sql);

            ResultSet rs = st.executeQuery();

            while (rs.next()){
                String username = rs.getString("username");
                String password = rs.getString("password");
                String hovaten = rs.getString("hovaten");

                User user = new User(username,password,hovaten);
                ketQua.add(user);
            }

            JDBCUtil.closeConnection(connect);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketQua;
    }

    @Override
    public User selectById(User user) {
        User ketQua = null;
        try {
            Connection connect = JDBCUtil.getConnection();
            String sql = "SELECT * FROM user where username = ?";
            PreparedStatement st = connect.prepareStatement(sql);
            st.setString(1, user.getUsername());

            System.out.println(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()){
                String username = rs.getString("username");
                String password = rs.getString("password");
                String hovaten = rs.getString("hovaten");

                ketQua = new User(username,password,hovaten);
            }

            JDBCUtil.closeConnection(connect);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketQua;
    }

    @Override
    public ArrayList<User> selectByCondition(String condition) {
        return null;
    }

    /*@Override
    public ArrayList<User> selectByCondition(String condition) {
        ArrayList<User> ketQua = new ArrayList<User>();
        try {
            Connection connect = JDBCUtil.getConnection();
            Statement st = connect.createStatement();
            String sql = "SELECT * FROM book where " + condition;

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()){
                String id = rs.getString("id");
                String tenUser = rs.getString("tenUser");
                Float giaban = rs.getFloat("giaBan");
                int namXuatban = rs.getInt("namXuatban");

                User user = new User(id,tenUser,giaban,namXuatban);
                ketQua.add(user);
            }

            JDBCUtil.closeConnection(connect);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketQua;
    }*/
}
