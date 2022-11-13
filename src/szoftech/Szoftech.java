package szoftech;

import java.io.*;
import java.util.*;

public class Szoftech {

    inputOutput inp = new inputOutput();
    Boolean exit = false;
    user user = null;
    Boolean vissza = false;
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
        System.out.println("1 - Események kilistázása");
        System.out.println("2 - Eseményre jelentkezés");
        if (user.getRang() == 0) {
            System.out.println("3 - Foglalónak jelentkezés");
        }
        if (user.getRang() > 0) {
            System.out.println("3 - Saját foglalások megtekintése");
            System.out.println("4 - Terem foglalás");
            System.out.println("5 - Foglalás törlése");
        }
        if (user.getRang() > 1) {
            System.out.println("6 - Termek kezelése");
            System.out.println("7 - felhasználók kezelése");
            System.out.println("8 - jogosultság kérők kezelése");
        }
        System.out.println("0 - Kijelentkezés");
        mainMenuEvents();
    }

    public void mainMenuEvents() {
        int parancs = inp.inputSzam("Add meg a Parancs számát: ");
        vissza = false;
        switch (parancs) {
            case 0:
                //kijelentkezes
                user = null;
                break;
            case 1:
                //esemeny kilistazas
                
                break;
            case 2:
                //esemenyre jelentkezes
//                termek.teremEsemenyereJelentkezes(teremnev, parancs, user);
                    
                break;
        }
        if (user == null) {
            return;
        }
        if (user.getRang() > 0) {
            switch (parancs) {
                case 3:
                    //sajat foglalasok kilistazasa
                    termek.listAllSajatEsemeny(user.getNev());
                    break;
                case 4:
                    //terem foglalasa
                    termek.listAllTeremEsemennyel();
                    termek.addEsemeny(inp.inputString("Terem neve: "),
                            new esemeny(inp.inputString("Esemény neve: "),inp.inputString("Leírás: "), inp.inputSzam("Év: "),
                                    inp.inputSzam("Hónap: "), inp.inputSzam("Nap: "),
                                   inp.inputSzam("Kezdés(óra): "), inp.inputSzam("Vége(óra): ")),user);
                    break;
                case 5:
                    //terem foglalas torlese
                    termek.listAllSajatEsemeny(user.getNev());
                    termek.torlesTeremEsemenye(inp.inputString("Terem neve: "), inp.inputSzam("Esemény száma: "));
                    break;
            }
        }
        if (user.getRang() > 1) {
            switch (parancs) { 
                case 6:
                    //termek kezelese
                    while (!vissza) {
                        termekMenu();
                        termekMenuEvents();
                    }
                    break;
                case 7:
                    //felheasznalok kezelese
                    while (!vissza) {
                        felMenu();
                        felMenuEvents();
                    }
                    break;
                case 8:
                    //foglaloi jelentkezesek kezelese
                    break;
            }
        }
        if(user.getRang() == 0 && (parancs < 0 || parancs > 2)){
            System.out.println("Rossz számot adtál meg");
        }
        if(user.getRang() == 1 && (parancs < 0 || parancs > 5)){
            System.out.println("Rossz számot adtál meg");
        }
        if(user.getRang() == 2 && (parancs < 0 || parancs > 8)){
            System.out.println("Rossz számot adtál meg");
        }
    }

    public void termekMenu() {
        System.out.println("");
        System.out.println("Termek kezelése");
        System.out.println("1 - Termek kilistázása");
        System.out.println("2 - Terem hozzáadása");
        System.out.println("3 - Terem törlése");
        System.out.println("4 - Terem módosítása");
        System.out.println("0 - Vissza");

    }

    public void termekMenuEvents() {
        switch (inp.inputSzam("Add meg a Parancs számát: ")) {
            case 0:
                vissza = true;
                break;
            case 1:
                termek.listAllTeremSima();
                break;
            case 2:
                termek.addTerem(new terem(inp.inputString("Terem neve: "),
                        inp.inputSzam("Férőhely: "),
                        inp.inputString("Leírás: ")));
                break;
            case 3:
                termek.listAllTeremSima();
                termek.torlesTerem(inp.inputString("Terem neve:"));
                break;
            case 4:
                System.out.println("1 - Leírás módosítása");
                System.out.println("2 - Férőhely módosítása");
                switch (inp.inputSzam("Add meg a Parancs számát:")) {
                    case 1:
                        termek.listAllTeremSima();
                        termek.modositLeiras(inp.inputString("Terem neve: "),inp.inputString("Terem új leírása: "));
                        break;
                    case 2:
                        termek.listAllTeremSima();
                        termek.modositFerohely(inp.inputString("Terem neve: "), inp.inputSzam("Add meg az új férőhelyt: "));
                        break;
                    default:
                        System.out.println("Rossz számot adtál meg");
                        break;
                }
                break;
            default:
                System.out.println("Rossz számot adtál meg");
        }
    }

    public void felMenu() {
        System.out.println("");
        System.out.println("Felhasználók kezelése");
        System.out.println("1 - Felhasználók kilistázása");
        System.out.println("2 - Felhasználó törlése");
        System.out.println("3 - Foglalói jogosultság törlése");
        System.out.println("0 - Vissza");
    }

    public void felMenuEvents() {
        switch (inp.inputSzam("Add meg a Parancs számát: ")) {
            case 0:
                vissza = true;
                break;
            default:
                System.out.println("Rossz számot adtál meg");
        }
    }

    public void jogMenu() {

    }

    public void jogMenuEvents() {
        switch (inp.inputSzam("Add meg a Parancs számát: ")) {
            case 0:
                vissza = true;
                break;
            default:
                System.out.println("Rossz számot adtál meg");
        }
    }

}
