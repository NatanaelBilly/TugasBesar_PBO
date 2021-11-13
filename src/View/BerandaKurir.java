/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Kurir;
import Model.UserManager;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

/**
 *
 * @author Asus
 */
public class BerandaKurir implements ActionListener{
    private JFrame frame;
    private JPanel panelBerandaKurir;
    private JLabel labelPesan;
    private JButton btnProfil, btnOrder, btnTransaksi, btnObrolan;

    public BerandaKurir(Kurir kurir){
        //label
        labelPesan = new DefaultComponentSetting().defaultRegularLabel("Selamat Datang, !");

        //Button
        btnProfil = new DefaultComponentSetting().defaultButton("Llihat Profil",20);
        btnProfil.setBounds(170, 150, 250, 80);
        btnProfil.addActionListener(this);
        
        btnOrder = new DefaultComponentSetting().defaultButton("Lihat Order",20);
        btnOrder.setBounds(170, 250, 250, 80);
        btnOrder.addActionListener(this);
        
        btnTransaksi = new DefaultComponentSetting().defaultButton("Lihat Transaksi",20);
        btnTransaksi.setBounds(170, 350, 250, 80);
        btnTransaksi.addActionListener(this);

        
        btnObrolan = new DefaultComponentSetting().defaultButton("Obrolan",20);
        btnObrolan.setBounds(170, 450, 250, 80);
        btnObrolan.addActionListener(this);
        
        //Panel
        panelBerandaKurir = new JPanel();
        panelBerandaKurir.setBounds(0,0,600,50);
        panelBerandaKurir.setVisible(true);
        panelBerandaKurir.add(labelPesan);

        //Frame
        frame = new DefaultComponentSetting().defaultFrame();
        frame.add(btnProfil);
        frame.add(btnOrder);
        frame.add(btnTransaksi);
        frame.add(btnObrolan);
        frame.add(panelBerandaKurir);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Lihat Profil":
//                new MenuLihatProfilKurir(kurir);
                frame.setVisible(false);
                break;
            case "Lihat Order":
                frame.setVisible(false);
                break;
            case "Lihat Transaksi":
                frame.setVisible(false);
                break;
            case "Obrolan":
                frame.setVisible(false);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Berhasil Keluar");
                System.exit(1);
                break;
        }
    }
}
