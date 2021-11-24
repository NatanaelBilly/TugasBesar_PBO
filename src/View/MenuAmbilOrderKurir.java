package View;

import Controller.Controller;
import Controller.KurirController;
import Model.Kurir;
import Model.Transaksi;
import Model.User;

import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MenuAmbilOrderKurir {
    private JFrame frame;
    private JPanel panelPengirim, panelPenerima, panelBarang;
    private JLabel labelJudul, labelPengirim, labelPenerima, labelBarang, labelNamaPenerima, labelNamaPengirim, labelAlamatPenerima, labelAlamatPengirim, labelNomorHPPenerima, labelNomorHPPengirim, labelTipeBarang, labelTotalBarang, labelBeratBarang;
    private JTextField inputNamaPengirim, inputTipeBarang, inputNamaPenerima, inputLokasiPengirim, inputLokasiPenerima, inputNoHPPengirim, inputNoHPPenerima, inputBanyakBarang, inputBeratBarang;

    private Controller con = new Controller();
    private final DefaultComponentSetting GUI = new DefaultComponentSetting();

    private Kurir kurir;
    private User pelanggan;

    public MenuAmbilOrderKurir(Transaksi transaksi, Kurir kurir) {

        this.kurir = kurir;
        pelanggan = con.ambilDataUser(transaksi.getIdPelanggan());

        labelJudul = GUI.defaultHeadingLabel("Ambil Order");
        labelJudul.setBounds(0, 40, 600, 30);

        labelPengirim = GUI.defaultRegularLabel("Pengirim");
        labelPengirim.setBounds(10, 100, 240, 30);

        labelPenerima = GUI.defaultRegularLabel("Penerima");
        labelPenerima.setBounds(305, 100, 240, 30);

        labelBarang = GUI.defaultRegularLabel("Barang");
        labelBarang.setBounds(10, 360, 500, 30);

        panelPengirim = new JPanel();
        panelPengirim.setBounds(10, 130, 270, 210);
        panelPengirim.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        panelPengirim.setVisible(true);
        panelPengirim.setLayout(null);
        panelPengirim.setBackground(GUI.backGroundColor());

        panelPenerima = new JPanel();
        panelPenerima.setBounds(305, 130, 270, 210);
        panelPenerima.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        panelPenerima.setVisible(true);
        panelPenerima.setLayout(null);
        panelPenerima.setBackground(GUI.backGroundColor());

        panelBarang = new JPanel();
        panelBarang.setBounds(10, 390, 565, 170);
        panelBarang.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        panelBarang.setVisible(true);
        panelBarang.setLayout(null);
        panelBarang.setBackground(GUI.backGroundColor());

        labelNamaPengirim = GUI.defaultRegularLabel("Nama Pengirim");
        labelNamaPengirim.setBounds(10, 10, 215, 20);

        labelNamaPenerima = GUI.defaultRegularLabel("Nama Penerima");
        labelNamaPenerima.setBounds(10, 10, 215, 20);

        labelTipeBarang = GUI.defaultRegularLabel("Tipe Barang");
        labelTipeBarang.setBounds(10, 10, 150, 20);

        inputNamaPengirim = new JTextField(pelanggan.getNamaDepan() + " " + pelanggan.getNamaBelakang());
        inputNamaPengirim.setBounds(10, 35, 215, 30);
        inputNamaPengirim.setText(transaksi.getNamaPengirim());
        inputNamaPengirim.setEditable(false);

        inputNamaPenerima = new JTextField();
        inputNamaPenerima.setBounds(10, 35, 215, 30);
        inputNamaPenerima.setText(transaksi.getNamaPenerima());
        inputNamaPenerima.setEditable(false);

        inputTipeBarang = new JTextField();
        inputTipeBarang.setBounds(225, 10, 280, 30);
        inputTipeBarang.setText(transaksi.getKategoriBarang());
        inputTipeBarang.setEditable(false);

        labelAlamatPengirim = GUI.defaultRegularLabel("Alamat Pengirim");
        labelAlamatPengirim.setBounds(10, 75, 215, 20);

        labelAlamatPenerima = GUI.defaultRegularLabel("Alamat Penerima");
        labelAlamatPenerima.setBounds(10, 75, 215, 20);

        labelTotalBarang = GUI.defaultRegularLabel("Total");
        labelTotalBarang.setBounds(10, 60, 150, 20);

        inputLokasiPengirim = new JTextField();
        inputLokasiPengirim.setBounds(10, 100, 215, 30);
        inputLokasiPengirim.setText(transaksi.getAlamatPengirim());
        inputLokasiPengirim.setEditable(false);

        inputLokasiPenerima = new JTextField();
        inputLokasiPenerima.setBounds(10, 100, 215, 30);
        inputLokasiPenerima.setText(transaksi.getAlamatPenerima());
        inputLokasiPenerima.setEditable(false);

        inputBanyakBarang = new JTextField();
        inputBanyakBarang.setBounds(225, 60, 280, 30);
        inputBanyakBarang.setText("" + transaksi.getJumlahBarang());
        inputBanyakBarang.setEditable(false);

        labelNomorHPPengirim = GUI.defaultRegularLabel("Nomor HP Pengirim");
        labelNomorHPPengirim.setBounds(10, 140, 215, 20);

        labelNomorHPPenerima = GUI.defaultRegularLabel("Nomor HP Penerima");
        labelNomorHPPenerima.setBounds(10, 140, 215, 20);

        labelBeratBarang = GUI.defaultRegularLabel("Berat Barang(kg)");
        labelBeratBarang.setBounds(10, 110, 150, 30);

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
        inputBeratBarang.setText("" + transaksi.getBeratBarang());
        inputBeratBarang.setEditable(false);

        JButton btnAmbilOrder = GUI.defaultButton("Ambil Order", 20);
        btnAmbilOrder.setBounds(200, 600, 200, 50);
        btnAmbilOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ambilOrderan(transaksi.getIdTransaksi())) {
                    frame.dispose();
                    ArrayList<Transaksi> listTransaksi = new Controller().ambilDaftarOrder(kurir.getIdUser());
                    kurir.setListTransaksi(listTransaksi);
                    kurir.setKetersediaan(1);
                    new BerandaKurir(kurir);
                }
            }
        });

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

        frame = GUI.defaultFrame();
        frame.getContentPane().setBackground(GUI.backGroundColor());

        panelPengirim.add(labelNamaPengirim);
        panelPengirim.add(labelAlamatPengirim);
        panelPengirim.add(labelNomorHPPengirim);
        panelPengirim.add(inputNamaPengirim);
        panelPengirim.add(inputLokasiPengirim);
        panelPengirim.add(inputNoHPPengirim);

        panelPenerima.add(labelNamaPenerima);
        panelPenerima.add(labelAlamatPenerima);
        panelPenerima.add(labelNomorHPPenerima);
        panelPenerima.add(inputNamaPenerima);
        panelPenerima.add(inputLokasiPenerima);
        panelPenerima.add(inputNoHPPenerima);

        panelBarang.add(labelTipeBarang);
        panelBarang.add(labelTotalBarang);
        panelBarang.add(labelBeratBarang);
        panelBarang.add(inputTipeBarang);
        panelBarang.add(inputBanyakBarang);
        panelBarang.add(inputBeratBarang);

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
