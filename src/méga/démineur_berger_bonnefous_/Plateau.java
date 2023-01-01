/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package méga.démineur_berger_bonnefous_;

import java.util.Random;

/**
 *
 * @author berge
 */
public class Plateau {

    private int ligne;
    private int colonne;
    Case[][] grille;

    public Plateau(int l, int c) {
        ligne = l;
        colonne = c;
        grille = new Case[ligne][colonne];

        //On crée des cases pour la grille
        for (int i = 0; i < ligne; i++) {
            for (int j = 0; j < colonne; j++) {
                grille[i][j] = new Case();
            }
        }
    }

    public void AjoutBombes() {
        //On rajoute les bombes aléatoirement
        int cmtB = 0;
        int lgn;
        int col;
        Random rand = new Random();

        while (cmtB < 15) {
            lgn = rand.nextInt(ligne - 1);
            col = rand.nextInt(colonne - 1);
            if (!grille[lgn][col].caseBombe()) {
                grille[lgn][col].devenirBombe();
                cmtB++;
            }
        }
    }

    public void afficherGrilleSurConsole() {
        for (int i = ligne - 1; i > -1; i--) {
            for (int j = 0; j < colonne; j++) {

                if (grille[i][j].caseBombe()) {
                    System.out.print("[b]");
                } else if (!grille[i][j].caseBombe()) {
                    System.out.print("[" + grille[i][j].getNbrBombesAutour() + "]");
                } else {
                    System.out.print("[" + null + "]");
                }

                if (j == colonne - 1) {
                    System.out.print("\n");
                }
            }
        }
    }

    public void compteBombe() {
        for (int i = 0; i < ligne; i++) {
            for (int j = 0; j < colonne; j++) {
                int cmtB = 0;
                if (!grille[i][j].caseBombe()) {
                    if (i == 0) { //Cas de la ligne bas

                        if (j == 0) { //Cas du coin bas gauche
                            if (grille[i + 1][j].caseBombe()) {
                                cmtB++;
                            }
                            if (grille[i + 1][j + 1].caseBombe()) {
                                cmtB++;
                            }
                            if (grille[i][j + 1].caseBombe()) {
                                cmtB++;
                            }

                        } else if (j + 1 == colonne) { //Cas du coin bas droit
                            if (grille[i][j - 1].caseBombe()) {
                                cmtB++;
                            }
                            if (grille[i + 1][j - 1].caseBombe()) {
                                cmtB++;
                            }
                            if (grille[i + 1][j].caseBombe()) {
                                cmtB++;
                            }

                        } else {
                            if (grille[i + 1][j - 1].caseBombe()) {
                                cmtB++;
                            }
                            if (grille[i + 1][j].caseBombe()) {
                                cmtB++;
                            }
                            if (grille[i + 1][j + 1].caseBombe()) {
                                cmtB++;
                            }
                            if (grille[i][j - 1].caseBombe()) {
                                cmtB++;
                            }
                            if (grille[i][j + 1].caseBombe()) {
                                cmtB++;
                            }
                        }

                    } else if (i + 1 == ligne) { //cas de la ligne haut

                        if (j == 0) { //Cas du coin haut gauche
                            if (grille[i - 1][j].caseBombe()) {
                                cmtB++;
                            }
                            if (grille[i - 1][j + 1].caseBombe()) {
                                cmtB++;
                            }
                            if (grille[i][j + 1].caseBombe()) {
                                cmtB++;
                            }

                        } else if (j + 1 == colonne) { //Cas du coin haut droit 
                            if (grille[i - 1][j].caseBombe()) {
                                cmtB++;
                            }
                            if (grille[i - 1][j - 1].caseBombe()) {
                                cmtB++;
                            }
                            if (grille[i][j - 1].caseBombe()) {
                                cmtB++;
                            }

                        } else {
                            if (grille[i - 1][j - 1].caseBombe()) {
                                cmtB++;
                            }
                            if (grille[i - 1][j].caseBombe()) {
                                cmtB++;
                            }
                            if (grille[i - 1][j + 1].caseBombe()) {
                                cmtB++;
                            }
                            if (grille[i][j - 1].caseBombe()) {
                                cmtB++;
                            }
                            if (grille[i][j + 1].caseBombe()) {
                                cmtB++;
                            }
                        }

                    } else if (j == 0) { //Cas de la ligne gauche

                        if (grille[i - 1][j].caseBombe()) {
                            cmtB++;
                        }
                        if (grille[i + 1][j].caseBombe()) {
                            cmtB++;
                        }
                        if (grille[i - 1][j + 1].caseBombe()) {
                            cmtB++;
                        }
                        if (grille[i][j + 1].caseBombe()) {
                            cmtB++;
                        }
                        if (grille[i + 1][j + 1].caseBombe()) {
                            cmtB++;
                        }

                    } else if (j + 1 == colonne) { //Cas de la ligne droite

                        if (grille[i - 1][j].caseBombe()) {
                            cmtB++;
                        }
                        if (grille[i + 1][j].caseBombe()) {
                            cmtB++;
                        }
                        if (grille[i - 1][j - 1].caseBombe()) {
                            cmtB++;
                        }
                        if (grille[i][j - 1].caseBombe()) {
                            cmtB++;
                        }
                        if (grille[i + 1][j - 1].caseBombe()) {
                            cmtB++;
                        }

                    } else { //Tout les autres cas / Intérieur de la grille
                        if (grille[i - 1][j - 1].caseBombe()) {
                            cmtB++;
                        }
                        if (grille[i - 1][j].caseBombe()) {
                            cmtB++;
                        }
                        if (grille[i - 1][j + 1].caseBombe()) {
                            cmtB++;
                        }
                        if (grille[i][j - 1].caseBombe()) {
                            cmtB++;
                        }
                        if (grille[i][j + 1].caseBombe()) {
                            cmtB++;
                        }
                        if (grille[i + 1][j - 1].caseBombe()) {
                            cmtB++;
                        }
                        if (grille[i + 1][j].caseBombe()) {
                            cmtB++;
                        }
                        if (grille[i + 1][j + 1].caseBombe()) {
                            cmtB++;
                        }
                    }
                }
                grille[i][j].setNbrBombesAutour(cmtB); //On attribut à la case étudié le nombre de bombes autour d'elle 
            }
        }
    }

