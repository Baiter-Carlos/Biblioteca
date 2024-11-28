public class Prestamo {
    private Usuario usuario;
    private Nodos libro;
    private int cantidadPrestada;

    public Prestamo(Nodos libro, int cantidadPrestada, Usuario usuarioSeleccionado) {
        this.libro = libro;
        this.cantidadPrestada = cantidadPrestada;
        this.usuario = usuarioSeleccionado; // Utiliza usuarioSeleccionado en lugar de usuario
    }

    public Usuario getUsuario() {
        return usuario;
    }


    public Nodos getLibro() {
        return libro;
    }

    public void setLibro(Nodos libro) {
        this.libro = libro;
    }

    public int getCantidadPrestada() {
        return cantidadPrestada;
    }

    public void setCantidadPrestada(int cantidadPrestada) {
        this.cantidadPrestada = cantidadPrestada;
    }

    public void devolverLibro(int cantidadDevuelta) {
        cantidadPrestada -= cantidadDevuelta;
    }

    public void restaurarCantidadPrestada() {
        cantidadPrestada = libro.getCantidad();
    }

    @Override
    public String toString() {
        return "Libro: " + libro.toString() + ", Cantidad Prestada: " + cantidadPrestada + ", Prestado a: " + (usuario != null ? usuario.toString() : "N/A");
    }
}