/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import connection.connexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.jdbc.JDBCCategoryDataset;

/**
 *
 * @author Hamza
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
        this.setTitle("Gestion des Reservations");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        ClientsMenuItem = new javax.swing.JMenuItem();
        ChambreMenuItem = new javax.swing.JMenuItem();
        CategorieMenuItem = new javax.swing.JMenuItem();
        ReservationMenuItem = new javax.swing.JMenuItem();
        UtilisateurMenuItem1 = new javax.swing.JMenuItem();
        StatistiquesMenuItem2 = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        cutMenuItem = new javax.swing.JMenuItem();
        copyMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        desktopPane.setBackground(new java.awt.Color(0, 102, 102));

        fileMenu.setMnemonic('f');
        fileMenu.setText("GESTION");

        ClientsMenuItem.setMnemonic('o');
        ClientsMenuItem.setText("Clients");
        ClientsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClientsMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(ClientsMenuItem);

        ChambreMenuItem.setMnemonic('s');
        ChambreMenuItem.setText("Chambre");
        ChambreMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChambreMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(ChambreMenuItem);

        CategorieMenuItem.setMnemonic('x');
        CategorieMenuItem.setText("Categorie");
        CategorieMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CategorieMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(CategorieMenuItem);

        ReservationMenuItem.setMnemonic('a');
        ReservationMenuItem.setText("Reservations");
        ReservationMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReservationMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(ReservationMenuItem);

        UtilisateurMenuItem1.setMnemonic('o');
        UtilisateurMenuItem1.setText("Utilisateur");
        UtilisateurMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UtilisateurMenuItem1ActionPerformed(evt);
            }
        });
        fileMenu.add(UtilisateurMenuItem1);

        StatistiquesMenuItem2.setMnemonic('o');
        StatistiquesMenuItem2.setText("Statistiques");
        StatistiquesMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StatistiquesMenuItem2ActionPerformed(evt);
            }
        });
        fileMenu.add(StatistiquesMenuItem2);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        editMenu.setMnemonic('e');
        editMenu.setText("RECHERCHE");

        cutMenuItem.setMnemonic('t');
        cutMenuItem.setText("FindChambreByCategorie");
        cutMenuItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cutMenuItemMouseClicked(evt);
            }
        });
        cutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cutMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(cutMenuItem);

        copyMenuItem.setMnemonic('y');
        copyMenuItem.setText("findChambreBetweenDates");
        copyMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(copyMenuItem);

        menuBar.add(editMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1266, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CategorieMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CategorieMenuItemActionPerformed
       CategorieF ca = new CategorieF();
        desktopPane.add(ca);
        ca.setVisible(true);
       
    }//GEN-LAST:event_CategorieMenuItemActionPerformed

    private void ClientsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClientsMenuItemActionPerformed
     ClientsFO cF=new ClientsFO();
        desktopPane.add(cF);
        cF.setVisible(true);
    }//GEN-LAST:event_ClientsMenuItemActionPerformed

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
            System.exit(0); 
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void ChambreMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChambreMenuItemActionPerformed
        ChambreF cha = new ChambreF();
            desktopPane.add(cha);
            cha.setVisible(true);
    }//GEN-LAST:event_ChambreMenuItemActionPerformed

    private void ReservationMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReservationMenuItemActionPerformed
        ReservationF r = new ReservationF();
            desktopPane.add(r);
            r.setVisible(true);
    }//GEN-LAST:event_ReservationMenuItemActionPerformed

    private void cutMenuItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cutMenuItemMouseClicked
       // TODO add your handling code here:
    }//GEN-LAST:event_cutMenuItemMouseClicked

    private void UtilisateurMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UtilisateurMenuItem1ActionPerformed
// TODO add your handling code here:
        UtilisateurFo ut =new UtilisateurFo();
        desktopPane.add(ut);
        ut.setVisible(true);
    }//GEN-LAST:event_UtilisateurMenuItem1ActionPerformed

    private void cutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cutMenuItemActionPerformed
        // TODO add your handling code here:
         FindChambre fc =new FindChambre();
        desktopPane.add(fc);
        fc.setVisible(true);
        
    }//GEN-LAST:event_cutMenuItemActionPerformed

    private void copyMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyMenuItemActionPerformed
        // TODO add your handling code here:
        FindBetween fb=new  FindBetween();
        desktopPane.add(fb);
        fb.setVisible(true);
    }//GEN-LAST:event_copyMenuItemActionPerformed

    private void StatistiquesMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StatistiquesMenuItem2ActionPerformed
        // TODO add your handling code here:
        try {
            JDBCCategoryDataset dataset = new JDBCCategoryDataset(connexion.getCon());
            String query = "select count(c.id) as nombreChambre,cat.libelle as libellecategorie from chambre c,categorie cat\n"
                    + "where c.idCategorie = cat.id group by c.idCategorie";
            PreparedStatement ps = connexion.getCon().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String toc = rs.getString("libellecategorie");
                int summary = rs.getInt("nombreChambre");
                dataset.setValue(summary, toc, toc);
            }
            JFreeChart chart = ChartFactory.createBarChart("Statistiques", "nombreChambre", "libellecategorie", dataset, PlotOrientation.VERTICAL, false, true, false);
            CategoryPlot plot = chart.getCategoryPlot();
            ChartFrame frame = new ChartFrame("Statistiques", chart);
            frame.setVisible(true);
            frame.setSize(400, 650);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_StatistiquesMenuItem2ActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem CategorieMenuItem;
    private javax.swing.JMenuItem ChambreMenuItem;
    private javax.swing.JMenuItem ClientsMenuItem;
    private javax.swing.JMenuItem ReservationMenuItem;
    private javax.swing.JMenuItem StatistiquesMenuItem2;
    private javax.swing.JMenuItem UtilisateurMenuItem1;
    private javax.swing.JMenuItem copyMenuItem;
    private javax.swing.JMenuItem cutMenuItem;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuBar menuBar;
    // End of variables declaration//GEN-END:variables

}