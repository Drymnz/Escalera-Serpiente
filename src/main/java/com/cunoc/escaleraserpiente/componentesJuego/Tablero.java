/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cunoc.escaleraserpiente.componentesJuego;

import com.cunoc.escaleraserpiente.ManejadorArchivos.ManejoEscrituraLectura;
import com.cunoc.escaleraserpiente.Start;
import com.cunoc.escaleraserpiente.Usuario.Usuario;
import com.cunoc.escaleraserpiente.casillasEspeciales.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.io.File;
import javax.swing.JOptionPane;

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
    }

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

    public void cargar() {
        this.setLayout(new GridLayout(fila, columna));
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
        this.setLayout(new GridLayout(fila, columna));
        this.fila = fila;
        this.columna = columna;
        this.listado = new Casilla[columna * fila];

        listado[listado.length - 1] = new Casilla((fila * columna), null, new Color(234, 190, 63));// casilla victoria
        this.add(listado[listado.length - 1]);
        for (int i = (listado.length - 2); i >= 0; i--) {
            if (listado[i] == null) {
                listado[i] = asignarTipo(i + 1);
                this.add(listado[i]);
            } else {
                listado[i].setId((i + 1));
                this.add(listado[i]);
            }
        }
    }

    private Casilla asignarTipo(int id) {
        int aletorio = (int) (Math.random() * 100);
        Casilla asignarTipo = null;
        switch ((aletorio > 60) ? 1 : (aletorio > 50) ? 2 : (aletorio > 40) ? 3 : (aletorio > 30) ? 4 : (aletorio > 20) ? 5 : (aletorio > 10) ? 6 : 7) {
            case 1:// CASILLA SIMPLE 
                asignarTipo = new Casilla(id, casillasSimples);
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

            case 7:// CASILLA AvanzarMas 10
                asignarTipo = new AvanzarMas(id);
                break;
            case 2:// CASILLA SERPIENTE  10
                if (2 * columna < id) {
                    asignarTipo = new Serpiente(id);
                } else {
                    asignarTipo = new Casilla(id, casillasSimples);
                }
                break;
            case 6:// CASILLA Escalera 10
                if (id < ((fila * columna) - (2 * columna))) {
                    asignarTipo = new Escalera(id);
                } else {
                    asignarTipo = new Casilla(id, casillasSimples);
                }
                break;

        }
        return asignarTipo;
    }

    private void moverFicha() {
        if ((fichaEnMovimiento != null) && (fichaEnMovimiento.getUbicacion() != null) && (fichaEnMovimiento.getUbicacion().getId() < (fila * columna)) && (fichaEnMovimiento.getUbicacion().getId() > (-1))) {
            int mover = (pasosMoverFicha > 0) ? 1 : -1;
            if ((fichaEnMovimiento.getUbicacion().getId() - 1) + 1 > (fila * columna) && ((fichaEnMovimiento.getUbicacion().getId() - 1) + mover) < (fila * columna) && ((fichaEnMovimiento.getUbicacion().getId() - 1) + mover) > 0) {
                this.ganadorUsuario = fichaEnMovimiento.getUsuario();
                Start.ejecutar.irMenuPrincipal();
                for (int i = 0; i < listado.length; i++) {
                    if (listado[i].getFicha().getUsuario() == ganadorUsuario) {
                        listado[i].getFicha().getUsuario().setVictoria(listado[i].getFicha().getUsuario().getVictoria() + 1);
                    } else {
                        listado[i].getFicha().getUsuario().setPerdida(listado[i].getFicha().getUsuario().getPerdida() + 1);
                    }
                    listado[i].getFicha().getUsuario().setCantidadPartidad(listado[i].getFicha().getUsuario().getCantidadPartidad() + 1);
                    (new ManejoEscrituraLectura()).escribirArchivo(listado[i], new File(".Archivo/Usuario/" + listado[i].getId() + ".usuario"));
                }
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

    private void gano() {
        for (int i = 0; i < listado.length; i++) {
            if (listado[i].getFicha().getUsuario() == ganadorUsuario) {
                JOptionPane.showMessageDialog(null, "GAno>>>> "+ganadorUsuario.getId()+" Nombre >>>"+ganadorUsuario.getNombre());
                listado[i].getFicha().getUsuario().setVictoria(listado[i].getFicha().getUsuario().getVictoria() + 1);
            } else {
                listado[i].getFicha().getUsuario().setPerdida(listado[i].getFicha().getUsuario().getPerdida() + 1);
            }
            listado[i].getFicha().getUsuario().setCantidadPartidad(listado[i].getFicha().getUsuario().getCantidadPartidad() + 1);
            (new ManejoEscrituraLectura()).escribirArchivo(listado[i], new File(".Archivo/Usuario/" + listado[i].getId() + ".usuario"));
            Start.ejecutar.irMenuPrincipal();
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
            if (fichaEnMovimiento.getUbicacion() == null || (fichaEnMovimiento.getUbicacion() != null && fichaEnMovimiento.getUbicacion().getId() > 0 && fichaEnMovimiento.getUbicacion().getId() < ((fila * columna) + 1))) {
                moverFicha();
                if (fichaEnMovimiento.getUbicacion().getId() >= ((fila * columna))) {
                gano();
            }
            }
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
