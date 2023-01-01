/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package méga.démineur_berger_bonnefous_;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author berge
 */
public class CaseGraphique extends JButton {

    Case caseAssociee;
    ImageIcon img_cache = new javax.swing.ImageIcon(getClass().getResource("/images/cache.png"));
    ImageIcon img_boum = new javax.swing.ImageIcon(getClass().getResource("/images/boum.png"));
    ImageIcon img_bombe = new javax.swing.ImageIcon(getClass().getResource("/images/bombe.png"));
    ImageIcon img_bomberate = new javax.swing.ImageIcon(getClass().getResource("/images/bomberate.png"));
    ImageIcon img_drapeau = new javax.swing.ImageIcon(getClass().getResource("/images/drapeau.png"));
    ImageIcon img_vide = new javax.swing.ImageIcon(getClass().getResource("/images/caseVide.png")); //Aussi égale à une case à 0 bombes autour
    ImageIcon img_case1 = new javax.swing.ImageIcon(getClass().getResource("/images/case1.png"));
    ImageIcon img_case2 = new javax.swing.ImageIcon(getClass().getResource("/images/case2.png"));
    ImageIcon img_case3 = new javax.swing.ImageIcon(getClass().getResource("/images/case3.png"));
    ImageIcon img_case4 = new javax.swing.ImageIcon(getClass().getResource("/images/case4.png"));
    ImageIcon img_case5 = new javax.swing.ImageIcon(getClass().getResource("/images/case5.png"));
    ImageIcon img_case6 = new javax.swing.ImageIcon(getClass().getResource("/images/case6.png"));
    ImageIcon img_case7 = new javax.swing.ImageIcon(getClass().getResource("/images/case7.png"));
    ImageIcon img_case8 = new javax.swing.ImageIcon(getClass().getResource("/images/case8.png"));

    public CaseGraphique(Case uneCase) {
        caseAssociee = uneCase;
    }

    @Override
    public void paintComponent(Graphics G) {
        super.paintComponent(G);
        if (caseAssociee.isDrapeauVisible()) {
            setIcon(img_drapeau);
        }else if (caseAssociee.isCache()) {
            setIcon(img_cache);
        }else if (caseAssociee.isBoum()){
                setIcon(img_boum);
        }else if (caseAssociee.caseBombe() && !caseAssociee.isCache()){
            setIcon(img_bombe);
        } else {
            int nbrB = caseAssociee.getNbrBombesAutour();
            switch (nbrB) {
                case 0:
                    setIcon(img_vide);
                    break;
                case 1:
                    setIcon(img_case1);
                    break;
                case 2:
                    setIcon(img_case2);
                    break;
                case 3:
                    setIcon(img_case3);
                    break;
                case 4:
                    setIcon(img_case4);
                    break;
                case 5:
                    setIcon(img_case5);
                    break;
                case 6:
                    setIcon(img_case6);
                    break;
                case 7:
                    setIcon(img_case7);
                    break;
                case 8:
                    setIcon(img_case8);
                    break;
            }
        }
    }
}
