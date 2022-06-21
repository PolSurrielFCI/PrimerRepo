import java.util.*;


public class Main {

    public static void main(String[] args){

        // Crear:
        LinkedList<Integer> list = new LinkedList<Integer>();
        ArrayList<Integer> array = new ArrayList<Integer>();

        // Anadir elemento:
        list.add(2); // Añadimos un 2 a la lista
        array.add(2); // Añadimos un 2 a la lista

        // Acceder por indice:
        System.out.println(list.get(0));
        System.out.println(array.get(0));

        // Eliminar el primer elemento:
        list.remove(0);
        array.remove(0);

        // Anadir varios elementos en una linea:
        list.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        array.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7));

        // Recorrer y mostrar valores:
        int count = 0;
        while (count < list.size()){
            System.out.println(list.get(count));
            count += 1;
        }

        count = 0;
        while (count < array.size()){
            System.out.println(array.get(count));
            count += 1;
        }

        // recorrer y mostrar con direcciones de memoria:
        Iterator it = list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        Iterator itarray = array.iterator();
        while(itarray.hasNext()){
            System.out.println(itarray.next());
        }

    }

}



