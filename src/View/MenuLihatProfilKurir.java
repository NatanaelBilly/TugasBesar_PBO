package View;

import Controller.KurirController;
import Model.Kurir;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MenuLihatProfilKurir {
    private JFrame frame;
    private JLabel labelMenu, labelProfilePic, labelNama, labelEmail, labelNoHp, labelNIK, labelPlat, labelKendaraan, labelKetersediaan,
            TampilanNama, TampilanEmail, TampilanNoHp, TampilanNIK, TampilanPlat, TampilanKendaraan, TampilanKetersediaan;
    private ImageIcon profilePic;
    
    private final DefaultComponentSetting GUI = new DefaultComponentSetting();
    public MenuLihatProfilKurir(Kurir kurir)
    {
//        if(kurir == null || new KurirController().cekKurirLogin())
//        {
//            new MenuLogin();
//        }
        
        //Data Template
//        int data_id = kurir.getId_user();
//        Role data_role = kurir.getRole();
        String data_nama_lengkap = kurir.getNama_depan() + " " + kurir.getNama_belakang();
        String data_email = kurir.getEmail_user();
        String data_noHp = kurir.getNoHp();
//        String data_password = kurir.getPassword();

        String data_NIK = kurir.getNIK();
        String data_plat = kurir.getPlat();
        String data_jenis_kendaraan = kurir.getJenis_kendaraan();
//        double data_total_pendapatan = kurir.getTotal_pendapatan();
        int data_ketersediaan = kurir.getKetersediaan();
        

        //Menu
        labelMenu = GUI.defaultHeadingLabel("Lihat Profil");
        labelMenu.setBounds(200,50,200,50);
        
        //picture
        labelProfilePic = new JLabel();
        profilePic = new ImageIcon ("assets/profile_pic.jpg");
        labelProfilePic.setIcon(profilePic);
        labelProfilePic.setBounds(130,100,325,260);

        //Label Keterangan
        labelNama = GUI.defaultRegularLabel("Nama : ");
        labelNama.setBounds(100,375,200,40);
        
        labelNIK = GUI.defaultRegularLabel("NIK ");
        labelNIK.setBounds(100,400,200,40);
        
        labelEmail = GUI.defaultRegularLabel("Email");
        labelEmail.setBounds(100,425,200,40);
        
        labelNoHp = GUI.defaultRegularLabel("No Telepon");
        labelNoHp.setBounds(100,450,200,40);
        
        labelPlat = GUI.defaultRegularLabel("Plat");
        labelPlat.setBounds(100,475,200,40);
        
        labelKendaraan = GUI.defaultRegularLabel("Kendaraan");
        labelKendaraan.setBounds(100,500,200,40);
        
        labelKetersediaan = GUI.defaultRegularLabel("Status");
        labelKetersediaan.setBounds(100,525,200,40);

        //Data
        TampilanNama = GUI.defaultRegularLabel(": " + data_nama_lengkap);
        TampilanNama.setBounds(200,375,300,40);
        
        TampilanNIK = GUI.defaultRegularLabel(": " + data_NIK);
        TampilanNIK.setBounds(200,400,300,40);
        
        TampilanEmail = GUI.defaultRegularLabel(": " + data_email);
        TampilanEmail.setBounds(200,425,300,40);
        
        TampilanNoHp = GUI.defaultRegularLabel(": " + data_noHp);
        TampilanNoHp.setBounds(200,450,300,40);
        
        TampilanPlat = GUI.defaultRegularLabel(": " + data_plat);
        TampilanPlat.setBounds(200,475,300,40);
        
        TampilanKendaraan = GUI.defaultRegularLabel(": " + data_jenis_kendaraan);
        TampilanKendaraan.setBounds(200,500,300,40);

        
        String status;
        if(data_ketersediaan == 0)
            status = "Tidak Ada Orderan";
        else
            status = "Sedang Mengirim Orderan";
            
        TampilanKetersediaan = GUI.defaultRegularLabel(": " + status);
        TampilanKetersediaan.setBounds(200,525,300,40);

        //Button Edit
        JButton btnEditProfile = GUI.defaultButton("Ubah Profil", 20);
        btnEditProfile.setBounds(200, 600, 200, 50);
        btnEditProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuEditProfilKurir(kurir);
                frame.dispose();
            }
        });
        
        
        //Link Kembali
        JLabel labelKembali = GUI.defaultBackLabel();
        labelKembali.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new BerandaKurir(kurir);
                frame.dispose();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                new BerandaKurir(kurir);
                frame.dispose();
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

        frame.add(labelMenu);
        frame.add(labelProfilePic);
        frame.add(labelNama);
        frame.add(labelEmail);
        frame.add(labelNoHp);
        frame.add(labelNIK);
        frame.add(labelPlat);
        frame.add(labelKendaraan);
        frame.add(labelKetersediaan);
        frame.add(TampilanNama);
        frame.add(TampilanEmail);
        frame.add(TampilanNoHp);
        frame.add(TampilanPlat);
        frame.add(TampilanKendaraan);
        frame.add(TampilanNIK);
        frame.add(TampilanKetersediaan);
        
        frame.add(btnEditProfile);
        frame.add(labelKembali);

    }
    
}
