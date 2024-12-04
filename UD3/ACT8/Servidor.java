import java.net.*;

/**
 * Clase Servidor que calcula el cubo de un numero y envia el mensaje al cliente
 */
public class Servidor {
    public static void main(String[] args) {
        DatagramSocket socket = null;

        try {
            // Socket UDP
            socket = new DatagramSocket(12346);
            
            System.out.println("Esperando datagrama...");
            
            // Recibir el mensaje
            byte[] buffer = new byte[1024];
            DatagramPacket paqueteRecibido = new DatagramPacket(buffer, buffer.length);
            
            // Recibir el datagrama
            socket.receive(paqueteRecibido);
            
            // Obtener el número
            String mensajeRecibido = new String(paqueteRecibido.getData(), 0, paqueteRecibido.getLength());
            int numero = Integer.parseInt(mensajeRecibido);
            
            // Mostrar la información
            System.out.println("Vamos a calcular el cubo de: " + numero);
            System.out.println("IP de origen: " + paqueteRecibido.getAddress());
            System.out.println("Puerto de origen: " + paqueteRecibido.getPort());
            
            // Calcular el cubo
            int cubo = (int) Math.pow(numero, 3);
            
            // Convertir el mensaje
            String respuesta = String.valueOf(cubo);
            byte[] respuestaBytes = respuesta.getBytes();
            
            // Enviar el resultado
            DatagramPacket paqueteRespuesta = new DatagramPacket(respuestaBytes, respuestaBytes.length, paqueteRecibido.getAddress(), paqueteRecibido.getPort());
            socket.send(paqueteRespuesta);
            
            // Mostrar mensaje de envío
            System.out.println("Enviamos el resultado... " + cubo);
            
            // Mensaje final y cierre del socket
            System.out.println("Adiósss");
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
