package View;

import javax.swing.*;
import java.lang.Object;
import java.awt.Color;
import Model.*;
public class MenuLihatSaldoAdmin {

    public MenuLihatSaldoAdmin(Admin admin){
        //frame
        JFrame frame = new JFrame("Nama APK");
        frame.setSize(600, 800);

        //panel
        JPanel panel= new JPanel();
        panel.setSize(600, 600);
        panel.setBackground(new Color(201, 228, 197));

        //String builder
        StringBuilder str =new StringBuilder();
        str.append(admin.getSaldo());

        //Label
        JLabel labelTotal = new JLabel("Saldo Total Pendapatan");
        labelTotal.setBounds(30, 100, 150, 30);
        panel.add(labelTotal);
        JLabel labelGetTotal = new JLabel(str.toString());
        labelGetTotal.setBounds(200, 100, 150, 30);
        panel.add(labelGetTotal);

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
