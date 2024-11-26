import java.net.URI;
import java.net.URISyntaxException;

public class Actividad4 {

    public static void main(String[] args) {
        // Crea las URIs
        try {
            URI uri1 = new URI("http://docs.oracle.com");
            URI uri2 = new URI("http://docs.oracle.com/javase/7");
            URI uri3 = new URI("http://docs.oracle.com/javase/7/docs/api/java/net/URL.html");

            // Llama al método para cada URI
            Actividad4 actividad = new Actividad4();
            actividad.Visualizar(uri1);
            actividad.Visualizar(uri2);
            actividad.Visualizar(uri3);
        } catch (URISyntaxException e) {
            System.out.println("Error en la URI: " + e.getMessage());
        }
    }

    // Recibe un objeto URI y muestra su información
    private void Visualizar(URI uri) {
        System.out.println("URI: " + uri);
        System.out.println("\tHost: " + uri.getHost());
        System.out.println("\tPort: " + uri.getPort());
        System.out.println("\tPath: " + uri.getPath());
        System.out.println("\tScheme: " + uri.getScheme());
        System.out.println("\tAuthority: " + uri.getAuthority());
        System.out.println();
    }
}
