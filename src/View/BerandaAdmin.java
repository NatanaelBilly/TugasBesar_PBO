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
        labelNama =new JLabel("WELCOME ADMIN "+admin.getNama_depan());
        labelNama.setBounds(250,20,200,30);
        panel.add(labelNama);

        //button lihat saldo pendapatan apk
        buttonPendpatan = new JButton("lihat pendapatan");
        buttonPendpatan.setBounds(200, 100, 200, 30);
        buttonPendpatan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                new LihatSaldoAdmin(admin);
                frame.dispose();
            }
        });
        panel.add(buttonPendpatan);
        //button lihat list user
        buttonListTransaksi = new JButton("lihat tabel transaksi");
        buttonListTransaksi.setBounds(200, 150, 200, 30);
        buttonListTransaksi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuMenampilkanSeluruhTransaksi();
                frame.dispose();
            }
        });
        panel.add(buttonListTransaksi);

        //button lihat seluruh transaksi
        buttonListUser = new JButton("lihat tabel user");
        buttonListUser.setBounds(200, 200, 200, 30);
        buttonListUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuMenampilkanListUser();
                frame.dispose();
            }
        });
        panel.add(buttonListUser);

        //button lihat feedback dari user
        buttonListFeedback = new JButton("lihat tabel feedback");
        buttonListFeedback.setBounds(200, 250, 200, 30);
        buttonListFeedback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuMenampilkanFeedbackDariPengguna();
                frame.dispose();
            }
        });
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
