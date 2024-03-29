/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cunoc.escaleraserpiente.ManejadorArchivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

/**
 *
 * @author drymnz
 */
public class ManejoEscrituraLectura {

    public <T> void escribirArchivo(T aguardar, File donde) {
        try {
            FileOutputStream cual = new FileOutputStream(donde.getAbsolutePath());
            ObjectOutputStream colocar = new ObjectOutputStream(cual);
            colocar.writeObject(aguardar);
            colocar.close();
            System.out.println("Se aguardo " + donde.toString());
        } catch (IOException e) {
            System.out.println("Error >>" + e.toString());
            System.out.println("fue " + e.getMessage());
        }
    }

    public Object lecturarArchivoBinario(File donde) {
        Object retunar = null;
        File prueva = donde;
        try {
            if (prueva.length() != 0) {// leer si el archivo contine algo
                InputStream mirar = new FileInputStream(donde);
                ObjectInputStream colocalo = new ObjectInputStream(mirar);
                retunar = colocalo.readObject();
                colocalo.close();
                System.out.println("Se cargo el archivo " + donde.getName());
            }
        } catch (IOException e) {
            System.out.println("error>>" + e.getMessage());
        } catch (ClassNotFoundException a) {
            System.out.println("error>>" + a.getMessage());
        }
        return retunar;
    }

    public void escribirArchivoTexto(String textoEscrivir, File donde) {
        try {
            FileWriter escritor = new FileWriter(donde);
            PrintWriter mano = new PrintWriter(escritor);
            System.out.println(textoEscrivir);
            mano.println(textoEscrivir);
            mano.close();
            escritor.close();
        } catch (IOException e) {
        }

    }
}
