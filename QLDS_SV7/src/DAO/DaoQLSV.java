package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.QLSV;
import Model.Thisinh;
import Model.Tinh;
import dataBase.ConnectDateBase;

public class DaoQLSV  {
	   
   public static DaoQLSV getInfor() {
	   return new DaoQLSV();
   }
 
   public  int insertDB(Thisinh t) {
		
	   try { 
		 
	  		 // bước 1;kết nối với lại sql
	             Connection conection= ConnectDateBase.getConect();
	     
	            /*  bước 2 :tạo ra 1 đối tượng stament xác định lun 
	               
	              */
	  		  
	  	   
	  		   
	  		/*bước 3 thưcj hiện câu lệnh sql
	  		 * nếu có sự thay đổi thêm dòng thì phải dùng lệnh excuseupdate
	  		 */
	           String sql= "INSERT INTO  sinhvien(id, ten, quequan, ngaysinh, gioitinh, diem15p, diemhk, diemtb) "
	              		+ "VALUES (?,?,?,?,?,?,?,?)";//++","++","++","++")";
	          java.sql.PreparedStatement st=conection.prepareStatement(sql);
	          st.setString(1,t.getMasv());
	          st.setString(2,t.getTen());
	          st.setString(3,t.quequan.gettenTinh());
	          st.setString(4,t.getNgaysinh());
	          st.setBoolean(5,t.isGioitinh());
	          st.setDouble(6,t.getDiemtoan());
	          st.setDouble(7,t.getDiemli());
	          st.setDouble(8,t.getDiemhoa());
	          int ketqua=st.executeUpdate(sql);
	           
	           /*bước 4 sử lí kế quả
	            *  check nó sẻ cho biết con số lượng dòng thay đổi
	            * - check>0 nễu có 1 dòng thay đổi 
	               ngược lại thêm bị thất bại
	            */
	           System.out.println("số dòng thay đổi la:  "+ketqua);
	           if(ketqua>0) {
	          	 System.out.println("thêm dữ liệu thành công");
	          	 System.out.println("xuat giá tri đuọc them vào"+sql);
	           }else {
	          	 System.out.println("thêm dữ liệu thất bại ");
	           }
	           
	          
	           /* bước 5 close chương gtrinh;
	            * 
	            */
	           ConnectDateBase.closeConnect(conection);
	   
	   } catch (SQLException e) {
	  		// TODO Auto-generated catch block
	  		e.printStackTrace();
	  	}
	   
	   
	   
	   return 0;
}


public int upDATEData(Thisinh t) {
	   try { 	
	
	// bước 1;kết nối với lại sql
		    Connection conection= ConnectDateBase.getConect();
		
		   /*  bước 2 :tạo ra 1 đối tượng stament xác định lun 
		      
		     */
			  
			   
			/*bước 3 thưcj hiện câu lệnh truy vấn sql
			 * nếu có sự thay đổi thêm dòng thì phải dùng lệnh excuseupdate
			 */
		  String sql="UPDATE sinhvien"
		  		+ " SET "+
		  	"id=?,ten=?,quequan=?,ngaysinh=?,gioitinh=?,diem15p=?,diemhk=?,diemtb=? WHERE id=?";
		 
		  java.sql.PreparedStatement st=conection.prepareStatement(sql);
          st.setString(1,t.getMasv());
          st.setString(2,t.getTen());
          st.setString(3,t.quequan.gettenTinh());
          st.setString(4,t.getNgaysinh());
          st.setBoolean(5,t.isGioitinh());
          st.setDouble(6,t.getDiemtoan());
          st.setDouble(7,t.getDiemli());
          st.setDouble(8,t.getDiemhoa());
          
		  int ketqua=st.executeUpdate();
		 
		  
		  /*bước 4 sử lí kế quả
		   *  check nó sẻ cho biết con số lượng dòng thay đổi
		   * - check>0 nễu có 1 dòng thay đổi 
		      ngược lại thêm bị thất bại
		   */
		  System.out.println("số dòng thay đổi la:  "+ketqua);
		  if(ketqua>0) {
		 	 System.out.println("thêm dữ liệu thành công");
		 	// System.out.println("xuat giá tri đuọc them vào"+sql);
		  }else {
		 	 System.out.println("thêm dữ liệu thất bại ");
		  }
		  
		 
		  /* bước 5 close chương gtrinh;	
		   * 
		   */
		  ConnectDateBase.closeConnect(conection);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}




return 0;
}


public int delete(Thisinh t) {
	  try { 	
			
			// bước 1;kết nối với lại sql
				    Connection conection= ConnectDateBase.getConect();
				
				   /*  bước 2 :tạo ra 1 đối tượng stament xác định lun 
				      
				     */
					   
				
					   
					/*bước 3 thưcj hiện câu lệnh truy vấn sql
					 * nếu có sự thay đổi thêm dòng thì phải dùng lệnh excuseupdate
					 */
				  String sql="DELETE from sinhvien"+" WHERE id=?";
				  
				  java.sql.PreparedStatement st=conection.prepareStatement(sql);
		          st.setString(1,t.getMasv());
		          
				  int ketqua=st.executeUpdate();
				 
				  
				  /*bước 4 sử lí kế quả
				   *  check nó sẻ cho biết con số lượng dòng thay đổi
				   * - check>0 nễu có 1 dòng thay đổi 
				      ngược lại thêm bị thất bại
				   */
				  System.out.println("số dòng thay đổi la:  "+ketqua);
				  if(ketqua>0) {
				 	 System.out.println("xóa dữ liệu thành công");
				 	 System.out.println("xuat giá tri đuọc them vào"+sql);
				  }else {
				 	 System.out.println("xóa dữ liệu thất bại ");
				  }
				  
				 
				  /* bước 5 close chương gtrinh;
				   * 
				   */
				  ConnectDateBase.closeConnect(conection);
				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
return 0;


}

//@Override
public ArrayList<Thisinh> selectAll() { 
	ArrayList<Thisinh> arrayList = new ArrayList<Thisinh>();
	 try { 	
			
			// bước 1;kết nối với lại sql
				    Connection conection=  ConnectDateBase.getConect();
				
				   /*  bước 2 :tạo ra 1 đối tượng stament xác định lun 
				      
				     */
					   java.sql.Statement st=conection.createStatement();
				
					   
					/*bước 3 thưcj hiện câu lệnh truy vấn sql
					 * nếu có sự thay đổi thêm dòng thì phải dùng lệnh excuseuteQuery 
					 * là câu lệnh truy vấn trả về class reusultset giống như table bên 
					 * trong lấy dữ liệu ra
					 *
					 * 
					 */
				  String sql="SELECT* FROM sinhvien";
				  ResultSet ketqua=st.executeQuery(sql);


				  
				  /*bước 4 sử lí kế quả dùng next() để lấy dữ liệu từ các dong ra 
				   *    và sử dụng ten và có 2 cách lấy ra la đánh tên cột tương uứng với dữ liệu cột lấy ra hoặc đánh
				   *    thứ tự cột 
				   */
				 
				  while(ketqua.next()) {
				    	String id=ketqua.getString("id");
				    	String tenThisinh=ketqua.getString("ten");
				    	String quequan=ketqua.getString("quequan");
				    	Tinh tinh=Tinh.getTinhByTen(quequan+"");
				    	String ngaysinh=ketqua.getString("ngaysinh");
				    	
				    	boolean gioitinh=ketqua.getBoolean("gioitinh");
				    	
				         double diem15p =ketqua.getDouble("diem15p");
				         double diemhk =ketqua.getDouble("diemhk");
				         double diemtb =ketqua.getDouble("diemtb");
				    	
				    	
				    	
				    	
						arrayList.add(new Thisinh(id,tenThisinh,tinh,ngaysinh,gioitinh,diem15p,diemhk,diemtb));
				    }
				  
				 
				  /* bước 5 close chương gtrinh;
				   * 
				   */
				  ConnectDateBase.closeConnect(conection);
				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	return arrayList ;
}


public Thisinh slectByid(String idm) {
	Thisinh kq=null;
	try { 	
		
		// bước 1;kết nối với lại sql
			    Connection conection= ConnectDateBase.getConect();;
			
			   /*  bước 2 :tạo ra 1 đối tượng stament xác định lun 
			      
			     */
				  
			
				   
				/*bước 3 thưcj hiện câu lệnh truy vấn sql
				 * nếu có sự thay đổi thêm dòng thì phải dùng lệnh excuseuteQuery 
				 * là câu lệnh truy vấn trả về class reusultset giống như table bên 
				 * trong lấy dữ liệu ra
				 *
				 * 
				 */
			  String sql="SELECT* FROM sinhvien where id=?";
			  java.sql.PreparedStatement st=conection.prepareStatement(sql);
	          st.setString(1,idm);
			  ResultSet ketqua=st.executeQuery();


			  
			  /*bước 4 sử lí kế quả dùng next() để lấy dữ liệu từ các dong ra 
			   *    và sử dụng ten và có 2 cách lấy ra la đánh tên cột tương uứng với dữ liệu cột lấy ra hoặc đánh
			   *    thứ tự cột 
			   */
			 
			  while(ketqua.next()) {
			    	String id=ketqua.getString("id");
			    	String tenThisinh=ketqua.getString("ten");
			    	String quequan=ketqua.getString("quequan");
			    	Tinh tinh=Tinh.getTinhByTen(quequan+"");
			    	String ngaysinh=ketqua.getString("ngaysinh");
			    	
			    	boolean gioitinh=ketqua.getBoolean("gioitinh");
			    	
			         double diem15p =ketqua.getDouble("diem15p");
			         double diemhk =ketqua.getDouble("diemhk");
			         double diemtb =ketqua.getDouble("diemtb");
			    
					kq=(new Thisinh(id,tenThisinh,tinh,ngaysinh,gioitinh,diem15p,diemhk,diemtb));
			    
			  
			    }
			 
			  /* bước 5 close chương gtrinh;
			   * 
			   */
			  ConnectDateBase.closeConnect(conection);
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	return kq;
}


public ArrayList<Thisinh> selectByCondition(String condition) {
	ArrayList<Thisinh> arrayList = new ArrayList();
	 try { 	
			
			// bước 1;kết nối với lại sql
				    Connection conection=  ConnectDateBase.getConect();				
				   /*  bước 2 :tạo ra 1 đối tượng stament xác định lun 
				      
				     */
					  
					/*bước 3 thưcj hiện câu lệnh truy vấn sql
					 * nếu có sự thay đổi thêm dòng thì phải dùng lệnh excuseuteQuery 
					 * là câu lệnh truy vấn trả về class reusultset giống như table bên 
					 * trong lấy dữ liệu ra
					 *
					 * 
					 */
					   // condition là điêf kiện
				  String sql="SELECT* FROM sinhvien where diemtb=?";
				  java.sql.PreparedStatement st=conection.prepareStatement(sql);
		          st.setString(1,condition);
				  ResultSet ketqua=st.executeQuery();


				  
				  /*bước 4 sử lí kế quả dùng next() để lấy dữ liệu từ các dong ra 
				   *    và sử dụng ten và có 2 cách lấy ra la đánh tên cột tương uứng với dữ liệu cột lấy ra hoặc đánh
				   *    thứ tự cột 
				   */
				 
				    while(ketqua.next()) {
				    	String id=ketqua.getString("id");
				    	String tenThisinh=ketqua.getString("ten");
				    	String quequan=ketqua.getString("quequan");
				    	Tinh tinh=Tinh.getTinhByTen(quequan+"");
				    	String ngaysinh=ketqua.getString("ngaysinh");
				    	
				    	boolean gioitinh=ketqua.getBoolean("gioitinh");
				    	
				         double diem15p =ketqua.getDouble("diem15p");
				         double diemhk =ketqua.getDouble("diemhk");
				         double diemtb =ketqua.getDouble("diemtb");
				    	
						arrayList.add(new Thisinh(id,tenThisinh,tinh,ngaysinh,gioitinh,diem15p,diemhk,diemtb));
				    }
				  
				  
//				 
				  /* bước 5 close chương gtrinh;
				   * 
				   */
				  //  ConnectDateBase.closeConnect(conection);	
				    
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	return arrayList ;

	
}
//
////public int upDATE2(Thisinh t) {
////	           
////	 try { 	
////			
////			// bước 1;kết nối với lại sql
////				    Connection conection= dataJBDC.getConnection();
////				
////				   /*  bước 2 :tạo ra 1 đối tượng stament xác định lun 
////				      
////				     */
////					   java.sql.Statement st=conection.createStatement();
////				
////					   
////					/*bước 3 thưcj hiện câu lệnh truy vấn sql
////					 * nếu có sự thay đổi thêm dòng thì phải dùng lệnh excuseupdate
////					 */
////				  String sql="UPDATE Thisinh"
////				  		+ " SET "
////				  		     + "tenThisinh='"+t.setTenThisinh('')+"', gia="+t.setGiaban(11)+", nam="+t.setNam(4)+" WHERE id='"+t.setId("s02")+"\'";
////				 
////				  int ketqua=st.executeUpdate(sql);
////				 
////				  
////				  /*bước 4 sử lí kế quả
////				   *  check nó sẻ cho biết con số lượng dòng thay đổi
////				   * - check>0 nễu có 1 dòng thay đổi 
////				      ngược lại thêm bị thất bại
////				   */
////				  System.out.println("số dòng thay đổi la:  "+ketqua);
////				  if(ketqua>0) {
////				 	 System.out.println("thêm dữ liệu thành công");
////				 	 System.out.println("xuat giá tri đuọc them vào"+sql);
////				  }else {
////				 	 System.out.println("thêm dữ liệu thất bại ");
////				  }
////				  
////				 
////				  /* bước 5 close chương gtrinh;
////				   * 
////				   */
////				  dataJBDC.closeConection(conection);
////				
////				} catch (SQLException e) {
////					// TODO Auto-generated catch block
////					e.printStackTrace();
////				}
////
////
////
////
////		return 0;
//}
     

//     public boolean dangNhapJDBC(String idLogin, String pass) {
//    	 ResultSet ketqua = null;
//    	 try { 	
// 			
// 			// bước 1;kết nối với lại sql
// 				    Connection conection=  ConnectDateBase.getConect();				
// 				   /*  bước 2 :tạo ra 1 đối tượng stament xác định lun 
// 				      
// 				     */
// 					  
// 					/*bước 3 thưcj hiện câu lệnh truy vấn sql
// 					 * nếu có sự thay đổi thêm dòng thì phải dùng lệnh excuseuteQuery 
// 					 * là câu lệnh truy vấn trả về class reusultset giống như table bên 
// 					 * trong lấy dữ liệu ra
// 					 *
// 					 * 
// 					 */
// 					   // condition là điêf kiện
// 				  String sql="SELECT* FROM login Where idLogin=? and pass=?";
// 				  java.sql.PreparedStatement st=conection.prepareStatement(sql);
// 				  
// 		          st.setString(1,idLogin);
// 		          st.setString(2,pass);
// 				   ketqua=st.executeQuery(sql);
//
//
// 				  
// 				  /*bước 4 sử lí kế quả dùng next() để lấy dữ liệu từ các dong ra 
// 				   *    và sử dụng ten và có 2 cách lấy ra la đánh tên cột tương uứng với dữ liệu cột lấy ra hoặc đánh
// 				   *    thứ tự cột 
// 				   */
// 				 
// 				  
// 				  
//
// 				    
// 				} catch (SQLException e) {
// 					// TODO Auto-generated catch block
// 					e.printStackTrace();
// 				}
//     
//           if(ketqua==null){
//    		          return false;
//    	         }
// 			return true;
//
//           }
public boolean dangNhapJDBC(String idLogin, String pass) throws SQLException {
	 ResultSet ketqua = null;
	 try { 	
		
		
		 Connection conection= ConnectDateBase.getConect();

		 /*  bước 2 :tạo ra 1 đối tượng stament xác định lun 
		   
		  */
		    java.sql.Statement st=conection.createStatement();

		    
		 /*bước 3 thưcj hiện câu lệnh truy vấn sql
		  * nếu có sự thay đổi thêm dòng thì phải dùng lệnh excuseupdate
		  */
		    String sql="SELECT* FROM login Where idLogin='"+idLogin+
		    		
		    		"'and pass='"+pass+"'";
		   
		    ketqua=st.executeQuery(sql);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 
      if(!ketqua.next()){
		          return false;
	         }
		return true;

      }

public int capNhatTaiKhoan(String taikhoan,String pass,String Email) {
	  try { 
			 
	  		 // bước 1;kết nối với lại sql
	             Connection conection= ConnectDateBase.getConect();
	     
	            /*  bước 2 :tạo ra 1 đối tượng stament xác định lun 
	               
	              */
	  		  
	  	   
	  		   
	  		/*bước 3 thưcj hiện câu lệnh sql
	  		 * nếu có sự thay đổi thêm dòng thì phải dùng lệnh excuseupdate
	  		 */
	           String sql= "INSERT INTO login(idLogin, pass, email) VALUES(?,?,?)";//++","++","++","++")";
	          java.sql.PreparedStatement st=conection.prepareStatement(sql);
	          st.setString(1,taikhoan);
	          st.setString(2,pass);
	          st.setString(3,Email);
	          
	          int ketqua=st.executeUpdate();
	           
	           /*bước 4 sử lí kế quả
	            *  check nó sẻ cho biết con số lượng dòng thay đổi
	            * - check>0 nễu có 1 dòng thay đổi 
	               ngược lại thêm bị thất bại
	            */
	           System.out.println("số dòng thay đổi la:  "+ketqua);
	           if(ketqua>0) {
	          	 System.out.println("thêm dữ liệu thành công");
	          	 System.out.println("xuat giá tri đuọc them vào"+sql);
	           }else {
	          	 System.out.println("thêm dữ liệu thất bại ");
	           }
	           
	          
	           /* bước 5 close chương gtrinh;
	            * 
	            */
	           ConnectDateBase.closeConnect(conection);
	   
	   } catch (SQLException e) {
	  		// TODO Auto-generated catch block
	  		e.printStackTrace();
	  	}
	   
	   
	   
	  
	return 0;
}
public ArrayList<String> EmailTaikhoan(String email) {
	   ArrayList<String> chuoitk=new ArrayList<String>();
	   ResultSet ketqua=null;
	try { 	
		
		// bước 1;kết nối với lại sql
			    Connection conection= ConnectDateBase.getConect();;
			
			   /*  bước 2 :tạo ra 1 đối tượng stament xác định lun 
			      
			     
				   
				/*bước 3 thưcj hiện câu lệnh truy vấn sql
				 * nếu có sự thay đổi thêm dòng thì phải dùng lệnh excuseuteQuery 
				 * là câu lệnh truy vấn trả về class reusultset giống như table bên 
				 * trong lấy dữ liệu ra
				 *
				 * 
				 */
			  String sql="SELECT* FROM  login Where email=?";
			  java.sql.PreparedStatement st=conection.prepareStatement(sql);
	          st.setString(1,email);
			   ketqua=st.executeQuery();
			 
				   while(ketqua.next()) {
				  String taikhoan=ketqua.getString("idLogin");
				  String passWord=ketqua.getString("pass");
				  chuoitk.add(taikhoan);
				  chuoitk.add(passWord);
				  
			  } 
			   
			 
			  System.out.println("mamuidb"+email);
              System.out.println("idLogin"+chuoitk.get(0));
			
			 
			  /* bước 5 close chương gtrinh;
			   * 
			   */
			  ConnectDateBase.closeConnect(conection);
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
 

      return chuoitk;
}

}
