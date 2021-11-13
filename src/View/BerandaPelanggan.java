package View;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BerandaPelanggan {
    JFrame frame;
    JPanel panelMessage;
    JLabel labelMessage;
    JButton btnProfile, btnOrder, btnTransaction;

    public BerandaPelanggan() {
        //label
        labelMessage = new JLabel("Welcome Back, Ini Nama!");
        labelMessage.setFont(new Font("Arial", Font.BOLD, 24));

        //Button
        btnProfile = new DefaultComponentSetting().defaultButton("Lihat Profil",20);
        btnProfile.setBounds(170, 210, 250, 80);
        btnProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new MenuProfilePelanggan();
            }
        });
        btnOrder = new JButton("Buat Order");
        btnOrder.setBounds(170, 340, 250, 80);
        btnOrder.setFont(new Font("Arial", Font.BOLD, 20));
        btnOrder.setBackground(new Color(217, 217, 217));
        btnOrder.setBorder(new BevelBorder(1, Color.BLACK, Color.BLACK));
        btnOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new MenuBuatOrder();
            }
        });


        btnTransaction = new JButton("Lihat Transaksi");
        btnTransaction.setBounds(170, 470, 250, 80);
        btnTransaction.setFont(new Font("Arial", Font.BOLD, 20));
        btnTransaction.setBackground(new Color(217, 217, 217));
        btnTransaction.setBorder(new BevelBorder(1, Color.BLACK, Color.BLACK));
        btnTransaction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuLihatDaftarTransaksiPelanggan();
            }
        });

        //Panel
        panelMessage = new JPanel();
        panelMessage.setBounds(0, 120, 600, 50);

        //Frame
        frame = new DefaultComponentSetting().defaultFrame();

        panelMessage.add(labelMessage);
        frame.add(btnProfile);
        frame.add(btnOrder);
        frame.add(btnTransaction);
        frame.add(panelMessage);

        panelMessage.setVisible(true);

    }
}
