package View;

import javax.swing.*;
import java.awt.*;

import Model.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BerandaAdmin {
    private JFrame frame;
    private JPanel panel;
    private JLabel labelNama;
    private JButton buttonPendpatan, buttonListTransaksi, buttonListUser, buttonListFeedback, buttonLogout;
    private DefaultComponentSetting GUI = new DefaultComponentSetting();

    public BerandaAdmin(Admin admin) {
        labelNama = GUI.defaultHeadingLabel("Welcome Admin");
        labelNama.setBounds(0, 70, 600, 30);

        buttonListTransaksi = GUI.defaultButton("Lihat Daftar Transaksi", 18);
        buttonListTransaksi.setBounds(170, 220, 250, 80);
        buttonListTransaksi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new MenuMenampilkanSeluruhTransaksi(admin);
            }
        });

        buttonListUser = GUI.defaultButton("Lihat Daftar User", 18);
        buttonListUser.setBounds(170, 320, 250, 80);
        buttonListUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new MenuMenampilkanListUser(admin);
            }
        });

        buttonListFeedback = GUI.defaultButton("Lihat Masukan", 18);
        buttonListFeedback.setBounds(170, 420, 250, 80);
        buttonListFeedback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new MenuMenampilkanFeedbackDariPengguna(admin);
            }
        });

        buttonLogout = GUI.defaultButton("Log Out", 18);
        buttonLogout.setBounds(170, 520, 250, 80);
        buttonLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UserManager().logOut();
                JOptionPane.showMessageDialog(null, Constant.INFO_LOGOUT);
                frame.dispose();
                new HalamanAwal();
            }
        });

        panel = new JPanel();
        panel.setLayout(null);
        panel.setVisible(true);
        panel.setSize(600, 800);
        panel.setBackground(GUI.backGroundColor());
        panel.add(labelNama);
        panel.add(buttonPendpatan);
        panel.add(buttonListTransaksi);
        panel.add(buttonListUser);
        panel.add(buttonListFeedback);
        panel.add(buttonLogout);

        frame = GUI.defaultFrame();
        frame.add(panel);
    }
}
