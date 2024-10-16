/*
 * Clase que se encarga de gestionar la informacion que va a salir por pantalla en la clase Actividad1.
 * Ademas de ser la clase con la que se crea el hilo
 */
public class Hilo extends Thread {
	private final String mensaje;

    public Hilo(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            System.out.println(mensaje + i);
        }
    }
}
