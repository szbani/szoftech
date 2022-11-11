
package szoftech;

import java.io.*;
import java.util.*;

public class inputOutput {
    
    public String inputString() {
        try {
            Scanner sc = new Scanner(System.in);
            String i = sc.nextLine();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public int inputSzam(String kiiras) {
        try {
            System.out.println(kiiras);
            Scanner sc = new Scanner(System.in);
            int i = sc.nextInt();
            return i;
        }catch(InputMismatchException ex){
            System.out.println("Nem számot adtál meg");
            return -1;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public String inputFile(String file) {
        try {
            Scanner sc = new Scanner(new File(file));
            String i = "";
            while (sc.hasNextLine()) {
                i = sc.nextLine();
            }
            return i;
        } catch (FileNotFoundException e) {
            try {

                PrintWriter pw = new PrintWriter(file);
                pw.close();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
