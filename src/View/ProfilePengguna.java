package View;

import javax.swing.*;

public class ProfilePengguna {
    JFrame frame;
    JPanel panelMenu;
    public ProfilePengguna(){
        new listMenuPengguna();
        panelMenu = listMenuPengguna.panel;
        //Frame
        frame = new JFrame("Nama APK");
        frame.setSize(600, 800);
        frame.add(panelMenu);

        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
