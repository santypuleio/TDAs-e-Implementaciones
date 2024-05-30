package api;

public interface ConjuntoTDA {
    // Método para inicializar el conjunto
    void InicializarConjunto();
    
    // Método para verificar si el conjunto está vacío
    // Precondición: el conjunto debe estar inicializado
    boolean ConjuntoVacio();
    
    // Método para agregar un elemento al conjunto
    // Precondición: el conjunto debe estar inicializado
    void Agregar(int x);
    
    // Método para elegir un elemento del conjunto
    // Precondición: el conjunto debe estar inicializado y no debe estar vacío
    int Elegir();
    
    // Método para remover un elemento del conjunto
    // Precondición: el conjunto debe estar inicializado
    void Sacar(int x);
    
    // Método para verificar si un elemento pertenece al conjunto
    // Precondición: el conjunto debe estar inicializado
    boolean Pertenece(int x);

    void imprimir();
}
