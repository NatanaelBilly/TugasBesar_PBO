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
public class Admin extends User{
    private int id_admin;

    public Admin(int id_admin, int id_user, String nama_depan, String nama_belakang, String email_user, String password, Role role) {
        super(id_user, nama_depan, nama_belakang, email_user, password, role);
        this.id_admin = id_admin;
    }

    public int getId_admin() {
        return id_admin;
    }

    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
    }
    
    
}
