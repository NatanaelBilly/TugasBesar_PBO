package View;

import Controller.Controller;
import Model.StatusPengiriman;
import Model.Transaksi;
import Model.User;
import Model.UserManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Date;

public class MenuBuatOrder {
    JFrame frame;
    JPanel panelPengirim, panelPenerima, panelBarang;
    JLabel labelKembali, labelJudul, labelPengirim, labelPenerima, labelBarang, labelNamaPenerima, labelNamaPengirim, labelAlamatPenerima, labelAlamatPengirim, labelNomorHPPenerima, labelNomorHPPengirim, labelTipeBarang, labelTotalBarang, labelBeratBarang, labelKesalahanBanyak, labelKesalahanBerat;
    JTextField inputNamaPengirim, inputNamaPenerima, inputLokasiPengirim, inputLokasiPenerima, inputNoHPPengirim, inputNoHPPenerima, inputBanyakBarang, inputBeratBarang;
    JButton buttonOrder;
    JComboBox inputTipeBarang;
    User user = new UserManager().getInstance().getUser();
    public MenuBuatOrder() {
        //Hyperlink Back
        labelKembali = new DefaultComponentSetting().defaultBackLabel();
        labelKembali.setVisible(true);
        labelKembali.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                new BerandaPelanggan();
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

        //Label Judul
        labelJudul = new DefaultComponentSetting().defaultHeadingLabel("Buat Order");
        labelJudul.setBounds(0, 40, 600, 30);

        // Label Pengirim
        labelPengirim = new DefaultComponentSetting().defaultRegularLabel("Pengirim");
        labelPengirim.setBounds(20, 70, 240, 30);

        //Label Penerima
        labelPenerima = new DefaultComponentSetting().defaultRegularLabel("Penerima");
        labelPenerima.setBounds(320, 70, 240, 30);

        //Label Order
        labelBarang = new DefaultComponentSetting().defaultRegularLabel("Barang");
        labelBarang.setBounds(50, 320, 500, 30);

        //Panel Pengirim
        panelPengirim = new JPanel();
        panelPengirim.setBounds(20, 100, 240, 210);
        panelPengirim.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        panelPengirim.setVisible(true);
        panelPengirim.setLayout(null);

        //Panel Penerima
        panelPenerima = new JPanel();
        panelPenerima.setBounds(320, 100, 240, 210);
        panelPenerima.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        panelPenerima.setVisible(true);
        panelPenerima.setLayout(null);

        //Panel Barang
        panelBarang = new JPanel();
        panelBarang.setBounds(50, 350, 500, 170);
        panelBarang.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        panelBarang.setVisible(true);
        panelBarang.setLayout(null);

        //Label Nama Pengirim
        labelNamaPengirim = new DefaultComponentSetting().defaultRegularLabel("Nama Pengirim");
        labelNamaPengirim.setBounds(10, 10, 215, 20);

        //Label Nama Penerima
        labelNamaPenerima = new DefaultComponentSetting().defaultRegularLabel("Nama Penerima");
        labelNamaPenerima.setBounds(10, 10, 215, 20);

        //Label Tipe Barang
        labelTipeBarang = new DefaultComponentSetting().defaultRegularLabel("Tipe Barang");
        labelTipeBarang.setBounds(10, 10, 150, 20);

        //Input Nama Pengirim
        inputNamaPengirim = new JTextField(user.getNama_depan()+" "+user.getNama_belakang());
        inputNamaPengirim.setBounds(10, 35, 215, 30);

        //Input Nama Penerima
        inputNamaPenerima = new JTextField();
        inputNamaPenerima.setBounds(10, 35, 215, 30);

        //Input Tipe Barang
        String[] tipeBarang = {"Dokumen", "Makanan", "Alat Rumah Tangga", "Alat Kecantikan", "Tipe Lain"};
        inputTipeBarang = new JComboBox(tipeBarang);
        inputTipeBarang.setBounds(225, 10, 215, 30);

        //Label Alamat Pengirim
        labelAlamatPengirim = new DefaultComponentSetting().defaultRegularLabel("Alamat Pengirim");
        labelAlamatPengirim.setBounds(10, 75, 215, 20);

        //Label Alamat Penerima
        labelAlamatPenerima = new DefaultComponentSetting().defaultRegularLabel("Alamat Penerima");
        labelAlamatPenerima.setBounds(10, 75, 215, 20);

        //Label total Item
        labelTotalBarang = new DefaultComponentSetting().defaultRegularLabel("Total");
        labelTotalBarang.setBounds(10, 60, 150, 20);

        //Input Alamat Pengirim
        inputLokasiPengirim = new JTextField();
        inputLokasiPengirim.setBounds(10, 100, 215, 30);

        //Input Alamat Penerima
        inputLokasiPenerima = new JTextField();
        inputLokasiPenerima.setBounds(10, 100, 215, 30);

        //Input Total Barang -> only accept number
        inputBanyakBarang = new JTextField();
        inputBanyakBarang.setBounds(225, 60, 215, 30);
        inputBanyakBarang.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                String value = inputBanyakBarang.getText();
                int l = value.length();
                if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9') {
                    labelKesalahanBanyak.setText("");
                } else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    labelKesalahanBanyak.setText("");
                } else {
                    labelKesalahanBanyak.setText("Harap masukkan angka.");
                }
            }
        });

        //Label Kesalahan Berat
        labelKesalahanBanyak = new DefaultComponentSetting().defaultRegularLabel("");
        labelKesalahanBanyak.setBounds(10, 90, 215, 20);
        labelKesalahanBanyak.setForeground(Color.RED);

        //Label no HP
        labelNomorHPPengirim = new DefaultComponentSetting().defaultRegularLabel("Nomor HP Pengirim");
        labelNomorHPPengirim.setBounds(10, 140, 215, 20);

        labelNomorHPPenerima = new DefaultComponentSetting().defaultRegularLabel("Nomor HP Penerima");
        labelNomorHPPenerima.setBounds(10, 140, 215, 20);

        labelBeratBarang = new DefaultComponentSetting().defaultRegularLabel("Berat Barang");
        labelBeratBarang.setBounds(10, 110, 150, 30);

        //Input no HP
        inputNoHPPengirim = new JTextField(user.getNoHp());
        inputNoHPPengirim.setBounds(10, 165, 215, 30);


        inputNoHPPenerima = new JTextField();
        inputNoHPPenerima.setBounds(10, 165, 215, 30);

        inputBeratBarang = new JTextField();
        inputBeratBarang.setBounds(225, 110, 215, 30);
        inputBeratBarang.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                String value = inputBeratBarang.getText();
                int l = value.length();
                if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9') {
                    labelKesalahanBerat.setText("");
                } else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    labelKesalahanBerat.setText("");
                } else {
                    labelKesalahanBerat.setText("Harap masukkan angka.");
                }
            }
        });

        //Label Kesalahan input Berat
        labelKesalahanBerat = new DefaultComponentSetting().defaultRegularLabel("");
        labelKesalahanBerat.setForeground(Color.RED);
        labelKesalahanBerat.setBounds(10, 140, 215, 30);

        //button Order
        buttonOrder = new DefaultComponentSetting().defaultButton("Order", 16);
        buttonOrder.setBounds(230, 550, 140, 30);
        buttonOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idTransaksi = 0;
                int idPelanggan = user.getId_user();
                int idKurir = 0;
                String kategoriBarang = String.valueOf(inputTipeBarang.getSelectedItem());
                double beratBarang = Double.valueOf(inputBeratBarang.getText());
                double banyakBarang = Double.valueOf(inputBanyakBarang.getText());
                String namaPengirim = inputNamaPengirim.getText();
                String alamatPengirim = inputLokasiPengirim.getText();
                String noHPPengirim = inputNoHPPengirim.getText();
                String namaPenerima = inputNamaPenerima.getText();
                String alamatPenerima = inputLokasiPenerima.getText();
                System.out.println("alamat penerima disini: "+alamatPenerima);
                System.out.println("alamat pengirim disini: "+alamatPengirim);
                String noHPPenerima = inputNoHPPenerima.getText();



                if(beratBarang*banyakBarang>20){
                    JOptionPane.showMessageDialog(null,"Maaf, berat barang yang anda masukkan melebihi batas yang kami tentukan.");
                } else {
                    double totalPembayaran=10000;
                    if(beratBarang<3){
                        totalPembayaran+=10000;
                    } else if(beratBarang<8){
                        totalPembayaran+=15000;
                    } else {
                        totalPembayaran+=25000;
                    }
                    int statusPemesanan = StatusPengiriman.MENUNGGU_KURIR;
                    long millis=System.currentTimeMillis();
                    Date tanggal = new java.sql.Date(millis);
                    String saranDriver = null;

                    Transaksi transaksi = new Transaksi(idTransaksi,idPelanggan,idKurir,kategoriBarang,beratBarang,banyakBarang,namaPengirim,alamatPengirim,noHPPengirim,namaPenerima,alamatPenerima,noHPPenerima,totalPembayaran,statusPemesanan,tanggal,saranDriver,null);
                    System.out.println(transaksi.getStatus_pemesanan());;
                    System.out.println("alamat penerima: "+transaksi.getAlamat_penerima());
                    System.out.println("alamat pengirim: "+transaksi.getAlamat_pengirim());
                    Controller c = new Controller();
                    boolean transaksiTerbuat = c.buatTransaksi(transaksi);
                    if(transaksiTerbuat){
                        JOptionPane.showMessageDialog(null, "Transaksi Terbuat!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Transaksi gagal terbuat. Coba lagi");
                    }

                }

            }
        });


        //Frame
        frame = new DefaultComponentSetting().defaultFrame();

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
        panelBarang.add(labelKesalahanBanyak);
        panelBarang.add(labelBeratBarang);
        panelBarang.add(labelKesalahanBerat);
        panelBarang.add(inputTipeBarang);
        panelBarang.add(inputBanyakBarang);
        panelBarang.add(inputBeratBarang);

        //Add Panel to Frame
        frame.add(labelJudul);
        frame.add(labelKembali);
        frame.add(labelPengirim);
        frame.add(labelPenerima);
        frame.add(labelBarang);
        frame.add(panelPengirim);
        frame.add(panelPenerima);
        frame.add(panelBarang);
        frame.add(buttonOrder);
    }

}
