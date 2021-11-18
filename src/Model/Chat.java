package Model;

import java.sql.Time;
import java.util.Date;


public class Chat {
    private int idChat;
    private int idTransaksi;
    private int idPengirim;
    private int idPenerima;
    private String chat;
    private Date time;
    
    
    public Chat(){}


    public Chat(int idChat, int idTransaksi, int idPengirim, int idPenerima, String chat, Date time) {
        setIdChat(idChat);
        setIdTransaksi(idTransaksi);
        setIdPengirim(idPengirim);
        setIdPenerima(idPenerima);
        setChat(chat);
        setTime(time);
    }

    public int getIdChat() {
        return idChat;
    }

    public void setIdChat(int idChat) {
        this.idChat = idChat;
    }

    public int getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(int idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public int getIdPengirim() {
        return idPengirim;
    }

    public void setIdPengirim(int idPengirim) {
        this.idPengirim = idPengirim;
    }

    public int getIdPenerima() {
        return idPenerima;
    }

    public void setIdPenerima(int idPenerima) {
        this.idPenerima = idPenerima;
    }

    public String getChat() {
        return chat;
    }

    public void setChat(String chat) {
        this.chat = chat;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Chat{" + "idChat=" + idChat + ", idTransaksi=" + idTransaksi + ", idPengirim=" + idPengirim + ", idPenerima=" + idPenerima + ", chat=" + chat + ", time=" + time + '}';
    }
    
    
    
    
}
