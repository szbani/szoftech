package szoftech;

import java.util.List;
import java.util.Vector;

public class Termek {

    Vector<Terem> trmList = new Vector<Terem>();

    public Termek() {
        inputOutput be = new inputOutput();
        List<String> list = be.getFile("termek.txt");
        for (String us : list) {
            String[] arr = us.split(" ");
            try {
                trmList.add(new Terem(arr[0], Integer.parseInt(arr[1])));

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public void teremLetrehozas(Terem t) {        
        if (this.checkCredentials(t)) {
            trmList.add(t);
            mentes();
        }
    }

    public void teremEsemenyereJelentkezes(String teremnev, int esId, Felhasznalo us) {
        boolean volt = false;
        for (Terem object : trmList) {
            if (object.getNev().equals(teremnev)) {
                object.addUser(esId, us.getNev());
                volt = true;
                mentes();
            }
        }
        if (volt) {
            System.out.println("A Jelentkezés megtörtént!");
        } else {
            System.out.println("Hiba: Nem történt jelentkezés!");
        }
    }

    public void addEsemeny(String teremnev, Esemeny es, Felhasznalo us) {
        for (Terem object : trmList) {
            if (object.getNev().equals(teremnev)) {
                es.addUser(us.getNev());
                object.addEsemeny(es);
                mentes();
            }
        }
    }

    public void torlesTeremEsemenye(String teremnev, int id) {
        for (Terem object : trmList) {
            if (object.getNev().equals(teremnev)) {
                object.esemenytorol(id - 1);
                mentes();
                break;
            }
        }
    }

    public boolean checkCredentials(Terem t) {
        for (Terem us : trmList) {
            if (us.getNev().equals(t.getNev())) {
                System.out.println("A Terem már létezik!");
                return false;
            }

        }
        return true;
    }

    public void mentes() {
        inputOutput ki = new inputOutput();
        ki.writeFile(trmList, "termek.txt");
    }
    public void listAllSajatErtekeles(String foglalo){
        System.out.println("");
        System.out.println("Saját értékelések:");
        for (Terem object : trmList) {
            System.out.println(object.kiirErtek(foglalo)+"\n");                
        }       
    }
    public void listAllSajatEsemeny(String foglalo) {
        System.out.println("");
        System.out.println("Saját események:");
        for (Terem object : trmList) {
            for (Esemeny object2 : object.eslist) {
                if (object2.getFoglalo().equals(foglalo)) {
                    System.out.println(object.kiirEsemennyel());
                }
            }
        }
    }

    public void listAllEsemeny() {
        System.out.println("");
        System.out.println("Termek:");
        for (Terem object : trmList) {
            System.out.println(object.kiirEsemennyel());
        }

    }

    public void listAllTeremSima() {
        System.out.println("");
        System.out.println("Termek:");
        for (Terem object : trmList) {
            System.out.println(object.kiirTerem());
        }
    }

    public void listOneTeremEsemeny(String teremnev) {
        for (Terem object : trmList) {
            if (object.nev.equals(teremnev)) {
                System.out.println(object.kiirEsemennyel());
            }
        }
    }

    public void addErtekeles(String teremnev, int esid, String ertekeles) {
        Terem t = null;
        for (Terem object : trmList) {
            if (object.getNev().equals(teremnev)) {
                t = object;
                break;
            }
        }if(t != null){
            t.addErtekels(esid-1, ertekeles);
        }

    }
    public boolean esmenyLetezik(String nev,int esID){
        for (Terem object : trmList) {
            if (object.getNev().equals(nev)) {
                return object.esIdLetezik(esID-1);
            }
        }
        return false;
    }
    public boolean teremLetezik(String nev){
        for (Terem object : trmList) {
            if (object.getNev().equals(nev)) {
                return false;
            }
        }
        return true;
    }
}
