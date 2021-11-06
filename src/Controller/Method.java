package Controller;
import Model.*;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
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
    public String [][] konversiListToArray(ArrayList<User> list){
        String hasil[][]=new String[list.size()][4];
        for (int i = 0; i < list.size(); i++) {
            User currentUser= list.get(i);
            hasil[i][0]=Integer.toString(currentUser.getId_user());
            hasil[i][1]=currentUser.getNama_depan();
            hasil[i][2]=currentUser.getNama_belakang();
            hasil[i][3]=currentUser.getEmail_user();
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

    public double lihatSaldoAdmin(ArrayList<Transaksi> listTransaksi){
        double total=0;
        for (int i = 0; i < listTransaksi.size(); i++) {
            Transaksi currentTransaksi= listTransaksi.get(i);
            total += currentTransaksi.getTotal_pembayaran();
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
                hasil[i][0]=Integer.toString(currentTransaksi.getId_transaksi());
                hasil[i][1]=Integer.toString(currentTransaksi.getId_pelanggan());
                hasil[i][2]=Integer.toString(currentTransaksi.getId_kurir());
                hasil[i][3]=  dateFormat.format(currentTransaksi.getTanggal());
            }
        }
        return hasil;
    }
}
