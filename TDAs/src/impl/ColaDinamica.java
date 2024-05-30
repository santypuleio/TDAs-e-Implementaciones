package impl;

import api.ColaTDA;

public class ColaDinamica implements ColaTDA {
    // Primer elemento en la cola
    Nodo primero;
    // Último elemento en la cola, es decir, el último agregado
    Nodo ultimo;

    // Inicializa la cola
    public void InicializarCola() {
        primero = null;
        ultimo = null;
    }

    // Agrega un elemento al final de la cola
    public void Acolar(int x) {
        Nodo aux = new Nodo();
        aux.info = x;
        aux.sig = null;
        // Si la cola no está vacía
        if (ultimo != null)
            ultimo.sig = aux;
        ultimo = aux;
        // Si la cola estaba vacía
        if (primero == null)
            primero = ultimo;
    }

    // Elimina el primer elemento de la cola
    public void Desacolar() {
        primero = primero.sig;
        // Si la cola queda vacía
        if (primero == null)
            ultimo = null;
    }

    // Verifica si la cola está vacía
    public boolean ColaVacia() {
        return (ultimo == null);
    }

    // Devuelve el valor del primer elemento de la cola
    public int Primero() {
        return primero.info;
    }

    public void imprimir(){
        Nodo salto = primero;
        while (salto != null) {
            System.out.println(salto.info);
            salto = salto.sig;
        }
    }
}
