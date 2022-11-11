
package szoftech;


public class user {
    private static long idCount;
    private final long id;
    private String user;
    protected String pw;

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
    


}
