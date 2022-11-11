package szoftech;
import java.util.*;

public class usercontainer {
    private Vector<user> usLst=new Vector<user>();

    public usercontainer() {
        inputOutput be = new inputOutput();
        List<String> list = be.getFile("users.txt");
        for (String us : list) {
            int elsoindex, masoidkindex,harmadikindex,negyedikindx;
            elsoindex=us.indexOf(" ", 0);
            masoidkindex=us.indexOf(" ",elsoindex);
            harmadikindex=us.indexOf(" ",masoidkindex);
            negyedikindx=us.indexOf(" ",harmadikindex);
            usLst.add(new user(us.substring(0,elsoindex),
                    us.substring(elsoindex,masoidkindex),
                    us.substring(masoidkindex, harmadikindex),
                    us.substring(harmadikindex,negyedikindx),
                            Integer.parseInt(us.substring(negyedikindx,us.length()))));
            
        }
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
        ki.writeFile(usLst, "users.txt");
    }
    public int getSize(){
        return usLst.size();
    }
    
    
    
}
