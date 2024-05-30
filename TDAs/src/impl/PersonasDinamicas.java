package impl;

import api.PersonasTDA;

public class PersonasDinamicas implements PersonasTDA{

    NodoPersona primero;
    NodoPersona ultimo;

    public void inicializar() {
        primero = null;
        ultimo = null;
    }

    public void eliminarID(int id) {
        NodoPersona salto = primero;
        if(primero == null){
            System.out.println("No hay personas por eliminar.");
        }
        else if(primero.id == id){
            if(primero.sig != null){
                primero = primero.sig;
                System.out.println("Alumno eliminado con éxito.");
            }
            else{
                primero = null;
                ultimo = null;
                System.out.println("Alumno eliminado con éxito.");
            }
        }
        else if(ultimo.id == id){
            while (salto!=null) {
                if (salto.sig == ultimo) {
                    ultimo = salto;
                    System.out.println("Alumno eliminado con éxito.");
                }
                else{
                    salto = salto.sig;
                }
            }
        }
        else if(salto.id == id && salto != primero && salto != ultimo){
            while (salto != null) {
                if (salto.sig.id == id) {
                    salto.sig = salto.sig.sig;
                    System.out.println("Alumno eliminado con éxito.");
                }
                else{
                    salto = salto.sig;
                }
            }
        }
    }

    public void eliminarNota(int id, int nota) {
        NodoPersona salto = primero;
        while (salto != null) {
            if(salto.id == id){
                for(int i = 0; i<=salto.contadorNotas; i ++){
                    //si es el primero:
                    if(salto.notas[i] == nota && i == 0){
                        for(int n = i; n<salto.contadorNotas; n++){
                            salto.notas[n] = salto.notas[n+1];
                        }
                        salto.contadorNotas = salto.contadorNotas - 1;
                    }
                    //si es el ultimo:
                    else if(salto.notas[i] == nota && i == salto.contadorNotas){
                        salto.contadorNotas = salto.contadorNotas - 1;
                    }
                    //si esta en el medio:
                    else if(salto.notas[i] == nota && i != 0 && i != salto.contadorNotas){
                        for(int n = i; n<salto.contadorNotas; n++){
                            salto.notas[n] = salto.notas[n+1];
                        }
                        salto.contadorNotas = salto.contadorNotas - 1;
                    }
                }
            }
            salto = salto.sig;
        }
    }

    public void cargarNota(int id, int nota) {
        NodoPersona salto = primero;
        
        while (salto != null) {
            if(salto.id == id){
                if (salto.contadorNotas == 0) {
                    salto.notas = new int[100];
                    salto.notas[0] = nota;
                    salto.contadorNotas = salto.contadorNotas + 1;
                }
                else{
                    salto.notas[salto.contadorNotas + 1] = nota;
                    salto.contadorNotas = salto.contadorNotas + 1;
                }
            }
            salto = salto.sig;
        }
    }

    public void verNotas(int id) {
        NodoPersona salto = primero;
        if (salto == null) {
            System.out.println("No hay usuarios ingresados aun.");
        }
        while (salto != null) {
            if(salto.id == id){
                for(int i = 0; i<=salto.contadorNotas; i ++){
                    if (salto.notas[i] != 0) {
                        System.out.println("Nota del alumno " + id + " = " + salto.notas[i]);    
                    }
                }
                break;
            }

            if (salto == ultimo && salto.id != id) {
                System.out.println("El id ingresado no existe.");
            }
            salto = salto.sig;
        }
    }

    public boolean aprobo(int id) {
        NodoPersona salto = primero;
        System.out.println(salto.id);
        int sumadorNotas = 0;
        int promedio = 0;
        while (salto != null) {
            if(salto.id == id){
                int notasAlumno [] = salto.notas;
                for(int i = 0; i<=salto.contadorNotas; i ++){
                    sumadorNotas = sumadorNotas + notasAlumno[i]; 
                }
                promedio = sumadorNotas / salto.contadorNotas;
                return(promedio>=4);
            }
            salto = salto.sig;
        }
        return(promedio>=4);
    }

    public void cargarPersona(int id){
        NodoPersona aux = new NodoPersona();
        aux.id = id;
        if (primero == null) {
            primero = aux;
            ultimo = aux;
        }
        else{
            NodoPersona salto = primero;
            
            while (salto != null) {
                if(salto.id == id){
                    System.out.println("El usuario que intenta cargar ya existe.");
                }
                else{
                    if (salto == ultimo && salto.id != id) {
                        ultimo.sig = aux;
                        ultimo = aux;
                        System.out.println("Usuario ingresado con exito.");
                        break;
                    }
                }
                salto = salto.sig;
            }
        }
        
    }
}
