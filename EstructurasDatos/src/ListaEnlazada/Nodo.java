 package ListaEnlazada;

/* @author alejo*/
public class Nodo {
    private String Dato = "";
    Nodo EnlaceNodo;

    public Nodo() {
        this.Dato = "";
        this.EnlaceNodo = null;
    }
    public Nodo(String Dato) { 
        this.Dato = Dato;
        this.EnlaceNodo = null;
        
    }
    
    public void setDato(String dato){
        this.Dato = dato;
    }
    public String getDato(){
        return Dato;
    }
    
}
