package Colas;
import javax.swing.JOptionPane;

public class Cola {
    
    private Nodo primero, ultimo;
    String cola = "";
    private int tamano;
    
    public Cola(){
        
    }
    
    
    //Verificar si la Cola no tiene nodos
    public boolean colaVacia(){
        if (tamano == 0){//primero == null
            return true;
        }
        return false;   
    }
    
   //Anadir un nodo al ultimo
    public void add(String dato){        
        Nodo nuevo = new Nodo(dato);
        if(colaVacia()){
            primero = nuevo;
            ultimo = nuevo;
        } else {
            //nuevo.Siguiente = ultimo;
            //ultimo = nuevo;
            ultimo.Siguiente = nuevo;
            ultimo = nuevo;
        }
        tamano++;
    }
    
    //Método para extraer de la cola
    public String extraer(){
        String nombre = primero.Informacion;
        if(colaVacia()){
            return null;
        } else if (tamano == 1){//primero == ultimo
            primero = null;
            ultimo = null;
                
        }else{//el segundo en la Cola pasa a ser el primero
            primero = primero.Siguiente;
        }
        tamano--;
        return nombre;
    }
    
    //Método para imprimir el contenido de la Cola
    public void imprimirCola(){
        Nodo recorrido = primero;
        String colaInvertida;
        while (recorrido != null){
            cola += recorrido.Informacion + " ";
            recorrido = recorrido.Siguiente;
        }
        String cadena [] = cola.split(" ");
        
        colaInvertida = "|| Cola del Banco ||\n";
        for(int i = cadena.length-1; i >= 0 ;i--){
            colaInvertida += "->" + cadena[i];
        }
        
        JOptionPane.showMessageDialog(null,colaInvertida);
        cola = "";
    }
    
    //Método que regresa el tamano de la Cola
    public int size(){
        return tamano;
    }
    
}
