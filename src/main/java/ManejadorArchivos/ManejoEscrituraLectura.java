/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManejadorArchivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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
                ObjectInputStream colocalo= new ObjectInputStream(mirar);
                retunar = colocalo.readObject();
                colocalo.close();
                System.out.println("Se cargo el archivo "+donde.getName());
            }
        } catch (IOException e) {
            System.out.println("error>>"+e.getMessage());
        }catch (ClassNotFoundException a){
            System.out.println("error>>"+ a.getMessage());
        }
        return retunar;
    }
}
