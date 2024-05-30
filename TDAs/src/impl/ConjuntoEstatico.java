package impl;

import api.ConjuntoTDA;

public class ConjuntoEstatico implements ConjuntoTDA {
    // Arreglo para almacenar los elementos del conjunto
    int[] a;
    // Variable para guardar la cantidad de elementos en el conjunto
    int cant;

    // Agrega un elemento al conjunto si no está presente
    public void Agregar(int x) {
        if (!this.Pertenece(x)) {
            a[cant] = x;
            cant++;
        }
    }

    // Verifica si el conjunto está vacío
    public boolean ConjuntoVacio() {
        return cant == 0;
    }

    // Devuelve un elemento arbitrario del conjunto
    public int Elegir() {
        return a[cant - 1];
    }

    // Inicializa el conjunto
    public void InicializarConjunto() {
        a = new int[100];
        cant = 0;
    }

    // Verifica si un elemento pertenece al conjunto
    public boolean Pertenece(int x) {
        int i = 0;
        while (i < cant && a[i] != x) {
            i++;
        }
        return (i < cant);
    }

    // Elimina un elemento del conjunto
    public void Sacar(int x) {
        int i = 0;
        while (i < cant && a[i] != x) {
            i++;
        }
        if (i < cant) {
            a[i] = a[cant - 1];
            cant--;
        }
    }

    public void imprimir(){
        for(int i = 0; i < cant; i++){
            System.out.println(a[i]);
        }
    }
}

