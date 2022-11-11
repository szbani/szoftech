
package szoftech;


public class user {
    
    private long id;
    private final String user;
    protected String pw;

    public user(String user,String pw) {
        this.user=user;
        this.pw=pw;
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
