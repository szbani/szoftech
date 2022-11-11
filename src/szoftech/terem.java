
package szoftech;

import java.util.Vector;

public class terem {
    String nev;
    int ferohely;
    String leiras;
    Vector<esemeny> eslist=new Vector<esemeny>();
    
    public terem(String nev,int ferohely,String leiras){
        this.nev = nev;
        this.ferohely = ferohely;
        this.leiras = leiras;
    }
    
    public String getLeiras(){
        return leiras;
    }
    public int getFerohely(){
        return ferohely;
    }
    public String getNev(){
        return nev;
    }
    
    public void setNev(String nev){
        this.nev = nev;
    }
    public void setFerohely(int ferohely){
        this.ferohely = ferohely;
    }
    public void setLeiras(String leiras){
        this.leiras = leiras;
    }
    
    public void addEsemeny(esemeny es){
        eslist.add(es);
    }
    public void listEsemeny(){
        for (esemeny obj : eslist) {
            System.out.println();
        }
    }
    public void mentes(){
        inputOutput ki = new inputOutput();
        ki.writeFile(eslist, nev+".txt");
    }
    public Vector<esemeny> betoltes(){
        return null;
    }
    public String toString(){
        return nev + ferohely + leiras; 
    }
    //addesemeny
    //foglalás ütközésének leellenőrzése
    //események betöltése
    //esemény mentése
    
    //terem konténer osztály
}
