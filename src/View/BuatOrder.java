package View;

import Model.Constant;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class BuatOrder {
    JFrame frame;
    JPanel panelPengirim, panelPenerima, panelBarang;
    JLabel labelPengirim, labelPenerima, labelBarang, labelNamaPenerima, labelNamaPengirim, labelAlamatPenerima, labelAlamatPengirim, labelNomorHPPenerima, labelNomorHPPengirim, labelTipeBarang, labelTotalBarang, labelBeratBarang;
    JButton buttonOrder;

    public BuatOrder(){
        //Panel Pengirim
        panelPengirim = new JPanel();
        panelPengirim.setBounds(50,50,240,400);

        //Frame
        frame = new DefaultFrameSetting().defaultFrame();
    }
}
