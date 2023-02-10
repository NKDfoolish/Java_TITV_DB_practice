package test;

import databases.JDBCUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBCUtil {
    public static void main(String[] args) {
       /* try {
            // B1: tao ket noi
            Connection connection = JDBCUtil.getConnection();

            // B2: tao ra doi tuong statement
            Statement st = connection.createStatement();

            // B3: Thuc thi 1 cau lenh SQL
            String sql = "INSERT INTO Persons (last_name,firstname,gender,dob,income)" +
                    "VALUES(\"Nguyen\",\"Thuy Tien\",\"F\",\"2001-12-31\",100000000)";

            int check = st.executeUpdate(sql);

            // B4: Xu ly ket qua
            System.out.println("So dong thay doi " + check);
            if(check > 0){
                System.out.println("Them du lieu thanh cong");
            } else {
                System.out.println("Them du lieu that bai");
            }

            // B5: Ngat ket noi
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/



    }
}
