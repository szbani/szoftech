package szoftech;

import java.io.*;
import java.util.*;

public class Szoftech {
    public inputOutput inp = new inputOutput();
    public Boolean exit = false;
    public user user = null;
    public usercontainer users = new usercontainer();
    
    
    
    public static void main(String[] args) {
        Szoftech sz = new Szoftech();
        
        while (!sz.exit) {
            if(sz.user == null){
            sz.loginMenu();
            }else{
//                terem t = new terem("terem", 20, "anyád");
//                esemeny es = new esemeny("esemeny1","leiras1",
//                        2022,10,21,10,11);
//                es.addUser("hallo");
//                t.addEsemeny(es);
                System.out.println("Bejelentkeztél");
                sz.mainMenu();
                sz.exit = true;
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
    
    public void loginUser(){
        System.out.println("");
        System.out.println("Bejelentkezés");
        
        user = users.getUser(inp.inputString("Felhasználónév: "),inp.inputString("Jelszó: "));
        
        
    }
    
    public void registerUser(){
        System.out.println("");
        System.out.println("Regisztráció");
        user us = new user(inp.inputString("Felhasználónév: "), inp.inputString("Jelszó: "),
                inp.inputString("Vezetéknév: "), inp.inputString("Keresztnév:"));
        users.addUser(us);
        users.mentes();
    }

    public void mainMenu(){
        System.out.println("Fiók: " + user.getNev() + " " + user.getRangString());
        System.out.println("1 - Események kilistázása");
        System.out.println("2 - Eseményre jelentkezés");
        if (user.getRang() == 0) {
                    System.out.println("3 - Foglalónak jelentkezés");
        }
        if (user.getRang() > 0) {
            System.out.println("3 - Terem foglalás");
            System.out.println("4 - Saját foglalások megtekintése");
            System.out.println("5 - Foglalás törlése");
        }
        if(user.getRang() > 1){
            System.out.println(" - Termek kezelése");
            System.out.println(" - felhasználók kezelése");
            System.out.println("jogosultság kérők kezelése");
        }
        System.out.println("0 - Kijelentkezés");
        mainMenuEvents();
    }
    
    public void mainMenuEvents(){
        
    }
    
}
