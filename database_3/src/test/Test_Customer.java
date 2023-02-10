package test;

import dao.KhachHangDAO;
import dao.SachDAO;
import model.KhachHang;
import model.Sach;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;

public class Test_Customer {
    public static void main(String[] args) {
        /* - Select * - */
        /*ArrayList<KhachHang> list = KhachHangDAO.getInstance().selectAll();
        for (KhachHang kh : list){
            System.out.println(kh.toString());
        }*/


        /* -Insert- */
        /* -Error use date to push into SQL- */
        /* -NKDfoolish has fixed this bug 8/2/2023-*/
        // Date date = new Date(1998-1900,10-1,20); ----> Deprecated
        /*String dateString = "2000-12-31";
        Date date = Date.valueOf(dateString);

        KhachHang kh1 = new KhachHang("Nguyen Khanh Linh",date,"Ha Noi");
        KhachHangDAO.getInstance().insert(kh1);*/


        /* -Update- */
        /*String dateString = "1998-12-31";
        Date date = Date.valueOf(dateString);
        KhachHang khachHang = new KhachHang(1,"Le Duong Bao Lam",date,"HCm City");
        KhachHangDAO.getInstance().update(khachHang);*/


        /* -Delete- */
        /*KhachHang khachHang = new KhachHang();
        khachHang.setId(1);
        KhachHangDAO.getInstance().delete(khachHang);*/




        /* Select by ID */
        /*KhachHang khachHang = new KhachHang();
        khachHang.setId(2);
        KhachHang khachHangResult = KhachHangDAO.getInstance().selectById(khachHang);
        System.out.println(khachHangResult);*/


        /* Select by condition */
        ArrayList<KhachHang> listKH = KhachHangDAO.getInstance().selectByCondition(" id > 3");
        for (KhachHang kh : listKH){
            System.out.println(kh);
        }
    }
}
