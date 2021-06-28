/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cunoc.escaleraserpiente.componentesJuego;

import com.cunoc.escaleraserpiente.Usuario.Usuario;
import com.cunoc.escaleraserpiente.casillasEspeciales.*;
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
    public Tablero(Casilla[] listado, int fila, int columna, Ficha fichaEnMovimiento, int pasosMoverFicha, Color casillasSimples, Usuario ganadorUsuario) {
        this.listado = listado;
        this.fila = fila;
        this.columna = columna;
        this.fichaEnMovimiento = fichaEnMovimiento;
        this.pasosMoverFicha = pasosMoverFicha;
        this.casillasSimples = casillasSimples;
        this.ganadorUsuario = ganadorUsuario;
         initComponents();
        this.setLayout(new GridLayout(fila, columna));
        cargar();
    }

    public Tablero(int columna, int fila) {
        this.fila = fila;
        this.columna = columna;
        initComponents();
        this.setLayout(new GridLayout(fila, columna));
    }

    public Tablero() {
        this(0, 0);
        initComponents();
    }
    //final  Creates new form Tablero

    private void cargar(){
        for (int i = 0; i < listado.length; i++) {
            this.add(listado[i]);
        }
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        repaint();
    }

    public void botones(int columna, int fila) {
        this.fila = fila;
        this.columna = columna;
        this.listado = new Casilla[columna * fila];
        
        listado[listado.length - 1] = new Casilla((fila * columna), null, new Color(234, 190, 63));// casilla victoria
        this.add(listado[listado.length - 1]);
        for (int i = (listado.length - 2); i >= 0; i--) {
            listado[i] = asignarTipo(i + 1);
            this.add(listado[i]);
        }
    }

    private Casilla asignarTipo(int id) {
        int aletorio = (int) (Math.random() * 100);
        Casilla asignarTipo = null;
        switch ((aletorio > 60) ? 1 : (aletorio > 50) ? 2 : (aletorio > 40) ? 3 : (aletorio > 30) ? 4 : (aletorio > 20) ? 5 : (aletorio > 10) ? 6 : 7) {
            case 1:// CASILLA SIMPLE 
                asignarTipo = new Casilla(id, casillasSimples);
                break;
            case 2:// CASILLA SERPIENTE  10
                if (2 * columna < id) {
                    asignarTipo = new Serpiente(id);
                } else {
                    asignarTipo = new Casilla(id, casillasSimples);
                }
                break;
            case 3:// CASILLA RetrocederCasilla  10
                asignarTipo = new RetrocederCasilla(id);
                break;
            case 4:// CASILLA PierdeTurno 10
                asignarTipo = new PierdeTurno(id);
                break;
            case 5:// CASILLA NuevoTrueno 10
                asignarTipo = new NuevoTrueno(id);
                break;
            case 6:// CASILLA Escalera 10
                asignarTipo = new Escalera(id);
                break;
            case 7:// CASILLA AvanzarMas 10
                asignarTipo = new AvanzarMas(id);
                break;

        }
        return asignarTipo;
    }

    private Casilla buscarCasillaCola(int id) {
        int rando = (int) (Math.random() * fila) + 8;
        Casilla dar = null;
        do {
            rando = (int) (Math.random() * fila) + 8;
            if (rando >= 0 && rando < fila * columna) {
                for (int i = 0; i < listado.length; i++) {
                    if (listado[rando].getId() < id) {
                        return listado[i];
                    }
                }
            }
        } while (rando >= 0 && rando < fila * columna);
        return listado[0];
    }

    private void moverFicha() {
        if ((fichaEnMovimiento != null) && (fichaEnMovimiento.getUbicacion() != null) && (fichaEnMovimiento.getUbicacion().getId() > -1)) {
            int mover = (pasosMoverFicha > 0) ? 1 : -1;
            if ((fichaEnMovimiento.getUbicacion().getId() - 1) + 1 > (fila * columna)) {
                this.ganadorUsuario = fichaEnMovimiento.getUsuario();
            } else {
                if (fichaEnMovimiento.getUbicacion().getFicha() == fichaEnMovimiento) {
                    fichaEnMovimiento.getUbicacion().setFicha(null);
                }
                if (listado[(fichaEnMovimiento.getUbicacion().getId() - 1) + mover].getFicha() == null) {
                    listado[(fichaEnMovimiento.getUbicacion().getId() - 1) + mover].setFicha(fichaEnMovimiento);
                }
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

    public Usuario getGanadorUsuario() {
        return ganadorUsuario;
    }

    public void setFichaEnMovimiento(Ficha fichaEnMovimiento) {
        this.fichaEnMovimiento = fichaEnMovimiento;
    }

    public void setPasosMoverFicha(int pasosMoverFicha) {
        this.pasosMoverFicha = pasosMoverFicha;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public Casilla[] getListado() {
        return listado;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
