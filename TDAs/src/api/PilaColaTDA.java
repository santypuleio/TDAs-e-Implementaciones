package api;

public interface PilaColaTDA {
    void inicializar();
    int contadorElementos();
    void agregar(int x);
    void eliminar();
    int topeOprimero();
    void imprimirPilaCola();
    boolean estaVacia();
}
