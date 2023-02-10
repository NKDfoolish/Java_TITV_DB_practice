package test;

import dao.SachDAO;
import model.Sach;

public class TestSachDAO {
    public static void main(String[] args) {

        /* Test Insert*/
        /*Sach s1 = new Sach("LT_JV","Lap trinh java",50000,2025 );
        Sach s2 = new Sach("LT_PT","Lap trinh python",70000,2030 );

        SachDAO.getInstance().insert(s2);*/

        /*for (int i = 0; i < 1000; i++){
            Sach sach = new Sach("LT" + i,"Lap trinh i: " + i,20000,2024 );
            SachDAO.getInstance().insert(sach);
        }*/




        /* Test Update*/
        /*Sach s1 = new Sach("LT_JV","Lap trinh java",1000000,2025 );
        SachDAO.getInstance().update(s1);*/

        /* Test Delete*/
        for (int i = 0; i < 1000; i++) {
            Sach sach = new Sach("LT" + i, "Lap trinh i: " + i, 20000, 2024);
            SachDAO.getInstance().delete(sach);

        }
    }
}
