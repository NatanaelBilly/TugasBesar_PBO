package Controller;

import Model.Pelanggan;
import Model.User;
import View.BerandaPelanggan;

public class LoginHandler {
    public LoginHandler(String email, String password) {
        Controller controller = new Controller();

        controller.logIn(email, password);

        User user = new Model.UserManager().getInstance().getUser();

        if (user instanceof Pelanggan) {
            new BerandaPelanggan();
        } else {
            System.out.println("Belum jadi guinya, maap yak");
        }
    }
}
