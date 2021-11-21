package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.*;
import Controller.*;

public class MenuMenampilkanListUser {
    JFrame frame;
    JPanel panel;
    DefaultTableModel tableModel;
    JTable tabelUser;
    JScrollPane sp;
    JButton back;
    public MenuMenampilkanListUser(Admin admin){
        Controller c=new Controller();
        Method m=new Method();
        frame = new DefaultComponentSetting().defaultFrame();

        //panel
        panel= new JPanel();
        panel.setSize(600, 800);
        panel.setBackground(new Color(201, 228, 197));

        //init isi data
        c.getAllUsers();
        String [][] dataUser=m.konversiListToArray(c.users);

        //init kolom
        String column[]={"Tingkatan","Id User","Nama Depan","Nama Belakang","email"};

        //tabel data
        tableModel=new DefaultTableModel(dataUser,column);
        tabelUser=new JTable(tableModel);
        tabelUser.setBackground(new Color(201, 228, 197));
        tabelUser.setBounds(10,100,550,600);
        JScrollPane sp=new JScrollPane(tabelUser);
        sp.setBounds(0,100,550,600);
        sp.setBackground(new Color(201, 228, 197));
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);


        //button back
        back = new DefaultComponentSetting().defaultButton("kembali ke main menu",10);
        back.setBounds(400,20,200,30);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BerandaAdmin(admin);
                frame.dispose();
            }
        });
        panel.add(back);
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
