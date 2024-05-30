package impl;

import api.ColaTDA;
import api.ListaPromediadaTDA;

public class ListaPromediadaDinamica implements ListaPromediadaTDA{

    Nodo ultimo;
    Nodo primero;
    int contador;

    public void inicializar() {
        ultimo = null;
        primero = null;
        contador = 0;
    }

    public void agregar(int valor) {
        Nodo aux = new Nodo();
        aux.info = valor;
        if(primero == null){
            primero = aux;
            ultimo = aux;
        }
        else if (aux.info < promedio()) {
            aux.sig = primero;
            primero = aux;
        }
        else if(aux.info > promedio()){
            ultimo.sig = aux;
            ultimo = aux;
        }
        else if(aux.info == promedio()){
            System.out.println("El promedio es igual al valor ingresado, no se agrega.");
        }
    }

    public void eliminar(int valor) {
        Nodo salto = primero;
        while (salto != null) {
            if (salto.info == valor && salto == primero) {
                primero = primero.sig;
            }
            else if(salto.info == valor && salto == ultimo){
                Nodo subsalto = primero;
                while (subsalto != null) {
                    if (subsalto.sig == ultimo) {
                        ultimo = subsalto;
                        ultimo.sig = null;
                    }
                    subsalto = subsalto.sig;
                }
            }
            else if(salto.info == valor && salto != primero && salto != ultimo){
                Nodo subsalto = primero;
                while (salto != null) {
                    if (salto.sig.info == valor) {
                        salto.sig = salto.sig.sig;
                    }
                    subsalto = subsalto.sig;
                }
            }
            salto = salto.sig;
        }
    }

    public int promedio() {
        Nodo salto = primero;
        int sumador = 0;
        int contador = 0;

        while(salto != null){
            sumador = sumador + salto.info;    
            salto = salto.sig;
            contador = contador + 1;
        }
        return(sumador/contador);
    }

    public ColaTDA menores() {
        ColaTDA men = new ColaDinamica();
        men.InicializarCola();
        Nodo salto = primero;
        while(salto != null){
            if (salto.info < promedio()) {
                men.Acolar(salto.info);
            }
            salto = salto.sig;
        }
        imprimirCola(men);
        return(men);
    }

    public ColaTDA mayores() {
        ColaTDA may = new ColaDinamica();
        may.InicializarCola();
        Nodo salto = primero;
        while(salto != null){
            if (salto.info > promedio()) {
                may.Acolar(salto.info);
            }
            salto = salto.sig;
        }
        imprimirCola(may);
        return(may);
    }

    public boolean estaVacia() {
        return(primero == null);
    }

    public void imprimirLista(){
        Nodo salto = primero;
        while (salto != null) {
            System.out.println(salto.info);
            salto = salto.sig;
        }
    }

    private void imprimirCola(ColaTDA c){
        ColaTDA caux = c;
        while(!caux.ColaVacia()){
            System.out.println(caux.Primero());
            caux.Desacolar();
        }
    }
}
