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
    JFrame frame;
    JLabel labelHeading, labelNamaDepan, labelNamaBelakang, labelEmail, labelNoHp, labelBack;
    JTextField tfNamaDepan, tfNamaBelakang, tfEmail, tfNoHp;
    JButton btnEdit;

    public MenuEditProfilePelanggan(Pelanggan pelanggan){
        //Frame
        frame = new DefaultComponentSetting().defaultFrame();
        System.out.println(pelanggan.toString());
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

        //Text Field
        tfNamaDepan = new JTextField(pelanggan.getNama_depan());
        tfNamaDepan.setBounds(200,150,350,40);
        tfNamaBelakang = new JTextField(pelanggan.getNama_belakang());
        tfNamaBelakang.setBounds(200,210,350,40);
        tfEmail = new JTextField(pelanggan.getEmail_user());
        tfEmail.setBounds(200,270,350,40);
        tfNoHp = new JTextField(pelanggan.getNoHp());
        tfNoHp.setBounds(200,330,350,40);

        //Button
        btnEdit = new DefaultComponentSetting().defaultButton("Edit",14);
        btnEdit.setBounds(250, 420, 100,40);
        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //change database
                Controller c = new Controller();
                boolean updateDataPelanggan = c.updateDataPelanggan(tfNamaDepan.getText(), tfNamaBelakang.getText(), tfEmail.getText(), tfNoHp.getText(), pelanggan.getId_user());
                if(updateDataPelanggan){
                    User user = new UserManager().getInstance().getUser();
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
            }
        });

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
    }
}
