
package szoftech;

import java.util.Calendar;
import java.util.Date;
import java.util.Vector;


public class esemeny {
    int id;
    private String név;
    String leírás;
    int kezdora, vegora;    // 8-22    
    Calendar nap = Calendar.getInstance();
    Vector<String> resztvevők; // az első a foglaló

    
    // esemenyre jelentkezés user hozz
    

    public esemeny(int id,String nev,String leiras,int év,int hónap,int nap,int kezdora,int vegora) {
        this.id=id;
        this.név=nev;
        this.leírás=leiras;
        //calendar
        this.kezdora=kezdora;
        this.vegora=vegora;
        
    }

    

    public int getKezdora() {
        return kezdora;
    }

    public int getVegora() {
        return vegora;
    }

    @Override
    public String toString() {
        return "\t"+this.id+". "+this.név+" foglaló: "+this.getFoglaló()+"\n\t\t"+this.leírás+"\n\t\t"+this.nap.toString()+", kezdés: "+this.kezdora+"-"+this.vegora+" óráig";
    }
    void addUser(user us){
        resztvevők.add(us.getNev());
    }
    public String getFoglaló(){
        return resztvevők.get(0);
    }
    
}
