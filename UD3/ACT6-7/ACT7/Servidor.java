import java.io.*;
import java.net.*;

/**
 * Clase Servidor.
 * Envia el mensaje para los clientes.
 */
public class Servidor {
    public static void main(String[] args) {
        // Puerto a usar
        int puerto = 6013;

        ServerSocket serverSocket = null;
        Socket socketCliente = null;
        DataOutputStream out = null;
        DataInputStream in = null;
        
        System.out.println("Esperando a los clientes.....");

        try {
            // Crear ServerSocket
            serverSocket = new ServerSocket(puerto);

            // 3 clientes
            for (int i = 1; i <= 3; i++) {
                try {
                    // Esperar por la conexión de un cliente
                    socketCliente = serverSocket.accept();

                    // Flujos de entrada y salida
                    out = new DataOutputStream(socketCliente.getOutputStream());
                    in = new DataInputStream(socketCliente.getInputStream());

                    // Enviar un mensaje al cliente
                    out.writeUTF("Hola cliente " + i);
                    
                    in.close();
                    out.close();
                    socketCliente.close();
                } catch (IOException e) {
                    System.out.println("Error en la comunicación con el cliente " + i + ": " + e.getMessage());
                }
            }
            
            serverSocket.close();
        } catch (IOException e) {
            System.out.println("Error en el servidor: " + e.getMessage());
        }
    }
}

