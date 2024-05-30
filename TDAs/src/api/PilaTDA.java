package api;

public interface PilaTDA {
    // Método para inicializar la pila
    void InicializarPila();
    
    // Método para apilar un elemento en la pila
    // Precondición: la pila debe estar inicializada
    void Apilar(int x);
    
    // Método para desapilar un elemento de la pila
    // Precondición: la pila debe estar inicializada y no debe estar vacía
    void Desapilar();
    
    // Método para verificar si la pila está vacía
    // Precondición: la pila debe estar inicializada
    boolean PilaVacia();
    
    // Método para obtener el elemento en el tope de la pila
    // Precondición: la pila debe estar inicializada y no debe estar vacía
    int Tope();

    void imprimir();
}
