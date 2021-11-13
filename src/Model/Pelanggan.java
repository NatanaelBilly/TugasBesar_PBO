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
public class Pelanggan extends User {
    TingkatanUser tingkatan;

    public Pelanggan() {

    }

    public Pelanggan(TingkatanUser tingkatan, int id_user, String nama_depan, String nama_belakang, String noHp, String email_user, String password, double saldo, Role role, ArrayList<Transaksi> listTransaksi) {
        super(id_user, nama_depan, nama_belakang, noHp, email_user, password, saldo, role, listTransaksi);
        setTingkatan(tingkatan);
    }

    public TingkatanUser getTingkatan() {
        return tingkatan;
    }

    public void setTingkatan(TingkatanUser tingkatan) {
        this.tingkatan = tingkatan;
    }

}
