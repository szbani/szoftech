package szoftech;

import java.io.*;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Szoftech {

    public Boolean exit = false; 
    public static void main(String[] args) {
        Szoftech sz = new Szoftech();
        while(!sz.exit){
            sz.menu();
        }
        Vector asd = new Vector<user>();
    }
    
    public void menu(){
        System.out.println("");
        System.out.println("menü:");
        System.out.println("1 - asd");
        System.out.println("1 - asd");
        System.out.println("1 - asd");
        System.out.println("1 - asd");
        
        inputFile("asd.txt");
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
            String i = "";
            while(sc.hasNextLine()){
                 i = sc.nextLine();
            }
            return i;
        }
        catch(FileNotFoundException e){
            try {
                PrintWriter pw = new PrintWriter(file);
                pw.close();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
     
}
