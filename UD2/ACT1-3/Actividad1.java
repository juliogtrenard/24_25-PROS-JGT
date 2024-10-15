package actividadeshilos;

public class Actividad1 {
	public static void main(String[] args) {
		Hilos h = new Hilos();
		
		new Thread(new Runnable() {
		    public void run() {
		        h.primero();
		    }
		}).start();
		
	    new Thread(new Runnable() {
	        public void run() {
	            h.segundo();
	        }
	    }).start();
	}
}
