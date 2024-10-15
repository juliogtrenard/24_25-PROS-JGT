package actividadeshilos;

public class Hilos extends Thread {
	public void primero() {
		for(int i = 1; i <= 20; i++) {
			System.out.println("Primero " + i);
		}
	}
	
	public void segundo() {
		for(int i = 1; i <= 20; i++) {
			System.out.println("Segundo " + i);
		}
	}
}
