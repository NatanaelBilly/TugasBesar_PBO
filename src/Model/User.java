package Model;

import java.util.ArrayList;

public class User {

    private int idUser;
    private String namaDepan;
    private String namaBelakang;
    private String emailUser;
    private String password;
    private String noHp;
    private double saldo;
    private Model.Role role;
    private ArrayList<Transaksi> listTransaksi;

    public User() {

    }

    public User(int idUser, String namaDepan, String namaBelakang,String noHp, String emailUser, String password, double saldo, Role role, ArrayList<Transaksi> listTransaksi) {
        setIdUser(idUser);
        setNamaDepan(namaDepan);
        setNamaBelakang(namaBelakang);
        setNoHp(noHp);
        setEmailUser(emailUser);
        setPassword(password);
        setSaldo(saldo);
        setRole(role);
        setListTransaksi(listTransaksi);
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNamaDepan() {
        return namaDepan;
    }

    public void setNamaDepan(String namaDepan) {
        this.namaDepan = namaDepan;
    }

    public String getNamaBelakang() {
        return namaBelakang;
    }

    public void setNamaBelakang(String namaBelakang) {
        this.namaBelakang = namaBelakang;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }
    

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public ArrayList<Transaksi> getListTransaksi() {
        return listTransaksi;
    }

    public void setListTransaksi(ArrayList<Transaksi> listTransaksi) {
        this.listTransaksi = listTransaksi;
    }

    @Override
    public String toString() {
        return "User{" + "idUser=" + idUser + ", namaDepan=" + namaDepan + ", namaBelakang=" + namaBelakang + ", emailUser=" + emailUser + ", password=" + password + ", noHp=" + noHp + ", saldo=" + saldo + ", role=" + role + ", listTransaksi=" + listTransaksi + '}';
    }

    
    
    
}
