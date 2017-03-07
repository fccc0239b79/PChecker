/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pchecker;


import java.sql.Connection;
import java.sql.DriverManager;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import java.sql.SQLException;
/**
 *
 */
public class ServerControl {

        static int lport;
        static int rport;
        
        public static void connect(){
        
        String rUser = "up780016";
        String rPassword = "gregl33";
        String rHost = "35.187.14.195";
        try{
            JSch jsch = new JSch();
            Session session = jsch.getSession(rUser, rHost, 22);
            lport = 4321;
            rport = 3306;
            session.setPassword(rPassword);
            session.setConfig("StrictHostKeyChecking", "no");
            System.out.println("Establishing Connection...");
            session.connect(); 
            session.setPortForwardingL(lport, "localhost", rport);
            System.out.println("Connected");
            
             }catch(Exception e){
            System.err.print(e);
        }
        
        }
        
    public static Connection ConnectDB() {    //This method connects to the database and returns the connection.
       
          Connection DBconnection = null;
          String url = "jdbc:mysql://localhost:" + lport + "/PChecker";
          String dbUser = "root";
          String dbPasswd = "root";
          try{
            Class.forName("com.mysql.jdbc.Driver");
            DBconnection = DriverManager.getConnection(url, dbUser, dbPasswd);
            System.out.println("Connected to database successfully...");
            return DBconnection;
            }
          catch (Exception e){
            e.printStackTrace();
            return null;
          }       
    }
  
}