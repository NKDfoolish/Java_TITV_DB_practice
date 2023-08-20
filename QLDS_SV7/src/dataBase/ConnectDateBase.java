package dataBase;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDateBase {
     public static Connection getConect() {
    	 Connection c=null;
    	 try {
    		  String ulr="jdbc:mySQL://localhost:3306/quanly";
    	       String password="";
    	       String user="root";
    	 c=DriverManager.getConnection(ulr, user, password);
    	 }catch(Exception e) {
    		e.printStackTrace(); 
    	 }
    	 return c;
     }
   public static void closeConnect(Connection c) {
	   if(c!=null) {
		   try {
			   c.close();
		   }catch(Exception e) {
			   e.printStackTrace();
		   }
	   }
   }
   public static void printInfor(Connection c) {
		  if(c!=null) {
			  try {
				  // in ra thong ten của hẹ quantricsdl và vesion
				 DatabaseMetaData mbmd=c.getMetaData();
				 System.out.println(mbmd.getDatabaseProductName());
				  // lấy ra thông tin bằng getmetadata của cái bảng sql
				//System.out.println(c.getMetaData().toString());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }

}
 
}
