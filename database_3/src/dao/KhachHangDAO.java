package dao;

import databases.JDBCUtil;
import model.KhachHang;
import model.Sach;

import java.sql.*;
import java.util.ArrayList;

public class KhachHangDAO implements DAOInterface<KhachHang> {

    public static KhachHangDAO getInstance(){
        return new KhachHangDAO();
    }

    @Override
    public int insert(KhachHang khachHang) {
        int ketQua = 0;
        try {
            // b1: tao ket noi csdl
            Connection connect = JDBCUtil.getConnection();

            // b2: tao ra doi tuong statement
            Statement st = connect.createStatement();

            //b3: thuc thi cau lenh sql
            String sql = "INSERT INTO customers (hoVaTen, ngaySinh, diaChi)" +
                    " VALUES('"+khachHang.getHoVaTen()+"','"
                    +khachHang.getNgaySinh()+"','"+khachHang.getDiaChi()+"')";

            ketQua = st.executeUpdate(sql);

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
    public int update(KhachHang khachHang) {
        int ketQua = 0;
        try {
            Connection connect = JDBCUtil.getConnection();
            Statement st = connect.createStatement();
            String sql = "UPDATE customers " +
                    " SET " +
                    " hoVaTen = '" + khachHang.getHoVaTen() + "'" +
                    ", ngaySinh = '"+ khachHang.getNgaySinh()+ "'" +
                    ", diaChi = '"+ khachHang.getDiaChi()+ "'" +
                    " WHERE id = " + khachHang.getId();

            ketQua = st.executeUpdate(sql);

            System.out.println("Ban da thuc thi "+sql);
            System.out.println("Co "+ketQua+" dong bi thay doi");

            JDBCUtil.closeConnection(connect);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketQua;
    }

    @Override
    public int delete(KhachHang khachHang) {
        int ketQua = 0;
        try {
            Connection connect = JDBCUtil.getConnection();
            Statement st = connect.createStatement();
            String sql = "DELETE FROM customers " +
                    "WHERE id = " + khachHang.getId();

            ketQua = st.executeUpdate(sql);

            System.out.println("Ban da thuc thi "+sql);
            System.out.println("Co "+ketQua+" dong bi thay doi");

            JDBCUtil.closeConnection(connect);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketQua;
    }

    @Override
    public ArrayList<KhachHang> selectAll() {
        ArrayList<KhachHang> ketQua = new ArrayList<KhachHang>();
        try {
            Connection connect = JDBCUtil.getConnection();
            Statement st = connect.createStatement();
            String sql = "SELECT * FROM customers ";

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()){
                int id = rs.getInt("id");
                String hoVaTen = rs.getString("hoVaTen");
                Date ngaySinh = rs.getDate("ngaySinh");
                String diaChi = rs.getNString("diaChi");

                KhachHang khachHang = new KhachHang(id,hoVaTen,ngaySinh,diaChi);
                ketQua.add(khachHang);
            }

            JDBCUtil.closeConnection(connect);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketQua;
    }

    @Override
    public KhachHang selectById(KhachHang khachHang) {
        KhachHang ketQua = null;
        try {
            Connection connect = JDBCUtil.getConnection();
            Statement st = connect.createStatement();
            String sql = "SELECT * FROM customers where id = " + khachHang.getId();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()){
                int id = rs.getInt("id");
                String hoVaTen = rs.getString("hoVaTen");
                Date ngaySinh = rs.getDate("ngaySinh");
                String diaChi = rs.getString("diaChi");

                ketQua = new KhachHang(id,hoVaTen,ngaySinh,diaChi);
            }

            JDBCUtil.closeConnection(connect);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketQua;
    }

    @Override
    public ArrayList<KhachHang> selectByCondition(String condition) {
        ArrayList<KhachHang> ketQua = new ArrayList<KhachHang>();
        try {
            Connection connect = JDBCUtil.getConnection();
            Statement st = connect.createStatement();
            String sql = "SELECT * FROM customers where " + condition;

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()){
                int id = rs.getInt("id");
                String hoVaTen = rs.getString("hoVaTen");
                Date ngaySinh = rs.getDate("ngaySinh");
                String diaChi = rs.getString("diaChi");

                KhachHang kh = new KhachHang(id,hoVaTen,ngaySinh,diaChi);
                ketQua.add(kh);
            }

            JDBCUtil.closeConnection(connect);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketQua;
    }
}
