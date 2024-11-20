import java.net.*;

/**
 * Clase principal del programa.
 * Obtiene todas las direcciones del sitio web pasado como argumento y las muestra por consola.
 * En caso de que se pase un sitio web incorrecto, se muestra un mensaje de error.
 * En caso de no pasar ningun argumento, se muestran las direcciones IP locales.
 */
public class Actividad3 {
    public static void main(String[] args) {
        try {
            // Verificar que se pase al menos un parámetro
            if (args.length == 0) {
                // Si no se pasa ningún parámetro, usar las direcciones IP locales
                InetAddress localAddress = InetAddress.getLocalHost();
                System.out.println("Dirección IP: " + localAddress.getHostAddress());
                System.out.println("Nombre: " + localAddress.getHostName());

                // Mostrar las direcciones IP locales
                InetAddress[] localAddresses = InetAddress.getAllByName(localAddress.getHostName());
                for (InetAddress address : localAddresses) {
                    System.out.println(localAddress.getHostName() + "/" + address.getHostAddress());
                }
            } else {
                // Si se pasa un parámetro
                String dominio = args[0];
                
                InetAddress[] direcciones = InetAddress.getAllByName(dominio);

                // Mostrar la dirección IP
                System.out.println("Dirección IP: " + direcciones[0].getHostAddress());
                System.out.println("Nombre: " + direcciones[0].getHostName());

                // Mostrar todas las direcciones IP
                for (InetAddress direccion : direcciones) {
                    System.out.println(dominio + "/" + direccion.getHostAddress());
                }
            }
        } catch (UnknownHostException e) {
        	// En caso de error
            System.out.println("Error al buscar las direcciones IP");
        }
    }
}