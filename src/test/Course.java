package test;

import java.util.ArrayList;

public class Course {

    public int hours;
    public String name;

    Course(int hours, String name){
        this.hours = hours;
        this.name = name;
    }

    public static int calcularTotalHoras(ArrayList<Course> cursos){
        int sumatorio = 0;
        for (int i = 0; i < cursos.size(); i++) {
            sumatorio += cursos.get(i).hours;
        }
        return sumatorio;
    }

}
