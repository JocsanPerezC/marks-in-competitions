
package Interfaces.ListadoPantallas;

import Interfaces.ListadoPantallas.ListadoMarcasPantalla;
import Interfaces.MenuPrincipalPantalla.MenuPrincipal;
import Lógica.Atleta;
import Lógica.Competencia;
import Lógica.PrincipalAtletismo;
import javax.swing.JOptionPane;
import Lógica.Prueba;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.table.DefaultTableModel;
import java.util.Arrays;


public class ListadoMarcasPorPrueba extends javax.swing.JFrame {
    DefaultTableModel tablaAux = new DefaultTableModel();
    String atributoPrueba;
    /**
     * Creates new form listadoMarcasPorPrueba
     */
    public ListadoMarcasPorPrueba(String pPrueba) {
        initComponents();
        setLocationRelativeTo(null);
        atributoPrueba = pPrueba;
        setModelo();
        listarRegistro();
    }
    
    public void setModelo(){
        
        String[] cabezera = {"Prueba", "Atleta", "País", "Marca", "Lugar en la competencia", "Competencia"};
        tablaAux.setColumnIdentifiers(cabezera);
        tablaPrincipal.setModel(tablaAux);//Permite definir el número de columnas y filas del objeto como también las expresiones que irán en las columnas
        
    }
    
    public void listarRegistro(){
        
        // ARRAYLIST 
        
        ArrayList<Prueba> listaPruebas;
        ArrayList<Atleta> listaAtletasAux = PrincipalAtletismo.claseMain.getListaAtletas();
        ArrayList<String> listaMarcas = new ArrayList<>();
        ArrayList<String> listaMarcasAux;
        ArrayList<Atleta> listaAtletas;
        ArrayList<String> listaMarcasPrincipal = new ArrayList<>();
        ArrayList<String> nombresPruebas = new ArrayList<>();
        ArrayList<String> listaCompetencias = new ArrayList<>();
        int indiceTotal = 0;
        int indiceCompetencia = 0;
        int indiceAtleta = 0;
        int indiceGeneral = 0;
        boolean indicador = false;
        String atributoPruebaAux = new String(atributoPrueba);
        
        int cantidadListado = PrincipalAtletismo.claseMain.getConfiguracion();
        
        String[] datos = new String[6];
        
        tablaAux.setRowCount(0);
        
        listaAtletas = new ArrayList<>();
          
        for(Atleta atleta: listaAtletasAux){
            
            
            listaPruebas = atleta.getPruebas();
            
            for(Prueba prueba: listaPruebas){
                
                
                if(atributoPruebaAux.length() == 0){
                    
                    atributoPrueba = prueba.getNombre();
                }
                
                if(prueba.getNombre().equals(atributoPrueba)){
                 
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

                    indiceAtleta = 0;
                    
                    for(String marca: listaMarcas){
                        
                        indiceAtleta = indiceGeneral;
                        for(String marcaAux: listaMarcasAux){
                            
                            if(marca.equals(marcaAux)){
                                
                                indicador = false;
                                
                                indiceTotal = 0;
                                for(Atleta atletaActual: listaAtletas){
                                   
                                    if(atletaActual.getId().equals(listaAtletasAux.
                                            get(indiceAtleta).getId()) && 
                                            prueba.getCompetencia().equals(listaCompetencias.
                                                    get(indiceTotal))){
                                        
                                            indicador = true;
                                            break;
                                        
                                        
                                    }
                                    
                                    indiceTotal ++;
                                }
                               
                                if(indicador == false){
                                   
                                    listaMarcasPrincipal.add(prueba.getMarcaAtleta(listaAtletasAux.get(indiceAtleta).getId()));
                                    nombresPruebas.add(prueba.getNombre());
                                    nombresPruebas.add(prueba.getCompetencia());
                                    listaAtletas.add(listaAtletasAux.get(indiceAtleta));
                                    listaCompetencias.add(prueba.getCompetencia());
                                    break;
                                }                              

                            }

                        }
                        
                        indiceAtleta ++;
                    }

                    indiceAtleta = 0;

                    indicador = true;
                    
                }
                         
            }
            
            indiceGeneral ++;
        }
        
        indiceAtleta = 0;  
        
        int indiceAux = 0;
                
        for(Atleta atletaAux: listaAtletas){
            
            if(listaMarcasPrincipal.get(indiceAux) == null){
                indiceAtleta += 2;
                indiceAux ++;
                continue;
                
            }
            
            datos[0] = nombresPruebas.get(indiceAtleta);
            datos[1] = atletaAux.getNombre();
            datos[2] = atletaAux.getPais();
            datos[3] = listaMarcasPrincipal.get(indiceAux);
            datos[4] = Integer.toString(indiceAux + 1);
            datos[5] = listaCompetencias.get(indiceAux);
            tablaAux.addRow(datos);
            indiceAtleta += 2;
            indiceAux ++;
            
            if(indiceAux == cantidadListado){
                
                tablaPrincipal.setModel(tablaAux);
                return;
            }
        }
        
        
        if(indicador == false){

            JOptionPane.showMessageDialog(this, "Ningún atleta se encuentra en esta prueba");           
            return;
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

        jScrollPane2 = new javax.swing.JScrollPane();
        tablaPrincipal = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        regresarBot = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaPrincipal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Atleta", "Dorsal", "Marca", "Lugar"
            }
        ));
        jScrollPane2.setViewportView(tablaPrincipal);

        jLabel1.setFont(new java.awt.Font("Sylfaen", 0, 24)); // NOI18N
        jLabel1.setText("Marcas por prueba");

        regresarBot.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        regresarBot.setText("Regresar");
        regresarBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarBotActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(205, 205, 205)
                                .addComponent(regresarBot, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(189, 189, 189)
                                .addComponent(jLabel1)))
                        .addGap(0, 185, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(regresarBot, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
            java.util.logging.Logger.getLogger(ListadoMarcasPorPrueba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListadoMarcasPorPrueba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListadoMarcasPorPrueba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListadoMarcasPorPrueba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListadoMarcasPorPrueba("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton regresarBot;
    private javax.swing.JTable tablaPrincipal;
    // End of variables declaration//GEN-END:variables
}
