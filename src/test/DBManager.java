package test;

import java.sql.*;

public class DBManager {
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

    public static void closeConnection(){
        try {
            if (DBManager.conn != null) {
                DBManager.conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void InitializeDB(){
        DBManager.conn = connect();

        DBManager.executeSQL("DROP TABLE person");
        DBManager.executeSQL("DROP TABLE course");
        DBManager.executeSQL("DROP TABLE inscriptions");

        DBManager.executeSQL("CREATE TABLE person (\n" +
                "    personID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                "    name TEXT NOT NULL,\n" +
                "    secondName TEXT NOT NULL\n" +
                ");");

        DBManager.executeSQL("CREATE TABLE course (\n" +
                "    name TEXT NOT NULL PRIMARY KEY,\n" +
                "    hours INTEGER NOT NULL\n" +
                ");");

        DBManager.executeSQL("CREATE TABLE inscriptions (\n" +
                "    personID INTEGER NOT NULL,\n" +
                "    courseName TEXT NOT NULL\n" +
                ");");


        // AÑADIR REGISTRO

        DBManager.executeSQL("INSERT INTO course (name, hours) VALUES (\"android\",300)");
        DBManager.executeSQL("INSERT INTO course (name, hours) VALUES (\"criptomonedas\",200)");
        DBManager.executeSQL("INSERT INTO course (name, hours) VALUES (\"desarrolloweb\",500)");

        DBManager.executeSQL("INSERT INTO person (name, secondName) VALUES (\"pepito\",\"gonzalez\")");
        DBManager.executeSQL("INSERT INTO person (name, secondName) VALUES (\"juan\",\"martinez\")");
        DBManager.executeSQL("INSERT INTO person (name, secondName) VALUES (\"miguel\",\"ortunyo\")");
        DBManager.executeSQL("INSERT INTO person (name, secondName) VALUES (\"rodolfo\",\"adolfo\")");

        DBManager.executeSQL("INSERT INTO inscriptions (personID, courseName) VALUES (1,\"android\")");
        DBManager.executeSQL("INSERT INTO inscriptions (personID, courseName) VALUES (1,\"desarrolloweb\")");
        DBManager.executeSQL("INSERT INTO inscriptions (personID, courseName) VALUES (2,\"criptomonedas\")");
        DBManager.executeSQL("INSERT INTO inscriptions (personID, courseName) VALUES (3,\"android\")");
        DBManager.executeSQL("INSERT INTO inscriptions (personID, courseName) VALUES (3,\"desarrolloweb\")");
        DBManager.executeSQL("INSERT INTO inscriptions (personID, courseName) VALUES (3,\"criptomonedas\")");

    }
    

    public static ResultSet executeQuery(String sql){
        ResultSet rs = null;
        try {
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return rs;
    }

}
