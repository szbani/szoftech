
package szoftech;


public class user {
    private String user;
    protected String pw;
    private int rang;
    private String vezNev,kerNev;

    
    public user(String user,String pw,String veznev,String kerNev) {     
        this.user=user;
        this.pw=pw;
        this.rang=0;
    }
    

    public void setPw(String pw) {
        this.pw = pw;
    }

    public void setUserName(String user) {
        this.user = user;
    }
    


    public String getPw() {
        return pw;
    }

    public String getUser() {
        return user;
    }


    public void setRang(int rang) {
        this.rang = rang;
    }

    public int getRang() {
        return rang;
    }
    
    
    
    


}
