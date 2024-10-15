package actividadeshilos;

public class Hilos extends Thread {
	private final String mensaje;

    public Hilos(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            System.out.println(mensaje + i);
        }
    }
}
