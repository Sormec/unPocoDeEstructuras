package ListaEnlazada;
import javax.swing.JOptionPane;

/*@author alejo*/
public class ListaEnlazada {
    
    private int tamano;
    private Nodo cabeza;
    private Nodo fin;
    String lista = "";
    
    public ListaEnlazada(){
        cabeza = null;
        fin = null;
        tamano = 0;
    }
    
    
    //Verificar si lista no tiene nodos
    public boolean listaVacia(){
        boolean flag = false;
        if (tamano == 0){
            flag = true;
        }
        return flag;   
    }
    
    //Anadir nodo al inicio
    public void addPrimero(String dato){
        Nodo nuevo;
        if (listaVacia()){
            cabeza = new Nodo(dato);
            fin = cabeza;
        }else{
            nuevo = new Nodo(dato);
            nuevo.EnlaceNodo = cabeza;
            cabeza = nuevo;//identificar cabeza como primer nodo            
        }
        tamano++;
    }
    
    //Anadir un nodo al ultimo
    public void addUltimo(String dato){        
        Nodo puntero, nuevo;
        if(listaVacia()){
            JOptionPane.showMessageDialog(null,"La Libreria esta vacia,\n"
                    + "no se guardo el libro");
        } else {
            puntero = fin;
            nuevo = new Nodo(dato);        
            puntero.EnlaceNodo = nuevo;        
            fin = nuevo;
            tamano++;
        }
    }
    
    //Anadir nodo en un lugar especifico
    public void addLugar(int posicion, String dato){
        Nodo nuevo, temporal;
        int contador = 1;
        if (listaVacia()){
            addPrimero(dato);
        }else if (tamano == posicion){
            addUltimo(dato);
        }else{
            nuevo = new Nodo(dato);
            temporal = cabeza;
            while( contador < posicion){
                temporal = temporal.EnlaceNodo;
                contador++;
            }//el nuevo nodo apuntara done apunta temporal
            nuevo.EnlaceNodo = temporal.EnlaceNodo;
            temporal.EnlaceNodo = nuevo;//temporal apuntara al nuevo nodo
            tamano++;
        }
    }
    
    //Metodo para enlazar al siguiente nodo
    public void enlazarSig(Nodo a, Nodo b){
        a.EnlaceNodo = b;
        tamano++;
    }
    
    //Meotodo para eliminar un nodo
    public String eliminarNodo(int posicion){
        int contador = 1;//si quiero q se elimine desde 0, pongo 0 aqui
        Nodo eliminar = cabeza;
        Nodo temporal = new Nodo();
        if (listaVacia()){
            JOptionPane.showMessageDialog(null,"La Libreria esta vacia");
        } else if (posicion == 1){//se podra eliminar desde 1er libro
            //el siguiente sera la nueva cabeza || eliminar.EnlaceNodo
            cabeza = cabeza.EnlaceNodo;
            eliminar.EnlaceNodo = null;
            temporal = eliminar;//para retornar el valor eliminado
        }else{
            while( contador < posicion-1 ){
                eliminar = eliminar.EnlaceNodo;
                contador++;
            } 
            //temporal estara en el nodo q se eliminara
            temporal = eliminar.EnlaceNodo;
            //eliminar apuntara al siguiente nodo, del nodo q se va a eliminar
            eliminar.EnlaceNodo = temporal.EnlaceNodo;
            temporal.EnlaceNodo = null;
        }
        tamano--;
        return temporal.getDato();
    }
    
    //Método para vaciar la Lista
    public void vaciarLista(){
        Nodo eliminar = cabeza;
        Nodo temporal;
        while (!listaVacia()){//loop hasta que la pila este vacia
            cabeza = cabeza.EnlaceNodo;//1->2
            temporal = eliminar;//temporal estara en el nodo q se eliminara
            eliminar = eliminar.EnlaceNodo;//se adelantara al otro nodo 
            temporal.EnlaceNodo = null;//el nodo a eliminar apunta a tierra
            tamano--;
        }
    }
    
    //Regresa el dato del index/lugar indicado
    public String obtenerDato(int index){
        int contador = 1;
        Nodo temporal = cabeza;
        while (contador < index){
            temporal = temporal.EnlaceNodo;
            contador++;
        }
        return temporal.getDato();
    }
    //Método para cortar lista y hacerla pequeña
    public void cortarLista(int index){
        int contador = 1;//se puede cortar desde 1ro
        Nodo temporal = cabeza;
        if(index <= tamano){
            while(contador < index){
                temporal = temporal.EnlaceNodo;
                contador++;
            }//apuntara a tierra para cortar la lista
            temporal.EnlaceNodo = null;
            tamano = index;
        }else{
            JOptionPane.showMessageDialog(null,"El tamano exede"
                    + "a los libros en la Libreria, intente de nuevo");
        }
    }
    
    //Metodo para imprimir una lista acedendente
    public void imprimirLista (){
        Nodo recorrido = cabeza;//apunta al primer nodo
        lista = " | "+"";
        while (recorrido != null){
            lista += recorrido.getDato() + " | ";//concatena cada dato
            recorrido = recorrido.EnlaceNodo;
        }
        JOptionPane.showMessageDialog(null,"||Libreria de Alejo||\n" + lista);
        lista = "";
    }
    
    //Regresa el valor del tamano actual de la lista
    public int size(){
        return tamano;
    }
    
}
