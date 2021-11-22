package View;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controller.Controller;
import Controller.Method;
import Model.*;
public class MenuMenampilkanSeluruhTransaksi {
    private JFrame frame;
    private JPanel panel;
    private DefaultTableModel tableModel;
    private JTable tabelUser;
    private JLabel labelTotal,labelGetTotal;
    private JScrollPane sp;
    private JButton back;
    private DefaultComponentSetting GUI = new DefaultComponentSetting();
    public MenuMenampilkanSeluruhTransaksi(Admin admin){
        Controller c =new Controller();
        Method m=new Method();
        frame = new DefaultComponentSetting().defaultFrame();

        panel= new JPanel();
        panel.setSize(600, 800);

        StringBuilder str =new StringBuilder();
        c.getSeluruhTransaksi();
        admin.setSaldo(m.lihatSaldoAdmin(c.listTransaksi));
        str.append(admin.getSaldo());

        labelTotal  = new DefaultComponentSetting().defaultRegularLabel("Saldo Total Pendapatan : ");
        labelTotal.setBounds(30, 100, 200, 30);

        labelGetTotal = new DefaultComponentSetting().defaultRegularLabel(str.toString());
        labelGetTotal.setBounds(250, 100, 150, 30);

        c.getAllUsers();
        String [][] dataTransakksi=m.konversiListToArrayTransaksi(c.users);

        String column[]={"id transaksi","Id pelanggan","id kurir","tanggal transaksi","total pembayaran"};

        tableModel=new DefaultTableModel(dataTransakksi,column);
        tabelUser=new JTable(tableModel);
        tabelUser.setBackground(GUI.backGroundColor());
        tabelUser.setBounds(10, 80, 570, 700);
        sp=new JScrollPane(tabelUser);
        sp.setBounds(10, 80, 570, 700);
        sp.setBackground(GUI.backGroundColor());
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        back = GUI.defaultButton("Kembali", 18);
        back.setBounds(350,20,200,30);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BerandaAdmin(admin);
                frame.dispose();
            }
        });

        panel.add(labelTotal);
        panel.add(labelGetTotal);
        panel.add(back);
        panel.add(sp);

        panel.setLayout(null);
        panel.setVisible(true);
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
