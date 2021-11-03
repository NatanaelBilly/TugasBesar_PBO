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
public class Chat {
    private int id_chat;
    private int id_pengirim;
    private int id_penerima;
    private String chat;

    public Chat(int id_chat, int id_pengirim, int id_penerima, String chat) {
        this.id_chat = id_chat;
        this.id_pengirim = id_pengirim;
        this.id_penerima = id_penerima;
        this.chat = chat;
    }

    public int getId_chat() {
        return id_chat;
    }

    public void setId_chat(int id_chat) {
        this.id_chat = id_chat;
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
    
    
}
