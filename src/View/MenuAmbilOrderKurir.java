package View;

import Controller.Controller;
import Controller.KurirController;
import Model.Kurir;
import Model.Pelanggan;
import Model.Transaksi;
import Model.User;
import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MenuAmbilOrderKurir {
//    private JFrame frame;
//    private JLabel labelMenu, labelNamaPengirim, labelAlamatPengirim, labelNamaPenerima, labelAlamatPenerima, labelKategoriBarang,
//            labelBeratBarang, labelJumlahBarang, labelHPPengirim, labelHPPenerima, labelTotalBayar;

    
    private JFrame frame;
    private JPanel panelPengirim, panelPenerima, panelBarang;
    private JLabel labelJudul, labelPengirim, labelPenerima, labelBarang, labelNamaPenerima, labelNamaPengirim, labelAlamatPenerima, labelAlamatPengirim, labelNomorHPPenerima, labelNomorHPPengirim, labelTipeBarang, labelTotalBarang, labelBeratBarang;
    private JTextField inputNamaPengirim, inputTipeBarang, inputNamaPenerima, inputLokasiPengirim, inputLokasiPenerima, inputNoHPPengirim, inputNoHPPenerima, inputBanyakBarang, inputBeratBarang;
    
    private Controller con = new Controller();
    private final DefaultComponentSetting GUI = new DefaultComponentSetting();

    private Kurir kurir;
    private User pelanggan;
    public MenuAmbilOrderKurir(Transaksi transaksi,Kurir kurir) {
        
        this.kurir = kurir;
        pelanggan = con.ambilDataUser(transaksi.getIdPelanggan());
        
        //Label Judul
        labelJudul = GUI.defaultHeadingLabel("Ambil Order");
        labelJudul.setBounds(0, 40, 600, 30);

        // Label Pengirim
        labelPengirim = GUI.defaultRegularLabel("Pengirim");
        labelPengirim.setBounds(10, 100, 240, 30);

        //Label Penerima
        labelPenerima = GUI.defaultRegularLabel("Penerima");
        labelPenerima.setBounds(305, 100, 240, 30);

        //Label Order
        labelBarang = GUI.defaultRegularLabel("Barang");
        labelBarang.setBounds(10, 360, 500, 30);

        //Panel Pengirim
        panelPengirim = new JPanel();
        panelPengirim.setBounds(10, 130, 270, 210);
        panelPengirim.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        panelPengirim.setVisible(true);
        panelPengirim.setLayout(null);
        panelPengirim.setBackground(GUI.backGroundColor());

        //Panel Penerima
        panelPenerima = new JPanel();
        panelPenerima.setBounds(305, 130, 270, 210);
        panelPenerima.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        panelPenerima.setVisible(true);
        panelPenerima.setLayout(null);
        panelPenerima.setBackground(GUI.backGroundColor());

        //Panel Barang
        panelBarang = new JPanel();
        panelBarang.setBounds(10, 390, 565, 170);
        panelBarang.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        panelBarang.setVisible(true);
        panelBarang.setLayout(null);
        panelBarang.setBackground(GUI.backGroundColor());

        //Label Nama Pengirim
        labelNamaPengirim = GUI.defaultRegularLabel("Nama Pengirim");
        labelNamaPengirim.setBounds(10, 10, 215, 20);

        //Label Nama Penerima
        labelNamaPenerima = GUI.defaultRegularLabel("Nama Penerima");
        labelNamaPenerima.setBounds(10, 10, 215, 20);

        //Label Tipe Barang
        labelTipeBarang = GUI.defaultRegularLabel("Tipe Barang");
        labelTipeBarang.setBounds(10, 10, 150, 20);

        //Input Nama Pengirim
        inputNamaPengirim = new JTextField(pelanggan.getNamaDepan() + " " + pelanggan.getNamaBelakang());
        inputNamaPengirim.setBounds(10, 35, 215, 30);
        inputNamaPengirim.setText(transaksi.getNamaPengirim());
        inputNamaPengirim.setEditable(false);

        //Input Nama Penerima
        inputNamaPenerima = new JTextField();
        inputNamaPenerima.setBounds(10, 35, 215, 30);
        inputNamaPenerima.setText(transaksi.getNamaPenerima());
        inputNamaPenerima.setEditable(false);

        //Input Tipe Barang
         inputTipeBarang = new JTextField();
        inputTipeBarang.setBounds(225, 10, 280, 30);
        inputTipeBarang.setText(transaksi.getKategoriBarang());
        inputTipeBarang.setEditable(false);

        //Label Alamat Pengirim
        labelAlamatPengirim = GUI.defaultRegularLabel("Alamat Pengirim");
        labelAlamatPengirim.setBounds(10, 75, 215, 20);

        //Label Alamat Penerima
        labelAlamatPenerima = GUI.defaultRegularLabel("Alamat Penerima");
        labelAlamatPenerima.setBounds(10, 75, 215, 20);

        //Label total Item
        labelTotalBarang = GUI.defaultRegularLabel("Total");
        labelTotalBarang.setBounds(10, 60, 150, 20);

        //Input Alamat Pengirim
        inputLokasiPengirim = new JTextField();
        inputLokasiPengirim.setBounds(10, 100, 215, 30);
        inputLokasiPengirim.setText(transaksi.getAlamatPengirim());
        inputLokasiPengirim.setEditable(false);

        //Input Alamat Penerima
        inputLokasiPenerima = new JTextField();
        inputLokasiPenerima.setBounds(10, 100, 215, 30);
        inputLokasiPenerima.setText(transaksi.getAlamatPenerima());
        inputLokasiPenerima.setEditable(false);

        //Input Total Barang -> only accept number
        inputBanyakBarang = new JTextField();
        inputBanyakBarang.setBounds(225, 60, 280, 30);
        inputBanyakBarang.setText("" + transaksi.getJumlahBarang());
        inputBanyakBarang.setEditable(false);
        

        //Label no HP
        labelNomorHPPengirim = GUI.defaultRegularLabel("Nomor HP Pengirim");
        labelNomorHPPengirim.setBounds(10, 140, 215, 20);

        labelNomorHPPenerima = GUI.defaultRegularLabel("Nomor HP Penerima");
        labelNomorHPPenerima.setBounds(10, 140, 215, 20);

        labelBeratBarang = GUI.defaultRegularLabel("Berat Barang(kg)");
        labelBeratBarang.setBounds(10, 110, 150, 30);

        //Input no HP
        inputNoHPPengirim = new JTextField(pelanggan.getNoHp());
        inputNoHPPengirim.setBounds(10, 165, 215, 30);
        inputNoHPPengirim.setText(transaksi.getNoHpPengirim());
        inputNoHPPengirim.setEditable(false);

        inputNoHPPenerima = new JTextField();
        inputNoHPPenerima.setBounds(10, 165, 215, 30);
        inputNoHPPenerima.setText(transaksi.getNoHpPenerima());
        inputNoHPPenerima.setEditable(false);

        inputBeratBarang = new JTextField();
        inputBeratBarang.setBounds(225, 110, 280, 30);
        inputBeratBarang.setText(""+transaksi.getBeratBarang());
        inputBeratBarang.setEditable(false);
        
        
        
        
        
        
//
//        //Menu
//        labelMenu = GUI.defaultHeadingLabel("Rincian Order");
//        labelMenu.setBounds(200, 25, 200, 50);
//
//        //Label Keterangan
//        labelKategoriBarang = GUI.defaultRegularLabel("Kategori Barang : " + transaksi.getKategoriBarang());
//        labelKategoriBarang.setBounds(100, 100, 200, 40);
//
//        labelBeratBarang = GUI.defaultRegularLabel("Berat Barang : " + transaksi.getBeratBarang() + " KG");
//        labelBeratBarang.setBounds(100, 125, 200, 40);
//
//        labelJumlahBarang = GUI.defaultRegularLabel("Jumlah Barang : " + transaksi.getJumlahBarang());
//        labelJumlahBarang.setBounds(100, 150, 200, 40);
//
//        labelNamaPengirim = GUI.defaultRegularLabel("Nama Pengirim : " + transaksi.getNamaPengirim());
//        labelNamaPengirim.setBounds(100, 175, 200, 40);
//
//        labelHPPengirim = GUI.defaultRegularLabel("No Telepon Pengirim : " + transaksi.getNoHpPengirim());
//        labelHPPengirim.setBounds(100, 200, 200, 40);
//
//        labelAlamatPengirim = GUI.defaultRegularLabel("Alamat Pengirim : " + transaksi.getAlamatPengirim());
//        labelAlamatPengirim.setBounds(100, 225, 200, 40);
//
//        labelNamaPenerima = GUI.defaultRegularLabel("Nama Penerima : " + transaksi.getNamaPenerima());
//        labelNamaPenerima.setBounds(100, 250, 200, 40);
//
//        labelHPPenerima = GUI.defaultRegularLabel("No Telepon Penerima : " + transaksi.getNoHpPenerima());
//        labelHPPenerima.setBounds(100, 275, 300, 40);
//
//        labelAlamatPenerima = GUI.defaultRegularLabel("Alamat Penerima : " + transaksi.getAlamatPenerima());
//        labelAlamatPenerima.setBounds(100, 300, 200, 40);
//
//        labelTotalBayar = GUI.defaultRegularLabel("Total Pembayaran : " + transaksi.getTotalPembayaran());
//        labelTotalBayar.setBounds(100, 325, 325, 40);


        //Button Edit
        JButton btnAmbilOrder = GUI.defaultButton("Ambil Order", 20);
        btnAmbilOrder.setBounds(200, 600, 200, 50);
        btnAmbilOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ambilOrderan(transaksi.getIdTransaksi())) {
                    frame.dispose();
                    kurir.getListTransaksi().add(new Controller().ambilSuatuOrder(transaksi.getIdTransaksi()));
                    kurir.setKetersediaan(1);
                    new BerandaKurir(kurir);
                }
            }
        });


        //Link Kembali
        JLabel labelKembali = GUI.defaultBackLabel();
        labelKembali.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                new MenuLihatOrderKurir(kurir);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                frame.dispose();
                new MenuLihatOrderKurir(kurir);
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


        //Frame
        frame = GUI.defaultFrame();

