package Controller;

import Database.Database;
import Model.*;

import java.sql.*;
import java.util.ArrayList;

public class Controller {

    static Database conn = new Database();
    public ArrayList<User> users = new ArrayList<>();
    ArrayList<Chat> chats = new ArrayList<>();
    public ArrayList<Transaksi> listTransaksi = new ArrayList<>();
    public ArrayList<Saran> listSaran = new ArrayList<>();

    public ArrayList<User> getAllUsers() {
        conn.connect();
        String query = "SELECT * FROM user";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                User user = new User();
                user.setIdUser(rs.getInt("id_user"));
                user.setNamaDepan(rs.getString("nama_depan"));
                user.setNamaBelakang(rs.getString("nama_belakang"));
                user.setEmailUser(rs.getString("email_user"));
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

    public User ambilDataUser(int idUser) {

        User user = new User();
        conn.connect();
        String query = "SELECT * FROM user WHERE id_user=" + idUser;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                user.setIdUser(rs.getInt("id_user"));
                user.setNamaDepan(rs.getString("nama_depan"));
                user.setNamaBelakang(rs.getString("nama_belakang"));
                user.setEmailUser(rs.getString("email_user"));
                user.setPassword(rs.getString("password"));
                user.setRole(Role.valueOf(rs.getString("role")));
                user.setSaldo(rs.getInt("saldo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (user);
    }

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
                    double saldo = rs.getDouble("saldo");
                    String NIK = rs.getString("NIK");
                    String plat = rs.getString("plat");
                    String jenis_kendaraan = rs.getString("jenis_kendaraan");
//                    double total_pendapatan = rs.getInt("total_pendapatan");
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
//                            .setTotalPendapatan(total_pendapatan)
                            .setKetersediaan(ketersediaan)
                            .build();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dataKurir;
    }

    public boolean insertChat(Chat chat) {
        conn.connect();
        String query = "INSERT INTO chat VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, getLastIdChat());
            stmt.setInt(2, chat.getIdTransaksi());
            stmt.setInt(3, chat.getIdPengirim());
            stmt.setInt(4, chat.getIdPenerima());
            stmt.setString(5, chat.getChat());
            stmt.setTime(6, chat.getTime());
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }

    }

    public ArrayList<Chat> getChatById(int idTransaksi) {
        conn.connect();
        String query = "SELECT * FROM chat WHERE id_transaksi = " + idTransaksi + ";";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Chat chat = new Chat();
                chat.setIdChat(rs.getInt("id"));
                chat.setIdTransaksi(rs.getInt("id_transaksi"));
                chat.setIdPengirim(rs.getInt("id_pengirim"));
                chat.setIdPenerima(rs.getInt("id_penerima"));
                chat.setChat(rs.getString("chat"));
                chat.setTime(rs.getTime("time"));
                chats.add(chat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (chats);
    }

    public int HitungJumlahUser() {
        ArrayList<User> listUser = getAllUsers();
        int size = listUser.size();
        return listUser.get(size - 1).getIdUser();
    }

    public boolean RegisterPelanggan(Pelanggan pelanggan) {
        conn.connect();
        String query1 = "INSERT INTO user VALUES (?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement stmt = conn.con.prepareStatement(query1);
            stmt.setInt(1, pelanggan.getIdUser());
            stmt.setString(2, pelanggan.getNamaDepan());
            stmt.setString(3, pelanggan.getNamaBelakang());
            stmt.setString(4, pelanggan.getNoHp());
            stmt.setString(5, pelanggan.getEmailUser());
            stmt.setString(6, pelanggan.getPassword());
            stmt.setString(7, String.valueOf(pelanggan.getRole()));
            stmt.setDouble(8, pelanggan.getSaldo());
            stmt.setString(9, String.valueOf(pelanggan.getTingkatan()));
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
            stmt.setInt(1, transaksi.getIdPelanggan());
//            stmt.setInt(2, transaksi.getId_kurir());
            stmt.setString(2, transaksi.getKategoriBarang());
            stmt.setDouble(3, transaksi.getBeratBarang());
            stmt.setDouble(4, transaksi.getJumlahBarang());
            stmt.setString(5, transaksi.getNamaPengirim());
            stmt.setString(6, transaksi.getNamaPenerima());
            stmt.setString(7, transaksi.getNoHpPengirim());
            stmt.setString(8, transaksi.getNoHpPenerima());
            stmt.setString(9, transaksi.getAlamatPengirim());
            stmt.setString(10, transaksi.getAlamatPenerima());
            stmt.setDouble(11, transaksi.getTotalPembayaran());
            stmt.setDate(12, (Date) transaksi.getTanggal());
            stmt.setInt(13, transaksi.getStatusPemesanan());
            stmt.executeUpdate();
            return (true);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return (false);
        }


    }

    public ArrayList<Transaksi> ambilDaftarOrder() {
        ArrayList<Transaksi> daftarOrder = new ArrayList<>();

        conn.connect();
        String query = "SELECT * FROM transaksi";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Transaksi transaksi = new Transaksi();
                transaksi.setIdTransaksi(rs.getInt("id_transaksi"));
                transaksi.setIdPelanggan(rs.getInt("id_pelanggan"));
                transaksi.setIdKurir(rs.getInt("id_kurir"));
                transaksi.setKategoriBarang(rs.getString("kategori_barang"));
                transaksi.setBeratBarang(rs.getDouble("berat_barang"));
                transaksi.setJumlahBarang(rs.getDouble("jumlah_barang"));
                transaksi.setNamaPengirim(rs.getString("nama_pengirim"));
                transaksi.setAlamatPengirim(rs.getString("alamat_pengirim"));
                transaksi.setNoHpPengirim(rs.getString("noHP_pengirim"));
                transaksi.setNamaPenerima(rs.getString("nama_penerima"));
                transaksi.setAlamatPengirim(rs.getString("alamat_pengirim"));
                transaksi.setAlamatPenerima(rs.getString("alamat_penerima"));
                transaksi.setNoHpPenerima(rs.getString("noHP_penerima"));
                transaksi.setTotalPembayaran(rs.getDouble("total_pembayaran"));
                transaksi.setTanggal(rs.getDate("tanggal"));
//                switch (rs.getString("status_pemesanan")) {
//                    case "MENUNGGU KURIR":
//                        transaksi.setStatusPemesanan(0);
//                        break;
//                    case "DIANTAR":
                transaksi.setStatusPemesanan(rs.getInt("status_pemesanan"));
//                        break;
//                    case "DITERIMA":
//                        transaksi.setStatusPemesanan(2);
//                        break;
//                }

                //Get Status nya belum
//                String status_pemesanan = rs.getString("status_pemesanan");
//                int status;
//                if (status_pemesanan.equals("MENUNGGU KURIR")) {
//                    status = 0;
//                } else if (status_pemesanan.equals("DIANTAR")) {
//                    status = 1;
//                } else {
//                    status = 2;
//                }
//
//                transaksi.setStatusPemesanan(status);

                daftarOrder.add(transaksi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return daftarOrder;
    }

    public ArrayList<Transaksi> ambilDaftarOrder(int idUser) {
        ArrayList<Transaksi> daftarOrder = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM transaksi WHERE id_kurir = " + idUser + " OR id_pelanggan = " + idUser + " ORDER BY tanggal DESC;";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Transaksi transaksi = new Transaksi();
                transaksi.setIdTransaksi(rs.getInt("id_transaksi"));
                transaksi.setIdPelanggan(rs.getInt("id_pelanggan"));
                transaksi.setIdKurir(rs.getInt("id_kurir"));
                transaksi.setKategoriBarang(rs.getString("kategori_barang"));
                transaksi.setBeratBarang(rs.getDouble("berat_barang"));
                transaksi.setJumlahBarang(rs.getDouble("jumlah_barang"));
                transaksi.setNamaPengirim(rs.getString("nama_pengirim"));
                transaksi.setAlamatPengirim(rs.getString("alamat_pengirim"));
                transaksi.setNoHpPengirim(rs.getString("noHP_pengirim"));
                transaksi.setNamaPenerima(rs.getString("nama_penerima"));
                transaksi.setAlamatPengirim(rs.getString("alamat_pengirim"));
                transaksi.setAlamatPenerima(rs.getString("alamat_penerima"));
                transaksi.setNoHpPenerima(rs.getString("noHP_penerima"));
                transaksi.setTotalPembayaran(rs.getDouble("total_pembayaran"));
                transaksi.setTanggal(rs.getDate("tanggal"));
                transaksi.setStatusPemesanan(rs.getInt("status_pemesanan"));

                daftarOrder.add(transaksi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return daftarOrder;
    }

    public ArrayList<Transaksi> ambilDaftarOrderMenunggu(ArrayList<Transaksi> daftarOrder) {
        ArrayList<Transaksi> daftarOrderMenunggu = new ArrayList<>();
        for (Transaksi order : daftarOrder) {
            if (order.getStatusPemesanan() == 1) {
                daftarOrderMenunggu.add(order);
            }
        }

        return daftarOrderMenunggu;
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
                    pelanggan.setIdUser(idUser);
                    pelanggan.setNamaDepan(namaDepan);
                    pelanggan.setNamaBelakang(namaBelakang);
                    pelanggan.setNoHp(noHp);
                    pelanggan.setEmailUser(emailUser);
                    pelanggan.setPassword(passwordUser);
                    pelanggan.setSaldo(saldo);
                    pelanggan.setRole(roleUser);
                    pelanggan.setListTransaksi(ambilDaftarOrder(idUser));//sementara
                    new UserManager().getInstance().setUser(pelanggan);
                } else if (roleUser == Role.KURIR) {
                    String query2 = "SELECT * FROM kurir WHERE id_user=" + idUser + ";";
                    try {
                        Statement stmt2 = conn.con.createStatement();
                        ResultSet rs2 = stmt2.executeQuery(query2);
                        while (rs2.next()) {
                            String NIK = rs2.getString("NIK");
//                            double totalPendapatan = rs2.getDouble("total_pendapatan");
                            int ketersediaanKurir = rs2.getInt("ketersediaan");
                            String platNomor = rs2.getString("plat");
                            String jenisKendaraan = rs2.getString("jenis_kendaraan");

                            Kurir kurir = new Kurir();
                            kurir.setIdUser(idUser);
                            kurir.setNamaDepan(namaDepan);
                            kurir.setNamaBelakang(namaBelakang);
                            kurir.setNoHp(noHp);
                            kurir.setEmailUser(emailUser);
                            kurir.setPassword(passwordUser);
                            kurir.setSaldo(saldo);
                            kurir.setRole(roleUser);
                            kurir.setListTransaksi(ambilDaftarOrder(idUser));
                            kurir.setNIK(NIK);
                            kurir.setKetersediaan(ketersediaanKurir);
                            kurir.setPlat(platNomor);
                            kurir.setJenisKendaraan(jenisKendaraan);
                            new UserManager().getInstance().setUser(kurir);

                        }
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                } else {
                    Admin admin = new Admin();
                    admin.setIdUser(idUser);
                    admin.setNamaDepan(namaDepan);
                    admin.setNamaBelakang(namaBelakang);
                    admin.setNoHp(noHp);
                    admin.setEmailUser(emailUser);
                    admin.setPassword(passwordUser);
                    admin.setSaldo(saldo);
                    admin.setRole(roleUser);
//                    admin.setTin
                    admin.setListTransaksi(ambilDaftarOrder());//sementara
                    admin.setListSaran(getSeluruhSaran());//sementara;
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

    public boolean isiSaldo(Pelanggan pelanggan, int saldo) {
        conn.connect();
        double total = pelanggan.getSaldo() + saldo;
        String query = "UPDATE user SET saldo = " + total + "WHERE id_user =" + pelanggan.getIdUser() + ";";

        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }

    }

    public ArrayList<Transaksi> getSeluruhTransaksi(){
        conn.connect();
        String query = "SELECT * FROM transaksi WHERE status_pemesanan='"+3+"';";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int idTransaksi = rs.getInt(1);
                int idPelanggan = rs.getInt(2);
                int idKurir=rs.getInt(3);
                String kategori = rs.getString(4);
                double berat=rs.getDouble(5);
                double jumlah=rs.getDouble(6);
                String namaPengirim=rs.getString(7);
                String namaPenerima=rs.getString(8);
                String noPengirim=rs.getString(9);
                String noPenerima=rs.getString(10);
                String alamatPemgirim=rs.getString(11);
                String alamatPenerima=rs.getString(12);
                double totalPembayaran=rs.getDouble(13);
                Date tanggal=rs.getDate(14);
                int statusPemesanan=rs.getInt(15);
                ArrayList<Chat> listChat=new ArrayList<>();
                Transaksi transaksi=new Transaksi(idTransaksi,idPelanggan,idKurir,kategori,berat,jumlah,namaPengirim,alamatPemgirim,noPengirim,namaPenerima,alamatPenerima,noPenerima,totalPembayaran,statusPemesanan,tanggal,listChat);
                listTransaksi.add(transaksi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listTransaksi;
    }

    public ArrayList<Saran> getSeluruhSaran() {
        conn.connect();
        String query = "SELECT * FROM saran";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int idSaran = rs.getInt(1);
                int idPelanggan = rs.getInt(2);
                String saran = rs.getString(3);
                Saran isiSaran = new Saran(idSaran, idPelanggan, saran);
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
            stmt.setInt(1, saran.getIdSaran());
            stmt.setInt(2, saran.getIdPelanggan());
            stmt.setString(3, saran.getSaran());
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }

    }

    public boolean updateDataPelanggan(String namaDpn, String namaBlkng, String email, String noHp, int idUser, String password) {
        conn.connect();
        String query = "UPDATE user SET nama_depan = ?, nama_belakang = ?, email_user = ?, noHp = ?, password = ? WHERE id_user = ?";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, namaDpn);
            stmt.setString(2, namaBlkng);
            stmt.setString(3, email);
            stmt.setString(4, noHp);
            stmt.setString(5, password);
            stmt.setInt(6, idUser);
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    public double bayarOrder(int idPelanggan, double totalBayar) {
        conn.connect();
        String query1 = "SELECT saldo FROM user WHERE id_user=" + idPelanggan + ";";
        double totalSekarang = 0;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query1);
            while ((rs.next())) {
                totalSekarang = rs.getDouble("saldo");

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        double totalNow = totalSekarang - totalBayar;
        String query2 = "UPDATE user SET saldo = " + totalNow + " WHERE id_user = " + idPelanggan + ";";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query2);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return totalSekarang - totalBayar;
    }

    public String getNamaLawanChat(Transaksi t, User u) {

        int getId = 0;
        if (u instanceof Pelanggan) {
            getId = t.getIdKurir();
        }
        if (u instanceof Kurir) {
            getId = t.getIdPelanggan();
        }
        conn.connect();
        String query = "SELECT * FROM user WHERE id_user = " + getId + ";";
        User user = new User();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {

                user.setNamaDepan(rs.getString("nama_depan"));
                user.setNamaBelakang(rs.getString("nama_belakang"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user.getNamaDepan() + " " + user.getNamaBelakang();
    }

    public int getIdLawanChat(Transaksi t, User userNow) {
        int getId = 0;
        if (userNow instanceof Pelanggan) {
            getId = t.getIdKurir();
        }
        if (userNow instanceof Kurir) {
            getId = t.getIdPelanggan();
        }
        conn.connect();
        String query = "SELECT * FROM user WHERE id_user = " + getId + ";";
        User user = new User();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                user.setIdUser(rs.getInt("id_user"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user.getIdUser();
    }

    public int getLastIdChat() {

        conn.connect();
        String query = "SELECT * FROM chat;";
        Chat c = new Chat();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {

                c.setIdChat(rs.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return c.getIdChat() + 1;
    }

    public boolean hapusAkun(int idUser) {
        conn.connect();
        String sql1 = "DELETE FROM kurir WHERE id_user=" + idUser + ";";
        String sql2 = "DELETE FROM transaksi WHERE id_pelanggan=" + idUser + " OR id_kurir=" + idUser + ";";
        String sql3 = "DELETE FROM chat WHERE id_pengirim=" + idUser + " OR id_penerima=" + idUser + ";";
        String sql4 = "DELETE FROM saran WHERE id_pelanggan=" + idUser + ";";
        String sql5 = "DELETE FROM user WHERE id_user=" + idUser + ";";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(sql1);
            stmt.executeUpdate(sql2);
            stmt.executeUpdate(sql3);
            stmt.executeUpdate(sql4);
            stmt.executeUpdate(sql5);
            return (true);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return (false);
        }
    }

    public TingkatanUser updateTingkatan(int idUser) {
        int banyakTransaksi = 0;
        conn.connect();
        String query = "SELECT count(" + idUser + ") AS banyakTransaksi FROM transaksi WHERE id_pelanggan = " + idUser;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                banyakTransaksi = rs.getInt("banyakTransaksi");
            }
            if (banyakTransaksi <= 10) {
                return TingkatanUser.BRONZE;
            } else {
                if (banyakTransaksi <= 20) {
                    return TingkatanUser.SILVER;
                } else {
                    return TingkatanUser.GOLD;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return TingkatanUser.BRONZE;
    }

    public void hapusChat(int idTransaksi) {
        conn.connect();
        String query = "DELETE FROM chat WHERE id_transaksi = " + idTransaksi + ";";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}