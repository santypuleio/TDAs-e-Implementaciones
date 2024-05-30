package impl;

import api.DiccionarioSimpleTDA;
import api.ConjuntoTDA;

public class DicSimpleDinamico implements DiccionarioSimpleTDA {
    // Clase interna que representa un nodo de clave-valor
    class NodoClave {
        int clave;
        int valor;
        NodoClave sigClave;
    }

    NodoClave origen;

    // Inicializa el diccionario
    public void InicializarDiccionario() {
        origen = null;
    }

    // Agrega un par clave-valor al diccionario
    public void Agregar(int clave, int valor) {
        NodoClave nc = Clave2NodoClave(clave);
        if (nc == null) {
            nc = new NodoClave();
            nc.clave = clave;
            nc.sigClave = origen;
            origen = nc;
        }
        nc.valor = valor;
    }

    // Elimina una clave y su valor asociado del diccionario
    public void Eliminar(int clave) {
        if (origen != null) {
            if (origen.clave == clave) {
                origen = origen.sigClave;
            } else {
                NodoClave aux = origen;
                while (aux.sigClave != null && aux.sigClave.clave != clave) {
                    aux = aux.sigClave;
                }
                if (aux.sigClave != null) {
                    aux.sigClave = aux.sigClave.sigClave;
                }
            }
        }
    }

    // Recupera el valor asociado a una clave
    public int Recuperar(int clave) {
        NodoClave n = Clave2NodoClave(clave);
        return (n != null) ? n.valor : 0;
    }

    // Devuelve un conjunto con todas las claves del diccionario
    public ConjuntoTDA Claves() {
        ConjuntoTDA c = new ConjuntoDinamico();
        c.InicializarConjunto();
        NodoClave aux = origen;
        while (aux != null) {
            c.Agregar(aux.clave);
            aux = aux.sigClave;
        }
        return c;
    }

    // Método privado que busca un nodo clave dado su valor
    private NodoClave Clave2NodoClave(int clave) {
        NodoClave aux = origen;
        while (aux != null && aux.clave != clave) {
            aux = aux.sigClave;
        }
        return aux;
    }

}
