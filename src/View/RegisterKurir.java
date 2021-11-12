package View;

import Controller.*;
import Model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterKurir {
    JFrame frame;
    JPanel panelRegisterKurir;
    JLabel labelJudul, labelNamaDepan, labelNamaBelakang, labelNIK, labelPlatNomor, labelJenisKendaraan, labelEmail, labelNomorHP, labelPassword;
    JTextField inputNamaDepan, inputNamaBelakang, inputNIK, inputPlatnomor, inputJenisKendaraan, inputEmail, inputNomorHp;
    JPasswordField inputPassword;
    JButton buttonRegister;

    public RegisterKurir() {
        //Label Judul
        labelJudul = new JLabel("REGISTER - KURIR", SwingConstants.CENTER);
        labelJudul.setBounds(0, 50, 600, 30);
        labelJudul.setFont(new Font("Arial", Font.BOLD, 20));

        //Label Nama Depan
        labelNamaDepan = new JLabel("Nama Depan");
        labelNamaDepan.setFont(new Font("Arial", Font.PLAIN, 16));
        labelNamaDepan.setBounds(65, 130, 150, 30);

        //Input Nama Depan
        inputNamaDepan = new JTextField();
        inputNamaDepan.setBounds(230, 130, 250, 30);

        //Label Nama Belakang
        labelNamaBelakang = new JLabel("Nama Belakang");
        labelNamaBelakang.setFont(new Font("Arial", Font.PLAIN, 16));
        labelNamaBelakang.setBounds(65, 180, 150, 30);

        //Input Nama Belakang
        inputNamaBelakang = new JTextField();
        inputNamaBelakang.setBounds(230, 180, 250, 30);

        //Label NIK
        labelNIK = new JLabel("NIK");
        labelNIK.setFont(new Font("Arial", Font.PLAIN, 16));
        labelNIK.setBounds(65, 230, 150, 30);

        //Input NIK
        inputNIK = new JTextField();
        inputNIK.setBounds(230, 230, 250, 30);

        //Label Plat Nomor
        labelPlatNomor = new JLabel("Plat Nomor");
        labelPlatNomor.setFont(new Font("Arial", Font.PLAIN, 16));
        labelPlatNomor.setBounds(65, 280, 150, 30);

        //Input Plat Nomor
        inputPlatnomor = new JTextField();
        inputPlatnomor.setBounds(230, 280, 250, 30);

        //Label Jenis Kendaraan
        labelJenisKendaraan = new JLabel("Jenis Kendaraan");
        labelJenisKendaraan.setFont(new Font("Arial", Font.PLAIN, 16));
        labelJenisKendaraan.setBounds(65, 330, 150, 30);

        inputJenisKendaraan = new JTextField();
        inputJenisKendaraan.setBounds(230, 330, 250, 30);

        //Label Email
        labelEmail = new JLabel("Email");
        labelEmail.setFont(new Font("Arial", Font.PLAIN, 16));
        labelEmail.setBounds(65, 370, 150, 30);

        //Input Email
        inputEmail = new JTextField();
        inputEmail.setBounds(230, 370, 250, 30);

        //Label Nomor HP
        labelNomorHP = new JLabel("Nomor HP");
        labelNomorHP.setFont(new Font("Arial", Font.PLAIN, 16));
        labelNomorHP.setBounds(65, 420, 150, 30);

        //Input Nomor HP
        inputNomorHp = new JTextField();
        inputNomorHp.setBounds(230, 420, 250, 30);

        //Label Password
        labelPassword = new JLabel("Password");
        labelPassword.setFont(new Font("Arial", Font.PLAIN, 16));
        labelPassword.setBounds(65, 470, 150, 30);

        //Input Password
        inputPassword = new JPasswordField();
        inputPassword.setBounds(230, 470, 250, 30);

        //button Register
        buttonRegister = new JButton("Register");
        buttonRegister.setBounds(380, 540, 100, 40);
        buttonRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller controller = new Controller();
                KurirController ck = new KurirController();
                String namaDepan = inputNamaDepan.getText();
                String namaBelakang = inputNamaBelakang.getText();
                String emailUser = inputEmail.getText();
                String password = String.valueOf(inputPassword.getPassword());
                String role = String.valueOf(Role.PELANGGAN);
                double saldo = 0;
                String NIK = inputNIK.getText();
                int jumlahUserSekarang = controller.HitungJumlahUser();
                int idUser = jumlahUserSekarang+1;
                double totalPendapatan = 0;
                int ketersediaan = 0;
                String plat = inputPlatnomor.getText();
                String jenisKendaraan = inputJenisKendaraan.getText();

                User kurirBaru = new Kurir(totalPendapatan, NIK, ketersediaan, plat, jenisKendaraan,idUser, namaDepan, namaBelakang, emailUser, password, saldo, Role.KURIR, null);

                if(ck.RegisterKurir((Kurir) kurirBaru)){
                    JOptionPane.showMessageDialog(null, "Register Berhasil!");
                    frame.dispose();
                    new HomePelanggan();
                } else {
                    JOptionPane.showMessageDialog(null, "Coba lagi");
                }




            }
        });

        //Panel
        panelRegisterKurir = new JPanel();
        panelRegisterKurir.setSize(600, 800);
        panelRegisterKurir.setVisible(true);
        panelRegisterKurir.setLayout(null);
        panelRegisterKurir.add(labelJudul);
        panelRegisterKurir.add(labelNamaDepan);
        panelRegisterKurir.add(labelNamaBelakang);
        panelRegisterKurir.add(labelNIK);
        panelRegisterKurir.add(labelPlatNomor);
        panelRegisterKurir.add(labelJenisKendaraan);
        panelRegisterKurir.add(labelEmail);
        panelRegisterKurir.add(labelNomorHP);
        panelRegisterKurir.add(labelPassword);
        panelRegisterKurir.add(inputNamaDepan);
        panelRegisterKurir.add(inputNamaBelakang);
        panelRegisterKurir.add(inputNIK);
        panelRegisterKurir.add(inputPlatnomor);
        panelRegisterKurir.add(inputJenisKendaraan);
        panelRegisterKurir.add(inputEmail);
        panelRegisterKurir.add(inputNomorHp);
        panelRegisterKurir.add(inputPassword);
        panelRegisterKurir.add(buttonRegister);


        //Frame
        frame = new JFrame(Constant.applicationName + " - Register Kurir");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 800);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.add(panelRegisterKurir);
    }
}
