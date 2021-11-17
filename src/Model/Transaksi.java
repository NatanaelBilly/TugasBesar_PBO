/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;
import java.util.ArrayList;

/**
 *
 * @author natanael billy
 */
public class Transaksi implements StatusPengiriman {

    private int id_transaksi;
    private int id_pelanggan;
    private int id_kurir;
    private String kategori_barang;
    private double berat_barang;
    private double jumlah_barang;
    private String nama_pengirim;
    private String alamat_pengirim;
    private String noHP_pengirim;
    private String nama_penerima;
    private String alamat_penerima;
    private String noHP_penerima;
    private double total_pembayaran;
    private int status_pemesanan;
    private Date tanggal;
    private String saran_driver;
    private ArrayList<Chat> listChat;

    public Transaksi() {
        
    }
    public Transaksi(int id_transaksi, int id_pelanggan, int id_kurir, String kategori_barang, double berat_barang, double jumlah_barang, String nama_pengirim, String alamat_pengirim, String noHP_pengirim, String nama_penerima, String alamat_penerima, String noHP_penerima, double total_pembayaran, int status_pemesanan, Date tanggal, String saran_driver, ArrayList<Chat> listChat) {
        setId_transaksi(id_transaksi);
        setId_pelanggan(id_pelanggan);
        setId_kurir(id_kurir);
        setKategori_barang(kategori_barang);
        setBerat_barang(berat_barang);
        setJumlah_barang(jumlah_barang);
        setNama_pengirim(nama_pengirim);
        setAlamat_pengirim(alamat_pengirim);
        setNoHP_pengirim(noHP_pengirim);
        setNama_penerima(nama_penerima);
        setAlamat_pengirim(alamat_pengirim);
        setAlamat_penerima(alamat_penerima);
        setNoHP_penerima(noHP_penerima);
        setTotal_pembayaran(total_pembayaran);
        setStatus_pemesanan(status_pemesanan);
        setTanggal(tanggal);
        setSaran_driver(saran_driver);
        setListChat(listChat);
    }

    

    public int getId_transaksi() {
        return id_transaksi;
    }

    public void setId_transaksi(int id_transaksi) {
        this.id_transaksi = id_transaksi;
    }

    public int getId_pelanggan() {
        return id_pelanggan;
    }

    public void setId_pelanggan(int id_pelanggan) {
        this.id_pelanggan = id_pelanggan;
    }

    public int getId_kurir() {
        return id_kurir;
    }

    public void setId_kurir(int id_kurir) {
        this.id_kurir = id_kurir;
    }

    public String getKategori_barang() {
        return kategori_barang;
    }

    public void setKategori_barang(String kategori_barang) {
        this.kategori_barang = kategori_barang;
    }

    public double getBerat_barang() {
        return berat_barang;
    }

    public void setBerat_barang(double berat_barang) {
        this.berat_barang = berat_barang;
    }

    public double getJumlah_barang() {
        return jumlah_barang;
    }

    public void setJumlah_barang(double jumlah_barang) {
        this.jumlah_barang = jumlah_barang;
    }

    public String getNama_pengirim() {
        return nama_pengirim;
    }

    public void setNama_pengirim(String nama_pengirim) {
        this.nama_pengirim = nama_pengirim;
    }

    public String getAlamat_pengirim() {
        return alamat_pengirim;
    }

    public void setAlamat_pengirim(String alamat_pengirim) {
        this.alamat_pengirim = alamat_pengirim;
    }

    public String getNoHP_pengirim() {
        return noHP_pengirim;
    }

    public void setNoHP_pengirim(String noHP_pengirim) {
        this.noHP_pengirim = noHP_pengirim;
    }

    public String getNama_penerima() {
        return nama_penerima;
    }

    public void setNama_penerima(String nama_penerima) {
        this.nama_penerima = nama_penerima;
    }

    public String getAlamat_penerima() {
        return alamat_penerima;
    }

    public void setAlamat_penerima(String alamat_penerima) {
        this.alamat_penerima = alamat_penerima;
    }

    public String getNoHP_penerima() {
        return noHP_penerima;
    }

    public void setNoHP_penerima(String noHP_penerima) {
        this.noHP_penerima = noHP_penerima;
    }

    public double getTotal_pembayaran() {
        return total_pembayaran;
    }

    public void setTotal_pembayaran(double total_pembayaran) {
        this.total_pembayaran = total_pembayaran;
    }

    public String getStatus_pemesanan() {
        String status = "";
        if(status_pemesanan == 0){
            status = "MENUNGGU KURIR";
        } else if(status_pemesanan == 1){
            status = "DIANTAR";
        } else {
            status = "DITERIMA";
        }
        return status;
    }

    public void setStatus_pemesanan(int status_pemesanan) {
        this.status_pemesanan = status_pemesanan;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public String getSaran_driver() {
        return saran_driver;
    }

    public void setSaran_driver(String saran_driver) {
        this.saran_driver = saran_driver;
    }

    public ArrayList<Chat> getListChat() {
        return listChat;
    }

    public void setListChat(ArrayList<Chat> listChat) {
        this.listChat = listChat;
    }
}
