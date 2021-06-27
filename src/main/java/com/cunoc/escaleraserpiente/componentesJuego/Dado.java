/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cunoc.escaleraserpiente.componentesJuego;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author drymnz
 */
public class Dado extends JPanel implements Runnable {

    private int limiteMaximo;
    private int limiteMinimo;
    private int numeroSalio;
    private Color color;
    private boolean disponible;
    // constructor

    public Dado(int limiteMaximo, int limiteMinimo, int numeroSalio, Color color, boolean disponible) {
        this.limiteMaximo = limiteMaximo;
        this.limiteMinimo = limiteMinimo;
        this.numeroSalio = numeroSalio;
        this.disponible = disponible;
        this.color = color;
    }

    public Dado() {
        this(6, 1, 0, Color.white, true);
    }
    //fin constructor

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, this.getWidth(), this.getHeight());
        g.setFont(new Font("Time new Roman", Font.PLAIN, this.getHeight()));
        g.drawString(numeroSalio + "<", 10, this.getHeight() - 10);
    }

    @Override
    public void run() {
        int numeroAleatorio = (int) (Math.random() * 10 + 10);
        int fuerza = (int) (Math.random() * 100 + 10);
        disponible = false;
        do {
            for (int i = 0; i < numeroAleatorio; i++) {
                int numeroAletorioDos = (int) (Math.random() * limiteMaximo);
                if (numeroAletorioDos > limiteMinimo && numeroAletorioDos < limiteMaximo) {
                    this.numeroSalio = numeroAletorioDos;
                } else {
                    this.numeroSalio = limiteMaximo;
                }
            }
            fuerza--;
            try {
                Thread.sleep(1000 / fuerza);
            } catch (Exception e) {
            }
        } while (fuerza > 0);
        disponible = true;
    }

    public void setNumeroSalio(int numeroSalio) {
        this.numeroSalio = numeroSalio;
    }

    public int getNumeroSalio() {
        return numeroSalio;
    }

    public boolean isDisponible() {
        return disponible;
    }

}
