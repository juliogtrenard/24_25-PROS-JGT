/*
 * Programa en Java que saca por consola información relativa a la prioridad del hilo principal y de otros dos hilos.
 */
public class Actividad10 {
    public static void main(String[] args) {
        //Creamos los hilos
        Hilo hilo1 = new Hilo("Hilo-prioridad 3");
        Hilo hilo2 = new Hilo("Hilo-prioridad 7");

        //Les damos las prioridades
        hilo1.setPriority(3);
        hilo2.setPriority(7);

        //Mostramos la información del hilo principal
        Thread hiloPrincipal = Thread.currentThread();
        System.out.println(hiloPrincipal.getName() + " tiene la prioridad " + hiloPrincipal.getPriority());

        //Iniciamos los hilos
        hilo1.start();
        hilo2.start();

        //Mostramos la información de los hilos
        System.out.println(hilo1.getName() + " tiene la prioridad " + hilo1.getPriority());
        System.out.println(hilo2.getName() + " tiene la prioridad " + hilo2.getPriority());

        //Final del programa
        System.out.println("Final programa");
    }
}
