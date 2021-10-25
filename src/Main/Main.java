package Main;

import Controller.Controller;
import Model.User;
import View.HomePelanggan;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        new HomePelanggan();
        
        //Try To Print User, You can delete it
        Controller controller = new Controller();
        ArrayList<User> users = controller.getAllUsers();
        
        for (User user : users) {
            System.out.println(user.toString());
        }
        
    }
}
