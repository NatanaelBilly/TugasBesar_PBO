/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.KurirController;
import Model.Constant;
import Model.Kurir;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Asus
 */
public class KurirEditProfil {

    private JFrame frame;
    private JPanel panelRegisterKurir;
    private JLabel labelJudul, labelNamaDepan, labelNamaBelakang, labelNIK, labelPlatNomor, labelJenisKendaraan, labelEmail, labelNomorHP, labelPassword;
    private JTextField inputNamaDepan, inputNamaBelakang, inputNIK, inputPlatnomor, inputJenisKendaraan, inputEmail, inputNomorHp;

    private Kurir kurir;

    
    private KurirController conKurir = new KurirController();
    
    public KurirEditProfil(Kurir kurir) {
        
        this.kurir = kurir;
        
        //Label Judul
        labelJudul = new JLabel("EDIT PROFIL", SwingConstants.CENTER);
        labelJudul.setBounds(0, 50, 600, 30);
        labelJudul.setFont(new Font("Arial", Font.BOLD, 20));

        //Label Nama Depan
        labelNamaDepan = new JLabel("Nama Depan");
        labelNamaDepan.setFont(new Font("Arial", Font.PLAIN, 16));
        labelNamaDepan.setBounds(65, 130, 150, 30);

        //Input Nama Depan
        inputNamaDepan = new JTextField();
        inputNamaDepan.setBounds(230, 130, 250, 30);

        //Label Nama Belakang
        labelNamaBelakang = new JLabel("Nama Belakang");
        labelNamaBelakang.setFont(new Font("Arial", Font.PLAIN, 16));
        labelNamaBelakang.setBounds(65, 180, 150, 30);

        //Input Nama Belakang
        inputNamaBelakang = new JTextField();
        inputNamaBelakang.setBounds(230, 180, 250, 30);

        //Label NIK
        labelNIK = new JLabel("NIK");
        labelNIK.setFont(new Font("Arial", Font.PLAIN, 16));
        labelNIK.setBounds(65, 230, 150, 30);

        //Input NIK
        inputNIK = new JTextField();
        inputNIK.setBounds(230, 230, 250, 30);

        //Label Plat Nomor
        labelPlatNomor = new JLabel("Plat Nomor");
        labelPlatNomor.setFont(new Font("Arial", Font.PLAIN, 16));
        labelPlatNomor.setBounds(65, 280, 150, 30);

        //Input Plat Nomor
        inputPlatnomor = new JTextField();
        inputPlatnomor.setBounds(230, 280, 250, 30);

        //Label Jenis Kendaraan
        labelJenisKendaraan = new JLabel("Jenis Kendaraan");
        labelJenisKendaraan.setFont(new Font("Arial", Font.PLAIN, 16));
        labelJenisKendaraan.setBounds(65, 330, 150, 30);

        inputJenisKendaraan = new JTextField();
        inputJenisKendaraan.setBounds(230, 330, 250, 30);

        //Label Email
        labelEmail = new JLabel("Email");
        labelEmail.setFont(new Font("Arial", Font.PLAIN, 16));
        labelEmail.setBounds(65, 370, 150, 30);

        //Input Email
        inputEmail = new JTextField();
        inputEmail.setBounds(230, 370, 250, 30);

        //Label Nomor HP
        labelNomorHP = new JLabel("Nomor HP");
        labelNomorHP.setFont(new Font("Arial", Font.PLAIN, 16));
        labelNomorHP.setBounds(65, 420, 150, 30);

        //Input Nomor HP
//        inputNomorHp = new JTextField();
//        inputNomorHp.setBounds(230, 420, 250, 30);

        //Label Password
        labelPassword = new JLabel("Password");
        labelPassword.setFont(new Font("Arial", Font.PLAIN, 16));
        labelPassword.setBounds(65, 470, 150, 30);

        
        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(380, 540, 100, 40);
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Panggil Controller Edit
                Kurir kurirBaru = kurir;
                kurirBaru.setNama_depan(inputNamaDepan.getText());
                kurirBaru.setNama_belakang(inputNamaBelakang.getText());
                kurirBaru.setEmail_user(inputEmail.getText());
                kurirBaru.setNIK(inputNIK.getText());
                
                kurirBaru.setPlat(inputPlatnomor.getText());
                kurirBaru.setJenis_kendaraan(inputJenisKendaraan.getText());

                
                if(conKurir.EditDataKurirToDB(kurirBaru))
                    JOptionPane.showMessageDialog(null, "Profil Telah Diperbaharui");
                else
                    JOptionPane.showMessageDialog(null, "Mohon Maaf, Terjadi Kesalahan");
                    
                new KurirLihatProfil(kurir);
                frame.setVisible(false);
            }
        });
        //Button Back
        JButton btnBack = new JButton("Kembali");
        btnBack.setBounds(450, 25, 100, 30);
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new KurirLihatProfil(kurir);
                frame.setVisible(false);
            }
        });
        
        //Function
        isiDataLama();

        //Panel
        panelRegisterKurir = new JPanel();
        panelRegisterKurir.setSize(600, 800);
        panelRegisterKurir.setVisible(true);
        panelRegisterKurir.setLayout(null);
        panelRegisterKurir.add(labelJudul);
        panelRegisterKurir.add(labelNamaDepan);
        panelRegisterKurir.add(labelNamaBelakang);
        panelRegisterKurir.add(labelNIK);
        panelRegisterKurir.add(labelPlatNomor);
        panelRegisterKurir.add(labelJenisKendaraan);
        panelRegisterKurir.add(labelEmail);
        panelRegisterKurir.add(labelNomorHP);
        panelRegisterKurir.add(labelPassword);
        panelRegisterKurir.add(inputNamaDepan);
        panelRegisterKurir.add(inputNamaBelakang);
        panelRegisterKurir.add(inputNIK);
        panelRegisterKurir.add(inputPlatnomor);
        panelRegisterKurir.add(inputJenisKendaraan);
        panelRegisterKurir.add(inputEmail);
//        panelRegisterKurir.add(inputNomorHp);
        panelRegisterKurir.add(btnSubmit);
        panelRegisterKurir.add(btnBack);

        //Frame
        frame = new JFrame(Constant.applicationName + " - Register Kurir");
        frame.setSize(600, 800);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.add(panelRegisterKurir);
    }

    private void isiDataLama() {
        inputNamaDepan.setText(kurir.getNama_depan());
        inputNamaBelakang.setText(kurir.getNama_belakang());
        inputNIK.setText(kurir.getNIK());

        inputPlatnomor.setText(kurir.getPlat());

        inputJenisKendaraan.setText(kurir.getJenis_kendaraan());

        inputEmail.setText(kurir.getEmail_user());

        //inputNomorHp.setText();
    }
    
    
}
