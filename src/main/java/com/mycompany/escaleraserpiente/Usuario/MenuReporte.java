/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.escaleraserpiente.Usuario;

import ManejadorArchivos.ManejoEscrituraLectura;
import com.mycompany.escaleraserpiente.Start;
import java.io.File;

/**
 *
 * @author drymnz
 */
public class MenuReporte extends javax.swing.JPanel implements Runnable {

    private Usuario[] listado;
    private int contador;

    /**
     * Creates new form MenuReportes
     */
    public MenuReporte() {
        initComponents();
    }

    public void cargarListadoUsuario(int contador) {
        this.contador = contador;
        listado = new Usuario[contador];
        (new Thread(this)).start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JButtonMenuPrincial = new javax.swing.JButton();
        JButtonActualizar = new javax.swing.JButton();

        setBackground(new java.awt.Color(160, 111, 111));

        JButtonMenuPrincial.setText("Menu Princial");
        JButtonMenuPrincial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonMenuPrincialActionPerformed(evt);
            }
        });

        JButtonActualizar.setText("Actualizar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JButtonMenuPrincial)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 173, Short.MAX_VALUE)
                .addComponent(JButtonActualizar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JButtonMenuPrincial)
                    .addComponent(JButtonActualizar))
                .addContainerGap(260, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void JButtonMenuPrincialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonMenuPrincialActionPerformed
        // TODO add your handling code here:
        Start.ejecutar.irMenuPrincipal();
    }//GEN-LAST:event_JButtonMenuPrincialActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JButtonActualizar;
    private javax.swing.JButton JButtonMenuPrincial;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        for (int i = 0; i < listado.length; i++) {
            Object obtener = (new ManejoEscrituraLectura()).lecturarArchivoBinario(new File(".Archivo/Usuario/" + (i + 1) + ".usuario"));
            listado[i] = (Usuario) (obtener);
        }
    }

}
