package View;

import Model.Constant;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LihatDaftarTransaksiPelanggan {
    JFrame frame;
    JPanel panel, panelTransaksi;
    JLabel label,label1;
    JScrollPane scrlpane;

    public LihatDaftarTransaksiPelanggan(){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new EmptyBorder(30, 60, 30, 60));

        for (int i = 0; i < 6; i++) {
            JPanel panel1 = new JPanel();
            panel1.setPreferredSize( new Dimension(100, 200) );
            panel1.setBorder(new BevelBorder(1, Color.BLACK, Color.BLACK));
            panel1.setBackground(new Color(200,200,0));
            panel.add( panel1 );
            panel.add(Box.createRigidArea(new Dimension(0, 25)));
        }

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setBounds(0, 0, 600, 800);
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(600, 800));
        contentPane.add(scrollPane);

        frame.setContentPane(contentPane);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
}
