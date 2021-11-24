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
        welcomeUser = GUI.defaultHeadingLabel("Hallo! Welcome to " + Constant.APPLICATION_NAME);
        welcomeUser.setBounds(0, 150, 600, 80);

        btnLogin = GUI.defaultButton("Login", 22);
        btnLogin.setBounds(170, 250, 250, 80);
        btnLogin.addActionListener(e -> {
            frame.dispose();
            new MenuLogin();
        });

        btnRegister = GUI.defaultButton("Register", 22);
        btnRegister.setBounds(170, 390, 250, 80);
        btnRegister.addActionListener(e -> {
            frame.dispose();
            new MenuRegisterPilihRole();
        });

        panelLandingPage = new JPanel();
        panelLandingPage.setVisible(true);
        panelLandingPage.setLayout(null);
        panelLandingPage.setBounds(0, 0, 600, 800);
        panelLandingPage.setBackground(GUI.backGroundColor());
        panelLandingPage.add(welcomeUser);
        panelLandingPage.add(btnLogin);
        panelLandingPage.add(btnRegister);

        frame = new DefaultComponentSetting().defaultFrame();
        frame.add(panelLandingPage);
    }
}
