
package Interfaces.ListadoPantallas;
import Interfaces.ListadoPantallas.ListadoMarcasPantalla;
import Interfaces.MenuPrincipalPantalla.MenuPrincipal;
import Lógica.Atleta;
import Lógica.PrincipalAtletismo;
import Lógica.Prueba;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class ListadoMejoresMarcas extends javax.swing.JFrame {
    
    String atributoAtleta, atributoPrueba = "";
    
    DefaultTableModel tablaAux = new DefaultTableModel();

    /**
     * Creates new form listadoPorAtleta
     */
    public ListadoMejoresMarcas(String pAtleta) {
        initComponents();
        setLocationRelativeTo(null);
        atributoAtleta = pAtleta;
        setModelo();
        listarRegistro();
        
    }
    
     public void setModelo(){
        
        String[] cabezera = {"Atleta", "Prueba", "Marca", "Lugar en la competencia", "Competencia"};
        tablaAux.setColumnIdentifiers(cabezera);
        tablaPrincipal.setModel(tablaAux);//Permite definir el número de columnas y filas del objeto como también las expresiones que irán en las columnas
        
    }
    
    public void listarRegistro(){
        
        String listaCompetencias;
        ArrayList<Prueba> listaPruebas;
        ArrayList<Atleta> listaAtletas = PrincipalAtletismo.claseMain.getListaAtletas();
        ArrayList<String> listaMarcas;
        ArrayList<Atleta> listaAtletasAux = new ArrayList<Atleta>();
        ArrayList<String> listaMarcasAux;
        ArrayList<String> listaMarcasPrincipal = new ArrayList<String>();
        ArrayList<String> listaPruebasAux = new ArrayList<>();
        ArrayList<String> listaCompetenciasAux = new ArrayList<>();
        int indiceCompetencia = 0;
        int indiceAtleta = 0;
        
        int posicion = 1;
        boolean indicador = false;
        boolean bandera = false;
        if(atributoPrueba.length() == 0){
            
            indicador = true;
        }
        
        int cantidadListado = PrincipalAtletismo.claseMain.getConfiguracion();
        
        String[] datos = new String[5];
        
        tablaAux.setRowCount(0);
        for(Atleta atleta: listaAtletas){
          
            if(atributoAtleta.length() != 0){
                
                if(atleta.getId().equals(atributoAtleta)){
                    
                    listaPruebas = atleta.getPruebas();
                    
                    for(Prueba prueba: listaPruebas){
                        
                       
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

                        indiceAtleta = 0;

                        for(String marca: listaMarcas){

                            for(String marcaAux: listaMarcasAux){

                                if(marca.equals(marcaAux)){
                                    bandera = false;
                                    for(Atleta atletaActual: listaAtletas){
                                     
                                        if(listaAtletasAux.size() == 0) break;
                                        if(atletaActual.getId().equals(listaAtletasAux.
                                                get(indiceAtleta).getId())){
                                            bandera = true;
                                            break;
                                        }
                                        
                                    }
                                  
                                   
                                    if(bandera == false){
                                      
                                        if(atributoAtleta.length() != 0 && listaAtletas.get(indiceAtleta).
                                                getId().equals(atributoAtleta)){

                                            listaMarcasPrincipal.add(prueba.getMarcaAtleta(listaAtletas.get(indiceAtleta).getId()));
                                            listaPruebasAux.add(prueba.getNombre());
                                            listaCompetenciasAux.add(prueba.getCompetencia());
                                            listaAtletasAux.add(listaAtletas.get(indiceAtleta));

                                            indiceCompetencia ++;
                                            break;

                                        }

                                        indiceAtleta ++;
                                    }   


                                }   
                               //indiceAtleta ++;
                            }
                        }

                    }
                }
            }
            
            else{
            
                listaPruebas = atleta.getPruebas();
              
                for(Prueba prueba: listaPruebas){
                    
                    if(indicador == true){
                        
                        atributoPrueba = prueba.getNombre();
                    }
                    else if(prueba.getNombre().equals(atributoPrueba) == false){
                        
                        continue;
                    }

                    listaCompetencias = prueba.getCompetencia();
                    listaAtletasAux = prueba.getListaAtletas();
                    listaMarcas = prueba.getMarcaAtletas();
                    
                    indiceAtleta = 0;
                    for(Atleta atletaAux: listaAtletasAux){

                        if(atletaAux.getId().equals(atleta.getId())){

                            break;
                        }

                        indiceAtleta ++;
                    }
                    
                    
                    datos[0] = atleta.getNombre();
                    datos[1] = prueba.getNombre();
                    datos[2] = listaMarcas.get(indiceAtleta);
                    datos[3] = Integer.toString(posicion);
                    datos[4] = listaCompetencias;

                    tablaAux.addRow(datos);
                    
                    posicion ++;
                    indiceAtleta ++;

                }
                
                indiceCompetencia ++;
            
            }
            
            if(indiceCompetencia == cantidadListado && indiceCompetencia != 0){
                
                break;
            }
         
        }
        
      
        if(atributoAtleta.length() != 0){
            
            indiceAtleta = 0;
            
            for(Atleta atletaActual2: listaAtletasAux){
               
                if(atletaActual2.getId().equals(atributoAtleta)){
                   
                    datos[0] = atletaActual2.getId();
                    datos[1] = listaPruebasAux.get(indiceAtleta);
                    datos[2] = listaMarcasPrincipal.get(indiceAtleta);
                    datos[3] = Integer.toString(indiceAtleta + 1);
                    datos[4] = listaCompetenciasAux.get(indiceAtleta);

                    tablaAux.addRow(datos);
                    break;
                }
                
                indiceAtleta ++;
            }
        }

        tablaPrincipal.setModel(tablaAux);
    }
    /**
     * Creates new form listadoMejoresMarcas
     */
    

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
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Atleta", "Dorsal", "Marca", "Lugar"
            }
        ));
        jScrollPane2.setViewportView(tablaPrincipal);

        jLabel1.setFont(new java.awt.Font("Sylfaen", 0, 24)); // NOI18N
        jLabel1.setText("Mejores marcas del atleta");

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
                        .addGap(0, 236, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(ListadoMejoresMarcas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListadoMejoresMarcas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListadoMejoresMarcas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListadoMejoresMarcas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListadoMejoresMarcas("").setVisible(true);
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
