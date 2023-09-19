package ListaEnlazada;
import javax.swing.JOptionPane;

/*@author alejo*/
public class ListaEnlazada {
    
    private int tamano;
    private Node cabeza;
    private Node fin;
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
        Node nuevo;
        if (listaVacia()){
            cabeza = new Node(dato);
            fin = cabeza;
        }else{
            nuevo = new Node(dato);
            nuevo.Siguiente = cabeza;
            cabeza = nuevo;//identificar cabeza como primer nodo            
        }
        tamano++;
    }
    
    //Anadir un nodo al ultimo
    public void addUltimo(String dato){        
        Node puntero, nuevo;
        if(listaVacia()){
            JOptionPane.showMessageDialog(null,"La Libreria esta vacia,\n"
                    + "no se guardo el libro");
        } else {
            puntero = fin;
            nuevo = new Node(dato);        
            puntero.Siguiente = nuevo;        
            fin = nuevo;
            tamano++;
        }
    }
    
    //Anadir nodo en un lugar especifico
    public void addLugar(int posicion, String dato){
        Node nuevo, temporal;
        int contador = 1;
        if (listaVacia()){
            addPrimero(dato);
        }else if (tamano == posicion){
            addUltimo(dato);
        }else{
            nuevo = new Node(dato);
            temporal = cabeza;
            while( contador < posicion){
                temporal = temporal.Siguiente;
                contador++;
            }//el nuevo nodo apuntara done apunta temporal
            nuevo.Siguiente = temporal.Siguiente;
            temporal.Siguiente = nuevo;//temporal apuntara al nuevo nodo
            tamano++;
        }
    }
    
    //Metodo para enlazar al siguiente nodo
    public void enlazarSig(Node a, Node b){
        a.Siguiente = b;
        tamano++;
    }
    
    //Meotodo para eliminar un nodo
    public String eliminarNodo(int posicion){
        int contador = 1;//si quiero q se elimine desde 0, pongo 0 aqui
        Node eliminar = cabeza;
        Node temporal = new Node();
        if (listaVacia()){
            JOptionPane.showMessageDialog(null,"La Libreria esta vacia");
        } else if (posicion == 1){//se podra eliminar desde 1er libro
            //el siguiente sera la nueva cabeza || eliminar.Siguiente
            cabeza = cabeza.Siguiente;
            eliminar.Siguiente = null;
            temporal = eliminar;//para retornar el valor eliminado
        }else{
            while( contador < posicion-1 ){
                eliminar = eliminar.Siguiente;
                contador++;
            } 
            //temporal estara en el nodo q se eliminara
            temporal = eliminar.Siguiente;
            //eliminar apuntara al siguiente nodo, del nodo q se va a eliminar
            eliminar.Siguiente = temporal.Siguiente;
            temporal.Siguiente = null;
        }
        tamano--;
        return temporal.getDato();
    }
    
    //Método para vaciar la Lista
    public void vaciarLista(){
        Node eliminar = cabeza;
        Node temporal;
        while (!listaVacia()){//loop hasta que la pila este vacia
            cabeza = cabeza.Siguiente;//1->2
            temporal = eliminar;//temporal estara en el nodo q se eliminara
            eliminar = eliminar.Siguiente;//se adelantara al otro nodo 
            temporal.Siguiente = null;//el nodo a eliminar apunta a tierra
            tamano--;
        }
    }
    
    //Regresa el dato del index/lugar indicado
    public String obtenerDato(int index){
        int contador = 1;
        Node temporal = cabeza;
        while (contador < index){
            temporal = temporal.Siguiente;
            contador++;
        }
        return temporal.getDato();
    }
    //Método para cortar lista y hacerla pequeña
    public void cortarLista(int index){
        int contador = 1;//se puede cortar desde 1ro
        Node temporal = cabeza;
        if(index <= tamano){
            while(contador < index){
                temporal = temporal.Siguiente;
                contador++;
            }//apuntara a tierra para cortar la lista
            temporal.Siguiente = null;
            tamano = index;
        }else{
            JOptionPane.showMessageDialog(null,"El tamano exede"
                    + "a los libros en la Libreria, intente de nuevo");
        }
    }
    
    //Metodo para imprimir una lista acedendente
    public void imprimirLista (){
        Node recorrido = cabeza;//apunta al primer nodo
        lista = " | "+"";
        while (recorrido != null){
            lista += recorrido.getDato() + " | ";//concatena cada dato
            recorrido = recorrido.Siguiente;
        }
        JOptionPane.showMessageDialog(null,"||Libreria de Alejo||\n" + lista);
        lista = "";
    }
    
    //Regresa el valor del tamano actual de la lista
    public int size(){
        return tamano;
    }
    //Metodo para identificar el ultimo nodo
//    public Node vUltimoNodo (Node A, Node B, Node C, Node D){
//          Node ultimo = A;
//          if(ultimo.Siguiente == null){
//                    return ultimo;
//          }
//          do{
//                    ultimo = ultimo.Siguiente;
//                    System.out.println("metodo ultimo>"+ultimo.Dato);
//          }while(ultimo.Siguiente != null);
//          return ultimo;
//    }
    //Metodo para imprimir una lista descendente 
//    public void imprimirListaInversa (Node pFinal){
//          Node x = pFinal;//apunta al ultimo nodo
//          System.out.println("Lista de Datos a la Inversa");
//          while(x != null){
//                    System.out.println("-->"+x.Dato);
//                    x = x.Previo;//apunta al nodo anterior a el
//          }
//    }
    
//    public Node ObtenerSig(){
//        return Siguiente;
//    }
//    
//    public String obtenerValor(){
//        return Dato;
//    }
}
