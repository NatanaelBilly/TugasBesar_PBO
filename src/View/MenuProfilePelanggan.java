package View;

import Model.Pelanggan;
import Model.TingkatanUser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuProfilePelanggan {
    JFrame frame;
    JPanel panelNama;
    JLabel labelProfilePic, labelNama, labelEmail,labelSaldo, labelRole, labelNoHp, email, role, saldo, noHp, labelKembali;
    ImageIcon profilePic;
    JButton btnEditProfile;
    DefaultComponentSetting GUI = new DefaultComponentSetting();

    public MenuProfilePelanggan(Pelanggan pelanggan) {
        //back
        labelKembali = GUI.defaultBackLabel();
        labelKembali.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                new BerandaPelanggan(pelanggan);
            }
        });

        //picture
        labelProfilePic = new JLabel();
        profilePic = new ImageIcon("assets/profile_pic.jpg");
        labelProfilePic.setIcon(profilePic);
        labelProfilePic.setBounds(130, 80, 320, 260);

        //label
        labelNama = GUI.defaultHeadingLabel(pelanggan.getNama_depan() + " " + pelanggan.getNama_belakang());
        labelEmail = new JLabel("Email");
        labelEmail.setBounds(90, 420, 80, 40);
        labelEmail.setFont(new Font("Arial", Font.PLAIN, 17));
        labelRole = new JLabel("Role");
        labelRole.setBounds(90, 470, 80, 40);
        labelRole.setFont(new Font("Arial", Font.PLAIN, 17));
        labelNoHp = new JLabel("Nomor HP");
        labelNoHp.setBounds(90, 520, 80, 40);
        labelNoHp.setFont(new Font("Arial", Font.PLAIN, 17));
        labelSaldo = new JLabel("Saldo");
        labelSaldo.setBounds(90, 570, 80, 40);
        labelSaldo.setFont(new Font("Arial", Font.PLAIN, 17));

        email = new JLabel(": " + pelanggan.getEmail_user());
        email.setBounds(190, 420, 300, 40);
        email.setFont(new Font("Arial", Font.PLAIN, 17));
        role = new JLabel(": " + pelanggan.getRole());
        role.setBounds(190, 470, 300, 40);
        role.setFont(new Font("Arial", Font.PLAIN, 17));
        noHp = new JLabel(": " + pelanggan.getNoHp());
        noHp.setBounds(190, 520, 300, 40);
        noHp.setFont(new Font("Arial", Font.PLAIN, 17));
        saldo = new JLabel(": " + pelanggan.getSaldo());
        saldo.setBounds(190, 570, 300, 40);
        saldo.setFont(new Font("Arial", Font.PLAIN, 17));

        //Button
        btnEditProfile = GUI.defaultButton("Edit Profil",14);
        btnEditProfile.setBounds(250, 620, 100, 30);
        btnEditProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new MenuEditProfilePelanggan(pelanggan);
            }
        });

        //Panel
        panelNama = new JPanel();
        panelNama.setBounds(90, 360, 400, 40);
        //kasih if untuk mengecek tinkatan pelanggan
        if(pelanggan.getTingkatan().equals(TingkatanUser.BRONZE)){
            panelNama.setBackground(new Color(204, 180, 114));
        }else if(pelanggan.getTingkatan().equals(TingkatanUser.SILVER)){
            panelNama.setBackground(new Color(214, 212, 206));
        }else if(pelanggan.getTingkatan().equals(TingkatanUser.GOLD)){
            panelNama.setBackground(new Color(252, 218, 116));
        }
        panelNama.add(labelNama);
        panelNama.setVisible(true);

        //Frame
        frame = GUI.defaultFrame();
        frame.getContentPane().setBackground(GUI.backGroundColor());

        frame.add(labelKembali);
        frame.add(labelProfilePic);
        frame.add(labelEmail);
        frame.add(labelRole);
        frame.add(email);
        frame.add(role);
        frame.add(labelSaldo);
        frame.add(saldo);
        frame.add(labelNoHp);
        frame.add(noHp);
        frame.add(panelNama);
        frame.add(btnEditProfile);

    }
}
