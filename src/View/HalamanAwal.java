package View;

import Model.Constant;

import javax.swing.*;

public class HalamanAwal {
    private JFrame frame;
    private JLabel welcomeUser;
    private JButton btnLogin, btnRegister;
    private JPanel panelLandingPage;
    private DefaultComponentSetting GUI = new DefaultComponentSetting();

    public HalamanAwal() {
        //Label
        welcomeUser = GUI.defaultHeadingLabel("Hallo! Welcome to " + Constant.APPLICATION_NAME);
        welcomeUser.setBounds(0, 150, 600, 80);

        //Button Login
        btnLogin = GUI.defaultButton("Login", 22);
        btnLogin.setBounds(170, 250, 250, 80);
        btnLogin.addActionListener(e -> {
            frame.dispose();
            new MenuLogin();
        });

        //Button Register
        btnRegister = GUI.defaultButton("Register", 22);
        btnRegister.setBounds(170, 390, 250, 80);
        btnRegister.addActionListener(e -> {
            frame.dispose();
            new MenuRegisterPilihRule();
        });

        //Panel
        panelLandingPage = new JPanel();
        panelLandingPage.setVisible(true);
        panelLandingPage.setLayout(null);
        panelLandingPage.setBounds(0, 0, 600, 800);
        panelLandingPage.setBackground(GUI.backGroundColor());
        panelLandingPage.add(welcomeUser);
        panelLandingPage.add(btnLogin);
        panelLandingPage.add(btnRegister);

        //Frame
        frame = new DefaultComponentSetting().defaultFrame();
        frame.add(panelLandingPage);
    }
}
