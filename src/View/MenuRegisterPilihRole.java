package View;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MenuRegisterPilihRole {
    private JFrame frame;
    private JPanel registerPilihRule;
    private JLabel pilihRule, labelKembali;
    private JButton registerKurir, registerPelanggan;
    private DefaultComponentSetting GUI = new DefaultComponentSetting();

    public MenuRegisterPilihRole() {
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

        pilihRule = GUI.defaultHeadingLabel("Pilih Role Kamu.");
        pilihRule.setBounds(0, 200, 600, 30);

        registerKurir = GUI.defaultButton("Kurir", 18);
        registerKurir.setBounds(60, 300, 480, 60);
        registerKurir.addActionListener(e -> {
            frame.dispose();
            new MenuRegisterKurir();
        });

        registerPelanggan = GUI.defaultButton("Pelanggan", 18);
        registerPelanggan.setBounds(60, 400, 480, 60);
        registerPelanggan.addActionListener(e -> {
            frame.dispose();
            new MenuRegisterPelanggan();
        });

        registerPilihRule = new JPanel();
        registerPilihRule.setBounds(0, 0, 600, 800);
        registerPilihRule.setLayout(null);
        registerPilihRule.setVisible(true);
        registerPilihRule.setBackground(GUI.backGroundColor());
        registerPilihRule.add(labelKembali);
        registerPilihRule.add(pilihRule);
        registerPilihRule.add(registerKurir);
        registerPilihRule.add(registerPelanggan);

        frame = GUI.defaultFrame();
        frame.add(registerPilihRule);
    }
}
