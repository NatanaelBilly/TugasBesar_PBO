package View;


import Model.Constant;
import Model.Kurir;
import Model.UserManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class BerandaKurir implements ActionListener {
    JFrame frame;
    JLabel labelPesan;
    JButton btnProfil, btnOrder, btnTransaksi, btnObrolan, btnLogout;
    DefaultComponentSetting GUI = new DefaultComponentSetting();
    Kurir kurir;

    public BerandaKurir(Kurir kurir) {
        this.kurir = kurir;

        //label
        labelPesan = GUI.defaultHeadingLabel("Selamat Datang, " + kurir.getNamaDepan() + "!");
        labelPesan.setBounds(145, 50, 300, 80);

        //Button Profil
        btnProfil = GUI.defaultButton("Lihat Profil", 20);
        btnProfil.setBounds(170, 150, 250, 80);
        btnProfil.addActionListener(this);

        //Button Order
        btnOrder = GUI.defaultButton("Lihat Order", 20);
        btnOrder.setBounds(170, 250, 250, 80);
        btnOrder.addActionListener(this);

        //Button Transaksi
        btnTransaksi = GUI.defaultButton("Lihat Transaksi", 20);
        btnTransaksi.setBounds(170, 350, 250, 80);
        btnTransaksi.addActionListener(this);

        //Button Obrolan
        btnObrolan = GUI.defaultButton("Obrolan", 20);
        btnObrolan.setBounds(170, 450, 250, 80);
        btnObrolan.addActionListener(this);

        //Button Logout
        btnLogout = GUI.defaultButton("Logout", 20);
        btnLogout.setBounds(170, 550, 250, 80);
        btnLogout.addActionListener(this);

        //Frame
        frame = GUI.defaultFrame();
        frame.add(btnProfil);
        frame.add(btnOrder);
        frame.add(btnTransaksi);
        frame.add(btnObrolan);
        frame.add(labelPesan);
        frame.add(btnLogout);
        frame.getContentPane().setBackground(GUI.backGroundColor());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Lihat Profil":
                frame.dispose();
                new MenuProfilKurir(kurir);
                break;
            case "Lihat Order":
                
                if(kurir.getKetersediaan() == 0)
                {
                    frame.dispose();
                    new MenuLihatOrderKurir(kurir);
                }
                else
                    JOptionPane.showMessageDialog(null, "Kamu masih memiliki orderan yang harus diantar.");
                
                break;
            case "Lihat Transaksi":
                frame.dispose();
                new MenuLihatDaftarTransaksi(kurir);
                break;
            case "Obrolan":
                frame.dispose();
                //new obrolan
                break;
            case "Logout":
                JOptionPane.showMessageDialog(null, Constant.INFO_LOGOUT);
                frame.dispose();
                UserManager.getInstance().logOut();
                new HalamanAwal();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Berhasil Keluar");
                System.exit(1);
                break;
        }
    }
}
