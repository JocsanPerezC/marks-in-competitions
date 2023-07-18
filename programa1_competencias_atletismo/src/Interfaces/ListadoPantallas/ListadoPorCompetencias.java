
package Interfaces.ListadoPantallas;

import Interfaces.ListadoPantallas.ListadoMarcasPantalla;
import Interfaces.MenuPrincipalPantalla.MenuPrincipal;
import Lógica.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.util.Collections;
import java.util.Comparator;


public class ListadoPorCompetencias extends javax.swing.JFrame {
    
    String atributoCompetencia, atributoPrueba;
    DefaultTableModel tablaAux = new DefaultTableModel();

    /**
     * Creates new form listadoCompetencias
     */
    public ListadoPorCompetencias(String pCompetencia, String pPrueba) {
        initComponents();
        setLocationRelativeTo(null);
        atributoCompetencia = pCompetencia;
        atributoPrueba = pPrueba;
        setModelo();
        listarRegistro();

        
    }
    
     public void setModelo(){
        
        String[] cabezera = {"Competencia", "Prueba", "Atleta", "Dorsal", "Marca", "Lugar"};
        tablaAux.setColumnIdentifiers(cabezera);
        tablaPrincipal.setModel(tablaAux); //Permite definir el número de columnas y filas del objeto como también las expresiones que irán en las columnas
        
    }
    
    public void listarRegistro(){
        
        ArrayList<Competencia> listaCompetencias = PrincipalAtletismo.claseMain.getCompetencias();
        ArrayList<Prueba> listaPruebas;
        ArrayList<Atleta> listaAtletas;
        ArrayList<String> listaMarcas;
        ArrayList<String> listaMarcasAux;
        ArrayList<Atleta> listaAtletasAux;
        int indiceCompetencia = 0;
        int indiceAtleta = 0;
        boolean indicador = true;
        
        if(atributoPrueba.length() == 0){
            
            indicador = false;
            
        }
        
        int cantidadListado = PrincipalAtletismo.claseMain.getConfiguracion();
       
        String[] datos = new String[6];
       
        tablaAux.setRowCount(0);
        for(Competencia competencia: listaCompetencias){
            
      
            if(atributoCompetencia.length() != 0){
                
                if(competencia.getNombre().equals(atributoCompetencia)){
                    
                    listaPruebas = new ArrayList<>(competencia.getPruebas());
                   
                    for(Prueba prueba: listaPruebas){
                        
                        if(indicador == true && prueba.getNombre().equals(atributoPrueba) == false){
                            
                            
                        }
                        
                        else{
                            
                            listaAtletasAux = prueba.getListaAtletas();
                            listaMarcasAux = prueba.getMarcaAtletas();
                            listaMarcas = new ArrayList(prueba.getMarcaAtletas());
                        
                            if(prueba.getMedicion().charAt(0) == 'M' || prueba.getMedicion().charAt(0)
                                    == 'm'){
                                
                               
                                Comparator<String> comparador = Collections.reverseOrder();
                                Collections.sort(listaMarcas, comparador);
                                
                                        
                            }
                            else{
                                
                                Collections.sort(listaMarcas);
                                
                            }
                            
                          
                            listaAtletas = new ArrayList<>();
                            
                            indiceAtleta = 0;
                            
                            for(String marca: listaMarcas){
                                
                                for(String marcaAux: listaMarcasAux){
                                    
                                    if(marca.equals(marcaAux)){
                                    
                                    listaAtletas.add(listaAtletasAux.get(indiceAtleta));
                                    
                                    }                                    
                                }
                                
                                indiceAtleta ++;
                                
                            }
                            
                            
                            indiceAtleta = 0;

                            for(Atleta atleta: listaAtletas){

                                datos[0] = competencia.getNombre();
                                datos[1] = prueba.getNombre();
                                datos[2] = atleta.getNombre();
                                datos[3] = Integer.toString(atleta.getDorsal());
                                datos[4] = listaMarcas.get(indiceAtleta);
                                datos[5] = Integer.toString(indiceAtleta + 1);
                                tablaAux.addRow(datos);
                                indiceAtleta ++;
                                
                                indiceCompetencia ++;
                               
                                if(indiceCompetencia == cantidadListado){
                                    tablaPrincipal.setModel(tablaAux);
                                    return;
                                }
                            }
                        
                        }
                    }
                }
            }
            else{
                
             
                listaPruebas = competencia.getPruebas();

                for(Prueba prueba: listaPruebas){
                    indiceAtleta = 0;
                   
                    listaAtletasAux = prueba.getListaAtletas();
                    listaMarcasAux = prueba.getMarcaAtletas();
                    listaMarcas = prueba.getMarcaAtletas();
                    if(prueba.getMedicion().charAt(0) == 'M' || prueba.getMedicion().charAt(0)
                            == 'm'){

                        Comparator<String> comparador = Collections.reverseOrder();
                        Collections.sort(listaMarcas, comparador);


                    }
                    else{

                        Collections.sort(listaMarcas);

                    }

                    listaAtletas = new ArrayList<>();
                    
                    for(String marca: listaMarcas){
                  
                        for(String marcaAux: listaMarcasAux){

                            if(marca.equals(marcaAux)){

                            listaAtletas.add(listaAtletasAux.get(indiceAtleta));
                            indiceAtleta ++;
                            }
                            
                        }
                    }
                    
                    indiceAtleta = 0;

                    for(Atleta atleta: listaAtletas){
                     
                        datos[0] = competencia.getNombre();
                        datos[1] = prueba.getNombre();
                        datos[2] = atleta.getNombre();
                        datos[3] = Integer.toString(atleta.getDorsal());
                        datos[4] = listaMarcas.get(indiceAtleta);
                        datos[5] = Integer.toString(indiceAtleta + 1);
                        tablaAux.addRow(datos);
                        indiceAtleta ++;
                            
                        if(indiceAtleta == cantidadListado){
                            
                            tablaPrincipal.setModel(tablaAux);
                            return;
                        }
                        indiceCompetencia ++;
            
                        if(indiceCompetencia == cantidadListado){
                            tablaPrincipal.setModel(tablaAux);
                            return;
                        }
                    }
                }
            
            }
            
            indiceCompetencia ++;
            
            if(indiceCompetencia == cantidadListado){
                tablaPrincipal.setModel(tablaAux);
                return;
            }
         
        }
        
        tablaPrincipal.setModel(tablaAux);
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
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaPrincipal = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        regresarBot = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaPrincipal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tablaPrincipal);

        jLabel1.setFont(new java.awt.Font("Sylfaen", 0, 24)); // NOI18N
        jLabel1.setText("Marcas por Competencia y Prueba");

        regresarBot.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        regresarBot.setText("Regresar");
        regresarBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarBotActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(139, 139, 139)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(205, 205, 205)
                                .addComponent(regresarBot, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 162, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(regresarBot, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void regresarBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarBotActionPerformed
        this.dispose();
        ListadoMarcasPantalla Listado = new ListadoMarcasPantalla();
        Listado.setVisible(true);
    }//GEN-LAST:event_regresarBotActionPerformed

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
            java.util.logging.Logger.getLogger(ListadoPorCompetencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListadoPorCompetencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListadoPorCompetencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListadoPorCompetencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListadoPorCompetencias("", "").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton regresarBot;
    private javax.swing.JTable tablaPrincipal;
    // End of variables declaration//GEN-END:variables
}
