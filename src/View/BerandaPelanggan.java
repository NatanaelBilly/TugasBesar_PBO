package View;

import Model.Pelanggan;

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

    public BerandaPelanggan(Pelanggan pelanggan) {
        //Label
        labelMessage = new DefaultComponentSetting().defaultHeadingLabel("Welcome Back");

        //Button
        btnProfile = new DefaultComponentSetting().defaultButton("Lihat Profil", 20);
        btnProfile.setBounds(170, 210, 250, 80);
        btnProfile.addActionListener(e -> {
            frame.dispose();
            new MenuProfilePelanggan();
        });

        btnOrder = new DefaultComponentSetting().defaultButton("Buat Order", 20);
        btnOrder.setBounds(170, 340, 250, 80);
        btnOrder.addActionListener(e -> {
            frame.dispose();
            new MenuBuatOrder();
        });

        btnTransaction = new DefaultComponentSetting().defaultButton("Lihat Transaksi", 20);
        btnTransaction.setBounds(170, 470, 250, 80);
        btnTransaction.addActionListener(e -> new MenuLihatDaftarTransaksiPelanggan());

        //Panel
        panelMessage = new JPanel();
        panelMessage.setBounds(0, 120, 600, 50);
        panelMessage.setVisible(true);
        panelMessage.add(labelMessage);

        //Frame
        frame = new DefaultComponentSetting().defaultFrame();
        frame.add(btnProfile);
        frame.add(btnOrder);
        frame.add(btnTransaction);
        frame.add(panelMessage);


    }
}
