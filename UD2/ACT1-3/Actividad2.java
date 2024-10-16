package actividadeshilos;

public class Actividad2 extends Thread {
	private final int hiloNumero;

	public Actividad2(int hiloNumero) {
		this.hiloNumero = hiloNumero;
	}

	@Override
	public void run() {
		for (int j = 0; j < 20; j++) {
			System.out.println("Hilo " + hiloNumero);
		}
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		
        Hilos2[] hilos = new Hilos2[n];
        for (int i = 0; i < n; i++) {
            hilos[i] = new Hilos2(i + 1);
            hilos[i].start();
        }
        
        System.out.println("Final programa");
	}
}
