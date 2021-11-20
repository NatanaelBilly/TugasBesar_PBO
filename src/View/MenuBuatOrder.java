package View;

import Controller.Controller;
import Model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Date;
import java.util.ArrayList;

public class MenuBuatOrder {
    private JFrame frame;
    private JPanel panelPengirim, panelPenerima, panelBarang;
    private JLabel labelKembali, labelJudul, labelPengirim, labelPenerima, labelBarang, labelNamaPenerima, labelNamaPengirim, labelAlamatPenerima, labelAlamatPengirim, labelNomorHPPenerima, labelNomorHPPengirim, labelTipeBarang, labelTotalBarang, labelBeratBarang;
    private JTextField inputNamaPengirim, inputNamaPenerima, inputLokasiPengirim, inputLokasiPenerima, inputNoHPPengirim, inputNoHPPenerima, inputBanyakBarang, inputBeratBarang;
    private JButton buttonOrder;
    private JComboBox inputTipeBarang;
    private DefaultComponentSetting GUI = new DefaultComponentSetting();

    public MenuBuatOrder(Pelanggan pelanggan) {
        //Hyperlink Back
        labelKembali = new DefaultComponentSetting().defaultBackLabel();
        labelKembali.setVisible(true);
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

        //Label Judul
        labelJudul = GUI.defaultHeadingLabel("Buat Order");
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

        //Input Nama Penerima
        inputNamaPenerima = new JTextField();
        inputNamaPenerima.setBounds(10, 35, 215, 30);

        //Input Tipe Barang
        String[] tipeBarang = {"Dokumen", "Makanan", "Alat Rumah Tangga", "Alat Kecantikan", "Tipe Lain"};
        inputTipeBarang = new JComboBox(tipeBarang);
        inputTipeBarang.setBounds(225, 10, 280, 30);

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

        //Input Alamat Penerima
        inputLokasiPenerima = new JTextField();
        inputLokasiPenerima.setBounds(10, 100, 215, 30);

        //Input Total Barang -> only accept number
        inputBanyakBarang = new JTextField();
        inputBanyakBarang.setBounds(225, 60, 280, 30);
        inputBanyakBarang.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                String falseInput = "";
                if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9') {
                    falseInput = "";
                } else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE || e.getKeyChar() == '.') {
                    falseInput = "";
                } else if (e.getKeyChar() == ',') {
                    falseInput = "Harap Gunakan Titik(.)";
                    JOptionPane.showMessageDialog(null, falseInput);
                    inputBeratBarang.setText("");
                } else {
                    falseInput = "Masukkan Hanya Angka";
                    JOptionPane.showMessageDialog(null, falseInput);
                    inputBeratBarang.setText("");
                }
            }
        });

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

        inputNoHPPenerima = new JTextField();
        inputNoHPPenerima.setBounds(10, 165, 215, 30);

        inputBeratBarang = new JTextField();
        inputBeratBarang.setBounds(225, 110, 280, 30);
        inputBeratBarang.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                String falseInput = "";
                if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9') {
                    falseInput = "";
                } else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE || e.getKeyChar() == '.') {
                    falseInput = "";
                } else if (e.getKeyChar() == ',') {
                    falseInput = "Harap Gunakan Titik(.)";
                    JOptionPane.showMessageDialog(null, falseInput);
                    inputBeratBarang.setText("");
                } else {
                    falseInput = "Masukkan Hanya Angka";
                    JOptionPane.showMessageDialog(null, falseInput);
                    inputBeratBarang.setText("");
                }
            }
        });

        //button Order
        buttonOrder = GUI.defaultButton("Order", 16);
        buttonOrder.setBounds(230, 590, 140, 40);
        buttonOrder.addActionListener(e -> {
            int idTransaksi = 0;
            int idPelanggan = pelanggan.getIdUser();
            int idKurir = 0;
            String kategoriBarang = String.valueOf(inputTipeBarang.getSelectedItem());
            String namaPengirim = inputNamaPengirim.getText();
            String alamatPengirim = inputLokasiPengirim.getText();
            String noHPPengirim = inputNoHPPengirim.getText();
            String namaPenerima = inputNamaPenerima.getText();
            String alamatPenerima = inputLokasiPenerima.getText();
            String noHPPenerima = inputNoHPPenerima.getText();
            if (namaPengirim.isEmpty() || namaPenerima.isEmpty() || alamatPenerima.isEmpty() || alamatPengirim.isEmpty() || noHPPenerima.isEmpty() || noHPPengirim.isEmpty() || inputBeratBarang.getText().isEmpty() || inputBanyakBarang.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, Constant.ERROR_MESSAGE);
            } else {
                double beratBarang = Double.parseDouble(inputBeratBarang.getText());
                double banyakBarang = Double.parseDouble(inputBanyakBarang.getText());
                if (beratBarang * banyakBarang > 20) {
                    JOptionPane.showMessageDialog(null, "Maaf, berat barang yang anda masukkan melebihi batas yang kami tentukan.");
                } else {
                    double totalPembayaran = 10000;
                    if (beratBarang < 3) {
                        totalPembayaran += 10000;
                    } else if (beratBarang < 8) {
                        totalPembayaran += 15000;
                    } else {
                        totalPembayaran += 25000;
                    }
                    if (pelanggan.getSaldo() < totalPembayaran) {
                        JOptionPane.showMessageDialog(null, "Maaf, saldo kamu tidak cukup");
                    } else {
                        int statusPemesanan = StatusPengiriman.MENUNGGU_KURIR;
                        long millis = System.currentTimeMillis();
                        Date tanggal = new Date(millis);
                        String saranDriver = null;

                        int buatTransaksi = JOptionPane.showConfirmDialog(null, "Saldo kamu akan terpotong sebesar " + totalPembayaran + " otomatis. Lanjutkan Pembayaran?");

                        if (buatTransaksi == JOptionPane.YES_OPTION) {
                            Transaksi transaksi = new Transaksi(idTransaksi, idPelanggan, idKurir, kategoriBarang, beratBarang, banyakBarang, namaPengirim, alamatPengirim, noHPPengirim, namaPenerima, alamatPenerima, noHPPenerima, totalPembayaran, statusPemesanan, tanggal, saranDriver, null);
                            Controller c = new Controller();
                            boolean transaksiTerbuat = c.buatTransaksi(transaksi);
                            if (transaksiTerbuat) {
                                double saldoSekarang = c.bayarOrder(pelanggan.getIdUser(), transaksi.getTotalPembayaran());
                                pelanggan.setSaldo(saldoSekarang);
                                pelanggan.getListTransaksi().add(transaksi);
                                JOptionPane.showMessageDialog(null, "Transaksi Terbuat! Saldo kamu kini tinggal " + pelanggan.getSaldo());
                                frame.dispose();
                                new BerandaPelanggan(pelanggan);
                            } else {
                                JOptionPane.showMessageDialog(null, "Transaksi gagal terbuat. Coba lagi");
                            }
                        }
                    }

                }
            }

        });


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
        frame.add(panelPengirim);
        frame.add(panelPenerima);
        frame.add(panelBarang);
        frame.add(buttonOrder);
    }
}
