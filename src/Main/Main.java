package Main;

import Controller.Controller;
import Model.Transaksi;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
public class Main {
    public static void main(String[] args) {
//        new BuatOrder();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date currentDate = new Date(new java.util.Date().getTime());

        Controller controller = new Controller();

        Transaksi transaksi = new Transaksi(1,1,1,"Dokumen",5.0,2,"Maycelline S","Jl. Cikutra Highland", "0897291921","Raffi V","Bali","083921231",50000,2,currentDate,null,null);
        if(controller.buatOrder(transaksi)){
            System.out.println("Succerss create order");
        }

    }
}
