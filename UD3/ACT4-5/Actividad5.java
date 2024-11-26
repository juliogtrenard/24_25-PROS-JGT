import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/*
 * Clase que muestra la información de una conexión HTTP
 */
public class Actividad5 {

    public static void main(String[] args) {
        // Llamar al método
        Actividad5 actividad = new Actividad5();
        actividad.VisualizarConexión();
    }

    // Realiza la conexión y muestra los detalles
    private void VisualizarConexión() {
        try {
            // Crea un cliente HTTP
            HttpClient cliente = HttpClient.newHttpClient();

            // Crea una solicitud HTTP con la URI, la envía y obtiene la respuesta
            HttpRequest solicitud = HttpRequest.newBuilder().uri(new URI("http://www.vitoria-gasteiz.com")).build();
            HttpResponse<String> respuesta = cliente.send(solicitud, HttpResponse.BodyHandlers.ofString());

            // Encabezado del texto por consola
            System.out.println("Conexión con www.vitoria-gasteiz.com");
            System.out.println("==========================");
            
            // Imprime la primera línea
            System.out.println("\tMétodo toString():" + respuesta.toString());

            // Imprime la segunda línea
            System.out.println("\tMétodo getStatusCode():" + respuesta.statusCode());

            // Imprime la tercera línea
            System.out.println("\tMétodo getContentType():" + respuesta.headers().firstValue("Content-Type").orElse("N/A"));

        } catch (Exception e) {
            // En caso de errores de conexión
            System.out.println("Error al realizar la conexión: " + e.getMessage());
        }
    }
}
