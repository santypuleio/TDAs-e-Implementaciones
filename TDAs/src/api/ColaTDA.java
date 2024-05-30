package api;

public interface ColaTDA {
    // Método para inicializar la cola
    void InicializarCola();
    
    // Método para agregar un elemento a la cola
    // Precondición: la cola debe estar inicializada
    void Acolar(int x);
    
    // Método para remover el elemento al frente de la cola
    // Precondición: la cola debe estar inicializada y no debe estar vacía
    void Desacolar();
    
    // Método para verificar si la cola está vacía
    // Precondición: la cola debe estar inicializada
    boolean ColaVacia();
    
    // Método para obtener el elemento al frente de la cola
    // Precondición: la cola debe estar inicializada y no debe estar vacía
    int Primero();

    void imprimir();
}

