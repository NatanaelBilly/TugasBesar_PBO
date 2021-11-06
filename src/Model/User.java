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
public class User {

    private int id_user;
    private String nama_depan;
    private String nama_belakang;
    private String email_user;
    private String password;
    private double saldo;
    private Model.Role role;
    private ArrayList<Transaksi> listTransaksi;

    public User() {

    }

    public User(int id_user, String nama_depan, String nama_belakang, String email_user, String password, double saldo, Role role, ArrayList<Transaksi> listTransaksi) {
        setId_user(id_user);
        setNama_depan(nama_depan);
        setNama_belakang(nama_belakang);
        setEmail_user(email_user);
        setPassword(password);
        setSaldo(saldo);
        setRole(role);
        setListTransaksi(listTransaksi);
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getNama_depan() {
        return nama_depan;
    }

    public void setNama_depan(String nama_depan) {
        this.nama_depan = nama_depan;
    }

    public String getNama_belakang() {
        return nama_belakang;
    }

    public void setNama_belakang(String nama_belakang) {
        this.nama_belakang = nama_belakang;
    }

    public String getEmail_user() {
        return email_user;
    }

    public void setEmail_user(String email_user) {
        this.email_user = email_user;
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
}
