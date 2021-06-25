/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cunoc.escaleraserpiente.ManejadorArchivos;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author drymnz
 */
public class ManejoCarga {

    // fele carpetas
    private File carpetaAlmacen = new File(".Archivo");
    private File carpetaUsuario = new File(".Archivo/Usuario");
    private File carpetaPartidad = new File(".Archivo/Partida");

    // fin carpetas
    //  Constructor 
    public ManejoCarga() {
    }

    // fin de constructor
    // verificar que las carpetas esten
    public void verificarCarpetasNesesarias() {
        verificadorCarpeta(carpetaAlmacen);
        verificadorCarpeta(carpetaUsuario);
        verificadorCarpeta(carpetaPartidad);
    }

    public void verificadorCarpeta(File Carpeta) {
        if (Carpeta.exists()) {
            System.out.println("Existe la carpete >>>" + Carpeta.getName());
        } else {
            if (Carpeta.mkdir()) {
                System.out.println("Fue creado la  >>>" + Carpeta.getName());
            } else {
                System.out.println("No se puede crear la carpeta");
            }
        }
    }

    // contador de cuantos archivos hay en una carpeta
    public int contadorArchivo(File carpeta,String extencion) {
        String nombres = "";
        try (DirectoryStream<Path> dp = Files.newDirectoryStream(Paths.get(carpeta.getAbsolutePath()))) {
            for (Path ruta : dp) {
                nombres += ruta.getFileName();
            }
        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
        }
        nombres = nombres.replaceAll("\\s+", "");
        nombres = nombres.replaceAll("\n+", "");
        if (nombres.trim().equals("")) {
            return 0;
        } else {
            String[] contador = nombres.split(extencion);
            return contador.length;
        }
    }

    //fin contador de cuantos archivos hay en una carpeta
    // get 
    public File getCarpetaAlmacen() {
        return carpetaAlmacen;
    }

    public File getCarpetaUsuario() {
        return carpetaUsuario;
    }

    public File getCarpetaPartidad() {
        return carpetaPartidad;
    }
    // fin get

}
