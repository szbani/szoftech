package szoftech;

import java.util.List;
import java.util.Vector;

public class teremcontainer {
        Vector<terem> trmList=new Vector<terem>();

    public teremcontainer() {
        inputOutput be = new inputOutput();
        List<String> list = be.getFile("termek.txt");
        for (String us : list) {
            String[] arr = us.split(" ");
            try {
                trmList.add(new terem(arr[0],Integer.parseInt(arr[1]),arr[2]));
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            
        }        
    }
    public void addTerem(terem t){
        if (this.checkCredentials(t)) {
            trmList.add(t);
        }
    }
    public void teremEsemenyereJelentkezes(String teremnev, int esId, user us){
        for (terem object : trmList) {
            if (object.getNev().equals(teremnev)) {
                object.addUser(esId, us.getNev());

            }
        }
    }
    public void addEsemeny(String teremnev,esemeny es){
        for (terem object : trmList) {
            if (object.getNev().equals(teremnev)) {
                object.addEsemeny(es);
            }
        }
    }
    public void modositLeiras(String terem,String ujleiras){
        for (terem object : trmList) {
            if(object.getNev().equals(object)){
                object.setLeiras(ujleiras);                    //lehet nem mukodik Sorry
            }
        }        
    }
    public void modositFerohely(String terem,int ujferohely){
        for (terem object : trmList) {
            if(object.getNev().equals(object)){
                object.setFerohely(ujferohely);                  //lehet nem mukodik Sorry
            }
        }        
    }
    public void torlesTerem(String terem){
        for (terem object : trmList) {
            if(object.getNev().equals(object)){
                trmList.remove(object);                    //lehet nem mukodik Sorry
            }
        }        
    }
    public void torlesTeremEsemenye(String terem, int id){
        for (terem object : trmList) {
            if (object.getNev().equals(terem)) {
                object.esemenytorol(id-1);
                System.out.println("Az esemény Törlése megtörtént!");
                break;
            }
        }        
    }
    public boolean checkCredentials(terem t){
        for (terem us : trmList) {            
            if (us.getNev().equals(t.getNev())) {
                System.out.println("A Terem már létezik!");
                return false;
            }
            
        }
        return true;
    }
    public void mentes(){
        inputOutput ki = new inputOutput();        
        ki.writeFile(trmList, "termek.txt");
    }
    public void listAllSajatEsemeny(String foglalo){
        for (terem object : trmList) {
            for (esemeny object2 : object.eslist) {
                if(object2.getFoglalo().equals(foglalo)){
                    System.out.println(object.kiirEsemennyel());
                }
            }
        }
    }
    public void listAllTeremSima(String teremnev){
        for (terem object : trmList) {
            object.kiirTerem();
        }
    }
    public void listAllTeremEsemennyel(){
        for (terem object : trmList) {
            System.out.println(object.kiirEsemennyel());
        }
    }
    public void listOneTeremEsemeny(String teremnev){
        for (terem object : trmList) {
            if(object.nev.equals(teremnev))
                System.out.println(object.kiirEsemennyel());
        }
    }
}
