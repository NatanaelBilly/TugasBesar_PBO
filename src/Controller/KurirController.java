/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.Controller.conn;

import Model.Kurir;
import Model.TingkatanUser;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Asus
 */
public class KurirController {

    private Controller con = new Controller();

    public boolean EditDataKurirToDB(Kurir kurir) {
        Controller.conn.connect();
        String query = "UPDATE user, kurir "
                + "SET "
                + "user.nama_depan='" + kurir.getNama_depan() + "', "
                + "user.nama_belakang='" + kurir.getNama_belakang() + "', "
                + "user.email_user='" + kurir.getEmail_user() + "', "
                + "user.password='" + kurir.getPassword()+ "', "
                + "user.noHp='" + kurir.getNoHp()+ "', "
                + "kurir.NIK= '" + kurir.getNIK() + "', "
                + "kurir.plat='" + kurir.getPlat() + "', "
                + "kurir.jenis_kendaraan='" + kurir.getJenis_kendaraan() + "' "
                + "WHERE user.id_user=" + kurir.getId_user()
                + " AND kurir.id_user=" + kurir.getId_user();
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
            stmt.setString(1, kurir.getNama_depan());
            stmt.setString(2, kurir.getNama_belakang());
            stmt.setString(3, kurir.getNoHp());
            stmt.setString(4, kurir.getEmail_user());
            stmt.setString(5, kurir.getPassword());
            stmt.setString(6, kurir.getRole().toString());
            stmt.setDouble(7, kurir.getSaldo());
            stmt.setString(8, TingkatanUser.KURIR.toString());
            stmt2.setString(1, kurir.getNIK());
            stmt2.setInt(2, kurir.getId_user());
            stmt2.setDouble(3, kurir.getTotal_pendapatan());
            stmt2.setInt(4, kurir.getKetersediaan());
            stmt2.setString(5, kurir.getPlat());
            stmt2.setString(6, kurir.getJenis_kendaraan());
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
