package szoftech;
import java.util.*;

public class usercontainer {
    private Vector<user> usLst=new Vector<user>();

    public usercontainer() {
        
    }
    public void addUser(user us){
        usLst.add(us);
    }
    
    public boolean checkCredentials(user usr){
        return usLst.contains(usr);
    }
    
    
    
    
}
