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
public class Transaksi implements Status_pengiriman{
    private int id_transaksi;
    private int id_pelanggan;
    private int id_kurir;
    private double pembayaran;
    private int statusPengiriman;
    private Date tanggal;
    private String saran_driver;
    private ArrayList<Chat> listChat;

    public Transaksi(int id_transaksi, int id_pelanggan, int id_kurir, double pembayaran, int statusPengiriman, Date tanggal, String saran_driver, ArrayList<Chat> listChat) {
        this.id_transaksi = id_transaksi;
        this.id_pelanggan = id_pelanggan;
        this.id_kurir = id_kurir;
        this.pembayaran = pembayaran;
        this.statusPengiriman = statusPengiriman;
        this.tanggal = tanggal;
        this.saran_driver = saran_driver;
        this.listChat = listChat;
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

    public double getPembayaran() {
        return pembayaran;
    }

    public void setPembayaran(double pembayaran) {
        this.pembayaran = pembayaran;
    }

    public int getStatusPengiriman() {
        return statusPengiriman;
    }

    public void setStatusPengiriman(int statusPengiriman) {
        this.statusPengiriman = statusPengiriman;
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
