package Pilas;

public class Nodo {
    String URL;
    Nodo siguiente;
    
    public Nodo(String URL){
        this.URL = URL;
        siguiente = null;
    }
}
