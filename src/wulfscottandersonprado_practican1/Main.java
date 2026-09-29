package wulfscottandersonprado_practican1;
import javax.swing.JOptionPane;
/**
 * Autor Wulf Scott Anderson Prado
 * Universidad: Fidélitas
 * Curso: Estructura de Datos SC-304
 * ---
 * Se siguen las siguientes instrucciones:
 * -Se utiliza "Java with ant" como se solicitó en el foro de la primera semana
 * -Todos los menús utilizan JOptionPane
 * -Se incorpora manejo de nulos, cadenas vacías, formatos incorrectos y protección contra errores de StackOverFlowError
 * ---
 * Se implementaron las siguientes clases:
 * -Menu: Esta clase se encarga de gestionar las ventanas del programa y de la interacción
 * con el usuario
 * -PilaVehiculos: Esta clase se encarga de gestionar los elementos de la pila
 * -Vehiculo: Gestiona los datos del vehículo y la función de contar vocales/consonantes(Recursiva). 
 */
public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.abrirMenuPrincipal();
    }
}
