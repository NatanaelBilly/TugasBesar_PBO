package Controller;

import static Controller.Controller.conn;

import Model.Kurir;
import Model.TingkatanUser;
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
        conn.connect();
        String query1 = "INSERT INTO user VALUES (null,?,?,?,?,?,?,?,?)";
        String query2 = "INSERT INTO kurir VALUES (?,?,?,?,?,?)";

        try {
            PreparedStatement stmt = conn.con.prepareStatement(query1);
            PreparedStatement stmt2 = conn.con.prepareStatement(query2);
            stmt.setString(1, kurir.getNamaDepan());
            stmt.setString(2, kurir.getNamaBelakang());
            stmt.setString(3, kurir.getNoHp());
            stmt.setString(4, kurir.getEmailUser());
            stmt.setString(5, kurir.getPassword());
            stmt.setString(6, kurir.getRole().toString());
            stmt.setDouble(7, kurir.getSaldo());
            stmt.setString(8, TingkatanUser.KURIR.toString());
            stmt2.setString(1, kurir.getNIK());
            stmt2.setInt(2, kurir.getIdUser());
            stmt2.setDouble(3, kurir.getTotalPendapatan());
            stmt2.setInt(4, kurir.getKetersediaan());
            stmt2.setString(5, kurir.getPlat());
            stmt2.setString(6, kurir.getJenisKendaraan());
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
