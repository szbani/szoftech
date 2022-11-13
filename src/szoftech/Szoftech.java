package szoftech;

import java.io.*;
import java.util.*;

public class Szoftech {

    inputOutput inp = new inputOutput();
    Boolean exit = false;
    user user = null;
    public usercontainer users = new usercontainer();
    public teremcontainer termek = new teremcontainer();

    public static void main(String[] args) {
        Szoftech sz = new Szoftech();

        while (!sz.exit) {
            if (sz.user == null) {
                sz.loginMenu();
            } else {
//                terem t = new terem("terem", 20, "anyád");
//                esemeny es = new esemeny("esemeny1","leiras1",
//                        2022,10,21,10,11);
//                es.addUser("hallo");
//                t.addEsemeny(es);
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
        user us = new user(inp.inputString("Felhasználónév: "), inp.inputString("Jelszó: "),
                inp.inputString("Vezetéknév: "), inp.inputString("Keresztnév:"));
        users.addUser(us);
        users.mentes();
    }

    public void mainMenu() {
        System.out.println("");
        System.out.println("Fiók: " + user.getNev() + " - " + user.getRangString());
        if(user.getRang() == 0){
        System.out.println("1 - Események Megtekintése");
        System.out.println("2 - Értékelés írása");
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
                    user = null;
                    break;
                case 1:
                    //események megtekintése
                    termek.listAllEsemeny();
                    System.out.println("Szeretnél eseményre jelentkezni?");
                    System.out.println("Y/N");
                    if(inp.inputString("Y/N\n").equalsIgnoreCase("y")){
                        termek.teremEsemenyereJelentkezes(inp.inputString("Terem neve: "), inp.inputSzam("Esemény száma: "), user);
                    }
                    break;
                case 2:
                    //Értékelés irása
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
                    user = null;
                    break;
                case 1:
                    //Terem foglalás
                    termek.listAllEsemeny();
                    termek.addEsemeny(inp.inputString("Terem neve: "),
                            new esemeny(inp.inputString("Esemény neve: "),inp.inputString("Leírás: "), 
                                     inp.inputSzam("Nap: (1 - hérfő, 2  - kedd, 3 - szerda, 4 - csütörtök, 5 - péntek)\n"),inp.inputSzam("Kezdés(óra): "),
                                    inp.inputSzam("Vége(óra): ")),user);
                    break;
                case 2:
                    //terem foglalás törlése
                    termek.torlesTeremEsemenye(inp.inputString("Terem neve: "), inp.inputSzam("Esemény száma: "));
                    break;
                case 3:
                    //Saját foglalások megtekintése
                    termek.listAllSajatEsemeny(user.getNev());
                    break;
                case 4:
                    //értékelések megtekintése
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
                    user = null;
                    break;
                case 1:
                    //Terem létrehozása
                    termek.addTerem(new terem(inp.inputString("Neve: "),inp.inputSzam("Férőhely: ")));
                    break;
                case 2:
                    //felheasznalok kilistázása
                    users.kiirUsers();
                    break;
                case 3:
                    //felhasználó törlése
                    users.deleteUser(inp.inputString("Felhasználónév: "));
                    break;
                case 4:
                    //Speciális regisztráció elfogadása
                    break;
                default:
                    System.out.println("Rossz számot adtál meg");
            }
        }
        else{
            user = null;
        }
    }

}
