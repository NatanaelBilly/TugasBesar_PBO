package View;

import Model.Pelanggan;
import Model.Transaksi;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MenuLihatDaftarTransaksiPelanggan {
    private JFrame frame;
    private JPanel panel, panelTransaksi;
    private JLabel labelKembali, labelTgl, labelPengirim, labelPenerima, labelKurir, labelTotal, labelLogo;
    private ImageIcon logo;
    private JButton btnDetail;
    private DefaultComponentSetting GUI = new DefaultComponentSetting();

    public MenuLihatDaftarTransaksiPelanggan(Pelanggan pelanggan) {
        labelKembali = GUI.defaultBackLabel();
        labelKembali.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                new BerandaPelanggan(pelanggan);
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

        frame = GUI.defaultFrame();
        panel = new JPanel();
        frame.add(panel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new EmptyBorder(30, 60, 30, 60));
        panel.setBounds(0, 100, 600, 800);
        panel.setBackground(GUI.backGroundColor());
        panel.add(labelKembali);
        panel.setVisible(true);

        for (int i = 0; i < pelanggan.getListTransaksi().size(); i++) {
            Transaksi transaksi = pelanggan.getListTransaksi().get(i);

            //Tanggal Untuk Setiap Transaksi
            labelTgl = GUI.defaultRegularLabel(String.valueOf(transaksi.getTanggal()));
            labelTgl.setBounds(30, 20, 320, 30);

            //Label Pengirim untuk Setiap Transaksi
            labelPengirim = GUI.defaultRegularLabel("Pengirim: " + transaksi.getNamaPengirim());
            labelPengirim.setBounds(30, 50, 320, 30);

            //Label Penerima
            labelPenerima = GUI.defaultRegularLabel("Penerima: " + transaksi.getNamaPenerima());
            labelPenerima.setBounds(30, 80, 320, 30);

            labelKurir = GUI.defaultRegularLabel("Kurir: kurir");
            labelKurir.setBounds(30, 110, 320, 30);

            labelTotal = GUI.defaultRegularLabel("Total: " + transaksi.getTotalPembayaran());
            labelTotal.setBounds(30, 140, 320, 30);

            labelLogo = new JLabel();
            if (transaksi.getStatusPemesanan().equalsIgnoreCase("MENUNGGU KURIR")) {
                logo = new ImageIcon("assets/menunggu_kurir.jpg");
            } else if (transaksi.getStatusPemesanan().equalsIgnoreCase("diantar")) {
                logo = new ImageIcon("assets/diantar.jpg");
            } else {
                logo = new ImageIcon("assets/order_selesai.jpg");
            }

            labelLogo.setIcon(logo);
            labelLogo.setBounds(330,30,100,100);

            btnDetail = GUI.defaultButton("Detail", 17);
            btnDetail.setBounds(330, 140, 100, 30);
            btnDetail.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                    new MenuLihatDetailTransaksiPelanggan(transaksi, pelanggan);
                }
            });

            panelTransaksi = new JPanel();
            panelTransaksi.setPreferredSize(new Dimension(100, 200));
            panelTransaksi.setMaximumSize(new Dimension(Integer.MAX_VALUE, 200));
            panelTransaksi.setBorder(new BevelBorder(1, Color.BLACK, Color.BLACK));
            panelTransaksi.setLayout(null);
            panelTransaksi.setVisible(true);
            panelTransaksi.setBackground(GUI.backGroundColor());

            panelTransaksi.add(labelTgl);
            panelTransaksi.add(labelPengirim);
            panelTransaksi.add(labelPenerima);
            panelTransaksi.add(labelKurir);
            panelTransaksi.add(labelTotal);
            panelTransaksi.add(labelLogo);
            panelTransaksi.add(btnDetail);

            panel.add(panelTransaksi);
            panel.add(Box.createRigidArea(new Dimension(0, 25)));
        }

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setBounds(0, 0, 600, 800);
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(600, 800));
        contentPane.add(scrollPane);

        frame.setContentPane(contentPane);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

}
