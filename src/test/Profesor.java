package test;

public class Profesor extends Empleado {

    public String[] asignaturas;

    public void impartirClase(Alumno[] asistentes){

    }

    public void renunciarAlSueldo(){
        sueldo = 0.0f;
    }

    public void evaluar(Alumno alumno){

        float promedio = 0f;
        int contador = 0;
        while(contador < alumno.notas.length){
            promedio = promedio + alumno.notas[contador];
            contador++;
        }

        promedio = promedio / (float) alumno.notas.length;

        if(promedio >= 4.5f){
            alumno.curso = alumno.curso + 1;
        }
    }

}
