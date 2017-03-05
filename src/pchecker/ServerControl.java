/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pchecker;

import java.sql.DriverManager;
import java.net.*;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 */
public class ServerControl {

    /**
     *
     * @return
     */
    public static Connection ServerControl() {    //This method connects to the database and returns the connection.

        try {
 
            String host = "jdbc:mysql://localhost:3306/PChecker";   //Location of mySQL server
            String userName = "root";    
            String userPass = "rootroot";
            Connection DBconnection = DriverManager.getConnection(host, userName, userPass);
            System.out.println("Connected to database successfully...");

            return DBconnection;
        } catch (SQLException err) {
            System.out.println(err.getMessage());   //Prints out SQL error if connection is not established
            return null;
        }
    }
    
    /**
     *
     * @param DBconnection
     */
    public void closeConnection(Connection DBconnection){
    //end of connection
        try{
        DBconnection.close();
        }catch(SQLException err){
        
        
        }
    
    }
}