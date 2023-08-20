package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;

import Model.Tinh;
import Model.Thisinh;
import View.DangKy;
import View.LoginFrame;
import View.QLSINHVIEN;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;
public class controQLSV implements ActionListener{
           
			QLSINHVIEN viewqlsv;
			LoginFrame loginframe;
			DangKy dangky;
	public controQLSV(QLSINHVIEN viewqlsv) {
			    
				this.viewqlsv = viewqlsv;
			}
	public controQLSV(LoginFrame loginframe) {
		this.loginframe=loginframe;
	}
	public controQLSV(DangKy dangky) {
		this.dangky=dangky;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String scr=e.getActionCommand();
		System.out.println("ban vua thuc hien nut "+scr);
//hiẻn thị ra màn hinhf thứ trạng thái donhf ta vừa nhấn 
		
	
    if(scr.equals("Thêm")) {

	    	 this.viewqlsv.xoaForm();
	    	 this.viewqlsv.qlsvmodel.setLuachon("Thêm");
	 }else if(scr.equals("Lưu")){ 
		 int luachon=JOptionPane.showConfirmDialog(viewqlsv,"bạn có chắc chắn muốn "+scr);
			if(luachon==JOptionPane.YES_OPTION) {
				   try {
				this.viewqlsv.Luu();
			     }catch(Exception e2) {
			    		e2.printStackTrace();
			    	}
			}else {
				
		    		if(luachon==JOptionPane.YES_OPTION) {
		    			return ;
		            }
				return ;
			}
	    
	            
       }else if(scr.equals("Cập...")){ 
        	  this.viewqlsv.capNhat();
	   
       }else if(scr.equals("Xóa")) {
    	       this.viewqlsv.thucHienXoa();
       }else if(scr.equals("Tìm Kiếm")) {
    	   if(this.viewqlsv.textdiem.getText().equals("")) {
    		     this.viewqlsv.TimKiemsv();
    	   }else if(this.viewqlsv.textField_mav.getText().equals("")) { 
    		   this.viewqlsv.Indiem();
    		  
    	   }else if(this.viewqlsv.textField_mav.getText().equals("")&&this.viewqlsv.textdiem.getText().equals("")){
    		   int gtri=JOptionPane.showConfirmDialog(this.viewqlsv,"vui lòng nhập masv hoặc điểm");
	    		if(gtri==JOptionPane.YES_OPTION) {
	    			return ;
	            }
    		   return ;
    	   }
       }else if(scr.equals("SelectALL")) {
    	   JOptionPane.showMessageDialog(viewqlsv,"bạn có chắc chắn muốn "+scr);
    	   this.viewqlsv.thucHienLuuDuLieu();
       }else if(scr.equals("AboutMe")) {
    	   JOptionPane.showMessageDialog(viewqlsv," hhahhaha ");
    	   //hiển thị option
       }else  if(scr.equals("Open")) {
    	   this.viewqlsv.thucHienOpenFile();
       }else  if(scr.equals("Save")) {
    	     this.viewqlsv.thucHienSaveFile();
       }else  if(scr.equals("Exit")) {
    	   this.viewqlsv.ThoatChuongTrinh();
       }else  if(scr.equals("Hủy Tìm")) {
    	   this.viewqlsv.HuyTim();
	    
      }else  if(scr.equals("DeTable")) {
   	   this.viewqlsv.xoaTrenTable();
	    
      }else  if(scr.equals("Excel")) {
    	  JOptionPane.showMessageDialog(viewqlsv,"bạn có chắc chắn muốn "+scr);
      	   try {
			this.viewqlsv.Excel();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
   	    
         
	}else if(scr.equals("Đăng Nhập")) {
		  try {
			this.loginframe.dangNhap();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	else if(scr.equals("Đăng Ký")) {
		  this.loginframe.dangkytk();
		  this.loginframe.dispose();
	}else if(scr.equals("Quyên Mật Khẩu")) {
		  this.loginframe.layTaiKhoan();
	
	
	}
	
	}
}
