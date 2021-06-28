/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cunoc.escaleraserpiente.guardarPartidaCargar;

import com.cunoc.escaleraserpiente.Usuario.Usuario;
import com.cunoc.escaleraserpiente.casillasEspeciales.*;
import com.cunoc.escaleraserpiente.componentesJuego.Casilla;
import com.cunoc.escaleraserpiente.componentesJuego.Tablero;

/**
 *
 * @author drymnz
 */
public class ManejoGuardarPartida implements Runnable {

    private Tablero tablero;
    private Usuario[] listado;
    private String escribir;

    public ManejoGuardarPartida(Tablero tablero, Usuario[] listado) {
        this.tablero = tablero;
        this.listado = listado;
    }

    private void escribirElTexot() {
        escribir += "tablero(" + tablero.getFila() + "," + tablero.getColumna() + ");\n";
        Casilla[] registrar = tablero.getListado();
        int indiceRegistrar = 0;
        for (int fila = 0; fila < tablero.getFila(); fila++) {
            for (int columna = 0; columna < tablero.getColumna(); columna++) {
                tipoCasilla(fila, columna, registrar[indiceRegistrar]);
                indiceRegistrar++;
            }
        }

    }

    private void tipoCasilla(int Fila, int Columna, Casilla casilla) {
        switch ((casilla instanceof Serpiente) ? 1 : (casilla instanceof RetrocederCasilla) ? 2 : (casilla instanceof PierdeTurno) ? 3 : (casilla instanceof NuevoTrueno) ? 4 : (casilla instanceof Escalera) ? 5 : (casilla instanceof AvanzarMas) ? 6 : 7) {
            case 1:// CASILLA SERPIENTE 
                Serpiente verSerpiente = (Serpiente) casilla;
                escribir += "bajada(" + Fila + "," + Columna + "," + 1 + ");\n";
                break;
            case 2:// CASILLA RetrocederCasilla 
                RetrocederCasilla verRetrocederCasilla = (RetrocederCasilla) casilla;
                escribir += "retrocede(" + Fila + "," + Columna + "," + verRetrocederCasilla.getRetroceder() + ");\n";
                break;
            case 3:// CASILLA PierdeTurno 
                escribir += "pierdeturno(" + Fila + "," + Columna + ");\n";
                break;
            case 4:// CASILLA NuevoTrueno
                escribir += "tiradados(" + Fila + "," + Columna + ");\n";
                break;
            case 5:// CASILLA Escalera
                Escalera verEscalera = (Escalera) casilla;
                escribir += "subida(" + Fila + "," + Columna + "," + 1 + ");\n";
                break;
            case 6:// CASILLA AvanzarMas
                AvanzarMas verAvanzarMas = (AvanzarMas) casilla;
                escribir += "avanza(" + Fila + "," + Columna + "," + verAvanzarMas.getAvanzar() + ");\n";
                break;
            case 7:// CASILLA SIMPLE
                break;

        }
    }

    @Override
    public void run() {

    }

}
