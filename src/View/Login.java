package View;

import Model.Constant;

import javax.swing.*;
import java.awt.*;

public class Login {
    JFrame frame;
    JLabel login, inputEmail, inputPassword;
    JPanel panelLogin;

    public Login(){
        //label Login
        login = new JLabel("Silahkan login dengan email dan password yang sudah didaftarkan.", SwingConstants.CENTER);
        login.setFont(new Font("Arial", Font.BOLD, 24));
        login.setBounds(0,50,600,80);

        //Panel Login
        panelLogin = new JPanel();
        panelLogin.setVisible(true);
        panelLogin.setLayout(null);
        panelLogin.setBounds(0,0,600,800);
        panelLogin.setBackground(new Color(204, 180, 114));
        panelLogin.add(login);

        //frame
        frame = new JFrame(Constant.applicationName);
        frame.setSize(600,800);
        frame.add(panelLogin);
        frame.setVisible(true);
    }
}
