package test;


import java.util.ArrayList;

public class Main {

    public static void showDBContent(){
        System.out.println("Personas:");
        ArrayList<Person> people = Person.getAllPersons();
        for (int i = 0; i < people.size(); i++){

            Person currentPerson = people.get(i);

            String output = currentPerson.name + " " + currentPerson.secondName + ", esta inscrita a los cursos de:\n";

            if(currentPerson.getInscriptionCount() == 0){
                output += currentPerson.name + " no tiene ninguna inscripcion.\n";

            }else {
                ArrayList<Course> cursos = currentPerson.getInscriptionsInfo();

                for (int j = 0; j < cursos.size(); j++) {
                    output += "   - "+cursos.get(j).name +" de "+cursos.get(j).hours + " horas.\n";
                }
                output += "Lo cual suma un total de "+Course.calcularTotalHoras(cursos)+" horas.\n";

            }

            System.out.println(output);
        }
    }

    public static void main(String [] args){
        DBManager.InitializeDB();

        // CONSULTAS
        showDBContent();

        DBManager.closeConnection();

    }




}