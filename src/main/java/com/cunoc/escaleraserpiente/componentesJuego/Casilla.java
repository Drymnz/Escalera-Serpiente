/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cunoc.escaleraserpiente.componentesJuego;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author drymnz
 */
public  class Casilla extends JPanel {

    private int id;
    private Ficha ficha;
    private Color color;

    // constructor
    public Casilla(int id, Ficha ficha, Color color) {
        this.id = id;
        this.ficha = ficha;
        this.color = color;
        this.setBackground(color);
    }

    public Casilla(int id, Color color) {
        this(id, null, color);
    }

    // fin constructor
    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, this.getWidth(), this.getHeight());
        if (ficha != null && ficha.getUsuario()!=null) {
            g.setColor(ficha.getColor());
            g.fillOval(0, 0, this.getWidth(), this.getHeight());
            g.setColor(Color.BLACK);
            try {
               g.drawString(ficha.getUsuario().getNombre(), this.getWidth() / 2, this.getHeight() / 2); 
            } catch (Exception e) {
            }
        } else {
            g.setColor(Color.BLACK);
            g.drawString(id + "", this.getWidth() / 2, this.getHeight() / 2);
        }
    }

    public int getId() {
        return id;
    }

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }

    public void setId(int id) {
        this.id = id;
    }

}
