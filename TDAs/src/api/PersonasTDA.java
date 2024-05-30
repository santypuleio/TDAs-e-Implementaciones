package api;

public interface PersonasTDA {
    void inicializar();
    void eliminarID(int id);
    void eliminarNota(int id, int nota);
    void cargarNota(int id, int nota);
    void cargarPersona(int id);
    void verNotas(int id);
    boolean aprobo(int id);
}