package View;

import Model.Constant;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class LandingPage {
    JFrame frame;
    JLabel welcomeUser;
    JButton btnLogin, btnRegister;
    JPanel panelLandingPage;

    public LandingPage(){
        // Label
        welcomeUser = new JLabel("Hallo! Welcome to "+ Constant.applicationName, SwingConstants.CENTER);
        welcomeUser.setFont(new Font("Arial", Font.BOLD, 24));
        welcomeUser.setBounds(0,50,600,80);

        //Button Login
        btnLogin = new JButton("Login");
        btnLogin.setBounds(170, 210, 250, 80);
        btnLogin.setFont(new Font("Arial", Font.BOLD, 20));
        btnLogin.setBackground(new Color(217, 217, 217));
        btnLogin.setBorder(new BevelBorder(1, Color.BLACK, Color.BLACK));


        //Button Register
        btnRegister = new JButton("Register");
        btnRegister.setBounds(170, 340, 250, 80);
        btnRegister.setFont(new Font("Arial", Font.BOLD, 20));
        btnRegister.setBackground(new Color(217, 217, 217));
        btnRegister.setBorder(new BevelBorder(1, Color.BLACK, Color.BLACK));

        //Panel
        panelLandingPage = new JPanel();
        panelLandingPage.setVisible(true);
        panelLandingPage.setLayout(null);
        panelLandingPage.setBounds(0,0,600,800);
        panelLandingPage.setBackground(new Color(204, 180, 114));

        //Frame
        frame = new JFrame("Nama APK - Home Pelanggan");
        frame.setSize(600, 800);


        panelLandingPage.add(welcomeUser);
        panelLandingPage.add(btnLogin);
        panelLandingPage.add(btnRegister);

        frame.add(panelLandingPage);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
