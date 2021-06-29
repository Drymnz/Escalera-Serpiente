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

    private Casilla subir;

    public Escalera(int id, Ficha ficha, Color color, Casilla subir) {
        super(id, ficha, color);
        this.subir = subir;
    }

    public Escalera(int id,Casilla subir) {
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

    public Casilla getSubir() {
        return subir;
    }

    public void setSubir(Casilla subir) {
        this.subir = subir;
    }
    
}
