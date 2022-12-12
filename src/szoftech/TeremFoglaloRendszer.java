package szoftech;

import java.io.*;
import java.util.*;

public class TeremFoglaloRendszer {

    inputOutput inp = new inputOutput();
    Boolean exit = false;
    Felhasznalo user = null;
    Felhasznalok users = new Felhasznalok();
    Termek termek = new Termek();

    public static void main(String[] args) {
        System.out.println("!!!Kérlek a program futása során ne használj ékezetes betűkjet!!!");
        TeremFoglaloRendszer sz = new TeremFoglaloRendszer();

        while (!sz.exit) {
            if (sz.user == null) {
                sz.loginMenu();
            } else {
                sz.mainMenu();
            }

        }
    }

    public void loginMenu() {
        System.out.println("");
        System.out.println("Menü:");
        System.out.println("1 - Belépés");
        System.out.println("2 - Regisztráció");
        System.out.println("3 - Speciális regisztráció");
        System.out.println("0 - Kilépés");
        loginMenuEvents();
    }

    public void loginMenuEvents() {
        switch (inp.inputSzam("Add meg a Parancs számát: ")) {
            case 0:
                exit = true;
                break;
            case 1:
                //bejelentkezés
                loginUser();
                break;
            case 2:
                //regisztráció
                registerUser();
                break;
            case 3:
                //regisztráció
                //registerUser();
                registerSpecialUser();
                break;
            default:
                System.out.println("Rossz számot adtál meg");
                break;
        }
    }

    public void loginUser() {
        System.out.println("");
        System.out.println("Bejelentkezés");

        user = users.loginUser(inp.inputString("Felhasználónév: "), inp.inputString("Jelszó: "));

    }

    public void registerUser() {
        System.out.println("");
        System.out.println("Regisztráció");
        Felhasznalo us = new Felhasznalo(inp.inputString("Felhasználónév: "), inp.inputString("Jelszó: "),
                inp.inputString("Vezetéknév: "), inp.inputString("Keresztnév:"));
        users.addUser(us);
        users.mentes();
    }
    
    public void registerSpecialUser() {
        System.out.println("");
        System.out.println("Regisztráció");
        Felhasznalo us = new Felhasznalo(inp.inputString("Felhasználónév: "), inp.inputString("Jelszó: "),
                inp.inputString("Vezetéknév: "), inp.inputString("Keresztnév:"));
        users.addSpecialuser(us, inp.inputSzam("Milyen rangot szeretnél?\n1 - Foglaló \t2 - Operátor\n"));
        users.mentes();
    }

    public void mainMenu() {
        System.out.println("");
        System.out.println("Fiók: " + user.getNev() + " - " + user.rang.getRangString());
        if(user.getRang() == 0){
        System.out.println("1 - Események Megtekintése");
        System.out.println("2 - Eseményre jelentkezés");
        System.out.println("3 - Értékelés írása");
        }
        else if (user.getRang() == 1) {
            System.out.println("1 - Terem foglalás");
            System.out.println("2 - Foglalás törlése");
            System.out.println("3 - Saját foglalások megtekintése");
            System.out.println("4 - Értékelések megtekintése");
        }
        else if (user.getRang() == 2) {
            System.out.println("1 - Terem Hozzáadása");
            System.out.println("2 - Felhasználók kilistázása");
            System.out.println("3 - Felhasználó törlése");
            System.out.println("4 - Speciális regisztráció elfogadása");
        }
        System.out.println("0 - Kijelentkezés");
        mainMenuEvents();
    }

    public void mainMenuEvents() {
        int parancs = inp.inputSzam("Add meg a Parancs számát: ");
        if (user.getRang() == 0){
            switch (parancs) {
                case 0:
                    //kijelentkezes
                    logOut();
                    break;
                case 1:
                    //események megtekintése
                    System.out.println("");
                    termek.listAllEsemeny();                                        
                    break;
                case 2:
                    //esemenyre jelentkezes
                    termek.listAllEsemeny();
                    String nev=inp.inputString("Terem neve: ");
                    while (termek.teremLetezik(nev)) {
                        System.out.println("Nem létezik a megadott nevü terem!");
                        nev=inp.inputString("Újra a Terem neve: ");
                    }
                    int esID= inp.inputSzam("Esemény száma: ");
                    while (!termek.esmenyLetezik(nev,esID)) {                        
                        System.out.println("Nem létezik az esemény adott számon!");
                        esID= inp.inputSzam("Újra az Esemény száma: ");
                    }
                    termek.teremEsemenyereJelentkezes(nev,esID , user);
                    break;
                case 3:
                    //Értékelés irása
                    System.out.println("");
                    
                    termek.addErtekeles(inp.inputString("Terem neve: "), inp.inputSzam("Esemény száma: "), inp.inputString("Értékelés: "));
                    break;
                default:
                    System.out.println("Rossz számot adtál meg");
            }
        }
        else if (user.getRang() == 1) {
            switch (parancs) {
                case 0:
                    //kijelentkezes
                    logOut();
                    break;
                case 1:
                    //Terem foglalás
                    System.out.println("");
                    termek.listAllEsemeny();
                    termek.addEsemeny(inp.inputString("Terem neve: "),
                            new Esemeny(inp.inputString("Esemény neve: "),inp.inputString("Leírás: "), 
                                     inp.inputSzam("Nap: (1 - hérfő, 2  - kedd, 3 - szerda, 4 - csütörtök, 5 - péntek)\n"),inp.inputSzam("Kezdés(óra): "),
                                    inp.inputSzam("Vége(óra): ")),user);
                    break;
                case 2:
                    //terem foglalás törlése
                    System.out.println("");
                    termek.torlesTeremEsemenye(inp.inputString("Terem neve: "), inp.inputSzam("Esemény száma: "));
                    break;
                case 3:
                    //Saját foglalások megtekintése
                    System.out.println("");
                    termek.listAllSajatEsemeny(user.getNev());
                    break;
                case 4:
                    //értékelések megtekintése
                    System.out.println("");
                    termek.listAllSajatErtekeles(user.getNev());
                    break;
                default:
                    System.out.println("Rossz számot adtál meg");
            }
        }
        else if (user.getRang() == 2) {
            switch (parancs) { 
                case 0:
                    //kijelentkezes
                    logOut();
                    break;
                case 1:
                    //Terem létrehozása
                    System.out.println("");
                    String teremNev=inp.inputString("Neve: ");
                    while (!termek.teremLetezik(teremNev)) {
                        System.out.println("Már létezik a megadott nevü terem!");
                        teremNev=inp.inputString("Újra a Terem neve: ");    
                    }
                    termek.teremLetrehozas(new Terem(teremNev,inp.inputSzam("Férőhely: ")));
                    break;
                case 2:
                    //felheasznalok kilistázása
                    System.out.println("");
                    users.felhasznalokKilistazasa();
                    break;
                case 3:
                    //felhasználó törlése
                    System.out.println("");
                    users.felhasznalokTorlese(inp.inputString("Felhasználónév: "));
                    break;
                case 4:
                    //Speciális regisztráció elfogadása
                    System.out.println("");
                    String id = inp.inputString("Melyik felhasnzálót szeretnéd elfogadni?\n");
                    System.out.println("");
                    System.out.println("Elfogadod a jelentkezését?");
                    users.specialisRegisztraciokBiralasa(id, inp.inputString("Y/N\n"));
                    break;
                default:
                    System.out.println("Rossz számot adtál meg");
            }
        }
        else{
            user = null;
        }
    }
    void logOut(){                            
        user = null;                    
        System.out.println("Kijelentkeztél");
    }

}
