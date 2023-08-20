package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controller.controQLSV;
import DAO.DaoQLSV;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class DangKy extends JFrame {
	ActionListener action=new controQLSV(this);
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
    public JButton btnNewButton;
    public JButton quyenMk;
    public JLabel lblNewLabel;
    public JLabel lbDangKy;
    public JButton btDangKy ;
    public JRadioButton btnHienThi ;
    public  JTextField texttk;
    public  JTextField textpass;
    public  JTextField textEmail;
	public JLabel lblEmail;
    public JLabel passdk;
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public DangKy() {
		getContentPane().setForeground(new Color(128, 0, 0));
		getContentPane().setLayout(null);
		
		texttk = new JTextField();
		texttk.setBounds(194, 37, 142, 42);
		getContentPane().add(texttk);
		texttk.setColumns(10);
		
		JLabel lbDk = new JLabel("Tài Khoản");
		lbDk.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbDk.setBounds(70, 41, 85, 31);
		getContentPane().add(lbDk);
		
		textpass = new JTextField();
		textpass.setColumns(10);
		textpass.setBounds(194, 90, 142, 42);
		getContentPane().add(textpass);
		
		textEmail = new JTextField();
		textEmail.setForeground(new Color(128, 0, 64));
		textEmail.setColumns(10);
		textEmail.setBounds(194, 149, 142, 42);
		getContentPane().add(textEmail);	
		
		JLabel passdk = new JLabel("Pass");
		passdk.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passdk.setBounds(70, 94, 85, 31);
		getContentPane().add(passdk);
		
		 lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmail.setBounds(70, 163, 85, 31);
		getContentPane().add(lblEmail);
		
		btDangKy = new JButton("Đăng Ký");
		btDangKy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			  taikhoandangky();
			}
		});
		 btDangKy.setBounds(219, 227, 89, 23);
		 getContentPane().add(btDangKy);
		this.setSize(600,300);
		this.setVisible(true);
	}
	public void taikhoandangky() {
		
		  String taikhoan=this.texttk.getText();
		  String pass=this.textpass.getText();
		  String Email=this.textEmail.getText();
		  DaoQLSV.getInfor().capNhatTaiKhoan(taikhoan,pass,Email);
		  
		  int gtri=JOptionPane.showConfirmDialog(this,"đăng kí thành công");
  		if(gtri==JOptionPane.YES_OPTION) {
  			
          }
  		new LoginFrame();
  		 dispose();
				
		
	}
}
