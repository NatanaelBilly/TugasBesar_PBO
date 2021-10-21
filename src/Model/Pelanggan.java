/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.util.ArrayList;
/**
 *
 * @author natanael billy
 */
public class Pelanggan extends User{
   Model.Tingakatan tingkatan;

    public Pelanggan(Tingakatan tingkatan, int id_user, String nama_depan, String nama_belakang, String email_user, String password, double saldo, Role role, ArrayList<Transaksi> listTransaksi) {
        super(id_user, nama_depan, nama_belakang, email_user, password, saldo, role, listTransaksi);
        this.tingkatan = tingkatan;
    }

    public Tingakatan getTingkatan() {
        return tingkatan;
    }

    public void setTingkatan(Tingakatan tingkatan) {
        this.tingkatan = tingkatan;
    }
    
}
