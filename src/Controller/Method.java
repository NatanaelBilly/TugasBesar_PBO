package Controller;
import Model.*;

import java.util.ArrayList;
public class Method {
    Controller c=new Controller();
    public void lihatDaftarUser(){
        ArrayList<User> listUser = c.getAllUsers();
        for (int i = 0; i < listUser.size(); i++) {
            User currentUser= listUser.get(i);
            System.out.println(currentUser);
            System.out.println();
        }
    }
    public String [][] konversiListToArray(ArrayList<Pelanggan> list){
        String hasil[][]=new String[list.size()][5];
        for (int i = 0; i < list.size(); i++) {
            Pelanggan currentUser= list.get(i);
            String tingkatan="";
            if(currentUser.getTingkatan()==Tingakatan.BRONZE){
                tingkatan="BRONZE";
            }else if(currentUser.getTingkatan()==Tingakatan.SILVER){
                tingkatan="SILVER";
            }else if(currentUser.getTingkatan()==Tingakatan.GOLD){
                tingkatan="GOLD";
            }
            hasil[i][0]=tingkatan;
            hasil[i][1]=Integer.toString(currentUser.getId_user());
            hasil[i][2]=currentUser.getNama_depan();
            hasil[i][3]=currentUser.getNama_belakang();
            hasil[i][4]=currentUser.getEmail_user();
        }
        return hasil;
    }
    public void lihatFeedback(ArrayList<Saran> listSaran){
        System.out.println("LIST FEEDBACK");
        for (int i = 0; i < listSaran.size(); i++) {
            Saran currentSaran= listSaran.get(i);
            System.out.println("From : "+ currentSaran.getId_pelanggan()+"\n" +
                    "Feedback : "+currentSaran.getSaran()+"\n");
        }
    }

    public void lihatSeluruhTransaksi(ArrayList<Transaksi> listTransaksi){
        System.out.println("LIST TRANSAKSI");
        for (int i = 0; i < listTransaksi.size(); i++) {
            Transaksi currentTransaksi= listTransaksi.get(i);
        }
    }

    public void lihatSaldoAdmin(ArrayList<Transaksi> listTransaksi){
        double total=0;
        for (int i = 0; i < listTransaksi.size(); i++) {
            Transaksi currentTransaksi= listTransaksi.get(i);
            total += currentTransaksi.getTotal_pembayaran();
        }
        System.out.println("Total pendapatan dari seluruh transaksi :");
        System.out.println(total);
    }
}
