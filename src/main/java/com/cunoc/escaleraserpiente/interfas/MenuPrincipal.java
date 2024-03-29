/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cunoc.escaleraserpiente.interfas;

import com.cunoc.escaleraserpiente.Start;

/**
 *
 * @author drymnz
 */
public class MenuPrincipal extends javax.swing.JPanel {

    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JButtonJugar = new javax.swing.JButton();
        JLabelLogo = new javax.swing.JLabel();
        JButtonCargarPartica = new javax.swing.JButton();
        JButtonRegistrarUsuario = new javax.swing.JButton();
        JButtonReportes = new javax.swing.JButton();
        JButtonSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(45, 214, 233));

        JButtonJugar.setBackground(java.awt.Color.gray);
        JButtonJugar.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        JButtonJugar.setText("Jugar");
        JButtonJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonJugarActionPerformed(evt);
            }
        });

        JLabelLogo.setIcon(new javax.swing.ImageIcon("/home/drymnz/NetBeansProjects/EscaleraSerpiente/src/main/resources/path54.png")); // NOI18N

        JButtonCargarPartica.setBackground(java.awt.Color.gray);
        JButtonCargarPartica.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        JButtonCargarPartica.setText("Cargar Partica");
        JButtonCargarPartica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonCargarParticaActionPerformed(evt);
            }
        });

        JButtonRegistrarUsuario.setBackground(java.awt.Color.gray);
        JButtonRegistrarUsuario.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        JButtonRegistrarUsuario.setText("Registrar Usuario");
        JButtonRegistrarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonRegistrarUsuarioActionPerformed(evt);
            }
        });

        JButtonReportes.setBackground(java.awt.Color.gray);
        JButtonReportes.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        JButtonReportes.setText("Reportes");
        JButtonReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonReportesActionPerformed(evt);
            }
        });

        JButtonSalir.setBackground(java.awt.Color.gray);
        JButtonSalir.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        JButtonSalir.setText("Salir");
        JButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonSalirActionPerformed(evt);
            }
        });

        jLabel1.setText("Benjamin de Jesus Perez Aguiar ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(JLabelLogo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JButtonJugar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JButtonCargarPartica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JButtonRegistrarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                    .addComponent(JButtonReportes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JButtonSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(JButtonJugar)
                .addGap(18, 18, 18)
                .addComponent(JButtonCargarPartica)
                .addGap(18, 18, 18)
                .addComponent(JButtonRegistrarUsuario)
                .addGap(18, 18, 18)
                .addComponent(JButtonReportes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JButtonSalir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void JButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonSalirActionPerformed
        // TODO add your handling code here:
         System.exit(0);
    }//GEN-LAST:event_JButtonSalirActionPerformed

    private void JButtonRegistrarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonRegistrarUsuarioActionPerformed
        // TODO add your handling code here:
        Start.ejecutar.subMenuRegistrar();
    }//GEN-LAST:event_JButtonRegistrarUsuarioActionPerformed

    private void JButtonReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonReportesActionPerformed
        // TODO add your handling code here:
        Start.ejecutar.subMenuReportes();
    }//GEN-LAST:event_JButtonReportesActionPerformed

    private void JButtonCargarParticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonCargarParticaActionPerformed
        // TODO add your handling code here:
        Start.ejecutar.subIniciarSeccion();
    }//GEN-LAST:event_JButtonCargarParticaActionPerformed

    private void JButtonJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonJugarActionPerformed
        // TODO add your handling code here:
        Start.ejecutar.subIniciarJuego();
    }//GEN-LAST:event_JButtonJugarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JButtonCargarPartica;
    private javax.swing.JButton JButtonJugar;
    private javax.swing.JButton JButtonRegistrarUsuario;
    private javax.swing.JButton JButtonReportes;
    private javax.swing.JButton JButtonSalir;
    private javax.swing.JLabel JLabelLogo;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
