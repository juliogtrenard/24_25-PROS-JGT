/*
 * Programa que crea dos hilos que imprimen "Primero" o "Segundo" 20 veces cada uno
 */
public class Actividad1 {
	public static void main(String[] args) {
		Hilo hilo1 = new Hilo("Primero ");
        Hilo hilo2 = new Hilo("Segundo ");

        hilo1.start();
        hilo2.start();
	}
}
