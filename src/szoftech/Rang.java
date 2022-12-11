/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package szoftech;

/**
 *
 * @author Admin
 */
public class Rang {
    int rang;

    public Rang(int rang) {
        this.rang = rang;
    }
    public String getRangString(){
        switch (this.rang) {
            case 0:
                return "Felasználó";
            case 1:
                return "Foglaló";
            case 2:
                return "Operátor";
            default:
                throw new AssertionError();
        }
    }

    public int getRang() {
        return rang;
    }

    public void setRang(int rang) {
        this.rang = rang;
    }
    
    
}
