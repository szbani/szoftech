
package szoftech;


public class user {
    private String user;
    protected String pw;
    protected Rang rang;
    private String vezNev,kerNev;
    private boolean jelentkezett=false;

    public user(String user,String pw,String veznev,String kerNev,int rang, Boolean b) {     
        this.user=user;
        this.pw=pw;
        this.vezNev=veznev;
        this.kerNev=kerNev;
        this.rang=new Rang(rang);
        this.jelentkezett = b;
    }
    public user(String user,String pw,String veznev,String kerNev) {     
        this.user=user;
        this.pw=pw;
        this.vezNev=veznev;
        this.kerNev=kerNev;
        this.rang= new Rang(0);
    }
    public void specReg(int rang){
        jelentkezett=true;
        this.rang.setRang(rang);
    }
    
    public void elfogad(){
        this.jelentkezett=false;
    }
    

   

    
    


    public String getPw() {
        return pw;
    }

    public String getUser() {
        return user;
    }

    public boolean isJelentkezett() {
        return !jelentkezett;
    }

    public int getRang() {
        return rang.getRang();
    }
    public String getNev(){
        return this.vezNev+" "+this.kerNev;
    }
    public void kiir(int sorszam){
        String s=sorszam+" - "+getUser()+ " " +getNev();
        if (jelentkezett) {
            s+=" Jelentekezett : "+this.rang.getRangString()+"-ra";
        }
        else s+=" Rangja: "+this.rang.getRangString();
        System.out.println(s);
    }
    @Override
    public String toString(){        
        return this.user+" "+this.pw+" "+this.vezNev+" "+this.kerNev+" "+this.rang+ " " +this.jelentkezett;
    }
    
    


}
