package View;

import Controller.Controller;
import Controller.KurirController;
import Model.Constant;
import Model.Kurir;
import Model.UserManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class MenuProfilKurir {
    private JFrame frame;
    private JLabel labelPassword, labelKembali, labelMenu, labelProfilePic, labelNama, labelEmail, labelNoHp, labelNIK, labelPlat, labelKendaraan, labelSaldo;
    private ImageIcon profilePic;
    private JTextField nama, nik, email, noHP, plat, kendaraan, saldo;
    private JPasswordField password;
    private JButton btnEditProfile, btnHapusAkun, btnSimpan;
    private final DefaultComponentSetting GUI = new DefaultComponentSetting();
    private Controller controller = new Controller();
    private KurirController ck = new KurirController();

    public MenuProfilKurir(Kurir kurir) {
        //Link Kembali
        labelKembali = GUI.defaultBackLabel();
        labelKembali.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new BerandaKurir(kurir);
                frame.dispose();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                new BerandaKurir(kurir);
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

        //Menu
        labelMenu = GUI.defaultHeadingLabel("Lihat Profil");
        labelMenu.setBounds(200, 40, 200, 40);

        //picture
        labelProfilePic = new JLabel();
        profilePic = new ImageIcon("assets/profile_pic.jpg");
        labelProfilePic.setIcon(profilePic);
        labelProfilePic.setBounds(225, 90, 150, 150);

        //Label Keterangan
        labelNama = GUI.defaultRegularLabel("Nama");
        labelNama.setBounds(100, 250, 200, 40);

        labelNIK = GUI.defaultRegularLabel("NIK");
        labelNIK.setBounds(100, 300, 200, 40);

        labelEmail = GUI.defaultRegularLabel("Email");
        labelEmail.setBounds(100, 350, 200, 40);

        labelNoHp = GUI.defaultRegularLabel("No Telepon");
        labelNoHp.setBounds(100, 400, 200, 40);

        labelPlat = GUI.defaultRegularLabel("Plat");
        labelPlat.setBounds(100, 450, 200, 40);

        labelKendaraan = GUI.defaultRegularLabel("Kendaraan");
        labelKendaraan.setBounds(100, 500, 200, 40);

        labelPassword = GUI.defaultRegularLabel("Password");
        labelPassword.setBounds(100, 550, 200, 40);

        labelSaldo = GUI.defaultRegularLabel("Saldo");
        labelSaldo.setBounds(100, 600, 200, 40);

        //Data
        nama = new JTextField(kurir.getNamaDepan() + " " + kurir.getNamaBelakang());
        nama.setBounds(210, 250, 315, 40);
        nama.setEditable(false);

        nik = new JTextField(kurir.getNIK());
        nik.setBounds(210, 300, 315, 40);
        nik.setEditable(false);

        email = new JTextField(kurir.getEmailUser());
        email.setBounds(210, 350, 315, 40);
        email.setEditable(false);

        noHP = new JTextField(kurir.getNoHp());
        noHP.setBounds(210, 400, 315, 40);
        noHP.setEditable(false);

        plat = new JTextField(kurir.getPlat());
        plat.setBounds(210, 450, 315, 40);
        plat.setEditable(false);

        kendaraan = new JTextField(kurir.getJenisKendaraan());
        kendaraan.setBounds(210, 500, 315, 40);
        kendaraan.setEditable(false);

        password = new JPasswordField(kurir.getPassword());
        password.setBounds(210, 550, 315, 40);
        password.setEditable(false);

        saldo = new JTextField(String.valueOf(kurir.getSaldo()));
        saldo.setBounds(210, 600, 315, 40);
        saldo.setEditable(false);

        //Button Hapus Akun
        btnHapusAkun = GUI.defaultButton("Hapus Akun", 18);
        btnHapusAkun.setBounds(100, 650, 140, 40);
        btnHapusAkun.setVisible(false);
        btnHapusAkun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int yakinHapus = JOptionPane.showConfirmDialog(null, Constant.CONFIRM_DELETE_ACCOUNT);
                if (yakinHapus == JOptionPane.YES_OPTION) {
                    if (controller.hapusAkun(kurir.getIdUser())) {
                        JOptionPane.showMessageDialog(null, "Akun kamu terhapus.");
                        new UserManager().logOut();
                        frame.dispose();
                        new HalamanAwal();
                    } else {
                        JOptionPane.showMessageDialog(null, "Gagal Hapus Akun");
                    }
                }
            }
        });

        //Button Simpan
        btnSimpan = GUI.defaultButton("Simpan", 18);
        btnSimpan.setBounds(390, 650, 140, 40);
        btnSimpan.setVisible(false);
        btnSimpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nama.getText().isEmpty() || nik.getText().isEmpty() || email.getText().isEmpty() || noHP.getText().isEmpty() || plat.getText().isEmpty() || kendaraan.getText().isEmpty() || String.valueOf(password.getPassword()).isEmpty()) {
                    JOptionPane.showMessageDialog(null, Constant.ERROR_MESSAGE);
                } else {
                    String[] splitted = nama.getText().split("\\s+");
                    String namaDepan = splitted[0];
                    String namaBelakang = "";
                    if (splitted.length != 1) {
                        for (int i = 1; i < splitted.length; i++) {
                            namaBelakang += splitted[i] + " ";
                        }
                    }
                    kurir.setNamaDepan(namaDepan);
                    kurir.setNamaBelakang(namaBelakang);
                    kurir.setNIK(nik.getText());
                    kurir.setEmailUser(email.getText());
                    kurir.setNoHp(noHP.getText());
                    kurir.setPlat(plat.getText());
                    kurir.setJenisKendaraan(kendaraan.getText());
                    kurir.setPassword(String.valueOf(password.getPassword()));

                    boolean teredit = ck.EditDataKurirToDB(kurir);
                    if (teredit) {
                        JOptionPane.showMessageDialog(null, "Data kamu terubah.");
                        frame.dispose();
                        new MenuProfilKurir(kurir);
                    } else {
                        JOptionPane.showMessageDialog(null, "Gagal mengedit profil");
                    }
                }
            }
        });


        //Button Edit
        btnEditProfile = GUI.defaultButton("Edit Profil", 18);
        btnEditProfile.setBounds(390, 650, 140, 40);
        btnEditProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nama.setEditable(true);
                nik.setEditable(true);
                email.setEditable(true);
                noHP.setEditable(true);
                plat.setEditable(true);
                kendaraan.setEditable(true);
                password.setEditable(true);
                btnEditProfile.setVisible(false);
                btnHapusAkun.setVisible(true);
                btnSimpan.setVisible(true);
            }
        });

        //Frame
        frame = GUI.defaultFrame();
        frame.getContentPane().setBackground(GUI.backGroundColor());
        frame.add(labelMenu);
        frame.add(labelProfilePic);
        frame.add(labelNama);
        frame.add(labelEmail);
        frame.add(labelNoHp);
        frame.add(labelNIK);
        frame.add(labelPlat);
        frame.add(labelKendaraan);
        frame.add(labelPassword);
        frame.add(labelSaldo);
        frame.add(nama);
        frame.add(email);
        frame.add(noHP);
        frame.add(plat);
        frame.add(kendaraan);
        frame.add(nik);
        frame.add(saldo);
        frame.add(password);
        frame.add(btnEditProfile);
        frame.add(labelKembali);
        frame.add(btnEditProfile);
        frame.add(btnHapusAkun);
        frame.add(btnSimpan);
    }

}
