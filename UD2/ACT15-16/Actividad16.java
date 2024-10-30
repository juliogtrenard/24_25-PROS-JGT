/**
 * Clase principal del programa.
 */
public class Actividad16 {
    /**
     * Método principal que inicia el programa.
     *
     * @param args Argumentos de línea de comandos.
     */
    public static void main(String[] args) {
        Contador cont = new Contador(100);
        HiloA a = new HiloA("HiloA", cont);
        HiloB b = new HiloB("HiloB", cont);
        
        a.start();
        b.start();
    }
}

/**
 * Clase que representa un contador que se puede incrementar o decrementar.
 */
class Contador {
    private int c = 0;

     /**
     * Constructor de la clase Contador.
     *
     * @param c Valor inicial del contador.
     */
    Contador(int c) {
        this.c = c;
    }

    /**
     * Método sincronizado para incrementar el contador.
     */
    public synchronized void incrementa() {
        c++;
    }

    /**
     * Método sincronizado para decrementar el contador.
     */
    public synchronized void decrementa() {
        c--;
    }

    /**
     * Método sincronizado para obtener el valor actual del contador.
     *
     * @return Valor actual del contador.
     */
    public synchronized int getValor() {
        return c;
    }
}

/**
 * Clase que representa un hilo que incrementa el contador.
 */
class HiloA extends Thread {
    /**
     * Contador a usar.
     */
    private Contador contador;

    /**
     * Constructor de la clase HiloA.
     *
     * @param n Nombre del hilo.
     * @param c Contador a modificar.
     */
    public HiloA(String n, Contador c) {
        setName(n);
        contador = c;
    }

    /**
     * Método que se ejecuta al iniciar el hilo.
     * Incrementa el contador 300 veces y muestra su valor al finalizar.
     */
    public void run() {
        for (int j = 0; j < 300; j++) {
            contador.incrementa();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
            }
        }
        System.out.println(getName() + " contador vale " + contador.getValor());
    }
}

/**
 * Clase que representa un hilo que decrementa el contador.
 */
class HiloB extends Thread {
    /**
     * El contador a usar.
     */
    private Contador contador;

    /**
     * Constructor de la clase HiloB.
     *
     * @param n Nombre del hilo.
     * @param c Contador a modificar.
     */
    public HiloB(String n, Contador c) {
        setName(n);
        contador = c;
    }

    /**
     * Método que se ejecuta al iniciar el hilo.
     * Espera a que el contador alcance 400 y luego lo decrementa 300 veces.
     */
    public void run() {
        // Esperar a que HiloA termine de incrementar
        while (contador.getValor() < 400) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
            }
        }

        for (int j = 0; j < 300; j++) {
            contador.decrementa();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
            }
        }
        System.out.println(getName() + " contador vale " + contador.getValor());
    }
}