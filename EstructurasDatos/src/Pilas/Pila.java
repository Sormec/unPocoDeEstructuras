package Pilas;
import javax.swing.JOptionPane;
//@author alejo

public class Pila {
    
    Nodo UltimoNodoIngresado;
    int tamano = 0;
    String Lista = "";

    public Pila() {
        UltimoNodoIngresado = null;
        tamano = 0;
    }
    
    
    //Método para saber cuando la pila esta vacia
    public boolean PilaVacia() {
        return (UltimoNodoIngresado == null);//retorna true cuando cumple la condicion
    }
    
    //Método para insertar un nodo en la pila
    public void InsertarNodo(String URL) {
        Nodo nuevo_nodo = new Nodo(URL);
        nuevo_nodo.enlaceNodo = UltimoNodoIngresado;//enlaza con el nodo de ABAJO
        UltimoNodoIngresado = nuevo_nodo;
        tamano++;
    }
    
    //Método para eliminar un nodo de la pila
    public String EliminarNodo(){
        String auxiliar = UltimoNodoIngresado.URL;
        UltimoNodoIngresado = UltimoNodoIngresado.enlaceNodo;
        tamano--;
        return auxiliar;
    }
    
    //Método para vaciar la Pila
    public void VaciarPila(){
        while (!PilaVacia()){//loop hasta que la pila este vacia
            EliminarNodo();
        }        
    }
    
    //Método para mostrar el contenido de la pila
    public void MostrarValores(){
        Nodo recorrido = UltimoNodoIngresado;
        while(recorrido != null){
            //+= siginifica que es acumulador de Strings
            Lista += "|"+recorrido.URL+"|\n";//guarda la ultima URL y da enter
            recorrido = recorrido.enlaceNodo;
        }
        Lista += "----------------";
        JOptionPane.showMessageDialog(null, Lista);
        Lista = "";
    }
}
