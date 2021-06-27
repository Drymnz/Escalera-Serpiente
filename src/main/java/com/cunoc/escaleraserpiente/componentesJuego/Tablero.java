/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cunoc.escaleraserpiente.componentesJuego;

import com.cunoc.escaleraserpiente.Usuario.Usuario;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;

/**
 *
 * @author drymnz
 */
public class Tablero extends javax.swing.JPanel implements Runnable {

    private Casilla[] listado;
    private int fila, columna;
    private Ficha fichaEnMovimiento;
    private int pasosMoverFicha;
    private Color casillasSimples;
    private Usuario ganadorUsuario;

    /**
     * Creates new form Tablero
     */
    public Tablero(int columna, int fila) {
        this.fila = fila;
        this.columna = columna;
        initComponents();
    }

    public Tablero() {
        this(0, 0);
        initComponents();
    }
    //final  Creates new form Tablero

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        repaint();
    }

    public void botones(int columna, int fila) {
        this.fila = fila;
        this.columna = columna;
        this.listado = new Casilla[columna * fila];
        this.setLayout(new GridLayout(fila, columna));
        for (int i = (listado.length - 1); i >= 0; i--) {
            listado[i] = new Casilla(i + 1, casillasSimples);
            this.add(listado[i]);
        }
    }

    private void moverFicha() {
        if ((fichaEnMovimiento != null) && (fichaEnMovimiento.getUbicacion() != null)) {
            int mover = (pasosMoverFicha > 0) ? 1 : -1;
            if ((fichaEnMovimiento.getUbicacion().getId() - 1) + 1 > (fila * columna)) {
                ganadorUsuario = fichaEnMovimiento.getUsuario();
            } else {
                fichaEnMovimiento.getUbicacion().setFicha(null);
                listado[(fichaEnMovimiento.getUbicacion().getId() - 1) + mover].setFicha(fichaEnMovimiento);
                fichaEnMovimiento.setUbicacion(listado[(fichaEnMovimiento.getUbicacion().getId() - 1) + mover]);
            }
        } else {
            fichaEnMovimiento.setUbicacion(listado[0]);
            listado[0].setFicha(fichaEnMovimiento);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(49, 127, 34));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 606, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 421, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void run() {
        for (int i = pasosMoverFicha; ((pasosMoverFicha > 0) ? (i < (pasosMoverFicha + pasosMoverFicha)) : (i < 0)); i++) {
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
            moverFicha();
        }
    }

    public void setFichaEnMovimiento(Ficha fichaEnMovimiento) {
        this.fichaEnMovimiento = fichaEnMovimiento;
    }

    public void setPasosMoverFicha(int pasosMoverFicha) {
        this.pasosMoverFicha = pasosMoverFicha;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
