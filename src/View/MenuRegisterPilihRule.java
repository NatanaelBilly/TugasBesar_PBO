package View;

import javax.swing.*;

public class MenuRegisterPilihRule {
    JFrame frame;
    JPanel registerPilihRule;
    JLabel pilihRule;
    JButton registerKurir, registerPelanggan;

    public MenuRegisterPilihRule(){
        //Panel
        registerPilihRule = new JPanel();
        registerPilihRule.setSize(600,800);
        registerPilihRule.setLayout(null);

        //Label
        pilihRule = new JLabel("Sebagai apa anda mendaftar?", SwingConstants.CENTER);
        pilihRule.setBounds(0,130,600,30);
        registerPilihRule.add(pilihRule);

        //Button Kurir
        registerKurir = new DefaultComponentSetting().defaultButton("Kurir",18);
        registerKurir.setBounds(60, 190, 480, 40);
        registerKurir.addActionListener(e -> {
            frame.dispose();
            new MenuRegisterKurir();
        });
        registerPilihRule.add(registerKurir);

        //Button Pelanggan
        registerPelanggan = new DefaultComponentSetting().defaultButton("Pelanggan",18);
        registerPelanggan.setBounds(60,270,480,40);
        registerPelanggan.addActionListener(e -> {
            frame.dispose();
            new MenuRegisterPelanggan();
        });

        registerPilihRule.add(registerPelanggan);

        //Frame
        frame = new DefaultComponentSetting().defaultFrame();
        frame.add(registerPilihRule);
    }
}
