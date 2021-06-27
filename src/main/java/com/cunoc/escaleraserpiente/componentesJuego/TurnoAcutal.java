/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cunoc.escaleraserpiente.componentesJuego;

import com.cunoc.escaleraserpiente.Usuario.Usuario;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author drymnz
 */
public class TurnoAcutal extends JPanel {

    private Usuario usuario;
    private Ficha ficha;
    private Dado dado;

    public TurnoAcutal() {
        this.setBackground(Color.WHITE);
    }

    public void turnoDe(Ficha ficha) {
        this.ficha = ficha;
        this.usuario = ficha.getUsuario();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        if (usuario != null) {
            g.setColor(Color.BLACK);
            g.drawString("Turno de : " + usuario.getNombre() + " " + usuario.getApellido(), 0, 10);
            g.setColor(ficha.getColor());
            g.fillOval(10, 20, 50, 50);
            g.setFont(new Font("Time new Roman", Font.PLAIN, 20));
            if (dado.isDisponible()) {
                g.setColor(new Color(66,236,39));
            } else {
                g.setColor(Color.RED);
            }
            g.drawString("lanzar", 70, 50);
        }
    }

    public void setDado(Dado dado) {
        this.dado = dado;
    }
}
