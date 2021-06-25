/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cunoc.escaleraserpiente.Usuario;

import com.cunoc.escaleraserpiente.ManejadorArchivos.ManejoEscrituraLectura;
import com.cunoc.escaleraserpiente.Start;
import java.io.File;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author drymnz
 */
public class MenuReporte extends javax.swing.JPanel implements Runnable {

    private Usuario[] listado;
    private DefaultTableModel aparenciaTabla = new DefaultTableModel(){
        // sobre escribir el metodo de aparencia para que no se aditable la tabla para el usuario
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    /**
     * Creates new form MenuReportes
     */
    public MenuReporte() {
        initComponents();
        JTable.setModel(aparenciaTabla);
    }
    // metodos para la aparencia de la tabla
    public void cargarListadoUsuario(int contador) {
        listado = new Usuario[contador];
        (new Thread(this)).start();
        cargaraparenciaTabla();
    }
    private void cargaraparenciaTabla(){
        String[] titulos = {"ID","Nombre","Apellido","Victorias","Derrotas","Partidas Total"};
        aparenciaTabla.setColumnIdentifiers(titulos);
        for (int i = 0; i < listado.length; i++) {
            if (listado[i] != null) {
                aparenciaTabla.addRow(new Object[]{listado[i].getId(),listado[i].getNombre(),listado[i].getApellido(),listado[i].getVictoria(),listado[i].getPerdida(),listado[i].getCantidadPartidad()});
            }
        }
    }
    private void actualizar(){
        int filas = aparenciaTabla.getRowCount();
        for (int i = (filas-1); i >= 0; i--) {
            aparenciaTabla.removeRow(i);
        }
        cargaraparenciaTabla();
    }
   // fin  metodos para la aparencia de la tabla
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JButtonMenuPrincial = new javax.swing.JButton();
        JButtonActualizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTable = new javax.swing.JTable();

        setBackground(new java.awt.Color(160, 111, 111));

        JButtonMenuPrincial.setText("Menu Princial");
        JButtonMenuPrincial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonMenuPrincialActionPerformed(evt);
            }
        });

        JButtonActualizar.setText("Actualizar");
        JButtonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonActualizarActionPerformed(evt);
            }
        });

        JTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(JTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JButtonMenuPrincial)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 195, Short.MAX_VALUE)
                .addComponent(JButtonActualizar)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JButtonMenuPrincial)
                    .addComponent(JButtonActualizar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void JButtonMenuPrincialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonMenuPrincialActionPerformed
        // TODO add your handling code here:
        Start.ejecutar.irMenuPrincipal();
    }//GEN-LAST:event_JButtonMenuPrincialActionPerformed

    private void JButtonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonActualizarActionPerformed
        // TODO add your handling code here:
         actualizar();
    }//GEN-LAST:event_JButtonActualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JButtonActualizar;
    private javax.swing.JButton JButtonMenuPrincial;
    private javax.swing.JTable JTable;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        for (int i = 0; i < listado.length; i++) {
            Object obtener = (new ManejoEscrituraLectura()).lecturarArchivoBinario(new File(".Archivo/Usuario/" + (i + 1) + ".usuario"));
            listado[i] = (Usuario) (obtener);
        }
    }

}
