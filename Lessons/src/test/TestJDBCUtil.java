package test;

import databases.JDBCUtil;

import java.sql.Connection;

public class TestJDBCUtil {
    public static void main(String[] args) {
        Connection connection = JDBCUtil.getConnection();

        JDBCUtil.printInfo(connection);

        JDBCUtil.closeConnection(connection);
    }
}
