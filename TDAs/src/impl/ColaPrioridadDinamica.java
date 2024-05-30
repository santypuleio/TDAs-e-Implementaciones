package impl;

import api.ColaPrioridadTDA;

public class ColaPrioridadDinamica implements ColaPrioridadTDA {
    // Nodo que representa el elemento de mayor prioridad en la cola
    NodoPrioridad mayorPrioridad;

    // Inicializa la cola de prioridad
    public void InicializarCola() {
        mayorPrioridad = null;
    }

    // Agrega un elemento a la cola de prioridad con su respectiva prioridad
    public void AcolarPrioridad(int x, int prioridad) {
        // Crear un nuevo nodo para el elemento a acolar
        NodoPrioridad nuevo = new NodoPrioridad();
        nuevo.info = x;
        nuevo.prioridad = prioridad;

        // Si la cola está vacía o el nuevo elemento tiene mayor prioridad que el primero
        if (mayorPrioridad == null || prioridad > mayorPrioridad.prioridad) {
            nuevo.sig = mayorPrioridad;
            mayorPrioridad = nuevo;
        } else {
            // Buscar la posición adecuada para insertar el nuevo elemento
            NodoPrioridad aux = mayorPrioridad;
            while (aux.sig != null && aux.sig.prioridad >= prioridad) {
                aux = aux.sig;
            }
            nuevo.sig = aux.sig;
            aux.sig = nuevo;
        }
    }

    // Elimina el primer elemento de la cola de prioridad
    public void Desacolar() {
        mayorPrioridad = mayorPrioridad.sig;
    }

    // Devuelve el valor del primer elemento de la cola de prioridad
    public int Primero() {
        return mayorPrioridad.info;
    }

    // Verifica si la cola de prioridad está vacía
    public boolean ColaVacia() {
        return (mayorPrioridad == null);
    }

    // Devuelve la prioridad del primer elemento de la cola de prioridad
    public int Prioridad() {
        return mayorPrioridad.prioridad;
    }
}
