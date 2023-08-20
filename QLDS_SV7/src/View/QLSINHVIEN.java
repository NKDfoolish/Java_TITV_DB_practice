package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.QLSV;
import Model.Thisinh;
import Model.Tinh;


import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;

import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.ComboBoxModel;
import javax.swing.GroupLayout.Group;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Controller.controQLSV;
import DAO.DaoQLSV;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.ScrollPaneConstants;
import java.awt.event.MouseAdapter;
import javax.swing.JList;
import java.awt.Label;
import java.awt.TextField;
public class QLSINHVIEN extends JFrame {
    public  QLSV qlsvmodel;
    public JPanel contentPane;
    public JTextField textField_mav;
    public JTable table;
    public  JRadioButton RadioButtonNam;
    public  JRadioButton RadioButtonNu;
    public JTextField textmontoan;
    public JTextField textFieldmonly;
    public JTextField textHoa;
    public ButtonGroup grGioitinh;
    public JComboBox comboBox_que2;
	  Tinh tinh;
	  public JLabel lbldiem;
	  public JTextField textFieldmsv;
	  public JTextField textTen;
	  public JTextField textdate2;
	private  JButton btnTimKim;
      DaoQLSV daoqlsv;
     public JTextField textdiem;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public QLSINHVIEN() {
		setFont(new Font("Segoe UI", Font.PLAIN, 12));
		ActionListener action=new controQLSV(this);
		
		this.qlsvmodel=new QLSV();
		// set tieu đề cho bài
		this.setTitle("Studen Management");
//	     URL url=QLSINHVIEN.class.getResource("‪D:\\laptrinhJava\\QLDS_SV4\\src\\View\\st3-icon.png");
//		 Image img=Toolkit.getDefaultToolkit().createImage(url);
//	     this.setIconImage(img);
	     
	     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 626, 522);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(10, 8, 424, 31);
		menuBar.setForeground(new Color(255, 0, 0));
		menuBar.setToolTipText("Menu");
		contentPane.add(menuBar);
		
		JMenu mnSetting = new JMenu("Setting");
		mnSetting.setFont(new Font("Segoe UI Variable", Font.PLAIN, 15));
		menuBar.add(mnSetting);
		
		JRadioButton btnbakround = new JRadioButton("backround");
	
