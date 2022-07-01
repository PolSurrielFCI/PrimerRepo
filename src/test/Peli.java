package test;

import java.io.Serializable;

public class Peli implements Serializable {

    String name;
    int duration;
    String description;
    double valoracion;

    Peli(String name, int dur, String des, double val){
        this.name = name;
        duration = dur;
        description = des;
        valoracion = val;
    }

}
