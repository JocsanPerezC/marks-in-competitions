
package Interfaces.VisoresAtletasPantalla;
import Interfaces.MenuPrincipalPantalla.MenuPrincipal;
import Lógica.Atleta;
import Lógica.PrincipalAtletismo;
import Lógica.Prueba;
import Lógica.VisorAtleta;
import java.util.ArrayList;
import Lógica.EnviarCorreo;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;


public class VisorPantallaCorreos extends javax.swing.JFrame {
    
    String atributoVisor;

    /**
     * Creates new form VisorPantallaCorreos
     */
    public VisorPantallaCorreos() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    public void crearCorreo(String pVisor) throws MessagingException{
        
        
        atributoVisor = pVisor;
        
        String listaCompetencias;
        ArrayList<Prueba> listaPruebas;
        ArrayList<Atleta> listaAtletas = PrincipalAtletismo.claseMain.getListaAtletas();
        ArrayList<String> listaMarcas;
        ArrayList<Atleta> listaAtletasAux = new ArrayList<Atleta>();
        ArrayList<String> listaCompetenciasAux = new ArrayList<>();
        ArrayList<VisorAtleta> listaVisores = PrincipalAtletismo.claseMain.getListaVisores();
        int indiceCompetencia = 0;
        int indiceAtleta = 0;
        String mensaje = "";
        
        EnviarCorreo envioCorreo = new EnviarCorreo();
        
        boolean indicador = true;
        
        if(atributoVisor == null || atributoVisor.length() == 0){
          
            indicador = false;
        }
      
        int cantidadListado = PrincipalAtletismo.claseMain.getConfiguracion();
        
        for(VisorAtleta visor: listaVisores){
            
            if(indicador){
               
                if(visor.getId().equals(atributoVisor) == false){
                    
                    continue;
                }
            }
            
            listaAtletas = visor.getAtletas();
         
            for(Atleta atleta: listaAtletas){
  
                listaPruebas = atleta.getPruebas();
              
                for(Prueba prueba: listaPruebas){
                    
                    listaCompetencias = prueba.getCompetencia();
                    listaMarcas = prueba.getMarcaAtletas();
                    listaAtletasAux = prueba.getListaAtletas();
                    
                    indiceAtleta = 0;
                    for(Atleta atletaAux: listaAtletasAux){

                        if(atletaAux.getId().equals(atleta.getId())){

                            break;
                        }

                        indiceAtleta ++;
                    }
                    
                    listaAtletasAux = visor.getAtletas();
                    
                    mensaje += "Información sobre el atleta " + atleta.getNombre();
                    mensaje += " se encuentra en la prueba " + prueba.getNombre();
                    mensaje += " en la competencia " + listaCompetencias;
                    mensaje += " con la marca " + listaMarcas.get(indiceAtleta);

                }
                
                mensaje += "\n\n";
                
            }
            
            envioCorreo.envioDeCorreo(visor.getEmail(), "Información de atletas", mensaje);
            
            mensaje = "";
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

        regresarBot = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        enviarTodosBot = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        idVisorText = new javax.swing.JTextArea();
        enviarBot = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        regresarBot.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        regresarBot.setText("Regresar");
        regresarBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarBotActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Sylfaen", 0, 24)); // NOI18N
        jLabel4.setText("ID del visor para enviarle el correo:");

        jLabel5.setFont(new java.awt.Font("Sylfaen", 0, 24)); // NOI18N
        jLabel5.setText("En caso de querer enviar a todos presionar el siguiente boton:");

        enviarTodosBot.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        enviarTodosBot.setText("Enviar a todos");
        enviarTodosBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarTodosBotActionPerformed(evt);
            }
        });

        idVisorText.setColumns(20);
        idVisorText.setRows(5);
        jScrollPane1.setViewportView(idVisorText);

        enviarBot.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        enviarBot.setText("Enviar");
        enviarBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarBotActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(enviarTodosBot, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(regresarBot, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(333, 333, 333))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(enviarBot, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(164, 164, 164))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(enviarBot, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(enviarTodosBot, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addComponent(regresarBot, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void regresarBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarBotActionPerformed
       
        try {
            crearCorreo(idVisorText.getText());
        } catch (MessagingException ex) {
            Logger.getLogger(VisorPantallaCorreos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.dispose();
        VisoresPantalla VisorP = new VisoresPantalla();
        VisorP.setVisible(true);
    }//GEN-LAST:event_regresarBotActionPerformed

    private void enviarTodosBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarTodosBotActionPerformed
        try {
            crearCorreo("");
        } catch (MessagingException ex) {
            Logger.getLogger(VisorPantallaCorreos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.dispose();
        VisoresPantalla VisorP = new VisoresPantalla();
        VisorP.setVisible(true);
    }//GEN-LAST:event_enviarTodosBotActionPerformed

    private void enviarBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarBotActionPerformed
        String idVisor = idVisorText.getText();
        
        try {
            crearCorreo(idVisor);
        } catch (MessagingException ex) {
            Logger.getLogger(VisorPantallaCorreos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.dispose();
        VisoresPantalla VisorP = new VisoresPantalla();
        VisorP.setVisible(true);
    }//GEN-LAST:event_enviarBotActionPerformed

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
            java.util.logging.Logger.getLogger(VisorPantallaCorreos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VisorPantallaCorreos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VisorPantallaCorreos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VisorPantallaCorreos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VisorPantallaCorreos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton enviarBot;
    private javax.swing.JButton enviarTodosBot;
    private javax.swing.JTextArea idVisorText;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton regresarBot;
    // End of variables declaration//GEN-END:variables
}
