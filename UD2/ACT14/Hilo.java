/**
 * La clase Hilo que extiende de Thread y representa
 * un hilo que trabaja sobre dos recursos compartidos.
 * 
 * Los hilos sincronizan el acceso a los
 * recursos a y b para evitar problemas de concurrencia.
 */
class Hilo extends Thread { 
    Recurso a; 
    Recurso b; 
    
    /**
     * Constructor de la clase Hilo.
     * 
     * @param a El primer recurso que será utilizado por el hilo.
     * @param b El segundo recurso que será utilizado por el hilo.
     * @param nombre El nombre del hilo, que se pasa al constructor de Thread.
     */
    public Hilo(Recurso a, Recurso b, String nombre) { 
        super(nombre); 
        this.a = a; 
        this.b = b; 
    }
    
    /**
     * Donde se define la lógica del hilo.
     * 
     * Realiza la sincronización en el recurso a,
     * duerme el hilo durante 100ms y luego intenta acceder
     * al recurso b.
     */
    public void run() { 
        System.out.println("Hilo " + this.getName() + " comienza"); 
        
        synchronized(a) { 
            try { 
                Thread.sleep(100); 
            } catch (InterruptedException e) { 
                e.printStackTrace(); 
            }
            synchronized(b) { 
                // Se quita para evitar el bloqueo
            } 
        }
        
        System.out.println("Hilo " + this.getName() + " ha terminado"); 
    } 
}

/**
 * La clase Recurso representa un recurso compartido
 * que puede ser utilizado por múltiples hilos.
 * 
 * En este programa la clase está vacía.
 */
class Recurso { 
}