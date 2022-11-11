
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

    public List getFile(String file) {
        List list = new ArrayList<String>();
        try {
            Scanner sc = new Scanner(new File(file));
            while (sc.hasNextLine()) {
                list.add(sc.nextLine());
            }
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
        return list;
    }
    public void writeFile(Vector vec,String file){
        try {
            PrintWriter pw = new PrintWriter(new File(file));
            for (Object obj : vec) {
                pw.println(obj.toString());
            }
            pw.close();
        } catch (Exception e) {
        }
    }
}
