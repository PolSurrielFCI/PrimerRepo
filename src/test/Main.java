package test;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Profesor pol = new Profesor();



        //hola

        Alumno alex = new Alumno();
        alex.curso = 2;
        alex.notas = new float[]{ 3f,2f,1f,4f};

        pol.evaluar(alex);

        System.out.println(alex.curso);

    }

}