		btnbakround.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnbakround.setBackground(new Color(0, 128, 128));
		mnSetting.add(btnbakround);
		btnbakround.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(btnbakround.isSelected()==true) {
					
					 contentPane.setBackground(new Color(0, 0, 0));
			        }
			        else{
			        	 contentPane.setBackground(new Color(240,240 ,240));
			    
			        
				 }
			}
		});
		
		JMenu MenuFile = new JMenu("File");
		MenuFile.setForeground(new Color(255, 0, 0));
		MenuFile.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(MenuFile);
		
		JMenuItem MenuOpen = new JMenuItem("Open");
		MenuOpen.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		MenuOpen.addActionListener(action); 
		MenuFile.add(MenuOpen);
		
		JMenuItem MenuSave = new JMenuItem("Save");
		MenuSave.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		MenuSave.addActionListener(action); 
		MenuFile.add(MenuSave);
		
		JSeparator separator = new JSeparator();
		MenuFile.add(separator);
		
		JMenu About = new JMenu("About");
		About.setForeground(new Color(64, 0, 0));
		About.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(About);
		About.addActionListener(action); 
		
		JMenuItem MenuAbout = new JMenuItem("AboutMe");
		MenuAbout.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		About.add(MenuAbout);
		MenuAbout.addActionListener(action);
		
		JLabel lblMSinhVin = new JLabel("Masv");
		lblMSinhVin.setForeground(new Color(0, 0, 64));
		lblMSinhVin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMSinhVin.setBounds(10, 42, 54, 31);
		contentPane.add(lblMSinhVin);
		
		textField_mav = new JTextField();
		textField_mav.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_mav.setBounds(54, 39, 94, 46);
		contentPane.add(textField_mav);
		textField_mav.setColumns(10);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 83, 615, 2);
		contentPane.add(separator_1);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 SV", "H\u1ECD T\u00EAn", "Qu\u00EA ", "Date", "G T\u00EDnh", "\u0110 To\u00E1n", "\u0110 L\u00FD", "\u0110 h\u00F3a"
			}
		));
		// /============================click của jtable-==============
		table.setRowHeight(25);
		JScrollPane scrollPane = new JScrollPane(table);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getjTable1MouseClicked();
			}
		});
		
		
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 96, 625,129);
		contentPane.add(scrollPane);
		
		JRadioButton RadioButtonNam_1 = new JRadioButton("Nam");
		scrollPane.setColumnHeaderView(RadioButtonNam_1);
		RadioButtonNam_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		RadioButtonNam_1.setBackground(new Color(0, 128, 128));
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(0, 236, 625, 2);
		contentPane.add(separator_1_1);
		
		JLabel lblTtThisinh = new JLabel("TT ThiSinh");
		lblTtThisinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTtThisinh.setBounds(10, 236, 72, 31);
		contentPane.add(lblTtThisinh);
		
		JLabel lbmaSv = new JLabel("Mã SV");
		lbmaSv.setBackground(new Color(0, 128, 64));
		lbmaSv.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbmaSv.setBounds(10, 263, 54, 31);
		contentPane.add(lbmaSv);
		
		JLabel lblHTn = new JLabel("Họ Tên");
		lblHTn.setBackground(new Color(128, 0, 128));
		lblHTn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHTn.setBounds(10, 305, 72, 31);
		contentPane.add(lblHTn);
		
		JLabel lblQuQun = new JLabel("Quê quán");
		lblQuQun.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblQuQun.setBounds(10, 339, 72, 31);
		contentPane.add(lblQuQun);
		
		JLabel lblDate = new JLabel("DATE");
		lblDate.setBackground(new Color(0, 64, 128));
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDate.setBounds(10, 378, 72, 31);
		contentPane.add(lblDate);
		
		 comboBox_que2 = new JComboBox();
		 comboBox_que2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_que2.setBounds(76, 347, 189, 28);
		contentPane.add(comboBox_que2);
		 comboBox_que2.addItem("");
		ArrayList<Tinh>tinhthanh=Tinh.getDSTinh();
		  for(Tinh tinh: tinhthanh) {
		 comboBox_que2.addItem(tinh);
		  }
		JLabel lblGiiTnh = new JLabel("Giới Tính");
		lblGiiTnh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGiiTnh.setBounds(333, 263, 72, 31);
		contentPane.add(lblGiiTnh);
		ArrayList<Tinh>tinhthanh1=Tinh.getDSTinh();
		  for(Tinh tinh: tinhthanh1) {
			  comboBox_que2.addItem(tinh);
		  }
		
		RadioButtonNam = new JRadioButton("Nam");
		RadioButtonNam.setBackground(new Color(0, 128, 128));
		RadioButtonNam.setFont(new Font("Tahoma", Font.PLAIN, 16));
		RadioButtonNam.setBounds(437, 263, 65, 27);
		contentPane.add(RadioButtonNam);
		
		RadioButtonNu = new JRadioButton("Nữ");
		RadioButtonNu.setBackground(new Color(255, 0, 128));
		RadioButtonNu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		RadioButtonNu.setBounds(535, 267, 65, 23);
		contentPane.add(RadioButtonNu);
// dùng froup dể chọn cho 2 nút nhấn vào  và chon 1 trong 2 nút nhấn này thui 	
		 grGioitinh=new ButtonGroup();
		grGioitinh.add(RadioButtonNam);
		grGioitinh.add(RadioButtonNu);
