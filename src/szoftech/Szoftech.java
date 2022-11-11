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
                System.out.println("Bejelentkeztél");
            }
            
        }
    }

    public void loginMenu() {
        System.out.println("");
        System.out.println("Menü:");
        System.out.println("1 - Belépés");
        System.out.println("2 - Regisztráció");
        System.out.println("0 - Kilépés");
        menuEvent();
    }

    public void menuEvent() {
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
                break;
            case 4:
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

}
