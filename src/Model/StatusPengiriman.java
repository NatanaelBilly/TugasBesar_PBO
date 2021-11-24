package Model;

public interface StatusPengiriman {
    int MENUNGGU_KURIR=1;
    int DIANTAR=2;
    int DITERIMA=3;
    abstract String pilihStatusPengiriman();
}
