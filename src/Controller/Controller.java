package Controller;

import Database.Database;
import Model.Chat;
import Model.Kurir;
import Model.Role;
import Model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Controller {

    static Database conn = new Database();
    public ArrayList<User> users = new ArrayList<>();
    ArrayList<Chat> chats = new ArrayList<>();

    public ArrayList<User> getAllUsers() {
        conn.connect();
        String query = "SELECT * FROM user";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                User user = new User();
                user.setId_user(rs.getInt("id_user"));
                user.setNama_depan(rs.getString("nama_depan"));
                user.setNama_belakang(rs.getString("nama_belakang"));
                user.setEmail_user(rs.getString("email_user"));
                user.setPassword(rs.getString("password"));
                user.setRole(Role.valueOf(rs.getString("role")));
                user.setSaldo(rs.getInt("saldo"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (users);
    }

    //Kurir
    public Kurir ambilDataKurir(int idUser) {
        Kurir dataKurir = null;

        conn.connect();
        String query = "SELECT u.*, k.* "
                + "FROM user u JOIN kurir k ON u.id_user = k.id_user "
                + "AND u.id_user = " + idUser;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                //Cek Role
                Role role = Role.valueOf(rs.getString("role"));
                if (role == Role.KURIR) {
                    int id_user = rs.getInt("id_user");
                    String nama_depan = rs.getString("nama_depan");
                    String nama_belakang = rs.getString("nama_belakang");
                    String email_user = rs.getString("email_user");
                    String password = rs.getString("password");

                    String NIK = rs.getString("NIK");
                    String plat = rs.getString("plat");
                    String jenis_kendaraan = rs.getString("jenis_kendaraan");
                    double total_pendapatan = rs.getInt("total_pendapatan");
                    int ketersediaan = rs.getInt("ketersediaan");

                    double saldo = rs.getInt("saldo");
                    dataKurir = new Kurir(
                            total_pendapatan, NIK, ketersediaan,
                            plat, jenis_kendaraan,
                            id_user, nama_depan, nama_belakang,
                            email_user, password, saldo,
                            role, null);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dataKurir;
    }

    //Insert Chat
    public boolean insertChat(Chat chat) {
        conn.connect();

        String query = "INSERT INTO chat VALUES(?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, chat.getId_chat());
            stmt.setInt(2, chat.getId_transaksi());
            stmt.setInt(3, chat.getId_pengirim());
            stmt.setInt(4, chat.getId_penerima());
            stmt.setString(5, chat.getChat());
            stmt.setTime(6, chat.getTime());
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }

    }

    //Get chat
    public ArrayList<Chat> getChatById(int idUser, int idKurir, int idTransaksi) {
        conn.connect();
        String query = "SELECT * FROM chat WHERE id_pengirim = " + idUser
                + " AND id_penerima = " + idKurir
                + " OR id_pengirim = " + idKurir + " AND id_penerima = " + idUser;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Chat chat = new Chat();
                chat.setId_chat(rs.getInt("id"));
                chat.setId_transaksi(rs.getInt("id_transaksi"));
                chat.setId_pengirim(rs.getInt("id_pengirim"));
                chat.setId_penerima(rs.getInt("id_penerima"));
                chat.setChat(rs.getString("chat"));
                chat.setTime(rs.getTime("time"));
                chats.add(chat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (chats);
    }
    
 

}
