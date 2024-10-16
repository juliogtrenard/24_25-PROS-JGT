/*
 * Clase que crea y ejecuta dos hilos simultáneamente, cada uno con un mensaje diferente
 */
public class Actividad4 {

	public static void main(String[] args) {
		Thread hilo1 = new Thread(new Posicion("Primero "));
		Thread hilo2 = new Thread(new Posicion("Segundo "));
		
		hilo1.start();
		hilo2.start();
		
		System.out.println("Fin programa");
	}

}
