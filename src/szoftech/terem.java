
package szoftech;

import java.util.*;

public class terem {
    String nev;
    int ferohely;
    String leiras;
    Vector<esemeny> eslist=new Vector<esemeny>();
    
    public terem(String nev,int ferohely,String leiras){
        this.nev = nev;
        this.ferohely = ferohely;
        this.leiras = leiras;
        betoltes();
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
    public void esemenytorol(int id){
        eslist.remove(id);
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
            String[] arr = es.split(",");
            try {
                Vector<String> users=new Vector<String>();
                for (int i = 7; i < arr.length; i++) {
                    users.add(arr[i]);
                }
                eslist.add(
                        new esemeny(arr[0],arr[1],
                                Integer.parseInt(arr[2]),Integer.parseInt(arr[3]),
                                Integer.parseInt(arr[4]),Integer.parseInt(arr[5]),Integer.parseInt(arr[6])));
                for (esemeny obj : eslist) {
                    for (int i = 0; i < users.size(); i++) {
                        obj.addUser(users.get(i));
                    }
                    
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            
        }
        return null;
    }
    public void addUser(int esid, String nev ){
        eslist.get(esid).addUser(nev);
    }
    public String kiirEsemennyel(){
        String ret="Név"+nev + ferohely + leiras;
        for (esemeny object : eslist) {
            ret+="\t"+object.kiir();
        }
        return ret;
    }
    public String kiirTerem(){
        String ret="Név"+nev + ferohely + leiras;
        
        return ret;
    }
    @Override
    public String toString(){
        return "Név"+nev + ferohely + leiras; 
    }

    //foglal�s �tk�z�s�nek leellen?rz�se
    


    
    //terem kont�ner oszt�ly
}
