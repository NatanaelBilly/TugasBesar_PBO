package Controller;

import static Controller.Controller.conn;

import Model.Kurir;
import Model.TingkatanUser;
import Model.User;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class KurirController {
    private Controller con = new Controller();

    public boolean EditDataKurirToDB(Kurir kurir) {
        Controller.conn.connect();
        String query = "UPDATE user, kurir "
                + "SET "
                + "user.nama_depan='" + kurir.getNamaDepan() + "', "
                + "user.nama_belakang='" + kurir.getNamaBelakang() + "', "
                + "user.email_user='" + kurir.getEmailUser() + "', "
                + "user.password='" + kurir.getPassword()+ "', "
                + "user.noHp='" + kurir.getNoHp()+ "', "
                + "kurir.NIK= '" + kurir.getNIK() + "', "
                + "kurir.plat='" + kurir.getPlat() + "', "
                + "kurir.jenis_kendaraan='" + kurir.getJenisKendaraan() + "' "
                + "WHERE user.id_user=" + kurir.getIdUser()
                + " AND kurir.id_user=" + kurir.getIdUser();
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    public boolean RegisterKurir(Kurir kurir) {
        System.out.println(kurir.toString());
        conn.connect();
        String query1 = "INSERT INTO user VALUES (?,?,?,?,?,?,?,?,?)";
        String query2 = "INSERT INTO kurir VALUES (?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query1);
            PreparedStatement stmt2 = conn.con.prepareStatement(query2);
            stmt.setInt(1,kurir.getIdUser());
            stmt.setString(2, kurir.getNamaDepan());
            stmt.setString(3, kurir.getNamaBelakang());
            stmt.setString(4, kurir.getNoHp());
            stmt.setString(5, kurir.getEmailUser());
            stmt.setString(6, kurir.getPassword());
            stmt.setString(7, kurir.getRole().toString());
            stmt.setDouble(8, kurir.getSaldo());
            stmt.setString(9, TingkatanUser.KURIR.toString());
            stmt2.setString(1, kurir.getNIK());
            stmt2.setInt(2, kurir.getIdUser());
            stmt2.setInt(3, kurir.getKetersediaan());
            stmt2.setString(4, kurir.getPlat());
            stmt2.setString(5, kurir.getJenisKendaraan());
            stmt.executeUpdate();
            stmt2.executeUpdate();
            return (true);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }

    }
    
    public boolean ambilOrderOlehKurir(int idTransaksi, int idKurir)
    {
        Controller.conn.connect();
        String query = "UPDATE transaksi "
                + "SET "
                + "status_pemesanan = 'DIANTAR' ,"
                + "id_kurir = " + idKurir
                + " WHERE id_transaksi=" + idTransaksi;
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
    
    public boolean konfirmasiOrderOlehKurir(int idTransaksi)
    {
        Controller.conn.connect();
        String query = "UPDATE transaksi "
                + "SET "
                + "status_pemesanan = 'DITERIMA' "
                + " WHERE id_transaksi=" + idTransaksi;
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
    
    public Kurir prosesPembayaran(double biaya, int idKurir)
    {
        Controller con = new Controller();
        User admin = con.ambilDataUser(1);
        
        Kurir kurir = con.ambilDataKurir(idKurir);
        
        kurir.setSaldo(kurir.getSaldo() + (biaya * 0.7));
        double totalSaldoAdmin = admin.getSaldo() + (biaya * 0.3);
        
        if(ubahSaldoUser(1, totalSaldoAdmin))
        {
            if(ubahSaldoUser(kurir.getIdUser(), kurir.getSaldo()))
            {
                return kurir;
            }
        }
        
        return null;
    }
    
    public boolean ubahSaldoUser(int idUser, double saldo) {
        Controller.conn.connect();
        String query = "UPDATE user "
                + "SET "
                + "saldo = " + saldo
                + " WHERE id_user= " + idUser;
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
    
    public boolean ubahKetersediaanKurir(int idKurir, int ketersediaan) {
        Controller.conn.connect();
        String query = "UPDATE kurir "
                + "SET "
                + "ketersediaan = " + ketersediaan
                + " WHERE id_user= " + idKurir;
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
    
    public boolean cekKurirLogin()
    {
        return (Kurir) new Model.UserManager().getInstance().getUser() == null;
    }
    


}
