package impl;

import api.PilaTDA;

public class PilaDinamica implements PilaTDA {
    // Nodo que representa el primer elemento de la pila
    Nodo primero;

    // Inicializa la pila
    public void InicializarPila() {
        primero = null;
    }

    // Apila un elemento en la pila
    public void Apilar(int x) {
        Nodo aux = new Nodo();
        aux.info = x;
        aux.sig = primero;
        primero = aux;
    }

    // Desapila un elemento de la pila
    public void Desapilar() {
        primero = primero.sig;
    }

    // Verifica si la pila está vacía
    public boolean PilaVacia() {
        return (primero == null);
    }

    // Devuelve el valor del tope de la pila
    public int Tope() {
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

