package ListaEnlazada;
import javax.swing.JOptionPane;

/* @author alejo*/
public class Principal {
    
    public static void main(String[] args) {
        ListaEnlazada lista = new ListaEnlazada();
        String dato;
        int opc, posicion;       
        do{
            opc = 0;
            try{
                
                opc = Integer.parseInt(JOptionPane.showInputDialog(
                         "----Libreria de Alejo----\n"
                       + "Menu de Opciones\n\n"
                       + "1.  Insertar un libro al inicio de la Lista\n"
                       + "2.  Insertar un libro al final de la Lista\n"
                       + "3.  ¿Donde quiere ingresar el libro?\n"
                       + "4.  Eliminar un libro\n"
                       + "5.  ¿Cuantos libros tiene la Libreria?\n"
                       + "6.  Mostrar contenido de la Libreria\n"
                       + "7.  ¿Que posicion quiere buscar?\n"
                       + "8.  ¿La Libreria esta vacia?\n"
                       + "9.  Vaciar Libreria\n"
                       + "10. Llevar libros (cortar lista)\n"
                       + "11. Salir.\n\n"
                       ));
                switch (opc) {
                    case 1:
                        dato = JOptionPane.showInputDialog(null,"Por favor ingresa el nombre del libro");
                        lista.addPrimero(dato);
                        break;
                        
                    case 2:
                        dato = JOptionPane.showInputDialog(null,"Por favor ingresa el nombre del libro");
                        lista.addUltimo(dato);
                        break;
                        
                    case 3:
                        if (!lista.listaVacia()){
                            lista.imprimirLista();
                            posicion = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Por favor ingresa la posicion en la que quiere guardar el libro"));
                            dato = JOptionPane.showInputDialog(null,"Por favor ingresa el nombre del libro");    
                            lista.addLugar(posicion, dato);
                        }else{
                            JOptionPane.showMessageDialog(null, "La Libreria esta vacia");
                        }
                        

                        break;
                        
                    case 4:
                        lista.imprimirLista();
                        posicion = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Por favor ingresa la posicion del libro a eliminar"));
                        JOptionPane.showMessageDialog(null, "Se ha eliminado un nodo con el valor: "
                                + lista.eliminarNodo(posicion));
                        break;
                        
                    case 5:
                        JOptionPane.showMessageDialog(null, "La Libreria contiene "+lista.size()+" libros.");                        
                        break;
                        
                    case 6:
                        if(lista.listaVacia()){
                            JOptionPane.showMessageDialog(null, "La Libreria esta vacia");
                        } else {
                            lista.imprimirLista();
                        }
                        break;
                        
                    case 7:
                        if (!lista.listaVacia()){
                            posicion = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Por favor ingresa la posicion del libro que busca"));
                            JOptionPane.showMessageDialog(null, "El Libro que busca es: "
                                    + lista.obtenerDato(posicion));
                        } else {
                            JOptionPane.showMessageDialog(null, "La Libreria esta vacia");
                        }
                        break;
                        
                    case 8:
                        if(lista.listaVacia()){
                            JOptionPane.showMessageDialog(null, "La Libreria esta vacia");
                        } else {
                            JOptionPane.showMessageDialog(null, "La Libreria NO esta vacia");
                        }
                        break;
                        
                    case 9:
                        if (!lista.listaVacia()){
                            lista.vaciarLista();
                            JOptionPane.showMessageDialog(null, "Se ha vaciado la Libreria correctamente");
                        } else {
                            JOptionPane.showMessageDialog(null, "La Libreria esta vacia");
                        }
                        break;    
                        
                    case 10:
                        if (!lista.listaVacia()){
                            posicion = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Por favor ingrese la cantidad de libros que se va a llevar(funcion cortar)"));
                            lista.cortarLista(posicion);
                            
                        } else {
                            JOptionPane.showMessageDialog(null, "La Libreria esta vacia");
                        }
                        break;
                        
                    case 11://ME FALTA
                        opc = 11;
                        break;    
                        
                    default:
                        JOptionPane.showMessageDialog(null, "Opción incorrecta, vuelve intentar nuevamente.");
                        break;
                }
            }catch(NumberFormatException e){
            
            }
        }while(opc != 11);//opc=11 para salir del loop        
    }
}
