package impl;

import api.ConjuntoTDA;

public class ConjuntoDinamico implements ConjuntoTDA {
    // Nodo que representa el primer elemento del conjunto
    Nodo c;

    // Inicializa el conjunto
    public void InicializarConjunto() {
        c = null;
    }

    // Verifica si el conjunto está vacío
    public boolean ConjuntoVacio() {
        return (c == null);
    }

    // Agrega un elemento al conjunto si no existe previamente
    public void Agregar(int x) {
        // Verifica que x no esté en el conjunto
        if (!this.Pertenece(x)) {
            Nodo aux = new Nodo();
            aux.info = x;
            aux.sig = c;
            c = aux;
        }
    }

    // Devuelve un elemento del conjunto (el primero encontrado)
    public int Elegir() {
        return c.info;
    }

    // Elimina un elemento del conjunto si existe
    public void Sacar(int x) {
        if (c != null) {
            // Si es el primer elemento de la lista
            if (c.info == x) {
                c = c.sig;
            } else {
                Nodo aux = c;
                while (aux.sig != null && aux.sig.info != x) {
                    aux = aux.sig;
                }
                if (aux.sig != null) {
                    aux.sig = aux.sig.sig;
                }
            }
        }
    }

    // Verifica si un elemento pertenece al conjunto
    public boolean Pertenece(int x) {
        Nodo aux = c;
        while (aux != null && aux.info != x) {
            aux = aux.sig;
        }
        return (aux != null);
    }

    public void imprimir(){
        Nodo salto = c;
        while(salto != null){
            System.out.println(salto.info);
            salto = salto.sig;
        }
    }
}
