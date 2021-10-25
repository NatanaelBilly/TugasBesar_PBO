package Controller;
import Model.*;

import java.util.ArrayList;
public class Method {

    public void lihatDaftarUser(){
        System.out.println("LIST USER");
    }

    public void lihatFeedback(ArrayList<Saran> listSaran){
        System.out.println("LIST FEEDBACK");
        for (int i = 0; i < listSaran.size(); i++) {
            Saran currentSaran= listSaran.get(i);
            System.out.println("From : "+ currentSaran.getId_pelanggan()+"\n" +
                    "Feedback : "+currentSaran.getSaran()+"\n");
        }
    }

    public void lihatSeluruhTransaksi(){

    }

    public void lihatSaldoAdmin(){

    }
}
