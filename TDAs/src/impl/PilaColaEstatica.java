package impl;

import api.PilaColaTDA;

public class PilaColaEstatica implements PilaColaTDA{

    int[] vector;
    int contador;

    public void inicializar() {
        vector = new int[100];
        contador = 0;
    }

    public int contadorElementos() {
        return(contador);
    }

    public void agregar(int x) {
        int siguiente = 0;
        if (contador > 10) {
            //pila
            for(int i = 0; i<=contador; i++){
                if(i == 0){
                    siguiente = vector[0];
                    vector[0] = x;
                }
                else{
                    int valor = vector[i];
                    vector[i] = siguiente;
                    siguiente = valor;
                }
            }
        }
        else if(contador <= 10){
            //cola
            vector[contador] = x;
        }
        contador = contador + 1;
        
    }

    public void eliminar() {
        if (contador > 10) {
            //pila
            contador = contador - 1;
        }
        else if(contador <= 10){
            //cola
            for(int i = 0; i<contador; i++){
                int siguiente = vector[i+1];
                vector[i] = siguiente;
            }
        }
        contador = contador - 1;
    }

    public int topeOprimero() {
        int elemento = 0;
        if (contador > 10) {
            //pila
            elemento = vector[contador];
            
        }
        else if(contador <= 10){
            //cola
            elemento = vector[0];
        }
        return(elemento);
    }

    public void imprimirPilaCola() {
        for(int i = 0; i <= contador; i++){
            System.out.println(vector[i]);
        }
    }

    public boolean estaVacia() {
        return(contador == 0);
    }
}
