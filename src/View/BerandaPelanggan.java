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
        //Label
        labelMessage = new DefaultComponentSetting().defaultHeadingLabel("Welcome Back");

        //Button
        btnProfile = new DefaultComponentSetting().defaultButton("Lihat Profil", 20);
        btnProfile.setBounds(170, 210, 250, 80);
<<<<<<< HEAD
        btnProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new MenuProfilePelanggan(pelanggan);
            }
=======
        btnProfile.addActionListener(e -> {
            frame.dispose();
            new MenuProfilePelanggan();
>>>>>>> 303d598c8a747878071b0e87529325ebdda1065d
        });

        btnOrder = new DefaultComponentSetting().defaultButton("Buat Order", 20);
        btnOrder.setBounds(170, 340, 250, 80);
        btnOrder.addActionListener(e -> {
            frame.dispose();
            new MenuBuatOrder();
        });

<<<<<<< HEAD
        
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
=======
        btnTransaction = new DefaultComponentSetting().defaultButton("Lihat Transaksi", 20);
        btnTransaction.setBounds(170, 470, 250, 80);
        btnTransaction.addActionListener(e -> new MenuLihatDaftarTransaksiPelanggan());
>>>>>>> 303d598c8a747878071b0e87529325ebdda1065d

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
