package View;

import Controller.Controller;
import Model.*;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class MenuLihatDaftarTransaksi {
    private JFrame frame;
    private JPanel panel, panelTransaksi;
    private JLabel labelKembali, labelTgl, labelPengirim, labelPenerima, labelKurir, labelTotal, labelLogo;
    private ImageIcon logo;
    private JButton btnDetail;
    private DefaultComponentSetting GUI = new DefaultComponentSetting();
    private Kurir kurir;
    private Controller controller = new Controller();

    private User user;

    public MenuLihatDaftarTransaksi(User user) {
        this.user = user;
        ArrayList<Transaksi> listTransaksi= controller.ambilDaftarOrder(user.getIdUser());
        System.out.println(listTransaksi.size() +  " " + listTransaksi);
        if (listTransaksi == null || listTransaksi.size() == 0) {
            JOptionPane.showMessageDialog(null, "Ordermu Kosong");
            if (user instanceof Pelanggan)
                new BerandaPelanggan((Pelanggan) user);
            else
                new BerandaKurir((Kurir) user);
        } else {
            labelKembali = GUI.defaultBackLabel();
            labelKembali.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    frame.dispose();
                    if (user instanceof Pelanggan)
                        new BerandaPelanggan((Pelanggan) user);
                    else
                        new BerandaKurir((Kurir) user);
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

            for (int i = user.getListTransaksi().size() - 1; i >= 0; i--) {
                Transaksi transaksi = listTransaksi.get(i);
                kurir = controller.ambilDataKurir(transaksi.getIdKurir());

                //Tanggal Untuk Setiap Transaksi
                labelTgl = GUI.defaultRegularLabel(String.valueOf(transaksi.getTanggal()));
                labelTgl.setBounds(30, 20, 320, 30);

                //Label Pengirim untuk Setiap Transaksi
                labelPengirim = GUI.defaultRegularLabel("Pengirim: " + transaksi.getNamaPengirim());
                labelPengirim.setBounds(30, 50, 320, 30);

                //Label Penerima
                labelPenerima = GUI.defaultRegularLabel("Penerima: " + transaksi.getNamaPenerima());
                labelPenerima.setBounds(30, 80, 320, 30);

                labelKurir = GUI.defaultRegularLabel("");
                labelKurir.setBounds(30, 110, 320, 30);

                labelTotal = GUI.defaultRegularLabel("Total: " + transaksi.getTotalPembayaran());
                labelTotal.setBounds(30, 140, 320, 30);


                btnDetail = GUI.defaultButton("Detail", 17);
                btnDetail.setBounds(330, 140, 100, 30);
                btnDetail.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame.dispose();
                        new MenuLihatDetailTransaksi(transaksi, user);
                    }
                });
                if (transaksi.getStatusPemesanan()== StatusPengiriman.MENUNGGU_KURIR) {
                    logo = new ImageIcon("assets/menunggu_kurir.jpg");
                    btnDetail.setVisible(false);
                } else if (transaksi.getStatusPemesanan()==StatusPengiriman.DIANTAR) {
                    logo = new ImageIcon("assets/diantar.jpg");
                    labelKurir.setText("Kurir: " + kurir.getNamaDepan() + " " + kurir.getNamaBelakang());
                } else {
                    logo = new ImageIcon("assets/order_selesai.jpg");
                    labelKurir.setText("Kurir: " + kurir.getNamaDepan() + " " + kurir.getNamaBelakang());
                }

                labelLogo = new JLabel();
                labelLogo.setIcon(logo);
                labelLogo.setBounds(330, 30, 100, 100);

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

}