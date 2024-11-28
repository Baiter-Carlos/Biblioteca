import java.util.ArrayList;
import java.util.List;

public class Arbol {
    Nodos Raiz;
    List<Prestamo> librosPrestados; // Declaración de la lista de libros prestados

    public Arbol() {
        Raiz = null;
        librosPrestados = new ArrayList<>(); // Inicialización de la lista de libros prestados
    }

    public boolean estaVacio() {
        return Raiz == null;
    }

    public void InsertarDatos(int dato, String nom, int cantidad) {
        Nodos nuevo = new Nodos(dato, nom, cantidad);
        if (estaVacio())
            Raiz = nuevo;
        else {
            Nodos aux = Raiz, Padre;
            while (true) {
                Padre = aux;
                if (dato < aux.Dato) {
                    aux = aux.HijoIzq;
                    if (aux == null) {
                        Padre.HijoIzq = nuevo;
                        return;
                    }
                } else {
                    aux = aux.HijoDer;
                    if (aux == null) {
                        Padre.HijoDer = nuevo;
                        return;
                    }
                }
            }
        }
    }

    public String obtenerElementos(Nodos nodo) {
        StringBuilder resultado = new StringBuilder();
        obtenerElementosRecursivo(nodo, resultado);
        return resultado.toString();
    }

    private void obtenerElementosRecursivo(Nodos nodo, StringBuilder resultado) {
        if (nodo != null) {
            obtenerElementosRecursivo(nodo.HijoIzq, resultado);
            resultado.append(nodo.Dato).append(" - ").append(nodo.Nombre).append(" - Cantidad: ").append(nodo.Cantidad).append("\n");
            obtenerElementosRecursivo(nodo.HijoDer, resultado);
        }
    }

    public void inOrder(Nodos Nodo) {
        if (Nodo != null) {
            inOrder(Nodo.HijoIzq);
            System.out.print(Nodo.Dato + " - " + Nodo.Nombre + ", ");
            inOrder(Nodo.HijoDer);
        }
    }

    public void preOrder(Nodos Nodo) {
        if (Nodo != null) {
            System.out.print(Nodo.Dato + " - " + Nodo.Nombre + ", ");
            preOrder(Nodo.HijoIzq);
            preOrder(Nodo.HijoDer);
        }
    }

    public void postOrder(Nodos Nodo) {
        if (Nodo != null) {
            postOrder(Nodo.HijoIzq);
            postOrder(Nodo.HijoDer);
            System.out.print(Nodo.Dato + " - " + Nodo.Nombre + ", ");
        }
    }

    public Nodos buscarNodo(int d) {
        Nodos aux = Raiz;
        while (aux != null && aux.Dato != d) {
            aux = d < aux.Dato ? aux.HijoIzq : aux.HijoDer;
        }
        return aux;
    }

    public boolean eliminar(int d) {
        Nodos auxiliar = Raiz;
        Nodos padre = Raiz;
        boolean esHijoIzq = true;

        while (auxiliar.Dato != d) {
            padre = auxiliar;
            if (d < auxiliar.Dato) {
                esHijoIzq = true;
                auxiliar = auxiliar.HijoIzq;
            } else {
                esHijoIzq = false;
                auxiliar = auxiliar.HijoDer;
            }
            if (auxiliar == null) {
                return false;
            }
        }

        // Eliminación de nodos
        if (auxiliar.HijoIzq == null && auxiliar.HijoDer == null) {
            if (auxiliar == Raiz) {
                Raiz = null;
            } else if (esHijoIzq) {
                padre.HijoIzq = null;
            } else {
                padre.HijoDer = null;
            }
        } else if (auxiliar.HijoDer == null) {
            if (auxiliar == Raiz) {
                Raiz = auxiliar.HijoIzq;
            } else if (esHijoIzq) {
                padre.HijoIzq = auxiliar.HijoIzq;
            } else {
                padre.HijoDer = auxiliar.HijoIzq;
            }
        } else if (auxiliar.HijoIzq == null) {
            if (auxiliar == Raiz) {
                Raiz = auxiliar.HijoDer;
            } else if (esHijoIzq) {
                padre.HijoIzq = auxiliar.HijoDer;
            } else {
                padre.HijoDer = auxiliar.HijoIzq;
            }
        } else {
            Nodos reemplazo = obtenerNodoReemplazo(auxiliar);
            if (auxiliar == Raiz) {
                Raiz = reemplazo;
            } else if (esHijoIzq) {
                padre.HijoIzq = reemplazo;
            } else {
                padre.HijoDer = reemplazo;
            }
            reemplazo.HijoIzq = auxiliar.HijoIzq;
        }
        return true;
    }

    public Nodos obtenerNodoReemplazo(Nodos nodoReemp) {
        Nodos reemplazarPadre = nodoReemp;
        Nodos reemplazo = nodoReemp;
        Nodos auxiliar = nodoReemp.HijoDer;

        while (auxiliar != null) {
            reemplazarPadre = reemplazo;
            reemplazo = auxiliar;
            auxiliar = auxiliar.HijoIzq;
        }

        if (reemplazo != nodoReemp.HijoDer) {
            reemplazarPadre.HijoIzq = reemplazo.HijoDer;
            reemplazo.HijoDer = nodoReemp.HijoDer;
        }

        return reemplazo;
    }
}

