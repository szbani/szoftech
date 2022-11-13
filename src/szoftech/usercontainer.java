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
        if (this.checkCredentials(us)) {
            usLst.add(us);    
        }
        
    }
    public void deleteUser(){
        
    }
    public user getUser(String usrn){
        for (user us : usLst) {
            if (us.getUser().equalsIgnoreCase(usrn)) {
                return us;
            }
        }
        return null;
    }
    public user getUser(int index){
        return usLst.get(index);
    }
    public void kiirUsers(){
        int i = 0;
        for (user us : usLst) {
            us.kiir(i);
            i++;
        }
    }public void kiirUsers(int rang){
        int i = 0;
        for (user us : usLst) {
            if(us.getRang() == rang)us.kiir(i);
            i++;
        }
    }
    public void jogElfogad(int index){
        getUser(index).elfogad();
    }
    public void jogElutasit(int index){
        usLst.remove(index);
    }
    public user loginUser(String usrn,String pw){
        for (user us : usLst) {
            if (us.getUser().equalsIgnoreCase(usrn)&&us.getPw().equals(pw)) {
                System.out.println("Bejelentkeztél");
                return us;
            }
        }
        System.out.println("Sikertelen bejelentkezés, rossz felhasználónév/jelszó!");
        return null;
    }
    
    
    public boolean checkCredentials(user usr){
        for (user us : usLst) {            
            if (us.getUser().equalsIgnoreCase(usr.getUser())) {
                System.out.println("A felhasználónév foglalt");
                return false;
            }
            
        }
        
        return true ;
    }
    public void mentes(){
        inputOutput ki = new inputOutput();
        ki.writeFile(usLst, "users.txt");
    }
    public int getSize(){
        return usLst.size();
    }
    
    
    
}
