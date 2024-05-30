package impl;

import api.ColaTDA;

public class ColaEstatica implements ColaTDA {
    // Arreglo en donde se guarda la información
    int[] a;
    // Variable entera en donde se guarda la cantidad de elementos que se tienen guardados
    int indice;

    // Inicializa la cola
    public void InicializarCola() {
        a = new int[100];
        indice = 0;
    }

    // Agrega un elemento al final de la cola
    public void Acolar(int x) {
        // Desplaza todos los elementos hacia la derecha
        for (int i = indice - 1; i >= 0; i--) {
            a[i + 1] = a[i];
        }
        // Coloca el nuevo elemento en la primera posición
        a[0] = x;
        indice++;
    }

    // Remueve el primer elemento de la cola
    public void Desacolar() {
        indice--;
    }

    // Verifica si la cola está vacía
    public boolean ColaVacia() {
        return (indice == 0);
    }

    // Devuelve el primer elemento de la cola
    public int Primero() {
        return a[indice - 1];
    }

    public void imprimir(){
        for(int i = 0; i< indice; i++){
            System.out.println(a[i]);
        }
    }
}
