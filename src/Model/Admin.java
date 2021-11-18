package Model;

import java.util.ArrayList;

public class Admin extends User {
    private ArrayList<Saran> listSaran;

    public Admin() {

    }

    public Admin(ArrayList<Saran> listSaran, int idUser, String namaDepan, String namaBelakang, String noHp,String emailUser, String password, double saldo, Role role, ArrayList<Transaksi> listTransaksi) {
        super(idUser, namaDepan, namaBelakang, noHp,emailUser, password, saldo, role, listTransaksi);
        setListSaran(listSaran);
    }

    public ArrayList<Saran> getListSaran() {
        return listSaran;
    }

    public void setListSaran(ArrayList<Saran> listSaran) {
        this.listSaran = listSaran;
    }


}
