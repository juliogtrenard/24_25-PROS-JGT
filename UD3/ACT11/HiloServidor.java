import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/*
 * Clase HiloServidor que controla la entrada por teclado para mirar si se introduce una cadena o '*'
 */
public class HiloServidor extends Thread {
    private Socket clientSocket;

    /**
     * Constructor para HiloServidor.
     * 
     * @param clientSocket Socket conectado al cliente.
     */
    public HiloServidor(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try (
            BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true)
        ) {
            String received;
            while ((received = input.readLine()) != null) {
                System.out.println("Comunico con: " + clientSocket);
                if ("*".equals(received)) {
                    System.out.println("Fin de la conexión con: " + clientSocket);
		    output.println("*");
                    break;
                }
                output.println(received.toUpperCase());
            }
        } catch (IOException e) {
            System.err.println("Error comunicando con el cliente: " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                System.err.println("Error cerrando el socket: " + e.getMessage());
            }
        }
    }
}