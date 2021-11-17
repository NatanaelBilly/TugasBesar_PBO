package View;

import Model.Constant;
import Model.Pelanggan;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MenuLihatDaftarTransaksiPelanggan {
    JFrame frame;
    JPanel panel, panelTransaksi, panelMenu;
    JLabel labelKembali, labelTgl, labelPengirim, labelPenerima, labelKurir, labelTotal, labelLogo;
    ImageIcon logo;
    JButton btnDetail;
    DefaultComponentSetting GUI = new DefaultComponentSetting();

    public MenuLihatDaftarTransaksiPelanggan(Pelanggan pelanggan) {
        labelKembali = GUI.defaultBackLabel();
        labelKembali.setVisible(true);
        labelKembali.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                new BerandaPelanggan((Pelanggan) pelanggan);
            }

            @Override
            public void mousePressed(MouseEvent e) {

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

        Font fontText = new Font("Arial", Font.PLAIN, 18);
        Font fontHarga = new Font("Arial", Font.BOLD, 18);
        Font fontButton = new Font("Arial", Font.BOLD, 16);

        frame = GUI.defaultFrame();
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new EmptyBorder(30, 60, 30, 60));

//        for (int i = 0; i < 6; i++) {
//            JPanel panel1 = new JPanel();
//            panel1.setPreferredSize( new Dimension(100, 200) );
//            panel1.setBorder(new BevelBorder(1, Color.BLACK, Color.BLACK));
//            panel1.setBackground(new Color(200,200,0));
//            panel.add( panel1 );
//            panel.add(Box.createRigidArea(new Dimension(0, 25)));
//        }
//--------------------------------------------------------------------------------------------
        panelTransaksi = new JPanel();
        panelTransaksi.setPreferredSize(new Dimension(100, 200));
        panelTransaksi.setMaximumSize(new Dimension(Integer.MAX_VALUE, 200));
        panelTransaksi.setBorder(new BevelBorder(1, Color.BLACK, Color.BLACK));
//        panelTransaksi.setBackground(new Color(0,250,150));
        panelTransaksi.setLayout(null);

        labelTgl = new JLabel("12/10/2021");
        labelTgl.setBounds(30, 20, 100, 30);
        labelTgl.setFont(fontText);
        labelPengirim = new JLabel("Pengirim : Pengirim 1");
        labelPengirim.setBounds(30, 50, 320, 30);
        labelPengirim.setFont(fontText);
        labelPenerima = new JLabel("Penerima : Penerima 1");
        labelPenerima.setBounds(30, 80, 320, 30);
        labelPenerima.setFont(fontText);
        labelKurir = new JLabel("Kurir : Kurir 1");
        labelKurir.setBounds(30, 110, 320, 30);
        labelKurir.setFont(fontText);
        labelTotal = new JLabel("Total : 20000");
        labelTotal.setBounds(30, 140, 320, 30);
        labelTotal.setFont(fontHarga);

        labelLogo = new JLabel();
        logo = new ImageIcon("assets/diantar.jpg");
        labelLogo.setIcon(logo);
        labelLogo.setBounds(360, 30, 100, 100);

        btnDetail = new JButton("Detail");
        btnDetail.setBounds(370, 140, 80, 30);
        btnDetail.setFont(fontButton);
        btnDetail.setBorder(new BevelBorder(1, Color.BLACK, Color.BLACK));
        btnDetail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuLihatDetailTransaksiPelanggan();
            }
        });

        panelTransaksi.add(labelTgl);
        panelTransaksi.add(labelPengirim);
        panelTransaksi.add(labelPenerima);
        panelTransaksi.add(labelKurir);
        panelTransaksi.add(labelTotal);
        panelTransaksi.add(labelLogo);
        panelTransaksi.add(btnDetail);

        panel.add(panelTransaksi);
        panel.add(Box.createRigidArea(new Dimension(0, 25)));

//---------------------------------------------------------------------------------------------

        panelTransaksi = new JPanel();
        panelTransaksi.setPreferredSize(new Dimension(100, 200));
        panelTransaksi.setMaximumSize(new Dimension(Integer.MAX_VALUE, 200));
        panelTransaksi.setBorder(new BevelBorder(1, Color.BLACK, Color.BLACK));
//        panelTransaksi.setBackground(new Color(0,250,150));
        panelTransaksi.setLayout(null);

        labelTgl = new JLabel("16/10/2021");
        labelTgl.setBounds(30, 20, 100, 30);
        labelTgl.setFont(fontText);
        labelPengirim = new JLabel("Pengirim : Pengirim 2");
        labelPengirim.setBounds(30, 50, 320, 30);
        labelPengirim.setFont(fontText);
        labelPenerima = new JLabel("Penerima : Penerima 2");
        labelPenerima.setBounds(30, 80, 320, 30);
        labelPenerima.setFont(fontText);
        labelKurir = new JLabel("Kurir : Kurir 2");
        labelKurir.setBounds(30, 110, 320, 30);
        labelKurir.setFont(fontText);
        labelTotal = new JLabel("Total : 15000");
        labelTotal.setBounds(30, 140, 320, 30);
        labelTotal.setFont(fontHarga);

        labelLogo = new JLabel();
        logo = new ImageIcon("assets/order_selesai.jpg");
        labelLogo.setIcon(logo);
        labelLogo.setBounds(370, 40, 80, 80);

        btnDetail = new JButton("Detail");
        btnDetail.setBounds(370, 140, 80, 30);
        btnDetail.setFont(fontButton);
        btnDetail.setBorder(new BevelBorder(1, Color.BLACK, Color.BLACK));
        btnDetail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuLihatDetailTransaksiPelanggan();
            }
        });

        panelTransaksi.add(labelTgl);
        panelTransaksi.add(labelPengirim);
        panelTransaksi.add(labelPenerima);
        panelTransaksi.add(labelKurir);
        panelTransaksi.add(labelTotal);
        panelTransaksi.add(labelLogo);
        panelTransaksi.add(btnDetail);

        panel.add(panelTransaksi);
        panel.add(Box.createRigidArea(new Dimension(0, 25)));
//
//        panelTransaksi = new JPanel();
//        panelTransaksi.setPreferredSize( new Dimension(100, 200) );
//        panelTransaksi.setMaximumSize( new Dimension(Integer.MAX_VALUE, 200) );
//        panelTransaksi.setBorder(new BevelBorder(1, Color.BLACK, Color.BLACK));
//        panelTransaksi.setBackground(new Color(200,200,0));
//        panelTransaksi.setLayout(null);
//        panel.add( panelTransaksi );
//        panel.add(Box.createRigidArea(new Dimension(0, 25)));
//
//        panelTransaksi = new JPanel();
//        panelTransaksi.setPreferredSize( new Dimension(100, 200) );
//        panelTransaksi.setMaximumSize( new Dimension(Integer.MAX_VALUE, 200) );
//        panelTransaksi.setBorder(new BevelBorder(1, Color.BLACK, Color.BLACK));
//        panelTransaksi.setBackground(new Color(200,200,0));
//        panelTransaksi.setLayout(null);
//        panel.add( panelTransaksi );
//        panel.add(Box.createRigidArea(new Dimension(0, 25)));

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setBounds(0, 0, 600, 800);
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(600, 800));
        contentPane.add(scrollPane);


        frame.setContentPane(contentPane);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.add(labelKembali);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
