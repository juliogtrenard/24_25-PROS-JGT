import java.net.*;

public class Actividad1 {
    public static void main(String[] args) {
        try {
            // Obtener todas las direcciones IP
            InetAddress[] direcciones = InetAddress.getAllByName("www.spotify.com");
            
            System.out.println("Direcciones asociadas a Spotify:");
            
            // Bucle para cada dirección obtenida
            for (InetAddress direccion : direcciones) {
                // Mostrar cada dirección IP
                System.out.println("www.spotify.com/" + direccion.getHostAddress());
            }
        } catch (UnknownHostException e) {
            // En caso de error
            System.out.println("Error al buscar las direcciones IP");
        }
    }
}