package Main;

import Controller.Controller;
import Model.Kurir;
import View.MenuLogin;

/**
 *
 * @author Asus
 */
public class MainAdit {
    public static void main(String[] args) {
        
        Kurir kurir = new Controller().ambilDataKurir(8);

        new MenuLogin();
    }
}
