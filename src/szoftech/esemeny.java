
package szoftech;


import java.util.Vector;


public class esemeny {
    
    private String nev;
    String leiras;
    int kezdora, vegora;    // 8-22    
    String nap;
    Vector<String> resztvevok = new Vector<String>(); // az első a foglaló
    Vector<String> ertekelesek=new Vector<String>();

    
    // esemenyre jelentkezés user hozz
    

    public esemeny(String nev,String leiras,int nap,int kezdora,int vegora) {
        this.nev=nev;
        this.leiras=leiras;
        //calendar
        this.nap=this.getNapString(nap);
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
        return(" "+id+". Esemény neve: "+this.nev+" foglaló: "+this.getFoglalo()+"\n\t"+this.leiras+"\n\t"+this.nap+", kezdés: "+this.kezdora+"-"+this.vegora+" óráig");
    }
    @Override
    public String toString() {
        String ret = this.nev+"#"+this.leiras+"#"+this.nap+"#"+this.kezdora+"#"+this.vegora;
        for (String string : resztvevok) {
            ret+=","+string;
        }
        ret+="#";
        for (String string : ertekelesek) {
            ret+=","+string;
        }
        return ret;
    }
    public String kiirErtekeles(){
        String a= this.nev+" Ertekelesek: ";
        for (String string : ertekelesek) {
            a+="\n\t"+string;
        }
        return a;
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
