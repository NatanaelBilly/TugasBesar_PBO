/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 * @author natanael billy
 */
public class Admin extends User {
    private ArrayList<Saran> listSaran;

    public Admin() {

    }

    public Admin(ArrayList<Saran> listSaran, int id_user, String nama_depan, String nama_belakang, String email_user, String password, double saldo, Role role, ArrayList<Transaksi> listTransaksi) {
        super(id_user, nama_depan, nama_belakang, email_user, password, saldo, role, listTransaksi);
        setListSaran(listSaran);
    }

    public ArrayList<Saran> getListSaran() {
        return listSaran;
    }

    public void setListSaran(ArrayList<Saran> listSaran) {
        this.listSaran = listSaran;
    }


}
