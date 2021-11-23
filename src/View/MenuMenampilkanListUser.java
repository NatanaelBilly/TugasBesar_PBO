package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.*;
import Controller.*;

public class MenuMenampilkanListUser {
    private JFrame frame;
    private JPanel panel;
    private DefaultTableModel tableModel;
    private JTable tabelUser;
    private JScrollPane sp;
    private JButton back;
    private Controller c = new Controller();
    private DefaultComponentSetting GUI = new DefaultComponentSetting();

    public MenuMenampilkanListUser(Admin admin) {
        Method m = new Method();
        //init isi data
        c.getAllUsers();
        String[][] dataUser = m.konversiListToArray(c.users);

        //init kolom
        String column[] = {"Tingkatan", "Id", "Nama Depan", "Nama Belakang", "email"};

        //tabel data
        tableModel = new DefaultTableModel(dataUser, column);
        tabelUser = new JTable(tableModel);
        tabelUser.setBackground(GUI.backGroundColor());
        tabelUser.setBounds(10, 80, 570, 700);
        JScrollPane sp = new JScrollPane(tabelUser);
        sp.setBounds(10, 80, 570, 700);
        sp.setBackground(GUI.backGroundColor());
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);


        //button back
        back = GUI.defaultButton("Kembali", 18);
        back.setBounds(400, 20, 150, 30);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BerandaAdmin(admin);
                frame.dispose();
            }
        });

        //panel
        panel = new JPanel();
        panel.setSize(600, 800);
        panel.setBackground(GUI.backGroundColor());
        panel.setLayout(null);
        panel.setVisible(true);
        panel.add(back);
        panel.add(sp);

        //Frame
        frame = GUI.defaultFrame();
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
