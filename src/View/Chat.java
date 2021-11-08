
package View;

import Controller.Controller;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.AbstractBorder;
import javax.swing.border.LineBorder;

public class Chat {

    public Chat() {
        JFrame frame = new JFrame("Chat");
        JScrollPane scroll = new JScrollPane();
        JLabel label = new JLabel("Menggunakan ScrollPane");
        JPanel panel = new JPanel();

        //ScrollPane
        label.setPreferredSize(new Dimension(450, 900));
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setViewportBorder(new LineBorder(Color.RED));
        scroll.getViewport().add(label, null);
        
        
        JTextField chat = new JTextField();
        chat.setBounds(500, 700, 50, 50);
        chat.setFont(new Font("Arial", Font.PLAIN, 20));
        frame.add(chat);
        
        //Chat Bubble
        frame.setSize(600, 800);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.add(scroll);
        frame.setLayout(null);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBounds(0, 70, 580, 600);
    }

    public static void main(String[] args) {
        new Chat();
    }

}
