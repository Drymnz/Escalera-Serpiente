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
        this.removeAll();
        this.setLayout(new GridLayout(fila, columna));
        int inicar = fila * columna;
        inicar--;
        for (int i = inicar; i != -1; i--) {
            this.add(listado[i]);
        }
        repaint();
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
        switch ((aletorio > 60) ? 1 : (aletorio > 50) ? 2 : (aletorio > 40) ? 3 : (aletorio > 35) ? 4 : (aletorio > 20) ? 5 : (aletorio > 10) ? 6 : 7) {
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
                if ((id > columna * 2)) {
                    asignarTipo = new Serpiente(id, (Serpiente) bajadaSubidad(id, false));
                } else {
                    asignarTipo = new Casilla(id, casillasSimples);
                }
                break;
            case 6:// CASILLA Escalera 10
                if (id < ((fila * columna) - (2 * columna))) {
                    asignarTipo = new Escalera(id, (Escalera) bajadaSubidad(id, true));
                } else {
                    asignarTipo = new Casilla(id, casillasSimples);
                }
                break;

        }
        return asignarTipo;
    }

    private Casilla bajadaSubidad(int id, boolean subidaBajadaid) {
        int multiplicador = (int) (Math.random() * (fila - 1)) + 1;
        int nuevoId = (subidaBajadaid) ? (id + (8 * multiplicador)) : id - (8 * multiplicador);
        while (nuevoId > (fila * columna) || nuevoId < 0) {
            multiplicador = (int) (Math.random() * (fila - 1)) + 1;
            nuevoId = (subidaBajadaid) ? (id + (8 * multiplicador)) : id - (8 * multiplicador);
        }
        Casilla subidaBajada = (subidaBajadaid) ? new Escalera(nuevoId) : new Serpiente(nuevoId);
        listado[nuevoId - 1] = subidaBajada;
        return listado[nuevoId - 1];
    }

    private void moverFicha() {
        if (fichaEnMovimiento != null && fichaEnMovimiento.getUbicacion() != null) {
            Casilla ubicacionAcutalDeLaFicha = fichaEnMovimiento.getUbicacion();
            if (ubicacionAcutalDeLaFicha.getId() >= fila * columna) {
                gano();
            } else {
                int asiaDondeSeVaMover = (pasosMoverFicha > 0) ? 1 : -1;
                int idAcutalDeLaFicha = ubicacionAcutalDeLaFicha.getId();
                int resutlado = idAcutalDeLaFicha + asiaDondeSeVaMover - 1;
                if (resutlado > 0) {
                    fichaEnMovimiento.setUbicacion(listado[resutlado]);
                    listado[resutlado].setFicha(fichaEnMovimiento);
                    ubicacionAcutalDeLaFicha.setFicha(null);
                } else {
                    fichaEnMovimiento.setUbicacion(listado[0]);
                    listado[0].setFicha(fichaEnMovimiento);
                }
            }
        } else {
            fichaEnMovimiento.setUbicacion(listado[0]);
            listado[0].setFicha(fichaEnMovimiento);
        }
    }

    private void gano() {
        for (int i = 0; i < listado.length; i++) {
            if (listado[i].getFicha().getUsuario() == ganadorUsuario) {
                JOptionPane.showMessageDialog(null, "GANO>>>> " + ganadorUsuario.getId() + " Nombre >>>" + ganadorUsuario.getNombre());
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
            moverFicha();
            if (fichaEnMovimiento.getUbicacion().getId() >= ((fila * columna))) {
                gano();
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
