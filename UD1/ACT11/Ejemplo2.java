import java.io.*;

/*
 * Clase Ejemplo2 para listar utilizando el comando ls -al ya que se realiza desde Linux
 */
public class Ejemplo2 {
    public static void main(String[] args) {
        Runtime r = Runtime.getRuntime();
        String comando = "ls -al"; // Descomentar la línea para Linux
        // String comando = "CMD /C DIR"; // Descomentar la línea para Windows
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

