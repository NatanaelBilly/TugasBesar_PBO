package View;

import Controller.*;
import Model.*;

import javax.swing.*;
import java.awt.*;

public class RegisterKurir {
    JFrame frame;
    JPanel panelRegisterKurir;
    JLabel labelJudul, labelNamaDepan, labelNamaBelakang, labelNIK, labelPlatNomor, labelJenisKendaraan, labelEmail, labelNomorHP, labelPassword;
    JTextField inputNamaDepan, inputNamaBelakang, inputNIK, inputPlatnomor, inputJenisKendaraan, inputEmail, inputNomorHp;
    JPasswordField inputPassword;
    JButton buttonRegister;

    public RegisterKurir() {
        //Label Judul
        labelJudul = new DefaultComponentSetting().defaultHeadingLabel("Register sebagai Kurir");
        labelJudul.setBounds(0, 50, 600, 30);

        //Label Nama Depan
        labelNamaDepan = new DefaultComponentSetting().defaultRegularLabel("Nama Depan");
        labelNamaDepan.setBounds(65, 130, 150, 30);

        //Input Nama Depan
        inputNamaDepan = new JTextField();
        inputNamaDepan.setBounds(230, 130, 250, 30);

        //Label Nama Belakang
        labelNamaBelakang = new DefaultComponentSetting().defaultRegularLabel("Nama Belakang");
        labelNamaBelakang.setBounds(65, 180, 150, 30);

        //Input Nama Belakang
        inputNamaBelakang = new JTextField();
        inputNamaBelakang.setBounds(230, 180, 250, 30);

        //Label NIK
        labelNIK = new DefaultComponentSetting().defaultRegularLabel("NIK");
        labelNIK.setBounds(65, 230, 150, 30);

        //Input NIK
        inputNIK = new JTextField();
        inputNIK.setBounds(230, 230, 250, 30);

        //Label Plat Nomor
        labelPlatNomor = new DefaultComponentSetting().defaultRegularLabel("Plat Nomor");
        labelPlatNomor.setFont(new Font("Arial", Font.PLAIN, 16));
        labelPlatNomor.setBounds(65, 280, 150, 30);

        //Input Plat Nomor
        inputPlatnomor = new JTextField();
        inputPlatnomor.setBounds(230, 280, 250, 30);

        //Label Jenis Kendaraan
        labelJenisKendaraan = new DefaultComponentSetting().defaultRegularLabel("Jenis Kendaraan");
        labelJenisKendaraan.setBounds(65, 330, 150, 30);

        inputJenisKendaraan = new JTextField();
        inputJenisKendaraan.setBounds(230, 330, 250, 30);

        //Label Email
        labelEmail = new DefaultComponentSetting().defaultRegularLabel("Email");
        labelEmail.setBounds(65, 370, 150, 30);

        //Input Email
        inputEmail = new JTextField();
        inputEmail.setBounds(230, 370, 250, 30);

        //Label Nomor HP
        labelNomorHP = new DefaultComponentSetting().defaultRegularLabel("Nomor HP");
        labelNomorHP.setBounds(65, 420, 150, 30);

        //Input Nomor HP
        inputNomorHp = new JTextField();
        inputNomorHp.setBounds(230, 420, 250, 30);

        //Label Password
        labelPassword = new DefaultComponentSetting().defaultRegularLabel("Password");
        labelPassword.setBounds(65, 470, 150, 30);

        //Input Password
        inputPassword = new JPasswordField();
        inputPassword.setBounds(230, 470, 250, 30);

        //button Register
        buttonRegister = new JButton("Register");
        buttonRegister.setBounds(380, 540, 100, 40);
        buttonRegister.addActionListener(e -> {
            Controller controller = new Controller();
            KurirController ck = new KurirController();
            String namaDepan = inputNamaDepan.getText();
            String namaBelakang = inputNamaBelakang.getText();
            String noHP = inputNomorHp.getText();
            String emailUser = inputEmail.getText();
            String password = String.valueOf(inputPassword.getPassword());
            String role = String.valueOf(Role.PELANGGAN);
            double saldo = 0;
            String NIK = inputNIK.getText();
            int jumlahUserSekarang = controller.HitungJumlahUser();
            int idUser = jumlahUserSekarang + 1;
            double totalPendapatan = 0;
            int ketersediaan = 0;
            String plat = inputPlatnomor.getText();
            String jenisKendaraan = inputJenisKendaraan.getText();

            Kurir kurirBaru = new Kurir(totalPendapatan, NIK, ketersediaan, plat, jenisKendaraan, idUser, namaDepan, namaBelakang, noHP, emailUser, password, saldo, Role.KURIR, null);

            if (ck.RegisterKurir(kurirBaru)) {
                JOptionPane.showMessageDialog(null, "Register Berhasil!");
                frame.dispose();
                new BerandaPelanggan();
            } else {
                JOptionPane.showMessageDialog(null, "Coba lagi");
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
        frame = new DefaultComponentSetting().defaultFrame();
        frame.add(panelRegisterKurir);
    }
}
