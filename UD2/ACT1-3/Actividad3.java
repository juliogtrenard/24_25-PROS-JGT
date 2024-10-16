/*
 * Programa que crea un hilo, saca su información incial (Nombre y prioridad) y luego la cambia
 */
public class Actividad3 {
    public static void main(String[] args) {
        Thread hilo = new Thread();

        // Mostrar el nombre y prioridad inicial del hilo
        System.out.println("El nombre del hilo es " + hilo.getName() + " y tiene la prioridad " + hilo.getPriority() + "\n");

        // Cambiar el nombre y la prioridad del hilo
        hilo.setName("SUPER-HILO-DM2");
        hilo.setPriority(6);

        // Mostrar el nuevo nombre y prioridad del hilo
        System.out.println("Ahora el nombre del hilo es " + hilo.getName() + " y tiene la prioridad " + hilo.getPriority() + "\n");

        System.out.println("Final programa");
    }
}
