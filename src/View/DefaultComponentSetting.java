package View;

import Model.Constant;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class DefaultComponentSetting {
    public JFrame defaultFrame() {
        //Declare Frame
        JFrame frame = new JFrame(Constant.APPLICATION_NAME);

        //Initialize Frame
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setSize(600, 800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return frame;
    }

    public JLabel defaultRegularLabel(String label) {
        JLabel jlabel = new JLabel(label);
        jlabel.setFont(new Font("Arial", Font.PLAIN, 14));
        return jlabel;
    }

    public JLabel defaultHeadingLabel(String label) {
        JLabel jlabel = new JLabel(label, SwingConstants.CENTER);
        jlabel.setFont(new Font("Arial", Font.BOLD, 20));
        return jlabel;
    }

    public JLabel defaultBackLabel() {
        JLabel jlabel = new JLabel("< Back");
        jlabel.setFont(new Font("Arial", Font.BOLD, 14));
        jlabel.setVisible(true);
        jlabel.setBounds(10, 5, 50, 30);
        return jlabel;
    }

    public JButton defaultButton(String namaButton, int besarFont) {
        JButton button = new JButton(namaButton);
        button.setBackground(new Color(217, 217, 217));
        button.setBorder(new BevelBorder(1, Color.BLACK, Color.BLACK));
        button.setFont(new Font("Arial", Font.BOLD, besarFont));
        return button;
    }

    public Color backGroundColor() {
        return Color.WHITE;
    }
}
