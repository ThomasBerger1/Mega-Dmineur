/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package méga.démineur_berger_bonnefous_;

import java.util.ArrayList;

/**
 *
 * @author berge
 */
public class fenetreJeu extends javax.swing.JFrame {

    private int ligne = 10;
    private int colonne = 11;
    private Plateau PdJ = new Plateau(ligne, colonne);
    private ArrayList<CaseGraphique> listeCaseGraph = new ArrayList<>();
    private int Victoire = 0; //Si victoire = -1 -> Défaite / Si victoire = 0 -> non défini / Si victoire = 1 -> Victoire

    /**
     * Creates new form fenetreJeu
     */
    public fenetreJeu() {
        initComponents();
        grilleJeu.setVisible(false);

        for (int i = ligne - 1; i >= 0; i--) {
            for (int j = 0; j < colonne; j++) {
                CaseGraphique caseGraph = new CaseGraphique(PdJ.grille[i][j]);
                int lig = i;
                int col = j;
                listeCaseGraph.add(caseGraph);
                grilleJeu.add(caseGraph);

                caseGraph.addActionListener((java.awt.event.ActionEvent evt) -> {
                    Case c = caseGraph.caseAssociee;

                    if (!c.caseBombe()) {

                        if (c.caseVide()) {
                            PdJ.decouvrirVide(lig, col);
                            grilleJeu.repaint();
                        }else{
                            c.setCache(false);
                            grilleJeu.repaint();
                        }
                    }
                    
                    if (c.caseBombe()){
                        
                        c.setCache(false);
                        c.setBoum(true);                       
                        afficherBombes(); //méthode afficher les bombes car défaite
                        setVictoire(-1); //On dit défaite!
                        ViOuDe(); //appel de la méthode pour 'concrétiser' défaite ou victoire                       
                    }
                });
                
                //ActionListener pour le clic droit 
                //
                
                grilleJeu.repaint();
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nbrBombesRestantes = new javax.swing.JTextField();
        tempsRestant = new javax.swing.JTextField();
        grilleJeu = new javax.swing.JPanel();
        btn_start = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nbrBombesRestantes.setBackground(new java.awt.Color(0, 0, 0));
        nbrBombesRestantes.setForeground(new java.awt.Color(255, 51, 0));
        nbrBombesRestantes.setPreferredSize(new java.awt.Dimension(200, 50));
        nbrBombesRestantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nbrBombesRestantesActionPerformed(evt);
            }
        });
        getContentPane().add(nbrBombesRestantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 140, -1));

        tempsRestant.setBackground(new java.awt.Color(0, 0, 0));
        tempsRestant.setForeground(new java.awt.Color(255, 51, 51));
        tempsRestant.setPreferredSize(new java.awt.Dimension(200, 50));
        tempsRestant.setRequestFocusEnabled(false);
        getContentPane().add(tempsRestant, new org.netbeans.lib.awtextra.AbsoluteConstraints(934, 6, 140, -1));

        grilleJeu.setBackground(new java.awt.Color(255, 255, 255));
        grilleJeu.setLayout(new java.awt.GridLayout(10, 10));
        getContentPane().add(grilleJeu, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 62, 1060, 650));

        btn_start.setText("Débuter Partie");
        btn_start.setPreferredSize(new java.awt.Dimension(150, 30));
        btn_start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_startActionPerformed(evt);
            }
        });
        getContentPane().add(btn_start, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 17, 120, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nbrBombesRestantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nbrBombesRestantesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nbrBombesRestantesActionPerformed

    private void btn_startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_startActionPerformed
        grilleJeu.setVisible(true);
        initialiserPartie();
        grilleJeu.repaint();
        btn_start.setEnabled(false);
    }//GEN-LAST:event_btn_startActionPerformed

    public void initialiserPartie() {
        PdJ.AjoutBombes();
        PdJ.compteBombe();
        PdJ.afficherGrilleSurConsole();
    }

    public void afficherBombes(){
        
        int cmtB = 0;
        for (int i = 0; i < ligne; i++){
            for (int j = 0; j < colonne; j++){
                if (PdJ.grille[i][j].caseBombe() && PdJ.grille[i][j].isCache() && !PdJ.grille[i][j].isDrapeauVisible()){
                    PdJ.grille[i][j].setCache(false);
                    cmtB ++;
                }
            }
        }
        System.out.println("Il vous manquait "+cmtB+" bombes à trouver.");
        grilleJeu.repaint();
    }

    public int getVictoire() {
        return Victoire;
    }

    public void setVictoire(int Victoire) {
        this.Victoire = Victoire;
    }
    
    public void ViOuDe(){
        if (getVictoire() == -1){ //cas défaite
            System.out.println("Vous avez perdu !");
        }
        if (getVictoire() == 1){ //cas victoire
            System.out.println("Vous avez gagné !");
        }
        
        for (int i = 0; i < (ligne*colonne); i++) {
            CaseGraphique cg = listeCaseGraph.get(i);
            cg.setEnabled(false);
        }
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(fenetreJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fenetreJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fenetreJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fenetreJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fenetreJeu().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btn_start;
    private javax.swing.JPanel grilleJeu;
    private javax.swing.JTextField nbrBombesRestantes;
    private javax.swing.JTextField tempsRestant;
    // End of variables declaration//GEN-END:variables
}
