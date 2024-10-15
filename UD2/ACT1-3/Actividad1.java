package actividadeshilos;

public class Actividad1 {
	public static void main(String[] args) {
		Hilos hilo1 = new Hilos("Primero ");
        Hilos hilo2 = new Hilos("Segundo ");

        hilo1.start();
        hilo2.start();
	}
}
