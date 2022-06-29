package test;

import java.sql.ResultSet;
import java.util.ArrayList;

public class Person {

    String name;
    String secondName;
    int id;


    Person(String name, String secondName, int id ){
        this.name = name;
        this.secondName = secondName;
        this.id = id;

    }

    public int getInscriptionCount(){

        int numInscripciones = 0;
        try {

            ResultSet resultadoConsultaNumeroInscripciones = DBManager.executeQuery("SELECT COUNT(*) AS numInscripciones " +
                    "FROM inscriptions " +
                    "WHERE personID = " + id);

            if(resultadoConsultaNumeroInscripciones.next()){
                numInscripciones = resultadoConsultaNumeroInscripciones.getInt("numInscripciones");
            }
            resultadoConsultaNumeroInscripciones.close();

        }catch (Exception e){

        }

        return numInscripciones;
    }

    public static ArrayList<Person> getAllPersons(){
        ResultSet result = DBManager.executeQuery("SELECT * FROM person");

        ArrayList<Person> personas = new ArrayList<>();
        try {

            while(result.next()){
                personas.add(new Person(
                        result.getString("name"),
                        result.getString("secondName"),
                        result.getInt("personID")
                ));
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return personas;
    }

    public ArrayList<Course> getInscriptionsInfo(){

        ArrayList<Course> resultado = new ArrayList<>();

        try {

            ResultSet resultadoConsultaInscripciones = DBManager.executeQuery("SELECT courseName FROM inscriptions " +
                    "WHERE personID = " + id);

            while (resultadoConsultaInscripciones.next()) {
                String courseName = resultadoConsultaInscripciones.getString("courseName");
                ResultSet resultadoConsultaHoras = DBManager.executeQuery("SELECT hours FROM course WHERE name LIKE \"" + courseName + "\"");

                int horas = resultadoConsultaHoras.getInt("hours");

                resultado.add(new Course(horas, courseName));

                resultadoConsultaHoras.close();
            }
            resultadoConsultaInscripciones.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return resultado;
    }


}
