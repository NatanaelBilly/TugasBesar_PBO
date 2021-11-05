/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.Controller.conn;
import Model.Kurir;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Asus
 */
public class KurirController {
    
    private Controller con = new Controller();
    
    public boolean editDataKurirToDB(Kurir kurir)
    {
        Controller.conn.connect();
        String query = "UPDATE user, kurir "
                + "SET "
                + "user.nama_depan='" + kurir.getNama_depan()+ "', "
                + "user.nama_belakang='" + kurir.getNama_belakang()+ "', "
                + "user.email_user='" + kurir.getEmail_user()+ "', "
                + "kurir.NIK= '" + kurir.getNIK()+ "', "
                + "kurir.plat='" + kurir.getPlat()+ "', "
                + "kurir.jenis_kendaraan='" + kurir.getJenis_kendaraan()+ "' "
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
    
}
