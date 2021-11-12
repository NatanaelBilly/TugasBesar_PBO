package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditProfilePelanggan {
    JFrame frame;
    JLabel labelNamaDepan, labelNamaBelakang, labelEmail;
    JTextField tfNamaDepan, tfNamaBelakang, tfEmail;
    JButton btnEdit;

    public EditProfilePelanggan(){
        //Frame
        frame = new DefaultComponentSetting().defaultFrame();

        //Label
        labelNamaDepan = new JLabel("Nama Depan");
        labelNamaDepan.setBounds(30,30,150,40);
        labelNamaBelakang = new JLabel("Nama Belakang");
        labelNamaBelakang.setBounds(30,80,150,40);
        labelEmail = new JLabel("Email");
        labelEmail.setBounds(30,130,150,40);

        //Text Field
        tfNamaDepan = new JTextField("NamaDepan");
        tfNamaDepan.setBounds(200,30,190,30);
        tfNamaBelakang = new JTextField("NamaBelakang");
        tfNamaBelakang.setBounds(200,80,190,30);
        tfEmail = new JTextField("iniemail@mail.com");
        tfEmail.setBounds(200,130,190,30);

        //Button
        btnEdit = new JButton("Edit");
        btnEdit.setBounds(170, 190, 100,40);
        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //change database
                frame.dispose();
                new ProfilePelanggan();
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
