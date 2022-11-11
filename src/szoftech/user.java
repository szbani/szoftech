
package szoftech;


public class user {
    private String user;
    protected String pw;
    private int rang;
    private String vezNev,kerNev;

    public user(String user,String pw,String veznev,String kerNev,int rang) {     
        this.user=user;
        this.pw=pw;
        this.vezNev=veznev;
        this.kerNev=kerNev;
        this.rang=rang;
    }
    public user(String user,String pw,String veznev,String kerNev) {     
        this.user=user;
        this.pw=pw;
        this.vezNev=veznev;
        this.kerNev=kerNev;
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
    

    @Override
    public String toString(){        
        return this.user+" "+this.pw+" "+this.vezNev+" "+this.kerNev+" "+this.rang;
        
    }
    
    


}
