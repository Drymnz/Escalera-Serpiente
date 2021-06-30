/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cunoc.escaleraserpiente.componentesJuego;

import com.cunoc.escaleraserpiente.Usuario.Usuario;
import com.cunoc.escaleraserpiente.casillasEspeciales.*;

/**
 *
 * @author drymnz
 */
public class ReglaJuegoSS {

    private String mencionar;
    private Ficha[] listado;
    private Ficha ver;
    private Tablero tablero;
    private int CantidadDeJugadores;
    private int turno;
    private Usuario[] penalizado;

    // constructor
    public ReglaJuegoSS(Usuario[] penalizado, String mencionar, Ficha[] listado, Ficha ver, Tablero tablero, int CantidadDeJugadores, int turno) {
        this.mencionar = mencionar;
        this.listado = listado;
        this.ver = ver;
        this.tablero = tablero;
        this.CantidadDeJugadores = CantidadDeJugadores;
        this.turno = turno;
        this.penalizado = penalizado;
    }

    public ReglaJuegoSS(Ficha[] listado, Tablero tablero, int CantidadDeJugadores, int turno) {
        this(new Usuario[listado.length], "", listado, null, tablero, CantidadDeJugadores, turno);
    }

    //fin constructor
    public void aplicarRegla(Ficha ficha) {
        ver = ficha;
        boolean repetriTruno = false;
        switch ((ficha.getUbicacion() instanceof Serpiente) ? 1 : (ficha.getUbicacion() instanceof RetrocederCasilla) ? 2 : (ficha.getUbicacion() instanceof PierdeTurno) ? 3 : (ficha.getUbicacion() instanceof NuevoTrueno) ? 4 : (ficha.getUbicacion() instanceof Escalera) ? 5 : (ficha.getUbicacion() instanceof AvanzarMas) ? 6 : 7) {
            case 1:// CASILLA SERPIENTE 
                Serpiente verSerpiente = (Serpiente) ficha.getUbicacion();
                if (verSerpiente.getCola() != null) {
                    int numero = verSerpiente.getCola().getId() - verSerpiente.getId();
                    System.out.println("verSerpiente.getCola().getId()>>>>"+verSerpiente.getCola().getId());
                    System.out.println("verSerpiente.getId()>>>>"+verSerpiente.getId());
                    tablero.setPasosMoverFicha(numero);
                    new Thread(tablero).start();
                    mencionar = ver.getUsuario().getNombre() + "regresaras a la cola";
                } else {
                    mencionar = ver.getUsuario().getNombre() + "solo es una cola";
                }
                break;
            case 2:// CASILLA RetrocederCasilla 
                RetrocederCasilla verRetrocederCasilla = (RetrocederCasilla) ficha.getUbicacion();
                tablero.setFichaEnMovimiento(ficha);
                tablero.setPasosMoverFicha((verRetrocederCasilla.getRetroceder()) * -1);
                mencionar = ver.getUsuario().getNombre() + " retrocera " + verRetrocederCasilla.getRetroceder();
                new Thread(tablero).start();
                break;
            case 3:// CASILLA PierdeTurno 
                agregarPenalizacion(ver.getUsuario());
                mencionar = ver.getUsuario().getNombre() + " perdera un turno";
                break;
            case 4:// CASILLA NuevoTrueno
                repetriTruno = true;
                mencionar = ver.getUsuario().getNombre() + " tirar nuevamente";
                break;
            case 5:// CASILLA Escalera
                Escalera verEscalera = (Escalera) ficha.getUbicacion();
                if (verEscalera.getSubir() != null) {
                    int numeroDos = verEscalera.getSubir().getId() - verEscalera.getId();
                    System.out.println("verEscalera.getSubir().getId()>>>>><"+verEscalera.getSubir().getId());
                    System.out.println("verEscalera.getId()"+verEscalera.getId());
                    System.out.println("numeroDos"+numeroDos);
                    tablero.setPasosMoverFicha(numeroDos);
                    new Thread(tablero).start();
                    mencionar = ver.getUsuario().getNombre() + "subira";
                } else {
                    mencionar = ver.getUsuario().getNombre() + "solo es la cima";
                }
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
        if (estapenalizado(listado[this.turno])) {
            turnoSiguiente();
        }
    }

    private void agregarPenalizacion(Usuario a) {
        for (int i = 0; i < penalizado.length; i++) {
            if (penalizado[i] == null) {
                penalizado[i] = a;
                i = penalizado.length;
            }
        }
    }

    private boolean estapenalizado(Ficha ver) {
        for (int i = 0; i < penalizado.length; i++) {
            if (penalizado[i] != null && penalizado[i] == ver.getUsuario()) {
                penalizado[i] = new Usuario(0, "asfd", "sdaf");
                penalizado[i] = null;
                return true;
            }
        }
        return false;
    }

    private void turnoSiguiente() {
        this.turno = ((this.turno + 1) >= CantidadDeJugadores) ? 0 : (this.turno + 1);
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
