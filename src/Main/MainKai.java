package Main;

import Model.Kurir;
import Model.Pelanggan;
import Model.User;
import View.BerandaKurir;
import View.BerandaPelanggan;
import View.MenuChat;
import View.MenuEditProfilePelanggan;
import View.MenuIsiSaldo;
import View.MenuLihatOrderKurir;
import View.MenuLogin;
import View.MenuProfilePelanggan;

/**
 *
 * @author MrKaisar
 */
public class MainKai {

    public static void main(String[] args) {
        Pelanggan user = new Pelanggan();
//        new MenuEditProfilePelanggan(user);

//        new BerandaPelanggan(user);
//        new MenuProfilePelanggan(user);
//        new MenuIsiSaldo(user);
//Kurir kurir = new Kurir();
//            new MenuLihatOrderKurir(kurir);
new MenuChat();
    }
}
