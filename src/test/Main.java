package test;


import java.util.ArrayList;

public class Main {



    public static void main(String [] args){
        DBManager.InitializeDB();

        // CONSULTAS
        DBManager.showDBContent();

        DBManager.closeConnection();

    }




}