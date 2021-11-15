package View;

import Model.Pelanggan;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuProfilePelanggan {
    JFrame frame;
    JPanel panelMenu, panelNama;
    JLabel labelProfilePic, labelNama, labelEmail,labelSaldo, labelRole, email, role, saldo;
    ImageIcon profilePic;
    JButton btnEditProfile;

    public MenuProfilePelanggan(Pelanggan pelanggan) {
        new HeaderMenu(pelanggan);
        panelMenu = HeaderMenu.panel;

        //picture
        labelProfilePic = new JLabel();
        profilePic = new ImageIcon("assets/profile_pic.jpg");
        labelProfilePic.setIcon(profilePic);
        labelProfilePic.setBounds(130, 80, 320, 260);

        //label
        labelNama = new JLabel(pelanggan.getNama_depan() + " " + pelanggan.getNama_belakang(), JLabel.CENTER);
        labelNama.setFont(new Font("Arial", Font.BOLD, 20));
        labelEmail = new JLabel("Email");
        labelEmail.setBounds(90, 420, 80, 40);
        labelEmail.setFont(new Font("Arial", Font.PLAIN, 17));
        labelRole = new JLabel("Role");
        labelRole.setBounds(90, 470, 80, 40);
        labelRole.setFont(new Font("Arial", Font.PLAIN, 17));
        labelSaldo = new JLabel("Saldo");
        labelSaldo.setBounds(90, 520, 80, 40);
        labelSaldo.setFont(new Font("Arial", Font.PLAIN, 17));

        email = new JLabel(": " + pelanggan.getEmail_user());
        email.setBounds(190, 420, 300, 40);
        email.setFont(new Font("Arial", Font.PLAIN, 17));
        role = new JLabel(": " + pelanggan.getRole());
        role.setBounds(190, 470, 300, 40);
        role.setFont(new Font("Arial", Font.PLAIN, 17));
        
        saldo = new JLabel(": " + pelanggan.getSaldo());
        saldo.setBounds(190, 520, 300, 40);
        saldo.setFont(new Font("Arial", Font.PLAIN, 17));

        //Panel
        panelNama = new JPanel();
        panelNama.setBounds(90, 360, 400, 40);
        //kasih if untuk mengecek tinkatan pelanggan
        panelNama.setBackground(new Color(204, 180, 114));
        panelNama.add(labelNama);
        panelNama.setVisible(true);
//        panelNama.setBackground(new Color(214, 212, 206)); utk silver
//        panelNama.setBackground(new Color(252, 218, 116)); utk gold

        //Button
        btnEditProfile = new JButton("Edit Profil");
        btnEditProfile.setBounds(250, 600, 100, 30);
        btnEditProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new MenuEditProfilePelanggan(pelanggan);
            }
        });

        //Frame
        frame = new DefaultComponentSetting().defaultFrame();
        frame.add(labelProfilePic);
        frame.add(labelEmail);
        frame.add(labelRole);
        frame.add(email);
        frame.add(role);
        frame.add(labelSaldo);
        frame.add(saldo);
        frame.add(panelMenu);
        frame.add(panelNama);
        frame.add(btnEditProfile);

    }
}
