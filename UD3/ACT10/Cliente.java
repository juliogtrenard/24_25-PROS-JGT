import java.net.*;
import java.io.*;

/* Clase Cliente que crea y envia un Tenista al Servidor para luego recibir el Tenista modificado */
public class Cliente {
    public static void main(String[] args) {
        try {
        	// Crear Tenista
            Tenista tenista = new Tenista("del Potro", 198);
        	
            // Dirección y puerto
            InetAddress servidor = InetAddress.getByName("localhost");
            int puertoServidor = 12348;

            // Socket UDP
            DatagramSocket socketCliente = new DatagramSocket(34567);

            // Objeto Tenista a array de bytes
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(tenista);
            oos.flush();
            byte[] buffer = baos.toByteArray();

            // Crear datagrama y enviar
            DatagramPacket paquete = new DatagramPacket(buffer, buffer.length, servidor, puertoServidor);
            socketCliente.send(paquete);
            
            System.out.println("Envío el objeto: " + tenista.getApellido() + " " + tenista.getAltura());

            // Esperar la respuesta
            System.out.println("Esperando datagrama.......");
            byte[] bufferRespuesta = new byte[1024];
            DatagramPacket paqueteRespuesta = new DatagramPacket(bufferRespuesta, bufferRespuesta.length);
            socketCliente.receive(paqueteRespuesta);

            // Recibir el Tenista modificado
            ByteArrayInputStream bais = new ByteArrayInputStream(bufferRespuesta);
            ObjectInputStream ois = new ObjectInputStream(bais);
            Tenista tenistaRecibido = (Tenista) ois.readObject();

            // Mostrar el tenista
            System.out.println("He recibido el objeto: " + tenistaRecibido.getApellido() + " " + tenistaRecibido.getAltura());
            
            System.out.println("Fin del cliente");

            // Cerrar el socket
            socketCliente.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
