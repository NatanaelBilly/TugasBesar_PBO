package View;

import Controller.Controller;
import Model.Pelanggan;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MenuIsiSaldo {
    private JFrame frame;
    private JButton gopay;
    private JButton ovo;
    private JLabel menuTitle, labelPaymentPic, labelKembali;
    private ImageIcon paymentPic;
    private JButton back;
    private JButton isi;
    private JLabel nomorTelepon;
    private JTextField inputNomorTelepon;
    private DefaultComponentSetting GUI = new DefaultComponentSetting();

    public MenuIsiSaldo(Pelanggan pelanggan) {
        //Label Kembali
        labelKembali = new DefaultComponentSetting().defaultBackLabel();
        labelKembali.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                new BerandaPelanggan(pelanggan);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                frame.dispose();
                new BerandaPelanggan(pelanggan);
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        //Judul
        menuTitle = GUI.defaultHeadingLabel("ISI SALDO");
        menuTitle.setBounds(0, 90, 600, 80);

        //Metode Gopay
        gopay = GUI.defaultButton("GOPAY", 20);
        gopay.setBounds(170, 250, 250, 80);
        gopay.addActionListener((ActionEvent e) -> {
            frame.dispose();
            MenuIsiSaldoGopayOvo(pelanggan, "Gopay");
        });

        //Metode OVO
        ovo = GUI.defaultButton("OVO", 20);
        ovo.setBounds(170, 380, 250, 80);
        ovo.addActionListener((ActionEvent e) -> {
            frame.dispose();
            MenuIsiSaldoGopayOvo(pelanggan, "Ovo");
        });

        //Frame
        frame = GUI.defaultFrame();
        frame.getContentPane().setBackground(GUI.backGroundColor());
        frame.add(menuTitle);
        frame.add(labelKembali);
        frame.add(gopay);
        frame.add(ovo);
    }

    public void MenuIsiSaldoGopayOvo(Pelanggan pelanggan, String via) {
        if (via.equals("Gopay")) {
            labelPaymentPic = new JLabel();
            paymentPic = new ImageIcon(new ImageIcon("assets/gopay.png").getImage().getScaledInstance(200, 100, Image.SCALE_DEFAULT));
            labelPaymentPic.setIcon(paymentPic);
            labelPaymentPic.setBounds(190, 70, 500, 260);
        }
        if (via.equals("Ovo")) {
            labelPaymentPic = new JLabel();
            paymentPic = new ImageIcon(new ImageIcon("assets/ovo.png").getImage().getScaledInstance(200, 100, Image.SCALE_DEFAULT));
            labelPaymentPic.setIcon(paymentPic);
            labelPaymentPic.setBounds(190, 70, 500, 260);
        }

        nomorTelepon = GUI.defaultHeadingLabel("Nomor Telepon :");
        nomorTelepon.setBounds(0, 340, 600, 30);

        inputNomorTelepon = new JTextField();
        inputNomorTelepon.setBounds(150, 390, 300, 50);
        inputNomorTelepon.setFont(new Font("Arial", Font.PLAIN, 20));


        back = GUI.defaultButton("Kembali", 14);
        back.setBounds(170, 460, 100, 30);
        back.addActionListener((ActionEvent e) -> {
            frame.dispose();
            new MenuIsiSaldo(pelanggan);
        });

        isi = GUI.defaultButton("Isi", 14);
        isi.setBounds(330, 460, 100, 30);
        isi.addActionListener((ActionEvent e) -> {
            if (inputNomorTelepon.getText().equals(pelanggan.getNoHp())) {
                Controller c = new Controller();
                int saldo = Integer.parseInt(JOptionPane.showInputDialog(null, "Masukkan Jumlah Saldo : "));
                boolean cek = c.isiSaldo(pelanggan, saldo);
                if (cek == true) {
                    JOptionPane.showMessageDialog(null, "Pengisian Berhasil");
                    double saldoSekarang = pelanggan.getSaldo();
                    pelanggan.setSaldo(saldoSekarang + saldo);
                } else {
                    JOptionPane.showMessageDialog(null, "Pengisian Gagal");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Nomor Telepon Tidak Sesuai");
            }
        });

        frame = GUI.defaultFrame();
        frame.getContentPane().setBackground(GUI.backGroundColor());
        frame.add(labelPaymentPic);
        frame.add(nomorTelepon);
        frame.add(inputNomorTelepon);
        frame.add(back);
        frame.add(isi);
    }

}
