import java.io.*;

/*
 * Clase Actividad11 para listar utilizando el comando ls -al ya que se realiza desde Linux
 */
public class Actividad11 {
    public static void main(String[] args) {
        Runtime r = Runtime.getRuntime();
        //String comando = "CMD /C DIR"; // Para Windows
        String comando = "java Ejemplo2"; // Para Linux
        Process p = null;
        try {
            p = r.exec(comando);
            InputStream is = p.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String linea;
            while ((linea = br.readLine()) != null) // lee una línea
                System.out.println(linea);
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Comprobación: Valor= 0 bien, Valor = -1 mal
        int exitVal;
        try {
            exitVal = p.waitFor();
            System.out.println("Valor de Salida " + exitVal);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
