import java.net.*;

/**
 * Clase principal del programa.
 * Obtiene todas las direcciones del sitio web pasado como argumento y las muestra por consola.
 * En caso de que se pase un sitio web incorrecto, se muestra un mensaje de error.
 * En caso de no pasar ningun argumento, se muestra un mensaje de error.
 */
public class Actividad2 {
    public static void main(String[] args) {
    	// Verificar que se pase al menos un parámetro
        if (args.length == 0) {
        	System.out.println("Se necesita una URL para obtener su dirección");
            return; // Salir del programa
        }
        
        String dominio = args[0]; // El argumento que se pasa por consola
    	
        try {
            // Obtener todas las direcciones IP para el sitio pasado como argumento
            InetAddress[] direcciones = InetAddress.getAllByName(dominio);
            
            System.out.println("Las direcciones asociadas a " + dominio + " son:");
            
            for (InetAddress direccion : direcciones) {
                // Mostrar cada dirección IP
                System.out.println(dominio + "/" + direccion.getHostAddress());
            }
        } catch (UnknownHostException e) {
        	// En caso de error
            System.out.println("Error al buscar las direcciones IP");
        }
    }
}