package Model;

public class Account implements Comparable<Account>{
    private String userName;
    private String password;
    private int level;
    private int exp;
    public Account(String userName, String password, int level, int exp){
        this.userName = userName;
        this.password = password;
        this.level = level;
        this.exp = exp;
    }
    public int compareTo(Account other){
        if (this.getLevel() != other.getLevel()){
            return Integer.compare(this.getLevel(), other.getLevel());
        }
        return Integer.compare(this.getExp(), this.getExp());
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public int getExp() {
        return exp;
    }
    public void setExp(int exp) {
        this.exp = exp;
    }
}
