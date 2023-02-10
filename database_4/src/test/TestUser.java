package test;

import dao.UserDAO;
import model.User;

import java.util.ArrayList;

public class TestUser {
    public static void main(String[] args) {
        /*User user1 = new User("u2","u321","NNN");
        UserDAO.getInstance().insert(user1);*/


        User userFind = new User("u2","u321","NNN");
        User result = UserDAO.getInstance().selectById(userFind);
        System.out.println(result);

    }
}
