package api;

public interface DiccionarioSimpleTDA {
    // Método para inicializar el diccionario
    void InicializarDiccionario();
    
    // Método para agregar una clave y su valor asociado al diccionario
    // Precondición: el diccionario debe estar inicializado
    void Agregar(int clave, int valor);
    
    // Método para eliminar una clave (y su valor asociado) del diccionario
    // Precondición: el diccionario debe estar inicializado
    void Eliminar(int clave);
    
    // Método para recuperar el valor asociado a una clave
    // Precondición: el diccionario debe estar inicializado y la clave debe existir en el diccionario
    int Recuperar(int clave);
    
    // Método para obtener un conjunto de todas las claves presentes en el diccionario
    // Precondición: el diccionario debe estar inicializado
    ConjuntoTDA Claves();

}

