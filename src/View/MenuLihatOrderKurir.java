package View;

import Controller.Controller;
import Model.Kurir;
import Model.Transaksi;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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

public class MenuLihatOrderKurir {
    private JFrame frame;
    private JPanel panel;
    private JPanel[] panelOrder;
    private JLabel labelPengirim,labelAlamatTujuan, labelBarang, labelBerat, labelJumlah, labelLogo;
    private ImageIcon logo;
    private JButton btnDetail;
    private final DefaultComponentSetting GUI = new DefaultComponentSetting();
    private Controller con = new Controller();
    
    public MenuLihatOrderKurir(Kurir kurir){
        //Link Kembali
        JLabel labelKembali = GUI.defaultBackLabel();
        labelKembali.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                new BerandaKurir(kurir);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                frame.dispose();
                new BerandaKurir(kurir);
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
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new EmptyBorder(25, 50, 25, 50));
        panel.add(labelKembali);
        panel.setBackground(GUI.backGroundColor());

        ArrayList<Transaksi> daftarSemuaOrder = con.ambilDaftarOrder();
        ArrayList<Transaksi> daftarOrder = con.ambilDaftarOrderMenunggu(daftarSemuaOrder);
        panelOrder = new JPanel[daftarOrder.size()];

        for (int i = 0; i < daftarOrder.size(); i++) {
            Transaksi thisOrder = daftarOrder.get(i);
            panelOrder[i] = new JPanel();
            panelOrder[i].setPreferredSize( new Dimension(100, 200) );
            panelOrder[i].setMaximumSize( new Dimension(Integer.MAX_VALUE, 200) );
            panelOrder[i].setBorder(new BevelBorder(1, Color.BLACK, Color.BLACK));
            panelOrder[i].setLayout(null);

            labelPengirim = GUI.defaultRegularLabel("Pengirim : " + daftarOrder.get(i).getNamaPengirim());
            labelPengirim.setBounds(30,20,320,30);
            labelAlamatTujuan = GUI.defaultRegularLabel("Alamat Tujuan : " + daftarOrder.get(i).getAlamatPenerima());
            labelAlamatTujuan.setBounds(30,50,320,30);
            labelBarang = GUI.defaultRegularLabel("Barang : " + daftarOrder.get(i).getKategoriBarang());
            labelBarang.setBounds(30,80,320,30);
            labelJumlah = GUI.defaultRegularLabel("Berat : " + daftarOrder.get(i).getBeratBarang() + " KG");
            labelJumlah.setBounds(30,110,320,30);
            labelBerat = GUI.defaultRegularLabel("Jumlah : " + daftarOrder.get(i).getJumlahBarang());
            labelBerat.setBounds(30,140,320,30);

            labelLogo= new JLabel();
            logo = new ImageIcon ("assets/menunggu_kurir.jpg");
            labelLogo.setIcon(logo);
            labelLogo.setBounds(360, 30,100,100);

            btnDetail = GUI.defaultButton("Rincian", 16);
            btnDetail.setBounds(370, 140, 80, 30);
            btnDetail.setBorder(new BevelBorder(1, Color.BLACK, Color.BLACK));
            btnDetail.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //Button Ambil
                    frame.dispose();
                    new MenuAmbilOrderKurir(thisOrder, kurir);
                }
            });

            panelOrder[i].add(labelBerat);
            panelOrder[i].add(labelPengirim);
            panelOrder[i].add(labelJumlah);
            panelOrder[i].add(labelAlamatTujuan);
            panelOrder[i].add(labelBarang);
            panelOrder[i].add(labelLogo);
            panelOrder[i].add(btnDetail);
            panelOrder[i].setBackground(GUI.backGroundColor());

            panel.add( panelOrder[i] );
            panel.add(Box.createRigidArea(new Dimension(0, 25)));
        }

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setBounds(0, 0, 600, 800);
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(600, 800));
        contentPane.add(scrollPane);

        frame = GUI.defaultFrame();
        frame.setContentPane(contentPane);
        frame.pack();
        frame.getContentPane().setBackground(GUI.backGroundColor());
    }
}
