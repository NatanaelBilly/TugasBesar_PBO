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

        labelKembali = new DefaultComponentSetting().defaultBackLabel();
        labelKembali.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                new MenuRegisterPilihRole();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                frame.dispose();
                new MenuRegisterPilihRole();
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

        labelJudul = GUI.defaultHeadingLabel("Register sebagai Kurir");
        labelJudul.setBounds(0, 70, 600, 30);


        labelNamaDepan = GUI.defaultRegularLabel("Nama Depan*");
        labelNamaDepan.setBounds(65, 150, 150, 30);

        inputNamaDepan = new JTextField();
        inputNamaDepan.setBounds(230, 150, 250, 30);

        labelNamaBelakang = GUI.defaultRegularLabel("Nama Belakang*");
        labelNamaBelakang.setBounds(65, 200, 150, 30);

        inputNamaBelakang = new JTextField();
        inputNamaBelakang.setBounds(230, 200, 250, 30);

        labelNIK = GUI.defaultRegularLabel("NIK*");
        labelNIK.setBounds(65, 250, 150, 30);

        inputNIK = new JTextField();
        inputNIK.setBounds(230, 250, 250, 30);

        labelPlatNomor = GUI.defaultRegularLabel("Plat Nomor*");
        labelPlatNomor.setBounds(65, 300, 150, 30);

        inputPlatnomor = new JTextField();
        inputPlatnomor.setBounds(230, 300, 250, 30);

        labelJenisKendaraan = GUI.defaultRegularLabel("Jenis Kendaraan*");
        labelJenisKendaraan.setBounds(65, 350, 150, 30);

        inputJenisKendaraan = new JTextField();
        inputJenisKendaraan.setBounds(230, 350, 250, 30);

        labelEmail = GUI.defaultRegularLabel("Email*");
        labelEmail.setBounds(65, 390, 150, 30);

        inputEmail = new JTextField();
        inputEmail.setBounds(230, 390, 250, 30);

        labelNomorHP = GUI.defaultRegularLabel("Nomor HP*");
        labelNomorHP.setBounds(65, 440, 150, 30);

        inputNomorHp = new JTextField();
        inputNomorHp.setBounds(230, 440, 250, 30);

        labelPassword = GUI.defaultRegularLabel("Password*");
        labelPassword.setBounds(65, 490, 150, 30);

        inputPassword = new JPasswordField();
        inputPassword.setBounds(230, 490, 250, 30);

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
            int ketersediaan = 0;
            String plat = inputPlatnomor.getText();
            String jenisKendaraan = inputJenisKendaraan.getText();

            if (namaDepan.isEmpty() || namaBelakang.isEmpty() || noHP.isEmpty() || emailUser.isEmpty() || password.isEmpty() || NIK.isEmpty() || plat.isEmpty() || jenisKendaraan.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Register Gagal.\n" + Constant.ERROR_MESSAGE);
            } else {
                if (Validation.cekEmail(emailUser)) {
                    if (Validation.cekNoHP(noHP)) {
                        if (password.length() > 8) {
                            Kurir kurirBaru = new Kurir(NIK, ketersediaan, plat, jenisKendaraan, idUser, namaDepan, namaBelakang, noHP, emailUser, password, saldo, Role.KURIR, null);
                            if (ck.RegisterKurir(kurirBaru)) {
                                JOptionPane.showMessageDialog(null, "Register Berhasil!");
                                frame.dispose();
                                new BerandaKurir(kurirBaru);
                            } else {
                                JOptionPane.showMessageDialog(null, "Coba lagi");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, Constant.WRONG_PASSWORD);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, Constant.WRONG_NUMBER);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, Constant.WRONG_EMAIL);
                }

            }

        });

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

        frame = GUI.defaultFrame();
        frame.add(panelRegisterKurir);
    }
}
