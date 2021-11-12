package View;

import Model.*;
import Controller.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPelanggan {
    JFrame frame;
    JPanel panelRegisterPelanggan;
    JLabel labelJudul, labelNamaDepan, labelNamaBelakang, labelEmail, labelNomorHP, labelPassword;
    JTextField inputNamaDepan, inputNamaBelakang, inputEmail, inputNomorHP;
    JPasswordField inputPassword;
    JButton buttonRegister;

    public RegisterPelanggan() {
        //Label Judul
        labelJudul = new JLabel("REGISTER - PELANGGAN", SwingConstants.CENTER);
        labelJudul.setBounds(0, 100, 600, 30);
        labelJudul.setFont(new Font("Arial", Font.BOLD, 20));

        //Label Nama Depan
        labelNamaDepan = new JLabel("Nama Depan");
        labelNamaDepan.setFont(new Font("Arial", Font.PLAIN, 16));
        labelNamaDepan.setBounds(65, 210, 150, 30);

        //Input Nama Depan
        inputNamaDepan = new JTextField();
        inputNamaDepan.setBounds(230, 210, 250, 30);

        //Label Nama Belakang
        labelNamaBelakang = new JLabel("Nama Belakang");
        labelNamaBelakang.setFont(new Font("Arial", Font.PLAIN, 16));
        labelNamaBelakang.setBounds(65, 260, 150, 30);

        //Input Nama Belakang
        inputNamaBelakang = new JTextField();
        inputNamaBelakang.setBounds(230, 260, 250, 30);

        //Label Email
        labelEmail = new JLabel("Email");
        labelEmail.setFont(new Font("Arial", Font.PLAIN, 16));
        labelEmail.setBounds(65, 310, 150, 30);

        //Input Email
        inputEmail = new JTextField();
        inputEmail.setBounds(230, 310, 250, 30);

        //Label Nomor HP
        labelNomorHP = new JLabel("Nomor HP");
        labelNomorHP.setFont(new Font("Arial", Font.PLAIN, 16));
        labelNomorHP.setBounds(65, 360, 150, 30);

        //Input Nomor HP
        inputNomorHP = new JTextField();
        inputNomorHP.setBounds(230, 360, 250, 30);

        //Label Password
        labelPassword = new JLabel("Password");
        labelPassword.setFont(new Font("Arial", Font.PLAIN, 16));
        labelPassword.setBounds(65, 410, 150, 30);

        //Input Password
        inputPassword = new JPasswordField();
        inputPassword.setBounds(230, 410, 250, 30);

        //button Register
        buttonRegister = new JButton("Register");
        buttonRegister.setBounds(380, 500, 100, 40);
        buttonRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller controller = new Controller();

                String namaDepan = inputNamaDepan.getText();
                String namaBelakang = inputNamaBelakang.getText();
                String emailUser = inputEmail.getText();
                String password = String.valueOf(inputPassword.getPassword());
                int banyakUser = controller.HitungJumlahUser();
                double saldo = 0;

                User penggunaBaru = new Pelanggan(TingkatanUser.BRONZE,banyakUser+1, namaDepan, namaBelakang,emailUser,password,saldo,Role.PELANGGAN,null);
                if(controller.RegisterPelanggan((Pelanggan) penggunaBaru)){
                    JOptionPane.showMessageDialog(null, "Register Berhasil!");
                    frame.dispose();
                    new BerandaPelanggan();
                } else {
                    JOptionPane.showMessageDialog(null, "Register Gagal. Silahkan coba lagi");
                }
            }
        });

        //Panel
        panelRegisterPelanggan = new JPanel();
        panelRegisterPelanggan.setSize(600, 800);
        panelRegisterPelanggan.setVisible(true);
        panelRegisterPelanggan.setLayout(null);
        panelRegisterPelanggan.add(labelJudul);
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
