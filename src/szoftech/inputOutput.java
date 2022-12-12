
package szoftech;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class inputOutput {
    
    public String inputString(String kiiras) {
        try {
            System.out.print(kiiras);
            Scanner sc = new Scanner(System.in,"utf-8");
            String i = sc.nextLine();
            i=i.replace(",", " ");
            i=i.replace("#", " ");
            return i;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public int inputSzam(String kiiras) {
        try {
            System.out.print(kiiras);
            Scanner sc = new Scanner(System.in,"utf-8");
            int i = sc.nextInt();
            return i;
        }catch(InputMismatchException ex){
            System.out.println("Nem számot adtál meg");
            return inputSzam(kiiras);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List getFile(String file) {
        List list = new ArrayList<String>();
        try {
          Scanner sc = new Scanner(new File(file),("utf-8"));
            
            
            
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
            
            BufferedWriter writer= new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),StandardCharsets.UTF_8));
            PrintWriter pw=new PrintWriter(writer);
            for (Object obj : vec) {
                pw.println(obj.toString());
            }
            pw.close();
        } catch (Exception e) {
             e.printStackTrace();
        }
    }
}
