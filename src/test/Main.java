package test;


import java.io.File;  // Import the File class
import java.io.FileWriter;
import java.io.IOException;  // Import the IOException class to handle errors

import java.nio.file.Files;
import java.security.spec.ECField;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static Connection connect() {
        try {
            Class.forName("org.sqlite.JDBC");

        }catch (Exception e){
        }

        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:C:/Users/psurr/Documents/sqlite/chinook.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {

        }

        return conn;
    }

    static Connection conn;

    static void executeSQL(String sql){
        try{
            Statement stmt = stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
            System.out.println("sql statement executed");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public static ResultSet executeQuery(String sql){
        ResultSet rs = null;
        try {
            Statement stmt = stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            System.out.println("sql query executed");


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return rs;
    }

    public static void bdmain(){

        conn = connect();

        executeSQL("DROP TABLE person");
        executeSQL("DROP TABLE department");

        executeSQL("CREATE TABLE person (\n" +
                "    personID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                "    name TEXT NOT NULL\n" +
                ");");

        executeSQL("CREATE TABLE department (\n" +
                "    name TEXT NOT NULL PRIMARY KEY,\n" +
                "    leaderID INTEGER,\n" +
                "    FOREIGN KEY (leaderID) REFERENCES person(personID)\n" +
                ");");

        executeSQL("INSERT INTO person (name) VALUES (\"pepito\")");
        executeSQL("INSERT INTO person (name) VALUES (\"manolito\")");
        executeSQL("INSERT INTO person (name) VALUES (\"fernando\")");
        executeSQL("INSERT INTO person (name) VALUES (\"gustavo\")");

        executeSQL("INSERT INTO department (name) VALUES (\"contabilidad\")");
        executeSQL("INSERT INTO department (name, leaderID) VALUES (\"siestologia\", 2)");
        executeSQL("UPDATE department SET leaderID = 1 WHERE name = \"contabilidad\"");

        ResultSet rs = executeQuery("SELECT * FROM person");

        System.out.println("\n\n\n\n________________________________");
        System.out.println("Todos los empleados que hay en la base de datos:");
        try {
            while(rs.next()){
                System.out.println("nombre:"+rs.getString("name"));
                System.out.println("id:"+rs.getInt("personID"));
            }

        }catch (Exception e){
            System.out.println(e);
        }


        rs = executeQuery("SELECT * FROM department");

        System.out.println("\n\n\n\n________________________________");
        System.out.println("Todos los departamentos que hay en la base de datos:");
        try {
            while(rs.next()){
                System.out.println("nombre:"+rs.getString("name"));
                System.out.println("leader id:"+rs.getInt("leaderID"));
                ResultSet tmprs = executeQuery("SELECT name FROM person WHERE personID = "+rs.getInt("leaderID"));
                System.out.println("leader name:"+tmprs.getString("name"));

            }

        }catch (Exception e){
            System.out.println(e);
        }

        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String [] args) throws IOException{

        // Crear fichero
        String ruta = "hola.txt";
        File file = new File(ruta);
        if(!file.exists()){
            file.createNewFile();
        }

        // Escribir archivos
        FileWriter writer = new FileWriter(ruta, false);
//        writer.write("\necribiendo");
//        writer.write("\necribiendo");
//        writer.write("\necribiendo");
//        writer.write("\necribiendo");

        // Ejemplo escribir archivos
        ArrayList<Persona> arr = new ArrayList<>();
        arr.add(new Persona(0, "Pepito", "Gonzalez"));
        arr.add(new Persona(1, "Manuel", "FFFF"));
        arr.add(new Persona(2, "María", "SDDSFDFDFD"));
        arr.add(new Persona(3, "Berta", "SDSD"));


        int contador = 0;
        writer.write(arr.size()+"\n");
        while (contador < arr.size()){
            writer.write(arr.get(contador).id+"\n");
            writer.write(arr.get(contador).nom+"\n");
            writer.write(arr.get(contador).cognom+"\n");
            contador+=1;
        }
        writer.close();

        // LEER FICHEROS
        arr = new ArrayList<>();
        Scanner fileReader = new Scanner(file);

        int size = Integer.parseInt(fileReader.nextLine());
        contador = 0;
        while(contador < size){
            int id = Integer.parseInt(fileReader.nextLine());
            String name = fileReader.nextLine();
            String secondName = fileReader.nextLine();
            arr.add(new Persona(id, name, secondName));
            contador++;
        }
        fileReader.close();

        for ( Persona p: arr) {
            System.out.println(p.id);
            System.out.println(p.nom);
            System.out.println(p.cognom);
        }

        // ELIMINAR FICHEROS:
        Files.delete(file.toPath());

    }

    public static class Persona{
        int id;
        String nom;
        String cognom;

        Persona(int id, String nom, String cognom){
            this.id = id;
            this.nom = nom;
            this.cognom = cognom;
        }

    }



}



