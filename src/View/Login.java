package View;

import Controller.Controller;
import Model.Constant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {
    JFrame frame;
    JLabel labelEmail, labelPassword;
    JTextField inputEmail;
    JPasswordField inputPassword;
    JPanel panelLogin;
    JButton buttonLogin;

    public Login(){
        //Label Input Email
        labelEmail = new JLabel("Email");
        labelEmail.setFont(new Font("Arial", Font.PLAIN, 18));
        labelEmail.setBounds(75,200,150,35);

        //TextField Input Email
        inputEmail = new JTextField();
        inputEmail.setBounds(225,200,300,35);

        //Label Input Password
        labelPassword = new JLabel("Password");
        labelPassword.setFont(new Font("Arial", Font.PLAIN, 18));
        labelPassword.setBounds(75, 270,150,35);

        //Input Password
        inputPassword = new JPasswordField();
        inputPassword.setBounds(225,270,300,35);

        //Button Login
        buttonLogin = new JButton("LOGIN");
        buttonLogin.setBounds(350, 350, 100,45);
        buttonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = inputEmail.getText();
                String password = String.valueOf(inputPassword.getPassword());

                Controller controller = new Controller();
                String loggedInAs = controller.LogInn(email,password);
                if(!loggedInAs.equalsIgnoreCase("null")){
                    frame.dispose();
                    if(loggedInAs.equalsIgnoreCase("pelanggan")){
                        new HomePelanggan();
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Gagal Login");
                }
            }
        });

        //Panel Login
        panelLogin = new JPanel();
        panelLogin.setVisible(true);
        panelLogin.setLayout(null);
        panelLogin.setBounds(0,0,600,800);
        panelLogin.setBackground(new Color(204, 180, 114));
        panelLogin.add(labelEmail);
        panelLogin.add(inputEmail);
        panelLogin.add(labelPassword);
        panelLogin.add(inputPassword);
        panelLogin.add(buttonLogin);

        //frame
        frame = new JFrame(Constant.applicationName);
        frame.setSize(600,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panelLogin);
        frame.setVisible(true);
    }
}
