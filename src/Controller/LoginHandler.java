package Controller;

import Model.Admin;
import Model.Kurir;
import Model.Pelanggan;
import Model.User;
import View.BerandaAdmin;
import View.BerandaKurir;
import View.BerandaPelanggan;

public class LoginHandler {
    public LoginHandler(String email, String password) {
        Controller controller = new Controller();

        controller.logIn(email, password);

        User user = new Model.UserManager().getInstance().getUser();
        System.out.println(user.getClass().getSimpleName());

        if (user instanceof Pelanggan) {
            new BerandaPelanggan((Pelanggan) user);
        } else if(user instanceof Kurir){
            System.out.println("Hai ini kurir");
            new BerandaKurir((Kurir) user);
        }
    }
}
