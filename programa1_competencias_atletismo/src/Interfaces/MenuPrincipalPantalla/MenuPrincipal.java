
package Interfaces.MenuPrincipalPantalla;

import Interfaces.MarcasPantalla.MarcaPantalla;
import Interfaces.VisoresAtletasPantalla.VisoresPantalla;
import Interfaces.ListadoPantallas.ListadoMarcasPantalla;
import Interfaces.DisciplinasPantalla.DisciplinaPantalla;
import Interfaces.CompetenciasPantalla.CompetenciaPantalla;
import Interfaces.AtletasPantalla.AtletaPantalla;
import Interfaces.Configuracion.ConfiguracionPantalla;
import javax.swing.JOptionPane;
import Lógica.PrincipalAtletismo;

public class MenuPrincipal extends javax.swing.JFrame {
    
    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        atletaBot = new javax.swing.JButton();
        disciplinasBot = new javax.swing.JButton();
        CompetenciasBot = new javax.swing.JButton();
        marcasBot = new javax.swing.JButton();
        visoresBot = new javax.swing.JButton();
        ListadodeMarcasBot1 = new javax.swing.JButton();
        SalirBot = new javax.swing.JButton();
        Configuracion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setName("Competencias de atletismo"); // NOI18N

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Sylfaen", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("COMPETENCIAS DE ATLETISMO");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));

        atletaBot.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        atletaBot.setText("Atletas");
        atletaBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atletaBotActionPerformed(evt);
            }
        });

        disciplinasBot.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        disciplinasBot.setText("Disciplinas");
        disciplinasBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disciplinasBotActionPerformed(evt);
            }
        });

        CompetenciasBot.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CompetenciasBot.setText("Competencias");
        CompetenciasBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CompetenciasBotActionPerformed(evt);
            }
        });

        marcasBot.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        marcasBot.setText("Marcas de atletas");
        marcasBot.setToolTipText("");
        marcasBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                marcasBotActionPerformed(evt);
            }
        });

        visoresBot.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        visoresBot.setText("Visores de Atletas");
        visoresBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visoresBotActionPerformed(evt);
            }
        });

        ListadodeMarcasBot1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ListadodeMarcasBot1.setText("Listado de Marcas");
        ListadodeMarcasBot1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListadodeMarcasBot1ActionPerformed(evt);
            }
        });

        SalirBot.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        SalirBot.setText("Salir");
        SalirBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirBotActionPerformed(evt);
            }
        });

        Configuracion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Configuracion.setText("Configuración");
        Configuracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfiguracionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Configuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(disciplinasBot, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(atletaBot, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CompetenciasBot, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(marcasBot, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(visoresBot, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ListadodeMarcasBot1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SalirBot, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(atletaBot, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(disciplinasBot, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(CompetenciasBot, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(marcasBot, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(visoresBot, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ListadodeMarcasBot1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(Configuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(SalirBot, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 55, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void atletaBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atletaBotActionPerformed
        
        AtletaPantalla AtletaP = new AtletaPantalla();
        AtletaP.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_atletaBotActionPerformed

    private void disciplinasBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disciplinasBotActionPerformed
        
        DisciplinaPantalla DisciplinaP = new DisciplinaPantalla();
        DisciplinaP.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_disciplinasBotActionPerformed

    private void CompetenciasBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CompetenciasBotActionPerformed
        CompetenciaPantalla CompetenciaP = new CompetenciaPantalla();
        CompetenciaP.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CompetenciasBotActionPerformed

    private void marcasBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marcasBotActionPerformed
        MarcaPantalla RegistroP = new MarcaPantalla();
        RegistroP.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_marcasBotActionPerformed

    private void visoresBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visoresBotActionPerformed
        VisoresPantalla VisoresP = new VisoresPantalla();
        VisoresP.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_visoresBotActionPerformed

    private void ListadodeMarcasBot1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListadodeMarcasBot1ActionPerformed
        ListadoMarcasPantalla ListadoP = new ListadoMarcasPantalla();
        ListadoP.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ListadodeMarcasBot1ActionPerformed

    private void SalirBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirBotActionPerformed
         this.dispose();
    }//GEN-LAST:event_SalirBotActionPerformed

    private void ConfiguracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfiguracionActionPerformed
        ConfiguracionPantalla config = new ConfiguracionPantalla();
        config.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ConfiguracionActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
              
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CompetenciasBot;
    private javax.swing.JButton Configuracion;
    private javax.swing.JButton ListadodeMarcasBot1;
    private javax.swing.JButton SalirBot;
    private javax.swing.JButton atletaBot;
    private javax.swing.JButton disciplinasBot;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton marcasBot;
    private javax.swing.JButton visoresBot;
    // End of variables declaration//GEN-END:variables
}
