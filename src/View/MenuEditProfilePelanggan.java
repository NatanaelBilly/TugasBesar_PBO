package View;

import Controller.Controller;
import Model.Pelanggan;
import Model.User;
import Model.UserManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuEditProfilePelanggan {
    JFrame frame, frameEditPass;
    JLabel labelHeading, labelNamaDepan, labelNamaBelakang, labelEmail, labelNoHp, labelBack;
    JLabel labelPass, labelPassBaru, labelKonfirmasiPass;
    JTextField tfNamaDepan, tfNamaBelakang, tfEmail, tfNoHp;
    JPasswordField tfPass, tfPassBaru, tfKonformasiPass;
    JButton btnEdit, btnUbahPass, btnKonfirmasiUbahPass;

    public MenuEditProfilePelanggan(Pelanggan pelanggan){
        System.out.println(pelanggan);
        //Frame
        frame = new DefaultComponentSetting().defaultFrame();
        System.out.println(pelanggan.toString());

        //Frame Edit Pass
        frameEditPass = new JFrame("Edit Pass");
        frameEditPass.setSize(600,350);
        frameEditPass.setVisible(false);
        frameEditPass.setLocationRelativeTo(null);
        frameEditPass.setLayout(null);

        //Label
        labelHeading = new DefaultComponentSetting().defaultHeadingLabel("Edit Profil");
        labelHeading.setBounds(220,80,150,40);
        labelBack = new DefaultComponentSetting().defaultBackLabel();
        labelBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                new MenuProfilePelanggan(pelanggan);
            }
        });
        labelNamaDepan = new DefaultComponentSetting().defaultRegularLabel("Nama Depan");
        labelNamaDepan.setBounds(30,150,150,40);
        labelNamaBelakang = new DefaultComponentSetting().defaultRegularLabel("Nama Belakang");
        labelNamaBelakang.setBounds(30,210,150,40);
        labelEmail = new DefaultComponentSetting().defaultRegularLabel("Email");
        labelEmail.setBounds(30,270,150,40);
        labelNoHp = new DefaultComponentSetting().defaultRegularLabel("Nomor HP");
        labelNoHp.setBounds(30,330,150,40);
        labelPass = new DefaultComponentSetting().defaultRegularLabel("Password");
        labelPass.setBounds(30,30,200,40);
        labelPassBaru = new DefaultComponentSetting().defaultRegularLabel("Password Baru");
        labelPassBaru.setBounds(30,80,200,40);
        labelKonfirmasiPass = new DefaultComponentSetting().defaultRegularLabel("Konfirmasi Password Baru");
        labelKonfirmasiPass.setBounds(30,130,200,40);

        //Text Field
        tfNamaDepan = new JTextField(pelanggan.getNama_depan());
        tfNamaDepan.setBounds(200,150,350,40);
        tfNamaBelakang = new JTextField(pelanggan.getNama_belakang());
        tfNamaBelakang.setBounds(200,210,350,40);
        tfEmail = new JTextField(pelanggan.getEmail_user());
        tfEmail.setBounds(200,270,350,40);
        tfNoHp = new JTextField(pelanggan.getNoHp());
        tfNoHp.setBounds(200,330,350,40);
        tfPass = new JPasswordField();
        tfPass.setBounds(250,30,310,40);
        tfPassBaru = new JPasswordField();
        tfPassBaru.setBounds(250,80,310,40);
        tfKonformasiPass = new JPasswordField();
        tfKonformasiPass.setBounds(250,130,310,40);

        //Button
        btnKonfirmasiUbahPass = new DefaultComponentSetting().defaultButton("Ubah Password",14);
        btnKonfirmasiUbahPass.setBounds(220, 200, 150,40);
        btnKonfirmasiUbahPass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pass = String.valueOf(tfPass.getPassword());
                String passBaru = String.valueOf(tfPassBaru.getPassword());
                String konfirmasiPass = String.valueOf(tfKonformasiPass.getPassword());
                User user = new UserManager().getInstance().getUser();
                if(user.getPassword().equals(pass)){
                    if(passBaru.equals(konfirmasiPass)){
                        Controller c = new Controller();
                        boolean ubahPassword = c.ubahPassword(passBaru, user.getId_user());
                        if(ubahPassword){
                            user.setPassword(passBaru);
                            JOptionPane.showMessageDialog(null, "Password berhasil diubah.");
                            frameEditPass.dispose();
                        } else {
                            JOptionPane.showMessageDialog(null, "Gagal mengubah password.");
                        }
                    }else {
                        JOptionPane.showMessageDialog(null, "Password baru yang dimasukkan tidak sama");
                    }
                }else {
                    JOptionPane.showMessageDialog(null, "Password yang dimasukkan salah");
                }
            }
        });
        btnEdit = new DefaultComponentSetting().defaultButton("Edit Profil",14);
        btnEdit.setBounds(120, 420, 150,40);
        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller c = new Controller();
                User user = new UserManager().getInstance().getUser();
                if(user.getEmail_user().equals(tfEmail.getText()) || !user.getEmail_user().equals(tfEmail.getText()) && !c.cekUserDiDataBase(tfEmail.getText())){
                    boolean updateDataPelanggan = c.updateDataPelanggan(tfNamaDepan.getText(), tfNamaBelakang.getText(), tfEmail.getText(), tfNoHp.getText(), pelanggan.getId_user());
                    if(updateDataPelanggan){
                        user.setNama_depan(tfNamaDepan.getText());
                        user.setNama_belakang(tfNamaBelakang.getText());
                        user.setEmail_user(tfEmail.getText());
                        user.setNoHp(tfNoHp.getText());
                        JOptionPane.showMessageDialog(null, "Data profil kamu berhasil diupdate.");
                        frame.dispose();
                        new MenuProfilePelanggan(pelanggan);
                    } else {
                        JOptionPane.showMessageDialog(null, "Gagal mengupdate profil.");
                    }
                }else {
                    JOptionPane.showMessageDialog(null, "Email telah digunakan");
                }
            }
        });
        btnUbahPass = new DefaultComponentSetting().defaultButton("Ganti Password",14);
        btnUbahPass.setBounds(320, 420, 150,40);
        btnUbahPass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameEditPass.setVisible(true);
            }
        });

        frameEditPass.add(labelPass);
        frameEditPass.add(labelPassBaru);
        frameEditPass.add(labelKonfirmasiPass);
        frameEditPass.add(tfPass);
        frameEditPass.add(tfPassBaru);
        frameEditPass.add(tfKonformasiPass);
        frameEditPass.add(btnKonfirmasiUbahPass);
        frame.add(labelHeading);
        frame.add(labelBack);
        frame.add(labelNamaDepan);
        frame.add(labelNamaBelakang);
        frame.add(labelEmail);
        frame.add(labelNoHp);
        frame.add(tfNamaDepan);
        frame.add(tfNamaBelakang);
        frame.add(tfEmail);
        frame.add(tfNoHp);
        frame.add(btnEdit);
        frame.add(btnUbahPass);
    }
}
