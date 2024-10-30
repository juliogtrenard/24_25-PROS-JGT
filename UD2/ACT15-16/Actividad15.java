import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clase que representa un hilo que muestra mensajes con su nombre y la hora actual.
 */
class Hilo extends Thread {
    /**
     * Nombre del hilo.
     */
    private String nombre;

    /**
     * Constructor de la clase Hilo.
     *
     * @param nombre El nombre del hilo.
     */
    public Hilo(String nombre) {
        this.nombre = nombre;
    }

     /**
     * Método que se ejecuta al iniciar el hilo.
     * Muestra el nombre del hilo y la hora actual cinco veces,
     * esperando 1 segundo entre cada mensaje.
     */
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            // Obtener la hora actual
            String horaActual = new SimpleDateFormat("HH:mm:ss").format(new Date());
            
            System.out.println(nombre + " - " + horaActual);
            
            try {
                Thread.sleep(1000); // Esperar 1 segundo
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

/**
 * Clase principal para ejecutar el programa.
 */
public class Actividad15 {
    /**
     * Método principal que crea e inicia los hilos.
     *
     * @param args Argumentos de línea de comandos.
     */
    public static void main(String[] args) {
        Hilo hilo1 = new Hilo("Hilo 1");
        Hilo hilo2 = new Hilo("Hilo 2");
        Hilo hilo3 = new Hilo("Hilo 3");

        hilo1.start();
        hilo2.start();
        hilo3.start();
    }
}
