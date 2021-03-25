/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g3_zaka_sergi;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
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
        leerFichero();
        añadirLinea();
    }

    public static void leerFichero() {
        File fichero = new File("files/classrooms.csv");

        try {
            /*
            * ISO-8859-1 Sirve para que al momento de ejecutar el programa
            * no falle a causa de un fichero con palabras con acentos
            * Scanner lectorFichero = new Scanner(fichero, "ISO-8859-1");
             */
            Scanner lectorFichero = new Scanner(fichero);

            while (lectorFichero.hasNext()) {
                String aula = lectorFichero.nextLine();
                imprimirAulas(aula);
            }

            /**
             * Este lector sirve para poder cerrar el fichero, aunque java ya
             * cierra el fichero de por si
             */
            lectorFichero.close();

            /**
             * Control de errores por si el fichero no se ha podido abrir a
             * causa de algun error
             */
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error al abrir/leer el fichero");
        }
    }

    private static void imprimirAulas(String aula) {

        //Dividimos los datos por comas y lo guardamos en una array
        String[] datosAula = aula.split(",");
        int i = 0;
        //Imprimimos los datos
        System.out.println("Clase: " + datosAula[i] + ", Información del aula: " + datosAula[i + 1] + ", Capacidad máxima de alumnos: " + datosAula[i + 2]
                + ", Hay PC's: " + datosAula[i + 3] + ", Nº PC's: " + datosAula[i + 4] + ", Hay proyector: " + datosAula[i + 5]
                + ", Clase insonorizada: " + datosAula[i + 6]);
    }

    public static void añadirLinea() {
        File fichero = new File("files/classrooms.csv");
        Scanner lector = new Scanner(System.in);
        String[] datos = new String[7];
        //Pedimos que el usuario introduzca los datos de la clase
        System.out.println("");
        System.out.println("--AÑADE UN CLASE NUEVA--");
        System.out.print("Clase: ");
        datos[0] = lector.next();
        System.out.print("Información del aula: ");
        datos[1] = lector.next();
        System.out.print("Capacidad máxima de alumnos:");
        datos[2] = lector.next();
        System.out.print("Hay PC's: ");
        datos[3] = lector.next();
        System.out.print("Nº PC's: ");
        datos[4] = lector.next();
        System.out.print("Hay proyector: ");
        datos[5] = lector.next();
        System.out.print("Clase insonorizada: ");
        datos[6] = lector.next();
        try {
            // El true al final indica que escribiremos al final del fichero añadiendo texto
            FileWriter writer = new FileWriter(fichero, true);
            //Añadimos la linea

            writer.write(datos[0] + "," + datos[1] + "," + datos[2] + "," + datos[3] + "," + datos[4] + "," + datos[5] + "," + datos[6]);

            writer.close();
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error al crear/escribir en el fichero");
        }
    }

}
