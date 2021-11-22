package View;
import Controller.Controller;
import Controller.Method;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Model.Admin;
public class MenuMenampilkanFeedbackDariPengguna {
    private JFrame frame;
    private JPanel panel;
    private DefaultTableModel tableModel;
    private JTable tabelSaran;
    private JScrollPane sp;
    private JButton back;
    private DefaultComponentSetting GUI = new DefaultComponentSetting();
    public MenuMenampilkanFeedbackDariPengguna(Admin admin){
        Controller c =new Controller();
        Method m=new Method();
        //frame
        frame = new DefaultComponentSetting().defaultFrame();

        //panel
        panel= new JPanel();
        panel.setSize(600, 800);
        panel.setBackground(new Color(201, 228, 197));

        //init isi data
        c.getSeluruhSaran();
        String [][] dataSaran=m.konversiListToArraySaran(c.listSaran);
        //init kolom
        String column[]={"id saran","Id pengguna","Saran"};

        //tabel data
        tableModel=new DefaultTableModel(dataSaran,column);
        tabelSaran=new JTable(tableModel);
        tabelSaran.setBackground(GUI.backGroundColor());
        tabelSaran.setBounds(10, 80, 570, 700);
        JScrollPane sp=new JScrollPane(tabelSaran);
        sp.setBounds(10, 80, 570, 700);
        sp.setBackground(GUI.backGroundColor());
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);


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
