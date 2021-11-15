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
public class Kurir extends User {

    private double total_pendapatan;
    private String NIK;
    private int ketersediaan;
    private String plat;
    private String jenis_kendaraan;

    public Kurir(){

    }

    public Kurir(double total_pendapatan, String NIK, int ketersediaan, String plat, String jenis_kendaraan, int id_user, String nama_depan, String nama_belakang, String noHp,String email_user, String password, double saldo, Role role, ArrayList<Transaksi> listTransaksi) {
        super(id_user, nama_depan, nama_belakang, noHp,email_user, password, saldo, role, listTransaksi);
        setTotal_pendapatan(total_pendapatan);
        setNIK(NIK);
        setKetersediaan(ketersediaan);
        setPlat(plat);
        setJenis_kendaraan(jenis_kendaraan);
    }



    public double getTotal_pendapatan() {
        return total_pendapatan;
    }

    public void setTotal_pendapatan(double total_pendapatan) {
        this.total_pendapatan = total_pendapatan;
    }

    public String getNIK() {
        return NIK;
    }

    public void setNIK(String NIK) {
        this.NIK = NIK;
    }

    public int getKetersediaan() {
        return ketersediaan;
    }

    public void setKetersediaan(int ketersediaan) {
        this.ketersediaan = ketersediaan;
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

    @Override
    public String toString() {
        return super.toString() + "Kurir{" + "total_pendapatan=" + total_pendapatan + ", NIK=" + NIK + ", ketersediaan=" + ketersediaan + ", plat=" + plat + ", jenis_kendaraan=" + jenis_kendaraan + '}';
    }
}
