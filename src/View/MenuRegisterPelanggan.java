package View;

import Model.*;
import Controller.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MenuRegisterPelanggan {
    JFrame frame;
    JPanel panelRegisterPelanggan;
    JLabel labelKembali, labelJudul, labelNamaDepan, labelNamaBelakang, labelEmail, labelNomorHP, labelPassword;
    JTextField inputNamaDepan, inputNamaBelakang, inputEmail, inputNomorHP;
    JPasswordField inputPassword;
    JButton buttonRegister;

    public MenuRegisterPelanggan() {
        //Link Kembali
        labelKembali = new DefaultComponentSetting().defaultBackLabel();
        labelKembali.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                new MenuRegisterPilihRule();
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
        labelJudul = new DefaultComponentSetting().defaultHeadingLabel("Anda akan register sebagai pelanggan");
        labelJudul.setBounds(0, 100, 600, 30);

        //Label Nama Depan
        labelNamaDepan = new DefaultComponentSetting().defaultRegularLabel("Nama Depan");
        labelNamaDepan.setBounds(65, 210, 150, 30);

        //Input Nama Depan
        inputNamaDepan = new JTextField();
        inputNamaDepan.setBounds(230, 210, 250, 30);

        //Label Nama Belakang
        labelNamaBelakang = new DefaultComponentSetting().defaultRegularLabel("Nama Belakang");
        labelNamaBelakang.setBounds(65, 260, 150, 30);

        //Input Nama Belakang
        inputNamaBelakang = new JTextField();
        inputNamaBelakang.setBounds(230, 260, 250, 30);

        //Label Email
        labelEmail = new DefaultComponentSetting().defaultRegularLabel("Email");
        labelEmail.setBounds(65, 310, 150, 30);

        //Input Email
        inputEmail = new JTextField();
        inputEmail.setBounds(230, 310, 250, 30);

        //Label Nomor HP
        labelNomorHP = new DefaultComponentSetting().defaultRegularLabel("Nomor HP");
        labelNomorHP.setBounds(65, 360, 150, 30);

        //Input Nomor HP
        inputNomorHP = new JTextField();
        inputNomorHP.setBounds(230, 360, 250, 30);

        //Label Password
        labelPassword = new DefaultComponentSetting().defaultRegularLabel("Password");
        labelPassword.setBounds(65, 410, 150, 30);

        //Input Password
        inputPassword = new JPasswordField();
        inputPassword.setBounds(230, 410, 250, 30);

        //button Register
        buttonRegister = new JButton("Register");
        buttonRegister.setBounds(380, 500, 100, 40);
        buttonRegister.addActionListener(e -> {
            Controller controller = new Controller();
            String noHP = inputNomorHP.getText();
            String namaDepan = inputNamaDepan.getText();
            String namaBelakang = inputNamaBelakang.getText();
            String emailUser = inputEmail.getText();
            String password = String.valueOf(inputPassword.getPassword());
            int banyakUser = controller.HitungJumlahUser();
            double saldo = 0;

            User penggunaBaru = new Pelanggan(TingkatanUser.BRONZE, banyakUser + 1, namaDepan, namaBelakang, noHP, emailUser, password, saldo, Role.PELANGGAN, null);
            if (controller.RegisterPelanggan((Pelanggan) penggunaBaru)) {
                JOptionPane.showMessageDialog(null, "Register Berhasil!");
                frame.dispose();
                new BerandaPelanggan((Pelanggan) penggunaBaru);
            } else {
                JOptionPane.showMessageDialog(null, "Register Gagal. Silahkan coba lagi");
            }
        });

        //Panel
        panelRegisterPelanggan = new JPanel();
        panelRegisterPelanggan.setSize(600, 800);
        panelRegisterPelanggan.setVisible(true);
        panelRegisterPelanggan.setLayout(null);
        panelRegisterPelanggan.add(labelJudul);
        panelRegisterPelanggan.add(labelKembali);
        panelRegisterPelanggan.add(labelNamaDepan);
        panelRegisterPelanggan.add(labelNamaBelakang);
        panelRegisterPelanggan.add(labelEmail);
        panelRegisterPelanggan.add(labelNomorHP);
        panelRegisterPelanggan.add(labelPassword);
        panelRegisterPelanggan.add(inputNamaDepan);
        panelRegisterPelanggan.add(inputNamaBelakang);
        panelRegisterPelanggan.add(inputEmail);
        panelRegisterPelanggan.add(inputNomorHP);
        panelRegisterPelanggan.add(inputPassword);
        panelRegisterPelanggan.add(buttonRegister);

        //Frame
        frame = new DefaultComponentSetting().defaultFrame();
        frame.add(panelRegisterPelanggan);
    }

}
