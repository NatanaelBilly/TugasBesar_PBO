package View;

import Model.Constant;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPilihRule {
    JFrame frame;
    JPanel registerPilihRule;
    JLabel pilihRule;
    JButton registerKurir, registerPelanggan;

    public RegisterPilihRule(){
        //Panel
        registerPilihRule = new JPanel();
        registerPilihRule.setSize(600,800);
        registerPilihRule.setLayout(null);

        //Label
        pilihRule = new JLabel("Sebagai apa anda mendaftar?", SwingConstants.CENTER);
        pilihRule.setBounds(0,130,600,30);
        registerPilihRule.add(pilihRule);

        //Button Kurir
        registerKurir = new JButton("Kurir");
        registerKurir.setBounds(60, 190, 480, 40);
        registerKurir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new RegisterKurir();
            }
        });
        registerPilihRule.add(registerKurir);

        //Button Pelanggan
        registerPelanggan = new JButton("Pelanggan");
        registerPelanggan.setBounds(60,270,480,40);
        registerPelanggan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new RegisterPelanggan();
            }
        });

        registerPilihRule.add(registerPelanggan);

        //Frame
        frame = new JFrame(Constant.applicationName);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,800);
        frame.setVisible(true);
        frame.add(registerPilihRule);
    }
}