//==================================================================================		
		JLabel diem1 = new JLabel("Điểm Toán");
		diem1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		diem1.setBounds(333, 297, 85, 31);
		contentPane.add(diem1);
		
		JLabel đ2 = new JLabel("Điem lý");
		đ2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		đ2.setBounds(333, 339, 85, 31);
		contentPane.add(đ2);
		
		JLabel mon3 = new JLabel("Điểm Hóa");
		mon3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mon3.setBounds(333, 378, 85, 31);
		contentPane.add(mon3);
		
		textmontoan = new JTextField();
		textmontoan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textmontoan.setColumns(10);
		textmontoan.setBounds(428, 297, 107, 31);
		contentPane.add(textmontoan);
		
		textFieldmonly = new JTextField();
		textFieldmonly.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldmonly.setColumns(10);
		textFieldmonly.setBounds(428, 338, 107, 31);
		contentPane.add(textFieldmonly);
		
		textHoa = new JTextField();
		textHoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textHoa.setColumns(10);
		textHoa.setBounds(426, 378, 109, 31);
		contentPane.add(textHoa);
		
		JButton btThem = new JButton("Thêm");
		btThem.setForeground(new Color(255, 0, 0));
		btThem.setBackground(new Color(255, 0, 0));
		btThem.addActionListener(action); 
		btThem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btThem.setBounds(10, 420, 89, 38);
		contentPane.add(btThem);
		
		JButton btxoa = new JButton("Xóa");
		btxoa.setForeground(new Color(0, 255, 0));
		btxoa.setBackground(Color.RED);
		btxoa.addActionListener(action); 
		btxoa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btxoa.setBounds(124, 420, 89, 40);
		contentPane.add(btxoa);
		
		JButton btnSua = new JButton("Lưu");
		btnSua.setForeground(new Color(0, 0, 255));
		btnSua.addActionListener(action); 
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSua.setBounds(258, 420, 89, 38);
		contentPane.add(btnSua);
		
		JButton btnCp = new JButton("Cập...");
		btnCp.setForeground(new Color(255, 0, 128));
		btnCp.addActionListener(action); 
		btnCp.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCp.setBounds(387, 420, 89, 38);
		contentPane.add(btnCp);
		
		JButton btnTimKim = new JButton("Tìm Kiếm");
		btnTimKim.setForeground(new Color(128, 255, 128));
		btnTimKim.addActionListener(action); 
		btnTimKim.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTimKim.setBounds(333, 36, 85, 43);
		contentPane.add(btnTimKim);
		
		JButton jbHuy = new JButton("SelectALL");
		jbHuy.setForeground(new Color(128, 0, 64));
        jbHuy.addActionListener(action); 
		jbHuy.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jbHuy.setBounds(511, 420, 89, 38);
		contentPane.add(jbHuy);
		
		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setBounds(-10, 420, 625, 2);
		contentPane.add(separator_1_1_1);
		
		textFieldmsv = new JTextField();
		textFieldmsv.setBackground(new Color(255, 255, 255));
		textFieldmsv.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldmsv.setColumns(10);
		textFieldmsv.setBounds(74, 265, 147, 31);
		contentPane.add(textFieldmsv);
		
		textTen = new JTextField();
		textTen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textTen.setColumns(10);
		textTen.setBounds(74, 305, 189, 31);
		contentPane.add(textTen);

		textdate2 = new JTextField();
		textdate2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textdate2.setColumns(10);
		textdate2.setBounds(76, 381, 147, 31);
		contentPane.add(textdate2);
		
		JButton btntimkkienn = new JButton("Hủy Tìm");
		btntimkkienn.setForeground(new Color(255, 0, 0));
		btntimkkienn.addActionListener(action); 
		btntimkkienn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btntimkkienn.setBounds(437, 41, 89, 41);
		contentPane.add(btntimkkienn);
		
		JButton btnNewButton = new JButton("Exit");
		
		btnNewButton.addActionListener(action); 
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 27));
		btnNewButton.setBounds(437, 11, 85, 28);
	
		contentPane.add(btnNewButton);
		
		JButton deleteTAble = new JButton("DeTable");
		deleteTAble.setBackground(new Color(0, 0, 160));
		deleteTAble.setFont(new Font("Tahoma", Font.PLAIN, 14));
		deleteTAble.setForeground(new Color(0, 0, 0));
		deleteTAble.addActionListener(new controQLSV(this) {
			
			
		});
		deleteTAble.setBounds(526, 45, 89, 33);
		contentPane.add(deleteTAble);
		
		JButton excelButton = new JButton("Excel");
		excelButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		excelButton.setBackground(new Color(64, 0, 64));
		excelButton.setBounds(526, 11, 89, 31);
		excelButton.addActionListener(new controQLSV(this) {
			
			
		});
		contentPane.add(excelButton);
		
		textdiem = new JTextField();
		textdiem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textdiem.setColumns(10);
		textdiem.setBounds(205, 42, 107, 38);
		contentPane.add(textdiem);
		
		 lbldiem = new JLabel("Điểm");
		lbldiem.setForeground(new Color(0, 0, 64));
		lbldiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbldiem.setBounds(158, 42, 54, 31);
		contentPane.add(lbldiem);
		
		JLabel lblDeginer = new JLabel("deginer");
		lblDeginer.setForeground(new Color(255, 255, 255));
		lblDeginer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDeginer.setBounds(89, 511, 72, 31);
		contentPane.add(lblDeginer);
		 this.setSize(650,650);
		this.setVisible(true);
		
	}

	public void xoaForm() {
		textFieldmsv.setText("");
		textTen.setText("");
		textdate2.setText("");
		textmontoan.setText("");
		textFieldmonly.setText("");
		textHoa.setText("");
	    comboBox_que2.setSelectedIndex(-1);//-1 la chưa chọn j hết
	    grGioitinh.clearSelection();
		
	}
	//=======================add gtri nhập vào cho bảng table===========================================================
