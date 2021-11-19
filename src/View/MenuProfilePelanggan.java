package View;

import Controller.Controller;
import Model.*;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuProfilePelanggan {
    private JFrame frame;
    private JPanel panelNama;
    private JLabel labelProfilePic, labelNama, labelEmail, labelSaldo, labelTingkatan, labelNoHp, labelKembali;
    private JTextField email, tingkatan, saldo, noHp, nama;
    private ImageIcon profilePic;
    private JButton btnEditProfile, btnSimpan, btnHapus;
    private DefaultComponentSetting GUI = new DefaultComponentSetting();
    Controller controller = new Controller();

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
        labelProfilePic.setBounds(200, 50, 200, 200);

        //label
        labelNama = GUI.defaultRegularLabel("Nama");
        labelNama.setBounds(90, 300, 80, 40);

        labelEmail = GUI.defaultRegularLabel("Email");
        labelEmail.setBounds(90, 350, 80, 40);

        labelNoHp = GUI.defaultRegularLabel("Nomor HP");
        labelNoHp.setBounds(90, 400, 80, 40);

        labelTingkatan = GUI.defaultRegularLabel("Tingkatan");
        labelTingkatan.setBounds(90, 450, 80, 40);

        labelSaldo = GUI.defaultRegularLabel("Saldo");
        labelSaldo.setBounds(90, 500, 80, 40);

        nama = new JTextField(pelanggan.getNamaDepan() + " " + pelanggan.getNamaBelakang());
        nama.setBounds(210, 300, 315, 40);
        nama.setFont(new Font("Arial", Font.PLAIN, 14));
        nama.setEditable(false);

        email = new JTextField(pelanggan.getEmailUser());
        email.setBounds(210, 350, 315, 40);
        email.setFont(new Font("Arial", Font.PLAIN, 14));
        email.setEditable(false);

        noHp = new JTextField(pelanggan.getNoHp());
        noHp.setBounds(210, 400, 315, 40);
        noHp.setFont(new Font("Arial", Font.PLAIN, 14));
        noHp.setEditable(false);

        tingkatan = new JTextField(String.valueOf(pelanggan.getTingkatan()));
        tingkatan.setBounds(210, 450, 315, 40);
        tingkatan.setFont(new Font("Arial", Font.PLAIN, 14));
        tingkatan.setEditable(false);

        saldo = new JTextField(String.valueOf(pelanggan.getSaldo()));
        saldo.setBounds(210, 500, 315, 40);
        saldo.setFont(new Font("Arial", Font.PLAIN, 14));
        saldo.setEditable(false);

        btnSimpan = GUI.defaultButton("Simpan", 18);
        btnSimpan.setBounds(390, 620, 140, 40);
        btnSimpan.setVisible(false);
        btnSimpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nama.getText().isEmpty() || email.getText().isEmpty() || noHp.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, Constant.ERROR_MESSAGE);
                } else {
                    String[] splited = nama.getText().split("\\s+");
                    String namaDepan = splited[0];
                    String namaBelakang = "";
                    if (splited.length != 1) {
                        for (int i = 1; i < splited.length; i++) {
                            namaBelakang += splited[i] + " ";
                        }
                    }
                    boolean updateData = controller.updateDataPelanggan(namaDepan, namaBelakang, email.getText(), noHp.getText(), pelanggan.getIdUser());

                    if (updateData) {
                        JOptionPane.showMessageDialog(null, "Data anda terubah.");
                        pelanggan.setEmailUser(email.getText());
                        pelanggan.setNamaDepan(namaDepan);
                        pelanggan.setNamaBelakang(namaBelakang);
                        pelanggan.setNoHp(noHp.getText());

                        nama.setText(pelanggan.getNamaDepan() + " " + pelanggan.getNamaBelakang());
                        email.setText(pelanggan.getEmailUser());
                        noHp.setText(pelanggan.getNoHp());
                        btnHapus.setVisible(false);
                        btnSimpan.setVisible(false);
                        btnEditProfile.setVisible(true);
                        nama.setEditable(false);
                        email.setEditable(false);
                        noHp.setEditable(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Gagal Update Data");
                    }

                }

            }
        });

        btnHapus = GUI.defaultButton("Hapus Akun", 18);
        btnHapus.setBounds(90, 620, 140, 40);
        btnHapus.setVisible(false);

        //Button
        btnEditProfile = GUI.defaultButton("Edit Profil", 18);
        btnEditProfile.setBounds(390, 620, 140, 40);
        btnEditProfile.addActionListener(e -> {
            btnEditProfile.setVisible(false);
            btnSimpan.setVisible(true);
            btnHapus.setVisible(true);
            email.setEditable(true);
            noHp.setEditable(true);
            nama.setEditable(true);
        });


        //Frame
        frame = GUI.defaultFrame();
        frame.getContentPane().setBackground(GUI.backGroundColor());
        frame.add(labelKembali);
        frame.add(labelProfilePic);
        frame.add(labelEmail);
        frame.add(labelTingkatan);
        frame.add(email);
        frame.add(tingkatan);
        frame.add(labelSaldo);
        frame.add(saldo);
        frame.add(labelNoHp);
        frame.add(noHp);
        frame.add(labelNama);
        frame.add(nama);
        frame.add(btnEditProfile);
        frame.add(btnSimpan);
        frame.add(btnHapus);

    }
}
