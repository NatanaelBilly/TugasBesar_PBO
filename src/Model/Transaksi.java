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
public class Transaksi implements Status_pengiriman {

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

}
