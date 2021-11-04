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

    public ListMenuPelanggan(){

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
                new HomePelanggan();
            }
        });

        labelOrder = new JLabel();
        order = new ImageIcon ("assets/menu_order.jpg");
        labelOrder.setIcon(order);
        labelOrder.setBounds(130,-10,70,60);

        labelFeedback = new JLabel();
        feedback = new ImageIcon ("assets/menu_feedback.jpg");
        labelFeedback.setIcon(feedback);
        labelFeedback.setBounds(200,-10,100,60);

        labelTransactions = new JLabel();
        transactions = new ImageIcon ("assets/menu_transaction.jpg");
        labelTransactions.setIcon(transactions);
        labelTransactions.setBounds(300,-10,130,60);

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
