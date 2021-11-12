/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Kurir;
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
public class KurirMenu implements ActionListener{
    private JFrame frame;
    private JPanel panelPesan;
    private JLabel labelPesan;
    private JButton btnProfil, btnOrder, btnTransaksi, btnObrolan;

    private Kurir kurir;
    
    public KurirMenu(Kurir kurir){
        this.kurir = kurir;
        
        //label
        labelPesan = new JLabel("Selamat Datang, !");
        labelPesan.setFont(new Font("Arial", Font.BOLD, 24));

        //Button
        btnProfil = new JButton("Lihat Profil");
        btnProfil.setBounds(170, 150, 250, 80);
        btnProfil.setFont(new Font("Arial", Font.BOLD, 20));
        btnProfil.setBackground(new Color(217, 217, 217));
        btnProfil.setBorder(new BevelBorder(1, Color.BLACK, Color.BLACK));
        btnProfil.addActionListener(this);
        
        btnOrder = new JButton("Lihat Order");
        btnOrder.setBounds(170, 250, 250, 80);
        btnOrder.setFont(new Font("Arial", Font.BOLD, 20));
        btnOrder.setBackground(new Color(217, 217, 217));
        btnOrder.setBorder(new BevelBorder(1, Color.BLACK, Color.BLACK));
        btnOrder.addActionListener(this);
        
        btnTransaksi = new JButton("Lihat Transaksi");
        btnTransaksi.setBounds(170, 350, 250, 80);
        btnTransaksi.setFont(new Font("Arial", Font.BOLD, 20));
        btnTransaksi.setBackground(new Color(217, 217, 217));
        btnTransaksi.setBorder(new BevelBorder(1, Color.BLACK, Color.BLACK));
        btnTransaksi.addActionListener(this);

        
        btnObrolan = new JButton("Obrolan");
        btnObrolan.setBounds(170, 450, 250, 80);
        btnObrolan.setFont(new Font("Arial", Font.BOLD, 20));
        btnObrolan.setBackground(new Color(217, 217, 217));
        btnObrolan.setBorder(new BevelBorder(1, Color.BLACK, Color.BLACK));
        btnObrolan.addActionListener(this);
        
        //Panel
        panelPesan = new JPanel();
        panelPesan.setBounds(0,50,600,50);

        //Frame
        frame = new DefaultFrameSetting().defaultFrame();

        panelPesan.add(labelPesan);
        frame.add(btnProfil);
        frame.add(btnOrder);
        frame.add(btnTransaksi);
        frame.add(btnObrolan);
        frame.add(panelPesan);

        panelPesan.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Lihat Profil":
                new KurirLihatProfil(kurir);
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
