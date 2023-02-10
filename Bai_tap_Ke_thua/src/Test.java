public class Test {
    public static void main(String[] args) {
        HangSanXuat hangSanXuat_1 = new HangSanXuat("Hang_1","VietNam");
        HangSanXuat hangSanXuat_2 = new HangSanXuat("Hang_2","USA");

        PhuongTienDiChuyen pt_1 = new MayBay(hangSanXuat_1,"Xang");
        PhuongTienDiChuyen pt_2 = new Oto(hangSanXuat_2,"Dien");

        System.out.println("phuong tien 1: " );
        System.out.println(pt_1.getHangSanXuat());
        System.out.println(pt_1.getTenLoaiPhuongTien());
        pt_1.batDau();
        System.out.println(pt_1.layVanToc());
        ((MayBay) pt_1).catCanh();
        ((MayBay) pt_1).haCanh();
        pt_1.dungLai();

        System.out.println("-------------------");

        System.out.println("phuong tien 2: " );
        System.out.println(pt_2.getHangSanXuat());
        System.out.println(pt_2.getTenLoaiPhuongTien());
        pt_2.batDau();
        System.out.println(pt_2.layVanToc());
        pt_2.dungLai();
    }
}
