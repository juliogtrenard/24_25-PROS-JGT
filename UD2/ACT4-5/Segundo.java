/*
 * Clase que se usa para crear el hilo y muestra un mensaje 15 veces, después de cada mensaje espera 200 ms
 */
class Segundo extends Thread { 
    public void run() {
        for (int i = 1; i <= 15; i++) {
            System.out.println("Segundo " + i);
            try {
                Thread.sleep(200); //200 milisegundos (0.2 segundos)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
