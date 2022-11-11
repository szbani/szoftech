package szoftech;
import java.util.*;

public class usercontainer {
    private Vector<user> usLst=new Vector<user>();

    public usercontainer() {
        
    }
    public void addUser(user us){
        if (!this.checkCredentials(us)) {
            usLst.add(us);    
        }
        
    }
    public user getUser(int indx){
        return usLst.elementAt(indx);
    }
    
    
    public boolean checkCredentials(user usr){
        for (user us : usLst) {
            if (us.getPw().equals(usr.getPw())){
                if (us.getUser().equalsIgnoreCase(usr.getUser())) {
                    return true;
                }
            }
        }
        return false;
    }
    public void mentes(){
        inputOutput ki = new inputOutput();
        // még kell
    }
    public int getSize(){
        return usLst.size();
    }
    
    
    
}
