package wulfscottandersonprado_practican1;
import javax.swing.JOptionPane;
/**
 * Autor Wulf Scott Anderson Prado
 * Universidad: Fidélitas
 * Curso: Estructura de Datos SC-304
 * Función de clase: Esta clase se encarga de gestionar la información de cada vehículo
 * No ejecuta ninguna ventana porque la gestión de ventanas es responsabilidad de la clase Menu.
 */
public class Vehiculo {
    private String placa; 
    private String color;
    private String modelo;
    //Constructor
    public Vehiculo(String placa, String color, String modelo) {
        this.placa = placa;
        this.color = color;
        this.modelo = modelo;
    }
    //Getters y Setters
    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    //toString() para mostrar datos del vehículo
    @Override
    public String toString() {
        return "El vehículo placa "+placa+" es de color "+color+" y es modelo "+modelo;
    }
    //Métodos para manipular información
    public int[] conteoVocalesConsonantes(String placa, int[] contador ){
        //Contador se define de esta manera: int[0] = vocales, int[1] = numeros, int[2] = consonantes, int[3] = número de iteracion.
        int vocales = 0; int numeros = 1; int consonantes = 2; int numeroIteracion = 3;
        if (contador[numeroIteracion]<(placa.length())){ //Condición de parada
            //El carácter evaluado corresponde a una vocal:
            if ((placa.charAt(contador[numeroIteracion]) == 'A')||(placa.charAt(contador[numeroIteracion]) == 'E')
                ||(placa.charAt(contador[numeroIteracion]) == 'I')||(placa.charAt(contador[numeroIteracion]) == 'O')
                ||(placa.charAt(contador[numeroIteracion]) == 'U')){
                    contador[vocales] ++; //Sumar Vocal
            //El carácter evaluado corresponde a un número:
            }else if((placa.charAt(contador[numeroIteracion]) == '1')||(placa.charAt(contador[numeroIteracion]) == '2')
                ||(placa.charAt(contador[numeroIteracion]) == '3')||(placa.charAt(contador[numeroIteracion]) == '4')
                ||(placa.charAt(contador[numeroIteracion]) == '5')||(placa.charAt(contador[numeroIteracion]) == '6')
                ||(placa.charAt(contador[numeroIteracion]) == '7')||(placa.charAt(contador[numeroIteracion]) == '8')
                ||(placa.charAt(contador[numeroIteracion]) == '9')||(placa.charAt(contador[numeroIteracion]) == '0')){
                    contador[numeros] ++; //Sumar Número
            //El carácter evaluado no corresponde a las condiciones anteriores
            }else{
                    contador[consonantes] ++;//Sumar Consonante
            }
            contador[numeroIteracion] ++;
            //La siguiente línea permite depurar cada iteración del método. 
            //JOptionPane.showMessageDialog(null, contador[vocales]+""+contador[numeros]+""+contador[consonantes]+"iteracion"+contador[numeroIteracion]);
            contador = conteoVocalesConsonantes(placa, contador);
        }
        return contador;
    }
}
