package View;

import Controller.*;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MenuLogin {
    JFrame frame;
    JLabel labelJudul, labelEmail, labelPassword, linkKembali;
    JTextField inputEmail;
    JPasswordField inputPassword;
    JPanel panelLogin;
    JButton buttonLogin;
    DefaultComponentSetting GUI = new DefaultComponentSetting();

    public MenuLogin() {
        //Link Kembali
        linkKembali = GUI.defaultBackLabel();
        linkKembali.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                new HalamanAwal();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                frame.dispose();
                new HalamanAwal();
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        //Label Judul
        labelJudul = GUI.defaultHeadingLabel("Log In");
        labelJudul.setBounds(0,150,600,40);

        //Label Input Email
        labelEmail = GUI.defaultRegularLabel("Email");
        labelEmail.setBounds(75, 250, 150, 35);

        //TextField Input Email
        inputEmail = new JTextField();
        inputEmail.setBounds(225, 250, 300, 35);

        //Label Input Password
        labelPassword = GUI.defaultRegularLabel("Password");
        labelPassword.setBounds(75, 320, 150, 35);

        //Input Password
        inputPassword = new JPasswordField();
        inputPassword.setBounds(225, 320, 300, 35);

        //Button Login
        buttonLogin = GUI.defaultButton("Login",20);
        buttonLogin.setBounds(425, 400, 100, 45);
        buttonLogin.addActionListener(e -> {
            String email = inputEmail.getText();
            String password = String.valueOf(inputPassword.getPassword());

            Controller controller = new Controller();

            boolean bisaLogin = controller.cekUserDiDataBase(email, password);

            System.out.println(bisaLogin);

            if (bisaLogin) {
                frame.dispose();
                new LoginHandler(email, password);
            } else {
                JOptionPane.showMessageDialog(null, "Masukkan data dengan benar");
            }
        });

        //Panel Login
        panelLogin = new JPanel();
        panelLogin.setVisible(true);
        panelLogin.setLayout(null);
        panelLogin.setBounds(0, 0, 600, 800);
        panelLogin.add(labelEmail);
        panelLogin.add(inputEmail);
        panelLogin.add(labelPassword);
        panelLogin.add(inputPassword);
        panelLogin.add(buttonLogin);
        panelLogin.add(linkKembali);
        panelLogin.add(labelJudul);
        panelLogin.setBackground(GUI.backGroundColor());

        //frame
        frame = new DefaultComponentSetting().defaultFrame();
        frame.add(panelLogin);
    }
}
