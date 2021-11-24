package View;

import Model.*;
import Controller.*;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MenuRegisterPelanggan {
    private JFrame frame;
    private JPanel panelRegisterPelanggan;
    private JLabel labelKembali, labelJudul, labelNamaDepan, labelNamaBelakang, labelEmail, labelNomorHP, labelPassword;
    private JTextField inputNamaDepan, inputNamaBelakang, inputEmail, inputNomorHP;
    private JPasswordField inputPassword;
    private JButton buttonRegister;
    private DefaultComponentSetting GUI = new DefaultComponentSetting();

    public MenuRegisterPelanggan() {
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

        labelJudul = GUI.defaultHeadingLabel("Anda akan register sebagai pelanggan");
        labelJudul.setBounds(0, 100, 600, 30);

        labelNamaDepan = GUI.defaultRegularLabel("Nama Depan");
        labelNamaDepan.setBounds(65, 210, 150, 30);

        inputNamaDepan = new JTextField();
        inputNamaDepan.setBounds(230, 210, 250, 30);

        labelNamaBelakang = GUI.defaultRegularLabel("Nama Belakang");
        labelNamaBelakang.setBounds(65, 260, 150, 30);

        inputNamaBelakang = new JTextField();
        inputNamaBelakang.setBounds(230, 260, 250, 30);

        labelEmail = GUI.defaultRegularLabel("Email");
        labelEmail.setBounds(65, 310, 150, 30);

        inputEmail = new JTextField();
        inputEmail.setBounds(230, 310, 250, 30);

        labelNomorHP = GUI.defaultRegularLabel("Nomor HP");
        labelNomorHP.setBounds(65, 360, 150, 30);

        inputNomorHP = new JTextField();
        inputNomorHP.setBounds(230, 360, 250, 30);

        labelPassword = GUI.defaultRegularLabel("Password");
        labelPassword.setBounds(65, 410, 150, 30);

        inputPassword = new JPasswordField();
        inputPassword.setBounds(230, 410, 250, 30);

        buttonRegister = GUI.defaultButton("Register", 16);
        buttonRegister.setBounds(380, 500, 100, 40);
        buttonRegister.addActionListener(e -> {

            if (inputNomorHP.getText().isEmpty() || inputNamaDepan.getText().isEmpty() || inputNamaBelakang.getText().isEmpty() || inputEmail.getText().isEmpty() || String.valueOf(inputPassword).isEmpty()) {
                JOptionPane.showMessageDialog(null, Constant.ERROR_MESSAGE);
            } else {
                if (Validation.cekEmail(inputEmail.getText())) {
                    if (Validation.cekNoHP(inputNomorHP.getText())) {
                        if (String.valueOf(inputPassword.getPassword()).length() > 8) {
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

        panelRegisterPelanggan = new JPanel();
        panelRegisterPelanggan.setSize(600, 800);
        panelRegisterPelanggan.setVisible(true);
        panelRegisterPelanggan.setLayout(null);
        panelRegisterPelanggan.setBackground(GUI.backGroundColor());
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
        frame = new DefaultComponentSetting().defaultFrame();
        frame.add(panelRegisterPelanggan);
    }

}
