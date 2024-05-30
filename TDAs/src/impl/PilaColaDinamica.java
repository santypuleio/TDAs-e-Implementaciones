package impl;

import api.PilaColaTDA;

public class PilaColaDinamica implements PilaColaTDA{

    Nodo primero;
    Nodo ultimo;
    int contador;

    public void inicializar() {
        primero = null;
        ultimo = null;
        contador = 0;
    }

    public int contadorElementos(){
        Nodo salto = primero;
        int contadorNodos = 0;
        if (primero == null) {
            return(0);
        }
        else{
            while (salto != null) {
                contadorNodos = contadorNodos + 1;
                salto = salto.sig;
            }
            return(contadorNodos);
        }
    }

    public void agregar(int x) {
        Nodo aux = new Nodo();
        aux.info = x;

        if (primero == null) {
            primero = aux;
            ultimo = aux;
        }
        else{
            if (contadorElementos() > 10) {
                //pila
                aux.sig = primero;
                primero = aux;
            }
            else if(contadorElementos() <= 10){
                //cola
                ultimo.sig = aux;
                ultimo = aux;
            }
        }
    }

    public void eliminar() {
        if (contadorElementos() > 10) {
            //pila
            Nodo salto = primero;
            while (salto != null) {
                if(salto.sig == ultimo){
                    ultimo = salto;
                    ultimo.sig = null;
                }
                salto = salto.sig;
            }
        }
        else if(contadorElementos() <= 10){
            //cola
            primero = primero.sig;
        }
    }

    public int topeOprimero() {
        int valor = 0;
        if (contadorElementos() > 10) {
            //pila
            valor = ultimo.info;
        }
        else if(contadorElementos() <= 10){
            //cola
            valor = primero.info;
        }
        return(valor);
    }

    public void imprimirPilaCola() {
        Nodo salto = primero;
        while(salto != null){
            System.out.println(salto.info);
            salto = salto.sig;
        }
    }

    public boolean estaVacia() {
        return(primero == null);
    }
}
