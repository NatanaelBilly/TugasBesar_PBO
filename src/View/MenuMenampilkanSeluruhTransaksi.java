package View;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controller.Controller;
import Controller.Method;
import Model.*;
public class MenuMenampilkanSeluruhTransaksi {
    public MenuMenampilkanSeluruhTransaksi(){
        Controller c =new Controller();
        Method m=new Method();
        JFrame frame = new DefaultComponentSetting().defaultFrame();

        //panel
        JPanel panel= new JPanel();
        panel.setSize(600, 800);
        panel.setBackground(new Color(201, 228, 197));

        //init isi data
        String [][] dataTransakksi=m.konversiListToArrayTransaksi(c.users);

        //init kolom
        String column[]={"id transaksi","Id pelanggan","id kurir","tanggal transaksi","total pembayaran"};

        //tabel data
        JTable tabelDataTransaksi=new JTable(dataTransakksi,column);
        tabelDataTransaksi.setBounds(30,40,400,600);
        JScrollPane sp=new JScrollPane(tabelDataTransaksi);
        panel.add(sp);

        //button back
        JButton back = new JButton("Kembali ke Main Menu");
        back.setBounds(20,500,100,40);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                new BerandaAdmin(admin);
                frame.dispose();
            }
        });
        panel.add(back);

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
