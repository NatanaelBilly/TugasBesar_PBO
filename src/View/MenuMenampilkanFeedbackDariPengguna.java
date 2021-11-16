package View;
import Controller.Controller;
import Controller.Method;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuMenampilkanFeedbackDariPengguna {
    public MenuMenampilkanFeedbackDariPengguna(){
        Controller c =new Controller();
        Method m=new Method();
        //frame
        JFrame frame = new DefaultComponentSetting().defaultFrame();
        frame.setBackground(new Color(201, 228, 197));

        //init isi data
        c.getSeluruhSaran();
        String [][] dataSaran=m.konversiListToArraySaran(c.listSaran);
        //init kolom
        String column[]={"id saran","Id pengguna","Saran"};

        //tabel data
        DefaultTableModel tabelModel=new DefaultTableModel(dataSaran,column);
        JTable tabelSaran=new JTable(tabelModel);
        tabelSaran.setBackground(new Color(201, 228, 197));
        tabelSaran.setBounds(10,100,550,600);
        JScrollPane sp=new JScrollPane(tabelSaran);
        sp.setBounds(0,100,550,600);
        sp.setBackground(new Color(201, 228, 197));
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        //button back
        JButton back = new JButton("Kembali ke Main Menu");
        back.setBounds(400,20,200,30);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                new BerandaAdmin(admin);
                frame.dispose();
            }
        });
        frame.add(back);

        //initialize panel dan frame
        frame.setLocationRelativeTo(null);
        frame.add(sp);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
