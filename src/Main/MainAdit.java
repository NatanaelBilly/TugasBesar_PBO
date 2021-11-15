package Main;

import Controller.Controller;
import Model.Kurir;
import Model.Role;
import View.BerandaKurir;
import View.MenuLihatOrderKurir;
import View.MenuLihatProfilKurir;

/**
 *
 * @author Asus
 */
public class MainAdit {
    public static void main(String[] args) {
        
        Kurir kurir = new Controller().ambilDataKurir(8);
        
        
        new MenuLihatOrderKurir();
    }
}
