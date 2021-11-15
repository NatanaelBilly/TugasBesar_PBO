package View;

import Model.Pelanggan;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuEditProfilePelanggan {
    JFrame frame;
    JLabel labelNamaDepan, labelNamaBelakang, labelEmail;
    JTextField tfNamaDepan, tfNamaBelakang, tfEmail;
    JButton btnEdit;

    public MenuEditProfilePelanggan(Pelanggan pelanggan){
        //Frame
        frame = new DefaultComponentSetting().defaultFrame();
        System.out.println(pelanggan.toString());
        //Label
        labelNamaDepan = new JLabel("Nama Depan");
        labelNamaDepan.setBounds(30,30,150,40);
        labelNamaBelakang = new JLabel("Nama Belakang");
        labelNamaBelakang.setBounds(30,80,150,40);
        labelEmail = new JLabel("Email");
        labelEmail.setBounds(30,130,150,40);

        //Text Field
        tfNamaDepan = new JTextField(pelanggan.getNama_depan());
        tfNamaDepan.setBounds(200,30,190,30);
        tfNamaBelakang = new JTextField(pelanggan.getNama_belakang());
        tfNamaBelakang.setBounds(200,80,190,30);
        tfEmail = new JTextField(pelanggan.getNama_belakang());
        tfEmail.setBounds(200,130,190,30);

        //Button
        btnEdit = new JButton("Edit");
        btnEdit.setBounds(170, 190, 100,40);
        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //change database
                frame.dispose();
                new MenuProfilePelanggan(pelanggan);
            }
        });


        frame.add(labelNamaDepan);
        frame.add(labelNamaBelakang);
        frame.add(labelEmail);
        frame.add(tfNamaDepan);
        frame.add(tfNamaBelakang);
        frame.add(tfEmail);
        frame.add(btnEdit);

    }
}
