/**
 * Clase Actividad14 que extiende de Thread
 * y muestra la creación y ejecución de múltiples hilos
 * que comparten recursos.
 * 
 * Se crean dos instancias de Recurso
 * y se inician dos hilos Hilo que intentan acceder a estos recursos
 * de manera concurrente.
 */
public class Actividad14 extends Thread { 
    /**
     * Inicio de la aplicación.
     * Se crean dos instancias de Recurso y dos hilos que 
     * utilizan estos recursos.
     * 
     * @param args Argumentos de línea de comandos.
     */
    public static void main(String args[]) {
        Recurso a = new Recurso(); 
        Recurso b = new Recurso(); 
        
        Hilo h1 = new Hilo(a, b, "uno"); 
        Hilo h2 = new Hilo(a, b, "dos"); 
        
        h1.start(); 
        h2.start(); 
    }
}