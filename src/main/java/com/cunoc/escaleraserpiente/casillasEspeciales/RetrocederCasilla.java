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
public class RetrocederCasilla extends Casilla {

    private int retroceder;

    public RetrocederCasilla(int id, Ficha ficha, Color color, int retroceder ) {
        super(id, ficha, color);
        this.retroceder = retroceder;
    }

    public RetrocederCasilla(int id) {
        this(id, null, Color.yellow,  (int)(Math.random()*10)+1);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        g.setColor(Color.RED);
        g.setFont(new Font("Time new Roman", Font.PLAIN, this.getHeight()));
        g.drawString(retroceder + "", 10, this.getHeight());
    }
}
