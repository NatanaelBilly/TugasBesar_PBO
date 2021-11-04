/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Controller;
import java.awt.Color;
import javax.swing.JFrame;

public class Chat {

    public Chat() {
        Controller c = new Controller();
        JFrame f = new JFrame();
        f.setSize(400, 300);
        f.setLocationRelativeTo(null);
        f.getContentPane().setBackground(Color.WHITE);
        f.setVisible(true);
        f.setLayout(null);
    }

}
