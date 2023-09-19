package Colas;
import javax.swing.JOptionPane;

public class Principal {

    public static void main(String[] args) {

        int opcion = 0;
        String nombre;
        Cola cola = new Cola();

        do {

            try {

                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                          "|| COLA DEL BANCO PICHINCHA||\n"
                        + "Menú de Opciones\n\n"
                        + "1. Insertar un nodo\n"
                        + "2. Extraer un nodo\n"
                        + "3. Mostrar contenido de la Cola\n"
                        + "4. Salir.\n\n"));

                switch (opcion) {
                    case 1:
                        nombre = JOptionPane.showInputDialog(null,
                                "Porfavor ingresa el nombre de la persona que va a hacer Cola.");
                        cola.add(nombre);
                        break;
                        
                    case 2:
                        if (!cola.colaVacia()) {
                            JOptionPane.showMessageDialog(null, "Se atendio a: " 
                                    + cola.extraer());
                        } else {
                            JOptionPane.showMessageDialog(null, "La Cola del Banco esta vacía");
                        }
                        break;
                        
                    case 3:
                        if (!cola.colaVacia()) {
                            cola.imprimirCola();                            
                        } else {
                            JOptionPane.showMessageDialog(null, "La Cola del Banco esta vacía");
                        }
                        break;
                    case 4:
                        opcion = 4;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no dispobible.");
                        break;
                }

            } catch (NumberFormatException e) {
            }

        } while (opcion != 4);
    }
}
