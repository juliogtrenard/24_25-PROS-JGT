import java.net.*;

/**
 * Clase cliente que se conecta a un servidor.
 */
public class Cliente {
    public static void main(String[] args) {
        DatagramSocket socket = null;

        try {
        	// El número a enviar
            int numero = 4;

            // Socket UDP en el puerto 34568
            socket = new DatagramSocket(34568);
            
            // Dirección del servidor
            InetAddress servidor = InetAddress.getByName("localhost");
            
            // Enviar el número
            byte[] mensaje = String.valueOf(numero).getBytes();
            DatagramPacket paquete = new DatagramPacket(mensaje, mensaje.length, servidor, 12346);
            socket.send(paquete);
            
            // Mensaje de espera
            System.out.println("Esperando respuesta...");
            
            // Recibir la respuesta
            byte[] buffer = new byte[1024];
            DatagramPacket respuesta = new DatagramPacket(buffer, buffer.length);
            socket.receive(respuesta);
            String respuestaServidor = new String(respuesta.getData(), 0, respuesta.getLength());
            
            // Mostrar la respuesta
            System.out.println("Esperando respuesta...: " + "el cubo de " + numero + " es " + respuestaServidor);
            
            // Mensaje final y cierre del socket
            System.out.println("Adiós...");
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
