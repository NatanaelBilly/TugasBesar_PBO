package Controller;

import Model.*;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.ArrayList;

public class Method {
    Controller c = new Controller();
    
    public void lihatDaftarUser(){
        ArrayList<User> listUser = c.getAllUsers();
        for (int i = 0; i < listUser.size(); i++) {
            User currentUser= listUser.get(i);
            System.out.println(currentUser);
            System.out.println();
        }
    }
    
    public String [][] konversiListToArray(ArrayList<User> list){
        String hasil[][]=new String[list.size()][5];
        for (int i = 0; i < list.size(); i++) {
            User currentUser= list.get(i);
            hasil[i][0]= currentUser.getRole().toString();
            hasil[i][1]=Integer.toString(currentUser.getIdUser());
            hasil[i][2]=currentUser.getNamaDepan();
            hasil[i][3]=currentUser.getNamaBelakang();
            hasil[i][4]=currentUser.getEmailUser();
        }
        return hasil;
    }
    
    public void lihatFeedback(ArrayList<Saran> listSaran){
        System.out.println("LIST FEEDBACK");
        for (int i = 0; i < listSaran.size(); i++) {
            Saran currentSaran= listSaran.get(i);
            System.out.println("From : "+ currentSaran.getIdPelanggan()+"\n" +
                    "Feedback : "+currentSaran.getSaran()+"\n");
        }
    }

    public double lihatSaldoAdmin(ArrayList<Transaksi> listTransaksi){
        double total=0;
        for (int i = 0; i < listTransaksi.size(); i++) {
            Transaksi currentTransaksi= listTransaksi.get(i);
            total += currentTransaksi.getTotalPembayaran();
        }
        return total*0.3;
    }

    public String [][] konversiListToArrayTransaksi(ArrayList<User> listUser){
        String hasil[][]=new String[listUser.size()][5];
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i <listUser.size() ; i++) {
            User currentUser= listUser.get(i);
            for (int j = 0; j < currentUser.getListTransaksi().size(); j++) {
                Transaksi currentTransaksi= currentUser.getListTransaksi().get(j);
                hasil[i][0]=Integer.toString(currentTransaksi.getIdTransaksi());
                hasil[i][1]=Integer.toString(currentTransaksi.getIdPelanggan());
                hasil[i][2]=Integer.toString(currentTransaksi.getIdKurir());
                hasil[i][3]=dateFormat.format(currentTransaksi.getTanggal());
            }
        }
        return hasil;
    }

    public String [][] konversiListToArraySaran(ArrayList<Saran> listSaran){
        String hasil[][]=new String[listSaran.size()][3];
            for (int i = 0; i < listSaran.size(); i++) {
                Saran currentTransaksi= listSaran.get(i);
                hasil[i][0]=Integer.toString(currentTransaksi.getIdSaran());
                hasil[i][1]=Integer.toString(currentTransaksi.getIdPelanggan());
                hasil[i][2]=currentTransaksi.getSaran();
            }
        return hasil;
    }
}
