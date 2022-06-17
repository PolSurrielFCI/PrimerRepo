package test;

import java.util.Scanner;
public class Main {

    public static void main(String[] args){

        Figura f1 = new Pawn();
        Figura f2 = new Queen();

        System.out.println(f1.movementIsValid("ataca"));
        System.out.println(f2.movementIsValid("ataca"));
    }

}



