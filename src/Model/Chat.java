/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Time;
import java.util.Date;


public class Chat {
    private int id_chat;
    private int id_transaksi;
    private int id_pengirim;
    private int id_penerima;
    private String chat;
    private Date time;
    
    
    public Chat(){}


    public Chat(int id_chat, int id_transaksi, int id_pengirim, int id_penerima, String chat, Date time) {
        setId_chat(id_chat);
        setId_transaksi(id_transaksi);
        setId_pengirim(id_pengirim);
        setId_penerima(id_penerima);
        setChat(chat);
        setTime(time);
    }

    public int getId_chat() {
        return id_chat;
    }

    public void setId_chat(int id_chat) {
        this.id_chat = id_chat;
    }

    public int getId_transaksi() {
        return id_transaksi;
    }

    public void setId_transaksi(int id_transaksi) {
        this.id_transaksi = id_transaksi;
    }

    public int getId_pengirim() {
        return id_pengirim;
    }

    public void setId_pengirim(int id_pengirim) {
        this.id_pengirim = id_pengirim;
    }

    public int getId_penerima() {
        return id_penerima;
    }

    public void setId_penerima(int id_penerima) {
        this.id_penerima = id_penerima;
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
    
    
    
    
}