public void themThiSinhVaoBang2(Thisinh ts) {
	 DefaultTableModel model=(DefaultTableModel)table.getModel();
	 model.addRow(new Object[] {
		      ts.getMasv()+"",
	          ts.getTen()+"",
	          ts.getQuequan()+"",
	          (ts.getNgaysinh())+"",
	          (ts.isGioitinh()? "Nam" : "Nữ")+"",
	          ts.getDiemtoan()+"",
	          ts.getDiemli()+"",
	          ts.getDiemhoa()+""});
 }
//=============================================================================
public void DkCapNhat(Thisinh ts) {

	
	DefaultTableModel model=(DefaultTableModel)table.getModel();
	
    	// this.qlsvmodel.update(ts);
    	 // trả về cho đối tượng thí sinh
    	  int SoluongDong= model.getRowCount();//getRowCount() hiển hị tổng số lươgj dòng của table
    	  // duyệt các dòng nào có mã sinh viên ,à trùng với mã sinh viên nhập
    	  // vào thì dòng đó được cập nhâp chèn dữ liệu 
            for(int i=0;i<SoluongDong;i++) {
             String id=model.getValueAt(i,0 )+"";// lấy ra id tại vị trí dòng lần lượt 
            	if(id.equals(ts.getMasv()+"")) {
            		model.setValueAt(ts.getMasv()+"",i,0);
            		model.setValueAt(ts.getTen()+"",i,1);
            		model.setValueAt(ts.getQuequan()+"",i,2);
            		model.setValueAt(ts.getNgaysinh()+"",i,3);
            		model.setValueAt((ts.isGioitinh()? "Nam" : "Nữ")+"",i,4);
            		model.setValueAt(ts.getDiemtoan()+"",i,5);
            		model.setValueAt(ts.getDiemli()+"",i,6);
            		model.setValueAt(ts.getDiemhoa()+"",i,7);
            	}
            }
}


