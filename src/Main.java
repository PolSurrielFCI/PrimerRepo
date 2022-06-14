import java.util.Scanner;

public class Main {


    public static void main(String[] args){



    }

    public static void ejercicio14(){
        System.out.println("La función 1 se está ejecutando");
    }


    /*
    *
    * 14 Funciones 1
Haz una función que se ejecute desde la función principal y muestre el siguiente mensaje
por consola: “La función 1 se está ejecutando”

* 15 Funciones 2
Haz un programa que se ejecute desde la función principal y ejecuta 10 veces la función del
ejercicio 1
    *
    * */

    public static void ejercicio13(){
        int[] numeros = new int[] {1,4,5,11,20,45};

        int contador = 0;
        int contadorNumerosMenorQue10 = 0;
        while (contador < numeros.length){
            if(numeros[contador] < 10){
                contadorNumerosMenorQue10++;
            }
            contador++;
        }

        System.out.println(contadorNumerosMenorQue10);
    }

    /*
    * Haz un programa que pregunta un numero al usuario y:
        ● Muestra por consola si es un numero menor que 4
        ● Muestra por consola si es un numero menor que 10 Y mayor que 3
        ● Muestra por consola si es un numero positivo o negativo
        ● Muestra por consola si es 0
        ● Muestra por consola si es un número entre 10 y 20 O entre 30 y 40
        ● Muestra por consola si es un número entre 10 y 20 O entre 30 y 40 y si el numero
        dividido entre 2 cumple la misma condición
    * */
    public static void ejercicio12(){
        Scanner in = new Scanner(System.in);

        System.out.println("Escribe un numero y hare comprobaciones con el:");
        int respuesta = in.nextInt();


        if (respuesta < 4){
            System.out.println("Se cumple");
        }else {
            System.out.println("No se cumple");
        }


        if (respuesta < 10 && respuesta >3){
            System.out.println("Se cumple");
        }else {
            System.out.println("No se cumple");
        }


        if (respuesta < 0 ) {
            System.out.println("negativo");
        }else {
            System.out.println("positivo");
        }

        if (respuesta == 0){
            System.out.println("Se cumple");
        }else {
            System.out.println("No se cumple");
        }


        // 10 y 20 O entre 30 y 40
        if ((respuesta > 10 && respuesta < 20) || (respuesta > 30 && respuesta <40) ) {
            System.out.println("Se cumple");
        }else {
            System.out.println("No se cumple");
        }

        boolean range10To20 = respuesta > 10 && respuesta < 20;
        boolean range30To40 = respuesta > 30 && respuesta < 40;
        boolean halfIsInRange10To20 = respuesta/2 > 10 && respuesta/2 < 20;
        boolean halfIsInRange30To40 = respuesta/2 > 30 && respuesta/2 < 40;

        if((range10To20 || range30To40) && (halfIsInRange10To20 || halfIsInRange30To40)){
            System.out.println("Se cumple");

        }else {
            System.out.println("No se cumple");

        }

    }





    /*
    * Crea un programa que genera una array de enteros con los valores 1, 2, 3, 4, 5, 6, 7, 8,9, 10
    * Usa un while o for para mostrar los valores
    * */
    public static void ejercicioWhileAvanzado(){
        float[] arregloDeNumeros = new float[]{1f, 2f, 3f, 4f, 5f, 5.5f, 6f, 7f, 8f, 9f, 10f};

        int ultimoIndice = arregloDeNumeros.length - 1;

        int contador=0;
        while (contador < arregloDeNumeros.length / 2) {
            System.out.print(arregloDeNumeros[contador]+", ");
            System.out.print(arregloDeNumeros[ultimoIndice - contador]+", ");
            contador++;
        }

        if(arregloDeNumeros.length % 2 == 1){
            System.out.print(arregloDeNumeros[contador]+".");
        }

        /*
        * vez    contador     indexe
        * 1         0         ultimo (9)                 ultimoIndice - contador = 9
        * 2         1         penultimo(8)               ultimoIndice - contador = 8
        * 3         2         antepenultimo(7)           ultimoIndice - contador = 7
        * 4         3         ante-antepeunltimo (6)     ultimoIndice - contador = 6
        * 5         4         5                          ultimoIndice - contador = 5
        *
        * */
    }



    public static void ejercicio9() {
        Scanner in = new Scanner(System.in);
        String respuestaDelUsuario = "";

        while (!respuestaDelUsuario.equalsIgnoreCase("Hemos llegado")) {
            System.out.println("Falta mucho ?");
            respuestaDelUsuario = in.nextLine();
        }
    }



    /*
    Haz un programa que pregunte al usuario un número. Si el número que el usuario ha escrito
es 3, muestra por consola “Has adivinado el número!”. En cualquier otro caso, muestra: “Lo
siento, no has acertado!”
    * */
    public static void ejercicio7(){
        Scanner in = new Scanner(System.in);
        System.out.println("Dime un un numero y te diré si has adivinado");
        int preguntaNumero = in .nextInt();

        if (preguntaNumero == 3) {
            System.out.println( "Has adivinado el número!");
        }
        else {
            System.out.println("Lo siento, no has acertado!");
        }
    }



    /*
    * Haz un programa que pregunte 5 números al usuario y los guarde dentro de una array con
        capacidad máxima de 6 elementos*/
    public static void ejercicio6(){
        int [] primerEje6 = new int[6];

        Scanner in = new Scanner(System.in);
        System.out.println("Dime 5 numeros ");
        primerEje6 [0] = in.nextInt();
        primerEje6 [1] = in.nextInt();
        primerEje6 [2] = in.nextInt();
        primerEje6 [3] = in.nextInt();
        primerEje6 [4] = in.nextInt();

    }

    // Haz un programa que pregunte un número al usuario y lo muestre por consola.
    public static void ejercicio5(){
        Scanner lectorDeTeclado = new Scanner(System.in);
        System.out.println("Escribe un numero");
        int elNumero = lectorDeTeclado.nextInt();
        System.out.println(elNumero);
    }


    /*
    * Haz un programa que almacene en memoria RAM:
        ● Un arreglo de enteros con los valores: 3,2,1,0
        ● Un arreglo de string vacío con capacidad para almacenar 5 textos
        ● Una variable entera con el valor q
    * */
    public static void ejercicio4(){
        int[] enteros = new int[]{3, 2, 1, 0};
        String[] vacio = new String[5];
        int resultado3 = enteros[0];
    }

    public static void ejercicio3(double resultadoEjercicioAnterior){
        int variableInt = (int) resultadoEjercicioAnterior;
        float variableFloat = (float) resultadoEjercicioAnterior;
        String programarEsDivertido;
        programarEsDivertido = "Programar es divertido";
        String variableString = "ejemplo para hacerlo en 1 linea";
        boolean positivo = true;
    }



}


