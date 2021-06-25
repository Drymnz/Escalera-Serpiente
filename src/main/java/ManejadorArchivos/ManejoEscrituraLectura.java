/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManejadorArchivos;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author drymnz
 */
public class ManejoEscrituraLectura {
    public<T> void escribirArchivo(T aguardar, File donde){
        try {
            FileOutputStream cual = new FileOutputStream(donde.getAbsolutePath());
            ObjectOutputStream colocar = new ObjectOutputStream(cual);
            colocar.writeObject(aguardar);
            colocar.close();
            System.out.println("Se aguardo "+donde.toString());
        } catch (IOException e) {
            System.out.println("Error >>"+e.toString());
            System.out.println("fue "+e.getMessage());
        }
    }
}
