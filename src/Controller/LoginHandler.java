package Controller;

import Model.Pelanggan;
import Model.User;
import View.HomePelanggan;

public class LoginHandler {
    public LoginHandler(String email, String password) {
        Controller controller = new Controller();

        controller.logIn(email, password);

        User user = new Model.UserManager().getInstance().getUser();

        if (user instanceof Pelanggan) {
            new HomePelanggan();
        } else {
            System.out.println("Belum jadi guinya, maap yak");
        }
    }
}
