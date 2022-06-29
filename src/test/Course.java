package test;

import java.util.ArrayList;

public class Course {

    public int hours;
    public String name;

    Course(int hours, String name){
        this.hours = hours;
        this.name = name;
    }

    /**
     * Calculates the total hours of a collection of courses based in each course duration (the summation of all course duration).
     * @param cursos the collection of courses.
     * @return the summation of all course's duration
     */
    public static int calcularTotalHoras(ArrayList<Course> cursos){
        int sumatorio = 0;
        for (int i = 0; i < cursos.size(); i++) {
            sumatorio += cursos.get(i).hours;
        }
        return sumatorio;
    }

}
