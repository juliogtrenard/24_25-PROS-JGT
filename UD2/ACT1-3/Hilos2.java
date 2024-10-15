package actividadeshilos;

public class Hilos2 extends Thread {
	private final int hiloNumero;

	public Hilos2(int hiloNumero) {
		this.hiloNumero = hiloNumero;
	}

	@Override
	public void run() {
		for (int j = 0; j < 20; j++) {
			System.out.println("Hilo " + hiloNumero);
		}
	}
}
