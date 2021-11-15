package View;

import Model.Pelanggan;
import Model.UserManager;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BerandaPelanggan {
    JFrame frame;
    JPanel panelMessage;
    JLabel labelMessage;
    JButton btnProfile, btnOrder, btnTransaction, btnIsiSaldo;

    public BerandaPelanggan(Pelanggan pelanggan) {
        //label
        labelMessage = new DefaultComponentSetting().defaultHeadingLabel("Welcome Back");
//        labelMessage.setFont(new Font("Arial", Font.BOLD, 24));

        //Button
        btnProfile = new DefaultComponentSetting().defaultButton("Lihat Profil",20);
        btnProfile.setBounds(170, 210, 250, 80);
        btnProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new MenuProfilePelanggan(pelanggan);
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

        btnIsiSaldo = new JButton("Isi Saldo");
        btnIsiSaldo.setBounds(170, 600, 250, 80);
        btnIsiSaldo.setFont(new Font("Arial", Font.BOLD, 20));
        btnIsiSaldo.setBackground(new Color(217, 217, 217));
        btnIsiSaldo.setBorder(new BevelBorder(1, Color.BLACK, Color.BLACK));
        btnIsiSaldo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuIsiSaldo(pelanggan);
            }
        });

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
        frame.add(btnIsiSaldo);
        frame.add(panelMessage);



    }
}