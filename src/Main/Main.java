package Main;

import Controller.Controller;
import Model.Chat;
import Model.User;
import View.HomePelanggan;
import View.LandingPage;
import View.Login;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        
        
        //Try To Print User, You can delete it
        
        Controller controller = new Controller();
        ArrayList<User> users = controller.getAllUsers();
        
        for (User user : users) {
            System.out.println(user.getNama_depan());
        }

//        Controller controller = new Controller();
//        ArrayList<User> users = controller.getAllUsers();
//
//        for (User user : users) {
//            System.out.println(user.toString());
//        }

        
    }
}
