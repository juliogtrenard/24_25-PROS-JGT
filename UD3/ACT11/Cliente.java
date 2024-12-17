import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/*
 * Clase Cliente que se conecta a un servidor, escribe una cadena y la recibe en mayusculas
 */
public class Cliente {
    public static void main(String[] args) {
        System.out.println("PROGRAMA CLIENTE INICIANDO");
        try (Socket socket = new Socket("localhost", 6000);
             PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             Scanner scanner = new Scanner(System.in)) {

            String message;
            while (true) {
                System.out.println("Introduce una cadena:");
                message = scanner.nextLine();
                output.println(message);
                String response = input.readLine();
                System.out.println("=>Respuesta:" + response);
                if ("*".equals(message)) {
                    System.out.println("Fin del envío....");
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println("Error en el cliente: " + e.getMessage());
        }
    }
}
