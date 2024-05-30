package api;

public interface DiccionarioMultipleTDA {
    // Método para inicializar el diccionario
    void InicializarDiccionario();
    
    // Método para agregar una clave y su valor asociado al diccionario
    // Precondición: el diccionario debe estar inicializado
    void Agregar(int clave, int valor);
    
    // Método para eliminar una clave (y todos sus valores asociados) del diccionario
    // Precondición: el diccionario debe estar inicializado
    void Eliminar(int clave);
    
    // Método para eliminar un valor específico asociado a una clave del diccionario
    // Precondición: el diccionario debe estar inicializado
    void EliminarValor(int clave, int valor);
    
    // Método para recuperar un conjunto de valores asociados a una clave
    // Precondición: el diccionario debe estar inicializado
    ConjuntoTDA Recuperar(int clave);
    
    // Método para obtener un conjunto de todas las claves presentes en el diccionario
    // Precondición: el diccionario debe estar inicializado
    ConjuntoTDA Claves();
}
