/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cunoc.escaleraserpiente.componentesJuego;

import com.cunoc.escaleraserpiente.Usuario.Usuario;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author drymnz
 */
public class PantallaDelJuego extends javax.swing.JPanel implements Runnable {

    private Usuario[] listado;
    private Ficha[] listadoFichas;
    private int CantidadDeJugadores;
    private int turno = 0;

    /**
     * Creates new form PantallaDelJuego
     */
    public PantallaDelJuego(int fila, int columna, Usuario[] listado, int CantidadDeJugadores) {
        initComponents();
        this.CantidadDeJugadores = CantidadDeJugadores;
        tablero1.botones(fila, columna);
        jugadores(listado);
        turnoAcutal.setDado(dado);
        new Thread(cronometro1).start();
    }

    private void jugadores(Usuario[] Revisar) {
        if (Revisar != null) {
            listado = new Usuario[CantidadDeJugadores];
            for (int i = 0; i < Revisar.length; i++) {
                if (Revisar[i] != null) {

                    listado[i] = Revisar[i];
                }
            }
            asignarTurnos();
        }
    }

    private void asignarTurnos() {
        if (listado != null) {
            int mazar = 10;
            do {
                int mover = (int) (Math.random() * listado.length - 1);
                int con = (int) (Math.random() * listado.length - 1);
                Usuario auxiliar = listado[mover];
                listado[mover] = listado[con];
                listado[con] = auxiliar;
                mazar--;
            } while (mazar == 0);
            asignarFichas();
        }

    }

    private void asignarFichas() {
        if (listado != null) {
            listadoFichas = new Ficha[listado.length];
            for (int i = 0; i < listado.length; i++) {
                listadoFichas[i] = new Ficha(colorAleatorio(), listado[i], null);
            }
        }
        turnoAcutal.turnoDe(listadoFichas[0]);
        mostrarListadoJugadores();
    }

    private void mostrarListadoJugadores() {
        DefaultTableModel modificar = (DefaultTableModel) JTableLIstadoJugadores.getModel();
        for (int i = 0; i < listado.length; i++) {
            if (listado[i] != null) {
                modificar.addRow(new Object[]{listado[i].getId(), listado[i].getNombre(), listado[i].getApellido()});
            }
        }
    }

    private Color colorAleatorio() {
        int numero = (int) (Math.random() * 5);
        return (numero == 0) ? Color.BLUE : (numero == 1) ? Color.CYAN : (numero == 2) ? Color.DARK_GRAY : (numero == 3) ? Color.GRAY : Color.LIGHT_GRAY;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tablero1 = new com.cunoc.escaleraserpiente.componentesJuego.Tablero();
        jPanel1 = new javax.swing.JPanel();
        dado = new com.cunoc.escaleraserpiente.componentesJuego.Dado();
        JButtonLanzar = new javax.swing.JButton();
        turnoAcutal = new com.cunoc.escaleraserpiente.componentesJuego.TurnoAcutal();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTableLIstadoJugadores = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cronometro1 = new com.cunoc.escaleraserpiente.Cronometro.Cronometro();

        javax.swing.GroupLayout tablero1Layout = new javax.swing.GroupLayout(tablero1);
        tablero1.setLayout(tablero1Layout);
        tablero1Layout.setHorizontalGroup(
            tablero1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1002, Short.MAX_VALUE)
        );
        tablero1Layout.setVerticalGroup(
            tablero1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 696, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(177, 193, 118));

        javax.swing.GroupLayout dadoLayout = new javax.swing.GroupLayout(dado);
        dado.setLayout(dadoLayout);
        dadoLayout.setHorizontalGroup(
            dadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        dadoLayout.setVerticalGroup(
            dadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        JButtonLanzar.setText("Lanzar");
        JButtonLanzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonLanzarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout turnoAcutalLayout = new javax.swing.GroupLayout(turnoAcutal);
        turnoAcutal.setLayout(turnoAcutalLayout);
        turnoAcutalLayout.setHorizontalGroup(
            turnoAcutalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        turnoAcutalLayout.setVerticalGroup(
            turnoAcutalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 76, Short.MAX_VALUE)
        );

        JTableLIstadoJugadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Apellido"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(JTableLIstadoJugadores);

        jLabel1.setText("Listado de jugadores.");

        jLabel2.setText("Este es el dado :");

        javax.swing.GroupLayout cronometro1Layout = new javax.swing.GroupLayout(cronometro1);
        cronometro1.setLayout(cronometro1Layout);
        cronometro1Layout.setHorizontalGroup(
            cronometro1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        cronometro1Layout.setVerticalGroup(
            cronometro1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 64, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(turnoAcutal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(dado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(JButtonLanzar))
                            .addComponent(jLabel2))
                        .addGap(0, 38, Short.MAX_VALUE))
                    .addComponent(cronometro1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cronometro1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(turnoAcutal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(dado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(JButtonLanzar)
                        .addGap(40, 40, 40))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tablero1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tablero1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void JButtonLanzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonLanzarActionPerformed
        // TODO add your handling code here:
        if (dado.isDisponible()) {
            new Thread(this).start();
        } else {
            JOptionPane.showMessageDialog(null, "Por favor espere que acabe el dado");
        }
    }//GEN-LAST:event_JButtonLanzarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JButtonLanzar;
    private javax.swing.JTable JTableLIstadoJugadores;
    private com.cunoc.escaleraserpiente.Cronometro.Cronometro cronometro1;
    private com.cunoc.escaleraserpiente.componentesJuego.Dado dado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.cunoc.escaleraserpiente.componentesJuego.Tablero tablero1;
    private com.cunoc.escaleraserpiente.componentesJuego.TurnoAcutal turnoAcutal;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        new Thread(dado).start();
        do {
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
        } while (!dado.isDisponible());
        int pasos = dado.getNumeroSalio();
        tablero1.setFichaEnMovimiento(listadoFichas[turno]);
        tablero1.setPasosMoverFicha(pasos);
        turno = ((turno + 1) >= CantidadDeJugadores) ? 0 : (turno + 1);
        Thread p = new Thread(tablero1);
        p.start();
        while (p.isAlive()) {
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
        }
        // aqui verificar si caso en una casillla en vanzar o retorceder ************************
        dado.setNumeroSalio(pasos);
        turnoAcutal.turnoDe(listadoFichas[turno]);
    }

}
