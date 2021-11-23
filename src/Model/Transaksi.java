package Model;

import java.util.Date;
import java.util.ArrayList;


public class Transaksi implements StatusPengiriman {

    private int idTransaksi;
    private int idPelanggan;
    private int idKurir;
    private String kategoriBarang;
    private double beratBarang;
    private double jumlahBarang;
    private String namaPengirim;
    private String alamatPengirim;
    private String noHpPengirim;
    private String namaPenerima;
    private String alamatPenerima;
    private String noHpPenerima;
    private double totalPembayaran;
    private int statusPemesanan;
    private Date tanggal;
    private ArrayList<Chat> listChat;

    public Transaksi() {
        
    }
    public Transaksi(int idTransaksi, int idPelanggan, int idKurir, 
            String kategoriBarang, double beratBarang, double jumlahBarang, 
            String namaPengirim, String alamatPengirim, String noHpPengirim, 
            String namaPenerima, String alamatPenerima, String noHpPenerima, 
            double totalPembayaran, int statusPemesanan, Date tanggal, 
            ArrayList<Chat> listChat) {
        
        setIdTransaksi(idTransaksi);
        setIdPelanggan(idPelanggan);
        setIdKurir(idKurir);
        setKategoriBarang(kategoriBarang);
        setBeratBarang(beratBarang);
        setJumlahBarang(jumlahBarang);
        setNamaPengirim(namaPengirim);
        setAlamatPengirim(alamatPengirim);
        setNoHpPengirim(noHpPengirim);
        setNamaPenerima(namaPenerima);
        setAlamatPengirim(alamatPengirim);
        setAlamatPenerima(alamatPenerima);
        setNoHpPenerima(noHpPenerima);
        setTotalPembayaran(totalPembayaran);
        setStatusPemesanan(statusPemesanan);
        setTanggal(tanggal);
        setListChat(listChat);
    }

    public int getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(int idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public int getIdPelanggan() {
        return idPelanggan;
    }

    public void setIdPelanggan(int idPelanggan) {
        this.idPelanggan = idPelanggan;
    }

    public int getIdKurir() {
        return idKurir;
    }

    public void setIdKurir(int idKurir) {
        this.idKurir = idKurir;
    }

    public String getKategoriBarang() {
        return kategoriBarang;
    }

    public void setKategoriBarang(String kategoriBarang) {
        this.kategoriBarang = kategoriBarang;
    }

    public double getBeratBarang() {
        return beratBarang;
    }

    public void setBeratBarang(double beratBarang) {
        this.beratBarang = beratBarang;
    }

    public double getJumlahBarang() {
        return jumlahBarang;
    }

    public void setJumlahBarang(double jumlahBarang) {
        this.jumlahBarang = jumlahBarang;
    }

    public String getNamaPengirim() {
        return namaPengirim;
    }

    public void setNamaPengirim(String namaPengirim) {
        this.namaPengirim = namaPengirim;
    }

    public String getAlamatPengirim() {
        return alamatPengirim;
    }

    public void setAlamatPengirim(String alamatPengirim) {
        this.alamatPengirim = alamatPengirim;
    }

    public String getNoHpPengirim() {
        return noHpPengirim;
    }

    public void setNoHpPengirim(String noHpPengirim) {
        this.noHpPengirim = noHpPengirim;
    }

    public String getNamaPenerima() {
        return namaPenerima;
    }

    public void setNamaPenerima(String namaPenerima) {
        this.namaPenerima = namaPenerima;
    }

    public String getAlamatPenerima() {
        return alamatPenerima;
    }

    public void setAlamatPenerima(String alamatPenerima) {
        this.alamatPenerima = alamatPenerima;
    }

    public String getNoHpPenerima() {
        return noHpPenerima;
    }

    public void setNoHpPenerima(String noHpPenerima) {
        this.noHpPenerima = noHpPenerima;
    }

    public double getTotalPembayaran() {
        return totalPembayaran;
    }

    public void setTotalPembayaran(double totalPembayaran) {
        this.totalPembayaran = totalPembayaran;
    }

//    public String getStatusPemesanan() {
//        String status = "";
//        if(statusPemesanan == 0){
//            status = "MENUNGGU KURIR";
//        } else if(statusPemesanan == 1){
//            status = "DIANTAR";
//        } else {
//            status = "DITERIMA";
//        }
//        return status;
//    }
    public int getStatusPemesanan() {
        return statusPemesanan;
    }

    public void setStatusPemesanan(int statusPemesanan) {
        this.statusPemesanan = statusPemesanan;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public ArrayList<Chat> getListChat() {
        return listChat;
    }

    public void setListChat(ArrayList<Chat> listChat) {
        this.listChat = listChat;
    }

    @Override
    public String toString() {
        return "Transaksi{" + "idTransaksi=" + idTransaksi + ", idPelanggan=" + idPelanggan + ", idKurir=" + idKurir + ", kategoriBarang=" + kategoriBarang + ", beratBarang=" + beratBarang + ", jumlahBarang=" + jumlahBarang + ", namaPengirim=" + namaPengirim + ", alamatPengirim=" + alamatPengirim + ", noHpPengirim=" + noHpPengirim + ", namaPenerima=" + namaPenerima + ", alamatPenerima=" + alamatPenerima + ", noHpPenerima=" + noHpPenerima + ", totalPembayaran=" + totalPembayaran + ", statusPemesanan=" + statusPemesanan + ", tanggal=" + tanggal + ", listChat=" + listChat + '}';
    }
    
    
}
