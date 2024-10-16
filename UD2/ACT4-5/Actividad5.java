/*
 * Clase que crea dos hilos para mostrar la información que contengan. Las clases Primero y Segundo
 * manejan la información del hilo
 */
public class Actividad5 {
    public static void main(String arg[]) {
        Primero p = new Primero();
        Segundo s = new Segundo();
        p.start();
        s.start();
        System.out.println("Fin programa");
    }
}