import java.io.*;
import java.net.*;

/**
 * Clase Servidor
 * Envia el mensaje con el resultado
 */
public class Servidor {
    public static void main(String[] args) {
        final int PUERTO = 6010;
        ServerSocket serverSocket = null;
        Socket clienteSocket = null;
        DataInputStream entrada = null;
        DataOutputStream salida = null;

        try {
            // Iniciar el ServerSocket
            serverSocket = new ServerSocket(PUERTO);
            System.out.println("Esperando al cliente.....");
            
            // Esperar a que el cliente se conecte
            clienteSocket = serverSocket.accept();

            // Flujos de entrada y salida
            entrada = new DataInputStream(clienteSocket.getInputStream());
            salida = new DataOutputStream(clienteSocket.getOutputStream());

            // Leer el número enviado
            int numeroRecibido = entrada.readInt();
            
            // Calcular el cuadrado del número
            int resultado = numeroRecibido * numeroRecibido;

            // Enviar el mensaje con el resultado
            String mensaje = "El cuadrado del número " + numeroRecibido + " es " + resultado;
            salida.writeUTF(mensaje);
            
            entrada.close();
            salida.close();
            clienteSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            System.out.println("Error en la conexión: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
