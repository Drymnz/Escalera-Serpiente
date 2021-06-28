/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cunoc.escaleraserpiente.guardarPartidaCargar;

import com.cunoc.escaleraserpiente.Usuario.Usuario;
import com.cunoc.escaleraserpiente.componentesJuego.Tablero;

/**
 *
 * @author drymnz
 */
public class ManejoGuardarPartida implements Runnable {
    private Tablero tablero;
    private Usuario[] listado;

    public ManejoGuardarPartida(Tablero tablero, Usuario[] listado) {
        this.tablero = tablero;
        this.listado = listado;
    }
    

    @Override
    public void run() {
    }

}
