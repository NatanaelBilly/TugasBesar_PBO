package View;
import javax.swing.*;
import java.awt.*;

import Controller.Controller;
import Controller.Method;
import Model.*;
public class MenampilkanSeluruhTransaksi {
    public MenampilkanSeluruhTransaksi(){
        Controller c =new Controller();
        Method m=new Method();
        //frame
        JFrame frame = new JFrame("Nama APK");
        frame.setSize(1500, 1500);

        //panel
        JPanel panel= new JPanel();
        panel.setSize(1200, 1200);
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
