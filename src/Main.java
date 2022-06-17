public class Main {
    public static void main(String[]args)  {
        Figura a= new Rectangulo();
        a.calcularArea();
        //System.out.println(a);
        Figura b= new Triangulo(5.4f,6.5f,8.7f);
        b.calcularArea();
        System.out.println(b.calcularArea());

    }
}
