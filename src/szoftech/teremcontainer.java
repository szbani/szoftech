package szoftech;

import java.util.List;
import java.util.Vector;

public class teremcontainer {
        Vector<terem> trmList=new Vector<terem>();

    public teremcontainer() {
        inputOutput be = new inputOutput();
        List<String> list = be.getFile("termek.txt");
        for (String us : list) {
            String[] arr = us.split(" ");
            try {
                //trmList.add(new terem(, , ));
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            
        }
        
    }
    public boolean checkCredentials(terem t){
        for (terem us : trmList) {            
            if (us.getNev().equals(t.getNev())) {
                System.out.println("A Terem m�r l�tezik");
                return false;
            }
            
        }
        return true;
    }
    public void mentes(){
        inputOutput ki = new inputOutput();
        ki.writeFile(trmList, "termek.txt");
    }
        
}
