package impl;
import api.PilaTDA;

public class PilaEstatica implements PilaTDA {
    // Arreglo en donde se guarda la información
    int[] a;
    // Variable entera en donde se guarda la cantidad de elementos que se tienen guardados
    int indice;

    // Inicializa la pila
    public void InicializarPila() {
        a = new int[100];
        indice = 0;
    }

    // Apila un elemento en la pila
    public void Apilar(int x) {
        a[indice] = x;
        indice++;
    }

    // Desapila el elemento en el tope de la pila
    public void Desapilar() {
        indice--;
    }

    // Verifica si la pila está vacía
    public boolean PilaVacia() {
        return (indice == 0);
    }

    // Devuelve el elemento en el tope de la pila
    public int Tope() {
        return a[indice - 1];
    }

    public void imprimir(){
        for(int i = 0; i < indice; i++){
            System.out.println(a[i]);
        }
    }
}
