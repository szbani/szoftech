
package szoftech;

import java.util.Date;
import java.util.Vector;


public class esemeny {
    int id;
    private String név;
    String leírás;
    Vector<user> resztvevők; // az első a foglaló
    int kezdora, vegora;    // 8-22    
    Date nap;
    
    // esemenyre jelentkezés user hozz
    

    public esemeny() {
    }

    public Date getNap() {
        return nap;
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
        resztvevők.add(us);
    }
    public user getFoglaló(){
        return resztvevők.get(0);
    }
    
}
