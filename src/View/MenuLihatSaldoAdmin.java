package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Object;
import java.awt.Color;
import Model.*;
public class MenuLihatSaldoAdmin {
    JFrame frame;
    JPanel panel;
    JLabel labelTotal,labelGetTotal;
    JButton detilTransaksi,back;
    public MenuLihatSaldoAdmin(Admin admin){
        //Frame
        frame = new DefaultComponentSetting().defaultFrame();

        //panel
        panel= new JPanel();
        panel.setSize(600, 800);
        panel.setBackground(new Color(201, 228, 197));

        //String builder
        StringBuilder str =new StringBuilder();
        str.append(admin.getSaldo());

        //Label
        labelTotal  = new DefaultComponentSetting().defaultRegularLabel("Saldo Total Pendapatan");
        labelTotal.setBounds(30, 100, 150, 30);
        panel.add(labelTotal);
        labelGetTotal = new DefaultComponentSetting().defaultRegularLabel(str.toString());
        labelGetTotal.setBounds(200, 100, 150, 30);
        panel.add(labelGetTotal);

        //button
        detilTransaksi = new DefaultComponentSetting().defaultButton("Detail Transaksi",50);
        detilTransaksi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuMenampilkanSeluruhTransaksi();
                frame.dispose();
            }
        });
        panel.add(detilTransaksi);

        //button back
        back = new JButton("Kembali ke Main Menu");
        back.setBounds(400,20,200,30);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BerandaAdmin(admin);
                frame.dispose();
            }
        });
        panel.add(back);

        //initialize panel dan frame
        panel.setLayout(null);
        panel.setVisible(true);
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
