package test;

import dao.SachDAO;
import model.Sach;

import java.util.ArrayList;

public class TestSachDAO {
    public static void main(String[] args) {
        ArrayList<Sach> list = SachDAO.getInstance().selectAll();
        for (Sach sach : list){
            System.out.println(sach.toString());
        }


        System.out.println("-------------------");

        Sach find = new Sach();
        find.setId("LT_JV");
        Sach sach_2 = SachDAO.getInstance().selectById(find);
        System.out.println(sach_2);


        System.out.println("-------------------");
        ArrayList<Sach> list2 = SachDAO.getInstance().selectByCondition(" giaBan <> 500000");
        for (Sach sach : list2){
            System.out.println(sach.toString());
        }

    }
}
