public class Libro {
    private String nombre;
    private int cantidad; // Esta es la cantidad disponible del libro.

    public Libro(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    // Incrementa el stock del libro.
    public void incrementarCantidad(int cantidad) {
        this.cantidad += cantidad;
    }

    @Override
    public String toString() {
        return nombre + " - " + cantidad + " disponibles";
    }
}
