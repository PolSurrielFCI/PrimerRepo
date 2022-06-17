package test;

public class Alumno extends RegistroPersona{

    public int curso;
    public String[] asignaturasRepetidas;
    public float[] notas;

    Alumno (Alumno otroAlumno){
        this.curso = otroAlumno.curso;
        this.asignaturasRepetidas = otroAlumno.asignaturasRepetidas;
    }

    Alumno(){

    }

    public static void MostrarRequisitosAdmision(){
        System.out.println("blablabla");

    }


    public void cumplirCastigo(){
        int contador = 0;

        while(contador < 10){
            System.out.println("no volvere a faltar a clase de "+curso);
            contador++;
        }
    }


    @Override
    public void mostrarInformacionPublica() {
        System.out.println("Alumno con nombre: "+ nombre + "apellidos: " + apellidos);

    }
}
