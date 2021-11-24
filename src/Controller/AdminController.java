package Controller;

import Model.*;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.ArrayList;

public class AdminController {
    Controller c = new Controller();
    
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

    public String [][] konversiListToArrayTransaksi(ArrayList<Transaksi> listTransaksi){
        String hasil[][]=new String[listTransaksi.size()][5];
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            for (int i = 0; i < listTransaksi.size(); i++) {
                Transaksi currentTransaksi= listTransaksi.get(i);
                hasil[i][0]=Integer.toString(currentTransaksi.getIdTransaksi());
                hasil[i][1]=Integer.toString(currentTransaksi.getIdPelanggan());
                hasil[i][2]=Integer.toString(currentTransaksi.getIdKurir());
                hasil[i][3]=dateFormat.format(currentTransaksi.getTanggal());
                hasil[i][4]=Double.toString(currentTransaksi.getTotalPembayaran());
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
