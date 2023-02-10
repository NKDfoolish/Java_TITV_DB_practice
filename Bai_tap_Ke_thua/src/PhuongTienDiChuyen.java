public abstract class PhuongTienDiChuyen {
    protected String tenLoaiPhuongTien;
    protected HangSanXuat hangSanXuat;

    public PhuongTienDiChuyen(String tenLoaiPhuongTien, HangSanXuat hangSanXuat) {
        this.tenLoaiPhuongTien = tenLoaiPhuongTien;
        this.hangSanXuat = hangSanXuat;
    }

    public String getTenLoaiPhuongTien() {
        return tenLoaiPhuongTien;
    }

    public String getHangSanXuat() {
        return this.hangSanXuat.getTenHangSanXuat();
    }

    public void setTenLoaiPhuongTien(String tenLoaiPhuongTien) {
        this.tenLoaiPhuongTien = tenLoaiPhuongTien;
    }

    public void setHangSanXuat(String hangSanXuat) {
        this.hangSanXuat.setTenHangSanXuat(hangSanXuat);
    }

    public void batDau(){
        System.out.println("Bat dau ...");
    }

    public void tangToc(){
        System.out.println("Tang toc ...");
    }

    public void dungLai(){
        System.out.println("Dung lai ...");
    }

    public abstract double layVanToc();
}
