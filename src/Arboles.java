import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Arboles {

    public static void main(String[] args) {
        Arbol arbol = new Arbol();
        ArrayList<Usuario> usuarios = new ArrayList<>();
        ArrayList<Prestamo> librosPrestados = new ArrayList<>();
        Nodos Sal;
        short opcion = 0;
        int Dato;
        String Nombre;

        do {
            try {
                opcion = Short.parseShort(JOptionPane.showInputDialog(null, "Escoga lo que desea hacer en el árbol:\n"
                        + "1. Agregar Libro.\n"
                        + "2. Agregar Usuario.\n"
                        + "3. Mostrar Libros.\n"
                        + "4. Mostrar Usuarios.\n"
                        + "5. Buscar un libro.\n"
                        + "6. Buscar un Usuario.\n"
                        + "7. Eliminar un Libro.\n"
                        + "8. Eliminar un Usuario.\n"
                        + "9. Prestar Libro.\n"
                        + "10. Libros prestados\n"
                        + "11. Devolver Libro.\n"
                        + "12. Salir", "Arbol", JOptionPane.PLAIN_MESSAGE));
                switch (opcion) {
                    case 1:
                        Dato = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el número que quiere insertar en el árbol", "Agregando Nodo", JOptionPane.PLAIN_MESSAGE));
                        Nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del libro", "Agregando Nodo", JOptionPane.PLAIN_MESSAGE);
                        int Cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad del libro", "Agregando Nodo", JOptionPane.PLAIN_MESSAGE));
                        arbol.InsertarDatos(Dato, Nombre, Cantidad);
                        break;
                    case 2:
                        Nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del usuario", "Agregando Usuario", JOptionPane.PLAIN_MESSAGE);
                        if (Nombre != null && !Nombre.isEmpty()) {
                            Usuario nuevoUsuario = new Usuario(Nombre);
                            usuarios.add(nuevoUsuario);
                            JOptionPane.showMessageDialog(null, "Usuario agregado: " + nuevoUsuario, "Usuario Agregado", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "El nombre del usuario no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case 3:
                        if (!arbol.estaVacio()) {
                            String elementos = arbol.obtenerElementos(arbol.Raiz);
                            JOptionPane.showMessageDialog(null, "Los Elementos del Arbol son:\n" + elementos, "Arbol", JOptionPane.PLAIN_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "No hay elementos en el arbol", "Arbol", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 4:
                        StringBuilder listaUsuarios = new StringBuilder();
                        for (Usuario usuario : usuarios) {
                            listaUsuarios.append(usuario.toString()).append("\n");
                        }
                        JOptionPane.showMessageDialog(null, "Los Usuarios son:\n" + listaUsuarios.toString(), "Lista de Usuarios", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case 5:
                        Dato = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el número que quiere buscar en el árbol", "Buscando Nodo", JOptionPane.PLAIN_MESSAGE));
                        Sal = arbol.buscarNodo(Dato);
                        if (Sal == null) {
                            JOptionPane.showMessageDialog(null, "Libro no encontrado", "Buscar Libro", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Libro encontrado, los datos son:\n" + Sal, "Libro encontrado", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 6:
                        Nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del usuario que desea buscar", "Buscar Usuario", JOptionPane.PLAIN_MESSAGE);
                        boolean encontrado = false;
                        for (Usuario usuario : usuarios) {
                            if (usuario.getNombre().equalsIgnoreCase(Nombre)) {
                                JOptionPane.showMessageDialog(null, "Usuario encontrado:\n" + usuario, "Usuario encontrado", JOptionPane.INFORMATION_MESSAGE);
                                encontrado = true;
                                break;
                            }
                        }
                        if (!encontrado) {
                            JOptionPane.showMessageDialog(null, "Usuario no encontrado", "Usuario no encontrado", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 7:
                        if (!arbol.estaVacio()) {
                            Dato = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el número que quiere eliminar en el árbol", "Eliminando Nodo", JOptionPane.PLAIN_MESSAGE));
                            if (!arbol.eliminar(Dato)) {
                                JOptionPane.showMessageDialog(null, "Nodo no existe", "Nodo no encontrado", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "Nodo ha sido eliminado del árbol", "Nodo eliminado", JOptionPane.INFORMATION_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "El árbol está vacío", "Cuidado", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 8:
                        if (!usuarios.isEmpty()) {
                            Nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del usuario que desea eliminar", "Eliminar Usuario", JOptionPane.PLAIN_MESSAGE);
                            boolean eliminado = false;
                            for (Usuario usuario : usuarios) {
                                if (usuario.getNombre().equalsIgnoreCase(Nombre)) {
                                    usuarios.remove(usuario);
                                    JOptionPane.showMessageDialog(null, "Usuario eliminado:\n" + usuario, "Usuario eliminado", JOptionPane.INFORMATION_MESSAGE);
                                    eliminado = true;
                                    break;
                                }
                            }
                            if (!eliminado) {
                                JOptionPane.showMessageDialog(null, "Usuario no encontrado", "Usuario no encontrado", JOptionPane.INFORMATION_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "No hay usuarios para eliminar", "Eliminar Usuario", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 9:
                        // Prestar Libro
                        if (!arbol.estaVacio()) {
                            String elementos = arbol.obtenerElementos(arbol.Raiz);
                            if (!elementos.equals("El árbol está vacío")) {
                                String[] libros = elementos.split("\n");
                                if (libros.length > 0) {
                                    String[] nombresUsuarios = new String[usuarios.size()];
                                    for (int i = 0; i < usuarios.size(); i++) {
                                        nombresUsuarios[i] = usuarios.get(i).getNombre();
                                    }
                                    if (nombresUsuarios.length > 0) {
                                        String libroPrestamo = (String) JOptionPane.showInputDialog(
                                                null,
                                                "Seleccione el libro que desea prestar:",
                                                "Prestar Libro",
                                                JOptionPane.QUESTION_MESSAGE,
                                                null,
                                                libros,
                                                libros[0]
                                        );
                                        if (libroPrestamo != null) {
                                            String usuarioPrestamo = (String) JOptionPane.showInputDialog(
                                                    null,
                                                    "Seleccione al usuario al que desea prestar el libro:",
                                                    "Prestar Libro",
                                                    JOptionPane.QUESTION_MESSAGE,
                                                    null,
                                                    nombresUsuarios,
                                                    nombresUsuarios[0]
                                            );
                                            if (usuarioPrestamo != null) {
                                                // Obtener el Dato del libro seleccionado
                                                int libroDato = Integer.parseInt(libroPrestamo.split(" - ")[0]);

                                                // Buscar el libro en el árbol
                                                Nodos libroPrestado = arbol.buscarNodo(libroDato);
                                                if (libroPrestado != null) {
                                                    Usuario usuarioSeleccionado = null;
                                                    // Encontrar el usuario seleccionado en la lista de usuarios
                                                    for (Usuario usuario : usuarios) {
                                                        if (usuario.getNombre().equals(usuarioPrestamo)) {
                                                            usuarioSeleccionado = usuario;
                                                            break;
                                                        }
                                                    }

                                                    // Si se encontró al usuario, prestar el libro
                                                    if (usuarioSeleccionado != null) {
                                                        // Pedir la cantidad de libros a prestar
                                                        int cantidadPrestamo = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad de libros que desea prestar:", "Cantidad de libros", JOptionPane.PLAIN_MESSAGE));

                                                        // Verificar si hay suficientes libros disponibles
                                                        if (cantidadPrestamo > 0 && cantidadPrestamo <= libroPrestado.Cantidad) {
                                                            // Descontar la cantidad prestada del nodo del árbol
                                                            libroPrestado.Cantidad -= cantidadPrestamo;

                                                            // Registrar el préstamo
                                                            Prestamo nuevoPrestamo = new Prestamo(libroPrestado, cantidadPrestamo, usuarioSeleccionado); // Aquí está el cambio
                                                            librosPrestados.add(nuevoPrestamo);

                                                            JOptionPane.showMessageDialog(
                                                                    null,
                                                                    "Libro(s) prestado(s) al usuario " + usuarioSeleccionado.getNombre() + ":\n" + libroPrestado + "\nCantidad prestada: " + cantidadPrestamo,
                                                                    "Libro(s) prestado(s)",
                                                                    JOptionPane.INFORMATION_MESSAGE
                                                            );
                                                        } else {
                                                            JOptionPane.showMessageDialog(
                                                                    null,
                                                                    "La cantidad seleccionada no es válida o no hay suficientes libros disponibles",
                                                                    "Error",
                                                                    JOptionPane.ERROR_MESSAGE
                                                            );
                                                        }
                                                    } else {
                                                        JOptionPane.showMessageDialog(
                                                                null,
                                                                "Usuario no encontrado",
                                                                "Prestar Libro",
                                                                JOptionPane.INFORMATION_MESSAGE
                                                        );
                                                    }
                                                } else {
                                                    JOptionPane.showMessageDialog(
                                                            null,
                                                            "Libro no encontrado",
                                                            "Prestar Libro",
                                                            JOptionPane.INFORMATION_MESSAGE
                                                    );
                                                }
                                            }
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(
                                                null,
                                                "No hay usuarios disponibles para prestar el libro",
                                                "Prestar Libro",
                                                JOptionPane.INFORMATION_MESSAGE
                                        );
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(
                                            null,
                                            "No hay libros disponibles para prestar",
                                            "Prestar Libro",
                                            JOptionPane.INFORMATION_MESSAGE
                                    );
                                }
                            } else {
                                JOptionPane.showMessageDialog(
                                        null,
                                        "El árbol está vacío",
                                        "Prestar Libro",
                                        JOptionPane.INFORMATION_MESSAGE
                                );
                            }
                        } else {
                            JOptionPane.showMessageDialog(
                                    null,
                                    "El árbol está vacío",
                                    "Prestar Libro",
                                    JOptionPane.INFORMATION_MESSAGE
                            );
                        }
                        break;
                    case 10:
                        // Libros Prestados
                        if (!librosPrestados.isEmpty()) {
                            StringBuilder librosPrestadosInfo = new StringBuilder();
                            for (Prestamo prestamo : librosPrestados) {
                                Usuario usuario = prestamo.getUsuario();
                                if (usuario != null) {
                                    librosPrestadosInfo.append("Usuario: ").append(usuario.getNombre())
                                            .append(", Libro: ").append(prestamo.getLibro().toString())
                                            .append(", Cantidad Prestada: ").append(prestamo.getCantidadPrestada())
                                            .append("\n");
                                }
                            }
                            JOptionPane.showMessageDialog(null, "Libros Prestados:\n" + librosPrestadosInfo.toString(), "Libros Prestados", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "No hay libros prestados actualmente", "Libros Prestados", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 11:
                        if (!librosPrestados.isEmpty()) {
                            String[] nombresLibrosPrestados = new String[librosPrestados.size()];
                            for (int i = 0; i < librosPrestados.size(); i++) {
                                nombresLibrosPrestados[i] = librosPrestados.get(i).toString();
                            }
                            String libroADevolver = (String) JOptionPane.showInputDialog(
                                    null,
                                    "Seleccione el libro que desea devolver:",
                                    "Devolver Libro",
                                    JOptionPane.QUESTION_MESSAGE,
                                    null,
                                    nombresLibrosPrestados,
                                    nombresLibrosPrestados[0]
                            );
                            if (libroADevolver != null) {
                                for (Prestamo prestamo : librosPrestados) {
                                    if (prestamo.toString().equals(libroADevolver)) {
                                        int cantidadDevuelta = Utilidades.seleccionarCantidadDevolucion();
                                        prestamo.devolverLibro(cantidadDevuelta);
                                        JOptionPane.showMessageDialog(
                                                null,
                                                "Libro devuelto:\n" + prestamo,
                                                "Libro devuelto",
                                                JOptionPane.INFORMATION_MESSAGE
                                        );
                                        librosPrestados.remove(prestamo); // Eliminar el libro devuelto de la lista librosPrestados
                                        break;
                                    }
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(
                                    null,
                                    "No hay libros prestados actualmente",
                                    "Libros Prestados",
                                    JOptionPane.INFORMATION_MESSAGE
                            );
                        }
                        break;
                    case 12:
                        JOptionPane.showMessageDialog(null, "Gracias por usar la aplicación, buen día");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "El elemento ingresado no está dentro de las opciones de nuestro sistema", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Hubo un error al digitar el número", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (opcion != 12);
    }
}
