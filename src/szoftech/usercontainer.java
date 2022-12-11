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
                usLst.add(new user(arr[0],arr[1],arr[2],arr[3],Integer.parseInt(arr[4]),Boolean.parseBoolean(arr[5])));
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            
        }
    }
    public void addSpecialuser(user e,int rang){
        e.specReg(rang);
        if (userExists(e)) {
            usLst.add(e);
        }
        else{
                System.out.println("A felhasználónév foglalt");
                }
    }
    public void addUser(user us){
        if (this.userExists(us)) {
            usLst.add(us);    
        }
        
    }
    public void felhasznalokTorlese(String username){
        int i = 0;
        for (user us : usLst) {
            if(us.getUser().equals(username)){
                usLst.remove(i);
                mentes();
                System.out.println("Sikeres törlés");
                break;
            }
            i++;
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
    public user getUser(int index){
        return usLst.get(index);
    }
    public void felhasznalokKilistazasa(){
        int i = 0;
        for (user us : usLst) {
            us.kiir(i);
            i++;
        }
    }

    public void specialisRegisztraciokBiralasa(String username,String yesOrNO){
        int i=0;
        for (user object : usLst) {
            if (object.getUser().equals(username)) {
                if (yesOrNO.toLowerCase().equals("y")) {
                    usLst.elementAt(i).elfogad();
                    System.out.println("Jelentkezés elfogadva!");
                }
                else if (yesOrNO.toLowerCase().equals("n")) {
                    usLst.remove(object);
                    System.out.println("Jelentkezés elutasitva!");
                }
            }
            i++;
        }    }
    public user loginUser(String usrn,String pw){
        for (user us : usLst) {
            if (us.getUser().equalsIgnoreCase(usrn)&&us.getPw().equals(pw)&&us.isJelentkezett()) {
                System.out.println("Bejelentkeztél");
                return us;
            }
        }
        System.out.println("Sikertelen bejelentkezés, rossz felhasználónév/jelszó!");
        return null;
    }
    
    
    private boolean userExists(user usr){
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
    
    
}
