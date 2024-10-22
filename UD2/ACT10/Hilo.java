/*
 * Clase que extiende de Thread donde se crean los hilos y se muestra el mensaje
 */
public class Hilo extends Thread {
    private String mensaje;

    public Hilo(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public void run() {
        //Mensaje a mostrar
        System.out.println("Ejecutando... " + mensaje);
    }
}