package View;

import javax.swing.*;

public class DefaultFrameSetting {
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
}
