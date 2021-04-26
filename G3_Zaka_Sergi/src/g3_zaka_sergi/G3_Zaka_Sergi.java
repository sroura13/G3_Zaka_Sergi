/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g3_zaka_sergi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
    //Creamos un array de usuaios
    //Por defecto, todas las posiciones del array valen null
    static User[] personal;
    static String usuarioInciado;

    public static void main(String[] args) {
        //leerFichero();
        //añadirLinea();
        //modificarLinea();
        //eliminarLinea();
        cargarUsuarios();
        crearUsuariosBasicos();
        //crearUsuario();
        //leerUsuarios();
        //modificarUsuario();
        //leerUsuarios();
        login();
        //menuTeacher();
        //menuAdmin();
    }

    public static void leerFicheroAulas() {
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
            System.out.println("");
            System.out.println("Ha ocurrido un error al abrir/leer el fichero en leerFicheroAulas()");
        }
    }

    public static void leerFicheroProgramas() {
        File fichero = new File("files/programs.csv");

        try {
            /*
            * ISO-8859-1 Sirve para que al momento de ejecutar el programa
            * no falle a causa de un fichero con palabras con acentos
            * Scanner lectorFichero = new Scanner(fichero, "ISO-8859-1");
             */
            Scanner lectorFichero = new Scanner(fichero);

            while (lectorFichero.hasNext()) {
                String programa = lectorFichero.nextLine();
                imprimirProgramas(programa);
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
            System.out.println("");
            System.out.println("Ha ocurrido un error al abrir/leer el fichero en leerFicheroProgramas()");
        }
    }

    private static void imprimirAulas(String aula) {

        //Dividimos los datos por comas y lo guardamos en una array
        String[] datosAula = aula.split(",");

        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------");
        //Imprimimos los datos
        System.out.println("Clase: " + datosAula[0] + ", Información del aula: " + datosAula[1] + ", Capacidad máxima de alumnos: " + datosAula[2]
                + ", Hay PC's: " + datosAula[3] + ", Nº PC's: " + datosAula[4] + ", Hay proyector: " + datosAula[5]
                + ", Clase insonorizada: " + datosAula[6]);
    }

    private static void imprimirProgramas(String programa) {

        //Dividimos los datos por comas y lo guardamos en una array
        String[] datosPrograma = programa.split(",");

        System.out.println("------------------------------------------------------------------------------------------------------------------------");
        //Imprimimos los datos
        System.out.println("Clase: " + datosPrograma[0] + ", Programa 1: " + datosPrograma[1] + ", Programa 2: " + datosPrograma[2]
                + ", Programa 3: " + datosPrograma[3] + ", Programa 4: " + datosPrograma[4]);
    }

    public static void añadirLineaAula() {
        File fichero = new File("files/classrooms.csv");
        Scanner lector = new Scanner(System.in);
        String[] datos = new String[7];
        //Pedimos que el usuario introduzca los datos de la clase
        System.out.println("");
        System.out.println("--AÑADE UN CLASE NUEVA--");
        System.out.print("Clase: ");
        datos[0] = lector.next();
        lector.nextLine();
        System.out.print("Información del aula: ");
        datos[1] = lector.nextLine();
        System.out.print("Capacidad máxima de alumnos: ");
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
            writer.write("\n" + datos[0] + "," + datos[1] + "," + datos[2] + "," + datos[3] + "," + datos[4] + "," + datos[5] + "," + datos[6]);

            writer.close();
        } catch (Exception e) {
            System.out.println("");
            System.out.println("Ha ocurrido un error al crear/escribir en el fichero en añadirLinea()");
        }
    }

    public static void modificarLineaAula() {
        File fichero = new File("files/classrooms.csv");

        // Array para guardar todas las líneas leídas del fichero
        ArrayList<String> lineas = new ArrayList<>();

        // Abrimos el fichero de texto para leerlo en memoria
        try {
            Scanner lectorFichero = new Scanner(fichero);

            while (lectorFichero.hasNext()) {
                lineas.add(lectorFichero.nextLine());
            }

            lectorFichero.close();

        } catch (Exception e) {
            System.out.println("");
            System.out.println("Ha ocurrido un error al abrir/leer el fichero");
        }

        Scanner lector = new Scanner(System.in);

        //Pedimos la clase a modificar y contamos el numero de caracteres que tiene el String clase
        System.out.println("");
        System.out.println("--MODIFICA UNA CLASE--");
        System.out.print("Que clase quieres modificar: ");
        String clase = lector.next();
        int longitud = clase.length();
        lector.nextLine();

        String[] datos = new String[7];
        //Pedimos que el usuario introduzca los datos de la clase
        System.out.println("");
        System.out.println("--NUEVOS CAMPOS--");
        System.out.print("Clase: ");
        datos[0] = lector.next();
        lector.nextLine();
        System.out.print("Información del aula: ");
        datos[1] = lector.nextLine();
        System.out.print("Capacidad máxima de alumnos: ");
        datos[2] = lector.next();
        System.out.print("Hay PC's: ");
        datos[3] = lector.next();
        System.out.print("Nº PC's: ");
        datos[4] = lector.next();
        System.out.print("Hay proyector: ");
        datos[5] = lector.next();
        System.out.print("Clase insonorizada: ");
        datos[6] = lector.next();

        // Abrimos el fichero de texto para sobreescribirlo
        // Actualizaremos la línea 4
        try {
            FileWriter writer = new FileWriter(fichero);

            for (String linea : lineas) {
                if (clase.equals(linea.substring(0, longitud))) {
                    writer.write(datos[0] + "," + datos[1] + "," + datos[2] + "," + datos[3] + "," + datos[4] + "," + datos[5] + "," + datos[6] + "\n");
                } else {
                    writer.write(linea + "\n");
                }
            }

            writer.close();
        } catch (Exception e) {
            System.out.println("");
            System.out.println("Ha ocurrido un error al abrir/sobreescribir el fichero en modificarLinea()");
        }
    }

    public static void modificarLineaPrograma() {
        File fichero = new File("files/programs.csv");

        // Array para guardar todas las líneas leídas del fichero
        ArrayList<String> lineas = new ArrayList<>();

        // Abrimos el fichero de texto para leerlo en memoria
        try {
            Scanner lectorFichero = new Scanner(fichero);

            while (lectorFichero.hasNext()) {
                lineas.add(lectorFichero.nextLine());
            }

            lectorFichero.close();

        } catch (Exception e) {
            System.out.println("");
            System.out.println("Ha ocurrido un error al abrir/leer el fichero");
        }

        Scanner lector = new Scanner(System.in);

        //Pedimos la clase a modificar y contamos el numero de caracteres que tiene el String clase
        System.out.println("");
        System.out.println("--MODIFICA LOS PROGRAMAS DE UN CURSO--");
        System.out.print("Que curso quieres modificar: ");
        String curso = lector.next();
        int longitud = curso.length();
        lector.nextLine();

        String[] datos = new String[7];
        //Pedimos que el usuario introduzca los datos de la clase
        System.out.println("");
        System.out.println("--NUEVOS CAMPOS--");
        System.out.print("Programa 1: ");
        datos[1] = lector.nextLine();
        System.out.print("Programa 2: ");
        datos[2] = lector.nextLine();
        System.out.print("Programa 3: ");
        datos[3] = lector.nextLine();
        System.out.print("Programa 4: ");
        datos[4] = lector.nextLine();

        // Abrimos el fichero de texto para sobreescribirlo
        // Actualizaremos la línea 4
        try {
            FileWriter writer = new FileWriter(fichero);

            for (String linea : lineas) {
                if (curso.equals(linea.substring(0, longitud))) {
                    writer.write(datos[0] + "," + datos[1] + "," + datos[2] + "," + datos[3] + "," + datos[4] + "\n");
                } else {
                    writer.write(linea + "\n");
                }
            }

            writer.close();
        } catch (Exception e) {
            System.out.println("");
            System.out.println("Ha ocurrido un error al abrir/sobreescribir el fichero en modificarLinea()");
        }
    }

    public static void eliminarLinea() {
        File fichero = new File("files/classrooms.csv");

        // Array para guardar todas las líneas leídas del fichero
        ArrayList<String> lineas = new ArrayList<>();

        // Abrimos el fichero de texto para leerlo en memoria
        try {
            Scanner lectorFichero = new Scanner(fichero);

            while (lectorFichero.hasNext()) {
                lineas.add(lectorFichero.nextLine());
            }

            lectorFichero.close();
        } catch (Exception e) {
            System.out.println("");
            System.out.println("Ha ocurrido un error al abrir/leer el fichero eliminarLinea()");
        }

        Scanner lector = new Scanner(System.in);

        System.out.println("");
        System.out.println("--ELIMINA UNA CLASE--");
        System.out.print("Que clase quieres eliminar: ");
        String clase = lector.next();
        int longitud = clase.length();
        lector.nextLine();

        // Abrimos el fichero de texto para sobreescribirlo
        // Eliminaremos la línea 3
        try {
            FileWriter writer = new FileWriter(fichero);

            for (String linea : lineas) {
                if (!clase.equals(linea.substring(0, longitud))) {
                    writer.write(linea + "\n");
                }
            }

            writer.close();
        } catch (Exception e) {
            System.out.println("");
            System.out.println("Ha ocurrido un error al abrir/sobreescribir el fichero");
        }
    }

    public static void crearUsuariosBasicos() {
        //CREAR FICHERO BINARIO
        try {
            ObjectOutputStream fichero = new ObjectOutputStream(new FileOutputStream("files/users.dat"));

            //Creamos un nuevo empleado en la 1ª posición del array
            personal[0] = new User();
            personal[0].usuario = "Sergi";
            personal[0].contraseña = "Admin2016.";
            personal[0].rol = "Admin";

            //Creamos un nuevo empleado en la 2ª posición del array
            personal[1] = new User();
            personal[1].usuario = "Zacarias";
            personal[1].contraseña = "Teacher2016.";
            personal[1].rol = "Teacher";

            //Con un writeObject escribimos directamente todo el array de Empleados
            fichero.writeObject(personal);

            //Cerramos el fichero
            fichero.close();

        } catch (Exception e) {
            System.out.println("");
            System.out.println("Ha ocurrido un error al crear/guardar el fichero en crearUsuariosBasicos()");
        }
    }

    public static void crearUsuario() {
        Scanner lector = new Scanner(System.in);
        //CREAR FICHERO BINARIO
        try {
            ObjectOutputStream fichero = new ObjectOutputStream(new FileOutputStream("files/users.dat"));
            boolean insertarUsuario = false;
            boolean insertarNombreUsuario;
            String nombreUsuario;
            for (int i = 0; i < personal.length && !insertarUsuario; i++) {
                if (personal[i] == null) {
                    personal[i] = new User();
                    //Recorremos el array hasta que encontremos una posición que sea null, cuando encontremos esa posición, entonces es donde meteremos el usuario nuevo 
                    do {
                        insertarNombreUsuario = false;
                        System.out.println("");
                        System.out.print("Nombre de usuario: ");
                        //Pedimos un nombre de usuario y comprobamos que este no existe
                        nombreUsuario = lector.next();
                        System.out.println("");
                        for (int j = 0; j < personal.length; j++) {
                            if (personal[j] != null && personal[j].usuario != null && personal[j].usuario.equals(nombreUsuario)) {
                                System.out.println("ERROR: El usuario introducido ya existe");
                                System.out.println("");
                                insertarNombreUsuario = true;
                            }
                        }
                    } while (insertarNombreUsuario);
                    //Pedimos una contraseña una vez el nombre sea correcto
                    personal[i].usuario = nombreUsuario;
                    System.out.print("Contraseña: ");
                    personal[i].contraseña = lector.next();
                    System.out.println("");
                    do {
                        System.out.print("Rol (Teacher o Admin): ");
                        personal[i].rol = lector.next();
                        System.out.println("");
                        //Por ultimo pedimos que escriba su rol y comprobamos que el rol escrito sea Admin o Teacher
                    } while (!personal[i].rol.equals("Teacher") && !personal[i].rol.equals("Admin"));
                    insertarUsuario = true;
                }
            }
            fichero.writeObject(personal);
            fichero.close();

        } catch (Exception e) {
            System.out.println("");
            System.out.println("Ha ocurrido un error al crear/guardar el fichero en crearUsuario()");
            e.printStackTrace();

        }
    }

    public static void modificarUsuario() {
        Scanner lector = new Scanner(System.in);
        //CREAR FICHERO BINARIO
        try {
            ObjectOutputStream fichero = new ObjectOutputStream(new FileOutputStream("files/users.dat"));
            boolean insertar = false;
            boolean usuarioExiste = false;
            boolean errorEliminarUsuario = false;
            String usuario;
            System.out.println("");
            System.out.print("Que usuario quieres modificar: ");
            usuario = lector.next();
            String usuarioModificado = usuario;
            int contadorAdmins = 0;
            //Comprobamos que el usuario introducido existe y lo comprobamos con un booleano
            for (int i = 0; i < personal.length; i++) {
                if (personal[i] != null && personal[i].usuario.equals(usuario)) {
                    usuarioExiste = true;
                }
            }
            
            if (usuarioExiste == true) {
                //Bucle que cuenta cuantos usuarios Admin existen y los guarda en el contador contadorAdmins
                for (int i = 0; i < personal.length; i++) {
                    if (personal[i] != null && personal[i].rol.equals("Admin")) {
                        contadorAdmins++;
                    }
                }
                //Si existe este usuario, entonces modificamos el usuario
                for (int i = 0; i < personal.length; i++) {
                    //Modificar un usuario Teacher
                    if (personal[i] != null && personal[i].usuario.equals(usuario) && personal[i].rol.equals("Teacher")) {
                        System.out.println("");
                        System.out.print("Nuevo nombre de usuario: ");
                        personal[i].usuario = lector.next();
                        System.out.print("Nueva contraseña: ");
                        personal[i].contraseña = lector.next();
                        
                        do {
                            System.out.print("Rol (Teacher o Admin): ");
                            personal[i].rol = lector.next();
                            System.out.println("");
                        } while (!personal[i].rol.equals("Teacher") && !personal[i].rol.equals("Admin"));
                        insertar = true;
                    } //Modifica el usuario Admin indicado siempre y cuando el contador de Admin sea mayor que 1
                    else if (personal[i] != null && personal[i].usuario.equals(usuario) && personal[i].rol.equals("Admin")) {
                        System.out.println("");
                        System.out.print("Nuevo nombre de usuario: ");
                        personal[i].usuario = lector.next();
                        System.out.print("Nueva contraseña: ");
                        personal[i].contraseña = lector.next();
                        do {
                            System.out.print("Rol (Teacher o Admin): ");
                            personal[i].rol = lector.next();
                            if (personal[i].rol.equals("Teacher") && contadorAdmins == 1) {
                                //Si intentamos borrar el ultimo usuario con el rol Admin le imprimimos por pantalla este error
                                System.out.println("ERROR: No se ha podido modificar el rol del usuario " + usuarioModificado
                                        + " porque es el único Administrador");
                                personal[i].rol = "Admin";
                            }
                            System.out.println("");
                        } while (!personal[i].rol.equals("Teacher") && !personal[i].rol.equals("Admin"));
                        insertar = true;
                        if (usuarioModificado.equals(usuarioInciado)) {
                            login();
                        }
                    }
                }
                //Si no existe, le imprimimos por pantalla un error y volvemos a llamar a la función
            } else {
                System.out.println("");
                System.out.println("ERROR: El usuario indicado no existe");
                modificarUsuario();
            }
            
            fichero.writeObject(personal);
            fichero.close();

        } catch (Exception e) {
            System.out.println("");
            System.out.println("Ha ocurrido un error al crear/guardar el fichero en modificarUsuario()");
        }
    }

    public static void eliminarUsuario() {
        Scanner lector = new Scanner(System.in);
        //CREAR FICHERO BINARIO
        try {
            ObjectOutputStream fichero = new ObjectOutputStream(new FileOutputStream("files/users.dat"));
            int contadorAdmins = 0, contadorUsuario = 0;
            System.out.println("");
            System.out.print("Que usuario quieres eliminar: ");
            String usuarioEliminado = lector.next();
            boolean usuarioExiste = false;
            for (int i = 0; i < personal.length; i++) {
                if (personal[i] != null && personal[i].usuario.equals(usuarioEliminado)) {
                    usuarioExiste = true;
                }
            }
            if (usuarioExiste == true) {
                //Bucle que cuenta cuantos usuarios Admin existen y los guarda en el contador contadorAdmins
                for (int i = 0; i < personal.length; i++) {
                    if (personal[i] != null && personal[i].rol.equals("Admin")) {
                        contadorAdmins++;
                    }
                }

                for (int i = 0; i < personal.length; i++) {
                    //Elimina un usuario Teacher
                    if (personal[i] != null && personal[i].usuario.equals(usuarioEliminado) && personal[i].rol.equals("Teacher")) {
                        contadorUsuario++;
                        personal[i].usuario = "";
                        personal[i].contraseña = "";
                        personal[i].rol = "";
                        personal[i] = null;
                        System.out.println("");
                        System.out.println("EL ususario " + usuarioEliminado + " se ha eliminado.");
                    } //Elimina el usuario Admin indicado siempre y cuando el contador de Admin sea mayor que 1
                    else if (personal[i] != null && personal[i].usuario.equals(usuarioEliminado) && personal[i].rol.equals("Admin") && contadorAdmins > 1) {
                        contadorUsuario++;
                        personal[i].usuario = "";
                        personal[i].contraseña = "";
                        personal[i].rol = "";
                        personal[i] = null;
                        System.out.println("");
                        System.out.println("El ususario " + usuarioEliminado + " se ha eliminado.");
                        if (usuarioEliminado.equals(usuarioInciado)) {
                            login();
                        }
                    }

                }

                if (contadorAdmins == 1 && personal[contadorUsuario] !=null && personal[contadorUsuario].rol.equals("Admin")) {
                    System.out.println("ERROR: El usuario " + usuarioEliminado + " no se ha podido elminar porque es el único Administrador");
                }
            } else {
                System.out.println("");
                System.out.println("ERROR: El usuario indicado no existe");
                eliminarUsuario();
            }
            fichero.writeObject(personal);
            fichero.close();

        } catch (Exception e) {
            System.out.println("");
            System.out.println("Ha ocurrido un error al crear/guardar el fichero en eliminarUsuario()");
            e.printStackTrace();
        }
    }

    public static void leerUsuarios() {
        try {
            ObjectInputStream fichero = new ObjectInputStream(new FileInputStream("files/users.dat"));

            //Leemos un objecto del fichero
            User[] personal = (User[]) fichero.readObject();
            //Imprimimos todos los usuarios que existen
            System.out.println("");
            System.out.println("------TODOS LOS USUARIOS------");
            for (User usuario : personal) {
                if (usuario != null && !usuario.usuario.isEmpty()) {
                    System.out.println("");
                    System.out.println("------------------------------");
                    System.out.println("Usuario: " + usuario.usuario);
                    System.out.println("Contrseña: " + usuario.contraseña);
                    System.out.println("Rol: " + usuario.rol);
                    System.out.println("------------------------------");
                }
            }

            fichero.close();

        } catch (Exception e) {
            System.out.println("");
            System.out.println("Ha ocurrido un error al crear/guardar el fichero en leerUsuarios()");
        }
    }

    public static void leerUsuariosAdmin() {
        try {
            ObjectInputStream fichero = new ObjectInputStream(new FileInputStream("files/users.dat"));

            //Leemos un objecto del fichero
            User[] personal = (User[]) fichero.readObject();
            //Imprimimos todos los usuarios que tengan el rol Admin
            System.out.println("");
            System.out.println("------USUARIOS ADMINISTRADORES------");
            for (User usuario : personal) {
                if (usuario != null && !usuario.usuario.isEmpty() && usuario.rol.equals("Admin")) {
                    System.out.println("");
                    System.out.println("------------------------------");
                    System.out.println("Usuario: " + usuario.usuario);
                    System.out.println("Contrseña: " + usuario.contraseña);
                    System.out.println("Rol: " + usuario.rol);
                    System.out.println("------------------------------");
                }
            }

            fichero.close();

        } catch (Exception e) {
            System.out.println("");
            System.out.println("Ha ocurrido un error al crear/guardar el fichero en leerUsuarios()");
        }
    }

    public static void leerUsuariosTeacher() {
        try {
            ObjectInputStream fichero = new ObjectInputStream(new FileInputStream("files/users.dat"));

            //Leemos un objecto del fichero
            User[] personal = (User[]) fichero.readObject();
            //Imprimimos todos los usuarios que tengan el rol Teacher
            System.out.println("");
            System.out.println("------USUARIOS TEACHER------");
            for (User usuario : personal) {
                if (usuario != null && !usuario.usuario.isEmpty() && usuario.rol.equals("Teacher")) {
                    System.out.println("");
                    System.out.println("------------------------------");
                    System.out.println("Usuario: " + usuario.usuario);
                    System.out.println("Contrseña: " + usuario.contraseña);
                    System.out.println("Rol: " + usuario.rol);
                    System.out.println("------------------------------");
                }
            }

            fichero.close();

        } catch (Exception e) {
            System.out.println("");
            System.out.println("Ha ocurrido un error al crear/guardar el fichero en leerUsuarios()");
        }
    }

    public static void cargarUsuarios() {
        personal = new User[100];
        try {
            ObjectInputStream fichero = new ObjectInputStream(new FileInputStream("files/users.dat"));

            //Leemos un objecto del fichero
            personal = (User[]) fichero.readObject();

            fichero.close();

        } catch (Exception e) {
            System.out.println("");
            System.out.println("Ha ocurrido un error al crear/guardar el fichero en leerUsuarios()");
        }
    }

    public static void login() {
        Scanner lector = new Scanner(System.in);
        System.out.println("");
        System.out.println("-------LOGIN-------");
        System.out.println("");
        String usuario, contraseña;
        System.out.print("Usuario: ");
        usuario = lector.next();
        usuarioInciado = usuario;
        System.out.print("Contraseña: ");
        contraseña = lector.next();

        //Comprueba las credenciales del usuario y su rol para mostrar su respectivo menú
        try {
            ObjectInputStream fichero = new ObjectInputStream(new FileInputStream("files/users.dat"));

            //Leemos un objecto del fichero
            User[] users = (User[]) fichero.readObject();
            boolean found = false;

            for (User user : users) {
                //Comprueba las credenciales del usuario y su rol para mostrar su respectivo menú
                if (user != null && !found) {
                    if (user.usuario.equals(usuario)) {
                        if (user.contraseña.equals(contraseña)) {
                            found = true;
                            if (user.rol.equals("Admin")) {
                                fichero.close();
                                menuAdmin();
                            } else if (user.rol.equals("Teacher")) {
                                fichero.close();
                                menuTeacher();
                            }
                        }
                    }
                }
            }
            if (!found) {
                System.out.println("");
                System.out.println("ERROR: El usuario o contraseña son incorrectos");
                login();
            }
        } catch (Exception e) {
        }
    }

    public static void menuAdmin() {
        Scanner lector = new Scanner(System.in);
        int opcion;
        //Imprimimos un menú con sus respectivas funciones dependiendo del rol
        do {
            System.out.println("");
            System.out.println("-----MENÚ ADMIN-----");
            System.out.println("Usuario: " + usuarioInciado);
            System.out.println("");
            System.out.println("1 - Crear Usuario");
            System.out.println("2 - Modificar Usuario");
            System.out.println("3 - Eliminar un Usuario");
            System.out.println("4 - Listar Usuarios");
            System.out.println("5 - Cerrar sesión");
            System.out.println("0 - Salir");
            System.out.println("");
            System.out.print("Que deseas hacer? ");
            opcion = lector.nextInt();
            
            //Llamamos a la función introducida por el usuario
            if (opcion == 1) {
                crearUsuario();
            } else if (opcion == 2) {
                modificarUsuario();
            } else if (opcion == 3) {
                eliminarUsuario();
            } else if (opcion == 4) {
                menuListarUsuarios();
            } else if (opcion == 5) {
                login();
            } else if (opcion == 0) {
                System.exit(0);
            } else {
                System.out.println("ERROR: Por favor elige una opción del 0 al 4");
            }
        } while (opcion != 0);

    }

    public static void menuTeacher() {
        Scanner lector = new Scanner(System.in);
        int opcion;
        //Imprimimos un menú con sus respectivas funciones dependiendo del rol
        do {
            System.out.println("");
            System.out.println("--------MENÚ TEACHER--------");
            System.out.println("Usuario: " + usuarioInciado);
            System.out.println("");
            System.out.println("1 - Ver información de las aulas");
            System.out.println("2 - Añadir un aula nueva");
            System.out.println("3 - Modificar un aula");
            System.out.println("4 - Eliminar un aula");
            System.out.println("5 - Ver información de los programas");
            System.out.println("6 - Cerrar sesión");
            System.out.println("0 - Salir");
            System.out.println("");
            System.out.print("Que deseas hacer? ");
            opcion = lector.nextInt();
            
            if (opcion == 1) {
                leerFicheroAulas();
            } else if (opcion == 2) {
                añadirLineaAula();
            } else if (opcion == 3) {
                modificarLineaAula();
            } else if (opcion == 4) {
                eliminarLinea();
            } else if (opcion == 5) {
                leerFicheroProgramas();
            } else if (opcion == 6) {
                login();
            } else if (opcion == 0) {
                System.exit(0);
            } else {
                System.out.println("ERROR: Por favor elige una opción del 0 al 5");
            }
        } while (opcion != 0);
    }

    public static void menuListarUsuarios() {
        int opcion;
        //Menú para listar todos los usuarios o dependiendo de su rol y una opción para poder volver atrás en el menú y no cerrar el programa
        do {
            Scanner lector = new Scanner(System.in);
            System.out.println("");
            System.out.println("Que quieres mostrar: ");
            System.out.println("");
            System.out.println("1 - Mostrar todos los usuarios");
            System.out.println("2 - Mostrar usuarios administradores");
            System.out.println("3 - Mostrar usuarios teachers");
            System.out.println("0 - Salir");
            System.out.println("");
            System.out.print("Que deseas hacer: ");
            opcion = lector.nextInt();

            if (opcion == 1) {
                leerUsuarios();
            } else if (opcion == 2) {
                leerUsuariosAdmin();
            } else if (opcion == 3) {
                leerUsuariosTeacher();
            } else if (opcion == 0) {
                menuAdmin();
            } else {
                System.out.println("ERROR: Por favor elige una opción del 0 al 4");
            }

        } while (opcion != 0);

    }

}
