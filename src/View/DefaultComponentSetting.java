package View;

import javax.swing.*;
import java.awt.*;

public class DefaultComponentSetting {
    public JFrame defaultFrame(){
        //Declare Frame
        JFrame frame = new JFrame();

        //Initialize Frame
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setSize(600,800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return frame;
    }

    public JLabel defaultRegularLabel(String label){
        JLabel jlabel = new JLabel(label);
        jlabel.setFont(new Font("Arial",Font.PLAIN,16));
        return jlabel;
    }

    public JLabel defaultHeadingLabel(String label){
        JLabel jlabel = new JLabel(label,SwingConstants.CENTER);
        jlabel.setFont(new Font("Arial",Font.BOLD,20));
        return jlabel;
    }
}
