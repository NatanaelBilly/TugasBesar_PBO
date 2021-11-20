package View;

import Controller.Controller;
import Controller.KurirController;
import Model.Constant;
import Model.Kurir;
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private Controller controller = new Controller();

    public MenuLihatDetailTransaksi(Transaksi transaksi, User user){
        Kurir kurir = controller.ambilDataKurir(transaksi.getIdKurir());

        //back
        labelKembali = GUI.defaultBackLabel();
        labelKembali.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                if(user instanceof Pelanggan)
                new MenuLihatDaftarTransaksi((Pelanggan) user);
            else
                new MenuLihatDaftarTransaksi((Kurir) user);
                
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
        labelNamaKurir = new JLabel(kurir.getNamaDepan()+" "+kurir.getNamaBelakang());
        labelNamaKurir.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        labelNamaKurir.setFont(fontLabelKurir);
        labelNoPlatKurir = new JLabel(kurir.getPlat());
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

            if(user instanceof Kurir)
            {
                JButton btnKonfirmasi = GUI.defaultButton("Konfirmasi Orderan",15);
                btnKonfirmasi.setBounds(20,660,540,30);
                btnKonfirmasi.setFont(fontText);
                btnKonfirmasi.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        KurirController conKurir = new KurirController();
                        boolean berhasil = false;
                        if(conKurir.ubahKetersediaanKurir(user.getIdUser(),0))
                        {
                            if(conKurir.konfirmasiOrderOlehKurir(transaksi.getIdTransaksi()))
                            {
                                Kurir newKurir = conKurir.prosesPembayaran(transaksi.getTotalPembayaran(), user.getIdUser());
                                if(newKurir != null)
                                {
                                    berhasil = true;
                                    frame.dispose();
                                    newKurir.setListTransaksi(user.getListTransaksi());
                                    //Ga Rekomen
                                    newKurir.getListTransaksi().get(newKurir.getListTransaksi().size() - 1).setStatusPemesanan(2);
                                    new BerandaKurir(newKurir);
                                }
                            }
                        }
                        if(berhasil)
                            JOptionPane.showMessageDialog(null, "Konfirmasi orderan berhasil.");
                        else
                            JOptionPane.showMessageDialog(null, "Konfirmasi orderan Gagal.");
                    }
                });
                
                frame.add(btnKonfirmasi);
            }
            else{
                JButton btnChat = GUI.defaultButton("Chat Driver",15);
                btnChat.setBounds(20,660,540,30);
                btnChat.setFont(fontText);
                frame.add(btnChat);
            }
        }else{
            if(user instanceof Kurir)
            {
                JLabel labelSelesai = new JLabel("Pesanan Selesai.");
                labelSelesai.setBounds(20,625,250,30);
                labelSelesai.setFont(fontText);
                frame.add(labelSelesai);
            }else
            {
                if(transaksi.getSaranDriver()==null){
                    JLabel labelFeedback = new JLabel("Masukkan untuk kurir : ");
                    labelFeedback.setBounds(20,605,250,30);
                    labelFeedback.setFont(fontText);
                    JTextArea taFeedback = new JTextArea();
                    taFeedback.setBounds(20,635,540,65);
                    taFeedback.setLineWrap(true);
                    Border border = BorderFactory.createLineBorder(Color.BLACK);
                    taFeedback.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
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

                    JButton btnSubmit = GUI.defaultButton("Submit",14);
                    btnSubmit.setFont(fontText);
                    btnSubmit.setBounds(455, 710, 100, 30);
                    frame.add(labelFeedback);
                    frame.add(taFeedback);
                    frame.add(btnSubmit);
                }else{
                    JLabel labelFeedback = new JLabel("Masukkan untuk kurir: ");
                    labelFeedback.setBounds(20,605,250,30);
                    labelFeedback.setFont(fontText);
                    JTextArea taFeedback = new JTextArea(transaksi.getSaranDriver());
                    taFeedback.setBounds(20,635,540,65);
                    taFeedback.setLineWrap(true);
                    taFeedback.setEditable(false);
                    Border border = BorderFactory.createLineBorder(Color.BLACK);
                    taFeedback.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
                    frame.add(taFeedback);
                    frame.add(labelFeedback);
                }
            }
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
