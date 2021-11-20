package Model;

import java.util.ArrayList;

public class Kurir extends User {

    private String NIK;
    private int ketersediaan;
    private String plat;
    private String jenisKendaraan;

    public Kurir(){

    }

    public Kurir(String NIK, int ketersediaan, String plat, 
            String jenisKendaraan, int idUser, String namaDepan, String namaBelakang, 
            String noHp, String emailUser, String password, double saldo, Role role, 
            ArrayList<Transaksi> listTransaksi) {
        
        super(idUser, namaDepan, namaBelakang, noHp,emailUser, password, saldo, role, listTransaksi);
        setNIK(NIK);
        setKetersediaan(ketersediaan);
        setPlat(plat);
        setJenisKendaraan(jenisKendaraan);
    }
    
    //Builder
    public Kurir(Builder builder) {
        this.NIK = builder.NIK;
        this.ketersediaan = builder.ketersediaan;
        this.plat = builder.plat;
        this.jenisKendaraan = builder.jenisKendaraan;
        super.setIdUser(builder.idUser);
        super.setNamaDepan(builder.namaDepan);
        super.setNamaBelakang(builder.namaBelakang);
        super.setEmailUser(builder.emailUser);
        super.setPassword(builder.password);
        super.setNoHp(builder.noHp);
        super.setRole(builder.role);
        super.setSaldo(builder.saldo);
    }
    
    public static class Builder {
        private int idUser;
        private String namaDepan;
        private String namaBelakang;
        private String emailUser;
        private String password;
        private String noHp;
        private double saldo;
        private Model.Role role;
        
        private String NIK;
        private String plat;
        private String jenisKendaraan;
        private int ketersediaan;
    
        public Builder() {
        }

        //User
        public Builder setIdUser(int idUser) {
            this.idUser = idUser;
            return this;
        }
        public Builder setNamaDepan(String namaDepan) {
            this.namaDepan = namaDepan;
            return this;
        }
        public Builder setNamaBelakang(String namaBelakang) {
            this.namaBelakang = namaBelakang;
            return this;
        }
        public Builder setEmail(String emailUser) {
            this.emailUser = emailUser;
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


        public Builder setKetersediaan(int ketersediaan) {
            this.ketersediaan = ketersediaan;
            return this;
        }

        public Builder setPlat(String plat) {
            this.plat = plat;
            return this;
        }

        public Builder setJenisKendaraan(String jenisKendaraan) {
            this.jenisKendaraan = jenisKendaraan;
            return this;
        }
        
        public Kurir build() {
            Kurir kurir = new Kurir(this);
            return kurir;
        }
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

    public String getJenisKendaraan() {
        return jenisKendaraan;
    }

    public void setJenisKendaraan(String jenisKendaraan) {
        this.jenisKendaraan = jenisKendaraan;
    }

    @Override
    public String toString() {
        return super.toString() + "Kurir{" + "NIK=" + NIK + ", ketersediaan=" + ketersediaan + ", plat=" + plat + ", jenisKendaraan=" + jenisKendaraan + '}';
    }

}
