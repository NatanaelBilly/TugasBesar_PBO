package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class IsiFeedbackAdmin {
    JFrame frame;
    JPanel panel, panelText;
    JLabel labelBack, labelProfilePic, labelNama, labelKet, labelAdmin;
    ImageIcon back, profilePic;
    JTextArea taFeedback;
    JButton btnSubmit;

    public IsiFeedbackAdmin(){
        //Font
        Font titleFont = new Font("Arial", Font.BOLD, 20);
        Font textFont = new Font("Arial", Font.PLAIN, 18);

        //back
        labelBack = new JLabel();
        back = new ImageIcon ("assets/back.jpg");
        labelBack.setIcon(back);
        labelBack.setBounds(30,15,100,30);

        labelBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Yay you clicked me");
            }
        });

        //picture
        labelProfilePic = new JLabel();
        profilePic = new ImageIcon ("assets/profile_pic.jpg");
        labelProfilePic.setIcon(profilePic);
        labelProfilePic.setBounds(130,50,320,260);

        //Nama
        labelNama = new JLabel("Hallo, "+"Nama Pengguna",JLabel.CENTER);
        labelNama.setFont(titleFont);

        //Ket
        labelKet = new JLabel("Let us know what you're thinking about this application",JLabel.CENTER);
        labelKet.setFont(textFont);
        labelAdmin = new JLabel("- ADMIN");
        labelAdmin.setFont(textFont);
        labelAdmin.setBounds(450,340,100,100);

        //Text Area
        taFeedback = new JTextArea();
        taFeedback.setBounds(110,420,360,180);
        taFeedback.setLineWrap(true);
        final int MAX_LENGTH = 400;
        taFeedback.setDocument(new PlainDocument() {
            @Override
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException, BadLocationException {
                if (str == null || taFeedback.getText().length() >= MAX_LENGTH) {
                    return;
                }

                super.insertString(offs, str, a);
            }
        });

        btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(450, 640, 100, 30);
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //add ke database
            }
        });

        //Frame
        frame = new JFrame("Nama APK");
        frame.setSize(600, 800);

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
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
