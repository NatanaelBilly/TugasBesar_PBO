package View;

import Controller.Controller;
import Model.Constant;
import Model.Kurir;
import Model.Role;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class KurirLihatProfil {
    private JFrame frame;
    private JLabel labelMenu, labelProfilePic, labelNama, labelEmail,labelNIK, labelPlat, labelKendaraan,
            showNama, showEmail, showNIK, showPlat, showKendaraan;
    private ImageIcon profilePic;
    
    private Kurir kurir;
    public KurirLihatProfil(Kurir kurir)
    {
        this.kurir = kurir;
        
        //Data Template
//        int data_id = kurir.getId_user();
//        Role data_role = kurir.getRole();
        String data_nama_lengkap = kurir.getNama_depan() + " " + kurir.getNama_belakang();
        String data_email = kurir.getEmail_user();
//        String data_password = kurir.getPassword();

        String data_NIK = kurir.getNIK();
        String data_plat = kurir.getPlat();
        String data_jenis_kendaraan = kurir.getJenis_kendaraan();
//        double data_total_pendapatan = kurir.getTotal_pendapatan();
//        int data_ketersediaan = kurir.getKetersediaan();
        
        //Menu
        labelMenu = new JLabel("Lihat Profil");
        labelMenu.setBounds(50,25,200,50);
        labelMenu.setFont(new Font("Arial", Font.BOLD, 25));
        
        //picture
        labelProfilePic = new JLabel();
        profilePic = new ImageIcon ("assets/profile_pic.jpg");
        labelProfilePic.setIcon(profilePic);
        labelProfilePic.setBounds(130,75,320,260);

        //label
        labelNama = new JLabel("Nama ");
        labelNama.setBounds(100,350,200,40);
        labelNama.setFont(new Font("Arial", Font.PLAIN, 17));
        labelNIK = new JLabel("NIK ");
        labelNIK.setBounds(100,375,200,40);
        labelNIK.setFont(new Font("Arial", Font.PLAIN, 17));
        labelEmail = new JLabel("Email");
        labelEmail.setBounds(100,400,200,40);
        labelEmail.setFont(new Font("Arial", Font.PLAIN, 17));
        labelPlat = new JLabel("Plat");
        labelPlat.setBounds(100,425,200,40);
        labelPlat.setFont(new Font("Arial", Font.PLAIN, 17));
        labelKendaraan = new JLabel("Kendaraan");
        labelKendaraan.setBounds(100,450,200,40);
        labelKendaraan.setFont(new Font("Arial", Font.PLAIN, 17));

        //Data
        showNama = new JLabel(": " + data_nama_lengkap);
        showNama.setBounds(200,350,300,40);
        showNama.setFont(new Font("Arial", Font.PLAIN, 17));
        showNIK = new JLabel(": " + data_NIK);
        showNIK.setBounds(200,375,300,40);
        showNIK.setFont(new Font("Arial", Font.PLAIN, 17));
        showEmail = new JLabel(": " + data_email);
        showEmail.setBounds(200,400,300,40);
        showEmail.setFont(new Font("Arial", Font.PLAIN, 17));
        showPlat = new JLabel(": " + data_plat);
        showPlat.setBounds(200,425,300,40);
        showPlat.setFont(new Font("Arial", Font.PLAIN, 17));
        showKendaraan = new JLabel(": " + data_jenis_kendaraan);
        showKendaraan.setBounds(200,450,300,40);
        showKendaraan.setFont(new Font("Arial", Font.PLAIN, 17));


        //Button Edit
        JButton btnEditProfile = new JButton("Edit Profil");
        btnEditProfile.setBounds(250, 600, 100, 30);
        btnEditProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new KurirEditProfil(kurir);
                frame.setVisible(false);
            }
        });
        
        //Button Back
        JButton btnBack = new JButton("Kembali");
        btnBack.setBounds(450, 25, 100, 30);
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new KurirMenu(kurir);
                frame.setVisible(false);
            }
        });

        
        //Frame
        frame = new JFrame(Constant.applicationName);
        frame.setSize(600, 800);

        frame.add(labelMenu);
        frame.add(labelProfilePic);
        frame.add(labelNama);
        frame.add(labelEmail);
        frame.add(labelNIK);
        frame.add(labelPlat);
        frame.add(labelKendaraan);
        frame.add(showNama);
        frame.add(showEmail);
        frame.add(showPlat);
        frame.add(showKendaraan);
        frame.add(showNIK);
        
        frame.add(btnEditProfile);
        frame.add(btnBack);

        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
