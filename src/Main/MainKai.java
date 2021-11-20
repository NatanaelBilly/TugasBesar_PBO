package Main;

import Model.Chat;
import Model.Kurir;
import Model.Pelanggan;
import Model.User;
import View.BerandaKurir;
import View.BerandaPelanggan;
import View.MenuChat;
import View.MenuEditProfilePelanggan;
import View.MenuIsiSaldo;
import View.MenuLihatDaftarTransaksiPelanggan;
import View.MenuLihatOrderKurir;
import View.MenuLogin;
import View.MenuProfilePelanggan;
import java.util.ArrayList;

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
        Pelanggan p = new Pelanggan();
        p.setIdUser(1);
        Chat chat1 = new Chat();
        chat1.setChat("Tes");
        chat1.setIdPenerima(1);
        chat1.setIdPengirim(2);
        
        Chat chat2 = new Chat();
        chat2.setChat("Tes2sedrfffffffffff");
        chat2.setIdPenerima(2);
        chat2.setIdPengirim(1);
        ArrayList<Chat> chat = new ArrayList();
        chat.add(chat1);
        chat.add(chat2);
        Pelanggan u = new Pelanggan();
        u.setIdUser(1);
//        new MenuChat(chat,u );
    }
}
