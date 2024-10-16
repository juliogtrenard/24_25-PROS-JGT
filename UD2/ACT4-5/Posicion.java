public class Posicion implements Runnable {
	private final String mensaje;

    public Posicion(String mensaje) {
        this.mensaje = mensaje;
    }
	
	@Override
	public void run() {
		for (int i = 1; i <= 15; i++) {
            System.out.println(mensaje + i);
        }
	}
}
