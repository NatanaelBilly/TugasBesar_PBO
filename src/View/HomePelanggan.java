package View;

import Model.Constant;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePelanggan {
    JFrame frame;
    JPanel panelMessage;
    JLabel labelMessage;
    JButton btnProfile, btnOrder, btnTransaction;

    public HomePelanggan(){
        //label
        labelMessage = new JLabel("Welcome Back, Ini Nama!");
        labelMessage.setFont(new Font("Arial", Font.BOLD, 24));

        //Button
        btnProfile = new JButton("See My Profile");
        btnProfile.setBounds(170, 210, 250, 80);
        btnProfile.setFont(new Font("Arial", Font.BOLD, 20));
        btnProfile.setBackground(new Color(217, 217, 217));
        btnProfile.setBorder(new BevelBorder(1, Color.BLACK, Color.BLACK));
        btnProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new ProfilePelanggan();
            }
        });
        btnOrder = new JButton("Create Order");
        btnOrder.setBounds(170, 340, 250, 80);
        btnOrder.setFont(new Font("Arial", Font.BOLD, 20));
        btnOrder.setBackground(new Color(217, 217, 217));
        btnOrder.setBorder(new BevelBorder(1, Color.BLACK, Color.BLACK));
        btnTransaction = new JButton("See transactions");
        btnTransaction.setBounds(170, 470, 250, 80);
        btnTransaction.setFont(new Font("Arial", Font.BOLD, 20));
        btnTransaction.setBackground(new Color(217, 217, 217));
        btnTransaction.setBorder(new BevelBorder(1, Color.BLACK, Color.BLACK));
        btnTransaction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LihatDaftarTransaksiPelanggan();
            }
        });

        //Panel
        panelMessage = new JPanel();
        panelMessage.setBounds(0,120,600,50);

        //Frame
        frame = new JFrame(Constant.applicationName+" - Home Pelanggan");
        frame.setSize(600, 800);

        panelMessage.add(labelMessage);
        frame.add(btnProfile);
        frame.add(btnOrder);
        frame.add(btnTransaction);
        frame.add(panelMessage);

        panelMessage.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
