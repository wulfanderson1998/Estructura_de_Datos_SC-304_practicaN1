# Estructura_de_Datos_SC-304_practicaN1
# Descripción

Las prácticas como estrategia didáctica constructivista promueven que las personas
estudiantes logren la construcción de conocimiento científico y alcancen el desarrollo de
competencias específicas, una mayor autonomía y participación, para que al ejecutarlas
aborden las dimensiones conceptuales, procedimentales y actitudinales del conocimiento.

Para esta actividad deberá aplicar conceptos de recursividad, estructuras de datos tipo pila
y POO para el desarrollo de una aplicación interactiva con ventanas de diálogo (JOptionPane),
que permita gestionar un conjunto de vehículos representados por sus placas.

Contexto. Sistema de parqueos inteligentes 

Se requiere diseñar un sistema en Java que permita registrar, mostrar y analizar una serie de
vehículos ingresados al parqueo, usando una estructura tipo pila, ya que los vehículos se
apilan en el orden en que llegan.

Además, cada placa será analizada letra por letra mediante recursividad para clasificar los
caracteres como vocales o consonantes.

Para ello, se solicita cumplir con los siguientes aspectos:

- POO: debe incluir al menos dos clases:
    - Vehiculo: con atributo placa (String) y métodos getPlaca(), toString().
    - PilaVehiculos: que utilice una pila dinámica (por ejemplo con ArrayList) y
    tenga métodos para push(), pop(), peek(), buscar(), mostrarTodo().
- Recursividad: implementar un método recursivo que reciba una placa y cuente la
cantidad de vocales y consonantes en la misma. Debe mostrar el resultado al usuario
al ingresar o buscar un vehículo.
- Interacción mediante ventanas: utilizar JOptionPane para mostrar un menú de
opciones:
    - Ingresar un nuevo vehículo
    - Sacar el vehículo que está al tope de la pila
    - Buscar un vehículo por placa
    - Mostrar todos los vehículos
    - Salir

En cada opción, mostrar mensajes amigables para guiar al usuario. 

Importante: no se permite el uso de librerías, clases o métodos que automaticen la lógica del
ejercicio, tales como Stack, TreeMap, split(), stream(), o cualquier API externa. Se evaluará la
implementación manual de estructuras de datos, recorridos y lógica condicional, como parte
del desarrollo de habilidades en programación estructurada y orientada a objetos.

# Instrucciones

- Individual
- Cumplir con la totalidad de los procedimientos
- Presentar el proyecto de NetBeans con la estructura de carpetas
- Incorporar POO, y ventanas de diálogo
- Entregar en formato .zip
- Nombrar la carpeta con el siguiente formato: Nombre completo_prácticaN1
