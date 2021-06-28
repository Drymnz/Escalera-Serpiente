/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cunoc.escaleraserpiente.guardarPartidaCargar;

import com.cunoc.escaleraserpiente.casillasEspeciales.*;
import com.cunoc.escaleraserpiente.componentesJuego.Casilla;
import com.cunoc.escaleraserpiente.componentesJuego.Tablero;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author drymnz
 */
public class ManejoCargaPartida {

    private File archivo;
    private Tablero tableroFinal;
    private String analizar;
    private int fila, columna;
    private Casilla[][] casillas;
    private Casilla[] listado;
    private int[][] matrizGuia;

    public ManejoCargaPartida(File archivo, Tablero tableroFinal) {
        this.archivo = archivo;
        this.tableroFinal = tableroFinal;
        convertir();
    }

    public ManejoCargaPartida(File archivo) {
        this(archivo, null);
    }

    private void convertir() {
        String Linea = "";
        try {
            FileInputStream arvhivoleer = new FileInputStream(archivo);
            InputStreamReader leer = new InputStreamReader(arvhivoleer);
            BufferedReader almacenar = new BufferedReader(leer);
            while ((Linea = almacenar.readLine()) != null) {
                analizar += Linea + "\n";
            }
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException>>" + e.getLocalizedMessage());
        } catch (IOException a) {
            System.out.println("IOException>>" + a.getMessage());
        }
        anilizarText();
    }

    private void anilizarText() {
        String[] dividirPorLinea = analizar.split("\n");
        for (int i = 0; i < dividirPorLinea.length; i++) {
            palabrasClaves(dividirPorLinea[i]);
        }
        completarCasillas();
    }

    private void completarCasillas() {
        int contador = tableroFinal.getFila() * tableroFinal.getColumna();
        listado = new Casilla[contador];
        listado[listado.length - 1] = new Casilla((fila * columna), null, new Color(234, 190, 63));
        for (int i = 0; i < tableroFinal.getFila(); i++) {
            for (int j = 0; j < tableroFinal.getColumna(); j++) {
                if (casillas[i][j] == null) {
                    listado[contador] = new Casilla(contador, Color.green);
                } else {
                    listado[contador] = casillas[i][j];
                }
                contador--;
            }
        }
    }

    private void palabrasClaves(String verificar) {
        verificar = verificar.replaceAll("\\);", "");
        verificar = verificar.replaceAll("\\s", "");
        String[] ver = verificar.split("\\(");
        switch (ver[0]) {
            case "tablero":
                String[] numerotablero = ver[0].split(",");
                int fila = Integer.parseInt(numerotablero[0]);
                int columna = Integer.parseInt(numerotablero[1]);
                this.casillas = new Casilla[fila][columna];
                crearMatrizGuia(fila, columna);
                break;
            case "pierdeturno":
                String[] numeropierdeturno = ver[0].split(",");
                int filaNumeropierdeturno = Integer.parseInt(numeropierdeturno[0]);
                int columnaNumeropierdeturno = Integer.parseInt(numeropierdeturno[1]);
                this.casillas[filaNumeropierdeturno][columnaNumeropierdeturno] = new PierdeTurno(matrizGuia[filaNumeropierdeturno][columnaNumeropierdeturno]);
                break;
            case "tiradados":
                String[] numerotiradados = ver[0].split(",");
                int filanumerotiradados = Integer.parseInt(numerotiradados[0]);
                int columnanumerotiradados = Integer.parseInt(numerotiradados[1]);
                this.casillas[filanumerotiradados][columnanumerotiradados] = new NuevoTrueno(matrizGuia[filanumerotiradados][columnanumerotiradados]);
                break;
            case "avanza":
                String[] numeroavanza = ver[0].split(",");
                int filanumeroavanza = Integer.parseInt(numeroavanza[0]);
                int columnanumeroavanza = Integer.parseInt(numeroavanza[1]);
                int avancenumeroavanza = Integer.parseInt(numeroavanza[3]);
                this.casillas[filanumeroavanza][columnanumeroavanza] = new AvanzarMas(matrizGuia[filanumeroavanza][columnanumeroavanza], avancenumeroavanza);
                break;
            case "retrocede":
                String[] numeroretrocede = ver[0].split(",");
                int filanumeroretrocede = Integer.parseInt(numeroretrocede[0]);
                int columnanumeroretrocede = Integer.parseInt(numeroretrocede[1]);
                int avancenumeroretrocede = Integer.parseInt(numeroretrocede[3]);
                this.casillas[filanumeroretrocede][columnanumeroretrocede] = new RetrocederCasilla(matrizGuia[filanumeroretrocede][columnanumeroretrocede], avancenumeroretrocede);
                break;
            case "subida":
                String[] numerosubida = ver[0].split(",");
                int filanumerosubida = Integer.parseInt(numerosubida[0]);
                int columnanumerosubida = Integer.parseInt(numerosubida[1]);
                int filaDosnumerosubida = Integer.parseInt(numerosubida[3]);
                int columnaDosnumerosubida = Integer.parseInt(numerosubida[4]);
                this.casillas[filanumerosubida][columnanumerosubida] = new Escalera(matrizGuia[filanumerosubida][columnanumerosubida], this.casillas[filaDosnumerosubida][columnaDosnumerosubida]);
                break;
            case "bajada":
                String[] numerobajada = ver[0].split(",");
                int filanumerobajada = Integer.parseInt(numerobajada[0]);
                int columnanumerobajada = Integer.parseInt(numerobajada[1]);
                int filaDosnumerobajada = Integer.parseInt(numerobajada[3]);
                int columnaDosnumerobajada = Integer.parseInt(numerobajada[4]);
                this.casillas[filanumerobajada][columnanumerobajada] = new Serpiente(matrizGuia[filanumerobajada][columnanumerobajada], this.casillas[filaDosnumerobajada][columnaDosnumerobajada]);
                break;
        }
    }

    private void crearMatrizGuia(int fila, int columna) {
        int contador = fila * columna;
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                matrizGuia[i][j] = contador;
                contador--;
            }
        }
    }

    public Tablero getTerminado() {
        return new Tablero(listado, fila, columna, null, 0, Color.green, null);
    }
}
