import javax.swing.*;

import javax.swing.JOptionPane;

public class Nodos {
    int Dato;
    String Nombre;
    int Cantidad; // Nueva variable para almacenar la cantidad del libro
    Nodos HijoIzq, HijoDer;
    private Libro libro;

    public Nodos(int Dato, String nom, int cantidad) {
        this.Dato = Dato;
        this.Nombre = nom;
        this.Cantidad = cantidad;
        this.libro = libro;
        this.HijoDer = null;
        this.HijoIzq = null;
    }

    public int getCantidad() {
        return Cantidad;
    }

    private int seleccionarCantidad(int[] opcionesCantidad) {
        // Convertir el array de opciones de cantidad a un array de objetos Integer
        Integer[] opciones = new Integer[opcionesCantidad.length];
        for (int i = 0; i < opcionesCantidad.length; i++) {
            opciones[i] = opcionesCantidad[i];
        }

        // Mostrar un diálogo para que el usuario seleccione la cantidad
        Integer cantidadSeleccionada = (Integer) JOptionPane.showInputDialog(
                null,
                "Seleccione la cantidad del libro:",
                "Seleccionar Cantidad",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]
        );

        // Si el usuario cancela la selección, devolver 0; de lo contrario, devolver la cantidad seleccionada
        return cantidadSeleccionada != null ? cantidadSeleccionada : 0;
    }

    public String toString() {
        return Nombre + " - " + Dato; // Modificado para incluir solo el nombre y el dato del libro
    }
}