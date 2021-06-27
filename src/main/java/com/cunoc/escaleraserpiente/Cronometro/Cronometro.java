/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cunoc.escaleraserpiente.Cronometro;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author drymnz
 */
public class Cronometro extends JPanel implements Runnable{
    private String tiempo = "00:00:00";
    
    // constructores 

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        
    }

    @Override
    public void run() {
    }
    
}
