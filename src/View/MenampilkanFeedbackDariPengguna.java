package View;
import Controller.Controller;
import Controller.Method;
import javax.swing.*;
import java.awt.*;
public class MenampilkanFeedbackDariPengguna {
    public MenampilkanFeedbackDariPengguna(){
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
        String [][] dataSaran=m.konversiListToArrayTransaksi(c.users);//masi perlu diganti jadi arrayList saran di admin

        //init kolom
        String column[]={"id saran","Id pengguna","Saran"};

        //tabel data
        JTable tabelSaran=new JTable(dataSaran,column);
        tabelSaran.setBounds(30,40,400,600);
        JScrollPane sp=new JScrollPane(tabelSaran);
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
