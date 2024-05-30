package impl;

import api.ColaPrioridadTDA;

public class ColaPrioridadEstatica implements ColaPrioridadTDA {
    // Arreglos para guardar los elementos y sus prioridades
    int[] elementos;
    int[] prioridades;
    // Variable entera para guardar la cantidad de elementos en la cola
    int indice;

    // Inicializa la cola de prioridad
    public void InicializarCola() {
        indice = 0;
        elementos = new int[100];
        prioridades = new int[100];
    }

    // Agrega un elemento con una prioridad específica a la cola
    public void AcolarPrioridad(int x, int prioridad) {
        // Desplaza los elementos a la derecha mientras su prioridad sea mayor o igual a la de x
        int j = indice;
        for (; j > 0 && prioridades[j - 1] >= prioridad; j--) {
            elementos[j] = elementos[j - 1];
            prioridades[j] = prioridades[j - 1];
        }
        elementos[j] = x;
        prioridades[j] = prioridad;
        indice++;
    }

    // Remueve el elemento con la mayor prioridad de la cola
    public void Desacolar() {
        indice--;
    }

    // Devuelve el elemento con la mayor prioridad de la cola
    public int Primero() {
        return elementos[indice - 1];
    }

    // Verifica si la cola está vacía
    public boolean ColaVacia() {
        return (indice == 0);
    }

    // Devuelve la prioridad del elemento con la mayor prioridad de la cola
    public int Prioridad() {
        return prioridades[indice - 1];
    }
}
