
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
        eslist.remove(id);
    }
    public void setNev(String nev){
        this.nev = nev;
    }
    public void setFerohely(int ferohely){
        this.ferohely = ferohely;
    }
    
    public void addEsemeny(esemeny es){
        if (eslist.size()==ferohely) {
            System.out.println("Betelt A Terem !");
        }
        else{
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
                for (int i = 7; i < arr.length; i++) {
                    users.add(arr[i]);
                }
                eslist.add(
                        new esemeny(arr[0],arr[1],
                                Integer.parseInt(arr[2]),
                                Integer.parseInt(arr[3]),
                                Integer.parseInt(arr[4])));
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
        String ret = "Terem :"+this.nev+" ";
        for (esemeny object : eslist) {
            ret+="\t"+object.kiir(eslist.indexOf(object)+1);
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

    //foglal�s �tk�z�s�nek leellen?rz�se
    


    
    //terem kont�ner oszt�ly
}
