package wulfscottandersonprado_practican1;
import java.util.LinkedList;

/**
 * Autor Wulf Scott Anderson Prado
 * Universidad: Fidélitas
 * Curso: Estructura de Datos SC-304
 * Función de clase: Esta clase se encarga de gestionar la pila
 * No ejecuta ninguna ventana porque la gestión de ventanas es responsabilidad de la clase Menu.
 */
public class PilaVehiculos {
    // Se utiliza LinkedList para implementar la pila, según la rúbrica (Punto 3).
    private LinkedList<Vehiculo> vehiculos = new LinkedList<>();
    
    public void push(Vehiculo vehiculo){
        vehiculos.push(vehiculo);
    }
    public Vehiculo pop(){
        return vehiculos.pop();
    }
    public Vehiculo peek(){
        return vehiculos.peek();
    }
    public Vehiculo buscar(String placa){
        /*Busca un vehículo con base en una placa.
         *null devuelve null.
         *String que coincide devuelve el vehículo.
         *String que NO coincide devuelve null.
         */
        if (placa == null){ //Protección contra nulos
            return null;
        }
        placa = placa.toUpperCase();
        for (int i = 0; i<vehiculos.size(); i++){ //Busca el vehículo por placa
            if (vehiculos.get(i).getPlaca().equals(placa)){
                return vehiculos.get(i);
            } 
        }
        return null;
    }
    public String mostrarTodo(){
        /*Añade los resultados de los métodos toString() de 
         *todos los vehículos de la pila. Luego, el método 
         *devuelve la cadena "s".
         */
        String s="";
        for (int i = 0; i<vehiculos.size(); i++){
            s += (i+1)+"-"+vehiculos.get(i).toString()+"\n";
        }
        return s;
    }
    public boolean esVacia(){
        //Verifica si la pila está vacía
        if (vehiculos.size()==0){
            return true;
        } else {
            return false;
        }
    }
}
