/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Controller;
import Controller.KurirController;
import Model.Kurir;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Asus
 */
public class MenuEditProfilKurir {

    private JFrame frame;
    private JPanel panelEditData;
    private JPanel panelEditPassword;
    private JLabel labelJudul, labelNamaDepan, labelNamaBelakang, labelNIK, labelPlatNomor, labelJenisKendaraan, labelEmail, labelNoHp;
    private JTextField inputNamaDepan, inputNamaBelakang, inputNIK, inputPlatnomor, inputJenisKendaraan, inputEmail, inputNoHp, inputPasswordLama, inputPasswordBaru, inputPasswordBaru2;

    private Kurir kurir;

    private KurirController conKurir = new KurirController();
    private Controller con = new Controller();
    private final DefaultComponentSetting GUI = new DefaultComponentSetting();

    public MenuEditProfilKurir(Kurir kurir) {

        this.kurir = kurir;

        //Label Judul
        labelJudul = GUI.defaultHeadingLabel("UBAH PROFIL");
        labelJudul.setBounds(50, 50, 500, 80);

        //Label Nama Depan
        labelNamaDepan = GUI.defaultRegularLabel("Nama Depan");
        labelNamaDepan.setBounds(65, 130, 150, 30);
        //Input Nama Depan
        inputNamaDepan = new JTextField();
        inputNamaDepan.setBounds(230, 130, 250, 30);
        inputNamaDepan.setText(kurir.getNama_depan());

        //Label Nama Belakang
        labelNamaBelakang = GUI.defaultRegularLabel("Nama Belakang");
        labelNamaBelakang.setBounds(65, 180, 150, 30);
        //Input Nama Belakang
        inputNamaBelakang = new JTextField();
        inputNamaBelakang.setBounds(230, 180, 250, 30);
        inputNamaBelakang.setText(kurir.getNama_belakang());

        //Label NIK
        labelNIK = GUI.defaultRegularLabel("NIK");
        labelNIK.setBounds(65, 230, 150, 30);
        //Input NIK
        inputNIK = new JTextField();
        inputNIK.setBounds(230, 230, 250, 30);
        inputNIK.setText(kurir.getNIK());

        //Label Email
        labelEmail = GUI.defaultRegularLabel("Email");
        labelEmail.setBounds(65, 280, 150, 30);
        //Input Email
        inputEmail = new JTextField();
        inputEmail.setBounds(230, 280, 250, 30);
        inputEmail.setText(kurir.getEmail_user());

        //Label No HP
        labelNoHp = GUI.defaultRegularLabel("Nomor Telepon");
        labelNoHp.setBounds(65, 330, 150, 30);
        //Input No HP
        inputNoHp = new JTextField();
        inputNoHp.setBounds(230, 330, 250, 30);
        inputNoHp.setText(kurir.getNoHp());

        //Label Plat Nomor
        labelPlatNomor = GUI.defaultRegularLabel("Plat Nomor");
        labelPlatNomor.setBounds(65, 380, 150, 30);
        //Input Plat Nomor
        inputPlatnomor = new JTextField();
        inputPlatnomor.setBounds(230, 380, 250, 30);
        inputPlatnomor.setText(kurir.getPlat());

        //Label Jenis Kendaraan
        labelJenisKendaraan = GUI.defaultRegularLabel("Jenis Kendaraan");
        labelJenisKendaraan.setBounds(65, 430, 150, 30);
        //Input Jenis
        inputJenisKendaraan = new JTextField();
        inputJenisKendaraan.setBounds(230, 430, 250, 30);
        inputJenisKendaraan.setText(kurir.getJenis_kendaraan());

//=====================Input Password=====================
//        Label Password
        JLabel labelPassword = GUI.defaultRegularLabel("Kata Sandi Lama");
        labelPassword.setHorizontalAlignment(SwingConstants.CENTER);
        labelPassword.setBounds(200, 150, 200, 30);
        inputPasswordLama = new JPasswordField();
        inputPasswordLama.setBounds(150, 180, 300, 30);

        JLabel labelPasswordBaru = GUI.defaultRegularLabel("Kata Sandi Baru");
        labelPasswordBaru.setHorizontalAlignment(SwingConstants.CENTER);
        labelPasswordBaru.setBounds(200, 250, 200, 30);
        inputPasswordBaru = new JPasswordField();
        inputPasswordBaru.setBounds(150, 280, 300, 30);

        JLabel labelPasswordBaru2 = GUI.defaultRegularLabel("Konfirmasi Kata Sandi");
        labelPasswordBaru2.setHorizontalAlignment(SwingConstants.CENTER);
        labelPasswordBaru2.setBounds(200, 350, 200, 30);
        inputPasswordBaru2 = new JPasswordField();
        inputPasswordBaru2.setBounds(150, 380, 300, 30);

//=====================Input Password=====================
//======================BUTTON======================
        //Link Kembali
        JLabel kembaliKeLihatProfil = GUI.defaultBackLabel();
        kembaliKeLihatProfil.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new MenuLihatProfilKurir(kurir);
                frame.dispose();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                new MenuLihatProfilKurir(kurir);
                frame.dispose();
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

        //Link Kembali Ke Edit
        JLabel kembaliKeUbahProfil = GUI.defaultBackLabel();
        kembaliKeUbahProfil.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                labelJudul.setText("EDIT PROFIL");
                panelEditData.setVisible(true);
                panelEditPassword.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                labelJudul.setText("EDIT PROFIL");
                panelEditData.setVisible(true);
                panelEditPassword.setVisible(false);
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

        //Submit Data
        JButton btnSubmitData = GUI.defaultButton("Submit", 20);
        btnSubmitData.setBounds(200, 550, 200, 50);
        btnSubmitData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Cek Email Redundant
                String newEmail = inputEmail.getText();
                if (con.cekUserDiDataBase(newEmail) && !kurir.getEmail_user().equals(newEmail)) {
                    JOptionPane.showMessageDialog(null, "Email tersebut sudah digunakan orang lain");
                } else {

                    //Cek Konfirmasi
                    int konfirmasi = JOptionPane.showConfirmDialog(null, "Apakah data yang akan diperbaharui sudah benar ?");

                    if (konfirmasi == 0) {

                        Kurir kurirBaru = kurir;
                        kurirBaru.setNama_depan(inputNamaDepan.getText());
                        kurirBaru.setNama_belakang(inputNamaBelakang.getText());
                        kurirBaru.setEmail_user(inputEmail.getText());
                        kurirBaru.setNoHp(inputNoHp.getText());
                        kurirBaru.setNIK(inputNIK.getText());

                        kurirBaru.setPlat(inputPlatnomor.getText());
                        kurirBaru.setJenis_kendaraan(inputJenisKendaraan.getText());

                        if (conKurir.EditDataKurirToDB(kurirBaru)) {
                            JOptionPane.showMessageDialog(null, "Profil Telah Diperbaharui");
                        } else {
                            JOptionPane.showMessageDialog(null, "Mohon Maaf, Terjadi Kesalahan");
                        }

                        new MenuLihatProfilKurir(kurir);
                        frame.dispose();

                    } else if (konfirmasi == 1) {
                        JOptionPane.showMessageDialog(null, "Perubahan Profil Dibatalkan");
                        new MenuLihatProfilKurir(kurir);
                        frame.dispose();
                    }
                }
            }
        });

        //Button Edit Password
        JButton btnPassword = GUI.defaultButton("Ubah Kata Sandi", 20);
        btnPassword.setBounds(200, 625, 200, 50);
        btnPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelJudul.setText("UBAH KATA SANDI");
                panelEditData.setVisible(false);
                panelEditPassword.setVisible(true);
            }
        });

        //Submit Password
        JButton btnSubmitPassword = GUI.defaultButton("Submit", 20);
        btnSubmitPassword.setBounds(200, 550, 200, 50);
        btnSubmitPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Cek Kata Sandi
                if (!inputPasswordLama.getText().equals(kurir.getPassword())) {
                    System.out.println("Input = " );
                    JOptionPane.showMessageDialog(null, "Kata Sandi lama salah");
                } else if (!inputPasswordBaru.getText().equals(inputPasswordBaru2.getText())) {
                    JOptionPane.showMessageDialog(null, "Kata Sandi baru tidak cocok");
                } else {
                    //Konfirmasi
                    int konfirmasi = JOptionPane.showConfirmDialog(null, "Apakah anda sudah yakin mengubah kata sandi baru?");

                    if (konfirmasi == 0) {
                        Kurir kurirBaru = kurir;
                        kurirBaru.setPassword(inputPasswordBaru.getText());

                        if (conKurir.EditDataKurirToDB(kurirBaru)) {
                            JOptionPane.showMessageDialog(null, "Kata Sandi Berhasil Diubah");
                        } else {
                            JOptionPane.showMessageDialog(null, "Mohon Maaf, Terjadi Kesalahan");
                        }

                        new MenuEditProfilKurir(kurir);
                        frame.dispose();
                    } else if (konfirmasi == 1) {
                        JOptionPane.showMessageDialog(null, "Ubah Kata Sandi Dibatalkan");
                        new MenuEditProfilKurir(kurir);
                        frame.dispose();
                    }
                }

            }
        });

