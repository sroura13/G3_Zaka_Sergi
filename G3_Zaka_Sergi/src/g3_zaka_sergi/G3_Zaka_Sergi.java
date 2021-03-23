/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g3_zaka_sergi;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author RVdav
 */
public class G3_Zaka_Sergi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         File fichero = new File("D:\\Grado Superior ASIX1\\GitKraken\\G3_Zaka_Sergi\\classrooms.csv");
        
        try {
            /*
             * ISO-8859-1 Sirve para que al momento de ejecutar el programa
             * no falle a causa de un fichero con palabras con acentos
             * Scanner lectorFichero = new Scanner(fichero, "ISO-8859-1");
            */
            Scanner lectorFichero = new Scanner(fichero, "ISO-8859-1");
            
            while(lectorFichero.hasNext()) {
                System.out.println(lectorFichero.nextLine());
            }
            
            /**
             * Este lector sirve para poder cerrar el fichero, aunque java
             * ya cierra el fichero de por si
            */
            lectorFichero.close();
            
            /**
             * Control de errores por si el fichero no se ha podido abrir
             * a causa de algun error
             */
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error al abrir/leer el fichero");
        }
    }
}
