package wulfscottandersonprado_practican1;
import java.awt.Window;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 * Autor Wulf Scott Anderson Prado
 * Universidad: Fidélitas
 * Curso: Estructura de Datos SC-304
 * Función de clase: Esta clase se encarga de gestionar las ventanas del programa y de la interacción
 * con el usuario. 
 */
public class Menu {
    //Crear pila de vehículos
    private PilaVehiculos pilaVehiculos = new PilaVehiculos();
    //Menú principal **************************************************************
    /*Este método solo controla el menú principal y sus botones.
     *La lógica de cada opción se maneja con los métodos auxiliares.
     */
    public void abrirMenuPrincipal(){
        //Configuraciones de los botones (JButton).
        JButton btnPush = new JButton("Ingresar un nuevo vehículo");
        JButton btnPop = new JButton("Sacar el vehículo que está al tope de la pila");
        JButton btnBuscar = new JButton("Buscar un vehículo por placa");
        JButton btnMostrarElementosPila = new JButton("Mostrar todos los vehículos");
        JButton btnSalir = new JButton("Salir");
        //Acciones que realiza cada botón. Llaman los métodos auxiliares, más abajo.
        ejecutarAccionBoton(btnPush, this::ingresarDatosVehiculo);
        ejecutarAccionBoton(btnPop, this::sacarTopeDePila);
        ejecutarAccionBoton(btnBuscar, this::buscarVehiculo);
        ejecutarAccionBoton(btnMostrarElementosPila, this::mostrarElementosPila);
        ejecutarAccionBoton(btnSalir, this::cerrarPrograma);
        //Mostrar menú con JOptionPane según rúbrica (Punto 5).
        JOptionPane.showMessageDialog(null, new Object[]{
            "Seleccione una opción: ",
            btnPush,  
            btnPop,
            btnBuscar,
            btnMostrarElementosPila,
            btnSalir
            },
            "Menú Principal",
            JOptionPane.PLAIN_MESSAGE
        );               
    }
    //Acciones del menú principal ************************************************
    public void ingresarDatosVehiculo(){
        //Ventana que maneja PilaVehiculos.push() y gestiona la interacción con el usuario
        //EL USUARIO SOLO PUEDE INGRESAR LETRAS O NÚMEROS DE ACUERDO A LA
        //CONFIGURACIÓN DEL ENUM "TipoEntrada".
        String placa; 
        String color; 
        String modelo;
        int j; //Variable de control para mantener bucles
        //Solicitar datos:
        do { //Placa
            j = 0;
            placa = (entradaDatos("Ingrese la placa del vehículo: "))[0]; //Método para solicitar datos y evitar cadenas vacías.
            if (placa == null){ //Manejar nulos y botón de cancelar.
                JOptionPane.showMessageDialog(null, "Volviendo al menú principal");
                abrirMenuPrincipal();//Si hay nulos o se cancela, se vuelve al menú principal.
                return;
            }
            placa = placa.toUpperCase(); //Todas las placas usan mayús.
            if (verificarFormatoDeMensaje(placa, TipoEntrada.ALFANUMERICO)==null){ //Método para revisar formato del mensaje.
                JOptionPane.showMessageDialog(null, "Por favor, utilice únicamente letras y números");
                j = 1;
            }
            if (placa.length()>6){ //Controlar longitud máxima de placas en CR para evitar StackOverFlow error.
                JOptionPane.showMessageDialog(null, "La longitud máxima es de 6 caracteres");
                j = 1;
            }
        } while (j==1);
        do { //Color
            j = 0;
            color = (entradaDatos("Ingrese el color del vehículo: "))[0];
            if (color == null){
                JOptionPane.showMessageDialog(null, "Volviendo al menú principal");
                abrirMenuPrincipal();
                return;
            }
            if (verificarFormatoDeMensaje(color, TipoEntrada.LETRAS)==null){
                JOptionPane.showMessageDialog(null, "Por favor, utilice únicamente letras en su mensaje");
                j = 1;
            }
        } while (j==1);
             // Modelo
        //No se aplican restricciones de formato. Los modelos de vehículo incluyen caracteres especiales.
        modelo = (entradaDatos("Ingrese el modelo del vehículo: "))[0];
        if (modelo == null){
            JOptionPane.showMessageDialog(null, "Volviendo al menú principal");
            abrirMenuPrincipal();
            return;
        }
        //Nuevo objeto de tipo vehículo:
        Vehiculo vehiculo = new Vehiculo(
            placa, 
            color, 
            modelo
        );
        //Invocar método push.
        pilaVehiculos.push(vehiculo); 
        //Invocar ventana para contar vocales.
        ventanaMostrarVocalesConsontantes(vehiculo); 
        //Invocar ventana de menú principal.
        abrirMenuPrincipal(); 
    }
    public void sacarTopeDePila(){
        //Ventana que maneja PilaVehiculos.pop() y gestiona la interacción con el usuario.
        if (pilaVehiculos.esVacia()){ //Está vacío el parqueo.
            JOptionPane.showMessageDialog(null, "Esta operación no se puede realizar,"
                    + " porque el parqueo está vacío");
            abrirMenuPrincipal();
        } else { //El parqueo tiene vehículos.
            pilaVehiculos.pop(); //Se llama al método .pop() y se notifica al usuario.
            JOptionPane.showMessageDialog(null, "Operación exitosa, se extrajo el último vehículo en ingresar "
                    + "al parqueo");
            abrirMenuPrincipal();
        }
    }
    public void buscarVehiculo(){
        //Ventana que maneja PilaVehiculos.buscar() y gestiona la interacción con el usuario.
        Vehiculo vehiculo;
        vehiculo = pilaVehiculos.buscar( //Guarda el vehículo encontrado o un null.
            JOptionPane.showInputDialog(
            null,
            "Digite la placa del vehículo que desea buscar: "
            ));
        if (!(vehiculo == null)){ //Si es un vehículo
            JOptionPane.showMessageDialog(null, vehiculo.toString()); 
            ventanaMostrarVocalesConsontantes(vehiculo); //Invocar ventana para contar vocales.
            abrirMenuPrincipal(); //Invocar ventana de menú principal.
            } else {
                JOptionPane.showMessageDialog(null, "Vehículo no encontrado");
                abrirMenuPrincipal(); //Invocar ventana de menú principal.
        }
    }
    public void mostrarElementosPila(){
        //Ventana que maneja PilaVehiculos.mostrarTodo() y gestiona la interacción con el usuario.
        JOptionPane.showMessageDialog(
            null,
            "Lista de vehículos en el parqueo: \n"
            +pilaVehiculos.mostrarTodo());
        abrirMenuPrincipal();
    }
    public String[] entradaDatos(String mensaje){
        //Método que maneja cadenas vacías "".
        String[] informacion = new String[2];
        int respuesta = 0;
        int mensajeOriginal =1;
        informacion[mensajeOriginal] = mensaje;
        do { //Al usar este método, no se permiten cadenas vacías.
            informacion[respuesta] = JOptionPane.showInputDialog(
            null,
            mensaje);
            if (informacion[respuesta] == null){
                return informacion;
            }
        } while (informacion[respuesta].isEmpty()); 
        informacion[mensajeOriginal] = mensaje;
        return informacion; //Devuelve respuestas que no son null y el mensaje original.
    }
    /*El siguiente método se usa para solicitar información:
     *La opción ALFANUMÉRICO restringe a letras y números.
     *La opción LETRAS restringe solo a letras.
     *La opción NUMEROS restringe a solo números.
     *Devuelve NULL si el formato ingresado es incorrecto.
     */
    enum TipoEntrada{
        ALFANUMERICO,
        LETRAS,
        NUMEROS
    }
    public String verificarFormatoDeMensaje(String mensaje, TipoEntrada tipoEntrada){
        //Método para asegurarse de que el formato de una entrada es válido. 
        if (tipoEntrada == tipoEntrada.ALFANUMERICO){
            //Revisar formato del mensaje para mensaje de tipo alfanumérico
            for (int i = 0; i<mensaje.length(); i++){
                char caracter = mensaje.charAt(i);
                if ((!Character.isLetter(caracter))&&(!Character.isDigit(caracter))){
                    return null;
                }
            }
            return mensaje;
        } else if (tipoEntrada == tipoEntrada.NUMEROS){
            //Revisar formato del mensaje para mensaje numérico
            for (int i = 0; i<mensaje.length(); i++){
                char caracter = mensaje.charAt(i);
                if (!Character.isDigit(caracter)){
                    return null;
                }
            }
            return mensaje;
        } else if (tipoEntrada == tipoEntrada.LETRAS){
            //Revisar formato del mensaje para mensaje puramente alfabético
            for (int i = 0; i<mensaje.length(); i++){
                char caracter = mensaje.charAt(i);
                if (!Character.isLetter(caracter)){
                    return null;
                }
            }
            return mensaje;  
        }
        return mensaje;
    }
    public void ventanaMostrarVocalesConsontantes(Vehiculo vehiculo){
        //Muestra en ventana el resultado del método conteoVocalesConsonantes() de la clase vehículo.
        int[] contador = new int[4];//Contador vacío del método recursivo.
        int vocales = 0;
        int numeros = 1;
        int consonantes = 2;
        int numeroIteracion = 3;
        //Invocar método recursivo para contar vocales y consonantes según rúbrica (punto 4).
        contador = vehiculo.conteoVocalesConsonantes(vehiculo.getPlaca(), contador);
        JOptionPane.showMessageDialog(
                null,
                "La placa tiene "
                +contador[vocales]
                +" vocales y "
                +contador[consonantes]
                +" consonantes");
    }
    public void ejecutarAccionBoton(JButton nombreBoton, Runnable accion){
        //Ejecuta un método particular al pulsar un botón.
        nombreBoton.addActionListener(e ->{
            cerrarVentana(nombreBoton);
            accion.run();
        });
        ;
    }
        public void cerrarVentana(JButton nombreBoton){
        //Cierra una ventana de JOptionPane.
        Window ventana = SwingUtilities.getWindowAncestor(nombreBoton);
        ventana.dispose();
    }
        //Método vacío
        public void cerrarPrograma(){ 
        }
}
