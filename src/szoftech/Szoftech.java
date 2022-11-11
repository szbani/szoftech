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
        user us = new user();
        
        while (!sz.exit) {
            if(sz.user == null){
            sz.loginMenu();
//            List asd = sz.inp.getFile("user");
            }
        }
//        Vector asd = new Vector<user>();
    }

    public void loginMenu() {
        System.out.println("");
        System.out.println("menü:");
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
                login();
                break;
            case 2:
                //regisztráció
                register();
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
    
    public void login(){
        
    }
    
    public void register(){
        
    }

}
