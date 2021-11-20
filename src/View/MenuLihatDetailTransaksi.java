package View;

import Model.Constant;
import Model.Pelanggan;
import Model.Transaksi;
import Model.User;


import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MenuLihatDetailTransaksi {
    JFrame frame;
    JPanel panelInfoKurir, panelNamaNoKurir, panelPengirim, panelPenerima, panelInfoPengiriman;
    JLabel labelMessage, labelIconProfil, labelNamaKurir, labelNoPlatKurir, labelIconPengirim, labelIconPenerima, labelKembali;
    JLabel labelNamaPengirim, labelNoTlpPengirim, labelNamaPenerima, labelNoTlpPenerima, labelIconBarang, labelBeratBarang, labelHarga, labelDot;
    JTextArea taAlamatPengirim, taAlamatPenerima;
    ImageIcon iconProfil, iconPengirim, iconPenerima, iconBarang, iconDot;
    private DefaultComponentSetting GUI = new DefaultComponentSetting();

    public MenuLihatDetailTransaksi(Transaksi transaksi, User user){
        //back
        labelKembali = GUI.defaultBackLabel();
        labelKembali.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                new MenuLihatDaftarTransaksi((Pelanggan) user);
            }
        });

        //Font
        Font fontLabelKurir = new Font("Arial", Font.PLAIN, 20);
        Font fontText = new Font("Arial", Font.PLAIN, 18);
        Font fontInfoPengiriman = new Font("Arial", Font.PLAIN, 35);

        //line border
        LineBorder line = new LineBorder(new Color(0,0,0), 2, true);

        //Panel
        panelInfoKurir = new JPanel();
        panelInfoKurir.setBounds(90,20,400,140);
        panelInfoKurir.setBorder(line);
        panelInfoKurir.setBackground(GUI.backGroundColor());

        panelNamaNoKurir = new JPanel();
        panelNamaNoKurir.setLayout(new BoxLayout(panelNamaNoKurir, BoxLayout.Y_AXIS));
        panelNamaNoKurir.setBounds(160,55,190,60);
        panelNamaNoKurir.setBackground(GUI.backGroundColor());

        panelPengirim = new JPanel(null);
        panelPengirim.setBounds(190,180,300,115);
        panelPengirim.setBackground(GUI.backGroundColor());

        panelPenerima = new JPanel(null);
        panelPenerima.setBounds(190,320,300,115);
        panelPenerima.setBackground(GUI.backGroundColor());

        panelInfoPengiriman = new JPanel();
        panelInfoPengiriman.setLayout(new GridLayout());
        panelInfoPengiriman.setBounds(40,450,500,150);
        panelInfoPengiriman.setBorder(new EmptyBorder(15, 35, 15, 25));
        panelInfoPengiriman.setBackground(GUI.backGroundColor());

        //label
        if(transaksi.getStatusPemesanan().equalsIgnoreCase("diantar")){
            labelMessage = new JLabel("Barangmu sedang diantar oleh...");
        }else{
            labelMessage = new JLabel("Barangmu telah diantar oleh...");
        }
        labelMessage.setBounds(55,5,400,40);
        labelMessage.setFont(fontLabelKurir);
        labelNamaKurir = new JLabel("KURIR");
        labelNamaKurir.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        labelNamaKurir.setFont(fontLabelKurir);
        labelNoPlatKurir = new JLabel("D 2754 SBD");
        labelNoPlatKurir.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        labelNoPlatKurir.setFont(fontLabelKurir);
        labelNamaPengirim = new JLabel(transaksi.getNamaPengirim());
        labelNamaPengirim.setBounds(0,0,300,25);
        labelNamaPengirim.setFont(fontText);
        labelNoTlpPengirim = new JLabel(transaksi.getNoHpPengirim());
        labelNoTlpPengirim.setBounds(0,25,300,25);
        labelNoTlpPengirim.setFont(fontText);
        taAlamatPengirim = new JTextArea(transaksi.getAlamatPengirim());
        taAlamatPengirim.setBounds(0,50,300,65);
        taAlamatPengirim.setFont(fontText);
        taAlamatPengirim.setLineWrap(true);
        taAlamatPengirim.setOpaque(false);
        taAlamatPengirim.setEditable(false);
        taAlamatPengirim.setFocusable(false);
        labelNamaPenerima = new JLabel(transaksi.getNamaPenerima());
        labelNamaPenerima.setBounds(0,0,300,25);
        labelNamaPenerima.setFont(fontText);
        labelNoTlpPenerima = new JLabel(transaksi.getNoHpPenerima());
        labelNoTlpPenerima.setBounds(0,25,300,25);
        labelNoTlpPenerima.setFont(fontText);
        taAlamatPenerima = new JTextArea(transaksi.getAlamatPenerima());
        taAlamatPenerima.setBounds(0,50,300,65);
        taAlamatPenerima.setFont(fontText);
        taAlamatPenerima.setLineWrap(true);
        taAlamatPenerima.setOpaque(false);
        taAlamatPenerima.setEditable(false);
        taAlamatPenerima.setFocusable(false);
        labelBeratBarang = new JLabel(transaksi.getBeratBarang()+" kg");
        labelBeratBarang.setFont(fontInfoPengiriman);
        labelBeratBarang.setHorizontalAlignment(JLabel.CENTER);
        labelBeratBarang.setBorder(BorderFactory.createMatteBorder(0, 2, 0, 0, Color.BLACK));
        labelHarga = new JLabel(transaksi.getTotalPembayaran()+"");
        labelHarga.setFont(fontInfoPengiriman);
        labelHarga.setHorizontalAlignment(JLabel.CENTER);
        labelHarga.setBorder(BorderFactory.createMatteBorder(0, 2, 0, 0, Color.BLACK));

        //icon pic
        labelIconProfil = new JLabel();
        labelIconProfil.setBounds(70,50,80,70);
        iconProfil = new ImageIcon ("assets/profile_pic.jpg");
        Image image = iconProfil.getImage().getScaledInstance(80, 70,  java.awt.Image.SCALE_SMOOTH);
        iconProfil = new ImageIcon(image);
        labelIconProfil.setIcon(iconProfil);
        labelIconPengirim = new JLabel();
        labelIconPengirim.setBounds(100,180,80,80);
        iconPengirim = new ImageIcon ("assets/sender.jpg");
        labelIconPengirim.setIcon(iconPengirim);
        labelDot = new JLabel();
        labelDot.setBounds(135,250,20,80);
        iconDot = new ImageIcon ("assets/dot.jpg");
        labelDot.setIcon(iconDot);
        labelIconPenerima = new JLabel();
        labelIconPenerima.setBounds(100,320,80,80);
        iconPenerima = new ImageIcon ("assets/recipient.jpg");
        labelIconPenerima.setIcon(iconPenerima);
        labelIconBarang = new JLabel();
        switch(transaksi.getKategoriBarang()){
            case "Dokumen":
                iconBarang = new ImageIcon ("assets/dokumen.png");
                break;
            case "Makanan":
                iconBarang = new ImageIcon ("assets/makanan.png");
                break;
            case "Alat Rumah Tangga":
                iconBarang = new ImageIcon ("assets/alat_rumah_tangga.png");
                break;
            case "Alat Kecantikan":
                iconBarang = new ImageIcon ("assets/alat_kecantikan.png");
                break;
            case "Lainnya":
                iconBarang = new ImageIcon ("assets/box.png");
                break;
        }
        labelIconBarang.setIcon(iconBarang);

        //Frame
        frame = GUI.defaultFrame();
        frame.getContentPane().setBackground(GUI.backGroundColor());

        if(transaksi.getStatusPemesanan().equalsIgnoreCase("diantar")){
            JButton btnChat = GUI.defaultButton("Chat Driver",15);
            btnChat.setBounds(20,660,540,30);
            btnChat.setFont(fontText);
            frame.add(btnChat);
        }

        panelNamaNoKurir.add(labelNamaKurir);
        panelNamaNoKurir.add(Box.createRigidArea(new Dimension(0, 10)));
        panelNamaNoKurir.add(labelNoPlatKurir);
        panelInfoKurir.add(panelNamaNoKurir);
        panelInfoKurir.add(labelIconProfil);
        panelInfoKurir.add(labelMessage);
        panelPengirim.add(labelNamaPengirim);
        panelPengirim.add(labelNoTlpPengirim);
        panelPengirim.add(taAlamatPengirim);
        panelPenerima.add(labelNamaPenerima);
        panelPenerima.add(labelNoTlpPenerima);
        panelPenerima.add(taAlamatPenerima);
        panelInfoPengiriman.add(labelIconBarang);
        panelInfoPengiriman.add(labelBeratBarang);
        panelInfoPengiriman.add(labelHarga);
        frame.add(labelKembali);
        frame.add(labelDot);
        frame.add(labelIconPengirim);
        frame.add(labelIconPenerima);
        frame.add(panelPengirim);
        frame.add(panelPenerima);
        frame.add(panelInfoKurir);
        frame.add(panelInfoPengiriman);

        panelInfoKurir.setLayout(null);
    }
}
