import javax.swing.JOptionPane;
import java.util.concurrent.atomic.AtomicInteger;

public class Usuario {
    private static final AtomicInteger contadorIDs = new AtomicInteger(0);
    private final int id;
    private String nombre;
    private Nodos libroPrestado; // Agregar atributo libroPrestado

    public Usuario(String nombre) {
        this.id = contadorIDs.incrementAndGet();
        this.nombre = nombre;
        this.libroPrestado = null; // Inicializar el libroPrestado como null al crear un usuario
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Nodos getLibroPrestado() {
        return libroPrestado;
    }

    public void setLibroPrestado(Nodos libroPrestado) {
        this.libroPrestado = libroPrestado;
    }

    // Método para seleccionar la cantidad de libros a prestar
    public int seleccionarCantidad() {
        // Definir las opciones de cantidad como un array de 1 a 10
        int[] opcionesCantidad = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // Convertir el array de opciones de cantidad a un array de objetos Integer
        Integer[] opciones = new Integer[opcionesCantidad.length];
        for (int i = 0; i < opcionesCantidad.length; i++) {
            opciones[i] = opcionesCantidad[i];
        }

        // Mostrar un diálogo para que el usuario seleccione la cantidad
        Integer cantidadSeleccionada = (Integer) JOptionPane.showInputDialog(
                null,
                "Seleccione la cantidad de libros:",
                "Seleccionar Cantidad",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]
        );

        // Si el usuario cancela la selección, devolver 1 (cantidad predeterminada); de lo contrario, devolver la cantidad seleccionada
        return cantidadSeleccionada != null ? cantidadSeleccionada : 1;
    }

    // Método para devolver un libro prestado
    public void devolverLibro() {
        libroPrestado = null; // Restablecer el libro prestado a null
        JOptionPane.showMessageDialog(null, "Libro devuelto con éxito.", "Devolución de Libro", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public String toString() {
        return " " + id + " - " + nombre + " ";
    }
}