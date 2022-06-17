package test;

public class Admin extends Empleado{

    public String cargo;

    @Override
    public void mostrarInformacionPublica() {
        System.out.println("Admin con nombre: "+ nombre + "apellidos: " + apellidos);

    }

    enum Cargos{
        Administrativo,
        Director,
        Informatico
    }

    public static void mostrarCargosExistentes() {
        System.out.println(Cargos.Administrativo.toString());
        System.out.println(Cargos.Director.toString());
        System.out.println(Cargos.Informatico.toString());
    }

    public float calcularFiniquito(){
        return sueldo/30f * diasTrabajados;
    }

    public static void function1(){

    }

    public void function2(){

    }
}
