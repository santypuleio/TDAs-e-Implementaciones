package impl;

import api.DiccionarioMultipleTDA;
import api.ConjuntoTDA;

public class DicMultipleDinamico implements DiccionarioMultipleTDA {
    // Clase interna que representa un nodo de clave
    class NodoClave {
        int clave;
        NodoValor valores;
        NodoClave sigClave;
    }

    // Clase interna que representa un nodo de valor
    class NodoValor {
        int valor;
        NodoValor sigValor;
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
        NodoValor aux = nc.valores;
        while (aux != null && aux.valor != valor) {
            aux = aux.sigValor;
        }
        if (aux == null) {
            NodoValor nv = new NodoValor();
            nv.valor = valor;
            nv.sigValor = nc.valores;
            nc.valores = nv;
        }
    }

    // Elimina un valor asociado a una clave del diccionario
    public void EliminarValor(int clave, int valor) {
        if (origen != null) {
            if (origen.clave == clave) {
                EliminarValorEnNodo(origen, valor);
                if (origen.valores == null) {
                    origen = origen.sigClave;
                }
            } else {
                NodoClave aux = origen;
                while (aux.sigClave != null && aux.sigClave.clave != clave) {
                    aux = aux.sigClave;
                }
                if (aux.sigClave != null) {
                    EliminarValorEnNodo(aux.sigClave, valor);
                    if (aux.sigClave.valores == null) {
                        aux.sigClave = aux.sigClave.sigClave;
                    }
                }
            }
        }
    }

    // Elimina un valor de un nodo clave
    private void EliminarValorEnNodo(NodoClave nodo, int valor) {
        if (nodo.valores != null) {
            if (nodo.valores.valor == valor) {
                nodo.valores = nodo.valores.sigValor;
            } else {
                NodoValor aux = nodo.valores;
                while (aux.sigValor != null && aux.sigValor.valor != valor) {
                    aux = aux.sigValor;
                }
                if (aux.sigValor != null) {
                    aux.sigValor = aux.sigValor.sigValor;
                }
            }
        }
    }

    // Elimina una clave y todos sus valores asociados del diccionario
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

    // Recupera todos los valores asociados a una clave
    public ConjuntoTDA Recuperar(int clave) {
        NodoClave n = Clave2NodoClave(clave);
        ConjuntoTDA c = new ConjuntoDinamico();
        c.InicializarConjunto();
        if (n != null) {
            NodoValor aux = n.valores;
            while (aux != null) {
                c.Agregar(aux.valor);
                aux = aux.sigValor;
            }
        }
        return c;
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