//======================BUTTON======================
//Panel Edit Data
        panelEditData = new JPanel();
        panelEditData.setSize(600, 800);
        panelEditData.setVisible(true);
        panelEditData.setLayout(null);

        //panelEditData.add(labelJudul);
        panelEditData.add(labelNamaDepan);
        panelEditData.add(labelNamaBelakang);
        panelEditData.add(labelNIK);
        panelEditData.add(labelPlatNomor);
        panelEditData.add(labelJenisKendaraan);
        panelEditData.add(labelEmail);
        panelEditData.add(labelNoHp);
        panelEditData.add(inputNamaDepan);
        panelEditData.add(inputNamaBelakang);
        panelEditData.add(inputNIK);
        panelEditData.add(inputPlatnomor);
        panelEditData.add(inputJenisKendaraan);
        panelEditData.add(inputEmail);
        panelEditData.add(inputNoHp);
        panelEditData.add(btnSubmitData);
        panelEditData.add(kembaliKeLihatProfil);
        panelEditData.add(btnPassword);

        //Panel Edit Password       
        panelEditPassword = new JPanel();
        panelEditPassword.setSize(600, 800);
        panelEditPassword.setVisible(false);
        panelEditPassword.setLayout(null);

        //panelEditPassword.add(labelJudul);
        panelEditPassword.add(labelPassword);
        panelEditPassword.add(labelPasswordBaru);
        panelEditPassword.add(labelPasswordBaru2);
        panelEditPassword.add(inputPasswordLama);
        panelEditPassword.add(inputPasswordBaru);
        panelEditPassword.add(inputPasswordBaru2);
        panelEditPassword.add(btnSubmitPassword);
        panelEditPassword.add(kembaliKeUbahProfil);

        //Frame
        frame = GUI.defaultFrame();
        frame.add(labelJudul);
        frame.add(panelEditData);
        frame.add(panelEditPassword);
    }

}
