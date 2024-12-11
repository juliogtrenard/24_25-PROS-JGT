import java.io.Serializable;

// Clase con información de un tenista
public class Tenista implements Serializable {
    private String apellido;
    private int altura;

    // Constructor
    public Tenista(String apellido, int altura) {
        this.apellido = apellido;
        this.altura = altura;
    }

    // Métodos para acceder a los atributos
    public String getApellido() {
        return apellido;
    }

    public int getAltura() {
        return altura;
    }

    // Métodos para modificar los atributos
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
}
