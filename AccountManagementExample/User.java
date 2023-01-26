/*
 * User
 * Kullanıcıyı temsil eder.
 * Constructor-> Yeni Kullanıcı oluşturulabilir. Aldığı parametreler = username(String), password (String)
 * setUsername -> Username parametresini değiştirir
 * setPassword -> password parametresini değiştirir.
 * getUsername -> username parametresini getirir.
 * getPassword -> password parametresini getirir.
 */


public class User{
    private String username, password;

    User (String username, String password){
        this.username=username;
        this.password=password;
    }

    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username=username;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password=password;
    }

}