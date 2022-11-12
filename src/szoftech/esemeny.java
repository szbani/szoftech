
package szoftech;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Vector;


public class esemeny {
    private String nev;
    String leiras;
    int kezdora, vegora;    // 8-22    
    Date nap;
    Vector<String> resztvevok = new Vector<String>(); // az els? a foglaló

    
    // esemenyre jelentkezés user hozz
    

    public esemeny(String nev,String leiras,int ev,int hónap,int nap,int kezdora,int vegora) {
        this.nev=nev;
        this.leiras=leiras;
        //calendar
        this.nap= new Date(ev,hónap,nap);
        this.kezdora=kezdora;
        this.vegora=vegora;
        
    }

    
    public int getKezdora() {
        return kezdora;
    }

    public int getVegora() {
        return vegora;
    }

    public String kiir(){
        return(this.nev+" foglaló: "+this.getFoglalo()+"\n\t\t"+this.leiras+"\n\t\t"+this.nap.toString()+", kezdés: "+this.kezdora+"-"+this.vegora+" óráig");
    }
    @Override
    public String toString() {
        String ret = this.nev+","+this.leiras+","+this.kezdora+","+this.vegora+","+this.nap.getYear()+","+nap.getMonth()+","+nap.getDate();
        for (String string : resztvevok) {
            ret+=","+string;
        }
        return ret;
    }
    
    public boolean egyidopont(esemeny masik){
        return this.nap.equals(masik.nap);
    }
    public void addUser(String us){
        resztvevok.add(us);
    }
    public void addUser(user us){
        resztvevok.add(us.getNev());
    }
    public String getFoglalo(){
        return resztvevok.get(0);
    }
    
}
