package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.*;
import Controller.AdminController;
import Controller.Controller;
public class MenuLihatSaldoAdmin {
    private JFrame frame;
    private JPanel panel;
    private JLabel labelTotal,labelGetTotal;
    private JButton detilTransaksi,back;
    private DefaultComponentSetting GUI = new DefaultComponentSetting();
    public MenuLihatSaldoAdmin(Admin admin){
        Controller c=new Controller();
        AdminController m=new AdminController();
        //Frame
        frame = new DefaultComponentSetting().defaultFrame();

        //panel
        panel= new JPanel();
        panel.setSize(600, 800);

        //String builder
        StringBuilder str =new StringBuilder();
        c.ambilDaftarOrder();
        admin.setSaldo(m.lihatSaldoAdmin(c.listTransaksi));
        str.append(admin.getSaldo());

        //Label
        labelTotal  = new DefaultComponentSetting().defaultRegularLabel("Saldo Total Pendapatan");
        labelTotal.setBounds(30, 100, 150, 30);

        labelGetTotal = new DefaultComponentSetting().defaultRegularLabel(str.toString());
        labelGetTotal.setBounds(200, 100, 150, 30);

        //button
        detilTransaksi = new DefaultComponentSetting().defaultButton("Detail Transaksi",10);
        detilTransaksi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuMenampilkanSeluruhTransaksi(admin);
                frame.dispose();
            }
        });


        //button back
        back = GUI.defaultButton("Kembali", 18);
        back.setBounds(400,20,200,30);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BerandaAdmin(admin);
                frame.dispose();
            }
        });


        panel.add(labelTotal);
        panel.add(labelGetTotal);
        panel.add(detilTransaksi);
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
