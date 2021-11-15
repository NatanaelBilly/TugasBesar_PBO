package Controller;

import Database.Database;
import Model.*;

import java.sql.*;
import java.util.ArrayList;

public class Controller {

    static Database conn = new Database();
    public ArrayList<User> users = new ArrayList<>();
    ArrayList<Chat> chats = new ArrayList<>();
    public ArrayList<Transaksi> listTransaksi=new ArrayList<>();
    public ArrayList<Saran> listSaran=new ArrayList<>();

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
                    String noHp = rs.getString("noHp");
                    double saldo = rs.getInt("saldo");

                    String NIK = rs.getString("NIK");
                    String plat = rs.getString("plat");
                    String jenis_kendaraan = rs.getString("jenis_kendaraan");
                    double total_pendapatan = rs.getInt("total_pendapatan");
                    int ketersediaan = rs.getInt("ketersediaan");
                    
                    dataKurir = new Kurir.Builder()
                        .setIdUser(id_user)
                        .setNamaDepan(nama_depan)
                        .setNamaBelakang(nama_belakang)
                        .setEmail(email_user)
                        .setPassword(password)
                        .setNoHp(noHp)
                        .setSaldo(saldo)
                        .setRole(role)
                        .setNIK(NIK)
                        .setPlat(plat)
                        .setJenisKendaraan(jenis_kendaraan)
                        .setTotalPendapatan(total_pendapatan)
                        .setKetersediaan(ketersediaan)
                        .build();
                    
//                    dataKurir = new Kurir(
//                            total_pendapatan, NIK, ketersediaan,
//                            plat, jenis_kendaraan,
//                            id_user, nama_depan, nama_belakang, noHp,
//                            email_user, password, saldo,
//                            role, null);
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
            stmt.setDate(6, (Date) chat.getTime());
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
        String query1 = "INSERT INTO user VALUES (null,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement stmt = conn.con.prepareStatement(query1);
            stmt.setString(1, pelanggan.getNama_depan());
            stmt.setString(2, pelanggan.getNama_belakang());
            stmt.setString(3, pelanggan.getNoHp());
            stmt.setString(4, pelanggan.getEmail_user());
            stmt.setString(5, pelanggan.getPassword());
            stmt.setString(6, String.valueOf(pelanggan.getRole()));
            stmt.setDouble(7, pelanggan.getSaldo());
            stmt.setString(8, String.valueOf(pelanggan.getTingkatan()));
            stmt.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    public boolean buatTransaksi(Transaksi transaksi) {
        conn.connect();
        String query = "INSERT INTO transaksi VALUES(null,?,null,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, transaksi.getId_pelanggan());
//            stmt.setInt(2, transaksi.getId_kurir());
            stmt.setString(2, transaksi.getKategori_barang());
            stmt.setDouble(3, transaksi.getBerat_barang());
            stmt.setDouble(4, transaksi.getJumlah_barang());
            stmt.setString(5, transaksi.getNama_pengirim());
            stmt.setString(6, transaksi.getNama_penerima());
            stmt.setString(7, transaksi.getNoHP_pengirim());
            stmt.setString(8, transaksi.getNoHP_penerima());
            stmt.setString(9, transaksi.getAlamat_pengirim());
            stmt.setString(10, transaksi.getAlamat_penerima());
            stmt.setDouble(11, transaksi.getTotal_pembayaran());
            stmt.setDate(12, (Date) transaksi.getTanggal());
            stmt.setString(13, transaksi.getStatus_pemesanan());
            stmt.executeUpdate();
            return (true);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return (false);
        }


    }

    public void logIn(String email, String password) {
        conn.connect();
        String query = "SELECT * FROM user WHERE email_user='" + email + "' AND password = '" + password + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int idUser = rs.getInt("id_user");
                String namaDepan = rs.getString("nama_depan");
                String namaBelakang = rs.getString("nama_belakang");
                String emailUser = rs.getString("email_user");
                String passwordUser = rs.getString("password");
                String noHp = rs.getString("noHp");
                Role roleUser = Role.valueOf(rs.getString("role"));

                double saldo = rs.getDouble("saldo");
                if (roleUser == Role.PELANGGAN) {
                    TingkatanUser tingkatanUser = TingkatanUser.valueOf(rs.getString("tingkatan"));
                    Pelanggan pelanggan = new Pelanggan();
                    pelanggan.setTingkatan(tingkatanUser);
                    pelanggan.setId_user(idUser);
                    pelanggan.setNama_depan(namaDepan);
                    pelanggan.setNama_belakang(namaBelakang);
                    pelanggan.setNoHp(noHp);
                    pelanggan.setEmail_user(emailUser);
                    pelanggan.setPassword(passwordUser);
                    pelanggan.setSaldo(saldo);
                    pelanggan.setRole(roleUser);
                    pelanggan.setListTransaksi(null);//sementara
                    new UserManager().getInstance().setUser(pelanggan);
                } else if (roleUser == Role.KURIR) {
                    String query2 = "SELECT * FROM kurir WHERE id_user=" + idUser + ";";
                    try {
                        Statement stmt2 = conn.con.createStatement();
                        ResultSet rs2 = stmt2.executeQuery(query2);
                        while (rs2.next()) {
                            String NIK = rs2.getString("NIK");
                            double totalPendapatan = rs2.getDouble("total_pendapatan");
                            int ketersediaanKurir = rs2.getInt("ketersediaan");
                            String platNomor = rs2.getString("plat");
                            String jenisKendaraan = rs2.getString("jenis_kendaraan");

                            Kurir kurir = new Kurir();
                            kurir.setId_user(idUser);
                            kurir.setNama_depan(namaDepan);
                            kurir.setNama_belakang(namaBelakang);
                            kurir.setNoHp(noHp);
                            kurir.setEmail_user(emailUser);
                            kurir.setPassword(passwordUser);
                            kurir.setSaldo(saldo);
                            kurir.setRole(roleUser);
                            kurir.setListTransaksi(null);
                            kurir.setTotal_pendapatan(totalPendapatan);
                            kurir.setNIK(NIK);
                            kurir.setKetersediaan(ketersediaanKurir);
                            kurir.setPlat(platNomor);
                            kurir.setJenis_kendaraan(jenisKendaraan);
                            new UserManager().getInstance().setUser(kurir);

                        }
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                } else {
                    Admin admin = new Admin();
                    admin.setId_user(idUser);
                    admin.setNama_depan(namaDepan);
                    admin.setNama_belakang(namaBelakang);
                    admin.setNoHp(noHp);
                    admin.setEmail_user(emailUser);
                    admin.setPassword(passwordUser);
                    admin.setSaldo(saldo);
                    admin.setRole(roleUser);
                    admin.setListTransaksi(null);//sementara
                    admin.setListSaran(null);//sementara;
                    new UserManager().getInstance().setUser(admin);

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }


    }

    public boolean cekUserDiDataBase(String email, String password) {
        conn.connect();
        String query = "SELECT * FROM user WHERE email_user='" + email + "' AND password='" + password + "';";

        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                return (true);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (false);
    }

    
    public boolean isiSaldo(Pelanggan pelanggan, int saldo){
        conn.connect();
        double total = pelanggan.getSaldo() + saldo;
        String query = "UPDATE user SET saldo = " + total + "WHERE id_user =" + pelanggan.getId_user() + ";";
        
         try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
        
    }

    public boolean cekUserDiDataBase(String email) {
        conn.connect();
        String query = "SELECT * FROM user WHERE email_user='" + email + "'";


        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                return (true);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (false);
    }

    public ArrayList<Transaksi> getSeluruhTransaksi() {
        conn.connect();
        String query = "SELECT * FROM transaksi";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int idTransaksi=rs.getInt(1);
                int idPelanggan=rs.getInt(2);
                int idKurir=rs.getInt(3);
                String kategoriBarang=rs.getString(4);
                double beratBarang=rs.getDouble(5);
                double jumlahBarang=rs.getDouble(6);
                String namaPengirim=rs.getString(7);
                String namaPenerima=rs.getString(8);
                String noHPPengirim=rs.getString(9);
                String noHPPenerima=rs.getString(10);
                String alamatPengirim=rs.getString(11);
                String alamatPenerima=rs.getString(12);
                double totalPembayaran=rs.getDouble(13);
                Date tanggal=rs.getDate(14);
                int statusPemesanan=rs.getInt(15);
                String saranDriver="";
                ArrayList<Chat> chatTransaksi=new ArrayList<>();
                Transaksi trans=new Transaksi(idTransaksi,idPelanggan,idKurir,kategoriBarang,beratBarang,jumlahBarang,namaPengirim,alamatPengirim,noHPPengirim,namaPenerima,alamatPenerima,noHPPenerima,totalPembayaran,statusPemesanan,tanggal,saranDriver,chatTransaksi);
                listTransaksi.add(trans);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (listTransaksi);
    }

    public ArrayList<Saran> getSeluruhSaran() {
        conn.connect();
        String query = "SELECT * FROM saran";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int idSaran=rs.getInt(1);
                int idPelanggan=rs.getInt(2);
                String saran=rs.getString(3);
                Saran isiSaran=new Saran(idSaran,idPelanggan,saran);
                listSaran.add(isiSaran);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (listSaran);
    }

    public boolean tambahSaran(Saran saran) {
        conn.connect();
        String query = "INSERT INTO saran VALUES(?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, saran.getId_saran());
            stmt.setInt(2, saran.getId_pelanggan());
            stmt.setString(3, saran.getSaran());
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }

    }

    public boolean updateDataPelanggan(String namaDpn, String namaBlkng, String email, String noHp, int idUser){
        conn.connect();
        String query = "update user set nama_depan = ?, nama_belakang = ?, email_user = ?, noHp = ? where id_user = ?";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, namaDpn);
            stmt.setString(2, namaBlkng);
            stmt.setString(3, email);
            stmt.setString(4, noHp);
            stmt.setInt(5, idUser);
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    public boolean ubahPassword(String passBaru, int idUser){
        conn.connect();
        String query = "update user set password = ? where id_user = ?";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, passBaru);
            stmt.setInt(2, idUser);
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
}
