
package szoftech;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Vector;


public class esemeny {
    private String név;
    String leírás;
    int kezdora, vegora;    // 8-22    
    GregorianCalendar nap;
    Vector<String> resztvevők; // az első a foglaló

    
    // esemenyre jelentkezés user hozz
    

    public esemeny(String nev,String leiras,int év,int hónap,int nap,int kezdora,int vegora) {
        this.név=nev;
        this.leírás=leiras;
        //calendar
        this.nap= new GregorianCalendar(év,hónap,nap);        
        this.kezdora=kezdora;
        this.vegora=vegora;
        
    }

    

    public int getKezdora() {
        return kezdora;
    }

    public int getVegora() {
        return vegora;
    }

    public void kiir(){
        System.out.println(this.név+" foglaló: "+this.getFoglaló()+"\n\t\t"+this.leírás+"\n\t\t"+this.nap.toString()+", kezdés: "+this.kezdora+"-"+this.vegora+" óráig");
    }
    @Override
    public String toString() {
        String ret = this.név+","+this.leírás+","+this.kezdora+","+this.vegora+","+this.nap.toString()+",";
        for (String string : resztvevők) {
            ret+=","+string;
        }
        return ret;
    }

    void addUser(String us){
        resztvevők.add(us);
    }
    void addUser(user us){
        resztvevők.add(us.getNev());
    }
    public String getFoglaló(){
        return resztvevők.get(0);
    }
    
}
