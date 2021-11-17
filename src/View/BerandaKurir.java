/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.KurirController;
import Model.Kurir;
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

    private final DefaultComponentSetting GUI = new DefaultComponentSetting();
    
    private final Kurir kurir;
    public BerandaKurir(Kurir kurir){
        
//        if(kurir == null || new KurirController().cekKurirLogin())
//        {
//            new MenuLogin();
//        }
        this.kurir = kurir;
        
        
        //label
        labelPesan = GUI.defaultHeadingLabel("Selamat Datang, "+ kurir.getNama_depan() +" !");
        labelPesan.setBounds(145, 50, 300, 80);

        //Button
        btnProfil = GUI.defaultButton("Lihat Profil",20);
        btnProfil.setBounds(170, 150, 250, 80);
        btnProfil.addActionListener(this);
        
        btnOrder = GUI.defaultButton("Lihat Order",20);
        btnOrder.setBounds(170, 250, 250, 80);
        btnOrder.addActionListener(this);
        
        btnTransaksi = GUI.defaultButton("Lihat Transaksi",20);
        btnTransaksi.setBounds(170, 350, 250, 80);
        btnTransaksi.addActionListener(this);

        
        btnObrolan = GUI.defaultButton("Obrolan",20);
        btnObrolan.setBounds(170, 450, 250, 80);
        btnObrolan.addActionListener(this);
        
        //Panel
//        panelBerandaKurir = new JPanel();
//        panelBerandaKurir.setBounds(0,0,600,50);
//        panelBerandaKurir.setLayout(null);
//        panelBerandaKurir.setVisible(true);
        
        
        //Frame
        frame = GUI.defaultFrame();
        frame.add(btnProfil);
        frame.add(btnOrder);
        frame.add(btnTransaksi);
        frame.add(btnObrolan);
        frame.add(labelPesan);
        //frame.add(panelBerandaKurir);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Lihat Profil":
                new MenuLihatProfilKurir(kurir);
                frame.dispose();
                break;
            case "Lihat Order":
                new MenuLihatOrderKurir(kurir);
                frame.dispose();
                break;
            case "Lihat Transaksi":
                frame.dispose();
                break;
            case "Obrolan":
                frame.dispose();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Berhasil Keluar");
                System.exit(1);
                break;
        }
    }
}
