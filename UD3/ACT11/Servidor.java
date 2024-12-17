import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * Clase Servidor donde se conectan los clientes
 */
public class Servidor {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(6000)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Cliente Conectado.....");
                new HiloServidor(clientSocket).start();
            }
        } catch (IOException e) {
            System.err.println("Error en el servidor: " + e.getMessage());
        }
    }
}