//add các giá trị vào table tư 1 đoi tơng   https://stackoverflow.com/questions/3549206/how-to-add-row-in-jtable
//============================================================================================	
	public void DieuKienNhap(Thisinh ts) {
			DefaultTableModel model=(DefaultTableModel)table.getModel();
		ArrayList<Thisinh>list= this.daoqlsv.getInfor().selectAll();
			for(Thisinh tsinh:list){
			   if(tsinh.getMasv().equals(this.textFieldmsv.getText()+"")) {
		            int luachon=JOptionPane.showConfirmDialog(this,"ma sv nhập bị trùng");
	    		          if(luachon==JOptionPane.YES_OPTION){
	    			          return ;
	                        }
			            }
	    		          else {
	    		        	   this.qlsvmodel.insert(ts);
			                   this.themThiSinhVaoBang2(ts); 
			                   this.daoqlsv.getInfor().insertDB(ts);
			                   return ;
	    		          }
			
			}
	    		// kiem tra ma sv đax tồn tai  hay chưa để thêm
			   //String masv=ts.getMasv()+"";
			  
			 
		//phủ định của mã sinh viên nay đã tồn tai->sinh viên này chauw tồn tại
	
		
	}
///============================= chọn vào hàng để lấy ra dữ liệu của hàng đó ============================================================
	
	
	private void getjTable1MouseClicked() {
	    // lấy ra gtri tư bảng trong hang so bao nhieu
			DefaultTableModel model=(DefaultTableModel)table.getModel();
			   int i_Row=table.getSelectedRow();
			   // nhap vao so hnagg va coy
			   
			   model.getValueAt(i_Row,7 );
			   String masv= ""+ model.getValueAt(i_Row,0 );
			    String ten= model.getValueAt(i_Row,1 )+"";
		       // lây ra cái tinh ơ trong bang
			    
			   Tinh diachi =Tinh.getTinhByTen(model.getValueAt(i_Row,2 )+"");
			     String ngaysinh=   model.getValueAt(i_Row,3 )+"";
			   
			   
			   	 String TextGioiTinh=model.getValueAt(i_Row,4)+"";
			    boolean chonGioiTinh=TextGioiTinh.equals("Nam");	
			    double diemtoan=Double.valueOf(model.getValueAt(i_Row,5)+"");
			    double diemli=Double.valueOf(model.getValueAt(i_Row,6 )+"");
				double diemhoa=Double.valueOf(model.getValueAt(i_Row,7 )+"");
				
			  
				
				this.textFieldmsv.setText(masv);
				 this.textTen.setText(ten);
				 this.comboBox_que2.setSelectedItem(diachi);
				 this.textdate2.setText(ngaysinh);
				 		
				 
				 if(chonGioiTinh==true) {
			 	     this.RadioButtonNam.setSelected(true);
			 	}else if(chonGioiTinh==false) {
			 	     this.RadioButtonNu.setSelected(true);	
			 	  }
				
				    this.textmontoan.setText(diemtoan+"");
				    this.textFieldmonly.setText(diemli+"");
				    this.textHoa.setText(diemhoa+"");
				   
				
	}
	
	//=======================ghi laị toàn bộ dư từ cột vào trong các ô tương ứng đẻ set lại nội dung cua côtk===============================================================
	
	
	public  void HienThiThongTinTroLai() { 
		// xóa dữ liệu từ table để chèn dữ liệu từ sql vào table
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		for(int i=0;i<model.getRowCount();i++) {
			model.removeRow(i);
		}
		Thisinh ts=getCapNhatThongTinSinhVien();
		
		for(Thisinh thisinh:this.daoqlsv.selectAll()) {
			this.Luu();
		}
	   
	}
	
	//=================================================================
	public Thisinh getCapNhatThongTinSinhVien() {
	    // lấy ra gtri tư bảng trong hang so bao nhieu
			DefaultTableModel model=(DefaultTableModel)table.getModel();
			   int i_Row=table.getSelectedRow();
			   // nhap vao so hnagg va coy
			   
			   model.getValueAt(i_Row,7 );
			   String masv= ""+ model.getValueAt(i_Row,0 );
			    String ten= model.getValueAt(i_Row,1 )+"";
		       // lây ra cái tinh ơ trong bang
			    
			   Tinh diachi =Tinh.getTinhByTen(model.getValueAt(i_Row,2 )+"");
			     String ngaysinh1=   model.getValueAt(i_Row,3 )+"";
			     String ngaysinh=   model.getValueAt(i_Row,3 )+"";
				   
			   
			   	 String TextGioiTinh=model.getValueAt(i_Row,4)+"";
			    boolean chonGioiTinh=TextGioiTinh.equals("Nam");	
			    Double diemtoan=Double.valueOf(model.getValueAt(i_Row,5)+"");
			    Double diemli=Double.valueOf(model.getValueAt(i_Row,6 )+"");
				Double diemhoa=Double.valueOf(model.getValueAt(i_Row,7 )+"");
				//nếu gọi conttructor ko tham số thif ta phải dung đói tơngj ko tham số là ts.setmasv=masv
				// khi gtri ở dạng dơn cần set haowcj get  cho 1 gtri thi ta goi ham có đối tượng ts.set như bt
				
			
				Thisinh ts =new Thisinh(masv,ten,diachi,ngaysinh,chonGioiTinh,diemtoan,diemli,diemhoa);
			    
				
				return ts;
	}
	
	//===============================================================================
	
	public void capNhat() {// hàm này lấy thông tin từ bảng ra 
		
	      // sửa  dữ liẹu từ ô mik nhập  ra để luu vào cột trong bảng
		
	// sưa dywx liệu băngd tay chuă lấy dữ liệu từ bảng được 
			String masv=this.textFieldmsv.getText();
		    String ten=this.textTen.getText();
		    int quequan=this.comboBox_que2.getSelectedIndex();
		    Tinh queHuong =Tinh.getTinhById(quequan-1);
		   
		     @SuppressWarnings("deprecation")
			 String ngaysinh=this.textdate2.getText();
		    boolean chonGioiTinh=true;

	         	if(this.RadioButtonNam.isSelected()) {
	         	     chonGioiTinh=true;	
	         	}else if(this.RadioButtonNu.isSelected()) {
	         	     chonGioiTinh=false;	
	         	  }
	         	
		     double diemtoan=Double.parseDouble(this.textmontoan.getText());
		     double diemli=Double.parseDouble(this.textFieldmonly.getText());
			 double diemhoa=Double.parseDouble(this.textHoa.getText());
			 Thisinh ts=new Thisinh(masv,ten,queHuong,ngaysinh,chonGioiTinh,diemtoan,diemli,diemhoa);
       		System.out.println("quư jsbjdb    "+ts.getQuequan());
			 this.DkCapNhat(ts);
       		DaoQLSV.getInfor().upDATEData(ts); //cập nhật đatabase
           	 

	}
