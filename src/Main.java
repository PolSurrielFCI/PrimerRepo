import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;


public class Main {

    public static void main(String[] args){

        LinkedList<Integer> list = new LinkedList<Integer>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        Iterator it = list.iterator();
        System.out.println(list.get(1));

        while (it.hasNext()){
            System.out.println(it.next());
        }



    }

    public static void ejemploArrayList(){
        ArrayList<Integer> arr = new ArrayList<Integer>();

        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);

        arr.remove(1);

        int contador = 0;
        while (contador < 100000){
            System.out.println("hola que tal");
            contador += 1;
        }
        System.out.println("He terminado");

    }

}



