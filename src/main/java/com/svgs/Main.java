package com.svgs;

import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    private static Connection conn;
    private static Statement state;
    public static void main(String[] args) {
        createDB();
        Scanner scan = new Scanner(System.in);
        System.out.println("1. Create a user");
        String choice = scan.nextLine();
        if(choice.equals("1"))
        {
            System.out.println("Username:");
            String username = scan.nextLine();
            System.out.println("Password:");
            String password = scan.nextLine();
            System.out.println("ROle:");
            String role = scan.nextLine();
            createUser(username,password,role);
        }
    }
    public static void menu(){

    }
    public static void createUser(String u, String p, String r)
    {
        
    }
    public static void createDB(){
        String url = "jdbc:sqlite:./src/main/resources/users.db";
        try{
            conn = DriverManager.getConnection(url);
            state = conn.createStatement();
            String query = "CREATE TABLE IF NOT EXIST users(userId TEXT, password TEXT, role TEXT)";
            state.executeUpdate(query);
        } catch (Exception e) {
            System.out.println("you effed up.");
        }

    }
       /*  String url = "jdbc:sqlite:./src/main/resources/users.db";
        try { 
            Connection conn = DriverManager.getConnection(url);
            Statement state = conn.createStatement();

            String query = "UPDATE employees SET FirstName = 'Garfield', LastName = 'Andrew' WHERE FirstName='Andrew' AND LastName='Adams'";
            state.executeUpdate(query);

            query = "DELETE FROM employees WHERE FirstName='Sherri'";
            System.out.println(state.executeUpdate(query));


            query = "SELECT * FROM employees ORDER BY LastName ASC";
            ResultSet results = state.executeQuery(query);
            while (results.next()) {
                String first = results.getString("FirstName");
                String last = results.getString("LastName");
                int employeeId = results.getInt("EmployeeID");
                System.out.println(employeeId + ":" + first + " " + last);
            }
            conn.close();
            
        } catch (SQLException e) {
            System.out.println("error :(");
        }

    }*/
}