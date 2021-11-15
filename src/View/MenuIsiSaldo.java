package View;

import Controller.Controller;
import Model.Pelanggan;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class MenuIsiSaldo {
    JFrame frame;
    JButton gopay;
    JButton ovo;
    JLabel menuTitle, labelPaymentPic;
    ImageIcon paymentPic;
    JButton back;
    JButton isi;
    JLabel nomorTelepon;
    JTextField inputNomorTelepon;
    public MenuIsiSaldo(Pelanggan pelanggan) {

        frame = new DefaultComponentSetting().defaultFrame();
        menuTitle = new JLabel("Isi Saldo");
        menuTitle.setFont(new Font("Serif", Font.PLAIN, 50));
        menuTitle.setBounds(205, 90, 250, 80);
        frame.add(menuTitle);

        gopay = new DefaultComponentSetting().defaultButton("Gopay", 20);
        gopay.setBounds(170, 250, 250, 80);
        gopay.addActionListener((ActionEvent e) -> {
            frame.dispose();
            MenuIsiSaldoGopayOvo(pelanggan, "Gopay");
        });
        frame.add(gopay);

        ovo = new DefaultComponentSetting().defaultButton("Ovo", 20);
        ovo.setBounds(170, 380, 250, 80);
        ovo.addActionListener((ActionEvent e) -> {
            frame.dispose();
            MenuIsiSaldoGopayOvo(pelanggan, "Ovo");
        });
        frame.add(ovo);
        
        back = new DefaultComponentSetting().defaultButton("< Back", 20);
        back.setBounds(170, 510, 250, 80);
        back.addActionListener((ActionEvent e) -> {
            frame.dispose();
            new BerandaPelanggan(pelanggan);
        });
        frame.add(back);
    }

    public void MenuIsiSaldoGopayOvo(Pelanggan pelanggan, String via) {
        frame = new DefaultComponentSetting().defaultFrame();
        Font fontButton = new Font("Arial", Font.BOLD, 16);
        if (via.equals("Gopay")) {
            labelPaymentPic = new JLabel();
            paymentPic = new ImageIcon( new ImageIcon("assets/gopay.png").getImage().getScaledInstance(200, 100, Image.SCALE_DEFAULT));
            labelPaymentPic.setIcon(paymentPic);
            labelPaymentPic.setBounds(190, 70, 500, 260);
        }
        if (via.equals("Ovo")) {
            labelPaymentPic = new JLabel();
            paymentPic = new ImageIcon( new ImageIcon("assets/ovo.png").getImage().getScaledInstance(200, 100, Image.SCALE_DEFAULT));
            labelPaymentPic.setIcon(paymentPic);
            labelPaymentPic.setBounds(190, 70, 500, 260);
        }
        frame.add(labelPaymentPic);
        
        
        nomorTelepon = new DefaultComponentSetting().defaultRegularLabel("Nomor Telepon :");
        nomorTelepon.setBounds(230, 340, 240, 30);
        Font newTextFieldFont2 = new Font(nomorTelepon.getFont().getName(), nomorTelepon.getFont().getStyle(), 20);
        nomorTelepon.setFont(newTextFieldFont2);
        frame.add(nomorTelepon);
        
        inputNomorTelepon = new JTextField();
        inputNomorTelepon.setBounds(200, 390, 215, 50);
        inputNomorTelepon.setFont(new Font("Arial", Font.PLAIN, 20));
        frame.add(inputNomorTelepon);
        
        back = new JButton("Back");
        back.setBounds(220, 460, 80, 30);
        back.setFont(fontButton);
        back.setBorder(new BevelBorder(1, Color.BLACK, Color.BLACK));
        back.addActionListener((ActionEvent e) -> {
            frame.dispose();
            new MenuIsiSaldo(pelanggan);
        });
        frame.add(back);
        
        isi = new JButton("isi");
        isi.setBounds(320, 460, 80, 30);
        isi.setFont(fontButton);
        isi.setBorder(new BevelBorder(1, Color.BLACK, Color.BLACK));
        isi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(inputNomorTelepon.getText().equals(pelanggan.getNoHp())){
                    Controller c = new Controller();
                    int saldo = Integer.parseInt(JOptionPane.showInputDialog(null, "Masukkan Jumlah Saldo : "));
                    boolean cek = c.isiSaldo(pelanggan, saldo);
                    if (cek == true) {
                        JOptionPane.showMessageDialog(null, "Pengisian Berhasil");
                    }else {
                        JOptionPane.showMessageDialog(null, "Pengisian Gagal");
                    }
                    
                }else {
                    JOptionPane.showMessageDialog(null, "Nomor Telepon Tidak Sesuai");
                }
                
            }
        });
        frame.add(isi);
    }

}
