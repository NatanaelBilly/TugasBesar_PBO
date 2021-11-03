
package Controller;

import Database.Database;
import Model.Role;
import Model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author MrKaisar
 */
public class Controller {
    static Database conn = new Database();
    
    public ArrayList<User> getAllUsers() {
        ArrayList<User> users = new ArrayList<>();
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
}
