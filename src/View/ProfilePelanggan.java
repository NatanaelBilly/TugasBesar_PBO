package View;

import Model.Constant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfilePelanggan {
    JFrame frame;
    JPanel panelMenu, panelNama;
    JLabel labelProfilePic, labelNama, labelEmail, labelRole, email, role;
    ImageIcon profilePic;
    JButton btnEditProfile;

    public ProfilePelanggan() {
        new ListMenuPelanggan();
        panelMenu = ListMenuPelanggan.panel;

        //picture
        labelProfilePic = new JLabel();
        profilePic = new ImageIcon("assets/profile_pic.jpg");
        labelProfilePic.setIcon(profilePic);
        labelProfilePic.setBounds(130, 80, 320, 260);

        //label
        labelNama = new JLabel("Nama Pengguna Ceritanya", JLabel.CENTER);
        labelNama.setFont(new Font("Arial", Font.BOLD, 20));
        labelEmail = new JLabel("Email");
        labelEmail.setBounds(90, 420, 80, 40);
        labelEmail.setFont(new Font("Arial", Font.PLAIN, 17));
        labelRole = new JLabel("Role");
        labelRole.setBounds(90, 470, 80, 40);
        labelRole.setFont(new Font("Arial", Font.PLAIN, 17));

        email = new JLabel(": iniemail@mail.com");
        email.setBounds(190, 420, 300, 40);
        email.setFont(new Font("Arial", Font.PLAIN, 17));
        role = new JLabel(": Pelanggan");
        role.setBounds(190, 470, 300, 40);
        role.setFont(new Font("Arial", Font.PLAIN, 17));

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
                new EditProfilePelanggan();
            }
        });

        //Frame
        frame = new JFrame(Constant.applicationName);
        frame.setSize(600, 800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(labelProfilePic);
        frame.add(labelEmail);
        frame.add(labelRole);
        frame.add(email);
        frame.add(role);
        frame.add(panelMenu);
        frame.add(panelNama);
        frame.add(btnEditProfile);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
