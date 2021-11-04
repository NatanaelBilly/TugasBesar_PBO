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

    public RegisterKurir(){
        //Label Nama Depan
        labelNamaDepan = new JLabel("Nama Depan");
        labelNamaDepan.setFont(new Font("Arial", Font.PLAIN, 16));
        labelNamaDepan.setBounds(65,60,150,35);

        //Input Nama Depan
        inputNamaDepan = new JTextField();
        inputNamaDepan.setBounds(230,60,250,30);

        //Label Nama Belakang
        labelNamaBelakang = new JLabel("Nama Belakang");
        labelNamaBelakang.setFont(new Font("Arial", Font.PLAIN, 16));
        labelNamaBelakang.setBounds(65,100,150,35);

        //Input Nama Belakang
        inputNamaBelakang = new JTextField();
        inputNamaBelakang.setBounds(230,100,250,30);

        //Label NIK
        labelNIK = new JLabel("NIK");
        labelNIK.setFont(new Font("Arial", Font.PLAIN, 16));
        labelNIK.setBounds(65,140,150,35);

        //Input NIK
        inputNIK = new JTextField();
        inputNIK.setBounds(230,140,250,30);

        //Label Plat Nomor
        labelPlatNomor = new JLabel("Plat Nomor");
        labelPlatNomor.setFont(new Font("Arial", Font.PLAIN, 16));
        labelPlatNomor.setBounds(65,210,150,35);

        //Input Plat Nomor
        inputPlatnomor = new JTextField();
        inputPlatnomor.setBounds(230,210,250,30);

        //Label Jenis Kendaraan
        labelJenisKendaraan = new JLabel("Jenis Kendaraan");
        labelJenisKendaraan.setFont(new Font("Arial", Font.PLAIN, 16));
        labelJenisKendaraan.setBounds(65,245,150,35);

        inputJenisKendaraan = new JTextField();
        inputJenisKendaraan.setBounds(230,245,250,30);

        //Label Email
        labelEmail = new JLabel("Email");
        labelEmail.setFont(new Font("Arial", Font.PLAIN, 16));
        labelEmail.setBounds(65,280,150,35);

        //Input Email
        inputEmail = new JTextField();
        inputEmail.setBounds(230,280,250,30);

        //Label Nomor HP
        labelNomorHP = new JLabel("Nomor HP");
        labelNomorHP.setFont(new Font("Arial", Font.PLAIN, 16));
        labelNomorHP.setBounds(65,315,150,35);

        //Input Nomor HP
        inputNomorHp = new JTextField();
        inputNomorHp.setBounds(230,315,250,30);

        //Label Password
        labelPassword = new JLabel("Password");
        labelPassword.setFont(new Font("Arial", Font.PLAIN, 16));
        labelPassword.setBounds(65,350,150,35);

        //Input Password
        inputPassword = new JPasswordField();
        inputPassword.setBounds(230,350,150,35);


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


        //Frame
        frame = new JFrame(Constant.applicationName);
        frame.setSize(600,800);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.add(panelRegisterKurir);
    }
}
