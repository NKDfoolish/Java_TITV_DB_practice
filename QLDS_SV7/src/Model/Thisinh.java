package Model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Iterator;
import java.util.Objects;

public class Thisinh implements Serializable{
  
private String masv;
   private String ten;
   public Tinh quequan;
   private String ngaysinh;
   private boolean gioitinh;
   private double diemtoan;
   private double diemli;
   private double diemhoa;
   
   
    public Thisinh(String masv, String ten, Tinh quequan, String ngaysinh, boolean gioitinh, double diemtoan, double diemli,double diemhoa) {
	
		this.masv = masv;
		this.ten = ten;
		this.quequan = quequan;
		this.ngaysinh = ngaysinh;
		this.gioitinh = gioitinh;
		this.diemtoan = diemtoan;
		this.diemli = diemli;
		this.diemhoa = diemhoa;
	}
    
    
	@Override
	public String toString() {
		return " "+ masv + "," + ten + "," + quequan + "," + ngaysinh
				+ "," + gioitinh + "," + diemtoan + "," + diemli + "," + diemhoa
				;
	}

	@Override
	public int hashCode() {
		return Objects.hash(diemhoa, diemli, diemtoan, gioitinh, masv,ngaysinh, quequan, ten);
	}
	public String getMasv() {
		return masv;
	}
	public void setMasv(String masv) {
		this.masv = masv;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public Tinh getQuequan() {
		return quequan;
	}
	public void setQuequan(Tinh quequan) {
		this.quequan = quequan;
	}
	public  String getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(String ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	public boolean isGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(boolean gioitinh) {
		this.gioitinh = gioitinh;
	}
	public double getDiemtoan() {
		return diemtoan;
	}
	public void setDiemtoan(double diemtoan) {
		this.diemtoan = diemtoan;
	}
	public double getDiemli() {
		return diemli;
	}
	public void setDiemli(double diemli) {
		this.diemli = diemli;
	}
	public double getDiemhoa() {
		return diemhoa;
	}
	public void setDiemhoa(double diemhoa) {
		this.diemhoa = diemhoa;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Thisinh other = (Thisinh) obj;
		return Double.doubleToLongBits(diemhoa) == Double.doubleToLongBits(other.diemhoa)
				&& Double.doubleToLongBits(diemli) == Double.doubleToLongBits(other.diemli)
				&& Double.doubleToLongBits(diemtoan) == Double.doubleToLongBits(other.diemtoan)
				&& Objects.equals(gioitinh, other.gioitinh) && masv == other.masv
				&& Objects.equals(ngaysinh, other.ngaysinh) &&Objects.equals(quequan, other.quequan)
				&& Objects.equals(ten, other.ten);
	}





	
	
}
