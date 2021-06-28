/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cunoc.escaleraserpiente.componentesJuego;

import com.cunoc.escaleraserpiente.casillasEspeciales.*;

/**
 *
 * @author drymnz
 */
public class ReglaJuegoSS {

    private String mencionar;
    private Ficha[] pierdeTurno;
    private Ficha[] listado;
    private Ficha ver;
    private Tablero tablero;
    private int CantidadDeJugadores;
    private int turno;
    private int contadorPierdeTurno = 0;

    // constructor
    public ReglaJuegoSS(String mencionar, Ficha[] pierdeTurno, Ficha[] listado, Ficha ver, Tablero tablero, int CantidadDeJugadores, int turno) {
        this.mencionar = mencionar;
        this.pierdeTurno = pierdeTurno;
        this.listado = listado;
        this.ver = ver;
        this.tablero = tablero;
        this.CantidadDeJugadores = CantidadDeJugadores;
        this.turno = turno;
    }

    public ReglaJuegoSS(Ficha[] pierdeTurno, Ficha[] listado, Tablero tablero, int CantidadDeJugadores, int turno) {
        this("", new Ficha[CantidadDeJugadores + 1], listado, null, tablero, CantidadDeJugadores, turno);
    }

    //fin constructor
    public void aplicarRegla(Ficha ficha) {
        ver = ficha;
        boolean repetriTruno = false;
        switch ((ficha.getUbicacion() instanceof Serpiente) ? 1 : (ficha.getUbicacion() instanceof RetrocederCasilla) ? 2 : (ficha.getUbicacion() instanceof PierdeTurno) ? 3 : (ficha.getUbicacion() instanceof NuevoTrueno) ? 4 : (ficha.getUbicacion() instanceof Escalera) ? 5 : (ficha.getUbicacion() instanceof AvanzarMas) ? 6 : 7) {
            case 1:// CASILLA SERPIENTE 
                mencionar = ver.getUsuario().getNombre() + " bajara a la cola de la serpiente";
                break;
            case 2:// CASILLA RetrocederCasilla 
                RetrocederCasilla verRetrocederCasilla = (RetrocederCasilla) ficha.getUbicacion();
                tablero.setFichaEnMovimiento(ficha);
                tablero.setPasosMoverFicha((verRetrocederCasilla.getRetroceder()) * -1);
                mencionar = ver.getUsuario().getNombre() + " retrocera " + verRetrocederCasilla.getRetroceder();
                new Thread(tablero).start();
                break;
            case 3:// CASILLA PierdeTurno 
                agregarTurnoPerdido();
                mencionar = ver.getUsuario().getNombre() + " perdera un turno";
                break;
            case 4:// CASILLA NuevoTrueno
                repetriTruno = true;
                mencionar = ver.getUsuario().getNombre() + " tirar nuevamente";
                break;
            case 5:// CASILLA Escalera
                mencionar = ver.getUsuario().getNombre() + " subira";
                break;
            case 6:// CASILLA AvanzarMas
                AvanzarMas verAvanzarMas = (AvanzarMas) ficha.getUbicacion();
                tablero.setPasosMoverFicha(verAvanzarMas.getAvanzar());
                mencionar = ver.getUsuario().getNombre() + " avanzara " + verAvanzarMas.getAvanzar();
                new Thread(tablero).start();
                break;
            case 7:// CASILLA SIMPLE
                mencionar = ver.getUsuario().getNombre() + " solo avanzo";
                break;

        }
        if (!repetriTruno) {
            turnoSiguiente();
        }

    }

    private void agregarTurnoPerdido() {
        for (int i = 0; i < pierdeTurno.length; i++) {
            if (pierdeTurno[i] == null) {
                pierdeTurno[i] = ver;
                System.out.println("pierdeTurno[i]" + pierdeTurno[i].getUsuario().getNombre());
                i = pierdeTurno.length;
            }
        }
    }

    public void turnoSiguiente() {
        this.turno = ((this.turno + 1) >= CantidadDeJugadores) ? 0 : (this.turno + 1);
        for (int i = 0; i < pierdeTurno.length; i++) {
            if (pierdeTurno[i] != null && listado[turno] == pierdeTurno[i]) {
                listado[i] = null;
                this.turno = ((this.turno + 1) >= CantidadDeJugadores) ? 0 : (this.turno + 1);
                System.out.println("ya complio su codena");
            }
        }
    }

    public void setCantidadDeJugadores(int CantidadDeJugadores) {
        this.CantidadDeJugadores = CantidadDeJugadores;
    }

    public int getTurno() {
        return turno;
    }

    public String getMencionar() {
        return mencionar;
    }

}
