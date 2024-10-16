/*
 * Clase que se usa para crear el hilo y muestra un mensaje 15 veces, después de cada mensaje espera 100 ms
 */
class Primero extends Thread { 
    public void run() {
        for (int i = 1; i <= 15; i++) {
            System.out.println("Primero " + i);
            try {
                Thread.sleep(100); //100 milisegundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}