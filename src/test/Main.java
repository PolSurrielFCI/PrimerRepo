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
            String url = "jdbc:sqlite:C:/Users/psurr/Documents/sqlite/midb.db";
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
            Statement stmt = conn.createStatement();
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
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            System.out.println("sql query executed");


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return rs;
    }

    public static void main(String [] args){

        conn = connect();

        executeSQL("DROP TABLE person");
        executeSQL("DROP TABLE department");

        executeSQL("CREATE TABLE person (\n" +
                "    personID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                "    name TEXT NOT NULL,\n" +
                "    secondName TEXT\n" +
                ");");

        executeSQL("CREATE TABLE department (\n" +
                "    name TEXT NOT NULL PRIMARY KEY,\n" +
                "    leaderID INTEGER,\n" +
                "    FOREIGN KEY (leaderID) REFERENCES person(personID)\n" +
                ");");

        // AÑADIR REGISTRO
        executeSQL("INSERT INTO person (name, secondName) VALUES (\"pepito\",\"gonzalez\")");
        executeSQL("INSERT INTO person (name, secondName) VALUES (\"manolito\",\"gonzalez\")");
        executeSQL("INSERT INTO person (name, secondName) VALUES (\"fernando\",\"gonzalez\")");
        executeSQL("INSERT INTO person (name, secondName) VALUES (\"gustavo\",\"gonzalez\")");

        executeSQL("INSERT INTO department (name) VALUES (\"contabilidad\")");
        executeSQL("INSERT INTO department (name, leaderID) VALUES (\"siestologia\", 2)");

        // MODIFICAR REGISTRO
        executeSQL("UPDATE department SET leaderID = 1 WHERE name = \"contabilidad\"");

        // ELIMINAR REGISTRO
        //executeSQL("DELETE * FROM person WHERE personID = 3");
        executeSQL("DELETE * FROM person WHERE name LIKE \"fernando\"");

        // CONSULTAS
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



}



