package View;

import Controller.*;
import Model.*;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MenuRegisterKurir {
    private JFrame frame;
    private JPanel panelRegisterKurir;
    private JLabel labelKembali, labelJudul, labelNamaDepan, labelNamaBelakang, labelNIK, labelPlatNomor, labelJenisKendaraan, labelEmail, labelNomorHP, labelPassword;
    private JTextField inputNamaDepan, inputNamaBelakang, inputNIK, inputPlatnomor, inputJenisKendaraan, inputEmail, inputNomorHp;
    private JPasswordField inputPassword;
    private JButton buttonRegister;
    private DefaultComponentSetting GUI = new DefaultComponentSetting();

    public MenuRegisterKurir() {
        //Label Kembali
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
                new MenuRegisterPilihRule();
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
        labelJudul = GUI.defaultHeadingLabel("Register sebagai Kurir");
        labelJudul.setBounds(0, 70, 600, 30);

        //Label Nama Depan
        labelNamaDepan = GUI.defaultRegularLabel("Nama Depan*");
        labelNamaDepan.setBounds(65, 150, 150, 30);

        //Input Nama Depan
        inputNamaDepan = new JTextField();
        inputNamaDepan.setBounds(230, 150, 250, 30);

        //Label Nama Belakang
        labelNamaBelakang = GUI.defaultRegularLabel("Nama Belakang*");
        labelNamaBelakang.setBounds(65, 200, 150, 30);

        //Input Nama Belakang
        inputNamaBelakang = new JTextField();
        inputNamaBelakang.setBounds(230, 200, 250, 30);

        //Label NIK
        labelNIK = GUI.defaultRegularLabel("NIK*");
        labelNIK.setBounds(65, 250, 150, 30);

        //Input NIK
        inputNIK = new JTextField();
        inputNIK.setBounds(230, 250, 250, 30);

        //Label Plat Nomor
        labelPlatNomor = GUI.defaultRegularLabel("Plat Nomor*");
        labelPlatNomor.setBounds(65, 300, 150, 30);

        //Input Plat Nomor
        inputPlatnomor = new JTextField();
        inputPlatnomor.setBounds(230, 300, 250, 30);

        //Label Jenis Kendaraan
        labelJenisKendaraan = GUI.defaultRegularLabel("Jenis Kendaraan*");
        labelJenisKendaraan.setBounds(65, 350, 150, 30);

        //Input Jenis Kendaraan
        inputJenisKendaraan = new JTextField();
        inputJenisKendaraan.setBounds(230, 350, 250, 30);

        //Label Email
        labelEmail = GUI.defaultRegularLabel("Email*");
        labelEmail.setBounds(65, 390, 150, 30);

        //Input Email
        inputEmail = new JTextField();
        inputEmail.setBounds(230, 390, 250, 30);

        //Label Nomor HP
        labelNomorHP = GUI.defaultRegularLabel("Nomor HP*");
        labelNomorHP.setBounds(65, 440, 150, 30);

        //Input Nomor HP
        inputNomorHp = new JTextField();
        inputNomorHp.setBounds(230, 440, 250, 30);

        //Label Password
        labelPassword = GUI.defaultRegularLabel("Password*");
        labelPassword.setBounds(65, 490, 150, 30);

        //Input Password
        inputPassword = new JPasswordField();
        inputPassword.setBounds(230, 490, 250, 30);

        //button Register
        buttonRegister = GUI.defaultButton("Register", 16);
        buttonRegister.setBounds(380, 560, 100, 40);
        buttonRegister.addActionListener(e -> {
            Controller controller = new Controller();
            KurirController ck = new KurirController();
            String namaDepan = inputNamaDepan.getText();
            String namaBelakang = inputNamaBelakang.getText();
            String noHP = inputNomorHp.getText();
            String emailUser = inputEmail.getText();
            String password = String.valueOf(inputPassword.getPassword());
            double saldo = 0;
            String NIK = inputNIK.getText();
            int jumlahUserSekarang = controller.HitungJumlahUser();
            int idUser = jumlahUserSekarang + 1;
//            double totalPendapatan = 0;
            int ketersediaan = 0;
            String plat = inputPlatnomor.getText();
            String jenisKendaraan = inputJenisKendaraan.getText();

            if (namaDepan.isEmpty() || namaBelakang.isEmpty() || noHP.isEmpty() || emailUser.isEmpty() || password.isEmpty() || NIK.isEmpty() || plat.isEmpty() || jenisKendaraan.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Register Gagal.\n" + Constant.ERROR_MESSAGE);
            } else {
                Kurir kurirBaru = new Kurir(NIK, ketersediaan, plat, jenisKendaraan, idUser, namaDepan, namaBelakang, noHP, emailUser, password, saldo, Role.KURIR, null);
                if (ck.RegisterKurir(kurirBaru)) {
                    JOptionPane.showMessageDialog(null, "Register Berhasil!");
                    frame.dispose();
                    new BerandaKurir(kurirBaru);
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
        panelRegisterKurir.setBackground(GUI.backGroundColor());
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
        panelRegisterKurir.add(labelKembali);

        //Frame
        frame = GUI.defaultFrame();
        frame.add(panelRegisterKurir);
    }
}
