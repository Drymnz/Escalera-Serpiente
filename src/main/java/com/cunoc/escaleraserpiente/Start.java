package com.cunoc.escaleraserpiente;

import com.cunoc.escaleraserpiente.ManejadorArchivos.ManejoCarga;
import com.cunoc.escaleraserpiente.interfas.Ventana;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author drymnz
 */
public class Start {

    public static final Ventana ejecutar = new Ventana();

    public static void main(String[] args) {
        (new ManejoCarga()).verificarCarpetasNesesarias();
        ejecutar.setSize(338, 620);
        ejecutar.setResizable(false);
        ejecutar.setVisible(true);
        ejecutar.setLocationRelativeTo(null);
    }
}
