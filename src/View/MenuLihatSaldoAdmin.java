package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Object;
import java.awt.Color;
import Model.*;
public class MenuLihatSaldoAdmin {

    public MenuLihatSaldoAdmin(Admin admin){
        //Frame
        JFrame frame = new DefaultComponentSetting().defaultFrame();

        //panel
        JPanel panel= new JPanel();
        panel.setSize(600, 800);
        panel.setBackground(new Color(201, 228, 197));

        //String builder
        StringBuilder str =new StringBuilder();
        str.append(admin.getSaldo());

        //Label
        JLabel labelTotal  = new DefaultComponentSetting().defaultRegularLabel("Saldo Total Pendapatan");
        labelTotal.setBounds(30, 100, 150, 30);
        panel.add(labelTotal);
        JLabel labelGetTotal = new DefaultComponentSetting().defaultRegularLabel(str.toString());
        labelGetTotal.setBounds(200, 100, 150, 30);
        panel.add(labelGetTotal);

        //button
        JButton detilTransaksi = new DefaultComponentSetting().defaultButton("Detail Transaksi",50);
        detilTransaksi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuMenampilkanSeluruhTransaksi();
                frame.dispose();
            }
        });
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