//        frame.add(labelMenu);
//        frame.add(labelNamaPengirim);
//        frame.add(labelHPPengirim);
//        frame.add(labelAlamatPengirim);
//        frame.add(labelNamaPenerima);
//        frame.add(labelHPPenerima);
//        frame.add(labelAlamatPenerima);
//        frame.add(labelKategoriBarang);
//        frame.add(labelBeratBarang);
//        frame.add(labelJumlahBarang);
//        frame.add(labelTotalBayar);

//        frame.add(btnEditProfile);
//        frame.add(labelKembali);

        //Frame
        frame = new DefaultComponentSetting().defaultFrame();
        frame.getContentPane().setBackground(GUI.backGroundColor());

        //Add To Panel
        panelPengirim.add(labelNamaPengirim);
        panelPengirim.add(labelAlamatPengirim);
        panelPengirim.add(labelNomorHPPengirim);
        panelPengirim.add(inputNamaPengirim);
        panelPengirim.add(inputLokasiPengirim);
        panelPengirim.add(inputNoHPPengirim);

        //Add to panel penerima
        panelPenerima.add(labelNamaPenerima);
        panelPenerima.add(labelAlamatPenerima);
        panelPenerima.add(labelNomorHPPenerima);
        panelPenerima.add(inputNamaPenerima);
        panelPenerima.add(inputLokasiPenerima);
        panelPenerima.add(inputNoHPPenerima);

        //Add to panel barang
        panelBarang.add(labelTipeBarang);
        panelBarang.add(labelTotalBarang);
        panelBarang.add(labelBeratBarang);
        panelBarang.add(inputTipeBarang);
        panelBarang.add(inputBanyakBarang);
        panelBarang.add(inputBeratBarang);

        //Add Panel to Frame
        frame.add(labelJudul);
        frame.add(labelKembali);
        frame.add(labelPengirim);
        frame.add(labelPenerima);
        frame.add(labelBarang);
        frame.add(btnAmbilOrder);
        frame.add(panelPengirim);
        frame.add(panelPenerima);
        frame.add(panelBarang);

    }

    private boolean ambilOrderan(int idTransaksi) {
        //Cek Konfirmasi
        int konfirmasi = JOptionPane.showConfirmDialog(null, "Ingin Mengambil Orderan Ini ?");

        if (konfirmasi == 0) {
            if (new KurirController().ambilOrderOlehKurir(idTransaksi, kurir.getIdUser())) {
                if (new KurirController().ubahKetersediaanKurir(kurir.getIdUser(), 1)) {
                    JOptionPane.showMessageDialog(null, "Berhasil Mengambil Order.");
                    return true;
                } else
                    JOptionPane.showMessageDialog(null, "Mohon Maaf, Telah Terjadi Kesalahan.");
            } else {
                JOptionPane.showMessageDialog(null, "Mohon Maaf, Telah Terjadi Kesalahan.");
            }
        }
        return false;
    }

}
