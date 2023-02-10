package dao;

import databases.JDBCUtil;
import model.Sach;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SachDAO implements DAOInterface<Sach>{

    public static SachDAO getInstance() {
        return new SachDAO();
    }

    @Override
    public int insert(Sach sach) {
        int ketQua = 0;
        try {
            Connection connect = JDBCUtil.getConnection();
            Statement st = connect.createStatement();
            String sql = "INSERT INTO book (id, tenSach, giaBan, namXuatBan)" +
                    " VALUES('"+sach.getId()+"','"+sach.getTenSach()+"',"+sach.getGiaBan()+","+sach.getNamXuatBan()+")";

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
    public int update(Sach sach) {
        int ketQua = 0;
        try {
            Connection connect = JDBCUtil.getConnection();
            Statement st = connect.createStatement();
            String sql = "UPDATE book " +
                        " SET " +
                        " tenSach = '" + sach.getTenSach() + "'" +
                        ", giaBan = "+ sach.getGiaBan()+
                        ", namXuatBan = "+ sach.getNamXuatBan()+
                        " WHERE id = '" + sach.getId() + "'";

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
    public int delete(Sach sach) {
        int ketQua = 0;
        try {
            Connection connect = JDBCUtil.getConnection();
            Statement st = connect.createStatement();
            String sql = "DELETE FROM book " +
                    "WHERE id = '" + sach.getId() + "'";

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
    public ArrayList<Sach> selectAll() {
        return null;
    }

    @Override
    public Sach selectById(Sach sach) {
        return null;
    }

    @Override
    public ArrayList<Sach> selectByCondition(String condition) {
        return null;
    }
}
