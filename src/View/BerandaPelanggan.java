package View;

import Model.Pelanggan;
import Model.UserManager;

import javax.swing.*;

public class BerandaPelanggan {
    JFrame frame;
    JPanel panelMessage;
    JLabel labelMessage;
    JButton btnProfile, btnOrder, btnTransaction, btnIsiSaldo, btnFeedback, btnLogout;
    DefaultComponentSetting GUI = new DefaultComponentSetting();

    public BerandaPelanggan(Pelanggan pelanggan) {
        //Label
        labelMessage = GUI.defaultHeadingLabel("Hallo, " + pelanggan.getNamaDepan() + "!");

        //Button Profile
        btnProfile = GUI.defaultButton("Lihat Profil", 20);
        btnProfile.setBounds(170, 120, 250, 80);
        btnProfile.addActionListener(e -> {
            frame.dispose();
            new MenuProfilePelanggan(pelanggan);
        });

        //Button Order
        btnOrder = GUI.defaultButton("Buat Order", 20);
        btnOrder.setBounds(170, 220, 250, 80);
        btnOrder.addActionListener(e -> {
            frame.dispose();
            new MenuBuatOrder(pelanggan);
        });

        //Button Transaksi
        btnTransaction = GUI.defaultButton("Lihat Transaksi", 20);
        btnTransaction.setBounds(170, 320, 250, 80);
        btnTransaction.addActionListener(e -> {
            frame.dispose();
            new MenuLihatDaftarTransaksiPelanggan(pelanggan);
        });

        //Button Isi Saldo
        btnIsiSaldo = GUI.defaultButton("Isi Saldo", 20);
        btnIsiSaldo.setBounds(170, 420, 250, 80);
        btnIsiSaldo.addActionListener(e -> {
            frame.dispose();
            new MenuIsiSaldo(pelanggan);
        });

        //Button Feedback
        btnFeedback = GUI.defaultButton("Beri Feedback", 20);
        btnFeedback.setBounds(170, 520, 250, 80);
        btnFeedback.addActionListener(e -> {
            frame.dispose();
            new MenuIsiFeedbackAdmin(pelanggan);
        });

        //Button Logout
        btnLogout = GUI.defaultButton("Logout", 20);
        btnLogout.setBounds(170, 620, 250, 80);
        btnLogout.addActionListener(e -> {
            frame.dispose();
            UserManager.getInstance().logOut();
            new HalamanAwal();
        });

        //Panel
        panelMessage = new JPanel();
        panelMessage.setBackground(GUI.backGroundColor());
        panelMessage.setBounds(0, 40, 600, 40);
        panelMessage.setVisible(true);
        panelMessage.add(labelMessage);

        //Frame
        frame = new DefaultComponentSetting().defaultFrame();
        frame.getContentPane().setBackground(GUI.backGroundColor());
        frame.add(btnProfile);
        frame.add(btnOrder);
        frame.add(btnTransaction);
        frame.add(btnIsiSaldo);
        frame.add(btnFeedback);
        frame.add(btnLogout);
        frame.add(panelMessage);
    }
}