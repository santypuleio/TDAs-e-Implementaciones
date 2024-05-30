package api;

public interface ColaPrioridadTDA {
    // Método para inicializar la cola
    void InicializarCola();
    
    // Método para agregar un elemento con una prioridad específica a la cola
    // Precondición: la cola debe estar inicializada
    void AcolarPrioridad(int x, int prioridad);
    
    // Método para remover el elemento de mayor prioridad de la cola
    // Precondición: la cola debe estar inicializada y no debe estar vacía
    void Desacolar();
    
    // Método para obtener el elemento de mayor prioridad de la cola sin removerlo
    // Precondición: la cola debe estar inicializada y no debe estar vacía
    int Primero();
    
    // Método para verificar si la cola está vacía
    // Precondición: la cola debe estar inicializada
    boolean ColaVacia();
    
    // Método para obtener la prioridad del elemento al frente de la cola sin removerlo
    // Precondición: la cola debe estar inicializada y no debe estar vacía
    int Prioridad();
}