//====================================================================================
	
	public void thucHienXoa() {
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		int soHang=table.getSelectedRow();//chọn dong nao để xóa 
		int luachon=JOptionPane.showConfirmDialog(this,"bạn có chắc muốn xóa");
		if(luachon==JOptionPane.YES_OPTION) {
			Thisinh ts=getCapNhatThongTinSinhVien();
			this.qlsvmodel.remove(ts);
			model.removeRow(soHang);
			//thưc hiện xóa ở đatabase
			DaoQLSV.getInfor().delete(ts);
		}
	}
//===================================================================================
	
	
	public void TimKiemsv() {
      
		   if(this.textField_mav.getText().equals("")) {
	    	  int luachon=JOptionPane.showConfirmDialog(this,"vui lòng nhập masv");
	    		if(luachon==JOptionPane.YES_OPTION) {
	    			return ;
	            }
	        }else {
				 while(true) {
					DefaultTableModel model=(DefaultTableModel)table.getModel();
					  int soluongDong=model.getRowCount();
					if(soluongDong==0) {
						break;
					}else {
						try {
						model.removeRow(0);
					}catch (Exception e) {
						e.printStackTrace();
					}
				 }
				}	
			this.themThiSinhVaoBang2(DaoQLSV.getInfor().slectByid(this.textField_mav.getText()+""));
	      // xóa toàn  bộ bảng và truyền dữ liẹu sinh viên đc chọn vào bảng
	          
	  }  
			

}
//=======================================================================================
	
	public void thucHienLuuDuLieu() {
		
		while(true) {
			DefaultTableModel model=(DefaultTableModel)table.getModel();
			  int soluongDong=model.getRowCount();
			if(soluongDong==0) {
				break;
			}else {
				try {
				model.removeRow(0);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	    ArrayList<Thisinh>list= this.daoqlsv.getInfor().selectAll();
		for(Thisinh tsinh:list){
			this.themThiSinhVaoBang2(tsinh);
		}
		
//		for(Thisinh tsinh:this.qlsvmodel.getDsThiSinh()) {
//			this.DieuKienNhap(tsinh);
//		     đocj dữ  liệu tưf danh sách arraylist đã lưu  thí sinh ra  để add vào table 
//	   }
	
	}
	
	//==========================lUU=============================================================
	public void Luu() {
		      // dọc dữ liẹu từ ô mik nhập  ra để luu vào cột trong bảng
		String masv=this.textFieldmsv.getText();
	    String ten=this.textTen.getText();
	    int quequan=this.comboBox_que2.getSelectedIndex();
	    Tinh queHuong =Tinh.getTinhById(quequan-1);
	   
	     @SuppressWarnings("deprecation")
		 String ngaysinh=this.textdate2.getText();
	    boolean chonGioiTinh=true;

         	if(this.RadioButtonNam.isSelected()) {// isSelected()là hàm có sẳn chỉ định chọn 1 trong 2 và ko cần action
         	     chonGioiTinh=true;	
         	}else if(this.RadioButtonNu.isSelected()) {
         	     chonGioiTinh=false;	
         	  }
         	
	     double diemtoan=Double.parseDouble(this.textmontoan.getText());
	     double diemli=Double.parseDouble(this.textFieldmonly.getText());
		 double diemhoa=Double.parseDouble(this.textHoa.getText());
		    System.out.println(queHuong);	
		 Thisinh ts=new Thisinh(masv,ten,queHuong,ngaysinh,chonGioiTinh,diemtoan,diemli,diemhoa);
              this.DieuKienNhap(ts);
             
	}
//=======================================================================================
	
	public void ThoatChuongTrinh() {
		int luaChon = JOptionPane.showConfirmDialog(
			    this,
			    "Bạn có muốn thoải khỏi chương trình?",
			    "Exit",
			    JOptionPane.YES_NO_OPTION);
		if (luaChon == JOptionPane.YES_OPTION) {
			System.exit(0);
		}else {
			return ;
		}
	}
	
//=========================================================================================
	void saveFile(String path) {
		try {
			this.qlsvmodel.setTenfile(path);
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (Thisinh ts : this.qlsvmodel.getDsThiSinh()) {
				oos.writeObject(ts);
			}
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//==========================================================================================
	public void thucHienSaveFile() {
		if(this.qlsvmodel.getTenfile().length()>0) {
			saveFile(this.qlsvmodel.getTenfile());
		}else {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showSaveDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				saveFile(file.getAbsolutePath());
			} 
		}
	}
//============================================================================================
	public void openFile(File file) {
		ArrayList<Thisinh> danhsach = new ArrayList<Thisinh>();
		try {
			this.qlsvmodel.setTenfile(file.getAbsolutePath());
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Thisinh ts = null;
			while((ts = (Thisinh) ois.readObject())!=null) {
				danhsach.add(ts);
			}
			ois.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		this.qlsvmodel.setDsThiSinh(danhsach);
	}
	//========================================================================================
	public void thucHienOpenFile() {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			openFile(file);
			thucHienLuuDuLieu();
		} 
	}

	public void HuyTim() {
		this.textField_mav.setText("");
	}
	public void xoaTrenTable() {
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		int soHang=table.getSelectedRow();//chọn dong nao để xóa 
		int luachon=JOptionPane.showConfirmDialog(this,"bạn có chắc muốn xóa");
		if(luachon==JOptionPane.YES_OPTION) {
			Thisinh ts=getCapNhatThongTinSinhVien();
			this.qlsvmodel.remove(ts);
			model.removeRow(soHang);
	      }
	}
	public void Excel() throws IOException {
		   ArrayList<Thisinh>listTs=new ArrayList<Thisinh>();
			DefaultTableModel model=(DefaultTableModel)table.getModel();
			  int soluongDong=model.getRowCount();
			  System.out.println(soluongDong);
			if(soluongDong==0) {
			        return;
			}else {
			  for(int i=0;i<soluongDong;i++) {
				   model.getValueAt(i,7 );
				   String masv= ""+ model.getValueAt(i,0 );
				    String ten= model.getValueAt(i,1 )+"";
			       // lây ra cái tinh ơ trong bang
				    
				   Tinh diachi =Tinh.getTinhByTen(model.getValueAt(i,2 )+"");
				     String ngaysinh1=   model.getValueAt(i,3 )+"";
				     String ngaysinh=   model.getValueAt(i,3 )+"";
					   
				   
				   	 String TextGioiTinh=model.getValueAt(i,4)+"";
				    boolean chonGioiTinh=TextGioiTinh.equals("Nam");	
				    Double diemtoan=Double.valueOf(model.getValueAt(i,5)+"");
				    Double diemli=Double.valueOf(model.getValueAt(i,6 )+"");
					Double diemhoa=Double.valueOf(model.getValueAt(i,7 )+"");
					//nếu gọi conttructor ko tham số thif ta phải dung đói tơngj ko tham số là ts.setmasv=masv
					// khi gtri ở dạng dơn cần set haowcj get  cho 1 gtri thi ta goi ham có đối tượng ts.set như bt
					
				
					Thisinh ts =new Thisinh(masv,ten,diachi,ngaysinh,chonGioiTinh,diemtoan,diemli,diemhoa);
				    
				listTs.add(ts);
			  }
	   }
			for(Thisinh SV: listTs) {
				System.out.println(SV);
			}
		// thực hiệnn ghi vào  fiel exel	

				FileWriter fw=new FileWriter("src\\View\\sinhvien.csv");
		
				fw.write("id, ten, quequan, ngaysinh, gioitinh, diem15p, diemhk, diemtb");
				for(Thisinh SV: listTs) {
		        	fw.write("\n"+SV);  ;
		       	
				}
						fw.flush();
						fw.close();
	         }
	
	public void Indiem() {
		 if(this.textdiem.getText().equals("")) {
	    	  int luachon=JOptionPane.showConfirmDialog(this,"vui lòng nhập masv");
	    		if(luachon==JOptionPane.YES_OPTION) {
	    			return ;
	            }
	        }else {
				 while(true) {
					DefaultTableModel model=(DefaultTableModel)table.getModel();
					  int soluongDong=model.getRowCount();
					if(soluongDong==0) {
						break;
					}else {
						try {
						model.removeRow(0);
					}catch (Exception e) {
						e.printStackTrace();
					}
				   }
				 }
				 
					 ArrayList<Thisinh>list= DaoQLSV.getInfor().selectByCondition(this.textdiem.getText()+"");
						for(Thisinh tsinh:list){
							this.themThiSinhVaoBang2(tsinh);
							
						}
		
	  }  
		
	}
}