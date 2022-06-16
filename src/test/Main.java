package test;

import java.util.Scanner;


public class Main {

    public static void main(String[] args){

        Admin.function1();

        Coche c = new Coche();
        c.acelerar();

        Coche.mostrarModelosExistentes();

        Admin a = new Admin();
        a.function2();

        Profesor pol = new Profesor();

        Alumno alex = new Alumno();
        alex.curso = 2;
        alex.notas = new float[]{ 3f,2f,1f,4f};

        pol.evaluar(alex);

        System.out.println(alex.curso);

    }

}

class Coche {

    float velocidadActual;
    float aceleracion;

    public void acelerar(){
        velocidadActual = velocidadActual + aceleracion;
    }

    public static void mostrarModelosExistentes(){
        System.out.println("tesla model 3, toyota noseque, etc...");
    }

}


