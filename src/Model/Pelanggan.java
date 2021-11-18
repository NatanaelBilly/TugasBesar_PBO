package Model;

import java.util.ArrayList;

public class Pelanggan extends User {
    TingkatanUser tingkatan;

    public Pelanggan() {

    }

    public Pelanggan(TingkatanUser tingkatan, int idUser, String namaDepan, String namaBelakang, 
            String noHp, String emailUser, String password, double saldo, Role role, 
            ArrayList<Transaksi> listTransaksi) {
        
        super(idUser, namaDepan, namaBelakang, noHp, emailUser, password, saldo, role, listTransaksi);
        setTingkatan(tingkatan);
    }

    public TingkatanUser getTingkatan() {
        return tingkatan;
    }

    public void setTingkatan(TingkatanUser tingkatan) {
        this.tingkatan = tingkatan;
    }

}
