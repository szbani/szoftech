
package szoftech;


public class user {
    private static long idCount=1;
    private final long id;
    private String user;
    protected String pw;
    private int rang;

    public user() {
        idCount+=1;
        id=idCount;
        this.user="";
    }
    public user(String user,String pw) {
        idCount+=1;
        id=idCount;
        this.user=user;
        this.pw=pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public void setUserName(String user) {
        this.user = user;
    }
    
    public long getId() {
        return id;
    }

    public String getPw() {
        return pw;
    }

    public String getUser() {
        return user;
    }

    public static void setIdCount(long idCount) {
        idCount = idCount;
    }

    public void setRang(int rang) {
        this.rang = rang;
    }
    
    
    


}
