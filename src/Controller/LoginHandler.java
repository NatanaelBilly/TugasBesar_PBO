package Controller;

import Model.Kurir;
import Model.Pelanggan;
import Model.User;
import Model.Admin;
import View.BerandaAdmin;
import View.BerandaKurir;
import View.BerandaPelanggan;

public class LoginHandler {
    public LoginHandler(String email, String password) {
        Controller controller = new Controller();

        controller.logIn(email, password);

        User user = new Model.UserManager().getInstance().getUser();

        if (user instanceof Pelanggan) {
            new BerandaPelanggan((Pelanggan) user);
        } else if(user instanceof Kurir){
            new BerandaKurir((Kurir) user);
        }else if (user instanceof Admin){
            new BerandaAdmin((Admin) user);
        }
    }
}
