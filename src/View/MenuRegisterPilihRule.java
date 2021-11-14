package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MenuRegisterPilihRule {
    JFrame frame;
    JPanel registerPilihRule;
    JLabel pilihRule, labelKembali;
    JButton registerKurir, registerPelanggan;

    public MenuRegisterPilihRule() {
        //Link Kembali
        labelKembali = new DefaultComponentSetting().defaultBackLabel();
        labelKembali.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                new HalamanAwal();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                frame.dispose();
                new HalamanAwal();
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

        //Label
        pilihRule = new DefaultComponentSetting().defaultHeadingLabel("Pilih Role Kamu.");
        pilihRule.setBounds(0, 200, 600, 30);

        //Button Kurir
        registerKurir = new DefaultComponentSetting().defaultButton("Kurir", 18);
        registerKurir.setBounds(60, 300, 480, 60);
        registerKurir.addActionListener(e -> {
            frame.dispose();
            new MenuRegisterKurir();
        });

        //Button Pelanggan
        registerPelanggan = new DefaultComponentSetting().defaultButton("Pelanggan", 18);
        registerPelanggan.setBounds(60, 400, 480, 60);
        registerPelanggan.addActionListener(e -> {
            frame.dispose();
            new MenuRegisterPelanggan();
        });

        //Panel
        registerPilihRule = new JPanel();
        registerPilihRule.setBounds(0, 0, 600, 800);
        registerPilihRule.setLayout(null);
        registerPilihRule.setVisible(true);
        registerPilihRule.setBackground(Color.white);
        registerPilihRule.add(labelKembali);
        registerPilihRule.add(pilihRule);
        registerPilihRule.add(registerKurir);
        registerPilihRule.add(registerPelanggan);

        //Frame
        frame = new DefaultComponentSetting().defaultFrame();
        frame.add(registerPilihRule);
    }
}
