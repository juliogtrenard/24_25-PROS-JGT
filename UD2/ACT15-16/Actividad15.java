import java.text.SimpleDateFormat;
import java.util.Date;

class Hilo extends Thread {
    private String nombre;

    public Hilo(String nombre) {
        this.nombre = nombre;
    }

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

public class Actividad15 {
    public static void main(String[] args) {
        Hilo hilo1 = new Hilo("Hilo 1");
        Hilo hilo2 = new Hilo("Hilo 2");
        Hilo hilo3 = new Hilo("Hilo 3");

        hilo1.start();
        hilo2.start();
        hilo3.start();
    }
}
