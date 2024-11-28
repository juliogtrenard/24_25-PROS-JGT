import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 * Clase Cliente
 * Obtiene el número introducido por el usuario y lo envía al servidor
 */
public class Cliente {
    public static void main(String[] args) {
        final String DIRECCION_SERVIDOR = "localhost";
        final int PUERTO = 6010;
        Socket socket = null;
        DataOutputStream salida = null;
        DataInputStream entrada = null;
        Scanner scanner = new Scanner(System.in);

        System.out.println("PROGRAMA CLIENTE INICIANDO");

        try {
            // Conectarse al servidor
            socket = new Socket(DIRECCION_SERVIDOR, PUERTO);

            // Flujos de entrada y salida
            salida = new DataOutputStream(socket.getOutputStream());
            entrada = new DataInputStream(socket.getInputStream());

            // Pedir el número
            System.out.println("Introduce un número");
            int numero = scanner.nextInt();

            // Enviar el número al servidor
            salida.writeInt(numero);

            // Recibir el mensaje del servidor
            String mensajeRecibido = entrada.readUTF();
            System.out.println("Recibiendo mensaje del servidor: ");
            System.out.println("\t" + mensajeRecibido);
            
            entrada.close();
            salida.close();
            socket.close();
            scanner.close();
        } catch (IOException e) {
            System.out.println("Error de conexión: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

