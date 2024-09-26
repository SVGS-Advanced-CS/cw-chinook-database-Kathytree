package com.svgs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:./src/main/resources/chinook.db";
        try { 
            Connection conn = DriverManager.getConnection(url);
            Statement state = conn.createStatement();

            String query = "INSERT INTO employees(FirstName,LastName) VALUES('Sherri','Berry')";
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

    }
}