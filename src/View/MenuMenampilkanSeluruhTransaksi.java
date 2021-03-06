package View;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controller.Controller;
import Controller.AdminController;
import Model.*;
public class MenuMenampilkanSeluruhTransaksi {
    private JFrame frame;
    private JPanel panel;
    private DefaultTableModel tableModel;
    private JTable tabelUser;
    private JScrollPane sp;
    private JButton back;
    private DefaultComponentSetting GUI = new DefaultComponentSetting();
    JLabel labelTotal, labelGetTotal;
    public MenuMenampilkanSeluruhTransaksi(Admin admin){
        Controller c =new Controller();
        AdminController m=new AdminController();
        frame = new DefaultComponentSetting().defaultFrame();

        panel= new JPanel();
        panel.setSize(600, 800);

        labelTotal  = new DefaultComponentSetting().defaultRegularLabel("Saldo Total Pendapatan : ");
        labelTotal.setBounds(10, 20, 200, 30);

        labelGetTotal = new DefaultComponentSetting().defaultRegularLabel(Double.toString(admin.getSaldo()));
        labelGetTotal.setBounds(210, 20, 150, 30);


        c.getSeluruhTransaksi();
        String [][] dataTransakksi=m.konversiListToArrayTransaksi(c.listTransaksi);

        //init kolom
        String column[]={"id transaksi","Id pelanggan","id kurir","tanggal transaksi","total pembayaran"};

        //tabel data
        tableModel=new DefaultTableModel(dataTransakksi,column);
        tabelUser=new JTable(tableModel);
        tabelUser.setBackground(GUI.backGroundColor());
        tabelUser.setBounds(10, 80, 570, 700);
        sp=new JScrollPane(tabelUser);
        sp.setBounds(10, 80, 570, 700);
        sp.setBackground(GUI.backGroundColor());
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);


        //button back
        back = GUI.defaultButton("Kembali", 18);
        back.setBounds(380,20,150,30);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BerandaAdmin(admin);
                frame.dispose();
            }
        });

        panel.add(back);
        panel.add(sp);
        panel.add(labelTotal);
        panel.add(labelGetTotal);
        //initialize panel dan frame
        panel.setLayout(null);
        panel.setVisible(true);
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
