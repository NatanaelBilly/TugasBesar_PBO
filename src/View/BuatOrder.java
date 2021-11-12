package View;

import Model.User;
import Model.UserManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BuatOrder {
    JFrame frame;
    JPanel panelPengirim, panelPenerima, panelBarang;
    JLabel labelKembali, labelJudul, labelPengirim, labelPenerima, labelBarang, labelNamaPenerima, labelNamaPengirim, labelAlamatPenerima, labelAlamatPengirim, labelNomorHPPenerima, labelNomorHPPengirim, labelTipeBarang, labelTotalBarang, labelBeratBarang;
    JTextField inputNamaPengirim, inputNamaPenerima, inputLokasiPengirim, inputLokasiPenerima, inputNoHPPengirim, inputNoHPPenerima;
    JButton buttonOrder;
//    User user = new UserManager().getInstance().getUser();

    public BuatOrder() {
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
        labelPengirim.setBounds(20,70,240,30);
        
        //Label Penerima
        labelPenerima = new DefaultComponentSetting().defaultRegularLabel("Penerima");
        labelPenerima.setBounds(320,70,240,30);

        //Label Order

        //Panel Pengirim
        panelPengirim = new JPanel();
        panelPengirim.setBounds(20, 100, 240, 210);
        panelPengirim.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        panelPengirim.setVisible(true);
        panelPengirim.setLayout(null);

        //Panel Penerima
        panelPenerima = new JPanel();
        panelPenerima.setBounds(20, 100,240,210);
        panelPenerima.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        panelPenerima.setVisible(true);
        panelPenerima.setLayout(null);

        //Panel Barang
        panelBarang = new JPanel();
        panelBarang.setBounds(50,350,500,210);
        panelBarang.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        panelBarang.setVisible(true);
        panelBarang.setLayout(null);

        //Label Nama Pengirim
        labelNamaPengirim = new DefaultComponentSetting().defaultRegularLabel("Nama Pengirim");
        labelNamaPengirim.setBounds(10, 10, 215, 20);

        //Label Nama Penerima
        labelNamaPenerima = new DefaultComponentSetting().defaultRegularLabel("Nama Penerima");
        labelNamaPenerima.setBounds(10,10,215,20);

        
        //Input Nama Pengirim
        inputNamaPengirim = new JTextField();
        inputNamaPengirim.setBounds(10, 35, 215, 30);

        //Input Nama Penerima
        inputNamaPenerima = new JTextField();
        inputNamaPenerima.setBounds(10,35,215,30);

        //Label Alamat Pengirim
        labelAlamatPengirim = new DefaultComponentSetting().defaultRegularLabel("Alamat Pengirim");
        labelAlamatPengirim.setBounds(10, 75, 215, 20);

        //Label Alamat Penerima
        labelAlamatPenerima = new DefaultComponentSetting().defaultRegularLabel("Alamat Penerima");
        labelAlamatPenerima.setBounds(10, 75, 215, 20);

        //Input Alamat Pengirim
        inputLokasiPengirim = new JTextField();
        inputLokasiPengirim.setBounds(10, 100, 215, 30);

        //Input Alamat Penerima
        inputLokasiPenerima = new JTextField();
        inputLokasiPenerima.setBounds(10, 100, 215, 30);

        //Label no HP
        labelNomorHPPengirim = new DefaultComponentSetting().defaultRegularLabel("Nomor HP Pengirim");
        labelNomorHPPengirim.setBounds(10, 140, 215, 20);

        labelNomorHPPenerima = new DefaultComponentSetting().defaultRegularLabel("Nomor HP Penerima");
        labelNomorHPPenerima.setBounds(10, 140, 215, 20);

        //Input no HP
        inputNoHPPengirim = new JTextField();
        inputNoHPPengirim.setBounds(10, 165, 215, 30);

        inputNoHPPenerima = new JTextField();
        inputNoHPPenerima.setBounds(10, 165, 215, 30);
        
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


        //Add Panel to Frame
        frame.add(labelJudul);
        frame.add(labelKembali);
        frame.add(labelPengirim);
        frame.add(labelPenerima);
        frame.add(panelPengirim);
        frame.add(panelPenerima);
        frame.add(panelBarang);
    }
}
