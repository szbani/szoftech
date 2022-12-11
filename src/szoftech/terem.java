
package szoftech;

import java.util.*;

public class Terem {
    String nev;
    int ferohely;
    Vector<Esemeny> eslist=new Vector<Esemeny>();
    
    public Terem(String nev,int ferohely){
        this.nev = nev;
        this.ferohely = ferohely;
        betoltes();
    }
    
    
    public int getFerohely(){
        return ferohely;
    }
    public String getNev(){
        return nev;
    }
    public void esemenytorol(int id){
        if (id<eslist.size()) {
            eslist.remove(id);
        System.out.println("Az esemény Törlése megtörtént!");

        }
        else System.out.println("Nem jó ID-t adtál meg (Művelet megszakítása)!");
    }
    
    public void addEsemeny(Esemeny es){
        boolean foglalt = false;
        for (Esemeny object : eslist) {
            if (object.egyidopont(es)) {
                foglalt=true;
            }
        }
        if (foglalt) {
            System.out.println("Az időpont foglalt");
        }
        else eslist.add(es);
        mentes();
        
    }
    public void listEsemeny(){
        for (Esemeny obj : eslist) {
            System.out.println(obj.toString());
        }
    }
    public void mentes(){
        inputOutput ki = new inputOutput();
        ki.writeFile(eslist, nev+".txt");
    }
    public Vector<Esemeny> betoltes(){
        inputOutput be = new inputOutput();
        List<String> list = be.getFile(nev+".txt");
        for (String es : list) {
            String[] arr = es.split("#");
            try {
                Vector<String> users=new Vector<String>();
                String[] arrus = arr[5].split(",");
                for (int i = 0; i < arrus.length; i++) {
                    users.add(arrus[i]);
                }
                Vector<String> ertekelesek=new Vector<String>();
                String[] arrert = arr[6].split(",");
                
                for (int i = 0; i < arrert.length; i++) {
                    ertekelesek.add(arrert[i]);
                }
                eslist.add(
                        new Esemeny(arr[0],
                                arr[1],
                                arr[2],
                                Integer.parseInt(arr[3]),
                                Integer.parseInt(arr[4])));
                for (Esemeny obj : eslist) {
                    for (int i = 0; i < users.size(); i++) {
                        obj.addUser(users.get(i));
                    }                                   
                }
                
                for (Esemeny obj : eslist) {
                    for (int i = 0; i < ertekelesek.size(); i++) {
                        obj.addErtekeles(ertekelesek.get(i));
                    }
                }
            } catch (Exception e) {
            }                       
        }
        return null;
    }public String kiirErtek(String username){
        String s = this.nev+" terem: \n";
            for (Esemeny es : eslist) {
                if(es.getFoglalo().equals(username))
                s+= es.kiirErtekeles()+" ";
            }
        return s;
    }
    public void addErtekels(int esid, String ertekeles ){
        eslist.get(esid).addErtekeles(ertekeles);
        mentes();
    }
    public void addUser(int esid, String nev ){
        if (eslist.size()==ferohely) {
            System.out.println("Betelt A Terem !");
        }
        else{
            eslist.get(esid-1).addUser(nev);

        }
        mentes();
    }
    public String kiirEsemennyel(){
        String ret = "Terem :"+this.nev+" ";
        for (Esemeny object : eslist) {
            ret+="\n\t"+object.kiir(eslist.indexOf(object)+1);
        }
        return ret;
    }
    public String kiirTerem(){
        String ret="Név: "+nev+" Férőhely: " + ferohely;
        
        return ret;
    }
    @Override
    public String toString(){
        return nev+" "+ferohely; 
    }
    public boolean esIdLetezik(int ID){
        return this.eslist.size()>ID;
    }
    //foglal�s �tk�z�s�nek leellen?rz�se
    


    
    //terem kont�ner oszt�ly

}
