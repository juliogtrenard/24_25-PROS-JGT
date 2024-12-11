import java.net.*;
import java.io.*;

/* Clase Servidor que recibe un Tenista del Cliente, lo modifica y lo envía de vuelta */
public class Servidor {
    public static void main(String[] args) {
        try {
            // Socket UDP
            DatagramSocket socketServidor = new DatagramSocket(12348);
            System.out.println("Esperando datagrama.......");

            // Buffer para recibir el datagrama
            byte[] buffer = new byte[1024];
            DatagramPacket paqueteRecibido = new DatagramPacket(buffer, buffer.length);

            // Recibir el datagrama
            socketServidor.receive(paqueteRecibido);

            // Convertir datos del datagrama
            ByteArrayInputStream bais = new ByteArrayInputStream(paqueteRecibido.getData(), 0, paqueteRecibido.getLength());
            ObjectInputStream ois = new ObjectInputStream(bais);
            Tenista tenistaRecibido = (Tenista) ois.readObject();

            // Mostrar el objeto recibido
            System.out.println("Recibo el objeto: " + tenistaRecibido.getApellido() + " " + tenistaRecibido.getAltura());
            System.out.println("IP de origen: " + paqueteRecibido.getAddress());
            System.out.println("Puerto de origen: " + paqueteRecibido.getPort());

            // Modificar el Tenista
            tenistaRecibido.setApellido("Karlovic");
            tenistaRecibido.setAltura(208);

            // Mostrar el Tenista modificado
            System.out.println("Envío el objeto: " + tenistaRecibido.getApellido() + " " + tenistaRecibido.getAltura());

            // Enviar el Tenista modificado
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(tenistaRecibido);
            oos.flush();
            byte[] bufferRespuesta = baos.toByteArray();

            // Crear datagrama para enviar
            DatagramPacket paqueteRespuesta = new DatagramPacket(bufferRespuesta, bufferRespuesta.length,
                    paqueteRecibido.getAddress(), paqueteRecibido.getPort());
            socketServidor.send(paqueteRespuesta);

            System.out.println("Fin del servidor");
            
            // Cerrar el socket
            socketServidor.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
