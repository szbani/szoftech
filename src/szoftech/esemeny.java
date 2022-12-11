
package szoftech;


import java.util.Vector;


public class Esemeny {
    
    private String nev;
    String leiras;
    int kezdora, vegora;    // 8-22    
    String nap;
    Vector<String> resztvevok = new Vector<String>(); // az első a foglaló
    Vector<String> ertekelesek=new Vector<String>();

    
    // esemenyre jelentkezés user hozz
    

    public Esemeny(String nev,String leiras,int nap,int kezdora,int vegora) {
        this.nev=nev;
        this.leiras=leiras;
        //calendar
        this.nap=this.getNapString(nap);
        this.kezdora=kezdora;
        this.vegora=vegora;
        
    }
    public Esemeny(String nev,String leiras,String nap,int kezdora,int vegora) {
        this.nev=nev;
        this.leiras=leiras;
        //calendar
        this.nap=nap;
        this.kezdora=kezdora;
        this.vegora=vegora;
        
    }

    public void addErtekeles(String ert){
        ertekelesek.add(ert);
    }
    
    public int getKezdora() {
        return kezdora;
    }

    public int getVegora() {
        return vegora;
    }

    public String getNapString(int nap){
        switch (nap) {
            case 1:
                return "Hétfő";
            case 2:
                return "Kedd";
            case 3:
                return "Szerda";
            case 4:
                return "Csütörtök";
            case 5:
                return "Péntek";
            default:
                throw new AssertionError();
        }
    }
    public String kiir(int id){
        return(" "+id+". Esemény neve: "+this.nev+" foglaló: "+this.getFoglalo()+"\n\tLeírás: "+
                this.leiras+"\n\tkezdés: "+this.nap+" "+this.kezdora+"-"+this.vegora+" óráig");
    }
    @Override
    public String toString() {
        String ret = this.nev+"#"+this.leiras+"#"+this.nap+"#"+this.kezdora+"#"+this.vegora+"#";
        if (resztvevok.isEmpty()) {
            ret+=",";

        }
        for (String string : resztvevok) {
            ret+=string+",";
        }
        ret+="#";
        if (ertekelesek.isEmpty()) {
            ret+=",";

        }
        for (String string : ertekelesek) {
            ret+=string+",";
        }
        return ret;
    }
    public String kiirErtekeles(){
        if (!ertekelesek.isEmpty()) {
            String a= this.nev+"(nevü esemeny) Értékelesei: ";
        for (String string : ertekelesek) {
            a+="\n\t"+string;
        }
        return a+"\n";
        }
        return "Nincs értékelés";
    }
    public boolean egyidopont(Esemeny masik){
        return this.nap.equals(masik.nap);
    }
    public void addUser(String us){
        resztvevok.add(us);
    }
    public void addUser(Felhasznalo us){
        if(!resztvevok.contains(us)){
            resztvevok.add(us.getNev());
        }
    }
    public String getFoglalo(){
        return resztvevok.get(0);
    }
    
}
