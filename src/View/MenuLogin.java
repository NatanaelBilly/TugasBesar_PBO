package View;

import Controller.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MenuLogin {
    JFrame frame;
    JLabel labelJudul, labelEmail, labelPassword, linkKembali;
    JTextField inputEmail;
    JPasswordField inputPassword;
    JPanel panelLogin;
    JButton buttonLogin;

    public MenuLogin() {
        //Link Kembali
        linkKembali = new DefaultComponentSetting().defaultBackLabel();
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
        labelJudul = new DefaultComponentSetting().defaultHeadingLabel("Log In");
        labelJudul.setBounds(0,100,600,40);


        //Label Input Email
        labelEmail = new DefaultComponentSetting().defaultRegularLabel("Email");
        labelEmail.setBounds(75, 200, 150, 35);

        //TextField Input Email
        inputEmail = new JTextField();
        inputEmail.setBounds(225, 200, 300, 35);

        //Label Input Password
        labelPassword = new DefaultComponentSetting().defaultRegularLabel("Password");
        labelPassword.setBounds(75, 270, 150, 35);

        //Input Password
        inputPassword = new JPasswordField();
        inputPassword.setBounds(225, 270, 300, 35);

        //Button Login
        buttonLogin = new DefaultComponentSetting().defaultButton("Login",20);
        buttonLogin.setBounds(350, 350, 100, 45);
        buttonLogin.addActionListener(e -> {
            String email = inputEmail.getText();
            String password = String.valueOf(inputPassword.getPassword());

            Controller controller = new Controller();

            boolean bisaLogin = controller.cekUserDiDataBase(email, password);

            if (bisaLogin) {
                System.out.println("Bisa Login");
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
        panelLogin.setBackground(new Color(204, 180, 114));
        panelLogin.add(labelEmail);
        panelLogin.add(inputEmail);
        panelLogin.add(labelPassword);
        panelLogin.add(inputPassword);
        panelLogin.add(buttonLogin);
        panelLogin.add(linkKembali);
        panelLogin.add(labelJudul);

        //frame
        frame = new DefaultComponentSetting().defaultFrame();
        frame.add(panelLogin);
//        frame.add(linkKembali);
    }
}
