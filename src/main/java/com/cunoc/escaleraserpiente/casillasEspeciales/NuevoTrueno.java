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
public class NuevoTrueno extends Casilla{
    
    public NuevoTrueno(int id, Ficha ficha, Color color) {
        super(id, ficha, color);
    }
    public NuevoTrueno(int id) {
        super(id, null, (new Color(30, 223, 49)));
    }
 @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        g.setColor(Color.BLACK);
        g.setFont(new Font("Time new Roman", Font.PLAIN, this.getHeight()/3));
        g.drawString("Turno++", 10, this.getHeight());
    }
}
