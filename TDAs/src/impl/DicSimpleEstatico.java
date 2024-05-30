package impl;
import api.ConjuntoTDA;
import api.DiccionarioSimpleTDA;
import impl.ConjuntoEstatico;

public class DicSimpleEstatico implements DiccionarioSimpleTDA {
    // Clase interna para representar un elemento clave-valor
    class Elemento {
        int clave;
        int valor;
    }

    // Arreglo para guardar los elementos
    Elemento[] elementos;
    // Variable para guardar la cantidad de elementos en el diccionario
    int cant;

    // Inicializa el diccionario
    public void InicializarDiccionario() {
        cant = 0;
        elementos = new Elemento[100];
    }

    // Agrega una clave y su valor asociado al diccionario
    public void Agregar(int clave, int valor) {
        int pos = Clave2Indice(clave);
        if (pos == -1) {
            pos = cant;
            elementos[pos] = new Elemento();
            elementos[pos].clave = clave;
            cant++;
        }
        elementos[pos].valor = valor;
    }

    // Busca el índice de una clave en el arreglo de elementos
    private int Clave2Indice(int clave) {
        int i = cant - 1;
        while (i >= 0 && elementos[i].clave != clave) {
            i--;
        }
        return i;
    }

    // Elimina una clave (y su valor asociado) del diccionario
    public void Eliminar(int clave) {
        int pos = Clave2Indice(clave);
        if (pos != -1) {
            elementos[pos] = elementos[cant - 1];
            cant--;
        }
    }

    // Recupera el valor asociado a una clave
    public int Recuperar(int clave) {
        int pos = Clave2Indice(clave);
        if(pos != -1){
            return elementos[pos].valor;
        }
        else{
            return 0;
        }
    }

    // Devuelve un conjunto de todas las claves presentes en el diccionario
    public ConjuntoTDA Claves() {
        ConjuntoTDA c = new ConjuntoEstatico();
        c.InicializarConjunto();
        for (int i = 0; i < cant; i++) {
            c.Agregar(elementos[i].clave);
        }
        return c;
    }
}
