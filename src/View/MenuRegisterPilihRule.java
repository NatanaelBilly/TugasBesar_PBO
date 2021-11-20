package View;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MenuRegisterPilihRule {
    private JFrame frame;
    private JPanel registerPilihRule;
    private JLabel pilihRule, labelKembali;
    private JButton registerKurir, registerPelanggan;
    private DefaultComponentSetting GUI = new DefaultComponentSetting();

    public MenuRegisterPilihRule() {
        //Link Kembali
        labelKembali = GUI.defaultBackLabel();
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
        pilihRule = GUI.defaultHeadingLabel("Pilih Role Kamu.");
        pilihRule.setBounds(0, 200, 600, 30);

        //Button Kurir
        registerKurir = GUI.defaultButton("Kurir", 18);
        registerKurir.setBounds(60, 300, 480, 60);
        registerKurir.addActionListener(e -> {
            frame.dispose();
            new MenuRegisterKurir();
        });

        //Button Pelanggan
        registerPelanggan = GUI.defaultButton("Pelanggan", 18);
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
        registerPilihRule.setBackground(GUI.backGroundColor());
        registerPilihRule.add(labelKembali);
        registerPilihRule.add(pilihRule);
        registerPilihRule.add(registerKurir);
        registerPilihRule.add(registerPelanggan);

        //Frame
        frame = GUI.defaultFrame();
        frame.add(registerPilihRule);
    }
}
