 package ListaEnlazada;

/* @author alejo*/
public class Node {
    private String Dato = "";
    Node Siguiente;

    public Node() {
        this.Dato = "";
        this.Siguiente = null;
    }
    public Node(String Dato) { 
        this.Dato = Dato;
        this.Siguiente = null;
        
    }
    
    public void setDato(String dato){
        this.Dato = dato;
    }
    public String getDato(){
        return Dato;
    }
    
}
