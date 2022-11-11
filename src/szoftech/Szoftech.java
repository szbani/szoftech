package szoftech;

import java.io.*;
import java.util.*;

public class Szoftech {

    public Boolean exit = false;
    inputOutput input = new inputOutput();
    String asd = input.inputString();
    public static void main(String[] args) {
        Szoftech sz = new Szoftech();
        user us = new user();
        us.getId();
        while (!sz.exit) {
            sz.menu();
        }
//        Vector asd = new Vector<user>();
    }

    public void menu() {
        System.out.println("");
        System.out.println("menü:");
        System.out.println("1 - asd");
        System.out.println("1 - asd");
        System.out.println("1 - asd");
        System.out.println("1 - asd");
        menuEvent();

    }

    public void menuEvent() {
        switch (1) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
        }
    }

    

}
