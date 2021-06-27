/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cunoc.escaleraserpiente.casillasEspeciales;

import com.cunoc.escaleraserpiente.componentesJuego.Casilla;
import com.cunoc.escaleraserpiente.componentesJuego.Ficha;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 *
 * @author drymnz
 */
public class AvanzarMas extends Casilla {
    private int avanzar;

    public AvanzarMas(int id, Ficha ficha, Color color,int avanza) {
        super(id, ficha, color);
        this.avanzar = avanza;
    }

    public AvanzarMas(int id) {
        this(id, null, Color.CYAN, (int)(Math.random()*10)+1);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        g.setColor(new Color(27,235,62));
        g.setFont(new Font("Time new Roman", Font.PLAIN, this.getHeight()));
        g.drawString(avanzar+"", 10, this.getHeight());
    }

}
