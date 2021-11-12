package View;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class ListMenuPelanggan {
    public static JPanel panel;
    JLabel labelMenu, labelOrder, labelFeedback, labelTransactions, labelProfile;
    ImageIcon menu, order, feedback, transactions, profile;
    JMenuBar menuPelanggan;
    JMenu order1,feedback1,transactions1,profile1;
    TextArea headerMenuPelanggan;

    public ListMenuPelanggan(){
        //JMenuBar
        menuPelanggan = new JMenuBar();
        order1 = new JMenu("Order");
        feedback1 = new JMenu("Feedback");
        transactions1 = new JMenu("Transaction");
        profile1 = new JMenu("Profile");
        menuPelanggan.add(order1);
        menuPelanggan.add(feedback1);
        menuPelanggan.add(transactions1);
        menuPelanggan.add(profile1);
        menuPelanggan.setVisible(true);

//        headerMenuPelanggan = new TextArea();
//        headerMenuPelanggan.add(menuPelanggan);
//        headerMenuPelanggan.setBounds(60,-10,600,60);


        //panel
        panel = new JPanel();
        panel.setSize(600, 40);
        Border blackline = BorderFactory.createLineBorder(Color.black);
        panel.setBorder(blackline);

        labelMenu = new JLabel();
        menu = new ImageIcon ("assets/menu_home.jpg");
        labelMenu.setIcon(menu);
        labelMenu.setBounds(60,-10,70,60);
        labelMenu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new BerandaPelanggan();
            }
        });

        labelOrder = new JLabel();
        order = new ImageIcon ("assets/menu_order.jpg");
        labelOrder.setIcon(order);
        labelOrder.setBounds(130,-10,70,60);
        labelOrder.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });

        labelFeedback = new JLabel();
        feedback = new ImageIcon ("assets/menu_feedback.jpg");
        labelFeedback.setIcon(feedback);
        labelFeedback.setBounds(200,-10,100,60);
        labelFeedback.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });

        labelTransactions = new JLabel();
        transactions = new ImageIcon ("assets/menu_transaction.jpg");
        labelTransactions.setIcon(transactions);
        labelTransactions.setBounds(300,-10,130,60);
        labelTransactions.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });

        labelProfile = new JLabel();
        profile = new ImageIcon ("assets/menu_profile.jpg");
        labelProfile.setIcon(profile);
        labelProfile.setBounds(430,-10,80,60);
        labelProfile.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new ProfilePelanggan();
            }
        });

        panel.add(labelMenu);
        panel.add(labelOrder);
        panel.add(labelFeedback);
        panel.add(labelTransactions);
        panel.add(labelProfile);

        panel.setLayout(null);
        panel.setVisible(true);
    }

}
