package View;
import javax.swing.*;
import java.awt.*;
import Model.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class BerandaAdmin {
    JFrame frame;
    JPanel panel;
    JLabel labelNama;
    JButton buttonPendpatan,buttonListTransaksi,buttonListUser,buttonListFeedback;

    public BerandaAdmin(Admin admin){
        //frame
        frame = new DefaultComponentSetting().defaultFrame();

        //panel
        panel= new JPanel();
        panel.setSize(600, 800);
        panel.setBackground(new Color(201, 228, 197));

        //label
        labelNama =new JLabel("WELCOME ADMIN "+admin.getNamaBelakang());
        labelNama.setBounds(250,20,200,30);

        //button lihat saldo pendapatan apk
        buttonPendpatan = new DefaultComponentSetting().defaultButton("Lihat Pendapatan",10);
        buttonPendpatan.setBounds(200, 100, 200, 30);
        buttonPendpatan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuLihatSaldoAdmin(admin);
                frame.dispose();
            }
        });

        //button lihat list user
        buttonListTransaksi = new DefaultComponentSetting().defaultButton("Lihat Tabel Transaksi",10);
        buttonListTransaksi.setBounds(200, 150, 200, 30);
        buttonListTransaksi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuMenampilkanSeluruhTransaksi(admin);
                frame.dispose();
            }
        });


        //button lihat seluruh transaksi
        buttonListUser = new DefaultComponentSetting().defaultButton("lihat Tabel User",10);
        buttonListUser.setBounds(200, 200, 200, 30);
        buttonListUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuMenampilkanListUser(admin);
                frame.dispose();
            }
        });


        //button lihat feedback dari user
        buttonListFeedback = new DefaultComponentSetting().defaultButton("Lihat Tabel Saran",10);
        buttonListFeedback.setBounds(200, 250, 200, 30);
        buttonListFeedback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuMenampilkanFeedbackDariPengguna(admin);
                frame.dispose();
            }
        });


        panel.add(labelNama);
        panel.add(buttonPendpatan);
        panel.add(buttonListTransaksi);
        panel.add(buttonListUser);
        panel.add(buttonListFeedback);
        //initialize panel dan frame
        panel.setLayout(null);
        panel.setVisible(true);
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);

    }
}
