package test;

import java.sql.ResultSet;
import java.util.ArrayList;

public class Person {

    String name;
    String secondName;

    /**
     * id in the database
     */
    int id;


    Person(String name, String secondName, int id ){
        this.name = name;
        this.secondName = secondName;
        this.id = id;

    }

    /**
     * IMPORTANT: This function will only work if the Connection.conn has been initialized.
     *
     * @return the amout of inscriptions of this person.
     */
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

    /**
     * IMPORTANT: This function will only work if the Connection.conn has been initialized.
     *
     * @return an ArrayList with all the persons registered in the database.
     */
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

    /**
     * IMPORTANT: This function will only work if the Connection.conn has been initialized.
     *
     * @return an ArrayList with all the courses that this person is subscribed
     */
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


