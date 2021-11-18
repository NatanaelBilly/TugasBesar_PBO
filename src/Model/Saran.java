package Model;

public class Saran {
    private int idSaran;
    private int idPelanggan;
    private String saran;

    public Saran(int idSaran, int idPelanggan, String saran) {
        setIdSaran(idSaran);
        setIdPelanggan(idPelanggan);
        setSaran(saran);
    }

    public int getIdSaran() {
        return idSaran;
    }

    public void setIdSaran(int idSaran) {
        this.idSaran = idSaran;
    }

    public int getIdPelanggan() {
        return idPelanggan;
    }

    public void setIdPelanggan(int idPelanggan) {
        this.idPelanggan = idPelanggan;
    }
    
    public String getSaran() {
        return saran;
    }

    public void setSaran(String saran) {
        this.saran = saran;
    }
    
}
