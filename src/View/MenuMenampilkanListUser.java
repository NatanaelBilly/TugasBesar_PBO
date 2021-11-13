package View;

import javax.swing.*;
import java.awt.*;
import Model.*;
import Controller.*;

public class MenuMenampilkanListUser {
    public MenuMenampilkanListUser(){
        Controller c=new Controller();
        Method m=new Method();
        //frame
        JFrame frame = new JFrame("Nama APK");
        frame.setSize(1500, 1500);

        //panel
        JPanel panel= new JPanel();
        panel.setSize(1200, 1200);
        panel.setBackground(new Color(201, 228, 197));

        //init isi data
        String [][] dataUser=m.konversiListToArray(c.users);

        //init kolom
        String column[]={"Tingkatan","Id User","Nama Depan","Nama Belakang","email"};

        //tabel data
        JTable tabelDataUser=new JTable(dataUser,column);
        tabelDataUser.setBounds(30,40,400,600);
        JScrollPane sp=new JScrollPane(tabelDataUser);
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
