/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package méga.démineur_berger_bonnefous_;

/**
 *
 * @author berge
 */
public class Case {
    private int nbrBombesAutour = 0;
    private boolean estBombe = false;
    private boolean cache = true;
    private boolean drapeauVisible = false;
    private boolean boum = false;

    public Case() {
    }

    public boolean caseBombe() {
        return estBombe;
    }
    
    public void devenirBombe(){
        this.estBombe = true;
    }    

    public void setNbrBombesAutour(int nbrBombesAutour) {
        this.nbrBombesAutour = nbrBombesAutour;
    }

    public int getNbrBombesAutour() {
        return nbrBombesAutour;
    }

    public boolean isCache() {
        return cache;
    }

    public void setCache(boolean cache) {
        this.cache = cache;
    }

    public boolean isDrapeauVisible() {
        return drapeauVisible;
    }

    public void setDrapeauVisible(boolean drapeauVisible) {
        this.drapeauVisible = drapeauVisible;
    }
    
    public boolean caseVide(){
        return (nbrBombesAutour == 0 );
    }

    public boolean isBoum() {
        return boum;
    }

    public void setBoum(boolean boum) {
        this.boum = boum;
    }
    
}
