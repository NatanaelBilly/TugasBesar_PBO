/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Controller;
import Model.Transaksi;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Asus
 */
public class MenuLihatOrderKurir {
     JFrame frame;
    JPanel panel, panelMenu;
    JPanel[] panelOrder;
    JLabel labelPengirim,labelAlamatTujuan, labelBarang, labelBerat, labelJumlah, labelLogo;
    ImageIcon logo;
    JButton btnDetail;

    private final DefaultComponentSetting GUI = new DefaultComponentSetting();
    private Controller con = new Controller();
    
    public MenuLihatOrderKurir(){
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new EmptyBorder(25, 50, 25, 50));
        
        ArrayList<Transaksi> daftarOrder = con.ambilDaftarOrder();
        //ArrayList<Transaksi> daftarOrder = new ArrayList<>();
        panelOrder = new JPanel[daftarOrder.size()];

        for (int i = 0; i < daftarOrder.size(); i++) {

            panelOrder[i] = new JPanel();
            panelOrder[i].setPreferredSize( new Dimension(100, 200) );
            panelOrder[i].setMaximumSize( new Dimension(Integer.MAX_VALUE, 200) );
            panelOrder[i].setBorder(new BevelBorder(1, Color.BLACK, Color.BLACK));
            panelOrder[i].setLayout(null);

            labelPengirim = GUI.defaultRegularLabel("Pengirim : " + daftarOrder.get(i).getNama_penerima());
            labelPengirim.setBounds(30,20,320,30);
            labelAlamatTujuan = GUI.defaultRegularLabel("Alamat Tujuan : " + daftarOrder.get(i).getAlamat_penerima());
            labelAlamatTujuan.setBounds(30,50,320,30);
            labelBarang = GUI.defaultRegularLabel("Barang : " + daftarOrder.get(i).getKategori_barang());
            labelBarang.setBounds(30,80,320,30);
            labelJumlah = GUI.defaultRegularLabel("Berat : " + daftarOrder.get(i).getBerat_barang() + " KG");
            labelJumlah.setBounds(30,110,320,30);
            labelBerat = GUI.defaultRegularLabel("Jumlah : " + daftarOrder.get(i).getJumlah_barang());
            labelBerat.setBounds(30,140,320,30);

            labelLogo= new JLabel();
            logo = new ImageIcon ("assets/diantar.jpg");
            labelLogo.setIcon(logo);
            labelLogo.setBounds(360, 30,100,100);

            btnDetail = GUI.defaultButton("Rincian", 16);
            btnDetail.setBounds(370, 140, 80, 30);
            btnDetail.setBorder(new BevelBorder(1, Color.BLACK, Color.BLACK));
            btnDetail.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //Button Ambil
                }
            });

            panelOrder[i].add(labelBerat);
            panelOrder[i].add(labelPengirim);
            panelOrder[i].add(labelJumlah);
            panelOrder[i].add(labelAlamatTujuan);
            panelOrder[i].add(labelBarang);
            panelOrder[i].add(labelLogo);
            panelOrder[i].add(btnDetail);

            panel.add( panelOrder[i] );
            panel.add(Box.createRigidArea(new Dimension(0, 25)));
        }
        
        //===================
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setBounds(0, 0, 600, 800);
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(600, 800));
        contentPane.add(scrollPane);

        frame = new JFrame("Transaksi");
        frame.setContentPane(contentPane);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
//        JScrollPane scrollPane = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//
//        frame = GUI.defaultFrame();
//        frame.add(panel);
    }
}
