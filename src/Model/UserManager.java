package Model;

public class UserManager {
    //Lazy Instantiation
    private static UserManager instance;
    private Pelanggan pelanggan;
    private Kurir kurir;
    private Admin admin;


    public static UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }

    public User getUser() {
        if (pelanggan != null) {
            return getPelanggan();
        } else if (kurir != null) {
            return getKurir();
        } else {
            return getAdmin();
        }
    }

    public void setUser(User user) {
        if (user instanceof Pelanggan) {
            this.pelanggan = (Pelanggan) user;
        } else if (user instanceof Kurir) {
            this.kurir = (Kurir) user;
        } else {
            this.admin = (Admin) admin;
        }
    }

    public Pelanggan getPelanggan() {
        return pelanggan;
    }

    public Admin getAdmin() {
        return admin;
    }

    public Kurir getKurir() {
        return kurir;
    }

    public void logOut() {
        instance = null;
    }


}
