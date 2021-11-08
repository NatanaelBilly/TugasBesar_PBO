package View;
import javax.swing.*;
import java.awt.*;
import Model.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class MainMenuAdmin {

    public MainMenuAdmin(Admin admin){
        //frame
        JFrame frame = new JFrame("Nama APK");
        frame.setSize(600, 800);

        //panel
        JPanel panel= new JPanel();
        panel.setSize(600, 800);
        panel.setBackground(new Color(201, 228, 197));

        //label
        JLabel labelNama =new JLabel("WELCOME ADMIN "+admin.getNama_depan());
        labelNama.setBounds(400,20,200,30);
        panel.add(labelNama);

        //button lihat saldo pendapatan apk
        JButton buttonPendpatan = new JButton("lihat pendapatan");
        buttonPendpatan.setBounds(300, 100, 200, 30);
        buttonPendpatan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LihatSaldoAdmin(admin);
                frame.dispose();
            }
        });
        panel.add(buttonPendpatan);
        //button lihat list user
        JButton buttonListTransaksi = new JButton("lihat tabel transaksi");
        buttonListTransaksi.setBounds(300, 150, 200, 30);
        buttonListTransaksi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenampilkanSeluruhTransaksi();
                frame.dispose();
            }
        });
        panel.add(buttonListTransaksi);

        //button lihat seluruh transaksi
        JButton buttonListUser = new JButton("lihat tabel user");
        buttonListUser.setBounds(300, 200, 200, 30);
        buttonListUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenampilkanListUser();
                frame.dispose();
            }
        });
        panel.add(buttonListUser);

        //button lihat feedback dari user
        JButton buttonListFeedback = new JButton("lihat tabel feedback");
        buttonListFeedback.setBounds(300, 250, 200, 30);
        buttonListFeedback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenampilkanFeedbackDariPengguna();
                frame.dispose();
            }
        });
        panel.add(buttonListFeedback);

        //initialize panel dan frame
        panel.setLayout(null);
        panel.setVisible(true);
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
