import java.io.IOException;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

/**
 * Clase que crea una estructura de carpetas en el usuario dinux
 */
public class Actividad2 {
	private final static String USER = "dinux";
	private final static String PASSWORD = "dinux";
	private final static String SERVIDOR = "172.20.104.140";
	private final static int PORT = 21;

	public static void main(String[] args) {
		FTPClient ftpClient = new FTPClient();
		
		try {
            System.out.println("Nos conectamos a " + SERVIDOR);
            
            ftpClient.connect(SERVIDOR, PORT);
            
            if (ftpClient.login(USER, PASSWORD)) {
                System.out.println("Login correcto");
                System.out.println("Directorio actual: " + ftpClient.printWorkingDirectory());

                ftpClient.enterLocalPassiveMode();
                ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

                String base = "aplicacionwebgonzalez";
                boolean crearBase = ftpClient.makeDirectory(base);
                boolean creardHtml = ftpClient.makeDirectory(base + "/html");
                boolean crearImagenes = ftpClient.makeDirectory(base + "/imagenes");
                boolean crearCss = ftpClient.makeDirectory(base + "/css");

                if (crearBase && creardHtml && crearImagenes && crearCss) {
                    System.out.println("Directorios creados...");
                } else {
                    System.out.println("NO SE HAN PODIDO CREAR LOS DIRECTORIOS");
                }

                if (ftpClient.logout()) {
                    System.out.println("Logout del servidor FTP....");
                } else {
                    System.out.println("Error al hacer logout");
                }
            } else {
                System.out.println("Login incorrecto...");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.disconnect();
                    System.out.println("Desconectado...");
                }
            } catch (IOException e) {
                System.out.println("Error al desconectar: " + e.getMessage());
                e.printStackTrace();
            }
        }
	}
}