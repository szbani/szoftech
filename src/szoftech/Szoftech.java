package szoftech;

import java.io.*;
import java.util.*;

public class Szoftech {
    public inputOutput inp = new inputOutput();
    public Boolean exit = false;
    public user user = null;
    public static void main(String[] args) {
        Szoftech sz = new Szoftech();
        user us = new user();
        us.getId();
        
        while (!sz.exit) {
            if(sz.user == null){
            sz.loginMenu();
            String asd = sz.inp.inputFile("user");
            }
        }
//        Vector asd = new Vector<user>();
    }

    public void loginMenu() {
        System.out.println("");
        System.out.println("menü:");
        System.out.println("0 - Kilépés");
        System.out.println("1 - Belépés");
        System.out.println("2 - Regisztráció");
        System.out.println("3 - asd");
        System.out.println("4 - asd");
        menuEvent();
    }

    public void menuEvent() {
        switch (inp.inputSzam("Add meg a Parancs számát: ")) {
            case 0:
                exit = true;
                break;
            //regisztráció
            case 1:
                break;
            //
            case 2:
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
