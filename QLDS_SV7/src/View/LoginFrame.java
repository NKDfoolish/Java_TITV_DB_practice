package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.controQLSV;
import DAO.DaoQLSV;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
    public JButton btnNewButton;
    public JButton quyenMk;
    public JLabel lblNewLabel;
    public JLabel lblNewLabel_1;
    public JButton ButtonDn ;
    public JRadioButton btnHienThi ;
    DangKy dangky;
    private JButton quyenmk;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public LoginFrame()  {
		ActionListener action=new controQLSV(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 0, 0));
		contentPane.setForeground(new Color(0, 0, 160));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBackground(new Color(255, 255, 255));
		textField.setBounds(222, 46, 112, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(222, 100, 112, 33);
		contentPane.add(passwordField);
		
		 lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(132, 44, 61, 33);
		contentPane.add(lblNewLabel);
		
	    lblNewLabel_1 = new JLabel("PassWord");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(124, 107, 88, 14);
		contentPane.add(lblNewLabel_1);
		
		ButtonDn = new JButton("Đăng Nhập");
		ButtonDn.setBackground(new Color(255, 0, 0));
		ButtonDn.setForeground(new Color(128, 0, 0));
		ButtonDn.addActionListener(action);
		ButtonDn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ButtonDn.setBounds(108, 184, 122, 33);
		contentPane.add(ButtonDn);
		
		 btnNewButton = new JButton("Đăng Ký");
		 btnNewButton.setForeground(new Color(128, 0, 128));
		 btnNewButton.setBackground(new Color(255, 0, 0));
		 btnNewButton.addActionListener(action);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(273, 184, 89, 30);
		contentPane.add(btnNewButton);
		
		btnHienThi = new JRadioButton("Hiển Thị");
		btnHienThi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(btnHienThi.isSelected()) {
				
					 passwordField.setEchoChar((char)0);
			        }
			        else{
			            
			       passwordField.setEchoChar('*');
			        
				 }
			}
		});
		
		btnHienThi.setBounds(340, 105, 109, 23);
		contentPane.add(btnHienThi);
		
		quyenmk = new JButton("Quyên Mật Khẩu");
		quyenmk.setBounds(179, 150, 193, 23);
		contentPane.add(quyenmk);
		quyenmk.addActionListener(action);
		 
		 
		 this.setVisible(true);
		
	}
	public void dangNhap() throws SQLException {
		String id=this.textField.getText();
		
		String pass=this.passwordField.getText();
		 if(this.textField.getText().equals("")||this.passwordField.getText().equals("")){
  		   int gtri=JOptionPane.showConfirmDialog(this,"vui lòng nhập pass hoặc tài khoản");
	    		if(gtri==JOptionPane.YES_OPTION) {
	    			return ;
	            }
	}else {
	      boolean  gtrave=DaoQLSV.getInfor().dangNhapJDBC(id, pass);
	      System.out.println(DaoQLSV.getInfor().dangNhapJDBC(id, pass));
	      if(gtrave==true) {
	    	  try {
	    			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	    			   new QLSINHVIEN();
	    			   dispose();// thoát hàm đăng nhập đầu tiên
	    		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
	    				| UnsupportedLookAndFeelException e) {
	    			
	    			e.printStackTrace();
	    		}
	      }
	      else {
	    	  int gtri=JOptionPane.showConfirmDialog(this,"Tài khoản hoặc pass không đúng ");
	    		if(gtri==JOptionPane.YES_OPTION) {
	    			
	            }

	    	  this.textField.setText("");
	    	  this.passwordField.setText("");
	    	 return ;
	      }
	}
}
	
	public void dangkytk() {
	
		Thread t=new Thread(()->{
			new DangKy();
			
		});
		t.start();
		
	}
	public void layTaiKhoan() {
		new quyenTk();
	}
	
}
