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
public class Escalera extends Casilla {

    private Escalera subir;

    public Escalera(int id, Ficha ficha, Color color, Escalera subir) {
        super(id, ficha, color);
        this.subir = subir;
    }

    public Escalera(int id,Escalera subir) {
        this(WIDTH, null,Color.WHITE, subir);
        this.subir = subir;
    }

    public Escalera(int id) {
        this(id, null, Color.WHITE, null);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        g.setColor(new Color(162, 127, 44));
        g.setFont(new Font("Time new Roman", Font.PLAIN, this.getHeight()));
        g.drawString("|--|", 10, this.getHeight());
    }

    public Escalera getSubir() {
        return subir;
    }

    public void setSubir(Escalera subir) {
        this.subir = subir;
    }
    
}
