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
    
    //Builder
    public Kurir(Builder builder) {
        this.total_pendapatan = builder.total_pendapatan;
        this.NIK = builder.NIK;
        this.ketersediaan = builder.ketersediaan;
        this.plat = builder.plat;
        this.jenis_kendaraan = builder.jenis_kendaraan;
        super.setId_user(builder.id_user);
        super.setNama_depan(builder.nama_depan);
        super.setNama_belakang(builder.nama_belakang);
        super.setEmail_user(builder.email_user);
        super.setPassword(builder.password);
        super.setNoHp(builder.noHp);
        super.setRole(builder.role);
        super.setSaldo(builder.saldo);
    }
    
    public static class Builder {
        private int id_user;
        private String nama_depan;
        private String nama_belakang;
        private String email_user;
        private String password;
        private String noHp;
        private double saldo;
        private Model.Role role;
        
        private String NIK;
        private String plat;
        private String jenis_kendaraan;
        private double total_pendapatan;
        private int ketersediaan;
    
        public Builder() {
        }

        //User
        public Builder setIdUser(int id_user) {
            this.id_user = id_user;
            return this;
        }
        public Builder setNamaDepan(String nama_depan) {
            this.nama_depan = nama_depan;
            return this;
        }
        public Builder setNamaBelakang(String nama_belakang) {
            this.nama_belakang = nama_belakang;
            return this;
        }
        public Builder setEmail(String email_user) {
            this.email_user = email_user;
            return this;
        }
        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }
        public Builder setNoHp(String noHp) {
            this.noHp = noHp;
            return this;
        }
        public Builder setSaldo(double saldo) {
            this.saldo = saldo;
            return this;
        }
        public Builder setRole(Model.Role role) {
            this.role = role;
            return this;
        }
        
        //Kurir
        public Builder setNIK(String NIK) {
            this.NIK = NIK;
            return this;
        }

        public Builder setTotalPendapatan(double total_pendapatan) {
            this.total_pendapatan = total_pendapatan;
            return this;
        }

        public Builder setKetersediaan(int ketersediaan) {
            this.ketersediaan = ketersediaan;
            return this;
        }

        public Builder setPlat(String plat) {
            this.plat = plat;
            return this;
        }

        public Builder setJenisKendaraan(String jenis_kendaraan) {
            this.jenis_kendaraan = jenis_kendaraan;
            return this;
        }
        
        public Kurir build() {
            Kurir kurir = new Kurir(this);
            return kurir;
        }
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
