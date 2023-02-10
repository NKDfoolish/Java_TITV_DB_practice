package dao;

import databases.JDBCUtil;
import model.Sach;

import java.sql.Connection;
import java.sql.ResultSet;
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
            // b1: tao ket noi csdl
            Connection connect = JDBCUtil.getConnection();

            // b2: tao ra doi tuong statement
            Statement st = connect.createStatement();

            //b3: thuc thi cau lenh sql
            String sql = "INSERT INTO book (id, tenSach, giaBan, namXuatBan)" +
                    " VALUES('"+sach.getId()+"','"+sach.getTenSach()+"',"+sach.getGiaBan()+","+sach.getNamXuatBan()+")";

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
        ArrayList<Sach> ketQua = new ArrayList<Sach>();
        try {
            Connection connect = JDBCUtil.getConnection();
            Statement st = connect.createStatement();
            String sql = "SELECT * FROM book";

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()){
                String id = rs.getString("id");
                String tenSach = rs.getString("tenSach");
                Float giaban = rs.getFloat("giaBan");
                int namXuatban = rs.getInt("namXuatban");

                Sach sach = new Sach(id,tenSach,giaban,namXuatban);
                ketQua.add(sach);
            }

            JDBCUtil.closeConnection(connect);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketQua;
    }

    @Override
    public Sach selectById(Sach sach) {
        Sach ketQua = null;
        try {
            Connection connect = JDBCUtil.getConnection();
            Statement st = connect.createStatement();
            String sql = "SELECT * FROM book where id = '" + sach.getId() + "'";

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()){
                String id = rs.getString("id");
                String tenSach = rs.getString("tenSach");
                Float giaban = rs.getFloat("giaBan");
                int namXuatban = rs.getInt("namXuatban");

                ketQua = new Sach(id,tenSach,giaban,namXuatban);
            }

            JDBCUtil.closeConnection(connect);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketQua;
    }

    @Override
    public ArrayList<Sach> selectByCondition(String condition) {
        ArrayList<Sach> ketQua = new ArrayList<Sach>();
        try {
            Connection connect = JDBCUtil.getConnection();
            Statement st = connect.createStatement();
            String sql = "SELECT * FROM book where " + condition;

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()){
                String id = rs.getString("id");
                String tenSach = rs.getString("tenSach");
                Float giaban = rs.getFloat("giaBan");
                int namXuatban = rs.getInt("namXuatban");

                Sach sach = new Sach(id,tenSach,giaban,namXuatban);
                ketQua.add(sach);
            }

            JDBCUtil.closeConnection(connect);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketQua;
    }
}
