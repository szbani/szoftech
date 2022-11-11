package szoftech;
import java.util.*;

public class usercontainer {
    private Vector<user> usLst=new Vector<user>();

    public usercontainer() {
        inputOutput be = new inputOutput();
        List<String> list = be.getFile("users.txt");
        for (String us : list) {
            String[] arr = us.split(" ");
            try {
                usLst.add(new user(arr[0],arr[1],arr[2],arr[3],Integer.parseInt(arr[4])));
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            
        }
    }
    public void addUser(user us){
        if (!this.checkCredentials(us)) {
            usLst.add(us);    
        }
        
    }
    public user getUser(String usrn){
        for (user us : usLst) {
            if (us.getUser().equalsIgnoreCase(usrn)) {
                return us;
            }
        }
        return null;
    }
    
    
    public boolean checkCredentials(user usr){
        for (user us : usLst) {            
            if (us.getUser().equalsIgnoreCase(usr.getUser())) {
                return true;
            }
            
        }
        System.out.println("A felhasznalonev foglalt");
        return false;
    }
    public void mentes(){
        inputOutput ki = new inputOutput();
        ki.writeFile(usLst, "users.txt");
    }
    public int getSize(){
        return usLst.size();
    }
    
    
    
}
