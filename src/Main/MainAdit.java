/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Controller.Controller;
import Model.Kurir;
import View.BerandaKurir;
import View.MenuLihatProfilKurir;

/**
 *
 * @author Asus
 */
public class MainAdit {
    public static void main(String[] args) {
        
        Kurir kurir = new Controller().ambilDataKurir(8);
        
        new BerandaKurir(kurir);
    }
}
