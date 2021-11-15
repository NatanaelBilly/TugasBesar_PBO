package View;

import Controller.Controller;
import Model.Pelanggan;
import Model.Saran;
import Model.User;
import Model.UserManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuIsiFeedbackAdmin {
    JFrame frame;
    JPanel panel, panelText;
    JLabel labelBack, labelProfilePic, labelNama, labelKet, labelAdmin;
    ImageIcon back, profilePic;
    JTextArea taFeedback;
    JButton btnSubmit;

    public MenuIsiFeedbackAdmin(Pelanggan pelanggan){
        //back
        labelBack = new DefaultComponentSetting().defaultBackLabel();
        labelBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                new BerandaPelanggan(pelanggan);
            }
        });

        //picture
        labelProfilePic = new JLabel();
        profilePic = new ImageIcon ("assets/profile_pic.jpg");
        labelProfilePic.setIcon(profilePic);
        labelProfilePic.setBounds(130,50,320,260);

        //Nama
        labelNama = new DefaultComponentSetting().defaultHeadingLabel("Hallo, "+pelanggan.getNama_depan()+" "+pelanggan.getNama_belakang());

        //Ket
        labelKet = new DefaultComponentSetting().defaultRegularLabel("Let us know what you're thinking about this application");
        labelAdmin = new DefaultComponentSetting().defaultRegularLabel("- ADMIN");
        labelAdmin.setBounds(420,340,100,100);

        //Text Area
        taFeedback = new JTextArea();
        taFeedback.setBounds(110,420,360,140);
        taFeedback.setLineWrap(true);
        final int MAX_LENGTH = 255;
        taFeedback.setDocument(new PlainDocument() {
            @Override
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException, BadLocationException {
                if (str == null || taFeedback.getText().length() >= MAX_LENGTH) {
                    return;
                }

                super.insertString(offs, str, a);
            }
        });

        btnSubmit = new DefaultComponentSetting().defaultButton("Submit", 14);
        btnSubmit.setBounds(380, 610, 100, 30);
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Saran saran = new Saran(0, pelanggan.getId_user(), taFeedback.getText());
                Controller c = new Controller();
                boolean submitSaran = c.tambahSaran(saran);
                if(submitSaran){
                    JOptionPane.showMessageDialog(null, "Saran telah kami terima. Terima Kasih!");
                    frame.dispose();
                    new BerandaPelanggan(pelanggan);
                } else {
                    JOptionPane.showMessageDialog(null, "Gagal menambahkan saran");
                }
            }
        });

        //Frame
        frame = new DefaultComponentSetting().defaultFrame();

        //Panel
        panel = new JPanel();
        panel.setSize(600, 320);
        panelText = new JPanel();
        panelText.setBounds(50,320,500,130);

        //add
        panel.add(labelBack);
        panel.add(labelProfilePic);
        panelText.add(labelNama);
        panelText.add(labelKet);
        frame.add(labelAdmin);
        frame.add(taFeedback);
        frame.add(btnSubmit);
        frame.add(panel);
        frame.add(panelText);

        panel.setLayout(null);
        panel.setVisible(true);
        panelText.setVisible(true);
    }
}
