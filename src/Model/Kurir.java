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
public class Kurir extends User{
    private String id_kurir;
    private String NIK;
    private double total_pendapatan;
    private int available;
    private String plat;
    private String jenis_kendaraan;
    ArrayList<Transaksi> listTransaksi;

    public Kurir(String id_kurir, String NIK, double total_pendapatan, int available, String plat, String jenis_kendaraan, ArrayList<Transaksi> listTransaksi, int id_user, String nama_depan, String nama_belakang, String email_user, String password, Role role) {
        super(id_user, nama_depan, nama_belakang, email_user, password, role);
        this.id_kurir = id_kurir;
        this.NIK = NIK;
        this.total_pendapatan = total_pendapatan;
        this.available = available;
        this.plat = plat;
        this.jenis_kendaraan = jenis_kendaraan;
        this.listTransaksi = listTransaksi;
    }

    public String getId_kurir() {
        return id_kurir;
    }

    public void setId_kurir(String id_kurir) {
        this.id_kurir = id_kurir;
    }

    public String getNIK() {
        return NIK;
    }

    public void setNIK(String NIK) {
        this.NIK = NIK;
    }

    public double getTotal_pendapatan() {
        return total_pendapatan;
    }

    public void setTotal_pendapatan(double total_pendapatan) {
        this.total_pendapatan = total_pendapatan;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public String getPlat() {
        return plat;
    }

    public void setPlat(String plat) {
        this.plat = plat;
    }

    public String getJenis_kendaraan() {
        return jenis_kendaraan;
    }

    public void setJenis_kendaraan(String jenis_kendaraan) {
        this.jenis_kendaraan = jenis_kendaraan;
    }

    public ArrayList<Transaksi> getListTransaksi() {
        return listTransaksi;
    }

    public void setListTransaksi(ArrayList<Transaksi> listTransaksi) {
        this.listTransaksi = listTransaksi;
    }
    
}
