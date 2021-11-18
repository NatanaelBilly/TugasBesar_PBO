package View;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class MenuChat {

    ArrayList<JLabel> labelChat = new ArrayList();

    public MenuChat() {
        JLabel chat1 = new JLabel("Kaisar : Halo");
        JLabel chat2 = new JLabel("Dina : Halo Juga");
        JLabel chat3 = new JLabel("Kaisar : Lagi Apa");
        JLabel chat4 = new JLabel("Dina : Makan");

        labelChat.add(chat1);
        labelChat.add(chat2);
        labelChat.add(chat3);
        labelChat.add(chat4);

        JFrame frame = new DefaultComponentSetting().defaultFrame();
//
//        //Panel
//        JPanel panel = new JPanel();
//        panel.setBackground(new Color(0, 254, 202, 255));
//
//        JTextField chat = new JTextField();
//        chat.setBounds(25, 680, 455, 50);
//        chat.setFont(new Font("Arial", Font.PLAIN, 20));
//
//        //Button Send
//        JButton send = new JButton("Send");
//        send.setBounds(485, 680, 70, 50);
//        send.setFont(new Font("Arial", Font.PLAIN, 15));
//
//        //Button back
//        JButton back = new JButton("<");
//        back.setBounds(25, 20, 50, 50);
//        frame.add(back);
//
//        //Nama
//        JLabel nama = new DefaultComponentSetting().defaultRegularLabel("Nama");
//        nama.setBounds(95, 20, 200, 50);
//        frame.add(nama);
//        nama.setFont(new Font("Arial", Font.PLAIN, 25));
//
//        //Chat Bubble
//        frame.add(panel);
//        frame.add(chat);
//        frame.add(send);
//        frame.setLayout(null);
//        panel.setBounds(25, 90, 530, 570);
//        frame.setBackground(new Color(204, 180, 114));
//======================================================================================
        JPanel container = new JPanel();
        JLabel label = new JLabel("Halo");
        label.setBounds(100,800, 100, 100);
        
        JScrollPane scrPane = new JScrollPane(container);
        
        frame.add(scrPane);
        scrPane.add(label);

    }
}
