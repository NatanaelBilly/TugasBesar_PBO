/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author natanael billy
 */
public class Saran {
    private int id_saran;
    private int id_pelanggan;
    private String saran;

    public Saran(int id_saran, int id_pelanggan, String saran) {
        this.id_saran = id_saran;
        this.id_pelanggan = id_pelanggan;
        this.saran = saran;
    }

    public int getId_saran() {
        return id_saran;
    }

    public void setId_saran(int id_saran) {
        this.id_saran = id_saran;
    }

    public int getId_pelanggan() {
        return id_pelanggan;
    }

    public void setId_pelanggan(int id_pelanggan) {
        this.id_pelanggan = id_pelanggan;
    }

    public String getSaran() {
        return saran;
    }

    public void setSaran(String saran) {
        this.saran = saran;
    }
    
}
