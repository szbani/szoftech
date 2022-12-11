
package szoftech;

import java.util.*;

public class terem {
    String nev;
    int ferohely;
    Vector<esemeny> eslist=new Vector<esemeny>();
    
    public terem(String nev,int ferohely){
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
    
    public void addEsemeny(esemeny es){
        boolean foglalt = false;
        for (esemeny object : eslist) {
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
        for (esemeny obj : eslist) {
            System.out.println(obj.toString());
        }
    }
    public void mentes(){
        inputOutput ki = new inputOutput();
        ki.writeFile(eslist, nev+".txt");
    }
    public Vector<esemeny> betoltes(){
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
                        new esemeny(arr[0],
                                arr[1],
                                arr[2],
                                Integer.parseInt(arr[3]),
                                Integer.parseInt(arr[4])));
                for (esemeny obj : eslist) {
                    for (int i = 0; i < users.size(); i++) {
                        obj.addUser(users.get(i));
                    }                                   
                }
                
                for (esemeny obj : eslist) {
                    for (int i = 0; i < ertekelesek.size(); i++) {
                        obj.addErtekeles(ertekelesek.get(i));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }                       
        }
        return null;
    }public String kiirErtek(String username){
        String s = this.nev+" terem: \n";
            for (esemeny es : eslist) {
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
        for (esemeny object : eslist) {
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
