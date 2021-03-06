package View;

import Controller.Controller;
import Model.Pelanggan;
import Model.Saran;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.Border;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuIsiFeedbackAdmin {
    private JFrame frame;
    private JPanel panel, panelText;
    private JLabel labelKembali, labelProfilePic, labelNama, labelKet, labelAdmin;
    private ImageIcon profilePic;
    private JTextArea taFeedback;
    private JButton btnSubmit;
    private DefaultComponentSetting GUI = new DefaultComponentSetting();

    public MenuIsiFeedbackAdmin(Pelanggan pelanggan){
        labelKembali = GUI.defaultBackLabel();
        labelKembali.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                new BerandaPelanggan(pelanggan);
            }
        });

        labelProfilePic = new JLabel();
        profilePic = new ImageIcon ("assets/profile_pic.jpg");
        labelProfilePic.setIcon(profilePic);
        labelProfilePic.setBounds(220,140,150,150);

        labelNama = GUI.defaultHeadingLabel("Hallo, "+pelanggan.getNamaDepan()+" "+pelanggan.getNamaBelakang());

        labelKet = GUI.defaultRegularLabel("Let us know what you're thinking about this application");

        labelAdmin = GUI.defaultRegularLabel("- ADMIN");
        labelAdmin.setBounds(420,340,100,100);

        taFeedback = new JTextArea();
        taFeedback.setBounds(110,420,360,140);
        taFeedback.setLineWrap(true);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        taFeedback.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
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

        btnSubmit = GUI.defaultButton("Submit", 14);
        btnSubmit.setBounds(380, 610, 100, 30);
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!taFeedback.getText().equals("")){
                    Saran saran = new Saran(0, pelanggan.getIdUser(), taFeedback.getText());
                    Controller c = new Controller();
                    boolean submitSaran = c.tambahSaran(saran);
                    if(submitSaran){
                        JOptionPane.showMessageDialog(null, "Saran telah kami terima. Terima Kasih!");
                        frame.dispose();
                        new BerandaPelanggan(pelanggan);
                    } else {
                        JOptionPane.showMessageDialog(null, "Gagal menambahkan saran");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Silahkan isi saran");
                }
            }
        });

        frame = GUI.defaultFrame();
        frame.getContentPane().setBackground(GUI.backGroundColor());

        panel = new JPanel();
        panel.setSize(600, 320);
        panel.setBackground(GUI.backGroundColor());
        panelText = new JPanel();
        panelText.setBounds(50,320,500,130);
        panelText.setBackground(GUI.backGroundColor());

        panel.add(labelKembali);
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
