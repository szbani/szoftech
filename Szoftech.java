package szoftech;

import java.io.IOException;
import java.util.Scanner;

public class Szoftech {

    public Boolean exit = false; 
    public static void main(String[] args) {
        Szoftech sz = new Szoftech();
        sz.menu();
        while(!sz.exit){
        
        }
        
    }
    
    public void menu(){
        System.out.println("");
        System.out.println("menü:");
        System.out.println("1 - asd");
        System.out.println("1 - asd");
        System.out.println("1 - asd");
        System.out.println("1 - asd");
        inputSzam();
    }
    
    public String inputString(){
        try {
            Scanner sc = new Scanner(System.in);
            String i = sc.nextLine();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
    
    public int inputSzam(){
        try {
            Scanner sc = new Scanner(System.in);
            int i = sc.nextInt();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public String inputFile(String file){
        try {
            Scanner sc = new Scanner(new File(file));
            String i = sc.nextLine();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
     
}
