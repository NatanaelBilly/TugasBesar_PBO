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
    private int id_pelanggan;
    private double saldo;
    private ArrayList<Transaksi> listTransaksi;
    private ArrayList<Saran> listSaran;

    public Pelanggan(int id_pelanggan, double saldo, ArrayList<Transaksi> listTransaksi, ArrayList<Saran> listSaran, int id_user, String nama_depan, String nama_belakang, String email_user, String password, Role role) {
        super(id_user, nama_depan, nama_belakang, email_user, password, role);
        this.id_pelanggan = id_pelanggan;
        this.saldo = saldo;
        this.listTransaksi = listTransaksi;
        this.listSaran = listSaran;
    }

    
    public int getId_pelanggan() {
        return id_pelanggan;
    }

    public void setId_pelanggan(int id_pelanggan) {
        this.id_pelanggan = id_pelanggan;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public ArrayList<Transaksi> getListTransaksi() {
        return listTransaksi;
    }

    public void setListTransaksi(ArrayList<Transaksi> listTransaksi) {
        this.listTransaksi = listTransaksi;
    }

    public ArrayList<Saran> getListSaran() {
        return listSaran;
    }

    public void setListSaran(ArrayList<Saran> listSaran) {
        this.listSaran = listSaran;
    }
    
}
