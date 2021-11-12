package View;

import Model.Constant;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;

public class LihatDetailTransaksiPelanggan {
    JFrame frame;
    JPanel panelInfoKurir, panelNamaNoKurir, panelPengirim, panelPenerima, panelInfoPengiriman;
    JLabel labelMessage, labelIconProfil, labelNamaKurir, labelNoPlatKurir, labelIconPengirim, labelIconPenerima;
    JLabel labelNamaPengirim, labelNoTlpPengirim, labelNamaPenerima, labelNoTlpPenerima, labelIconBarang, labelBeratBarang, labelHarga, labelDot;
    JTextArea taAlamatPengirim, taAlamatPenerima;
    ImageIcon iconProfil, iconPengirim, iconPenerima, iconBarang, iconDot;

    public LihatDetailTransaksiPelanggan(){
        //Font
        Font fontLabelKurir = new Font("Arial", Font.PLAIN, 20);
        Font fontText = new Font("Arial", Font.PLAIN, 18);
        Font fontInfoPengiriman = new Font("Arial", Font.PLAIN, 35);

        //Frame
        frame = new JFrame(Constant.applicationName+" - Detail Transaksi");
        frame.setSize(600, 800);

        //line border
        LineBorder line = new LineBorder(new Color(0,0,0), 2, true);

        //Panel
        panelInfoKurir = new JPanel();
        panelInfoKurir.setBounds(90,20,400,140);
        panelInfoKurir.setBorder(line);

        panelNamaNoKurir = new JPanel();
        panelNamaNoKurir.setLayout(new BoxLayout(panelNamaNoKurir, BoxLayout.Y_AXIS));
        panelNamaNoKurir.setBounds(160,55,190,60);

        panelPengirim = new JPanel(null);
        panelPengirim.setBounds(190,180,300,115);

        panelPenerima = new JPanel(null);
        panelPenerima.setBounds(190,320,300,115);

        panelInfoPengiriman = new JPanel();
        panelInfoPengiriman.setLayout(new GridLayout());
        panelInfoPengiriman.setBounds(40,450,500,150);
        panelInfoPengiriman.setBorder(new EmptyBorder(15, 35, 15, 25));

        //label
        labelMessage = new JLabel("Barangmu sedang diantar oleh...");
        labelMessage.setBounds(55,5,400,40);
        labelMessage.setFont(fontLabelKurir);
        labelNamaKurir = new JLabel("INI NAMA");
        labelNamaKurir.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        labelNamaKurir.setFont(fontLabelKurir);
        labelNoPlatKurir = new JLabel("D 2754 SBD");
        labelNoPlatKurir.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        labelNoPlatKurir.setFont(fontLabelKurir);
        labelNamaPengirim = new JLabel("Pengirim 1");
        labelNamaPengirim.setBounds(0,0,300,25);
        labelNamaPengirim.setFont(fontText);
        labelNoTlpPengirim = new JLabel("086374927394");
        labelNoTlpPengirim.setBounds(0,25,300,25);
        labelNoTlpPengirim.setFont(fontText);
        taAlamatPengirim = new JTextArea("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        taAlamatPengirim.setBounds(0,50,300,65);
        taAlamatPengirim.setFont(fontText);
        taAlamatPengirim.setLineWrap(true);
        taAlamatPengirim.setOpaque(false);
        taAlamatPengirim.setEditable(false);
        taAlamatPengirim.setFocusable(false);
        labelNamaPenerima = new JLabel("Penerima 1");
        labelNamaPenerima.setBounds(0,0,300,25);
        labelNamaPenerima.setFont(fontText);
        labelNoTlpPenerima = new JLabel("086374927394");
        labelNoTlpPenerima.setBounds(0,25,300,25);
        labelNoTlpPenerima.setFont(fontText);
        taAlamatPenerima = new JTextArea("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        taAlamatPenerima.setBounds(0,50,300,65);
        taAlamatPenerima.setFont(fontText);
        taAlamatPenerima.setLineWrap(true);
        taAlamatPenerima.setOpaque(false);
        taAlamatPenerima.setEditable(false);
        taAlamatPenerima.setFocusable(false);
        labelBeratBarang = new JLabel("10 kg");
        labelBeratBarang.setFont(fontInfoPengiriman);
        labelBeratBarang.setHorizontalAlignment(JLabel.CENTER);
        labelBeratBarang.setBorder(BorderFactory.createMatteBorder(0, 2, 0, 0, Color.BLACK));
        labelHarga = new JLabel("20000");
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
        labelIconPenerima = new JLabel();
        labelIconPenerima.setBounds(100,320,80,80);
        iconPenerima = new ImageIcon ("assets/recipient.jpg");
        labelIconPenerima.setIcon(iconPenerima);
        labelIconBarang = new JLabel();
        iconBarang = new ImageIcon ("assets/medkit.jpg");
        labelIconBarang.setIcon(iconBarang);
        labelDot = new JLabel();
        labelDot.setBounds(135,250,20,80);
        iconDot = new ImageIcon ("assets/dot.jpg");
        labelDot.setIcon(iconDot);

        //Button
        //Jika barang sedang diantar
//        JButton btnChat = new JButton("Chat Driver");
//        btnChat.setBounds(20,660,540,30);
//        btnChat.setFont(fontText);
//        frame.add(btnChat);

        //Jika transaksi sudah selesai
        JLabel labelFeedback = new JLabel("Masukkan untuk kurir : ");
        labelFeedback.setBounds(20,610,250,30);
        labelFeedback.setFont(fontText);
        JTextArea taFeedback = new JTextArea();
        taFeedback.setBounds(20,640,540,60);
        taFeedback.setLineWrap(true);
        final int MAX_LENGTH = 200;
        taFeedback.setDocument(new PlainDocument() {
            @Override
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException, BadLocationException {
                if (str == null || taFeedback.getText().length() >= MAX_LENGTH) {
                    return;
                }

                super.insertString(offs, str, a);
            }
        });

        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setFont(fontText);
        btnSubmit.setBounds(455, 710, 100, 30);
        frame.add(labelFeedback);
        frame.add(taFeedback);
        frame.add(btnSubmit);

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
        frame.add(labelDot);
        frame.add(labelIconPengirim);
        frame.add(labelIconPenerima);
        frame.add(panelPengirim);
        frame.add(panelPenerima);
        frame.add(panelInfoKurir);
        frame.add(panelInfoPengiriman);

        panelInfoKurir.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
