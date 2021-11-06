package Controller;

import Database.Database;
import Model.*;

import java.sql.*;
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

    //Buat transaksi
    public boolean buatOrder(Transaksi transaksi) {
        conn.connect();
        String query = "INSERT INTO transaksi VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, transaksi.getId_transaksi());
            stmt.setInt(2, transaksi.getId_pelanggan());
            stmt.setInt(3, transaksi.getId_kurir());
            stmt.setString(4, transaksi.getKategori_barang());
            stmt.setDouble(5, transaksi.getBerat_barang());
            stmt.setDouble(6, transaksi.getJumlah_barang());
            stmt.setString(7, transaksi.getNama_pengirim());
            stmt.setString(8, transaksi.getNama_penerima());
            stmt.setString(9, transaksi.getNoHP_pengirim());
            stmt.setString(10, transaksi.getNoHP_penerima());
            stmt.setString(11, transaksi.getAlamat_pengirim());
            stmt.setString(12, transaksi.getAlamat_penerima());
            stmt.setDouble(13, transaksi.getTotal_pembayaran());
            stmt.setDate(14, (Date) transaksi.getTanggal());
            stmt.setString(15, transaksi.getStatus_pemesanan());
            stmt.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    public int HitungJumlahUser() {
        getAllUsers();
        return users.size();
    }

    public boolean RegisterPelanggan(Pelanggan pelanggan) {
        conn.connect();
        String query1 = "INSERT INTO user VALUES (null,?,?,?,?,?,?)";

        try {
            PreparedStatement stmt = conn.con.prepareStatement(query1);
            stmt.setString(1, pelanggan.getNama_depan());
            stmt.setString(2,pelanggan.getNama_belakang());
            stmt.setString(3, pelanggan.getEmail_user());
            stmt.setString(4, pelanggan.getPassword());
            stmt.setString(5, String.valueOf(pelanggan.getRole()));
            stmt.setDouble(6, pelanggan.getSaldo());
            stmt.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }


}
