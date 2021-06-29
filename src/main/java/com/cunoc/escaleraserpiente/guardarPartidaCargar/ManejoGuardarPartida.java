/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cunoc.escaleraserpiente.guardarPartidaCargar;

import com.cunoc.escaleraserpiente.ManejadorArchivos.ManejoEscrituraLectura;
import com.cunoc.escaleraserpiente.Usuario.Usuario;
import com.cunoc.escaleraserpiente.casillasEspeciales.*;
import com.cunoc.escaleraserpiente.componentesJuego.Casilla;
import com.cunoc.escaleraserpiente.componentesJuego.Tablero;
import java.io.File;

/**
 *
 * @author drymnz
 */
public class ManejoGuardarPartida implements Runnable {

    private Tablero tablero;
    private Usuario[] listado;
    private int[][] matrizGuia;
    private String escribir="\n";

    public ManejoGuardarPartida(Tablero tablero, Usuario[] listado) {
        this.tablero = tablero;
        this.listado = listado;
        crearMatrizGuia(tablero.getFila(), tablero.getColumna());
        escribirUsuario();
    }
    private void escribirUsuario(){
        for (int i = 0; i < listado.length; i++) {
            escribir += "Usuario "+listado[i].getId()+".usuario\n";
        }
    }

    private void crearMatrizGuia(int fila, int columna) {
        matrizGuia = new int[fila][columna];
        int contador = fila * columna;
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                matrizGuia[i][j] = contador;
                contador--;
            }
        }
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
        try {
            switch ((casilla instanceof Serpiente) ? 1 : (casilla instanceof RetrocederCasilla) ? 2 : (casilla instanceof PierdeTurno) ? 3 : (casilla instanceof NuevoTrueno) ? 4 : (casilla instanceof Escalera) ? 5 : (casilla instanceof AvanzarMas) ? 6 : 7) {
                case 1:// CASILLA SERPIENTE 
                    Serpiente verSerpiente = (Serpiente) casilla;
                    escribir += "bajada(" + Fila + "," + Columna + "," + filaColumna(verSerpiente.getCola().getId(), true) +","+filaColumna(verSerpiente.getCola().getId(), false)+ ");\n";
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
                    escribir += "subida(" + Fila + "," + Columna + "," + filaColumna(verEscalera.getSubir().getId(), true) +","+filaColumna(verEscalera.getSubir().getId(), false)+ ");\n";
                    break;
                case 6:// CASILLA AvanzarMas
                    AvanzarMas verAvanzarMas = (AvanzarMas) casilla;
                    escribir += "avanza(" + Fila + "," + Columna + "," + verAvanzarMas.getAvanzar() + ");\n";
                    break;
                case 7:// CASILLA SIMPLE
                    break;

            }
        } catch (Exception e) {
        }
    }

    private int filaColumna(int id, boolean filaColumna) {
        for (int fila = 0; fila < tablero.getFila(); fila++) {
            for (int columna = 0; columna < tablero.getColumna(); columna++) {
                if (matrizGuia[fila][columna] == id) {
                    if (filaColumna) {
                        return fila;
                    } else {
                        return columna;
                    }
                }

            }
        }
        return 0;
    }

    @Override
    public void run() {
        escribirElTexot();
        new ManejoEscrituraLectura().escribirArchivoTexto(escribir, new File(".Archivo/Partida/Tablero.txt"));
    }

}
