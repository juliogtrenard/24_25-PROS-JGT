import java.io.*;
import java.net.*;

/**
 * Clase Cliente.
 * Se conecta 4 veces con el servidor y recibe el mensaje enviado por el servidor.
 * La cuarta conexión lanza un mensaje de error.
 */
public class Cliente {
    public static void main(String[] args) {
        // Dirección IP del servidor
        String host = "localhost";
        int puerto = 6013;

        Socket socket = null;
        DataInputStream in = null;
        DataOutputStream out = null;

        // Intentar conectar con el servidor 4 veces
        for (int i = 1; i <= 4; i++) {
            try {
            	System.out.println("PROGRAMA CLIENTE INICIANDO");
            	
                // Conexión con el servidor
                socket = new Socket(host, puerto);

                // Flujos de entrada y salida
                out = new DataOutputStream(socket.getOutputStream());
                in = new DataInputStream(socket.getInputStream());

                // Leer el mensaje enviado por el servidor
                String mensajeServidor = in.readUTF();
                System.out.println("Recibiendo mensaje del servidor: ");
                System.out.println("\t" + mensajeServidor);
                
                in.close();
                out.close();
                socket.close();
            } catch (IOException e) {
                // Si se conecta más de 3 veces, se produce un error
                if (i <= 3) {
                    System.out.println("Error en la conexión: " + e.getMessage());
                } else {
                    System.out.println("Connection refused: connect");
                }
            }
        }
    }
}
