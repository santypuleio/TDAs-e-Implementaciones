package api;
public interface ListaPromediadaTDA {
    void inicializar();
    void agregar(int valor);
    void eliminar(int valor);
    int promedio();
    ColaTDA menores();
    ColaTDA mayores();
    boolean estaVacia();
    void imprimirLista();
}
