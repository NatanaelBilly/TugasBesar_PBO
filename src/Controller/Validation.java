package Controller;

public class Validation {

    static public boolean cekEmail(String email){
        String regex = "^(.+)@(.+)$";
        return email.matches(regex);
    }

    static public boolean cekNoHP(String noHp){
        String regex = "^[0-9]+.{8,15}$";
        return noHp.matches(regex);
    }

}
