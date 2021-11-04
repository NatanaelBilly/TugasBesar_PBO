package View;

import Model.Constant;

import javax.swing.*;
import java.awt.*;

public class RegisterKurir {
    JFrame frame;
    JPanel panelRegisterKurir;
    JLabel labelNamaDepan,labelNamaBelakang, labelNIK, labelPlatNomor, labelJenisKendaraan, labelEmail, labelNomorHP, labelPassword;
    JTextField inputNamaDepan, inputNamaBelakang, inputNIK, inputPlatnomor, inputJenisKendaraan, inputEmail, inputNomorHp;
    JPasswordField inputPassword;
    JButton buttonRegister;

    public RegisterKurir(){
        //Label Nama Depan
        labelNamaDepan = new JLabel("Nama Depan");
        labelNamaDepan.setFont(new Font("Arial", Font.PLAIN, 16));
        labelNamaDepan.setBounds(65,90,150,30);

        //Input Nama Depan
        inputNamaDepan = new JTextField();
        inputNamaDepan.setBounds(230,90,250,30);

        //Label Nama Belakang
        labelNamaBelakang = new JLabel("Nama Belakang");
        labelNamaBelakang.setFont(new Font("Arial", Font.PLAIN, 16));
        labelNamaBelakang.setBounds(65,140,150,30);

        //Input Nama Belakang
        inputNamaBelakang = new JTextField();
        inputNamaBelakang.setBounds(230,140,250,30);

        //Label NIK
        labelNIK = new JLabel("NIK");
        labelNIK.setFont(new Font("Arial", Font.PLAIN, 16));
        labelNIK.setBounds(65,190,150,30);

        //Input NIK
        inputNIK = new JTextField();
        inputNIK.setBounds(230,190,250,30);

        //Label Plat Nomor
        labelPlatNomor = new JLabel("Plat Nomor");
        labelPlatNomor.setFont(new Font("Arial", Font.PLAIN, 16));
        labelPlatNomor.setBounds(65,240,150,30);

        //Input Plat Nomor
        inputPlatnomor = new JTextField();
        inputPlatnomor.setBounds(230,240,250,30);

        //Label Jenis Kendaraan
        labelJenisKendaraan = new JLabel("Jenis Kendaraan");
        labelJenisKendaraan.setFont(new Font("Arial", Font.PLAIN, 16));
        labelJenisKendaraan.setBounds(65,290,150,30);

        inputJenisKendaraan = new JTextField();
        inputJenisKendaraan.setBounds(230,290,250,30);

        //Label Email
        labelEmail = new JLabel("Email");
        labelEmail.setFont(new Font("Arial", Font.PLAIN, 16));
        labelEmail.setBounds(65,330,150,30);

        //Input Email
        inputEmail = new JTextField();
        inputEmail.setBounds(230,330,250,30);

        //Label Nomor HP
        labelNomorHP = new JLabel("Nomor HP");
        labelNomorHP.setFont(new Font("Arial", Font.PLAIN, 16));
        labelNomorHP.setBounds(65,380,150,30);

        //Input Nomor HP
        inputNomorHp = new JTextField();
        inputNomorHp.setBounds(230,380,250,30);

        //Label Password
        labelPassword = new JLabel("Password");
        labelPassword.setFont(new Font("Arial", Font.PLAIN, 16));
        labelPassword.setBounds(65,430,150,30);

        //Input Password
        inputPassword = new JPasswordField();
        inputPassword.setBounds(230,430,250,30);

        //button Register
        buttonRegister = new JButton("Register");
        buttonRegister.setBounds(380, 500, 100,40);

        //Panel
        panelRegisterKurir = new JPanel();
        panelRegisterKurir.setSize(600,800);
        panelRegisterKurir.setVisible(true);
        panelRegisterKurir.setLayout(null);
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
        frame = new JFrame(Constant.applicationName+" - Register Kurir");
        frame.setSize(600,800);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.add(panelRegisterKurir);
    }
}
