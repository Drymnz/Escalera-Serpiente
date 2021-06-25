/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cunoc.escaleraserpiente.interfas;

import com.cunoc.escaleraserpiente.ManejadorArchivos.ManejoCarga;
import com.cunoc.escaleraserpiente.Usuario.MenuReporte;
import com.cunoc.escaleraserpiente.Usuario.Registrar;
import com.cunoc.escaleraserpiente.componentesJuego.PantallaDelJuego;
import java.awt.CardLayout;
import java.io.File;
import javax.swing.SwingUtilities;

/**
 *
 * @author drymnz
 */
public class Ventana extends javax.swing.JFrame {

    private CardLayout carpeta;
    // instancias de las sub menus
    private MenuPrincipal menuPrincipal = new MenuPrincipal();
    private MenuJuego menuJuegar = new MenuJuego();
    private IniciarSeccion cargarPartida = new IniciarSeccion();
    private Registrar RegistrarUsuario;
    private MenuReporte menuRerpote = new MenuReporte();
    private PantallaDelJuego juego = new PantallaDelJuego();

    //fin  instancias de las sub menus
    /**
     * Creates new form Ventana
     */
    public Ventana() {
        RegistrarUsuario = new Registrar((new ManejoCarga()).contadorArchivo(new File(".Archivo/Usuario"), ".usuario"));
        initComponents();
        subVentanas();
    }

    // para el uso de los botones, metodos para cambiar de ventana
    private void subVentanas() {
        carpeta = (CardLayout) JPanelBase.getLayout();
        JPanelBase.add(menuPrincipal, "MenuPrincipal");
        JPanelBase.add(menuJuegar, "subIniciarJuego");
        JPanelBase.add(cargarPartida, "CargarPartidad");
        JPanelBase.add(RegistrarUsuario, "RegistrarUsuario");
        JPanelBase.add(menuRerpote, "Reportes");
        JPanelBase.add(juego, "Jugar");
    }

    public void irMenuPrincipal() {
        this.setSize(400, 620);
        carpeta.show(JPanelBase, "MenuPrincipal");
        SwingUtilities.updateComponentTreeUI(this);
        this.repaint();
    }

    public void subIniciarJuego() {
        menuJuegar.cargarUsuarios(RegistrarUsuario.getContador());
        carpeta.show(JPanelBase, "subIniciarJuego");
        SwingUtilities.updateComponentTreeUI(this);
        this.repaint();
    }

    public void subIniciarSeccion() {
        carpeta.show(JPanelBase, "CargarPartidad");
        SwingUtilities.updateComponentTreeUI(this);
        this.repaint();
    }

    public void subMenuRegistrar() {
        //menuRerpote
        carpeta.show(JPanelBase, "RegistrarUsuario");
        SwingUtilities.updateComponentTreeUI(this);
        this.repaint();
    }

    public void subMenuReportes() {
        menuRerpote.cargarListadoUsuario(RegistrarUsuario.getContador());
        carpeta.show(JPanelBase, "Reportes");
        SwingUtilities.updateComponentTreeUI(this);
        this.repaint();
    }
    //fin metodos para cambiar de ventana
    // para iniciar le juego
    public void jugar() {
        this.setSize(1280, 720);
        carpeta.show(JPanelBase, "Jugar");
        SwingUtilities.updateComponentTreeUI(this);
        this.repaint();
    }
    // fin juego

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPanelBase = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Juego Serpiente y Escalera\n");
        setSize(new java.awt.Dimension(400, 620));

        JPanelBase.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPanelBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPanelBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanelBase;
    // End of variables declaration//GEN-END:variables
}