    public void decouvrirVide(int l, int c) {
        int[] tab = new int[8];
        int cmt = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (i == 0 && j == 0) {
                    //Rien
                }else if (l + i < 0 || l + i == ligne || c + j < 0 || c + j == colonne){
                    tab[cmt] = -1;
                    cmt++;
                }else if (!grille[l + i][c + j].isCache()){
                    tab[cmt] = -1;
                    cmt++;
                }else if (grille[l + i][c + j].caseBombe()){
                    tab[cmt] = -1;
                    cmt++;
                } else {
                    int nbrB = grille[l + i][c + j].getNbrBombesAutour();
                    tab[cmt] = nbrB;
                    cmt++;
                }
            }
        }
        System.out.println(tab[0]);
        System.out.println(tab[1]);
        System.out.println(tab[2]);
        System.out.println(tab[3]);
        System.out.println(tab[4]);
        System.out.println(tab[5]);
        System.out.println(tab[6]);
        System.out.println(tab[7]);
        cmt = 0;
        for (int m = -1; m < 2; m++) {
            for (int n = -1; n < 2; n++) {
                int nvL = l + m;
                int nvC = c + n;
                System.out.println("ligne " +nvL);
                System.out.println("colonne "+nvC);
                if (m == 0 && n == 0){
                    if (grille[nvL][nvC].isCache()){
                        grille[nvL][nvC].setCache(false);
                        System.out.println(grille[nvL][nvC].isCache());
                }}else if (tab[cmt] == -1){
                    cmt++;
                }else if (nvL < 0 || nvL >= ligne || nvC < 0 || nvC >= colonne){
                    cmt++;
                }else{
                    if (grille[nvL][nvC].isCache()){
                        grille[nvL][nvC].setCache(false);
                    }
                    cmt++;
                    System.out.println(grille[nvL][nvC].isCache());
                }
            }
        }
  
        cmt = 0;
        for (int m = -1; m < 2; m++) {
            for (int n = -1; n < 2; n++) {
                if (m == 0 && n == 0){
                    //rien
                }else if (tab[cmt] == -1){
                    cmt++;
                }else if (tab[cmt] == 0){
                    decouvrirVide(l+m,c+n);
                    cmt++;
                }else{
                    cmt++;
                }
            }
        }
    }

    /*public boolean isVictoire() {
        return victoire;
    }

    public void setVictoire(boolean victoire) {
        this.victoire = victoire;
    }
    */
}
