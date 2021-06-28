/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cunoc.escaleraserpiente.Cronometro;

import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author drymnz
 */
public class Cronometro extends JPanel implements Runnable {
    // private String tiempo = "hora:minuto:segundo";

    private int minuto ;
    private int segundo ;
    private int hora ;
    private boolean detener = false;

    // constructores 
    public Cronometro(int minuto, int segundo, int hora, boolean detener) {
        this.minuto = minuto;
        this.segundo = segundo;
        this.hora = hora;
        this.detener = detener;

    }

    public Cronometro() {
        this(0, 0, 0, false);
    }

    // fin constructores
    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        g.setFont(new Font("Time new Roman", Font.PLAIN, this.getHeight() / 3));
        g.drawString("HH: " + hora + " MM: " + minuto + " SS: " + segundo, 10, this.getHeight() - 10);
        repaint();
    }

    @Override
    public void run() {
        do {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
            hora = (minuto >= 60) ? (hora + 1) : hora + 0;
            minuto = (segundo >= 60) ? (minuto + 1) : (minuto + 0);
            minuto = (minuto >= 60) ? 0 :(minuto + 0);
            segundo = (segundo >= 60) ? 0 : segundo + 1;
        } while (!detener);
    }

}
